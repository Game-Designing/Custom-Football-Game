package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;
import org.json.JSONObject;

public final class zzbmw implements zzdti<Set<zzbuz<zzue>>> {

    /* renamed from: a */
    private final zzdtu<zzbmn> f25583a;

    /* renamed from: b */
    private final zzdtu<Executor> f25584b;

    /* renamed from: c */
    private final zzdtu<JSONObject> f25585c;

    private zzbmw(zzdtu<zzbmn> zzdtu, zzdtu<Executor> zzdtu2, zzdtu<JSONObject> zzdtu3) {
        this.f25583a = zzdtu;
        this.f25584b = zzdtu2;
        this.f25585c = zzdtu3;
    }

    /* renamed from: a */
    public static zzbmw m27271a(zzdtu<zzbmn> zzdtu, zzdtu<Executor> zzdtu2, zzdtu<JSONObject> zzdtu3) {
        return new zzbmw(zzdtu, zzdtu2, zzdtu3);
    }

    public final /* synthetic */ Object get() {
        Set set;
        zzbmn zzbmn = (zzbmn) this.f25583a.get();
        Executor executor = (Executor) this.f25584b.get();
        if (((JSONObject) this.f25585c.get()) == null) {
            set = Collections.emptySet();
        } else {
            set = Collections.singleton(new zzbuz(zzbmn, executor));
        }
        zzdto.m30114a(set, "Cannot return null from a non-@Nullable @Provides method");
        return set;
    }
}
