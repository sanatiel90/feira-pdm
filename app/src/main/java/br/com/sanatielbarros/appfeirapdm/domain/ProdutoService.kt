package br.com.sanatielbarros.appfeirapdm.domain

import android.util.Log
import br.com.sanatielbarros.appfeirapdm.extensions.fromJson
import br.com.sanatielbarros.appfeirapdm.utils.HttpHelper

/**
 * Created by Sanatiel on 06/05/2018.
 */
//class que vai fazer requisicao à API
object ProdutoService {
    private val TAG = "feira"

    //endpoint base da API a ser acessada
    private val BASE_URL = "https://web-service-pdm.herokuapp.com/api/v1"

    fun getProdutos(categoria: CategoriaProduto): List<Produto>{
        Log.d(TAG, "CATEGORIA PARAM: "+categoria.name)

        val url: String

        if(categoria.name.equals("todas")){
            //pegando todos os produtos ordenados por data de cadastro descendente (últimos produtos cadastrados)
            url = "$BASE_URL/products?order=created_at,desc"

        }else{
            //se for informado uma categoria, pegar so os produtos da categoria
            url = "$BASE_URL/products?where[categoria]=${categoria.name}"
        }

            Log.d(TAG, url)

            //json com o resultado da requisicao (a classe HttpHelper faz as requisicoes usando a lib okhttp)
            val json = HttpHelper.get(url)
            //transforma o json num List<Produto>
            val produtos = fromJson<List<Produto>>(json)
            Log.d(TAG,"${produtos.size} produtos encontrados")
            return produtos
    }


}