package com.google.android.gms.internal.ads;

import java.io.IOException;

public abstract class zzks implements zzlo, zzlp {

    /* renamed from: a */
    private final int f28750a;

    /* renamed from: b */
    private zzlq f28751b;

    /* renamed from: c */
    private int f28752c;

    /* renamed from: d */
    private int f28753d;

    /* renamed from: e */
    private zzqw f28754e;

    /* renamed from: f */
    private long f28755f;

    /* renamed from: g */
    private boolean f28756g = true;

    /* renamed from: h */
    private boolean f28757h;

    public zzks(int i) {
        this.f28750a = i;
    }

    /* renamed from: d */
    public final int mo31914d() {
        return this.f28750a;
    }

    /* renamed from: e */
    public final zzlp mo31915e() {
        return this;
    }

    public final void setIndex(int i) {
        this.f28752c = i;
    }

    /* renamed from: f */
    public zzso mo31916f() {
        return null;
    }

    public final int getState() {
        return this.f28753d;
    }

    /* renamed from: a */
    public final void mo31908a(zzlq zzlq, zzlh[] zzlhArr, zzqw zzqw, long j, boolean z, long j2) throws zzku {
        zzsk.m31082b(this.f28753d == 0);
        this.f28751b = zzlq;
        this.f28753d = 1;
        mo31909a(z);
        mo31911a(zzlhArr, zzqw, j2);
        mo31907a(j, z);
    }

    public final void start() throws zzku {
        boolean z = true;
        if (this.f28753d != 1) {
            z = false;
        }
        zzsk.m31082b(z);
        this.f28753d = 2;
        mo31925o();
    }

    /* renamed from: a */
    public final void mo31911a(zzlh[] zzlhArr, zzqw zzqw, long j) throws zzku {
        zzsk.m31082b(!this.f28757h);
        this.f28754e = zzqw;
        this.f28756g = false;
        this.f28755f = j;
        mo31910a(zzlhArr, j);
    }

    /* renamed from: j */
    public final zzqw mo31920j() {
        return this.f28754e;
    }

    /* renamed from: k */
    public final boolean mo31921k() {
        return this.f28756g;
    }

    /* renamed from: g */
    public final void mo31917g() {
        this.f28757h = true;
    }

    /* renamed from: h */
    public final boolean mo31919h() {
        return this.f28757h;
    }

    /* renamed from: l */
    public final void mo31922l() throws IOException {
        this.f28754e.mo28468a();
    }

    /* renamed from: a */
    public final void mo31906a(long j) throws zzku {
        this.f28757h = false;
        this.f28756g = false;
        mo31907a(j, false);
    }

    public final void stop() throws zzku {
        zzsk.m31082b(this.f28753d == 2);
        this.f28753d = 1;
        mo31926p();
    }

    /* renamed from: c */
    public final void mo31913c() {
        boolean z = true;
        if (this.f28753d != 1) {
            z = false;
        }
        zzsk.m31082b(z);
        this.f28753d = 0;
        this.f28754e = null;
        this.f28757h = false;
        mo31927q();
    }

    /* renamed from: m */
    public int mo31923m() throws zzku {
        return 0;
    }

    /* renamed from: a */
    public void mo31905a(int i, Object obj) throws zzku {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo31909a(boolean z) throws zzku {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo31910a(zzlh[] zzlhArr, long j) throws zzku {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo31907a(long j, boolean z) throws zzku {
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public void mo31925o() throws zzku {
    }

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public void mo31926p() throws zzku {
    }

    /* access modifiers changed from: protected */
    /* renamed from: q */
    public void mo31927q() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: r */
    public final zzlq mo31928r() {
        return this.f28751b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public final int mo31924n() {
        return this.f28752c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final int mo31904a(zzlj zzlj, zznd zznd, boolean z) {
        int a = this.f28754e.mo28467a(zzlj, zznd, z);
        if (a == -4) {
            if (zznd.mo32016c()) {
                this.f28756g = true;
                if (this.f28757h) {
                    return -4;
                }
                return -3;
            }
            zznd.f28952d += this.f28755f;
        } else if (a == -5) {
            zzlh zzlh = zzlj.f28805a;
            long j = zzlh.f28801w;
            if (j != Long.MAX_VALUE) {
                zzlj.f28805a = zzlh.mo31941a(j + this.f28755f);
            }
        }
        return a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo31912b(long j) {
        this.f28754e.mo28469a(j - this.f28755f);
    }

    /* access modifiers changed from: protected */
    /* renamed from: s */
    public final boolean mo31929s() {
        return this.f28756g ? this.f28757h : this.f28754e.isReady();
    }
}
