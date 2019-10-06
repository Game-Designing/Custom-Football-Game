package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public final class zzcgn {

    /* renamed from: a */
    private final zzbbl f26585a;

    /* renamed from: b */
    private final zzbbl f26586b;

    /* renamed from: c */
    private final zzchv f26587c;

    /* renamed from: d */
    private final zzdte<zzcig> f26588d;

    public zzcgn(zzbbl zzbbl, zzbbl zzbbl2, zzchv zzchv, zzdte<zzcig> zzdte) {
        this.f26585a = zzbbl;
        this.f26586b = zzbbl2;
        this.f26587c = zzchv;
        this.f26588d = zzdte;
    }

    /* renamed from: a */
    public final zzbbh<InputStream> mo31158a(zzarx zzarx) {
        zzbbh zzbbh;
        String str = zzarx.f24718d;
        zzk.zzlg();
        if (zzaxi.m26135e(str)) {
            zzbbh = zzbar.m26375a((Throwable) new zzcie(0));
        } else {
            if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f24165re)).booleanValue()) {
                zzbbh = zzbar.m26381a(this.f26585a.mo30326a((Callable<T>) new C8979Li<T>(this, zzarx)), ExecutionException.class, C9000Mi.f21477a, (Executor) this.f26586b);
            } else {
                zzbbh = this.f26587c.mo31166a(zzarx);
            }
        }
        zzbbh<InputStream> a = zzbar.m26381a(zzbbh, zzcie.class, (zzbal<? super X, ? extends V>) new C9021Ni<Object,Object>(this, zzarx), (Executor) this.f26586b);
        if (!((Boolean) zzyt.m31536e().mo29599a(zzacu.f24165re)).booleanValue()) {
            a.mo28811a(new C9042Oi(zzbbh), zzbbm.f25065b);
        }
        return a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ zzbbh mo31159a(zzarx zzarx, zzcie zzcie) throws Exception {
        return ((zzcig) this.f26588d.get()).mo31169a(zzarx);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final /* synthetic */ InputStream mo31160b(zzarx zzarx) throws Exception {
        return (InputStream) this.f26587c.mo31166a(zzarx).get((long) ((Integer) zzyt.m31536e().mo29599a(zzacu.f24159qe)).intValue(), TimeUnit.SECONDS);
    }
}
