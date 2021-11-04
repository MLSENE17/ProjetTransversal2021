package com.api.projettransversal.demande.api.request;

import java.util.Date;


public interface DemandeProjection {
    Long getId();
    String getDiplome();
    Date getCreate();
    boolean getValide();
}
