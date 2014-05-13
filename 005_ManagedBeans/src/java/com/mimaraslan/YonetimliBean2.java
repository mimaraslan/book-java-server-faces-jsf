package com.mimaraslan;

import javax.faces.event.ActionEvent;

public class YonetimliBean2 {

    public void onayverAction() {
        String sonuc = "Action metodu çalıştırıldı.";
        System.out.println(sonuc);
    }

    public void onayverActionListener(ActionEvent olay) {
        String gelenParametreAdi =
                (String) olay.getComponent().getAttributes().get("p_adi");

        String gelenParametreSoyadi =
                (String) olay.getComponent().getAttributes().get("p_soyadi");

        String sonuc =
           "Parametreler: " + gelenParametreAdi + " " + gelenParametreSoyadi;
        System.out.println(sonuc);
    }
}
