package com.crashlytics.android.p126c;

import android.content.Context;
import android.os.Bundle;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import p024io.fabric.sdk.android.C13920f;
import p024io.fabric.sdk.android.C13929o;

/* renamed from: com.crashlytics.android.c.ka */
/* compiled from: DefaultAppMeasurementEventListenerRegistrar */
class C6499ka implements C6476b {

    /* renamed from: a */
    private static final List<Class<?>> f11669a = Collections.unmodifiableList(Arrays.asList(new Class[]{String.class, String.class, Bundle.class, Long.class}));
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C6472aa f11670b;

    /* renamed from: c */
    private Object f11671c;

    public C6499ka(C6472aa crashlyticsCore) {
        this.f11670b = crashlyticsCore;
    }

    /* renamed from: a */
    public boolean mo19527a() {
        Class appMeasurementClass = m12730a("com.google.android.gms.measurement.AppMeasurement");
        String str = "CrashlyticsCore";
        if (appMeasurementClass == null) {
            C13920f.m44245e().mo43326c(str, "Firebase Analytics is not present; you will not see automatic logging of events before a crash occurs.");
            return false;
        }
        Object appMeasurementInstance = m12734b(appMeasurementClass);
        if (appMeasurementInstance == null) {
            C13920f.m44245e().mo43321a(str, "Cannot register AppMeasurement Listener for Crashlytics breadcrumbs: Could not create an instance of Firebase Analytics.");
            return false;
        }
        Class<?> onEventListenerClass = m12730a("com.google.android.gms.measurement.AppMeasurement$OnEventListener");
        if (onEventListenerClass == null) {
            C13920f.m44245e().mo43321a(str, "Cannot register AppMeasurement Listener for Crashlytics breadcrumbs: Could not get class com.google.android.gms.measurement.AppMeasurement$OnEventListener");
            return false;
        }
        try {
            appMeasurementClass.getDeclaredMethod("registerOnMeasurementEventListener", new Class[]{onEventListenerClass}).invoke(appMeasurementInstance, new Object[]{mo19579a((Class) onEventListenerClass)});
        } catch (NoSuchMethodException e) {
            C13920f.m44245e().mo43322a(str, "Cannot register AppMeasurement Listener for Crashlytics breadcrumbs: Method registerOnMeasurementEventListener not found.", (Throwable) e);
            return false;
        } catch (Exception e2) {
            C13929o e3 = C13920f.m44245e();
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot register AppMeasurement Listener for Crashlytics breadcrumbs: ");
            sb.append(e2.getMessage());
            e3.mo43322a(str, sb.toString(), (Throwable) e2);
        }
        return true;
    }

    /* renamed from: a */
    private Class<?> m12730a(String clazz) {
        try {
            return this.f11670b.mo3307i().getClassLoader().loadClass(clazz);
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: b */
    private Object m12734b(Class<?> instanceClass) {
        try {
            return instanceClass.getDeclaredMethod("getInstance", new Class[]{Context.class}).invoke(instanceClass, new Object[]{this.f11670b.mo3307i()});
        } catch (Exception e) {
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public synchronized Object mo19579a(Class appMeasurementEventListenerClass) {
        if (this.f11671c == null) {
            this.f11671c = Proxy.newProxyInstance(this.f11670b.mo3307i().getClassLoader(), new Class[]{appMeasurementEventListenerClass}, new C6497ja(this));
        }
        return this.f11671c;
    }

    /* renamed from: a */
    static boolean m12733a(Object[] args) {
        if (args.length != f11669a.size()) {
            return false;
        }
        Iterator<Class<?>> typeItr = f11669a.iterator();
        for (Object arg : args) {
            if (!arg.getClass().equals(typeItr.next())) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m12735b(C6472aa crashlyticsCore, String name, Bundle params) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("$A$:");
            sb.append(m12731a(name, params));
            crashlyticsCore.mo19519a(sb.toString());
        } catch (JSONException e) {
            C13929o e2 = C13920f.m44245e();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unable to serialize Firebase Analytics event; ");
            sb2.append(name);
            e2.mo43321a("CrashlyticsCore", sb2.toString());
        }
    }

    /* renamed from: a */
    private static String m12731a(String name, Bundle params) throws JSONException {
        JSONObject enclosingObject = new JSONObject();
        JSONObject paramsObject = new JSONObject();
        for (String key : params.keySet()) {
            paramsObject.put(key, params.get(key));
        }
        enclosingObject.put("name", name);
        enclosingObject.put("parameters", paramsObject);
        return enclosingObject.toString();
    }
}
