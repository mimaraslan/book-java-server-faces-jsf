package com.mimaraslan;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "yonetimliBean3")
@RequestScoped
public class YonetimliBean3 {

    public YonetimliBean3() {
    }
    private String adi;
    private String soyadi;
    private String deneyim;

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getDeneyim() {
        return deneyim;
    }

    public void setDeneyim(String deneyim) {
        this.deneyim = deneyim;
    }

    public String getSoyadi() {
        return soyadi;
    }

    public void setSoyadi(String soyadi) {
        this.soyadi = soyadi;
    }

    public void yazdirMetodu() {
        String mesaj = "Adı Soyadı : " + this.adi + " " + this.soyadi
                + " Deneyim : " + this.deneyim;
        System.out.println(mesaj);
    }
}
