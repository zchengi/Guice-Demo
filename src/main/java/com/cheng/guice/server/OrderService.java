package com.cheng.guice.server;

/**
 * @author cheng
 *         2018/10/30 20:26
 */
public interface OrderService {

    void sendToPayment(long orderId);
}
