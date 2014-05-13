package com.mimaraslan;

public class SiteAdresiPOJO {

    String siteAdi;

    public String getSiteAdi() {
        return siteAdi;
    }

    public void setSiteAdi(String siteAdi) {
        this.siteAdi = siteAdi;
    }

    public SiteAdresiPOJO(String siteAdi) {
        this.siteAdi = siteAdi;
    }
 
    @Override
    public String toString() {
        return siteAdi;
    }
}