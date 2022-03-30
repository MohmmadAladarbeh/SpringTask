package com.example.demo.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (value = HttpStatus.NOT_FOUND)
public class AlbumFoundException extends RuntimeException{
    public AlbumFoundException (String message){
        super(message);
    }
}
