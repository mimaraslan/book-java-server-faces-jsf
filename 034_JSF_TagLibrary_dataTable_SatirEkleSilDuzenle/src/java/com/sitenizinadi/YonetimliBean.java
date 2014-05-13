package com.sitenizinadi;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "yb")
@SessionScoped
public class YonetimliBean implements Serializable {

    String numarasi;
    String adiSoyadi;
    BigDecimal maasi;
    int yasi;
//---------------------------
    public String getAdiSoyadi() {
        return adiSoyadi;
    }
    public void setAdiSoyadi(String adiSoyadi) {
        this.adiSoyadi = adiSoyadi;
    }
//---------------------------
    public BigDecimal getMaasi() {
        return maasi;
    }
    public void setMaasi(BigDecimal maasi) {
        this.maasi = maasi;
    }
//---------------------------
    public String getNumarasi() {
        return numarasi;
    }
    public void setNumarasi(String numarasi) {
        this.numarasi = numarasi;
    }
//---------------------------
    public int getYasi() {
        return yasi;
    }
    public void setYasi(int yasi) {
        this.yasi = yasi;
    }
//---------------------------
    private static final ArrayList<Personel> personelListesi =
        new ArrayList<Personel>(Arrays.asList(
        new Personel("571", "Suat Çelik", 28, new BigDecimal("1900.00")),
        new Personel("1299", "Metin Oğuzhan", 22, new BigDecimal("1500.00")),
        new Personel("1326", "Özkan İlhan", 20, new BigDecimal("1800.00")),
        new Personel("632", "Selman Kanbollu", 23, new BigDecimal("1300.00")))
            );
//---------------------------
    public ArrayList<Personel> getPersonelListesi() {
        
        return personelListesi;
        
    } 
//---------------------------
    public String kayitEkle() {
        Personel personel =
          new Personel(this.numarasi, this.adiSoyadi, this.yasi, this.maasi);

        personelListesi.add(personel);
        this.numarasi = "";
        this.adiSoyadi = "";
        this.yasi = 0;
        this.maasi = null;
        return null;
    }
//---------------------------
    public String kayitSil(Personel personel) {
        personelListesi.remove(personel);
        return null;
    }
//---------------------------
    public String kayitDuzenle(Personel personel) {

        personel.setDuzenle(true);
        return null;
    }
 //---------------------------
    public String degisikligiKaydet() {
        //Varolan tüm değeri düzenliyoruz
        for (Personel personel : personelListesi) {
            personel.setDuzenle(false);
        }
        //Geçerli sayfayı dön
        return null;
    }   
}