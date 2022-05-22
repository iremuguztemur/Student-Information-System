package com.example.mobilodeviobs.Login

import android.Manifest
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Spinner
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.google.common.collect.Maps
import com.google.firebase.Timestamp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.rpc.context.AttributeContext

import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.DexterError
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.PermissionRequestErrorListener
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import com.example.mobilodeviobs.CustomSpinner
import com.example.mobilodeviobs.Fragments.SifremiUnuttumFragment
import com.example.mobilodeviobs.Fragments.YukleniyorFragment
import com.example.mobilodeviobs.MainActivity
import com.example.mobilodeviobs.Models.KullaniciBilgileri
import com.example.mobilodeviobs.R
import com.example.mobilodeviobs.UniversitelerAdapter
import com.example.mobilodeviobs.Utils.CommonFunc
import com.example.mobilodeviobs.inventory.Data
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity() {


    lateinit var auth: FirebaseAuth
    lateinit var firestore: FirebaseFirestore

    var dialog : Fragment? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        auth = FirebaseAuth.getInstance()
        firestore = FirebaseFirestore.getInstance()

//  auth null değilse direkt main'e atıyor
        var currentUser = auth.currentUser
        if (currentUser != null) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        tvGirisYapLogin.setOnClickListener {



            imageViewAnimatedChange(this,bg_login_main,R.drawable.images,1)



            // imgLoginLogo.visibility = View.VISIBLE
        }
        tvKaydolLogin.setOnClickListener {


            imageViewAnimatedChange(this, bg_login_main, R.drawable.indir, 2)



        }

btnKaydolLogin.setOnClickListener {
    dialog = YukleniyorFragment()

    (dialog as YukleniyorFragment).show(this.supportFragmentManager, "YukleniyorFragment")
    (dialog as YukleniyorFragment).isCancelable = false

    kaydol(tvEmailKaydol.text.toString().trim(),tvSifreKayitFR.text.toString().trim())
}

        btnGirisYapGirisFR.setOnClickListener {
            //   progressBarGirisYap.visibility = View.VISIBLE
            var kullanici_email = tvEmailGirisFR.text.toString().toLowerCase()
            var kullanici_sifre = tvSifreGirisFR.text.toString()

            dialog = YukleniyorFragment()

            (dialog as YukleniyorFragment).show(this.supportFragmentManager, "YukleniyorFragment")
            (dialog as YukleniyorFragment).isCancelable = false
            if (kullanici_email.isNotEmpty() && kullanici_sifre.isNotEmpty()) {

                auth.signInWithEmailAndPassword(kullanici_email, kullanici_sifre)
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            startActivity(
                                Intent(this, MainActivity::class.java)
                                    .addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                            )
                            finish()
                        }
                    }.addOnFailureListener {
                        //   progressBarGirisYap.visibility = View.GONE
                        CommonFunc.toastMesaj(this,  "Bilgilerinizi kontrol edin.")
                        (dialog as YukleniyorFragment).dismiss()
                    }
            }else{
                (dialog as YukleniyorFragment).dismiss()
                CommonFunc.toastMesaj(this,  "Boş alanları doldurun.")
            }
        }



    }


    fun imageViewAnimatedChange(c: Context?, v: ConstraintLayout, loginBgPoipa: Int, i: Int) {
        val anim_out: Animation = AnimationUtils.loadAnimation(c, android.R.anim.fade_out)
        val anim_in: Animation = AnimationUtils.loadAnimation(c, android.R.anim.fade_in)
        anim_out.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {}
            override fun onAnimationRepeat(animation: Animation) {}
            override fun onAnimationEnd(animation: Animation) {
                bg_login_main.setBackgroundResource(loginBgPoipa)
                if (i == 1){
                    consGirisYap.visibility = View.VISIBLE
                    consKaydol.visibility = View.GONE

                    btn_register_bg.setBackgroundResource(R.drawable.btn_register_poipa)
                    btn_login_bg.setBackgroundResource(R.drawable.btn_login_poipa)
                }else{
                    consGirisYap.visibility = View.GONE
                    consKaydol.visibility = View.VISIBLE

                    btn_register_bg.setBackgroundResource(R.drawable.btn_login_poipa)
                    btn_login_bg.setBackgroundResource(R.drawable.btn_register_poipa)

                }
                anim_in.setAnimationListener(object : Animation.AnimationListener {
                    override fun onAnimationStart(animation: Animation) {}
                    override fun onAnimationRepeat(animation: Animation) {}
                    override fun onAnimationEnd(animation: Animation) {}
                })
                v.startAnimation(anim_in)
            }
        })
        v.startAnimation(anim_out)
    }




    private fun kaydol(kullanici_email: String, kullanici_sifre: String) {

        if (isValidEmail(kullanici_email)) {
            auth.createUserWithEmailAndPassword(kullanici_email, kullanici_sifre)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                      verileriFBYukle()
                    }
                }.addOnFailureListener {
                    CommonFunc.toastMesaj(this, "Error!")
                    (dialog as YukleniyorFragment).dismiss()
                }
        } else {

            CommonFunc.toastMesaj(this, "Geçerli bir mail adresi girin!")
            (dialog as YukleniyorFragment).dismiss()

        }

    }



    private fun verileriFBYukle() {
        var kullanici_adi = tvKullaniciAdiKayitFr.text.toString().toLowerCase().trim()
        var kullanici_mail = tvEmailKaydol.text.toString().toLowerCase().trim()
        var kullanici_no = user_no.text.toString().toLowerCase().trim()
        var kullanici_id = auth.currentUser?.uid


        var kullanicilar = KullaniciBilgileri(
            kullanici_adi,
            kullanici_no,
            kullanici_id,
            "",
            0,
            kullanici_mail)

        auth.currentUser?.let {
            firestore.collection("kullanicilar")
                .document(it.uid).set(kullanicilar)
                .addOnCompleteListener {
                    if (it.isSuccessful) {


                        startActivity(Intent(this, MainActivity::class.java))
                        finish()
                    } else {
                        Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show()
                    }
                }
        }




    }




    fun isValidEmail(kontrol: String): Boolean {
        if (kontrol == null) {
            return false
        } else {

            return android.util.Patterns.EMAIL_ADDRESS.matcher(kontrol)
                .matches() // mail olup olmadığını kontrol ediyor

        }
    }


}