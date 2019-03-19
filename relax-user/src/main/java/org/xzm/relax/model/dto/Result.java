package org.xzm.relax.model.dto;

public class Result<T> {

    private String code;
    private String message;
    private T data;

    private Result(String code,String message,T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> Result<T> success(T data){
        return new Result<>("","",data);
    }

    public static <T> Result<T> error(String code,T data){
        return new Result<>("","",data);
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
