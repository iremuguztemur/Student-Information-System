package com.example.mobilodeviobs

import android.content.Context
import android.content.Intent
import android.os.Build
import android.text.Html
import android.text.Spanned
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.Timestamp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import com.example.mobilodeviobs.Models.NotBilgisi
import kotlinx.android.synthetic.main.tek_satir_ders.view.*
import org.json.JSONException
import org.json.JSONObject
import java.util.*

class TumNotlarRecycler(var tumPostlar: ArrayList<NotBilgisi>, var context: Context) :
    RecyclerView.Adapter<TumNotlarRecycler.TumPostlarHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TumPostlarHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.tek_satir_ders, parent, false)
        return TumPostlarHolder(view)
    }

    override fun onBindViewHolder(holder: TumPostlarHolder, position: Int) {
        holder.setDataFromFb(tumPostlar.get(position), context)
        holder.setIsRecyclable(false)



    }

    override fun getItemCount(): Int {
        return tumPostlar.size


    }

    inner class TumPostlarHolder(view: View) : RecyclerView.ViewHolder(view) {

        var tumLayout = view as ConstraintLayout

        var tvDersKodu = tumLayout.tvDersKodu
        var tvOgrenmenAdi = tumLayout.tvOgrenmenAdi
        var tvDersinAdi = tumLayout.tvDersinAdi
        var tvOgrenciNo = tumLayout.tvOgrenciNo
        var tvOgrenciAdi = tumLayout.tvOgrenciAdi
        var tvVizeArtiNot = tumLayout.tvVizeArtiNot


        var contextmy = tumLayout.context


        fun setDataFromFb(
            model: NotBilgisi,
            context: Context,
        ) {

            tvDersKodu.text = model.ders_kodu
            tvOgrenmenAdi.text = model.ogretmen_adi
            tvDersinAdi.text = model.ders_adi
            tvOgrenciNo.text = model.ogrenci_no
            tvOgrenciAdi.text = model.ogrenci_adi
            tvVizeArtiNot.text = model.sinav_tipi.toString() + "\n" + model.sinav_notu

        }


    }


}