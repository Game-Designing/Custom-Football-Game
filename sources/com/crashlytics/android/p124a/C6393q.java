package com.crashlytics.android.p124a;

import android.content.Context;
import android.os.Bundle;
import java.lang.reflect.Method;

/* renamed from: com.crashlytics.android.a.q */
/* compiled from: AppMeasurementEventLogger */
public class C6393q implements C6401x {

    /* renamed from: a */
    private final Method f11433a;

    /* renamed from: b */
    private final Object f11434b;

    /* renamed from: a */
    public static C6401x m12381a(Context context) {
        Class instanceClass = m12383b(context);
        if (instanceClass == null) {
            return null;
        }
        Object instance = m12382a(context, instanceClass);
        if (instance == null) {
            return null;
        }
        Method logEventMethod = m12384b(context, instanceClass);
        if (logEventMethod == null) {
            return null;
        }
        return new C6393q(instance, logEventMethod);
    }

    /* renamed from: b */
    private static Class m12383b(Context context) {
        try {
            return context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement");
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: a */
    private static Object m12382a(Context context, Class instanceClass) {
        try {
            return instanceClass.getDeclaredMethod("getInstance", new Class[]{Context.class}).invoke(instanceClass, new Object[]{context});
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: b */
    private static Method m12384b(Context context, Class instanceClass) {
        try {
            return instanceClass.getDeclaredMethod("logEventInternal", new Class[]{String.class, String.class, Bundle.class});
        } catch (Exception e) {
            return null;
        }
    }

    public C6393q(Object logEventInstance, Method logEventMethod) {
        this.f11434b = logEventInstance;
        this.f11433a = logEventMethod;
    }

    /* renamed from: a */
    public void mo19413a(String eventName, Bundle metadata) {
        mo19414a("fab", eventName, metadata);
    }

    /* renamed from: a */
    public void mo19414a(String origin, String eventName, Bundle metadata) {
        try {
            this.f11433a.invoke(this.f11434b, new Object[]{origin, eventName, metadata});
        } catch (Exception e) {
        }
    }
}
