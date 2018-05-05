package br.com.sanatielbarros.appfeirapdm.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import br.com.sanatielbarros.appfeirapdm.R
import br.com.sanatielbarros.appfeirapdm.extensions.setupToolbar
import br.com.sanatielbarros.appfeirapdm.extensions.toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupToolbar(R.id.toolbar) //config a toolbar
        setupNavDrawer()
    }

    //configura o navigation drawer
    fun setupNavDrawer(){
        //componentes drawer_layout e toolbar foram recuperados pela Kotlin Extensions
        val toogle = ActionBarDrawerToggle(
                this,drawer_layout,toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close)

        drawer_layout.addDrawerListener(toogle)
        toogle.syncState()
        nav_view.setNavigationItemSelectedListener(this)

    }

    //trata evento de click no Navigation Drawer
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_item_frutas -> {
                toast("Frutas")
            }

            R.id.nav_item_verduras -> {
                toast("Verduras")
            }

            R.id.nav_item_graos -> {
                toast("Grãos")
            }

            R.id.nav_item_carnes -> {
                toast("Carnes")
            }

            R.id.nav_item_sobre -> {
                toast("Sobre")
            }
        }
        //fecha o menu depois de tratar o evento
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
