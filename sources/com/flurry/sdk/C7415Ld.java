package com.flurry.sdk;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* renamed from: com.flurry.sdk.Ld */
public final class C7415Ld {

    /* renamed from: a */
    private static C7415Ld f14537a;

    /* renamed from: b */
    final UncaughtExceptionHandler f14538b = Thread.getDefaultUncaughtExceptionHandler();

    /* renamed from: c */
    final Map<UncaughtExceptionHandler, Void> f14539c = new WeakHashMap();

    /* renamed from: com.flurry.sdk.Ld$a */
    final class C7416a implements UncaughtExceptionHandler {
        private C7416a() {
        }

        /* synthetic */ C7416a(C7415Ld ld, byte b) {
            this();
        }

        public final void uncaughtException(Thread thread, Throwable th) {
            for (UncaughtExceptionHandler uncaughtException : C7415Ld.this.mo23857b()) {
                try {
                    uncaughtException.uncaughtException(thread, th);
                } catch (Throwable th2) {
                }
            }
            UncaughtExceptionHandler uncaughtExceptionHandler = C7415Ld.this.f14538b;
            if (uncaughtExceptionHandler != null) {
                try {
                    uncaughtExceptionHandler.uncaughtException(thread, th);
                } catch (Throwable th3) {
                }
            }
        }
    }

    private C7415Ld() {
        Thread.setDefaultUncaughtExceptionHandler(new C7416a(this, 0));
    }

    /* renamed from: a */
    public static synchronized C7415Ld m16411a() {
        C7415Ld ld;
        synchronized (C7415Ld.class) {
            if (f14537a == null) {
                f14537a = new C7415Ld();
            }
            ld = f14537a;
        }
        return ld;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final Set<UncaughtExceptionHandler> mo23857b() {
        Set<UncaughtExceptionHandler> keySet;
        synchronized (this.f14539c) {
            keySet = this.f14539c.keySet();
        }
        return keySet;
    }
}
