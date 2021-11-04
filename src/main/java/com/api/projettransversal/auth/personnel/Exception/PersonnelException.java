package com.api.projettransversal.auth.personnel.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class PersonnelException  extends  RuntimeException{
    public PersonnelException(String message){
        super(message);
    }
}
