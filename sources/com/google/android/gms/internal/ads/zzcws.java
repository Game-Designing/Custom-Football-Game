package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import java.util.concurrent.ScheduledExecutorService;

public final class zzcws implements zzdti<zzcwq> {

    /* renamed from: a */
    private final zzdtu<zzamg> f27511a;

    /* renamed from: b */
    private final zzdtu<ScheduledExecutorService> f27512b;

    /* renamed from: c */
    private final zzdtu<Boolean> f27513c;

    /* renamed from: d */
    private final zzdtu<ApplicationInfo> f27514d;

    public zzcws(zzdtu<zzamg> zzdtu, zzdtu<ScheduledExecutorService> zzdtu2, zzdtu<Boolean> zzdtu3, zzdtu<ApplicationInfo> zzdtu4) {
        this.f27511a = zzdtu;
        this.f27512b = zzdtu2;
        this.f27513c = zzdtu3;
        this.f27514d = zzdtu4;
    }

    public final /* synthetic */ Object get() {
        return new zzcwq((zzamg) this.f27511a.get(), (ScheduledExecutorService) this.f27512b.get(), ((Boolean) this.f27513c.get()).booleanValue(), (ApplicationInfo) this.f27514d.get());
    }
}
