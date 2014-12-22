package com.bookserviceapp.exceptions;

/**
 * Created by Roman on 15.12.2014.
 */
public class AuthorNotFoundException extends Exception{

    public AuthorNotFoundException(){}

    public AuthorNotFoundException(String message){
        super(message);
    }

}
