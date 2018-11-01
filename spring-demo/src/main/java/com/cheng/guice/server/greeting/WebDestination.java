package com.cheng.guice.server.greeting;

import com.cheng.guice.helloworlddemo.MyDestination;
import com.google.inject.servlet.RequestScoped;

import javax.inject.Inject;

/**
 * @author cheng
 *         2018/11/1 14:08
 */
//@Singleton
@RequestScoped
public class WebDestination implements MyDestination {

    private final StringBuilder sb;

    @Inject
    public WebDestination() {
        System.out.println("WebDestination constructed.");
        this.sb = new StringBuilder();
    }

    @Override
    public void write(String string) {
        sb.append(string);
    }

    public String getResult() {
        return sb.toString();
    }
}
