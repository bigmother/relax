package org.xzm.relax.exception;

public enum ExceptionType {

    //未知异常
    UNKNOW_ERROR(1,"unknow error");

    private int code;
    private String message;

    ExceptionType(int code,String message){
        this.code = code;
        this.message = message;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
