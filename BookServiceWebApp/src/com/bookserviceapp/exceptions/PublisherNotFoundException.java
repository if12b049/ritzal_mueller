package com.bookserviceapp.exceptions;

/**
 * Created by Roman on 15.12.2014.
 */
public class PublisherNotFoundException extends Exception{

    public PublisherNotFoundException(){}

    public PublisherNotFoundException(String message){
        super(message);
    }

}
