package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;
import org.json.JSONObject;

public final class zzbmv implements zzdti<Set<zzbuz<zzbrx>>> {

    /* renamed from: a */
    private final zzdtu<zzbmn> f25580a;

    /* renamed from: b */
    private final zzdtu<Executor> f25581b;

    /* renamed from: c */
    private final zzdtu<JSONObject> f25582c;

    private zzbmv(zzdtu<zzbmn> zzdtu, zzdtu<Executor> zzdtu2, zzdtu<JSONObject> zzdtu3) {
        this.f25580a = zzdtu;
        this.f25581b = zzdtu2;
        this.f25582c = zzdtu3;
    }

    /* renamed from: a */
    public static zzbmv m27270a(zzdtu<zzbmn> zzdtu, zzdtu<Executor> zzdtu2, zzdtu<JSONObject> zzdtu3) {
        return new zzbmv(zzdtu, zzdtu2, zzdtu3);
    }

    public final /* synthetic */ Object get() {
        Set set;
        zzbmn zzbmn = (zzbmn) this.f25580a.get();
        Executor executor = (Executor) this.f25581b.get();
        if (((JSONObject) this.f25582c.get()) == null) {
            set = Collections.emptySet();
        } else {
            set = Collections.singleton(new zzbuz(zzbmn, executor));
        }
        zzdto.m30114a(set, "Cannot return null from a non-@Nullable @Provides method");
        return set;
    }
}
