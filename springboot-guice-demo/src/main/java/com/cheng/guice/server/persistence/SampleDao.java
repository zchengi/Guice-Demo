package com.cheng.guice.server.persistence;

import org.springframework.stereotype.Component;

/**
 * @author cheng
 *         2018/11/1 14:33
 */
@Component
public class SampleDao {

    public void save(String data) {
        System.out.println(data + " saved.");
    }

    public String getPersonData(String name) {
        System.out.println("Getting person data for: " + name);
        return name;
    }
}
