package com.crashlytics.android.p124a;

import android.content.Context;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p024io.fabric.sdk.android.C0102l;
import p024io.fabric.sdk.android.C13920f;
import p024io.fabric.sdk.android.C13929o;
import p024io.fabric.sdk.android.p348a.p350b.C13849i;
import p024io.fabric.sdk.android.p348a.p350b.C13852l;
import p024io.fabric.sdk.android.p348a.p351c.C13878g;
import p024io.fabric.sdk.android.p348a.p351c.C13881j;
import p024io.fabric.sdk.android.p348a.p353e.C13888b;
import p024io.fabric.sdk.android.services.network.C13971g;

/* renamed from: com.crashlytics.android.a.v */
/* compiled from: EnabledSessionAnalyticsManagerStrategy */
class C6399v implements C6369K {

    /* renamed from: a */
    private final C0102l f11442a;

    /* renamed from: b */
    private final C13971g f11443b;

    /* renamed from: c */
    private final Context f11444c;

    /* renamed from: d */
    private final C6366H f11445d;

    /* renamed from: e */
    private final ScheduledExecutorService f11446e;

    /* renamed from: f */
    private final AtomicReference<ScheduledFuture<?>> f11447f = new AtomicReference<>();

    /* renamed from: g */
    final C6374N f11448g;

    /* renamed from: h */
    private final C6402y f11449h;

    /* renamed from: i */
    C13878g f11450i;

    /* renamed from: j */
    C13849i f11451j = new C13849i();

    /* renamed from: k */
    C6400w f11452k = new C6360B();

    /* renamed from: l */
    boolean f11453l = true;

    /* renamed from: m */
    boolean f11454m = true;

    /* renamed from: n */
    volatile int f11455n = -1;

    /* renamed from: o */
    boolean f11456o = false;

    /* renamed from: p */
    boolean f11457p = false;

    public C6399v(C0102l kit, Context context, ScheduledExecutorService executor, C6366H filesManager, C13971g httpRequestFactory, C6374N metadata, C6402y firebaseAnalyticsApiAdapter) {
        this.f11442a = kit;
        this.f11444c = context;
        this.f11446e = executor;
        this.f11445d = filesManager;
        this.f11443b = httpRequestFactory;
        this.f11448g = metadata;
        this.f11449h = firebaseAnalyticsApiAdapter;
    }

    /* renamed from: a */
    public void mo19363a(C13888b analyticsSettingsData, String protocolAndHostOverride) {
        C6367I i = new C6367I(this.f11442a, protocolAndHostOverride, analyticsSettingsData.f42116a, this.f11443b, this.f11451j.mo43240d(this.f11444c));
        this.f11450i = C6392p.m12379a(i);
        this.f11445d.mo19347a(analyticsSettingsData);
        this.f11456o = analyticsSettingsData.f42121f;
        this.f11457p = analyticsSettingsData.f42122g;
        C13929o e = C13920f.m44245e();
        StringBuilder sb = new StringBuilder();
        sb.append("Firebase analytics forwarding ");
        String str = "enabled";
        String str2 = "disabled";
        sb.append(this.f11456o ? str : str2);
        String str3 = "Answers";
        e.mo43326c(str3, sb.toString());
        C13929o e2 = C13920f.m44245e();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Firebase analytics including purchase events ");
        sb2.append(this.f11457p ? str : str2);
        e2.mo43326c(str3, sb2.toString());
        this.f11453l = analyticsSettingsData.f42123h;
        C13929o e3 = C13920f.m44245e();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Custom event tracking ");
        sb3.append(this.f11453l ? str : str2);
        e3.mo43326c(str3, sb3.toString());
        this.f11454m = analyticsSettingsData.f42124i;
        C13929o e4 = C13920f.m44245e();
        StringBuilder sb4 = new StringBuilder();
        sb4.append("Predefined event tracking ");
        if (!this.f11454m) {
            str = str2;
        }
        sb4.append(str);
        e4.mo43326c(str3, sb4.toString());
        if (analyticsSettingsData.f42126k > 1) {
            C13920f.m44245e().mo43326c(str3, "Event sampling enabled");
            this.f11452k = new C6365G(analyticsSettingsData.f42126k);
        }
        this.f11455n = analyticsSettingsData.f42117b;
        mo19424a(0, (long) this.f11455n);
    }

    /* renamed from: a */
    public void mo19362a(C6372a builder) {
        C6371M event = builder.mo19369a(this.f11448g);
        String str = "Answers";
        if (!this.f11453l && C6373b.CUSTOM.equals(event.f11360c)) {
            C13929o e = C13920f.m44245e();
            StringBuilder sb = new StringBuilder();
            sb.append("Custom events tracking disabled - skipping event: ");
            sb.append(event);
            e.mo43326c(str, sb.toString());
        } else if (!this.f11454m && C6373b.PREDEFINED.equals(event.f11360c)) {
            C13929o e2 = C13920f.m44245e();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Predefined events tracking disabled - skipping event: ");
            sb2.append(event);
            e2.mo43326c(str, sb2.toString());
        } else if (this.f11452k.mo19341a(event)) {
            C13929o e3 = C13920f.m44245e();
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Skipping filtered event: ");
            sb3.append(event);
            e3.mo43326c(str, sb3.toString());
        } else {
            try {
                this.f11445d.mo43276a(event);
            } catch (IOException e4) {
                C13929o e5 = C13920f.m44245e();
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Failed to write event: ");
                sb4.append(event);
                e5.mo43325b(str, sb4.toString(), e4);
            }
            mo19425e();
            boolean isCustomOrPredefinedEvent = C6373b.CUSTOM.equals(event.f11360c) || C6373b.PREDEFINED.equals(event.f11360c);
            boolean isPurchaseEvent = "purchase".equals(event.f11364g);
            if (this.f11456o && isCustomOrPredefinedEvent) {
                if (!isPurchaseEvent || this.f11457p) {
                    try {
                        this.f11449h.mo19427a(event);
                    } catch (Exception e6) {
                        C13929o e7 = C13920f.m44245e();
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("Failed to map event to Firebase: ");
                        sb5.append(event);
                        e7.mo43325b(str, sb5.toString(), e6);
                    }
                }
            }
        }
    }

    /* renamed from: e */
    public void mo19425e() {
        if (this.f11455n != -1) {
            mo19424a((long) this.f11455n, (long) this.f11455n);
        }
    }

    /* renamed from: c */
    public void mo19364c() {
        if (this.f11450i == null) {
            C13852l.m44049c(this.f11444c, "skipping files send because we don't yet know the target endpoint");
            return;
        }
        C13852l.m44049c(this.f11444c, "Sending all files");
        int filesSent = 0;
        List d = this.f11445d.mo43279d();
        while (true) {
            try {
                if (d.size() <= 0) {
                    break;
                }
                C13852l.m44049c(this.f11444c, String.format(Locale.US, "attempt to send batch of %d files", new Object[]{Integer.valueOf(d.size())}));
                boolean cleanup = this.f11450i.mo19351a(d);
                if (cleanup) {
                    filesSent += d.size();
                    this.f11445d.mo43277a(d);
                }
                if (!cleanup) {
                    break;
                }
                d = this.f11445d.mo43279d();
            } catch (Exception e) {
                Context context = this.f11444c;
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to send batch of analytics files to server: ");
                sb.append(e.getMessage());
                C13852l.m44034a(context, sb.toString(), (Throwable) e);
            }
        }
        if (filesSent == 0) {
            this.f11445d.mo43278b();
        }
    }

    /* renamed from: b */
    public void mo19423b() {
        if (this.f11447f.get() != null) {
            C13852l.m44049c(this.f11444c, "Cancelling time-based rollover because no events are currently being generated.");
            ((ScheduledFuture) this.f11447f.get()).cancel(false);
            this.f11447f.set(null);
        }
    }

    /* renamed from: d */
    public void mo19365d() {
        this.f11445d.mo43274a();
    }

    /* renamed from: a */
    public boolean mo19422a() {
        try {
            return this.f11445d.mo43280g();
        } catch (IOException e) {
            C13852l.m44034a(this.f11444c, "Failed to roll file over.", (Throwable) e);
            return false;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo19424a(long initialDelaySecs, long frequencySecs) {
        if (this.f11447f.get() == null) {
            Runnable rollOverRunnable = new C13881j(this.f11444c, this);
            Context context = this.f11444c;
            StringBuilder sb = new StringBuilder();
            sb.append("Scheduling time based file roll over every ");
            sb.append(frequencySecs);
            sb.append(" seconds");
            C13852l.m44049c(context, sb.toString());
            try {
                this.f11447f.set(this.f11446e.scheduleAtFixedRate(rollOverRunnable, initialDelaySecs, frequencySecs, TimeUnit.SECONDS));
            } catch (RejectedExecutionException e) {
                C13852l.m44034a(this.f11444c, "Failed to schedule time based file roll over", (Throwable) e);
            }
        }
    }
}
