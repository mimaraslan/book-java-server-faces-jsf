package com.siteadi;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "yb")
@SessionScoped 
public class YonetimliBean {
    
    
    public String htmlInput = "<input type=\"{0}\" {1} />";

    public String getHtmlInput() {
        return htmlInput;
    }

    public void setHtmlInput(String htmlInput) {
        this.htmlInput = htmlInput;
    }
    
//-------------------------------
 
    public String adi, soyadi;
    public String selam = "Selamlar, {0}";
    
    public String getAdi() {
        return adi;
    }
    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getSoyadi() {
        return soyadi;
    }
    public void setSoyadi(String soyadi) {
        this.soyadi = soyadi;
    }
   
    public String getSelam() {
        return selam;
    }
    public void setSelam(String selam) {
        this.selam = selam;
    }

}

