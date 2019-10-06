package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzbpk {

    /* renamed from: a */
    private final Executor f25754a;

    /* renamed from: b */
    private final ScheduledExecutorService f25755b;

    /* renamed from: c */
    private final zzbbh<zzbph> f25756c;

    /* renamed from: d */
    private volatile boolean f25757d = true;

    public zzbpk(Executor executor, ScheduledExecutorService scheduledExecutorService, zzbbh<zzbph> zzbbh) {
        this.f25754a = executor;
        this.f25755b = scheduledExecutorService;
        this.f25756c = zzbbh;
    }

    /* renamed from: a */
    public final void mo30858a(zzban<zzbpc> zzban) {
        zzbar.m26383a(this.f25756c, (zzban<? super V>) new C9425fg<Object>(this, zzban), this.f25754a);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m27656a(List<? extends zzbbh<? extends zzbpc>> list, zzban<zzbpc> zzban) {
        if (list == null || list.isEmpty()) {
            this.f25754a.execute(new C9359cg(zzban));
            return;
        }
        zzbbh a = zzbar.m26376a(null);
        for (zzbbh egVar : list) {
            a = zzbar.m26379a(zzbar.m26381a(a, Throwable.class, (zzbal<? super X, ? extends V>) new C9381dg<Object,Object>(zzban), this.f25754a), (zzbal<? super A, ? extends B>) new C9403eg<Object,Object>(this, zzban, egVar), this.f25754a);
        }
        zzbar.m26383a(a, (zzban<? super V>) new C9447gg<Object>(this, zzban), this.f25754a);
    }

    /* renamed from: a */
    public final boolean mo30859a() {
        return this.f25757d;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m27657b() {
        this.f25757d = false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ zzbbh mo30857a(zzban zzban, zzbbh zzbbh, zzbpc zzbpc) throws Exception {
        if (zzbpc != null) {
            zzban.mo27998a(zzbpc);
        }
        return zzbar.m26378a(zzbbh, ((Long) zzyt.m31536e().mo29599a(zzacu.f24073cc)).longValue(), TimeUnit.MILLISECONDS, this.f25755b);
    }
}
