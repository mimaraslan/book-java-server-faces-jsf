package com.siteadi;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "yb")
@SessionScoped
public class YonetimliBean implements Serializable {

    String verileceMesaj ="Güzel gören güzel düşünür.\n"+
            "Güzel düşünen hayatından lezzet alır.\n";

    public String getVerileceMesaj() {
        return verileceMesaj;
    }

    public void setVerileceMesaj(String verileceMesaj) {
        this.verileceMesaj = verileceMesaj;
    }
   
}
