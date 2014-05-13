package com.mimaraslan;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="yb")
@RequestScoped
public class YonetimliBean {

    public YonetimliBean() {
    }
    
  int tamsayi; 
  double virgullusayi;

    public int getTamsayi() {
        return tamsayi;
    }

    public void setTamsayi(int tamsayi) {
        this.tamsayi = tamsayi;
    }
    
}