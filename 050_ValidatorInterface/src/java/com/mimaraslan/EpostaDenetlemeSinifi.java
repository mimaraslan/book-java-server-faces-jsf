package com.mimaraslan;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


@FacesValidator("com.mimaraslan.EpostaDenetlemeSinifi")
public class EpostaDenetlemeSinifi implements Validator {

    private static final String EPOSTA_PATTERN =
            "^(([A-Za-z0-9]+_+)\n"
            + "|([A-Za-z0-9]+\\-+)|([A-Za-z0-9]+\\.+)\n"
            + "|([A-Za-z0-9]+\\++))*[A-Za-z0-9]+@((\\w+\\-+)\n"
            + "|(\\w+\\.))*\\w{1,63}\\.[a-zA-Z]{2,6}$";
    private Pattern pattern;
    private Matcher matcher;

    public EpostaDenetlemeSinifi() {
        pattern = Pattern.compile(EPOSTA_PATTERN);
    }

    @Override
    public void validate(FacesContext context, UIComponent component,
            Object value) throws ValidatorException {

        matcher = pattern.matcher(value.toString());
        if (!matcher.matches()) {

            FacesMessage msg =new FacesMessage("E-posta denetleme başarısız!",
                    "Geçersiz e-posta!");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);

        }

    }
}




