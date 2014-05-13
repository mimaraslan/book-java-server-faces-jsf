package com.firmaadi;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

@ManagedBean(name = "language")
@SessionScoped
public class DillerBean implements Serializable {

    private String yerelKod;
    private static Map<String, Object> ulkeler;

    static {
        ulkeler = new LinkedHashMap<String, Object>();
        ulkeler.put("English", Locale.ENGLISH); //label, value
        ulkeler.put("Deutsch", Locale.GERMANY); //label, value
        ulkeler.put("中國的", Locale.SIMPLIFIED_CHINESE);
    }

    public Map<String, Object> getUlkerinHaritasi() {
        return ulkeler;
    }

    public String getYerelKod() {
        return yerelKod;
    }

    public void setYerelKod(String yerelKod) {
        this.yerelKod = yerelKod;
    }

    //değer değişimi olay dinleyicisi
    public void ulkeninYerelKoduDegisti(ValueChangeEvent e) {

        String yeniYerelKodDegeri = e.getNewValue().toString();

        //ülkelerin yerel kodunu karşılaştırmak için döngü haritası
        for (Map.Entry<String, Object> entry : ulkeler.entrySet()) {

            if (entry.getValue().toString().equals(yeniYerelKodDegeri)) {
                FacesContext.getCurrentInstance().
                        getViewRoot().
                        setLocale((Locale) entry.getValue());
            }
        }
    }
}
