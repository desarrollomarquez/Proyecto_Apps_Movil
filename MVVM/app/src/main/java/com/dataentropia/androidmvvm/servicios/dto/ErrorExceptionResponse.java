package com.dataentropia.androidmvvm.servicios.dto;

import java.util.List;

public class ErrorExceptionResponse{
    public ErrorExceptionResponse(String messageException, List<String> detailsException) {
        super();
        this.messageException = messageException;
        this.detailsException = detailsException;
    }

    private String messageException;
    private List<String> detailsException;

    public String getMessageException() {
        return messageException;
    }

    public void setMessageException(String messageException) {
        this.messageException = messageException;
    }

    public List<String> getDetailsException() {
        return detailsException;
    }

    public void setDetailsException(List<String> detailsException) {
        this.detailsException = detailsException;
    }

}
