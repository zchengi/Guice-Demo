package com.cheng.guice.server.controller;

import com.cheng.guice.server.SpringScanBase;
import com.cheng.guice.server.greeting.GreetingHandler;
import com.cheng.guice.server.greeting.HelloWorldWebModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

@RestController
@SpringBootApplication(scanBasePackageClasses = SpringScanBase.class)
@ServletComponentScan
public class SampleController {

    @Bean
    Injector injector(ApplicationContext context) {
        return Guice.createInjector(
                new HelloWorldWebModule(),
                new SpringAwareServletModule(context));
    }

    @Bean
    @RequestScope
    GreetingHandler greetingHandler(Injector injector) {
        return injector.getInstance(GreetingHandler.class);
    }

    @Autowired
    GreetingHandler greetingHandler;

    @GetMapping("/greeting")
    String greeting(@RequestParam("name") String name) {

//        params.setGreetingName(name);
//        applet.run();
//        return destination.getResult();

        return greetingHandler.getByName(name);
    }

    public static void main(String[] args) {
        SpringApplication.run(SampleController.class, args);
    }
}
