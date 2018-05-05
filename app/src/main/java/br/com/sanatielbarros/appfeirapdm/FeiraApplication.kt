package br.com.sanatielbarros.appfeirapdm

import android.app.Application
import android.util.Log

/**
 * Created by Sanatiel on 04/05/2018.
 */
class FeiraApplication : Application(){
    private val TAG = "FeiraApplication"

    //chamado quando Android criar o processo da aplicacao
    override fun onCreate() {
        super.onCreate()
        //salva instancia para termos acesso como Singleton
        appInstance = this
    }

    //companion object usado para criar metodos estaticos
    companion object {
        //Singleton da class Application
        private var appInstance: FeiraApplication? = null
        fun getInstance(): FeiraApplication{
            if(appInstance == null){
                throw IllegalStateException("Configura a classe application no AndroidManifest.xml")
            }
           return appInstance!!
        }
    }

    //chamado quando Android finalizar o processo da aplicacao
    override fun onTerminate() {
        super.onTerminate()
        Log.d(TAG, "FeiraApplication.onTerminate()")
    }


}