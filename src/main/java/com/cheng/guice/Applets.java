package com.cheng.guice;

import com.google.common.base.Joiner;
import com.google.inject.Binder;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;
import com.google.inject.binder.LinkedBindingBuilder;
import com.google.inject.multibindings.MapBinder;

import java.util.Map;

/**
 * @author cheng
 *         2018/10/31 20:29
 */
public class Applets {

    public static class AppletRegister {
        private final Binder binder;

        private AppletRegister(Binder binder) {
            this.binder = binder;
        }

        public LinkedBindingBuilder<MyApplet> named(String name) {
            return MapBinder.newMapBinder(binder, String.class, MyApplet.class)
                    .addBinding(name);
        }
    }

    public static AppletRegister register(Binder binder) {
        return new AppletRegister(binder);
    }

    public static MyApplet get(Injector injector, String name) {

        Map<String, MyApplet> applets = injector
//                        .getInstance(MyApplet.class);
//                        .getInstance(Key.get(MyApplet.class, Names.named(args[0])));
                .getInstance(Key.get(new TypeLiteral<Map<String, MyApplet>>() {
                }));

        if (name == null || !applets.containsKey(name)) {
            throw new IllegalArgumentException("Unable to find applet."
                    + "Valid applets are "
                    + Joiner.on(", ").join(applets.keySet()));
        }

        return applets.get(name);
    }
}
