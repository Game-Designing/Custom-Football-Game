package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzcvo implements zzcva<zzcvn> {

    /* renamed from: a */
    private final zzawi f27464a;

    /* renamed from: b */
    private final Context f27465b;

    /* renamed from: c */
    private final ScheduledExecutorService f27466c;

    /* renamed from: d */
    private final Executor f27467d;

    public zzcvo(zzawi zzawi, Context context, ScheduledExecutorService scheduledExecutorService, Executor executor) {
        this.f27464a = zzawi;
        this.f27465b = context;
        this.f27466c = scheduledExecutorService;
        this.f27467d = executor;
    }

    /* renamed from: a */
    public final zzbbh<zzcvn> mo28586a() {
        if (!((Boolean) zzyt.m31536e().mo29599a(zzacu.f24090fb)).booleanValue()) {
            return zzbar.m26375a((Throwable) new Exception("Did not ad Ad ID into query param."));
        }
        zzbbr zzbbr = new zzbbr();
        zzbbh a = this.f27464a.mo30149a(this.f27465b);
        a.mo28811a(new C9195Vl(this, a, zzbbr), this.f27467d);
        this.f27466c.schedule(new C9216Wl(a), ((Long) zzyt.m31536e().mo29599a(zzacu.f24096gb)).longValue(), TimeUnit.MILLISECONDS);
        return zzbbr;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ void mo31271a(zzbbh zzbbh, zzbbr zzbbr) {
        String str;
        try {
            Info info = (Info) zzbbh.get();
            if (info == null || !TextUtils.isEmpty(info.getId())) {
                str = null;
            } else {
                zzyt.m31532a();
                str = zzazt.m26313b(this.f27465b);
            }
            zzbbr.mo30338b(new zzcvn(info, this.f27465b, str));
        } catch (InterruptedException | CancellationException | ExecutionException e) {
            zzyt.m31532a();
            zzbbr.mo30338b(new zzcvn(null, this.f27465b, zzazt.m26313b(this.f27465b)));
        }
    }
}
