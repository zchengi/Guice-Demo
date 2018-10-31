package com.cheng.guice.server.impl;

import com.cheng.guice.server.PriceService;
import com.google.common.cache.Cache;

import javax.inject.Inject;
import java.util.Set;

/**
 * @author cheng
 *         2018/10/30 20:38
 */
public class PriceServiceImpl implements PriceService {

    private final Cache<String, String> cache;

    private final Set<String> supportedCurrencies;

    @Inject
    public PriceServiceImpl(Set<String> supportedCurrencies, Cache<String, String> cache) {
        this.supportedCurrencies = supportedCurrencies;
        this.cache = cache;
    }

    @Override
    public long getPrice(long orderId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<String> getSupportedCurrencies() {
//        return Arrays.asList("CNY", "USD", "EUR");
        return supportedCurrencies;
    }

    String getCachedValue(String key) {
        return cache.getIfPresent(key);
    }
}
