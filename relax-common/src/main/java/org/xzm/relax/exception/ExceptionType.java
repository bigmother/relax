package org.xzm.relax.exception;

public enum ExceptionType {

    SUCCESS("00000","success"),
    UNKNOW_ERROR("00001","unknow error");

    private String code;
    private String message;

    ExceptionType(String code,String message){
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
