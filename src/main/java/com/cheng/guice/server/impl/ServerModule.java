package com.cheng.guice.server.impl;

import com.cheng.guice.Logged;
import com.cheng.guice.server.OrderService;
import com.cheng.guice.server.PaymentService;
import com.cheng.guice.server.PriceService;
import com.google.common.cache.Cache;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.TypeLiteral;
import com.google.inject.matcher.Matchers;
import com.google.inject.name.Names;

import java.util.Arrays;
import java.util.List;

/**
 * @author cheng
 *         2018/10/30 20:38
 */
public class ServerModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new ChinaModule());
        install(new GlobalModule());

        // 类名绑定 实例绑定
        bind(OrderService.class).to(OrderServiceImpl.class);
        bind(PaymentService.class).to(PaymentServiceImpl.class);
        bind(PriceService.class).to(PriceServiceImpl.class);
//        bind(PriceService.class).toProvider(PriceServiceImpl::new);

        // 命名绑定
//        bind(Long.class).annotatedWith(SessionId.class).toInstance(System.currentTimeMillis());
//        bind(Long.class).annotatedWith(Names.named("appId")).toInstance(456L);

        // 泛型绑定
        bind(new TypeLiteral<List<String>>() {
        })
                .annotatedWith(Names.named("supportedCurrencies"))
                .toInstance(Arrays.asList("CNY", "EUR", "USD"));


        bind(new TypeLiteral<Cache<String, String>>() {
        }).to(GuiceDemoCache.class)/*.in(Singleton.class)*/;


        LoggingInterceptor loggingInterceptor = new LoggingInterceptor();
        requestInjection(loggingInterceptor);
        bindInterceptor(Matchers.any(),
                Matchers.annotatedWith(Logged.class),
                loggingInterceptor);
    }

    /**
     * 命名注入
     * Provider绑定
     *
     * @return
     */
    @Provides
    @SessionId
    protected Long generateSessionId() {
        return System.currentTimeMillis();
    }

    /**
     * 命名绑定
     *
     * @param priceService
     * @return
     */
  /*  @Provides
    @Named("supportedCurrencies")
    protected List<String> getSupportedCurrencies(PriceService priceService) {
        return priceService.getSupportedCurrencies();
    }*/

    /**
     * 作用域：Singleton
     *
     * @return
     */
    /*@Provides
    @Singleton
    private Cache<String, String> getCache() {
        return new GuiceDemoCache();
    }*/
}
