package com.crashlytics.android.p126c;

import android.os.Bundle;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import p024io.fabric.sdk.android.C13920f;

/* renamed from: com.crashlytics.android.c.ja */
/* compiled from: DefaultAppMeasurementEventListenerRegistrar */
class C6497ja implements InvocationHandler {

    /* renamed from: a */
    final /* synthetic */ C6499ka f11667a;

    C6497ja(C6499ka this$0) {
        this.f11667a = this$0;
    }

    public Object invoke(Object proxy, Method method, Object[] args) {
        String methodName = method.getName();
        if (args == null) {
            args = new Object[0];
        }
        if (args.length == 1 && methodName.equals("equals")) {
            return Boolean.valueOf(mo19576a(proxy, args[0]));
        }
        if (args.length == 0 && methodName.equals("hashCode")) {
            return Integer.valueOf(super.hashCode());
        }
        if (args.length == 0 && methodName.equals("toString")) {
            return super.toString();
        }
        if (args.length == 4 && methodName.equals("onEvent") && C6499ka.m12733a(args)) {
            String origin = (String) args[0];
            String name = (String) args[1];
            Bundle params = (Bundle) args[2];
            if (origin != null && !origin.equals("crash")) {
                C6499ka.m12735b(this.f11667a.f11670b, name, params);
                return null;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unexpected method invoked on AppMeasurement.EventListener: ");
        sb.append(methodName);
        sb.append("(");
        StringBuilder error = new StringBuilder(sb.toString());
        for (int i = 0; i < args.length; i++) {
            if (i > 0) {
                error.append(", ");
            }
            error.append(args[i].getClass().getName());
        }
        error.append("); returning null");
        C13920f.m44245e().mo43324b("CrashlyticsCore", error.toString());
        return null;
    }

    /* renamed from: a */
    public boolean mo19576a(Object proxy, Object obj) {
        boolean z = true;
        if (proxy == obj) {
            return true;
        }
        if (obj == null || !Proxy.isProxyClass(obj.getClass()) || !super.equals(Proxy.getInvocationHandler(obj))) {
            z = false;
        }
        return z;
    }
}
