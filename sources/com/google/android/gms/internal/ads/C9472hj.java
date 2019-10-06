package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.ads.hj */
final /* synthetic */ class C9472hj implements Callable {

    /* renamed from: a */
    private final zzbbh f22416a;

    /* renamed from: b */
    private final zzbbh f22417b;

    C9472hj(zzbbh zzbbh, zzbbh zzbbh2) {
        this.f22416a = zzbbh;
        this.f22417b = zzbbh2;
    }

    public final Object call() {
        return new zzciv((JSONObject) this.f22416a.get(), (zzasd) this.f22417b.get());
    }
}
