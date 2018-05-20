package br.com.sanatielbarros.appfeirapdm.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.sanatielbarros.appfeirapdm.R
import br.com.sanatielbarros.appfeirapdm.domain.Produto
import br.com.sanatielbarros.appfeirapdm.extensions.setupToolbar

class AddProductActivity : AppCompatActivity() {

    val produto:Produto? by lazy { intent.getParcelableExtra<Produto>("produto") }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_product)

        setupToolbar(R.id.toolbar, "Cadastrar Novo Produto",true)
    }
}
