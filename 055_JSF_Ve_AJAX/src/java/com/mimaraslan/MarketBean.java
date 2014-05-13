package com.mimaraslan;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;

@ManagedBean
@RequestScoped
public class MarketBean {

    private SelectItem[] firma=new SelectItem[]{
        new SelectItem("firma1", "Firma Adı 1"),
        new SelectItem("firma2", "Firma Adı 2"),
        new SelectItem("firma3", "Firma Adı 3"),
        new SelectItem("firma4", "Firma Adı 4")
    };
    
    private SelectItem[] firma1=new SelectItem[]{
        new SelectItem("urun1","ÜRÜN  Adı 001"),
        new SelectItem("urun2","ÜRÜN  Adı 002")  
    };
    
    private SelectItem[] firma2=new SelectItem[]{
        new SelectItem("urun3","ÜRÜN ADI 003"),
        new SelectItem("urun4","ÜRÜN ADI 004"),
        new SelectItem("urun5","ÜRÜN ADI 005"),
        new SelectItem("urun6","ÜRÜN ADI 006"),   
    };
    
    private SelectItem[] firma3=new SelectItem[]{
        new SelectItem("urun7","ÜRÜN ADI 007"),
        new SelectItem("urun8","ÜRÜN ADI 008"),
        new SelectItem("urun9","ÜRÜN ADI 009"),
        new SelectItem("urun10","ÜRÜN ADI 010"),
        new SelectItem("urun11","ÜRÜN ADI 011"),
        new SelectItem("urun12","ÜRÜN ADI 012"),
        new SelectItem("urun13","ÜRÜN ADI 013")
    };
    
    private SelectItem[] firma4=new SelectItem[]{
        new SelectItem("urun14","ÜRÜN ADI 014"),
        new SelectItem("urun15","ÜRÜN ADI 015"),
        new SelectItem("urun16","ÜRÜN ADI 016")
    };
    
    private SelectItem urun[]=firma1;
    private String firma_adi="firma_adi";
    private String urun_no;
    
    public SelectItem[] getFirma() {
        return firma;
    }
    public void setFirma(SelectItem[] firma) {
        this.firma = firma;
    }

    public String getFirma_adi() {
        return firma_adi;
    }
    public void setFirma_adi(String firma_adi) {
        this.firma_adi = firma_adi;
    }

    public String getUrun_no() {
        return urun_no;
    }
    public void setUrun_no(String urun_no) {
        this.urun_no = urun_no;
    }

    public SelectItem[] getFirma1() {
        return firma1;
    }
    public void setFirma1(SelectItem[] firma1) {
        this.firma1 = firma1;
    }
    public SelectItem[] getFirma2() {
        return firma2;
    }
    public void setFirma2(SelectItem[] firma2) {
        this.firma2 = firma2;
    }
    public SelectItem[] getUrun() {
        return urun;
    }
    public void setUrun(AjaxBehaviorEvent evt) {
       if(firma_adi.equalsIgnoreCase("firma1")) {
            this.urun =firma1;
        }
       else if(firma_adi.equalsIgnoreCase("firma2")) {
            this.urun =firma2;
        }
       else if(firma_adi.equalsIgnoreCase("firma3")) {
            this.urun =firma3;
        }
       else if(firma_adi.equalsIgnoreCase("firma4")) {
            this.urun =firma4;
        }
    }
}
