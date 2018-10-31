package com.cheng.guice.server.impl;

import com.google.common.cache.AbstractCache;
import com.google.inject.Singleton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author cheng
 *         2018/10/31 21:25
 */
@Singleton
public class GuiceDemoCache extends AbstractCache<String, String> {

    // private final Map<String, String> keyValues = new HashMap<>();
    private final Map<String, String> keyValues = new ConcurrentHashMap<>();

    @Override
    public String getIfPresent(Object key) {
        return keyValues.get(key);
    }

    @Override
    public void put(String key, String value) {
        keyValues.put(key, value);
    }
}
