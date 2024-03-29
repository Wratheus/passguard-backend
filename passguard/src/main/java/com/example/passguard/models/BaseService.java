package com.example.passguard.models;

public abstract class BaseService {
    private final BaseRequest request;

    public BaseService(BaseRequest request) {
        this.request = request;
    }

    public BaseRequest getRequest() {
        return request;
    }

    public abstract Response getResponse();
}
