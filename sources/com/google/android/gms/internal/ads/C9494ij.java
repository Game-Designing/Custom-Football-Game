package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.ads.ij */
final /* synthetic */ class C9494ij implements Callable {

    /* renamed from: a */
    private final zzbbh f22556a;

    /* renamed from: b */
    private final zzbbh f22557b;

    /* renamed from: c */
    private final zzbbh f22558c;

    C9494ij(zzbbh zzbbh, zzbbh zzbbh2, zzbbh zzbbh3) {
        this.f22556a = zzbbh;
        this.f22557b = zzbbh2;
        this.f22558c = zzbbh3;
    }

    public final Object call() {
        return new zzcir((zzciw) this.f22556a.get(), (JSONObject) this.f22557b.get(), (zzasd) this.f22558c.get());
    }
}
