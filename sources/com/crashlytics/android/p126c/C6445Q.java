package com.crashlytics.android.p126c;

import java.util.Date;
import java.util.concurrent.Callable;
import p024io.fabric.sdk.android.p348a.p350b.C13858o;
import p024io.fabric.sdk.android.p348a.p353e.C13900n;
import p024io.fabric.sdk.android.p348a.p353e.C13903q;
import p024io.fabric.sdk.android.p348a.p353e.C13909v;

/* renamed from: com.crashlytics.android.c.Q */
/* compiled from: CrashlyticsController */
class C6445Q implements Callable<Void> {

    /* renamed from: a */
    final /* synthetic */ Date f11546a;

    /* renamed from: b */
    final /* synthetic */ Thread f11547b;

    /* renamed from: c */
    final /* synthetic */ Throwable f11548c;

    /* renamed from: d */
    final /* synthetic */ C6490b f11549d;

    /* renamed from: e */
    final /* synthetic */ boolean f11550e;

    /* renamed from: f */
    final /* synthetic */ C6452U f11551f;

    C6445Q(C6452U this$0, Date date, Thread thread, Throwable th, C6490b bVar, boolean z) {
        this.f11551f = this$0;
        this.f11546a = date;
        this.f11547b = thread;
        this.f11548c = th;
        this.f11549d = bVar;
        this.f11550e = z;
    }

    public Void call() throws Exception {
        this.f11551f.f11573j.mo19510A();
        this.f11551f.m12551b(this.f11546a, this.f11547b, this.f11548c);
        C13909v settingsData = this.f11549d.mo19499a();
        C13903q sessionSettings = null;
        C13900n featuresSettings = null;
        if (settingsData != null) {
            sessionSettings = settingsData.f42192b;
            featuresSettings = settingsData.f42194d;
        }
        boolean sendReports = false;
        if ((featuresSettings == null || featuresSettings.f42163e) || this.f11550e) {
            this.f11551f.m12513a(this.f11546a.getTime());
        }
        this.f11551f.mo19479a(sessionSettings);
        this.f11551f.m12570m();
        if (sessionSettings != null) {
            this.f11551f.mo19476a(sessionSettings.f42181g);
        }
        if (C13858o.m44068a(this.f11551f.f11573j.mo3307i()).mo43247a() && !this.f11551f.m12559c(settingsData)) {
            sendReports = true;
        }
        if (sendReports) {
            this.f11551f.m12550b(settingsData);
        }
        return null;
    }
}
