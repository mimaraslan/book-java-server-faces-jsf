package com.siteadi;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "yb")
@SessionScoped
public class YonetimliBean implements Serializable {
    public String tarih1,tarih2,tarih3;
//-----------------------------------
    public String getTarih1() {
        return tarih1;
    }
    public void setTarih1(String tarih1) {
        this.tarih1 = tarih1;
    }
//-----------------------------------
    public String getTarih2() {
        return tarih2;
    }
    public void setTarih2(String tarih2) {
        this.tarih2 = tarih2;
    }
//-----------------------------------
    public String getTarih3() {
        return tarih3;
    }
    public void setTarih3(String tarih3) {
        this.tarih3 = tarih3;
    }
//-----------------------------------

    //Map Haritalama ile 
    private static Map<String, Object> tarih2Degeri;

    static {
        tarih2Degeri = new LinkedHashMap<String, Object>();
        tarih2Degeri.put("Osmanlı İmparatorluğunun Kuruluş Tarihi - 1299",
                "1299"); //label, value

        tarih2Degeri.put("İstanbul'un Fetih Tarihi - 1453", "1453");
        tarih2Degeri.put("Mısır'ın Fetih Tarihi - 1517", "1517");
    }

    public Map<String, Object> getTarih2DegerleriniAl() {
        return tarih2Degeri;
    }
//-----------------------------------

    public static class Yil {    //Bir sınıf ve nesne ile 

        public String yilEtiketi;
        public String yilDegeri;

        public Yil(String yilEtiketi, String yilDegeri) {
            this.yilEtiketi = yilEtiketi;
            this.yilDegeri = yilDegeri;
        }

        public String getYilEtiketi() {
            return yilEtiketi;
        }

        public String getYilDegeri() {
            return yilDegeri;
        }
    }
    public Yil[] tarih3Listesi;

    public Yil[] getTarih3DegerleriniAl() {

        tarih3Listesi = new Yil[3];
        tarih3Listesi[0] = new Yil("Osmanlı İmparatorluğunun "
                + "Kuruluş Tarihi - 1299", "1299");
        tarih3Listesi[1] = new Yil("İstanbul'un Fetih Tarihi - 1453",
                "1453");
        tarih3Listesi[2] = new Yil("Mısır'ın Fetih Tarihi - 1517", "1517");

        return tarih3Listesi;
    }
}
