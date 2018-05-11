package br.com.sanatielbarros.appfeirapdm.activities

import android.os.Bundle
import br.com.sanatielbarros.appfeirapdm.R
import br.com.sanatielbarros.appfeirapdm.domain.Produto
import br.com.sanatielbarros.appfeirapdm.extensions.setupToolbar
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
        txtPreco.text = "Preço: R$ "+produto.preco.toString()
        txtLocal.text = "Local: ${produto.local}"
        txtData.text = "Data: ${produto.created_at}"
        txtCategoria.text = "Categoria: ${produto.categoria}"
    }
}
