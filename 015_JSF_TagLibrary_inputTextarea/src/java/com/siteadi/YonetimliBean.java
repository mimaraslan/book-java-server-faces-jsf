package com.siteadi;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
@ManagedBean
@SessionScoped
public class YonetimliBean { 
    private String adisoyadi;
    private String mesaj;
    private String adres;

    public String getAdisoyadi() {
        return adisoyadi;
    }
    public void setAdisoyadi(String adisoyadi) {
        this.adisoyadi = adisoyadi;
    }

    public String getAdres() {
        return adres;
    }
    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getMesaj() {
        return mesaj;
    }
    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }
  
}
