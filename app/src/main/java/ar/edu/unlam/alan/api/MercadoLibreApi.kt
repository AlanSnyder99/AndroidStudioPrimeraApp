package ar.edu.unlam.alan.api

import modelo.Articulo
import modelo.Usuario
import modelo.SearchResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MercadoLibreAPI {

    @GET("items/{itemId}")
    fun getArticle(@Path("itemId") id: String): Call<Articulo>

    @GET("sites/MLA/search")
    fun search(@Query("q") query: String): Call<SearchResult>

    @GET ("users/{idUsuario}")
    fun getVendedor(@Path("idUsuario") id: String) : Call<Usuario>
}