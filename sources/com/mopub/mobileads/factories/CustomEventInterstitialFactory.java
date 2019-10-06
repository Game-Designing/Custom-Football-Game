package com.mopub.mobileads.factories;

import com.mopub.mobileads.CustomEventInterstitial;
import java.lang.reflect.Constructor;

public class CustomEventInterstitialFactory {

    /* renamed from: a */
    private static CustomEventInterstitialFactory f35262a = new CustomEventInterstitialFactory();

    public static CustomEventInterstitial create(String className) throws Exception {
        return f35262a.mo37464a(className);
    }

    @Deprecated
    public static void setInstance(CustomEventInterstitialFactory factory) {
        f35262a = factory;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public CustomEventInterstitial mo37464a(String className) throws Exception {
        Constructor<?> interstitialConstructor = Class.forName(className).asSubclass(CustomEventInterstitial.class).getDeclaredConstructor(null);
        interstitialConstructor.setAccessible(true);
        return (CustomEventInterstitial) interstitialConstructor.newInstance(new Object[0]);
    }
}
