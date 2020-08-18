package com.health.api.healthapi.payload.response;

import com.health.api.healthapi.models.User;

public class ApiResponseAuth {
    private String message;
    private String code;
    private User data;

    public ApiResponseAuth(String message, String code, User data) {
        this.message = message;
        this.code = code;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public User getData() {
        return data;
    }

    public void setData(User data) {
        this.data = data;
    }
}
