package com.cheng.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import java.util.Arrays;
import java.util.List;

/**
 * @author cheng
 *         2018/10/31 19:56
 */
public class CommandLineModule extends AbstractModule {

    private final String[] args;

    public CommandLineModule(String[] args) {
        this.args = args;
    }

    @Override
    protected void configure() {

    }

    @Provides
    @Args
    private List<String> getCommandLineArgs() {
        return Arrays.asList(args).subList(1, args.length);
    }
}
