package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.internal.Objects;

public final class zai<O extends ApiOptions> {

    /* renamed from: a */
    private final boolean f19892a = true;

    /* renamed from: b */
    private final int f19893b;

    /* renamed from: c */
    private final Api<O> f19894c;

    /* renamed from: d */
    private final O f19895d;

    private zai(Api<O> api, O o) {
        this.f19894c = api;
        this.f19895d = o;
        this.f19893b = Objects.m21849a(this.f19894c, this.f19895d);
    }

    private zai(Api<O> api) {
        this.f19894c = api;
        this.f19895d = null;
        this.f19893b = System.identityHashCode(this);
    }

    /* renamed from: a */
    public static <O extends ApiOptions> zai<O> m21616a(Api<O> api, O o) {
        return new zai<>(api, o);
    }

    /* renamed from: a */
    public static <O extends ApiOptions> zai<O> m21615a(Api<O> api) {
        return new zai<>(api);
    }

    /* renamed from: a */
    public final String mo27623a() {
        return this.f19894c.mo27325b();
    }

    public final int hashCode() {
        return this.f19893b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zai)) {
            return false;
        }
        zai zai = (zai) obj;
        if (this.f19892a || zai.f19892a || !Objects.m21851a(this.f19894c, zai.f19894c) || !Objects.m21851a(this.f19895d, zai.f19895d)) {
            return false;
        }
        return true;
    }
}
