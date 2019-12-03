package ar.edu.unlam.alan.actividades

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ar.edu.unlam.alan.api.API
import ar.edu.unlam.alan.R
import retrofit2.Call
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_producto.*
import modelo.Articulo
import modelo.Usuario
import retrofit2.Response

class ProductoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_producto)


        val idProducto = intent.extras?.getString("idProducto")

        Picasso.get()
            .load(R.drawable.card)
            .into(tarjetaImg)

        Picasso.get()
            .load(R.drawable.truck)
            .into(camion)

        API().getArticle(idProducto.toString(), object: retrofit2.Callback<Articulo>{

           override fun onFailure(call: Call<Articulo>, t: Throwable) {
//              //
           }

            override fun onResponse(call: Call<Articulo>, response: Response<Articulo>) {

                if (response.isSuccessful) {
                    val producto = response.body()
                    Picasso.get()
                        .load(producto?.imagenesProducto?.first()?.url)
                        .into(imagenProducto)

                    cantidadFotos.text = producto?.imagenesProducto?.size.toString() + "fotos"
                    precio.text =  "$" + producto?.precioDescuento
                    titulo.text = producto?.titulo

                    API().getVendedor(producto?.vendedorId.toString(), object:retrofit2.Callback<Usuario>{
                        override fun onFailure(call: Call<Usuario>, t: Throwable) {
                            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                        }
                        override fun onResponse(call: Call<Usuario>, response: Response<Usuario>) {
                            if(response.isSuccessful){
                                var usuario = response.body();
                                nombreVendedor.text = usuario?.nickname
                            }
                        }
                })

            }

        }

    })
}
}
