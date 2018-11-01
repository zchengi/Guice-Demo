package com.cheng.guice.server.controller;

import com.cheng.guice.server.persistence.SampleDao;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.servlet.ServletModule;
import org.springframework.context.ApplicationContext;

/**
 * @author cheng
 *         2018/11/1 14:36
 */
public class SpringAwareServletModule extends AbstractModule {

    private final ApplicationContext context;

    public SpringAwareServletModule(ApplicationContext context) {
        this.context = context;
    }

    @Override
    protected void configure() {

        install(new ServletModule());
        bind(ApplicationContext.class).toInstance(context);
    }

    @Provides
    SampleDao getSampleDao(ApplicationContext context) {
        return context.getBean(SampleDao.class);
    }
}
