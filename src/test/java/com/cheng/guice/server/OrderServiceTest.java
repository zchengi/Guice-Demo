package com.cheng.guice.server;

import com.cheng.guice.server.impl.ServerModule;
import com.google.inject.Guice;
import com.google.inject.Provider;
import com.google.inject.name.Named;
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
        Guice.createInjector(new ServerModule()/*,
                new AbstractModule() {
                    @Override
                    protected void configure() {
                        // 连接绑定
                        bind(PriceServiceImpl.class).toInstance(new PriceServiceImpl() {
                            @Override
                            public long getPrice(long orderId) {
                                return 567L;
                            }
                        });
                    }
                }*/)
                .injectMembers(this);
    }

    @Test
    public void testSendToPayment() {
        orderService.sendToPayment(677L);
    }

    @Test
    public void testSupportedCurrencies() {
//        throw new RuntimeException(supportedCurrenciesProvider.get().toString());
        throw new RuntimeException(priceService.getSupportedCurrencies().toString());
    }
}