package com.mimaraslan;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="yb")
@RequestScoped
public class YonetimliBean {

    public YonetimliBean() {
    }
//---------------------------------     
  //double 
    float urunfiyati;
//---------------------------------  
    public float getUrunfiyati() {
        return urunfiyati;
    }

    public void setUrunfiyati(float urunfiyati) {
        this.urunfiyati = urunfiyati;
    }
    
}


