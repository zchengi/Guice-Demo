package com.cheng.guice.server.impl;

import com.cheng.guice.server.PriceService;

import javax.inject.Inject;
import java.util.Set;

/**
 * @author cheng
 *         2018/10/30 20:38
 */
public class PriceServiceImpl implements PriceService {

    private final Set<String> supportedCurrencies;

    @Inject
    public PriceServiceImpl(Set<String> supportedCurrencies) {
        this.supportedCurrencies = supportedCurrencies;
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
}
