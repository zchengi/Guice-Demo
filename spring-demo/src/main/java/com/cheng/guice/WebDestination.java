package com.cheng.guice;

import com.cheng.guice.helloworlddemo.MyDestination;
import com.google.inject.servlet.RequestScoped;

import javax.inject.Inject;

/**
 * @author cheng
 *         2018/11/1 14:08
 */
//@Singleton
@RequestScoped
public class WebDestination implements MyDestination {

    private final SampleDao dao;
    private final StringBuilder sb;

    @Inject
    public WebDestination(SampleDao dao) {
        System.out.println("WebDestination constructed.");
        this.dao = dao;
        this.sb = new StringBuilder();
    }

    @Override
    public void write(String string) {
        dao.save(string);
        sb.append(string);
    }

    public String getResult() {
        return sb.toString();
    }
}
