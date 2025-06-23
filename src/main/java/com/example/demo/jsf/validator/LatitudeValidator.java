package com.example.demo.jsf.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("latitudeValidator")
public class LatitudeValidator implements Validator<Double> {

    @Override
    public void validate(FacesContext context, UIComponent component, Double value) throws ValidatorException {
        if (value == null) {
            return;
        }
        if (value < -90 || value > 90) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Invalid latitude",
                    "Latitude must be between -90 and 90");
            throw new ValidatorException(msg);
        }
    }
}
