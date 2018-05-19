package br.com.sanatielbarros.appfeirapdm.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.sanatielbarros.appfeirapdm.R
import br.com.sanatielbarros.appfeirapdm.extensions.setupToolbar

class AddProductActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_product)

        setupToolbar(R.id.toolbar, "Cadastrar Novo Produto",true)
    }
}
