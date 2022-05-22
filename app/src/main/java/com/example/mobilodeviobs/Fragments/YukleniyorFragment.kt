package com.example.mobilodeviobs.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.mobilodeviobs.R


class YukleniyorFragment : DialogFragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      var view=inflater.inflate(R.layout.fragment_yukleniyor, container, false)
        // dialog fr ye radius eklemek için kullandım
        getDialog()?.getWindow()?.setBackgroundDrawableResource(R.drawable.dialog_design)

        return view
    }

 
}