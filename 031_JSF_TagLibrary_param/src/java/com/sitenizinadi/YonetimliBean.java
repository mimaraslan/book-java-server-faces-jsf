package com.sitenizinadi;
import java.io.Serializable;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "yb")
@SessionScoped

public class YonetimliBean implements Serializable {
    
    public String adi, soyadi, bolumu;
    
    public String getAdi() {
        return adi;
    }
    
    public void setAdi(String adi) {
        this.adi = adi;
    }
//---------------------------------
    public String getSoyadi() {
        return soyadi;
    }
    
    public void setSoyadi(String soyadi) {
        this.soyadi = soyadi;
    }
//---------------------------------
    public String getBolumu() {
        return bolumu;
    }
    
    public void setBolumu(String bolumu) {
        this.bolumu = bolumu;
    }
//---------------------------------
    
 public String yonelenilecekSayfaGit() {

        FacesContext facesContext = FacesContext.getCurrentInstance();
        this.bolumu = getBolumuParametresiniAl(facesContext);

        return "sayfa2";
    }

    // "f:param" ile gelen değerler alınıyor.
    public String getBolumuParametresiniAl(FacesContext facesContext) {

        Map<String, String> params =
                facesContext.getExternalContext().getRequestParameterMap();

        return params.get("bolumu");
    }
    
}
