package com.cheng.guice.server;

import java.util.Set;

/**
 * @author cheng
 *         2018/10/30 20:29
 */
public interface PriceService {

    long getPrice(long orderId);

    Set<String> getSupportedCurrencies();
}
