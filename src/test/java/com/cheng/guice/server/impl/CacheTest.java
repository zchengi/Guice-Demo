package com.cheng.guice.server.impl;

import com.google.inject.Guice;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;


/**
 * @author cheng
 *         2018/10/31 21:31
 */
public class CacheTest {

    @Inject
    private PaymentServiceImpl paymentService;

    @Inject
    private PriceServiceImpl priceService;

    @Before
    public void setUp() {
        Guice.createInjector(new ServerModule())
                .injectMembers(this);
    }

    @Test
    public void testCache() {

        paymentService.putCache("testKey", "testValue");
        String cachedValue = priceService.getCachedValue("testKey");

        assertEquals("testValue", cachedValue);
    }
}
