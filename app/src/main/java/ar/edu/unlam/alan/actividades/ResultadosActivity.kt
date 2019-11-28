package ar.edu.unlam.alan.actividades

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
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

        var gridLayoutManager =  GridLayoutManager(this, 2)
        recycler.layoutManager = gridLayoutManager

        val adapter = AdaptadorDeArticulos()
        recycler.adapter = adapter


        val nombreProducto = intent.extras?.getString("texto") as String

        API().search(nombreProducto, object: retrofit2.Callback<SearchResult> {
            override fun onFailure(call: Call<SearchResult>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<SearchResult>, response: Response<SearchResult>) {

                if (response.isSuccessful) {

                    val search = response.body()?.articulos

                    adapter.articulos = search as ArrayList<Articulo>
                    adapter.notifyDataSetChanged()

                }
            }

        })



    }

}


/*
RESULTADOS VIEJO
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <Button android:id="@+id/verResultado"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="IR AL DETALLE DEL PRIMER RESULTADO"
        android:layout_centerInParent="true"/>

</RelativeLayout>*/