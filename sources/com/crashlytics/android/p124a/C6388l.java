package com.crashlytics.android.p124a;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;
import p024io.fabric.sdk.android.C0102l;
import p024io.fabric.sdk.android.C13920f;
import p024io.fabric.sdk.android.p348a.p351c.C13876e;
import p024io.fabric.sdk.android.p348a.p353e.C13888b;
import p024io.fabric.sdk.android.services.network.C13971g;

/* renamed from: com.crashlytics.android.a.l */
/* compiled from: AnswersEventsHandler */
class C6388l implements C13876e {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C0102l f11418a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Context f11419b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final C6389m f11420c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final C6376P f11421d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final C13971g f11422e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final C6402y f11423f;

    /* renamed from: g */
    final ScheduledExecutorService f11424g;

    /* renamed from: h */
    C6369K f11425h = new C6398u();

    public C6388l(C0102l kit, Context context, C6389m filesManagerProvider, C6376P metadataCollector, C13971g requestFactory, ScheduledExecutorService executor, C6402y firebaseAnalyticsApiAdapter) {
        this.f11418a = kit;
        this.f11419b = context;
        this.f11420c = filesManagerProvider;
        this.f11421d = metadataCollector;
        this.f11422e = requestFactory;
        this.f11424g = executor;
        this.f11423f = firebaseAnalyticsApiAdapter;
    }

    /* renamed from: a */
    public void mo19395a(C6372a eventBuilder) {
        mo19396a(eventBuilder, false, false);
    }

    /* renamed from: b */
    public void mo19400b(C6372a eventBuilder) {
        mo19396a(eventBuilder, false, true);
    }

    /* renamed from: c */
    public void mo19402c(C6372a eventBuilder) {
        mo19396a(eventBuilder, true, false);
    }

    /* renamed from: a */
    public void mo19397a(C13888b analyticsSettingsData, String protocolAndHostOverride) {
        m12352a((Runnable) new C6382f(this, analyticsSettingsData, protocolAndHostOverride));
    }

    /* renamed from: a */
    public void mo19394a() {
        m12352a((Runnable) new C6383g(this));
    }

    /* renamed from: a */
    public void mo19398a(String rolledOverFile) {
        m12352a((Runnable) new C6384h(this));
    }

    /* renamed from: b */
    public void mo19399b() {
        m12352a((Runnable) new C6385i(this));
    }

    /* renamed from: c */
    public void mo19401c() {
        m12352a((Runnable) new C6386j(this));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo19396a(C6372a eventBuilder, boolean sync, boolean flush) {
        Runnable runnable = new C6387k(this, eventBuilder, flush);
        if (sync) {
            m12354b(runnable);
        } else {
            m12352a(runnable);
        }
    }

    /* renamed from: b */
    private void m12354b(Runnable runnable) {
        try {
            this.f11424g.submit(runnable).get();
        } catch (Exception e) {
            C13920f.m44245e().mo43325b("Answers", "Failed to run events task", e);
        }
    }

    /* renamed from: a */
    private void m12352a(Runnable runnable) {
        try {
            this.f11424g.submit(runnable);
        } catch (Exception e) {
            C13920f.m44245e().mo43325b("Answers", "Failed to submit events task", e);
        }
    }
}
