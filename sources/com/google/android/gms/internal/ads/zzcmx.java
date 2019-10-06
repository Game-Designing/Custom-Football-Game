package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzcmx<AdT> implements zzbal<zzcxu, AdT> {

    /* renamed from: a */
    private final zzczt f27051a;

    /* renamed from: b */
    private final zzbrm f27052b;

    /* renamed from: c */
    private final zzdae f27053c;

    /* renamed from: d */
    private final Executor f27054d;

    /* renamed from: e */
    private final ScheduledExecutorService f27055e;

    /* renamed from: f */
    private final zzbpe<AdT> f27056f;

    /* renamed from: g */
    private final zzcmu f27057g;

    public zzcmx(zzczt zzczt, zzcmu zzcmu, zzbrm zzbrm, zzdae zzdae, zzbpe<AdT> zzbpe, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        this.f27051a = zzczt;
        this.f27057g = zzcmu;
        this.f27052b = zzbrm;
        this.f27053c = zzdae;
        this.f27056f = zzbpe;
        this.f27054d = executor;
        this.f27055e = scheduledExecutorService;
    }

    /* renamed from: a */
    public final /* synthetic */ zzbbh mo26658a(Object obj) throws Exception {
        zzcxu zzcxu = (zzcxu) obj;
        zzcze a = this.f27051a.mo31318a(zzczs.RENDER_CONFIG_INIT).mo31322a((zzbbh<O>) zzbar.m26375a((Throwable) new zzcmw("No ad configs", 3))).mo31325a();
        this.f27052b.mo30897a(new zzbmd(zzcxu, this.f27053c), this.f27054d);
        int i = 0;
        for (zzcxm zzcxm : zzcxu.f27596b.f27590a) {
            Iterator it = zzcxm.f27550a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String str = (String) it.next();
                zzcjv a2 = this.f27056f.mo28990a(zzcxm.f27551b, str);
                if (a2 != null && a2.mo31186b(zzcxu, zzcxm)) {
                    zzczl a3 = this.f27051a.mo31319a(zzczs.RENDER_CONFIG_WATERFALL, (zzbbh<I>) a);
                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 26);
                    sb.append("render-config-");
                    sb.append(i);
                    sb.append("-");
                    sb.append(str);
                    a = a3.mo31333a(sb.toString()).mo31330a(Throwable.class, (zzbal<T, O>) new C9429fk<T,O>(this, zzcxm, a2, zzcxu)).mo31325a();
                    break;
                }
            }
            i++;
        }
        return a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ zzbbh mo31212a(zzcxm zzcxm, zzcjv zzcjv, zzcxu zzcxu, Throwable th) throws Exception {
        return this.f27057g.mo31210a(zzcxm, zzbar.m26378a(zzcjv.mo31185a(zzcxu, zzcxm), (long) zzcxm.f27543I, TimeUnit.MILLISECONDS, this.f27055e));
    }
}
