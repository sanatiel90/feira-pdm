package br.com.sanatielbarros.appfeirapdm.activities

import android.content.Context
import android.support.v7.app.AppCompatActivity

/**
 * Created by Sanatiel on 04/05/2018.
 */
//class base para todas as outras activities
open class BaseActivity : AppCompatActivity() {

    protected val context: Context get() = this

}