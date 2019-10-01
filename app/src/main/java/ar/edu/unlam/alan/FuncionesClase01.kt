package ar.edu.unlam.alan

/*Funcion sumar*/

fun Sum(a:int, b:int):int{
    return a+b
}

/*O hacer la funcion de la siguiente manera*/

fun Sum2(a:int, b:int)= a+b

/*Variables*/

var numero = 1

/*Constante (No se puede cambiar)*/
val numeroNoCambianete = 1


fun obtenerMayor(a:Int, b:Int)= if (a<b) a else b

val obtenerElMayor = obtenerMayor(a:1,b:2)

/*Recorrer listas*/

val familia = listOf("alan","sol","derek")

for (nombres in familia){
println("hola, ${nombres}")
}

/*CLASES*/

class MiClase

fun ejemplo(){
    val miObjeto = MiClase()
}

class Persona(var nombre : String)

fun crearPersona(){
    val Alan = Persona(nombre = "Alan")
}

/*CONEXIONES Y LISTAS, INTERFACES, ENUMERADOS, DATA CLASES, SEALED CLASES, MAP() FILTER(), LET() APLAY()*/

/*KOTLING LANG  DEVELOPER.ANDOID.COM*/