package com.mimaraslan;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "yb")
@RequestScoped
public class YonetimliBean {

    public YonetimliBean() {
    }
    //-------------------------------------     
    private String eposta;
    //-------------------------------------  

    public String getEposta() {
        return eposta;
    }

    public void setEposta(String eposta) {
        this.eposta = eposta;
    }
} 