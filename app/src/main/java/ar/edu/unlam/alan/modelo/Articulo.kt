package modelo

import com.google.gson.annotations.SerializedName

//data class genera gettes y setteres de los atributtos que ponga
//@SerializedName es una anotacion para indicar que ese atrbuto es el que va a llega en
//en json
data class Articulo (
    @SerializedName("title") val titulo: String,
    val id: String,
    @SerializedName("original_price") val precioOriginal: String,
    @SerializedName("price") val precioDescuento: String,
    @SerializedName("sold_quantity") val vendidos: String,
    @SerializedName("seller_id") val vendedorId: Int,
    @SerializedName("pictures") val imagenesProducto: List<ImagenProducto>,
    @SerializedName("thumbnail") val urlImagen: String,
    @SerializedName("seller") val usuario: Usuario)
