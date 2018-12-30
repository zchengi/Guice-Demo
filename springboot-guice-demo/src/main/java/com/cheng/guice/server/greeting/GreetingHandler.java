package com.cheng.guice.server.greeting;

import com.cheng.guice.MyApplet;
import com.google.inject.servlet.RequestScoped;

import javax.inject.Inject;

/**
 * @author cheng
 *         2018/11/1 14:48
 */
@RequestScoped
public class GreetingHandler {

    private final RequestParams params;

    private final WebDestination destination;

    private final MyApplet applet;

    @Inject
    public GreetingHandler(RequestParams params, WebDestination destination, MyApplet applet) {
        this.params = params;
        this.destination = destination;
        this.applet = applet;
    }

    public String getByName(String name) {
        params.setGreetingName(name);
        applet.run();
        return destination.getResult();
    }
}
