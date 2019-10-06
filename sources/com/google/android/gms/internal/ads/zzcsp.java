package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;
import java.util.concurrent.Callable;

public final class zzcsp implements zzcva<C9734tl> {

    /* renamed from: a */
    private final Context f27340a;

    /* renamed from: b */
    private final zzbbl f27341b;

    zzcsp(Context context, zzbbl zzbbl) {
        this.f27340a = context;
        this.f27341b = zzbbl;
    }

    /* renamed from: a */
    public final zzbbh<C9734tl> mo28586a() {
        return this.f27341b.mo30326a((Callable<T>) new C9692rl<T>(this));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final /* synthetic */ C9734tl mo31256b() throws Exception {
        zzk.zzlg();
        String k = zzaxi.m26143k(this.f27340a);
        zzk.zzlg();
        return new C9734tl(k, zzaxi.m26144l(this.f27340a));
    }
}
