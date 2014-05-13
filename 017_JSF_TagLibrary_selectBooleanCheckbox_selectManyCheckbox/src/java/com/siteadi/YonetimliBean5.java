package com.siteadi;

import java.util.Arrays;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "yb5")
@SessionScoped
public class YonetimliBean5 {

    public String[] jsfSeverler;

    public String[] getJsfSeverler() {
        return jsfSeverler;
    }
    public void setJsfSeverler(String[] jsfSeverler) {
        this.jsfSeverler = jsfSeverler;
    }

   
    public static class Sayi { //Bir sınıfın tipindeki bir dizi ile
        public String sayiEtiketi;
        public String sayiDegeri;
        
        public Sayi(String sayiEtiketi, String sayiDegeri) {
            this.sayiEtiketi = sayiEtiketi;
            this.sayiDegeri = sayiDegeri;
        }
        
        public String getSayiEtiketi() {
            return sayiEtiketi;
        }
        public String getSayiDegeri() {
            return sayiDegeri;
        }
    }
    public Sayi[] jsfSeverlerAdiSoyadi;
    public Sayi[] getJsfSeverlerAdiSoyadi() {
        jsfSeverlerAdiSoyadi = new Sayi[6];
        jsfSeverlerAdiSoyadi[0] = new Sayi("Faruk Taşbaşı", "1");
        jsfSeverlerAdiSoyadi[1] = new Sayi("Mehmet Canker", "2");
        jsfSeverlerAdiSoyadi[2] = new Sayi("Can Delibas", "3");
        jsfSeverlerAdiSoyadi[3] = new Sayi("Halit Karaçayır", "4");
        jsfSeverlerAdiSoyadi[4] = new Sayi("Burak Tungut", "5");
        jsfSeverlerAdiSoyadi[5] = new Sayi("Veysel Karani Ece", "6");
        return jsfSeverlerAdiSoyadi;
    }
    
    public String getJsfSeverlerSonucu() {
		return Arrays.toString(jsfSeverler);
	}
}
