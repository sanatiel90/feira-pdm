package br.com.sanatielbarros.appfeirapdm.activities.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.app.DialogFragment
import android.os.Bundle
import android.app.FragmentManager
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import br.com.sanatielbarros.appfeirapdm.R
import kotlinx.android.synthetic.main.dialog_about.*

import org.jetbrains.anko.AlertBuilder
import java.util.zip.Inflater

/**
 * Created by Sanatiel on 12/05/2018.
 */
class AboutDialog : DialogFragment(){

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builderDialog = AlertDialog.Builder(activity)
        val inflater = LayoutInflater.from(activity)
        val view = inflater.inflate(R.layout.dialog_about, null)
        val bt = view.findViewById<Button>(R.id.btSobreOk)
        bt.setOnClickListener {
            dialog.dismiss()
        }
        builderDialog.setView(view)
        /*builderDialog.setPositiveButton(R.string.ok){
            dialog, whichButton -> dialog.dismiss()
        }*/
        return builderDialog.create()

    }


    /*companion object {
        fun showAbout(fm: FragmentManager){
            val ft = fm.beginTransaction()
            val prev = fm.findFragmentByTag("about_dialog")
            if(prev != null){
                ft.remove(prev)
            }
            ft.addToBackStack(null)
            AboutDialog().show(ft, "about_dialog")
        }
    }*/

}