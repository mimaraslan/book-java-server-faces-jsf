package com.mimaraslan;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

public class YonetimliBeanActionListener implements ActionListener{

    public YonetimliBeanActionListener() {
    }
    
    @Override
    public void processAction(ActionEvent event) 
            throws AbortProcessingException {
       System.out.println("Gönder2 düğmesine tıklandı.");
    }
} 
