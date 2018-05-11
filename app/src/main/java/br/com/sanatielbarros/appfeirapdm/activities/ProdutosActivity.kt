package br.com.sanatielbarros.appfeirapdm.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.sanatielbarros.appfeirapdm.R
import br.com.sanatielbarros.appfeirapdm.domain.CategoriaProduto
import br.com.sanatielbarros.appfeirapdm.extensions.addFragment
import br.com.sanatielbarros.appfeirapdm.extensions.setupToolbar
import br.com.sanatielbarros.appfeirapdm.fragments.ProdutosFragment
import kotlinx.android.synthetic.main.activity_produtos.*
import kotlinx.android.synthetic.main.fragment_produtos.*

class ProdutosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produtos)

        //recebendo a cat do produto enviado pela MainAct
        val categoria = intent.getSerializableExtra("categoria") as CategoriaProduto
        //pegando a string presente em categoia para informar como titulo
        val title = getString(categoria.string)

        setupToolbar(R.id.toolbar, title, true)

        if(savedInstanceState == null){
          //  addFragment(R.id.containerProdutosTipo, ProdutosFragment())
            val ft = supportFragmentManager.beginTransaction()
            val fragProdutos = ProdutosFragment()
            fragProdutos.arguments = intent.extras
            ft.add(R.id.layoutFragmentTipo, fragProdutos, "ProdutosFragment")
            ft.commit()
        }


    }
}
