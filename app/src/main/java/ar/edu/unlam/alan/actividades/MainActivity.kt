package ar.edu.unlam.alan.actividades

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ar.edu.unlam.alan.R
import kotlinx.android.synthetic.main.activity_main.*
import java.net.NetworkInterface

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (!isNetworkAvailable()){
            error.text = "ERROR DE CONCECCION"
        } else{
            //Boton manda el texto a otra vista
            botonBuscar.setOnClickListener {

                val textoIngresado = campoDeBusqueda.text.toString()

                //A que vista redirijo, es un mensaje entre componentes de la app, sirve tanto para lanzar una view como para pasar parametros
                val intent = Intent(this, ResultadosActivity::class.java)

                //mando a la otra pantalla el texto ingresado
                intent.putExtra("texto",textoIngresado)

                startActivity(intent)
            }
        }

    }

    private fun isNetworkAvailable(): Boolean{

    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE)
        return if(connectivityManager is ConnectivityManager){
            val networkInfo = connectivityManager.activeNetworkInfo
            networkInfo.isConnected
        } else false

    }

}
