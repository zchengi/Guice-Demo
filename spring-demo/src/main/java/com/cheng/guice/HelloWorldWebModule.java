package com.cheng.guice;

import com.cheng.guice.helloworlddemo.MyDestination;
import com.cheng.guice.helloworlddemo.Output;
import com.cheng.guice.helloworlddemo.StringWritingApplet;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.servlet.ServletModule;

/**
 * @author cheng
 *         2018/11/1 14:16
 */
public class HelloWorldWebModule extends AbstractModule {

    @Override
    protected void configure() {

        install(new ServletModule());

        bind(MyApplet.class).to(StringWritingApplet.class);
        bind(MyDestination.class).to(WebDestination.class);
    }

    @Provides
    @Output
    String getOutputString(RequestParams params) {
        return params.getMessage();
    }
}
