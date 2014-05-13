package com.sitenizinadi;
import java.math.BigDecimal;

public class Personel{

    String numarasi;
    String adiSoyadi;
    BigDecimal maasi;
    int yasi;
//---------------------------
    public Personel(String numarasi, String adiSoyadi, 
            BigDecimal maasi, int yasi) {
        this.numarasi = numarasi;
        this.adiSoyadi = adiSoyadi;
        this.maasi = maasi;
        this.yasi = yasi;
    }
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
}
