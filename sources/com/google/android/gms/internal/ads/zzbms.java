package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;
import org.json.JSONObject;

public final class zzbms implements zzdti<Set<zzbuz<zzbrw>>> {

    /* renamed from: a */
    private final zzdtu<zzbmn> f25572a;

    /* renamed from: b */
    private final zzdtu<Executor> f25573b;

    /* renamed from: c */
    private final zzdtu<JSONObject> f25574c;

    private zzbms(zzdtu<zzbmn> zzdtu, zzdtu<Executor> zzdtu2, zzdtu<JSONObject> zzdtu3) {
        this.f25572a = zzdtu;
        this.f25573b = zzdtu2;
        this.f25574c = zzdtu3;
    }

    /* renamed from: a */
    public static zzbms m27267a(zzdtu<zzbmn> zzdtu, zzdtu<Executor> zzdtu2, zzdtu<JSONObject> zzdtu3) {
        return new zzbms(zzdtu, zzdtu2, zzdtu3);
    }

    public final /* synthetic */ Object get() {
        Set set;
        zzbmn zzbmn = (zzbmn) this.f25572a.get();
        Executor executor = (Executor) this.f25573b.get();
        if (((JSONObject) this.f25574c.get()) == null) {
            set = Collections.emptySet();
        } else {
            set = Collections.singleton(new zzbuz(zzbmn, executor));
        }
        zzdto.m30114a(set, "Cannot return null from a non-@Nullable @Provides method");
        return set;
    }
}
