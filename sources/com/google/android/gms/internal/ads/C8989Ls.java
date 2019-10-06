package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;

/* renamed from: com.google.android.gms.internal.ads.Ls */
final class C8989Ls implements zzsh {

    /* renamed from: a */
    private final Uri f21454a;

    /* renamed from: b */
    private final zzrv f21455b;

    /* renamed from: c */
    private final C9010Ms f21456c;

    /* renamed from: d */
    private final zzsm f21457d;

    /* renamed from: e */
    private final zznt f21458e = new zznt();

    /* renamed from: f */
    private volatile boolean f21459f;

    /* renamed from: g */
    private boolean f21460g = true;

    /* renamed from: h */
    private long f21461h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public long f21462i = -1;

    /* renamed from: j */
    private final /* synthetic */ C8884Gs f21463j;

    public C8989Ls(C8884Gs gs, Uri uri, zzrv zzrv, C9010Ms ms, zzsm zzsm) {
        this.f21463j = gs;
        zzsk.m31078a(uri);
        this.f21454a = uri;
        zzsk.m31078a(zzrv);
        this.f21455b = zzrv;
        zzsk.m31078a(ms);
        this.f21456c = ms;
        this.f21457d = zzsm;
    }

    /* renamed from: a */
    public final void mo28445a(long j, long j2) {
        this.f21458e.f28979a = j;
        this.f21461h = j2;
        this.f21460g = true;
    }

    /* renamed from: b */
    public final void mo28447b() {
        this.f21459f = true;
    }

    /* renamed from: a */
    public final boolean mo28446a() {
        return this.f21459f;
    }

    /* renamed from: c */
    public final void mo28448c() throws IOException, InterruptedException {
        zznm zznm;
        int i = 0;
        while (i == 0 && !this.f21459f) {
            try {
                long j = this.f21458e.f28979a;
                zzrv zzrv = this.f21455b;
                zzry zzry = new zzry(this.f21454a, j, -1, this.f21463j.f21098h);
                this.f21462i = zzrv.mo29017a(zzry);
                if (this.f21462i != -1) {
                    this.f21462i += j;
                }
                zznm = new zznm(this.f21455b, j, this.f21462i);
                try {
                    zznn a = this.f21456c.mo28457a(zznm, this.f21455b.getUri());
                    if (this.f21460g) {
                        a.mo32056a(j, this.f21461h);
                        this.f21460g = false;
                    }
                    while (i == 0 && !this.f21459f) {
                        this.f21457d.mo32187a();
                        i = a.mo32054a((zzno) zznm, this.f21458e);
                        if (zznm.getPosition() > this.f21463j.f21099i + j) {
                            j = zznm.getPosition();
                            this.f21457d.mo32189c();
                            this.f21463j.f21105o.post(this.f21463j.f21104n);
                        }
                    }
                    if (i == 1) {
                        i = 0;
                    } else {
                        this.f21458e.f28979a = zznm.getPosition();
                    }
                    zzsy.m31151a(this.f21455b);
                } catch (Throwable th) {
                    th = th;
                    if (!(i == 1 || zznm == null)) {
                        this.f21458e.f28979a = zznm.getPosition();
                    }
                    zzsy.m31151a(this.f21455b);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                zznm = null;
                this.f21458e.f28979a = zznm.getPosition();
                zzsy.m31151a(this.f21455b);
                throw th;
            }
        }
    }
}
