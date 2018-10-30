package com.cheng.guice.server.impl;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;

/**
 * @author cheng
 *         2018/10/30 21:48
 */
public class ChinaModule extends AbstractModule {

    @Override
    protected void configure() {
        // Adds CNY support

        // 集合绑定
        Multibinder.newSetBinder(binder(), String.class)
                .addBinding().toInstance("CNY");

//        MapBinder.newMapBinder();
    }
}
