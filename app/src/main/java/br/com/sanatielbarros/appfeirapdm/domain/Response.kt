package br.com.sanatielbarros.appfeirapdm.domain

data class Response(val id:Long, val status: String, val msg: String, val url: String) {
    fun isOk() = "Ok".equals(status, ignoreCase = true)
}