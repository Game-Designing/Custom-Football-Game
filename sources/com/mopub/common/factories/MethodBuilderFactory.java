package com.mopub.common.factories;

import com.mopub.common.util.Reflection.MethodBuilder;

public class MethodBuilderFactory {

    /* renamed from: a */
    protected static MethodBuilderFactory f34400a = new MethodBuilderFactory();

    @Deprecated
    public static void setInstance(MethodBuilderFactory factory) {
        f34400a = factory;
    }

    public static MethodBuilder create(Object object, String methodName) {
        return f34400a.mo36638a(object, methodName);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public MethodBuilder mo36638a(Object object, String methodName) {
        return new MethodBuilder(object, methodName);
    }
}
