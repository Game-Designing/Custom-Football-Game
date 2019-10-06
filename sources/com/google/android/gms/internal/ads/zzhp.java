package com.google.android.gms.internal.ads;

public abstract class zzhp implements zzgf {

    /* renamed from: a */
    private int f28532a;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo31779a(long j) throws zzgd;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo31792a(long j, long j2) throws zzgd;

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract int mo31795b(long j) throws zzgd;

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract long mo31796b();

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public abstract boolean mo31785d();

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public abstract long mo31797j();

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public abstract boolean mo31789l();

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public abstract long mo31790m();

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public boolean mo31788k() {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final int mo31814c() {
        return this.f28532a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public final int mo31815c(long j) throws zzgd {
        boolean z = false;
        zzkh.m30537b(this.f28532a == 0);
        this.f28532a = mo31795b(j);
        int i = this.f28532a;
        if (i == 0 || i == 1 || i == -1) {
            z = true;
        }
        zzkh.m30537b(z);
        return this.f28532a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final void mo31813b(long j, boolean z) throws zzgd {
        boolean z2 = true;
        if (this.f28532a != 1) {
            z2 = false;
        }
        zzkh.m30537b(z2);
        this.f28532a = 2;
        mo31780a(j, z);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo31780a(long j, boolean z) throws zzgd {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public final void mo31817h() throws zzgd {
        zzkh.m30537b(this.f28532a == 2);
        this.f28532a = 3;
        mo31786e();
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo31786e() throws zzgd {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public final void mo31818i() throws zzgd {
        zzkh.m30537b(this.f28532a == 3);
        this.f28532a = 2;
        mo31787f();
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public void mo31787f() throws zzgd {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo31812a() throws zzgd {
        zzkh.m30537b(this.f28532a == 2);
        this.f28532a = 1;
        mo31791n();
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public void mo31791n() throws zzgd {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public final void mo31816g() throws zzgd {
        int i = this.f28532a;
        zzkh.m30537b((i == 2 || i == 3 || i == -2) ? false : true);
        this.f28532a = -2;
        mo31798o();
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public void mo31798o() throws zzgd {
    }

    /* renamed from: a */
    public void mo31767a(int i, Object obj) throws zzgd {
    }
}
