package com.mimaraslan;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;
 
@ManagedBean(name = "personel")
@SessionScoped
public class PersonelBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private static Map<String, String> kisiler;
    private String hakkinda = "Fırat Üniversitesi"; //varsayılan değer

    static {
        kisiler = new LinkedHashMap<String, String>();
                                  //label, value
        kisiler.put("Burak Cagatay Alkan", "Fırat Üniversitesi");
        kisiler.put("Furkan Uzun", "Ondokuz Mayıs Üniversitesi");
        kisiler.put("Veysel Hyung Ece", "Bilgisayar Mühensisi - Oracle DBA");
        kisiler.put("Metin Dinibütünoğlu", "Hyundai Assan Otomotiv'de Stajyer");
        kisiler.put("Tanju Bozok", "Azerbaijan Technical University");
        kisiler.put("Burakhan Sinal", "Gstcranes");
        kisiler.put("Ferid Mövsümov", "Ankara Üniversitesi");
        kisiler.put("Fatih Aktürk", "Medieval II : Total War'da Stajyer");
    }

    public void personelHakkindaChanged(ValueChangeEvent e) {
        //personel bilgisine yeni bir değer atanıyor
        hakkinda = e.getNewValue().toString();
    }

    public Map<String, String> getPersonelInMap() {
        return PersonelBean.kisiler;
    }

    public String getHakkinda() {
        return hakkinda;
    }

    public void setHakkinda(String hakkinda) {
        this.hakkinda = hakkinda;
    }
}