package com.example.demo.jsf.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("longitudeValidator")
public class LongitudeValidator implements Validator<Double> {

    @Override
    public void validate(FacesContext context, UIComponent component, Double value) throws ValidatorException {
        if (value == null) {
            return;
        }
        if (value < -180 || value > 180) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Invalid longitude",
                    "Longitude must be between -180 and 180");
            throw new ValidatorException(msg);
        }
    }
}
