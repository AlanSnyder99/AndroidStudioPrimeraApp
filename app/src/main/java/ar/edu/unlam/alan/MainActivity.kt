package ar.edu.unlam.alan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Boton manda el texto a otra vista
        botonBuscar.setOnClickListener {

            val textoIngresado = campoDeBusqueda.text.toString()

            //A que vista redirijo, es un mensaje entre componentes de la app, sirve tanto para lanzar una view como para pasar parametros
            val intent = Intent(this, ProductoActivity::class.java)

            //mando a la otra pantalla el texto ingresado
            intent.putExtra("texto",textoIngresado)

            startActivity(intent)
        }
//crear activity_resultado con 3 resultados con 3 IDs que redirija a producto_activity
    }
}
