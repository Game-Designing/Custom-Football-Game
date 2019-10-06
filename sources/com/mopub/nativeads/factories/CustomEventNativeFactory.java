package com.mopub.nativeads.factories;

import com.mopub.common.Preconditions;
import com.mopub.nativeads.CustomEventNative;
import com.mopub.nativeads.MoPubCustomEventNative;
import java.lang.reflect.Constructor;

public class CustomEventNativeFactory {

    /* renamed from: a */
    protected static CustomEventNativeFactory f36140a = new CustomEventNativeFactory();

    public static CustomEventNative create(String className) throws Exception {
        if (className == null) {
            return new MoPubCustomEventNative();
        }
        return f36140a.mo38162a(Class.forName(className).asSubclass(CustomEventNative.class));
    }

    @Deprecated
    public static void setInstance(CustomEventNativeFactory customEventNativeFactory) {
        Preconditions.checkNotNull(customEventNativeFactory);
        f36140a = customEventNativeFactory;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public CustomEventNative mo38162a(Class<? extends CustomEventNative> nativeClass) throws Exception {
        Preconditions.checkNotNull(nativeClass);
        Constructor<?> nativeConstructor = nativeClass.getDeclaredConstructor(null);
        nativeConstructor.setAccessible(true);
        return (CustomEventNative) nativeConstructor.newInstance(new Object[0]);
    }
}
