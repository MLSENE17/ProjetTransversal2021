package com.api.projettransversal.placeSignatory.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class PlaceSignatorExist extends  RuntimeException{
    public PlaceSignatorExist(String message){
            super(message);
    }
}
