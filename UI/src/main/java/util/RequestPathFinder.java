package util;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class RequestPathFinder {

    public static String getPath(){
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        return String.format("%s://%s:%d",
                context.getRequestScheme(),
                context.getRequestServerName(),
                context.getRequestServerPort());
    }
}
