package com.example.mobilodeviobs.inventory;

import com.example.mobilodeviobs.R;
import java.util.ArrayList;
import java.util.List;

public class Data {

    public static List<Universiteler> getFruitList() {
        List<Universiteler> universitelerList = new ArrayList<>();

        Universiteler Agu = new Universiteler();
        Agu.setName("ABDULLAH GÜL ÜNİVERSİTESİ - AGU");
        Agu.setImage(R.drawable.agu_circle);
        universitelerList.add(Agu);

        Universiteler Atu = new Universiteler();
        Atu.setName("ADANA ALPARSLAN TÜRKEŞ BİLİM VE TEKNOLOJİ ÜNİVERSİTESİ - ATÜ");
        Atu.setImage(R.drawable.atu_circle);
        universitelerList.add(Atu);

        Universiteler Adyu = new Universiteler();
        Adyu.setName("ADIYAMAN ÜNİVERSİTESİ - ADYÜ");
        Adyu.setImage(R.drawable.adyu_circle);
        universitelerList.add(Adyu);

        Universiteler Aku = new Universiteler();
        Aku.setName("AFYON KOCATEPE ÜNİVERSİTESİ - AKÜ");
        Aku.setImage(R.drawable.aku_circle);
        universitelerList.add(Aku);

        Universiteler Afsu = new Universiteler();
        Afsu.setName("AFYONKARAHİSAR SAĞLIK BİLİMLERİ ÜNİVERSİTESİ - AFSÜ");
        Afsu.setImage(R.drawable.afsu_circle);
        universitelerList.add(Afsu);

        Universiteler Aicu = new Universiteler();
        Aicu.setName("AĞRI İBRAHİM ÇEÇEN ÜNİVERSİTESİ - AİÇÜ");
        Aicu.setImage(R.drawable.aicu_circle);
        universitelerList.add(Aicu);

        Universiteler Asu = new Universiteler();
        Asu.setName("AKSARAY ÜNİVERSİTESİ - ASÜ");
        Asu.setImage(R.drawable.asu_circle);
        universitelerList.add(Asu);

        Universiteler Alku = new Universiteler();
        Alku.setName("ALANYA ALAADDİN KEYKUBAT ÜNİVERSİTESİ - ALKÜ");
        Alku.setImage(R.drawable.alku_circle);
        universitelerList.add(Alku);

        Universiteler Anau = new Universiteler();
        Anau.setName("ANADOLU ÜNİVERSİTESİ - ANAÜ");
        Anau.setImage(R.drawable.anau_circle);
        universitelerList.add(Anau);


        Universiteler Ahbvu = new Universiteler();
        Ahbvu.setName("ANKARA HACI BAYRAM VELİ ÜNİVERSİTESİ - AHBVÜ");
        Ahbvu.setImage(R.drawable.ahbu_circle);
        universitelerList.add(Ahbvu);



        return universitelerList;
    }

}
