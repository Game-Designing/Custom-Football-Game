package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;

/* renamed from: com.google.android.gms.internal.ads._q */
final class C9304_q implements zzkc {

    /* renamed from: a */
    private final Uri f22056a;

    /* renamed from: b */
    private final zzjp f22057b;

    /* renamed from: c */
    private final zzid f22058c;

    /* renamed from: d */
    private final zzjr f22059d;

    /* renamed from: e */
    private final int f22060e;

    /* renamed from: f */
    private final zzij f22061f = new zzij();

    /* renamed from: g */
    private volatile boolean f22062g;

    /* renamed from: h */
    private boolean f22063h;

    public C9304_q(Uri uri, zzjp zzjp, zzid zzid, zzjr zzjr, int i, long j) {
        zzkh.m30534a(uri);
        this.f22056a = uri;
        zzkh.m30534a(zzjp);
        this.f22057b = zzjp;
        zzkh.m30534a(zzid);
        this.f22058c = zzid;
        zzkh.m30534a(zzjr);
        this.f22059d = zzjr;
        this.f22060e = i;
        this.f22061f.f28617a = j;
        this.f22063h = true;
    }

    /* renamed from: b */
    public final void mo28837b() {
        this.f22062g = true;
    }

    /* renamed from: a */
    public final boolean mo28836a() {
        return this.f22062g;
    }

    /* renamed from: c */
    public final void mo28838c() throws IOException, InterruptedException {
        long j;
        if (this.f22063h) {
            this.f22058c.mo31856a();
            this.f22063h = false;
        }
        int i = 0;
        while (i == 0 && !this.f22062g) {
            zzib zzib = null;
            try {
                long j2 = this.f22061f.f28617a;
                zzjp zzjp = this.f22057b;
                zzjq zzjq = new zzjq(this.f22056a, j2, -1, null);
                long a = zzjp.mo28817a(zzjq);
                if (a != -1) {
                    j = a + j2;
                } else {
                    j = a;
                }
                zzib zzib2 = new zzib(this.f22057b, j2, j);
                while (i == 0) {
                    try {
                        if (this.f22062g) {
                            break;
                        }
                        this.f22059d.mo31877a(this.f22060e);
                        i = this.f22058c.mo31855a(zzib2, this.f22061f);
                    } catch (Throwable th) {
                        th = th;
                        zzib = zzib2;
                        if (!(i == 1 || zzib == null)) {
                            this.f22061f.f28617a = zzib.getPosition();
                        }
                        this.f22057b.close();
                        throw th;
                    }
                }
                if (i == 1) {
                    i = 0;
                } else {
                    this.f22061f.f28617a = zzib2.getPosition();
                }
                this.f22057b.close();
            } catch (Throwable th2) {
                th = th2;
                this.f22061f.f28617a = zzib.getPosition();
                this.f22057b.close();
                throw th;
            }
        }
    }
}
