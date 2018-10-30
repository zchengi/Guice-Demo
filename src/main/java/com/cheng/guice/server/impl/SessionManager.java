package com.cheng.guice.server.impl;

import com.google.inject.Provider;

import javax.inject.Inject;

/**
 * @author cheng
 *         2018/10/30 20:29
 */
public class SessionManager {

    private final Provider<Long> sessionProvider;

    @Inject
    public SessionManager(@SessionId Provider<Long> sessionProvider) {
        this.sessionProvider = sessionProvider;
    }

    public Long getSessionId() {
        return sessionProvider.get();
    }
}
