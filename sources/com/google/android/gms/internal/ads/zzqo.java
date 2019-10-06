package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public final class zzqo implements zzql {

    /* renamed from: a */
    private final zzql[] f29163a;

    /* renamed from: b */
    private final ArrayList<zzql> f29164b;

    /* renamed from: c */
    private final zzlu f29165c = new zzlu();

    /* renamed from: d */
    private zzqm f29166d;

    /* renamed from: e */
    private zzlr f29167e;

    /* renamed from: f */
    private Object f29168f;

    /* renamed from: g */
    private int f29169g = -1;

    /* renamed from: h */
    private zzqq f29170h;

    public zzqo(zzql... zzqlArr) {
        this.f29163a = zzqlArr;
        this.f29164b = new ArrayList<>(Arrays.asList(zzqlArr));
    }

    /* renamed from: a */
    public final void mo32106a(zzkv zzkv, boolean z, zzqm zzqm) {
        this.f29166d = zzqm;
        int i = 0;
        while (true) {
            zzql[] zzqlArr = this.f29163a;
            if (i < zzqlArr.length) {
                zzqlArr[i].mo32106a(zzkv, false, new C9073Ps(this, i));
                i++;
            } else {
                return;
            }
        }
    }

    /* renamed from: b */
    public final void mo32108b() throws IOException {
        zzqq zzqq = this.f29170h;
        if (zzqq == null) {
            for (zzql b : this.f29163a) {
                b.mo32108b();
            }
            return;
        }
        throw zzqq;
    }

    /* renamed from: a */
    public final zzqj mo32104a(int i, zzrt zzrt) {
        zzqj[] zzqjArr = new zzqj[this.f29163a.length];
        for (int i2 = 0; i2 < zzqjArr.length; i2++) {
            zzqjArr[i2] = this.f29163a[i2].mo32104a(i, zzrt);
        }
        return new C9052Os(zzqjArr);
    }

    /* renamed from: a */
    public final void mo32107a(zzqj zzqj) {
        C9052Os os = (C9052Os) zzqj;
        int i = 0;
        while (true) {
            zzql[] zzqlArr = this.f29163a;
            if (i < zzqlArr.length) {
                zzqlArr[i].mo32107a(os.f21566a[i]);
                i++;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public final void mo32105a() {
        for (zzql a : this.f29163a) {
            a.mo32105a();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m30944a(int i, zzlr zzlr, Object obj) {
        zzqq zzqq;
        if (this.f29170h == null) {
            int b = zzlr.mo28172b();
            int i2 = 0;
            while (true) {
                if (i2 >= b) {
                    if (this.f29169g == -1) {
                        this.f29169g = zzlr.mo28173c();
                    } else if (zzlr.mo28173c() != this.f29169g) {
                        zzqq = new zzqq(1);
                    }
                    zzqq = null;
                } else if (zzlr.mo31959a(i2, this.f29165c, false).f28826e) {
                    zzqq = new zzqq(0);
                    break;
                } else {
                    i2++;
                }
            }
            this.f29170h = zzqq;
        }
        if (this.f29170h == null) {
            this.f29164b.remove(this.f29163a[i]);
            if (i == 0) {
                this.f29167e = zzlr;
                this.f29168f = obj;
            }
            if (this.f29164b.isEmpty()) {
                this.f29166d.mo28528a(this.f29167e, this.f29168f);
            }
        }
    }
}
