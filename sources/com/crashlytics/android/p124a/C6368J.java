package com.crashlytics.android.p124a;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.crashlytics.android.p124a.C6395s.C6396a;
import java.util.concurrent.ScheduledExecutorService;
import p024io.fabric.sdk.android.C0102l;
import p024io.fabric.sdk.android.C13914b;
import p024io.fabric.sdk.android.C13920f;
import p024io.fabric.sdk.android.C13929o;
import p024io.fabric.sdk.android.p348a.p350b.C13864u;
import p024io.fabric.sdk.android.p348a.p350b.C13868y;
import p024io.fabric.sdk.android.p348a.p352d.C13883b;
import p024io.fabric.sdk.android.p348a.p353e.C13888b;
import p024io.fabric.sdk.android.services.network.C13967c;

/* renamed from: com.crashlytics.android.a.J */
/* compiled from: SessionAnalyticsManager */
class C6368J implements C6396a {

    /* renamed from: a */
    private final long f11353a;

    /* renamed from: b */
    final C6388l f11354b;

    /* renamed from: c */
    final C13914b f11355c;

    /* renamed from: d */
    final C6395s f11356d;

    /* renamed from: e */
    final C6391o f11357e;

    /* renamed from: a */
    public static C6368J m12305a(C0102l kit, Context context, C13868y idManager, String versionCode, String versionName, long installedAt) {
        Context context2 = context;
        C6376P metadataCollector = new C6376P(context2, idManager, versionCode, versionName);
        C6389m filesManagerProvider = new C6389m(context2, new C13883b(kit));
        C13967c httpRequestFactory = new C13967c(C13920f.m44245e());
        C13914b lifecycleManager = new C13914b(context2);
        ScheduledExecutorService executorService = C13864u.m44078b("Answers Events Handler");
        C6395s backgroundManager = new C6395s(executorService);
        C6388l lVar = new C6388l(kit, context, filesManagerProvider, metadataCollector, httpRequestFactory, executorService, new C6402y(context2));
        ScheduledExecutorService scheduledExecutorService = executorService;
        C6368J j = new C6368J(lVar, lifecycleManager, backgroundManager, C6391o.m12376a(context), installedAt);
        return j;
    }

    C6368J(C6388l eventsHandler, C13914b lifecycleManager, C6395s backgroundManager, C6391o preferenceManager, long installedAt) {
        this.f11354b = eventsHandler;
        this.f11355c = lifecycleManager;
        this.f11356d = backgroundManager;
        this.f11357e = preferenceManager;
        this.f11353a = installedAt;
    }

    /* renamed from: c */
    public void mo19360c() {
        this.f11354b.mo19399b();
        this.f11355c.mo43318a(new C6390n(this, this.f11356d));
        this.f11356d.mo19417a((C6396a) this);
        if (mo19361d()) {
            mo19353a(this.f11353a);
            this.f11357e.mo19412b();
        }
    }

    /* renamed from: b */
    public void mo19359b() {
        this.f11355c.mo43317a();
        this.f11354b.mo19394a();
    }

    /* renamed from: a */
    public void mo19355a(C6397t event) {
        C13929o e = C13920f.m44245e();
        StringBuilder sb = new StringBuilder();
        sb.append("Logged custom event: ");
        sb.append(event);
        e.mo43326c("Answers", sb.toString());
        this.f11354b.mo19395a(C6371M.m12322a(event));
    }

    /* renamed from: a */
    public void mo19358a(String sessionId, String exceptionName) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            C13920f.m44245e().mo43326c("Answers", "Logged crash");
            this.f11354b.mo19402c(C6371M.m12324a(sessionId, exceptionName));
            return;
        }
        throw new IllegalStateException("onCrash called from main thread!!!");
    }

    /* renamed from: a */
    public void mo19357a(String sessionId) {
    }

    /* renamed from: a */
    public void mo19353a(long installedAt) {
        C13920f.m44245e().mo43326c("Answers", "Logged install");
        this.f11354b.mo19400b(C6371M.m12320a(installedAt));
    }

    /* renamed from: a */
    public void mo19354a(Activity activity, C6373b type) {
        C13929o e = C13920f.m44245e();
        StringBuilder sb = new StringBuilder();
        sb.append("Logged lifecycle event: ");
        sb.append(type.name());
        e.mo43326c("Answers", sb.toString());
        this.f11354b.mo19395a(C6371M.m12321a(type, activity));
    }

    /* renamed from: a */
    public void mo19352a() {
        C13920f.m44245e().mo43326c("Answers", "Flush events when app is backgrounded");
        this.f11354b.mo19401c();
    }

    /* renamed from: a */
    public void mo19356a(C13888b analyticsSettingsData, String protocolAndHostOverride) {
        this.f11356d.mo19418a(analyticsSettingsData.f42125j);
        this.f11354b.mo19397a(analyticsSettingsData, protocolAndHostOverride);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public boolean mo19361d() {
        return !this.f11357e.mo19411a();
    }
}
