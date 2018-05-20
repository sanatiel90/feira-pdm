package br.com.sanatielbarros.appfeirapdm.utils

import android.util.Log
import okhttp3.*
import java.io.IOException

/**
 * Created by Sanatiel on 06/05/2018.
 */
//classe que usa lib okhttp para fazer requisicoes
object HttpHelper {

    private val TAG = "http"
    private val LOG_ON = true
    //define o tipo de arquivo e o encode
    val JSON = MediaType.parse("application/json; charset=utf-8")
    //instancia de okhttp
    val client = OkHttpClient()

    //GET
    fun get(url: String): String{
        log("HttpHelper.get: $url")
        //cria uma requisicao GET
        val request = Request.Builder().url(url).get().build()
        //faz a req GET e retorna o json de resposta
        return getJson(request)
    }

    //POST
    fun post(url: String, json: String): String {
        log("HttpHelper.post: $url > $json")
        val body = RequestBody.create(JSON, json)
        val request = Request.Builder().url(url).post(body).build()
        return getJson(request)
    }

    //POST com parâmetros(form-urlencoded)
    fun postForm(url: String, params: Map<String, String>): String {
        log("HttpHelper.postForm: $url > $params")
        val builder = FormBody.Builder()
        for ((key, value) in params) {
            builder.add(key, value)
        }
        val body = builder.build()
        val request = Request.Builder().url(url).post(body).build()
        return getJson(request)
    }



    //faz a requisicao e lê a resposta do servidor em formato json
    fun getJson(request: Request?): String{
        //faz a req e retorna a resposta
        val response = client.newCall(request).execute()
        //pega o body da resposta
        val responseBody = response.body()
        if(responseBody != null){
            //json com o corpo da resposta
            val json = responseBody.string()
            log("  << : $json")
            return json
        }
        throw IOException("Erro ao fazer requisição")

    }


    private fun log(s: String){
        if(LOG_ON){
            Log.d(TAG,s)
        }
    }


}