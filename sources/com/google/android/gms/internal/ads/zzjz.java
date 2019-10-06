package com.google.android.gms.internal.ads;

import android.os.Looper;
import java.util.concurrent.ExecutorService;

public final class zzjz {

    /* renamed from: a */
    private final ExecutorService f28730a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C9782vr f28731b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f28732c;

    public zzjz(String str) {
        this.f28730a = zzkq.m30566a(str);
    }

    /* renamed from: a */
    public final void mo31879a(zzkc zzkc, zzka zzka) {
        Looper myLooper = Looper.myLooper();
        zzkh.m30537b(myLooper != null);
        zzkh.m30537b(!this.f28732c);
        this.f28732c = true;
        C9782vr vrVar = new C9782vr(this, myLooper, zzkc, zzka, 0);
        this.f28731b = vrVar;
        this.f28730a.submit(this.f28731b);
    }

    /* renamed from: a */
    public final boolean mo31880a() {
        return this.f28732c;
    }

    /* renamed from: c */
    public final void mo31882c() {
        zzkh.m30537b(this.f28732c);
        this.f28731b.mo29238a();
    }

    /* renamed from: b */
    public final void mo31881b() {
        if (this.f28732c) {
            mo31882c();
        }
        this.f28730a.shutdown();
    }
}
