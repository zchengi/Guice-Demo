package com.cheng.guice.helloworlddemo;

import com.cheng.guice.Applets;
import com.cheng.guice.Args;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import java.io.PrintStream;
import java.util.List;

/**
 * @author cheng
 *         2018/10/30 19:25
 */
public class HelloWorldModule extends AbstractModule {

    @Override
    protected void configure() {

//        MapBinder.newMapBinder(binder(), String.class, MyApplet.class)
//                .addBinding("hello").to(StringWritingApplet.class);
       Applets.register(binder()).named("hello").to(StringWritingApplet.class);

//        bind(MyApplet.class).annotatedWith(Names.named("hello")).to(StringWritingApplet.class);
        bind(MyDestination.class).to(PrintStringWriter.class);
        bind(PrintStream.class).toInstance(System.out);
//        bind(String.class).annotatedWith(Output.class).toInstance("Hello World!");
//        bind(String.class).toProvider(() -> "Hello World!");
    }

    @Provides
    @Output
    private String getString(@Args List<String> args) {
//        return "Hello World!";
        return args.get(0);
    }
}