package com.cheng.guice.server.greeting;

import com.cheng.guice.MyApplet;
import com.cheng.guice.helloworlddemo.MyDestination;
import com.cheng.guice.helloworlddemo.Output;
import com.cheng.guice.helloworlddemo.StringWritingApplet;
import com.google.inject.AbstractModule;

/**
 * @author cheng
 *         2018/11/1 14:16
 */
public class HelloWorldWebModule extends AbstractModule {

    @Override
    protected void configure() {

        bind(MyApplet.class).to(StringWritingApplet.class);
        bind(MyDestination.class).to(WebDestination.class);

        bind(String.class).annotatedWith(Output.class)
                .toProvider(GreetingMessageProvider.class);
    }

    /*@Provides
    @Output
    String getOutputString(GreetingMessageProvider generator) {
        return generator.get();
    }*/
}

