package com.mopub.mobileads.factories;

import com.mopub.mobileads.CustomEventBanner;
import java.lang.reflect.Constructor;

public class CustomEventBannerFactory {

    /* renamed from: a */
    private static CustomEventBannerFactory f35260a = new CustomEventBannerFactory();

    public static CustomEventBanner create(String className) throws Exception {
        return f35260a.mo37462a(className);
    }

    @Deprecated
    public static void setInstance(CustomEventBannerFactory factory) {
        f35260a = factory;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public CustomEventBanner mo37462a(String className) throws Exception {
        Constructor<?> bannerConstructor = Class.forName(className).asSubclass(CustomEventBanner.class).getDeclaredConstructor(null);
        bannerConstructor.setAccessible(true);
        return (CustomEventBanner) bannerConstructor.newInstance(new Object[0]);
    }
}
