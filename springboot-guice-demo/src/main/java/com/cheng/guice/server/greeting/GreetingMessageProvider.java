package com.cheng.guice.server.greeting;

import com.cheng.guice.server.persistence.SampleDao;
import com.google.inject.Provider;

import javax.inject.Inject;

/**
 * @author cheng
 *         2018/11/1 14:51
 */
public class GreetingMessageProvider implements Provider<String> {

    private final RequestParams params;
    private final SampleDao dao;

    @Inject
    public GreetingMessageProvider(RequestParams params, SampleDao dao) {
        this.params = params;
        this.dao = dao;
    }

    @Override
    public String get() {

        String name = params.getGreetingName();
        dao.getPersonData(name);
        return "Hello " + name;
    }
}
