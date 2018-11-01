package com.cheng.guice;

import com.cheng.guice.helloworlddemo.MyDestination;
import com.google.inject.servlet.RequestScoped;

/**
 * @author cheng
 *         2018/11/1 14:08
 */
//@Singleton
@RequestScoped
public class WebDestination implements MyDestination {

    private StringBuilder sb = new StringBuilder();

    public WebDestination() {
        System.out.println("WebDestination constructed.");
    }

    @Override
    public void write(String string) {
        sb.append(string);
    }

    public String getResult() {
        return sb.toString();
    }
}
