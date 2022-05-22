package com.example.mobilodeviobs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.example.mobilodeviobs.Fragments.CikisYapFragment
import com.example.mobilodeviobs.Fragments.DersEkleFragment
import com.example.mobilodeviobs.Models.NotBilgisi
import com.example.mobilodeviobs.inventory.Data
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var dialog: Fragment? = null
    lateinit var auth: FirebaseAuth
    lateinit var firestore: FirebaseFirestore
    lateinit var tumNotlarArray: ArrayList<NotBilgisi>
    private var adapter: TumNotlarRecycler? = null
    var ogrenci_no = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()
        firestore = FirebaseFirestore.getInstance()
        tumNotlarArray = ArrayList<NotBilgisi>()
        fabAdd.setOnClickListener {
            dialog = DersEkleFragment()
            (dialog as DersEkleFragment).show(this.supportFragmentManager, "DersEkleFragment")
        }

        ic_cikisyap.setOnClickListener {
            dialog = CikisYapFragment()
            (dialog as CikisYapFragment).show(this.supportFragmentManager, "CikisYapFragment")
        }

        verileriGetir()


        tumNotlariGetir()


        var recyclerview = recTumNotlar
        adapter = TumNotlarRecycler(tumNotlarArray, this)
        recyclerview.adapter = adapter
        recyclerview.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerview.setHasFixedSize(true)
        recyclerview.getRecycledViewPool().setMaxRecycledViews(0, 0)

    }

    private fun verileriGetir() {
        firestore.collection("kullanicilar").document(auth.currentUser?.uid.toString())
            .addSnapshotListener { snap, err ->
                if (err != null) {

                } else {
                    if (snap!!.exists()) {
                        var kullanici_seviye = snap.getLong("kullanici_seviye")
                        ogrenci_no = snap.getString("kullanici_no").toString()
                        if (kullanici_seviye!! >= 1) {
                            fabAdd.visibility = View.VISIBLE
                        } else {
                            fabAdd.visibility = View.GONE

                        }

                    }
                }
            }
    }

    private fun tumNotlariGetir() {
        var notBilgisiOgrenci: NotBilgisi? = null
        firestore.collection("ders_notu").document(auth.currentUser?.uid.toString())
            .collection("ders_notu").orderBy("ders_adi", Query.Direction.DESCENDING)
            .addSnapshotListener { snap, err ->
                if (err != null){

                }
                if (snap != null) {
                    tumNotlarArray.clear()
                    val documents = snap.documents
                    for (doc in documents) {

                        notBilgisiOgrenci = doc.toObject(NotBilgisi::class.java)
                        tumNotlarArray.add(notBilgisiOgrenci!!)


                        adapter!!.notifyDataSetChanged()

                    }
                }
            }
    }
}