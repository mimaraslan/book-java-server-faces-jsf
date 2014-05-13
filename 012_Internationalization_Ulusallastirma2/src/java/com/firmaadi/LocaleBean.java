package com.firmaadi;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.*;

import javax.faces.event.ValueChangeEvent;

@ManagedBean(name = "dil")
@SessionScoped
public class LocaleBean {

    private String yerelDurum;
    private Map<String, Object> ulkelerHaritasi;

    public LocaleBean() {
        ulkelerHaritasi = new LinkedHashMap<String, Object>();
        ulkelerHaritasi.put("Türkçe", new Locale("tr", "TR"));
        ulkelerHaritasi.put("English", new Locale("en", "GB"));
        ulkelerHaritasi.put("русский", new Locale("ru", "RU"));
        ulkelerHaritasi.put("العربية", new Locale("ar", "AR"));
    }

    public Map<String, Object> getUlkeler() {
        return ulkelerHaritasi;
    }

    public String getYerelDurum() {
        return yerelDurum;
    }

    public void setYerelDurum(String yerelDurum) {
        this.yerelDurum = yerelDurum;
    }

    public void yerelDurumDegisiminiKontrolEt(ValueChangeEvent e) {

        String localeStr = e.getNewValue().toString();

        for (Map.Entry<String, Object> entry : ulkelerHaritasi.entrySet()) {
            if (entry.getValue().toString().equals(localeStr)) {
                Locale locale = (Locale) entry.getValue();
                FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
            }
        }
    }
}

