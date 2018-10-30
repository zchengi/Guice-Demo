package com.cheng.guice.helloworlddemo;

import com.cheng.guice.MyApplet;
import com.google.inject.Provider;

import javax.inject.Inject;

/**
 * @author cheng
 *         2018/10/30 18:32
 */
public class StringWritingApplet implements MyApplet {

    private MyDestination destination;

    private Provider<String> stringProvider;

    @Inject
    public StringWritingApplet(MyDestination destination,
                               @Output Provider<String> stringProvider) {
        this.destination = destination;
        this.stringProvider = stringProvider;
    }

    @Override
    public void run() {
        writeString();
    }

    private void writeString() {
        destination.write(stringProvider.get());
    }
}
