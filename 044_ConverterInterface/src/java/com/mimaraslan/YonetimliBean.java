package com.mimaraslan;
 
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "yb")
@SessionScoped
public class YonetimliBean implements Serializable {

    String siteAdresi;

    public String getSiteAdresi() {
        return siteAdresi;
    }

    public void setSiteAdresi(String siteAdresi) {
        this.siteAdresi = siteAdresi;
    }
}