package com.cheng.guice.helloworlddemo;

import com.cheng.guice.MyApplet;
import com.google.inject.AbstractModule;

import java.io.PrintStream;

/**
 * @author cheng
 *         2018/10/30 19:25
 */
public class HelloWorldModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(MyApplet.class).to(StringWritingApplet.class);
        bind(MyDestination.class).to(PrintStringWriter.class);
        bind(PrintStream.class).toInstance(System.out);
        bind(String.class).annotatedWith(Output.class).toInstance("Hello World!");
//        bind(String.class).toProvider(() -> "Hello World!");
    }

    /*@Provides
    private String getString() {
        return "Hello World!";
    }*/
}