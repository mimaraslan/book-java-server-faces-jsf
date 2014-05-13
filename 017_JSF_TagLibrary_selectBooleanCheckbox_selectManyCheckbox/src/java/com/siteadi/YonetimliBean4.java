package com.siteadi;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "yb4")
@SessionScoped
public class YonetimliBean4 {
    
    public String[] javaGuiSeverler;

    public String[] getJavaGuiSeverler() {
        return javaGuiSeverler;
    }
    public void setJavaGuiSeverler(String[] javaGuiSeverler) {
        this.javaGuiSeverler = javaGuiSeverler;
    }

    //Map - Haritalama ile oluşturuldu.
    private static Map<String, Object> javaGuiSeverlerAdiSoyadi;

    static {
        javaGuiSeverlerAdiSoyadi = new LinkedHashMap<String, Object>();
        javaGuiSeverlerAdiSoyadi.put("Emre Kaçan", "1"); //label, value
        javaGuiSeverlerAdiSoyadi.put("Ahmet Müngen", "2"); //etiket , değer
        javaGuiSeverlerAdiSoyadi.put("Mustafa Özserdar", "3");
        javaGuiSeverlerAdiSoyadi.put("Hüseyin Varol", "4");
        javaGuiSeverlerAdiSoyadi.put("Veysel Toprak", "5");
        javaGuiSeverlerAdiSoyadi.put("Meherrem Memmedov", "6");
    }

    public Map<String, Object> getJavaGuiSeverlerAdiSoyadi() {
        return javaGuiSeverlerAdiSoyadi;
    }

    public String getJavaGuiSeverlerSonucu() {
        return Arrays.toString(javaGuiSeverler);
    }
    
}

