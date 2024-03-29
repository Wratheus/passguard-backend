package com.example.passguard.models;

public class Response {
    private final String status;
    private final Integer code;
    private final Object data;

    public Response(String status, Integer code, Object data) {
        this.status = status;
        this.code = code;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public Integer getCode() {
        return code;
    }

    public Object getData() {
        return data;
    }
}
