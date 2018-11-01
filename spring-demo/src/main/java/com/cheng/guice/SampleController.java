package com.cheng.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

@RestController
@SpringBootApplication
@ServletComponentScan
public class SampleController {

    @Bean
    Injector injector() {
        return Guice.createInjector(new HelloWorldWebModule());
    }

    @Bean
    @RequestScope
    MyApplet myApplet(Injector injector) {
        return injector.getInstance(MyApplet.class);
    }

    @Bean
    @RequestScope
    WebDestination destination(Injector injector) {
        return injector.getInstance(WebDestination.class);
    }

    @Bean
    @RequestScope
    RequestParams params(Injector injector) {
        return injector.getInstance(RequestParams.class);
    }

    @Autowired
    MyApplet applet;

    @Autowired
    WebDestination destination;

    @Autowired
    RequestParams params;

    @GetMapping("/hello")
    String home(@RequestParam("msg") String msg) {
        params.setMessage(msg);
        applet.run();
        return destination.getResult();
    }

    public static void main(String[] args) {
        SpringApplication.run(SampleController.class, args);
    }
}
