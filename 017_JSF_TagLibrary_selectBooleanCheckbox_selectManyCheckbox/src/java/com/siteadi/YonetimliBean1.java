package com.siteadi;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "yb1")
@SessionScoped
public class YonetimliBean1 {

    public boolean yazilimiSeviyorMu;
    
    public boolean isYazilimiSeviyorMu() {
        return yazilimiSeviyorMu;
    }

    public void setYazilimiSeviyorMu(boolean yazilimiSeviyorMu) {
        this.yazilimiSeviyorMu = yazilimiSeviyorMu;
    }
    
}
