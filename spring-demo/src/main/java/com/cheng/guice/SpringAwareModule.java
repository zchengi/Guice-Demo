package com.cheng.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import org.springframework.context.ApplicationContext;

/**
 * @author cheng
 *         2018/11/1 14:36
 */
public class SpringAwareModule extends AbstractModule {

    private final ApplicationContext context;

    public SpringAwareModule(ApplicationContext context) {
        this.context = context;
    }

    @Override
    protected void configure() {
        bind(ApplicationContext.class).toInstance(context);
    }

    @Provides
    SampleDao getSampleDao(ApplicationContext context) {
        return context.getBean(SampleDao.class);
    }
}
