package com.example.mobilodeviobs.Utils


import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import com.example.mobilodeviobs.R
import de.hdodenhof.circleimageview.CircleImageView

class CommonFunc {

    companion object{
       var auth: FirebaseAuth = FirebaseAuth.getInstance()
        var firestore: FirebaseFirestore = FirebaseFirestore.getInstance()

/*
           firestore.collection("chat_son_giris").document(auth.currentUser.uid)
                .collection("chat_son_giris").document(oda_id.toString())
                .update("date", Timestamp.now(),"guncel_mi",false)
 */
        fun toastMesaj(activity: FragmentActivity?, msg: String) {
            Toast.makeText(activity, "$msg", Toast.LENGTH_SHORT).show()
        }
        fun setProfilePhotoCircle(kullanici_Id: String?, setPP: CircleImageView) {
            firestore.collection("kullanicilar").document(kullanici_Id.toString()).get()
                .addOnSuccessListener {
                    if (it.exists()){
                        var kullanici_profil_resmi = it.getString("kullanici_profil_resmi")
                        UniversalImageLoader.setImage(kullanici_profil_resmi.toString(),setPP , null,null)
                    }
                }
        }

        fun setProfilePhotoCircleWithBGColor(
            kullanici_Id: String?,
            setPP: CircleImageView,
            context: Context,
            tvFirstCharacterChatOda: TextView
        ) {

            firestore.collection("kullanicilar").document(kullanici_Id.toString()).get()
                .addOnSuccessListener {
                    if (it != null){

                        var kullanici_profil_resmi = it.getString("kullanici_profil_resmi")
                        var kullanici_adi = it.getString("kullanici_adi")
                        var renk_sayisi = it.getLong("renk_sayisi")
                        if (kullanici_profil_resmi == ""){
                            if (renk_sayisi == 0L){
                                setPP.setBackgroundDrawable(
                                    ContextCompat.getDrawable(
                                        context,
                                        R.color.renk0
                                    )
                                )
                            }
                            if (renk_sayisi == 1L){
                                setPP.setBackgroundDrawable(
                                    ContextCompat.getDrawable(
                                        context,
                                        R.color.renk1
                                    )
                                )
                            }
                            if (renk_sayisi == 2L){
                                setPP.setBackgroundDrawable(
                                    ContextCompat.getDrawable(
                                        context,
                                        R.color.renk2
                                    )
                                )
                            }
                            if (renk_sayisi == 3L){
                                setPP.setBackgroundDrawable(
                                    ContextCompat.getDrawable(
                                        context,
                                        R.color.renk3
                                    )
                                )
                            }
                            if (renk_sayisi == 4L){
                                setPP.setBackgroundDrawable(
                                    ContextCompat.getDrawable(
                                        context,
                                        R.color.renk4
                                    )
                                )
                            }
                            if (renk_sayisi == 5L){
                                setPP.setBackgroundDrawable(
                                    ContextCompat.getDrawable(
                                        context,
                                        R.color.renk5
                                    )
                                )
                            }
                            if (renk_sayisi == 6L){
                                setPP.setBackgroundDrawable(
                                    ContextCompat.getDrawable(
                                        context,
                                        R.color.renk6
                                    )
                                )
                            }
                            if (renk_sayisi == 7L){
                                setPP.setBackgroundDrawable(
                                    ContextCompat.getDrawable(
                                        context,
                                        R.color.renk7
                                    )
                                )
                            }
                            if (renk_sayisi == 8L){
                                setPP.setBackgroundDrawable(
                                    ContextCompat.getDrawable(
                                        context,
                                        R.color.renk8
                                    )
                                )
                            }
                            if (renk_sayisi == 9L){
                                setPP.setBackgroundDrawable(
                                    ContextCompat.getDrawable(
                                        context,
                                        R.color.renk9
                                    )
                                )
                            }
                            if (renk_sayisi == 10L){
                                setPP.setBackgroundDrawable(
                                    ContextCompat.getDrawable(
                                        context,
                                        R.color.renk10
                                    )
                                )
                            }
                            if (renk_sayisi == 11L){
                                setPP.setBackgroundDrawable(
                                    ContextCompat.getDrawable(
                                        context,
                                        R.color.renk11
                                    )
                                )
                            }
                            if (renk_sayisi == 12L){
                                setPP.setBackgroundDrawable(
                                    ContextCompat.getDrawable(
                                        context,
                                        R.color.renk12
                                    )
                                )
                            }
                            if (renk_sayisi == 13L){
                                setPP.setBackgroundDrawable(
                                    ContextCompat.getDrawable(
                                        context,
                                        R.color.renk13
                                    )
                                )
                            }
                            if (renk_sayisi == 14L){
                                setPP.setBackgroundDrawable(
                                    ContextCompat.getDrawable(
                                        context,
                                        R.color.renk14
                                    )
                                )
                            }
                            if (renk_sayisi == 15L){
                                setPP.setBackgroundDrawable(
                                    ContextCompat.getDrawable(
                                        context,
                                        R.color.renk15
                                    )
                                )
                            }
                            if (renk_sayisi == 16L){
                                setPP.setBackgroundDrawable(
                                    ContextCompat.getDrawable(
                                        context,
                                        R.color.renk16
                                    )
                                )
                            }
                            if (renk_sayisi == 17L){
                                setPP.setBackgroundDrawable(
                                    ContextCompat.getDrawable(
                                        context,
                                        R.color.renk17
                                    )
                                )
                            }
                            if (renk_sayisi == 18L){
                                setPP.setBackgroundDrawable(
                                    ContextCompat.getDrawable(
                                        context,
                                        R.color.renk18
                                    )
                                )
                            }
                            if (renk_sayisi == 19L){
                                setPP.setBackgroundDrawable(
                                    ContextCompat.getDrawable(
                                        context,
                                        R.color.renk19
                                    )
                                )
                            }
                            if (renk_sayisi == 20L){
                                setPP.setBackgroundDrawable(
                                    ContextCompat.getDrawable(
                                        context,
                                        R.color.renk20
                                    )
                                )
                            }


                            tvFirstCharacterChatOda.visibility = View.VISIBLE
                            tvFirstCharacterChatOda.text = kullanici_adi!!.first().toUpperCase().toString()
                        }else{
                            tvFirstCharacterChatOda.visibility = View.GONE
                            UniversalImageLoader.setImage(kullanici_profil_resmi.toString(),setPP , null,null)
                        }

                    }
                }
        }
        fun bringPhotofromFB(kullanici_Id: String?, setPP: ImageView) {
            firestore.collection("kullanicilar").document(kullanici_Id.toString()).get()
                .addOnSuccessListener {
                    if (it.exists()){
                        var kullanici_profil_resmi = it.getString("kullanici_profil_resmi")
                        UniversalImageLoader.setImage(kullanici_profil_resmi.toString(),setPP , null,null)
                    }
                }
        }

        fun vipUyeGoster( kullanici_id: String?, gelen_foto: ImageView) {
            firestore.collection("kullanicilar").document(kullanici_id.toString()).get()
                .addOnSuccessListener {
                    if (it != null) {
                        var vip_uye = it.get("vip_uye") as Boolean

                        if (vip_uye == true) {
                            gelen_foto.visibility = View.VISIBLE
                        }else{
                            gelen_foto.visibility = View.GONE
                        }
                    }
                }
        }
        fun kullaniciAdi( kullanici_id: String?, gelen_text: TextView) {
            firestore.collection("kullanicilar").document(kullanici_id.toString()).get()
                .addOnSuccessListener {
                    if (it != null) {
                        var kullanici_adi = it.get("kullanici_adi")

                      gelen_text.text = kullanici_adi.toString()
                    }
                }
        }

        fun kullaniciDataArttir(kullanici_Id: String?,dataArttir: String?){
            firestore.collection("kullanicilar").document(kullanici_Id.toString())
                .update(dataArttir.toString(),FieldValue.increment(1))
        }
        fun kullaniciDataAzalt(kullanici_Id: String?,dataArttir: String?){
            firestore.collection("kullanicilar").document(kullanici_Id.toString())
                .update(dataArttir.toString(),FieldValue.increment(-1))
        }








    }
}