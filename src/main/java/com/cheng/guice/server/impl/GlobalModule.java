package com.cheng.guice.server.impl;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;

/**
 * @author cheng
 *         2018/10/30 21:48
 */
public class GlobalModule extends AbstractModule {

    @Override
    protected void configure() {
        // Adds EUR, USD support

        // 集合绑定
        Multibinder<String> currencyBinder = Multibinder.newSetBinder(binder(), String.class);
        currencyBinder.addBinding().toInstance("EUR");
        currencyBinder.addBinding().toInstance("USD");
    }
}
