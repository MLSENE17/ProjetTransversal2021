package com.api.projettransversal.diplome.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DiplomeExceptionName extends  RuntimeException{
    public DiplomeExceptionName(String message){
        super(message);
    }
}
