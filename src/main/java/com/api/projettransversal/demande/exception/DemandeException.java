package com.api.projettransversal.demande.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DemandeException extends RuntimeException {
    public DemandeException(String message){
        super(message);
    }

}
