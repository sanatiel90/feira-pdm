package br.com.sanatielbarros.appfeirapdm.extensions

import android.app.Activity
import android.support.annotation.IdRes
import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.Toast

/**
 * Created by Sanatiel on 04/05/2018.
 */
//mostra toast
fun Activity.toast(message:CharSequence, length: Int = Toast.LENGTH_SHORT) = Toast.makeText(this,message,length).show()

//mostra toast
fun Activity.toast(@StringRes message: Int, length: Int = Toast.LENGTH_SHORT) = Toast.makeText(this,message,length).show()

//evento click; essa extensao vai add um evento de cliq a uma view qualquer, sem que precise ficar chamando findViewById para recuperar o componente
fun Activity.onClick(@IdRes viewId:Int, onClick:(v:android.view.View?) -> Unit){
    val view = findViewById<View>(viewId)
    view.setOnClickListener{ onClick(it) }
}

//configura a toolbar
fun AppCompatActivity.setupToolbar(@IdRes id:Int, title: String? = null, upNavigation: Boolean = false): ActionBar {
    val toolbar = findViewById<Toolbar>(id) //cria instancia de toolbar de acordo com uma toolbar informada por id
    setSupportActionBar(toolbar)
    //se titulo tiver sido informado, substituir
    if(title != null){
        supportActionBar?.title = title
    }
    //informa se vai mostrar up navigation ou nao
    supportActionBar?.setDisplayHomeAsUpEnabled(upNavigation)
    return supportActionBar!! //retorna msm correndo o risco de estar nulo
}

//adiciona fragment ao layout
fun AppCompatActivity.addFragment(@IdRes layoutId:Int, fragment: Fragment) {
    fragment.arguments = intent.extras //recebendo eventuais paramentros enviados
    val ft = supportFragmentManager.beginTransaction()
    ft.add(layoutId, fragment)
    ft.commit()
}
