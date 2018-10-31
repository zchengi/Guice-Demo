package com.cheng.guice.server.impl;

import com.cheng.guice.server.OrderService;
import com.cheng.guice.server.PaymentService;
import com.cheng.guice.server.PriceService;

import javax.inject.Inject;
import java.util.Set;

/**
 * @author cheng
 *         2018/10/30 20:27
 */
public class OrderServiceImpl implements OrderService {

    /**
     * Dependencies
     */
    private final PriceService priceService;
    private final PaymentService paymentService;
    private final SessionManager sessionManager;

    /**
     * States
     */
    private Long ordersPaid = 0L;

    @Inject
    public OrderServiceImpl(PriceService priceService, PaymentService paymentService, SessionManager sessionManager) {
        this.priceService = priceService;
        this.paymentService = paymentService;
        this.sessionManager = sessionManager;
    }

    @Override
    public void sendToPayment(long orderId) {
        long price = priceService.getPrice(orderId);
        paymentService.pay(orderId, price,
                sessionManager.getSessionId());
        ordersPaid = ordersPaid + 1;

        throw new RuntimeException("Price=" + price
                + ". SessionId=" + sessionManager.getSessionId()
                + ". ordersPaid=" + ordersPaid);
    }
}

class PriceServiceMock extends PriceServiceImpl {

    @Inject
    public PriceServiceMock(Set<String> supportedCurrencies) {
        super(supportedCurrencies, null);
    }

    @Override
    public long getPrice(long orderId) {
        return 567L;
    }
}