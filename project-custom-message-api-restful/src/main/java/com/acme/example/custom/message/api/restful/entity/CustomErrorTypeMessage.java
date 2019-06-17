package com.acme.example.custom.message.api.restful.entity;

public class CustomErrorTypeMessage {

	private String errorMessage;

    public CustomErrorTypeMessage(String errorMessage){
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
	
	
}
