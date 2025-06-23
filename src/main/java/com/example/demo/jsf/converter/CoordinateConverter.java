package com.example.demo.jsf.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("coordinateConverter")
public class CoordinateConverter implements Converter<Double> {

    @Override
    public Double getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.trim().isEmpty()) {
            return null;
        }
        try {
            return Double.parseDouble(value.replace(',', '.'));
        } catch (NumberFormatException e) {
            throw new ConverterException("Invalid coordinate", e);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Double value) {
        return value != null ? String.format("%.6f", value) : "";
    }
}
