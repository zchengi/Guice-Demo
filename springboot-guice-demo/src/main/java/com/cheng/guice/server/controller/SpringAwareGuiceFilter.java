package com.cheng.guice.server.controller;

import com.google.inject.servlet.GuiceFilter;

import javax.servlet.annotation.WebFilter;

/**
 * @author cheng
 *         2018/11/1 14:30
 */
@WebFilter
public class SpringAwareGuiceFilter extends GuiceFilter {
}
