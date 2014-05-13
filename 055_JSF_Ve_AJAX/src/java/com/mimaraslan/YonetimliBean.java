package com.mimaraslan;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "yb")
@RequestScoped
public class YonetimliBean implements Serializable {
private static final long serialVersionUID = 1L;
	
    public YonetimliBean() {
    }  
    String adi, soyadi;
//-------------------------------
    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }
//-------------------------------
    public String getSoyadi() {
        return soyadi;
    }

    public void setSoyadi(String soyadi) {
        this.soyadi = soyadi;
    }
}
