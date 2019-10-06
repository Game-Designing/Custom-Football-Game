package com.crashlytics.android.p126c;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.atomic.AtomicBoolean;
import p024io.fabric.sdk.android.C13920f;
import p024io.fabric.sdk.android.p348a.p353e.C13909v;

/* renamed from: com.crashlytics.android.c.ga */
/* compiled from: CrashlyticsUncaughtExceptionHandler */
class C6488ga implements UncaughtExceptionHandler {

    /* renamed from: a */
    private final C6489a f11653a;

    /* renamed from: b */
    private final C6490b f11654b;

    /* renamed from: c */
    private final boolean f11655c;

    /* renamed from: d */
    private final UncaughtExceptionHandler f11656d;

    /* renamed from: e */
    private final AtomicBoolean f11657e = new AtomicBoolean(false);

    /* renamed from: com.crashlytics.android.c.ga$a */
    /* compiled from: CrashlyticsUncaughtExceptionHandler */
    interface C6489a {
        /* renamed from: a */
        void mo19470a(C6490b bVar, Thread thread, Throwable th, boolean z);
    }

    /* renamed from: com.crashlytics.android.c.ga$b */
    /* compiled from: CrashlyticsUncaughtExceptionHandler */
    interface C6490b {
        /* renamed from: a */
        C13909v mo19499a();
    }

    public C6488ga(C6489a crashListener, C6490b settingsDataProvider, boolean firebaseCrashlyticsClientFlag, UncaughtExceptionHandler defaultHandler) {
        this.f11653a = crashListener;
        this.f11654b = settingsDataProvider;
        this.f11655c = firebaseCrashlyticsClientFlag;
        this.f11656d = defaultHandler;
    }

    public void uncaughtException(Thread thread, Throwable ex) {
        String str = "Crashlytics completed exception processing. Invoking default exception handler.";
        String str2 = "CrashlyticsCore";
        this.f11657e.set(true);
        try {
            this.f11653a.mo19470a(this.f11654b, thread, ex, this.f11655c);
        } catch (Exception e) {
            C13920f.m44245e().mo43325b(str2, "An error occurred in the uncaught exception handler", e);
        } catch (Throwable th) {
            C13920f.m44245e().mo43326c(str2, str);
            this.f11656d.uncaughtException(thread, ex);
            this.f11657e.set(false);
            throw th;
        }
        C13920f.m44245e().mo43326c(str2, str);
        this.f11656d.uncaughtException(thread, ex);
        this.f11657e.set(false);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo19547a() {
        return this.f11657e.get();
    }
}
