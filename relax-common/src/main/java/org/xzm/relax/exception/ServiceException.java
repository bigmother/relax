package org.xzm.relax.exception;

public class ServiceException extends RuntimeException {

    private int code;

    public ServiceException(ExceptionType exceptionType){
        super(exceptionType.getMessage());
        this.code = exceptionType.getCode();
    }

    public int getCode() {
        return code;
    }
}
