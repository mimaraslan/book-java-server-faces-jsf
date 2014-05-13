package com.mimaraslan;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/*BU ADRESTEN BU JAR DOSYALARINI INDIRDIK
 http://www.findjar.com
 */
import org.apache.commons.validator.UrlValidator;
 
@FacesConverter("com.mimaraslan.SiteAdresiTamamlamaSinifi")
public class SiteAdresiTamamlamaSinifi implements Converter {

@Override
 public Object getAsObject(FacesContext context, UIComponent component,
            String value) {

        String HTTP = "http://";
        StringBuilder url = new StringBuilder();

        //Girilen URL eğer http:// ile başlamıyorsa başa  http:// ekle
        if (!value.startsWith(HTTP, 0)) {
            url.append(HTTP);
        }
        url.append(value);

        //Apache URL denetleyici
        UrlValidator urlValidator = new UrlValidator();
        //Geçersiz URL
        if (!urlValidator.isValid(url.toString())) {

            FacesMessage mesaj = new FacesMessage("URL tamamlama hatası.",
                    "Geçersiz URL girildi.");
            mesaj.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ConverterException(mesaj);
        }

        SiteAdresiPOJO siteninAdresYolu = new SiteAdresiPOJO(url.toString());
        return siteninAdresYolu;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component,
            Object value) {

        return value.toString();

    }
}