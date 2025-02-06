package com.sergiomercado.projects.MovieManagement.exception;

public class ObjectNotFoundException extends RuntimeException {

    private final String objetNotFoundName;
    private final Throwable cause;
    public ObjectNotFoundException(String objetNotFoundName) {
        this.objetNotFoundName = objetNotFoundName;
        this.cause = null;
    }

    public ObjectNotFoundException(String objetNotFoundName, Throwable cause) {
        this.objetNotFoundName = objetNotFoundName;
        this.cause = cause;
    }

    @Override
    public String getMessage() {
        return super.getMessage()
                .concat("(object not found: ")
                .concat(this.objetNotFoundName)
                .concat(")");
    }

    public String getObjetNotFoundName() {
        return objetNotFoundName;
    }
}
