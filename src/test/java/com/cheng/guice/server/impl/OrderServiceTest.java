package com.cheng.guice.server.impl;

import com.cheng.guice.server.OrderService;
import com.cheng.guice.server.PriceService;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Provider;
import com.google.inject.name.Named;
import com.google.inject.util.Modules;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import java.util.List;

public class OrderServiceTest {

    @Inject
    private OrderService orderService;

    @Inject
    private PriceService priceService;

    @Inject
    @Named("supportedCurrencies")
    private Provider<List<String>> supportedCurrenciesProvider;

    @Before
    public void setUp()  {
        Guice.createInjector(Modules.override(new ServerModule()).
                with(new AbstractModule() {
                    @Override
                    protected void configure() {
                        bind(PriceService.class).to(PriceServiceMock.class);
                    }
                }))
                .injectMembers(this);
    }

    @Test
    public void testSendToPayment() {
        orderService.sendToPayment(789L);
    }

    @Test
    public void testSupportedCurrencies() {
//        throw new RuntimeException(supportedCurrenciesProvider.get().toString());
        throw new RuntimeException(priceService.getSupportedCurrencies().toString());
    }
}