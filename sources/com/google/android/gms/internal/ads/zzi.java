package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.concurrent.Executor;

public final class zzi implements zzab {

    /* renamed from: a */
    private final Executor f28567a;

    public zzi(Handler handler) {
        this.f28567a = new C9546kr(this, handler);
    }

    /* renamed from: a */
    public final void mo29405a(zzr<?> zzr, zzy<?> zzy) {
        mo29406a(zzr, zzy, null);
    }

    /* renamed from: a */
    public final void mo29406a(zzr<?> zzr, zzy<?> zzy, Runnable runnable) {
        zzr.mo32140y();
        zzr.mo32126a("post-response");
        this.f28567a.execute(new C9761ur(zzr, zzy, runnable));
    }

    /* renamed from: a */
    public final void mo29404a(zzr<?> zzr, zzaf zzaf) {
        zzr.mo32126a("post-error");
        this.f28567a.execute(new C9761ur(zzr, zzy.m31505a(zzaf), null));
    }
}
