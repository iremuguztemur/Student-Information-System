package com.example.mobilodeviobs.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.google.firebase.auth.FirebaseAuth
import com.example.mobilodeviobs.Login.WelcomeActivity

import com.example.mobilodeviobs.R
import kotlinx.android.synthetic.main.fragment_cikis_yap.view.*


class CikisYapFragment : DialogFragment() {

    lateinit var auth : FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

      var view=inflater.inflate(R.layout.fragment_cikis_yap, container, false)
        // dialog fr ye radius ekleme
        getDialog()?.getWindow()?.setBackgroundDrawableResource(R.drawable.dialog_design)

        auth = FirebaseAuth.getInstance()
        view.tvEvet.setOnClickListener {

            auth.signOut()
            val intent = Intent(context, WelcomeActivity::class.java)
            startActivity(intent)
            activity?.finish()

        }
        view.tvIptal.setOnClickListener {
            dismiss()

        }
        return view

    }


}