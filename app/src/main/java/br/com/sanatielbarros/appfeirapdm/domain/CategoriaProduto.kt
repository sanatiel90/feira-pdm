package br.com.sanatielbarros.appfeirapdm.domain

import br.com.sanatielbarros.appfeirapdm.R

/**
 * Created by Sanatiel on 05/05/2018.
 */
//enum com os tipos de produtos do app feira
enum class CategoriaProduto(val string: Int) {
    frutas(R.string.frutas),
    verduras(R.string.verduras),
    graos(R.string.graos),
    carnes(R.string.carnes)
}