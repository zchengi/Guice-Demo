package com.cheng.guice.server.greeting;

import com.google.inject.servlet.RequestScoped;

/**
 * @author cheng
 *         2018/11/1 14:09
 */
//@Singleton
@RequestScoped
public class RequestParams {

    private String greetingName;

    public RequestParams() {
        System.out.println("RequestParams constructed.");
    }

    public String getGreetingName() {
        return greetingName;
    }

    public void setGreetingName(String greetingName) {
        this.greetingName = greetingName;
    }
}
