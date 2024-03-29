package com.example.passguard.util;

public abstract class BaseService {
    private final BaseRequest request;

    public BaseService(BaseRequest request) {
        this.request = request;
    }

    public BaseRequest getRequest() {
        return request;
    }

    public abstract BaseResponse getResponse();
}
