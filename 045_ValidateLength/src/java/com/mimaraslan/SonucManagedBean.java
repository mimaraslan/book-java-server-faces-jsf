package com.mimaraslan;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "yb")
@RequestScoped
public class SonucManagedBean {

    public SonucManagedBean() {
    }
    String cumle;

    public String getCumle() {
        return cumle;
    }

    public void setCumle(String cumle) {
        this.cumle = cumle;
    }
}