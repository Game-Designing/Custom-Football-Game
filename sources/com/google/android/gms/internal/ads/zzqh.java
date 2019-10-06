package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import java.io.IOException;

public final class zzqh implements zzql, zzqm {

    /* renamed from: a */
    private final Uri f29151a;

    /* renamed from: b */
    private final zzrw f29152b;

    /* renamed from: c */
    private final zznq f29153c;

    /* renamed from: d */
    private final int f29154d = -1;

    /* renamed from: e */
    private final Handler f29155e;

    /* renamed from: f */
    private final zzqi f29156f;

    /* renamed from: g */
    private final zzlt f29157g;

    /* renamed from: h */
    private final String f29158h;

    /* renamed from: i */
    private final int f29159i;

    /* renamed from: j */
    private zzqm f29160j;

    /* renamed from: k */
    private zzlr f29161k;

    /* renamed from: l */
    private boolean f29162l;

    public zzqh(Uri uri, zzrw zzrw, zznq zznq, int i, Handler handler, zzqi zzqi, String str, int i2) {
        this.f29151a = uri;
        this.f29152b = zzrw;
        this.f29153c = zznq;
        this.f29155e = handler;
        this.f29156f = zzqi;
        this.f29158h = null;
        this.f29159i = i2;
        this.f29157g = new zzlt();
    }

    /* renamed from: a */
    public final void mo32106a(zzkv zzkv, boolean z, zzqm zzqm) {
        this.f29160j = zzqm;
        this.f29161k = new zzqz(-9223372036854775807L, false);
        zzqm.mo28528a(this.f29161k, null);
    }

    /* renamed from: b */
    public final void mo32108b() throws IOException {
    }

    /* renamed from: a */
    public final zzqj mo32104a(int i, zzrt zzrt) {
        zzsk.m31080a(i == 0);
        C8884Gs gs = new C8884Gs(this.f29151a, this.f29152b.mo29060a(), this.f29153c.mo28902a(), this.f29154d, this.f29155e, this.f29156f, this, zzrt, null, this.f29159i);
        return gs;
    }

    /* renamed from: a */
    public final void mo32107a(zzqj zzqj) {
        ((C8884Gs) zzqj).mo28302g();
    }

    /* renamed from: a */
    public final void mo32105a() {
        this.f29160j = null;
    }

    /* renamed from: a */
    public final void mo28528a(zzlr zzlr, Object obj) {
        boolean z = false;
        if (zzlr.mo28170a(0, this.f29157g, false).f28819d != -9223372036854775807L) {
            z = true;
        }
        if (!this.f29162l || z) {
            this.f29161k = zzlr;
            this.f29162l = z;
            this.f29160j.mo28528a(this.f29161k, null);
        }
    }
}
