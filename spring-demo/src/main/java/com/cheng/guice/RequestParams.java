package com.cheng.guice;

import com.google.inject.servlet.RequestScoped;

/**
 * @author cheng
 *         2018/11/1 14:09
 */
//@Singleton
@RequestScoped
public class RequestParams {

    private String message;

    public RequestParams() {
        System.out.println("RequestParams constructed.");
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
