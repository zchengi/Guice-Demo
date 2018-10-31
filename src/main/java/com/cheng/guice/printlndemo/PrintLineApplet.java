package com.cheng.guice.printlndemo;

import com.cheng.guice.MyApplet;

/**
 * @author cheng
 *         2018/10/31 20:04
 */
public class PrintLineApplet implements MyApplet {

    @Override
    public void run() {
        System.out.println("printLineApplet");
    }
}
