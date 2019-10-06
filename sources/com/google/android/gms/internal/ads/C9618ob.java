package com.google.android.gms.internal.ads;

import java.lang.Thread.UncaughtExceptionHandler;

/* renamed from: com.google.android.gms.internal.ads.ob */
final class C9618ob implements UncaughtExceptionHandler {

    /* renamed from: a */
    private final /* synthetic */ UncaughtExceptionHandler f22829a;

    /* renamed from: b */
    private final /* synthetic */ zzaqx f22830b;

    C9618ob(zzaqx zzaqx, UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f22830b = zzaqx;
        this.f22829a = uncaughtExceptionHandler;
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        try {
            this.f22830b.mo30005a(thread, th);
            UncaughtExceptionHandler uncaughtExceptionHandler = this.f22829a;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            }
        } catch (Throwable th2) {
            UncaughtExceptionHandler uncaughtExceptionHandler2 = this.f22829a;
            if (uncaughtExceptionHandler2 != null) {
                uncaughtExceptionHandler2.uncaughtException(thread, th);
            }
            throw th2;
        }
    }
}
