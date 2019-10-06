package com.google.android.gms.internal.ads;

import java.lang.Thread.UncaughtExceptionHandler;

/* renamed from: com.google.android.gms.internal.ads.pb */
final class C9640pb implements UncaughtExceptionHandler {

    /* renamed from: a */
    private final /* synthetic */ UncaughtExceptionHandler f22859a;

    /* renamed from: b */
    private final /* synthetic */ zzaqx f22860b;

    C9640pb(zzaqx zzaqx, UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f22860b = zzaqx;
        this.f22859a = uncaughtExceptionHandler;
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        try {
            this.f22860b.mo30005a(thread, th);
            UncaughtExceptionHandler uncaughtExceptionHandler = this.f22859a;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            }
        } catch (Throwable th2) {
            UncaughtExceptionHandler uncaughtExceptionHandler2 = this.f22859a;
            if (uncaughtExceptionHandler2 != null) {
                uncaughtExceptionHandler2.uncaughtException(thread, th);
            }
            throw th2;
        }
    }
}
