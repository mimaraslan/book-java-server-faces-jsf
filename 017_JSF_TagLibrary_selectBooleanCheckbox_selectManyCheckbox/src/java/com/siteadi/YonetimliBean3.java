package com.siteadi;
import java.util.Arrays;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "yb3")
@SessionScoped
public class YonetimliBean3 {
    public String[] iphoneSeverler;

    public String[] getIphoneSeverler() {
        return iphoneSeverler;
    }
    public void setIphoneSeverler(String[] iphoneSeverler) {
        this.iphoneSeverler = iphoneSeverler;
    }
  //Array - Dizi tarafından oluşturuldu
    public String[] getIphoneSeverlerAdiSoyadi() {
        iphoneSeverler = new String[6];
        iphoneSeverler[0] = "Birdal Özcan";
        iphoneSeverler[1] = "Mustafa Onur Aydın";
        iphoneSeverler[2] = "Rihan Güneş";
        iphoneSeverler[3] = "Serdar Türkmen";
        iphoneSeverler[4] = "Meltem Akdemir";
        iphoneSeverler[5] = "Hüseyin Kaplay";
        return iphoneSeverler;
    }
    
    public String getIphoneSeverlerSonucu() {
        return Arrays.toString(iphoneSeverler);
    }
}
