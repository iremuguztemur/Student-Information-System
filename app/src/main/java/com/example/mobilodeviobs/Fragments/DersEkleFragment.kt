package com.example.mobilodeviobs.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.example.mobilodeviobs.MainActivity
import com.example.mobilodeviobs.Models.NotBilgisi
import com.example.mobilodeviobs.R
import kotlinx.android.synthetic.main.fragment_ders_ekle.*
import kotlinx.android.synthetic.main.fragment_ders_ekle.view.*


class DersEkleFragment : DialogFragment() {

    lateinit var auth: FirebaseAuth
    lateinit var firestore: FirebaseFirestore
    var sinav_turu = "Vize"
    var dialog : Fragment? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_ders_ekle, container, false)
        getDialog()?.getWindow()?.setBackgroundDrawableResource(R.drawable.dialog_design)

        auth = FirebaseAuth.getInstance()
        firestore = FirebaseFirestore.getInstance()

        view.radioVize.setOnCheckedChangeListener{ radio, b ->
            if(b){
                sinav_turu = "vize"
            }
        }
        view.radioFinal.setOnCheckedChangeListener{ radio, b ->
            if(b){
                sinav_turu = "final"
            }
        }
        view.btn_ekle.setOnClickListener {
            dersNotunuEkle(view)

    view.progressBar.visibility = View.VISIBLE

        }
        return view
    }

    private fun dersNotunuEkle(view: View) {
        firestore.collection("kullanicilar").document(auth.currentUser?.uid.toString())

            .get().addOnSuccessListener {
                if(it.exists()){
                    var ogretmen_adi = it.getString("kullanici_adi")
                    firestore.collection("dersler").document(view.etDersKodu.text.toString().trim())

                        .get().addOnSuccessListener {
                            if(it.exists()){
                                var dersin_adi = it.getString("dersin_adi")




                                firestore.collection("kullanicilar").get()
                                    .addOnSuccessListener {
                                        if (it != null){
                                            var document = it.documents
                                            for (doc in document) {
                                                var gelen_no = doc.getString("kullanici_no")

                                                if(view.et_ogrenci_no.text.toString().trim() == gelen_no){
                                                  var ogrenci_no = doc.getString("kullanici_adi")
                                                  var ogrenci_id = doc.getString("kullanici_id")

                                                    var notBilgisi = NotBilgisi(
                                                        ogretmen_adi,
                                                        view.et_ogrenci_no.text.toString().trim(),
                                                        ogrenci_no,
                                                        view.etDersKodu.text.toString().trim(),
                                                        dersin_adi,
                                                        sinav_turu,
                                                        view.et_sinav_notu.text.toString().trim().toInt())

                                                    firestore.collection("ders_notu").document(ogrenci_id.toString())
                                                        .collection("ders_notu").document()
                                                        .set(notBilgisi)
                                                        .addOnCompleteListener {

                                                            if (it.isSuccessful){
                                                                dismiss()
                                                                Toast.makeText(
                                                                    activity,
                                                                    "Sınav notu eklendi!",
                                                                    Toast.LENGTH_SHORT
                                                                ).show()
                                                            }
                                                            if (view.et_sinav_notu.text.toString().trim().toInt() < 50){
                                                                dismiss()
                                                                Toast.makeText(
                                                                    activity,
                                                                    "Sınav notu dusuk!",
                                                                    Toast.LENGTH_SHORT
                                                                ).show()
                                                            }



                                                        }

                                                }

                                            }
                                        }
                                    }

                            }
                        }
                }
            }

    }


}