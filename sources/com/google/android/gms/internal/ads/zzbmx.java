package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;
import org.json.JSONObject;

public final class zzbmx implements zzdti<Set<zzbuz<zzo>>> {

    /* renamed from: a */
    private final zzdtu<zzbmn> f25586a;

    /* renamed from: b */
    private final zzdtu<Executor> f25587b;

    /* renamed from: c */
    private final zzdtu<JSONObject> f25588c;

    private zzbmx(zzdtu<zzbmn> zzdtu, zzdtu<Executor> zzdtu2, zzdtu<JSONObject> zzdtu3) {
        this.f25586a = zzdtu;
        this.f25587b = zzdtu2;
        this.f25588c = zzdtu3;
    }

    /* renamed from: a */
    public static zzbmx m27272a(zzdtu<zzbmn> zzdtu, zzdtu<Executor> zzdtu2, zzdtu<JSONObject> zzdtu3) {
        return new zzbmx(zzdtu, zzdtu2, zzdtu3);
    }

    public final /* synthetic */ Object get() {
        Set set;
        zzbmn zzbmn = (zzbmn) this.f25586a.get();
        Executor executor = (Executor) this.f25587b.get();
        if (((JSONObject) this.f25588c.get()) == null) {
            set = Collections.emptySet();
        } else {
            set = Collections.singleton(new zzbuz(zzbmn, executor));
        }
        zzdto.m30114a(set, "Cannot return null from a non-@Nullable @Provides method");
        return set;
    }
}
