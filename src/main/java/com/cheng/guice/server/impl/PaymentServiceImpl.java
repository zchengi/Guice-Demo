package com.cheng.guice.server.impl;

import com.cheng.guice.Logged;
import com.cheng.guice.server.PaymentService;
import com.google.common.cache.Cache;

import javax.inject.Inject;

/**
 * @author cheng
 *         2018/10/30 20:40
 */
public class PaymentServiceImpl implements PaymentService {

    private final Cache<String, String> cache;

    @Inject
    public PaymentServiceImpl(Cache<String, String> cache) {
        this.cache = cache;
    }

    @Override
    @Logged
    public void pay(long orderId, long price, Long sessionId) {
    }

    void putCache(String key, String value) {
        cache.put(key, value);
    }
}
