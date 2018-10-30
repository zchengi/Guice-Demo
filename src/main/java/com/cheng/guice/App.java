package com.cheng.guice;

import com.google.inject.Guice;

/**
 * @author cheng
 *         2018/10/30 18:14
 */
public class App {
    /**
     * bootstrap:
     * parse command line
     * set up environment
     * kick off main logic
     *
     * @param args
     */
    public static void main(String[] args) {
        MyApplet myApplet =
                Guice.createInjector(new MainModule())
                        .getInstance(MyApplet.class);
        myApplet.run();
    }
}
