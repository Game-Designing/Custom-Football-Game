package com.google.android.gms.internal.ads;

import org.json.JSONObject;

public final class zzbye implements zzdti<JSONObject> {

    /* renamed from: a */
    private final zzbyc f26068a;

    public zzbye(zzbyc zzbyc) {
        this.f26068a = zzbyc;
    }

    public final /* synthetic */ Object get() {
        JSONObject a = this.f26068a.mo30961a();
        zzdto.m30114a(a, "Cannot return null from a non-@Nullable @Provides method");
        return a;
    }
}
