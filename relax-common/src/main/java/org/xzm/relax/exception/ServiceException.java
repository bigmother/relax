package org.xzm.relax.exception;

public class ServiceException extends RuntimeException {

    private String code;

    public ServiceException(ExceptionType exceptionType){
        super(exceptionType.getMessage());
        this.code = exceptionType.getCode();
    }

    public String getCode() {
        return code;
    }
}
