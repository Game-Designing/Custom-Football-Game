package com.flurry.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;

/* renamed from: com.flurry.sdk.Fb */
public class C7379Fb {

    /* renamed from: a */
    private static final String f14429a = C7379Fb.class.getSimpleName();
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: b */
    private static C7379Fb f14430b;

    /* renamed from: c */
    private static boolean f14431c = false;

    /* renamed from: d */
    public final Context f14432d;

    /* renamed from: e */
    private final Handler f14433e = new Handler(Looper.getMainLooper());

    /* renamed from: f */
    private final Handler f14434f;

    /* renamed from: g */
    private final HandlerThread f14435g = new HandlerThread("FlurryAgent");

    /* renamed from: h */
    public final String f14436h;

    /* renamed from: i */
    private final C7525gc f14437i;

    private C7379Fb(Context context, String str) {
        this.f14432d = context.getApplicationContext();
        this.f14435g.start();
        this.f14434f = new Handler(this.f14435g.getLooper());
        this.f14436h = str;
        this.f14437i = new C7525gc();
    }

    /* renamed from: a */
    public static C7379Fb m16300a() {
        return f14430b;
    }

    /* renamed from: a */
    public static synchronized void m16301a(Context context, String str) {
        synchronized (C7379Fb.class) {
            if (f14430b != null) {
                if (f14430b.f14436h.equals(str)) {
                    C7513ec.m16651d(f14429a, "Flurry is already initialized");
                    return;
                }
                throw new IllegalStateException("Only one API key per application is supported!");
            } else if (context == null) {
                throw new IllegalArgumentException("Context cannot be null");
            } else if (!TextUtils.isEmpty(str)) {
                C7379Fb fb = new C7379Fb(context, str);
                f14430b = fb;
                fb.f14437i.mo23954a(context);
            } else {
                throw new IllegalArgumentException("API key must be specified");
            }
        }
    }

    /* renamed from: a */
    public final void mo23815a(Runnable runnable) {
        this.f14433e.post(runnable);
    }

    /* renamed from: b */
    public final void mo23817b(Runnable runnable) {
        this.f14434f.post(runnable);
    }

    /* renamed from: a */
    public final void mo23816a(Runnable runnable, long j) {
        if (runnable != null) {
            this.f14434f.postDelayed(runnable, j);
        }
    }

    /* renamed from: a */
    public final C7530hc mo23814a(Class<? extends C7530hc> cls) {
        return this.f14437i.mo23955b(cls);
    }

    /* renamed from: a */
    public static synchronized void m16302a(boolean z) {
        synchronized (C7379Fb.class) {
            f14431c = z;
        }
    }

    /* renamed from: b */
    public static synchronized boolean m16303b() {
        boolean z;
        synchronized (C7379Fb.class) {
            z = f14431c;
        }
        return z;
    }
}
