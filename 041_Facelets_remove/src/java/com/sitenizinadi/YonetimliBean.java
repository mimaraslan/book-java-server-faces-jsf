package com.sitenizinadi;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "yb")
@SessionScoped
public class YonetimliBean {

    private String adiSoyadi;
    private String buttonYazisi = "Sayfa2'ye Gönder";

    public String getAdiSoyadi() {
        return adiSoyadi;
    }

    public void setAdiSoyadi(String adiSoyadi) {
        this.adiSoyadi = adiSoyadi;
    }

    public String getButtonYazisi() {
        return buttonYazisi;
    }

    public void setButtonYazisi(String buttonYazisi) {
        this.buttonYazisi = buttonYazisi;
    }

    public String yonelenilecekSayfaGit() {
        return "sayfa2";
    }
} 