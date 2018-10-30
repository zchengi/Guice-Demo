package com.cheng.guice;

import com.cheng.guice.helloworlddemo.HelloWorldModule;
import com.google.inject.AbstractModule;

/**
 * 使用 Guice 配置 Dependency
 *
 * @author cheng
 *         2018/10/30 19:14
 */
public class MainModule extends AbstractModule {
    @Override
    protected void configure() {
        install(new HelloWorldModule());
    }
}
