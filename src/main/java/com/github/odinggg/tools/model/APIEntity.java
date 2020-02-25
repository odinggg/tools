package com.github.odinggg.tools.model;

/**
 * 描述:
 *
 * @author Hansen
 * @version 2020-02-25 15:00
 */
public class APIEntity<T> {
    private int status;
    private String message;
    private T data = null;

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public APIEntity(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public APIEntity(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public APIEntity() {
    }

}
