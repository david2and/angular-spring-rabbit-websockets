package com.david.test.model;

public class UrlValidationResponse {

    private String content;

    public UrlValidationResponse() {}

    public UrlValidationResponse(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "UrlValidationResponse{" +
                "content='" + content + '\'' +
                '}';
    }
}
