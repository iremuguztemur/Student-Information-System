package com.example.mobilodeviobs.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentActivity
import com.google.firebase.auth.FirebaseAuth

import com.example.mobilodeviobs.R
import com.example.mobilodeviobs.Utils.CommonFunc
import kotlinx.android.synthetic.main.fragment_sifremi_unuttum.*
import kotlinx.android.synthetic.main.fragment_sifremi_unuttum.view.*


class SifremiUnuttumFragment : DialogFragment() {

    lateinit var mContext: FragmentActivity
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view=inflater.inflate(R.layout.fragment_sifremi_unuttum, container, false)

        mContext= activity!!

        // dialog fr ye radius eklemek için kullandım
        getDialog()?.getWindow()?.setBackgroundDrawableResource(R.drawable.dialog_design)
        
        view.btnSifreyiTekrarGonder.setOnClickListener {

           // Toast.makeText(mContext, "gönder buton tıklandı", Toast.LENGTH_SHORT).show()


            if ( view.etSifreyiTekrarGonderEmail.text.toString() != ""){
                view.progressBarSifremiUnuttum.visibility = View.VISIBLE
                FirebaseAuth.getInstance().sendPasswordResetEmail(etSifreyiTekrarGonderEmail.text.toString())
                    .addOnCompleteListener {
                        if (it.isSuccessful){
                            view.progressBarSifremiUnuttum.visibility = View.GONE
                            CommonFunc.toastMesaj(activity,"Sıfırlama maili gönderildi!"
                            )
                            dialog?.dismiss()
                        }else{
                            view.progressBarSifremiUnuttum.visibility = View.GONE
                            Toast.makeText(mContext, "Error!", Toast.LENGTH_SHORT).show()
                        }
                    }
            }else{
                Toast.makeText(activity, "Boş alanları doldurun!" ,Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }

}