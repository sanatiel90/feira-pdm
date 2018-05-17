package br.com.sanatielbarros.appfeirapdm.activities

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import br.com.sanatielbarros.appfeirapdm.R
import br.com.sanatielbarros.appfeirapdm.domain.Produto
import br.com.sanatielbarros.appfeirapdm.extensions.setupToolbar
import br.com.sanatielbarros.appfeirapdm.extensions.toast
import kotlinx.android.synthetic.main.activity_produto_detalhe_contents.*

class ProdutoDetalheActivity : BaseActivity() {

    /*
     * recuperando o produto enviado pelo ProdutosFragment através de intent.getParcelableExtra<ClasseDoObj>("nome_parametro")
     *
     * a notacao by lazy faz com que o obj seja carregado na memoria apenas quando necessario
     */
    val produto by lazy { intent.getParcelableExtra<Produto>("produto") }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produto_detalhe)

        setupToolbar(R.id.toolbar,produto.nome,true)
        initViews()
    }

    private fun initViews(){
        txtPreco.text = "Preço: "+produto.preco
        txtLocal.text = "Local: ${produto.local}"
        txtData.text = "Data: ${produto.created_at}"
        txtCategoria.text = "Categoria: ${produto.categoria}"
    }

    //criando menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_form_detalhe, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            R.id.menu_editar -> {
                toast("Editar produto")
            }
            R.id.menu_deletar -> {
                toast("Deletar produto")
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
