package com.cheng.guice.printlndemo;

import com.cheng.guice.Applets;
import com.google.inject.AbstractModule;

/**
 * @author cheng
 *         2018/10/31 20:05
 */
public class PrintLineModule extends AbstractModule {

    @Override
    protected void configure() {

//        MapBinder.newMapBinder(binder(), String.class, MyApplet.class)
//                .addBinding("println").to(PrintLineApplet.class);
        Applets.register(binder()).named("println").to(PrintLineApplet.class);

//        bind(MyApplet.class).annotatedWith(Names.named("println")).to(PrintLineApplet.class);
    }
}
