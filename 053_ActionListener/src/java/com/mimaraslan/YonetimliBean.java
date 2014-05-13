package com.mimaraslan;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "yb")
@RequestScoped
public class YonetimliBean {

    public YonetimliBean() {
    }
    //-------------------------------------     
    private String adiSoyadi;
    //-------------------------------------  

    public String getAdiSoyadi() {
        return adiSoyadi;
    }

    public void setAdiSoyadi(String adiSoyadi) {
        this.adiSoyadi = adiSoyadi;
    } 
}




