package com.api.projettransversal.validation.api.request;

import java.util.Date;

public interface ValidationProjection {
    String getName();
    String getPlace();
    String getResponse();
    String getMessage();
    Date getUpdate();
}
