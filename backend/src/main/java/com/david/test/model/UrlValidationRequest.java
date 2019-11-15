package com.david.test.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class UrlValidationRequest implements Serializable {

    private  String text;

    public UrlValidationRequest(){

    }



    public UrlValidationRequest(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "HelloMessage{" +
                "text='" + text + '\'' +
               '}';
    }
}
