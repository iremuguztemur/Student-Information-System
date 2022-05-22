package com.example.mobilodeviobs.Models

import com.google.firebase.Timestamp

class KullaniciBilgileri {

    var kullanici_adi : String? = null
    var kullanici_no : String? = null
    var kullanici_id : String? = null
    var kullanici_profil_resmi : String? = null
    var kullanici_seviye : Int? = null
    var email : String? = null

    constructor()
    constructor(
        kullanici_adi: String?,
        kullanici_no: String?,
        kullanici_id: String?,
        kullanici_profil_resmi: String?,
        kullanici_seviye: Int?,
        email: String?
    ) {
        this.kullanici_adi = kullanici_adi
        this.kullanici_no = kullanici_no
        this.kullanici_id = kullanici_id
        this.kullanici_profil_resmi = kullanici_profil_resmi
        this.kullanici_seviye = kullanici_seviye
        this.email = email
    }

    override fun toString(): String {
        return "KullaniciBilgileri(kullanici_adi=$kullanici_adi, kullanici_no=$kullanici_no, kullanici_id=$kullanici_id, kullanici_profil_resmi=$kullanici_profil_resmi, kullanici_seviye=$kullanici_seviye, email=$email)"
    }

}