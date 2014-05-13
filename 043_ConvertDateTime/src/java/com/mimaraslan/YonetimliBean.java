package com.mimaraslan;

import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "yb")
@RequestScoped
public class YonetimliBean {

    public YonetimliBean() {
    }
//-------------------------------------   
    Date dogumtarihi;
//-------------------------------------
    public Date getDogumtarihi() {
        return dogumtarihi;
    }

    public void setDogumtarihi(Date dogumtarihi) {
        this.dogumtarihi = dogumtarihi;
    }
}

