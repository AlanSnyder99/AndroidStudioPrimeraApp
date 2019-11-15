package ar.edu.unlam.alan.actividades

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import ar.edu.unlam.alan.R
import ar.edu.unlam.alan.api.API
import kotlinx.android.synthetic.main.activity_resultados.*
import modelo.Articulo
import modelo.SearchResult
import retrofit2.Call
import retrofit2.Response

class ResultadosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultados)


        val nombreProducto = intent.extras?.getString("texto") as String

        API().search(nombreProducto, object: retrofit2.Callback<SearchResult> {
            override fun onFailure(call: Call<SearchResult>, t: Throwable) {
                // Si falla...
            }

            override fun onResponse(call: Call<SearchResult>, response: Response<SearchResult>) {

                if (response.isSuccessful) {

                    val resultado = response.body()?.articulos!!

                    verResultado.setOnClickListener {

                        val intent = Intent(applicationContext, ProductoActivity::class.java)
                        intent.putExtra("id",resultado[0].id)
                        startActivity(intent)
                    }

                }

                RecyclerView

            }

        })



    }

}