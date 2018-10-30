package com.cheng.guice.helloworlddemo;

import javax.inject.Inject;
import java.io.PrintStream;

/**
 * @author cheng
 *         2018/10/30 18:58
 */
public class PrintStringWriter implements MyDestination {

    private PrintStream destination;

    @Inject
    public PrintStringWriter(PrintStream destination) {
        this.destination = destination;
    }

    @Override
    public void write(String string) {
        destination.println(string);
    }
}
