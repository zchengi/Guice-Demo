package com.cheng.guice.server;

/**
 * @author cheng
 *         2018/10/30 20:29
 */
public interface PaymentService {

    void pay(long orderId, long price, Long sessionId);
}
