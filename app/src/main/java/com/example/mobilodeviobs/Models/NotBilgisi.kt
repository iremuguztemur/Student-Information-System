package com.example.mobilodeviobs.Models

class NotBilgisi {
    var ogretmen_adi : String? = null
    var ogrenci_no : String? = null
    var ogrenci_adi : String? = null
    var ders_kodu : String? = null
    var ders_adi : String? = null
    var sinav_tipi : String? = null
    var sinav_notu : Int? = null

    constructor()
    constructor(
        ogretmen_adi: String?,
        ogrenci_no: String?,
        ogrenci_adi: String?,
        ders_kodu: String?,
        ders_adi: String?,
        sinav_tipi: String?,
        sinav_notu: Int?
    ) {
        this.ogretmen_adi = ogretmen_adi
        this.ogrenci_no = ogrenci_no
        this.ogrenci_adi = ogrenci_adi
        this.ders_kodu = ders_kodu
        this.ders_adi = ders_adi
        this.sinav_tipi = sinav_tipi
        this.sinav_notu = sinav_notu
    }

    override fun toString(): String {

        return "NotBilgisi(ogretmen_adi=$ogretmen_adi, ogrenci_no=$ogrenci_no, ogrenci_adi=$ogrenci_adi, ders_kodu=$ders_kodu, ders_adi=$ders_adi, sinav_tipi=$sinav_tipi, sinav_notu=$sinav_notu)"
    }

}