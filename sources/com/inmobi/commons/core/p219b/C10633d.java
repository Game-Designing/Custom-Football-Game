package com.inmobi.commons.core.p219b;

import com.inmobi.commons.core.p220c.C10636a;
import com.inmobi.commons.core.p220c.C10638b;
import com.inmobi.commons.core.utilities.p225b.C10691b;
import com.inmobi.commons.core.utilities.uid.C10711d;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import p005cm.aptoide.p006pt.BuildConfig;

/* renamed from: com.inmobi.commons.core.b.d */
/* compiled from: EventProcessor */
public class C10633d implements C10638b {

    /* renamed from: a */
    private static final String f32407a = C10633d.class.getSimpleName();

    /* renamed from: b */
    private AtomicBoolean f32408b = new AtomicBoolean(false);

    /* renamed from: c */
    private AtomicBoolean f32409c = new AtomicBoolean(false);

    /* renamed from: d */
    private C10631b f32410d;

    /* renamed from: e */
    private C10635e f32411e;

    /* renamed from: f */
    private HashMap<String, C10630a> f32412f = new HashMap<>(1);

    /* renamed from: g */
    private List<String> f32413g = new LinkedList();

    /* renamed from: h */
    private ScheduledExecutorService f32414h;

    /* renamed from: a */
    static /* synthetic */ void m34891a(C10633d dVar, String str, C10711d dVar2) {
        int i;
        long j;
        if (!dVar.f32409c.get() && !dVar.f32408b.get()) {
            dVar.f32410d.mo34432b(dVar.m34892b(str).f32392a, str);
            int a = dVar.f32410d.mo34428a(str);
            int a2 = C10691b.m35099a();
            if (a2 != 1) {
                i = dVar.m34892b(str).f32400i;
            } else {
                i = dVar.m34892b(str).f32398g;
            }
            if (a2 != 1) {
                j = dVar.m34892b(str).f32401j;
            } else {
                j = dVar.m34892b(str).f32399h;
            }
            if (i <= a || dVar.f32410d.mo34431a(dVar.m34892b(str).f32394c, str) || dVar.f32410d.mo34430a(dVar.m34892b(str).f32397f, dVar.m34892b(str).f32394c, str)) {
                C10632c a3 = dVar.f32411e.mo34417a(str);
                if (a3 != null) {
                    dVar.f32408b.set(true);
                    C10630a b = dVar.m34892b(str);
                    int i2 = b.f32395d + 1;
                    C10636a.m34899a().mo34445a(a3, b.f32396e, i2, i2, j, dVar2, dVar);
                }
            }
        }
    }

    public C10633d(C10631b bVar, C10635e eVar, C10630a aVar) {
        this.f32410d = bVar;
        this.f32411e = eVar;
        mo34440a(aVar);
    }

    /* renamed from: a */
    public final void mo34439a() {
        ScheduledExecutorService scheduledExecutorService = this.f32414h;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
            this.f32414h = null;
        }
        this.f32408b.set(false);
        this.f32409c.set(true);
        this.f32413g.clear();
        this.f32412f.clear();
    }

    /* renamed from: a */
    public final void mo34440a(C10630a aVar) {
        String str = aVar.f32393b;
        if (str == null) {
            str = BuildConfig.APTOIDE_THEME;
        }
        this.f32412f.put(str, aVar);
    }

    /* renamed from: a */
    public final void mo34443a(final String str) {
        if (!this.f32409c.get()) {
            if (str == null) {
                str = BuildConfig.APTOIDE_THEME;
            }
            long j = m34892b(str).f32397f;
            if (!this.f32413g.contains(str)) {
                this.f32413g.add(str);
                if (this.f32414h == null) {
                    this.f32414h = Executors.newSingleThreadScheduledExecutor();
                }
                ScheduledExecutorService scheduledExecutorService = this.f32414h;
                C106341 r2 = new Runnable() {

                    /* renamed from: b */
                    final /* synthetic */ C10711d f32416b = null;

                    public final void run() {
                        C10633d.m34891a(C10633d.this, str, this.f32416b);
                    }
                };
                C10630a b = m34892b(str);
                long b2 = this.f32410d.mo34433b(str);
                if (b2 == -1) {
                    this.f32410d.mo34434c(System.currentTimeMillis(), str);
                }
                long seconds = TimeUnit.MILLISECONDS.toSeconds(b2) + b.f32397f;
                scheduledExecutorService.scheduleAtFixedRate(r2, seconds - TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()) > 0 ? seconds - TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()) : 0, j, TimeUnit.SECONDS);
            }
        }
    }

    /* renamed from: b */
    private C10630a m34892b(String str) {
        return (C10630a) this.f32412f.get(str);
    }

    /* renamed from: a */
    public final void mo34441a(C10632c cVar) {
        String b = this.f32410d.mo34438b(((Integer) cVar.f32404a.get(0)).intValue());
        this.f32410d.mo34429a(cVar.f32404a);
        if (b != null) {
            this.f32410d.mo34434c(System.currentTimeMillis(), b);
            this.f32408b.set(false);
        }
    }

    /* renamed from: a */
    public final void mo34442a(C10632c cVar, boolean z) {
        String b = this.f32410d.mo34438b(((Integer) cVar.f32404a.get(0)).intValue());
        if (cVar.f32406c && z) {
            this.f32410d.mo34429a(cVar.f32404a);
        }
        if (b != null) {
            this.f32410d.mo34434c(System.currentTimeMillis(), b);
            this.f32408b.set(false);
        }
    }
}
