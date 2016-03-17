package portal.utils;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
* Created with IntelliJ IDEA.
* User: NGUYEN VAN NHAN
* Date: 10/28/2015
* Time: 9:00 AM
* Long Van Soft Solution JSC
* To change this template use File | Settings | File Templates.
*/
@ApplicationScoped
@ManagedBean(name = "StringTrimmer")
public class StringTrimmer implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return value != null ? value.trim() : null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return (String) value;
    }

}
