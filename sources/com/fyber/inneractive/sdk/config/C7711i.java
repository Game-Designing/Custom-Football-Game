package com.fyber.inneractive.sdk.config;

import com.fyber.inneractive.sdk.config.enums.Vendor;
import com.google.gson.GsonBuilder;
import java.util.Set;

/* renamed from: com.fyber.inneractive.sdk.config.i */
public final class C7711i implements C7712j {

    /* renamed from: a */
    String f15361a;

    /* renamed from: b */
    String f15362b;

    /* renamed from: c */
    C7703c f15363c;

    /* renamed from: d */
    C7708f f15364d;

    /* renamed from: e */
    C7709g f15365e;

    /* renamed from: f */
    public C7713k f15366f;

    /* renamed from: g */
    C7715m f15367g;

    /* renamed from: f */
    public final /* bridge */ /* synthetic */ C7714l mo24210f() {
        return this.f15366f;
    }

    /* renamed from: g */
    public final /* bridge */ /* synthetic */ C7704d mo24211g() {
        return this.f15363c;
    }

    /* renamed from: a */
    public final String mo24204a() {
        return this.f15361a;
    }

    /* renamed from: b */
    public final String mo24206b() {
        return this.f15362b;
    }

    /* renamed from: c */
    public final C7708f mo24207c() {
        return this.f15364d;
    }

    /* renamed from: d */
    public final C7709g mo24208d() {
        return this.f15365e;
    }

    /* renamed from: e */
    public final C7715m mo24209e() {
        return this.f15367g;
    }

    public final String toString() {
        return new GsonBuilder().create().toJson((Object) this);
    }

    /* renamed from: a */
    public final boolean mo24205a(Vendor vendor) {
        C7715m mVar = this.f15367g;
        if (mVar != null) {
            Set<Vendor> set = mVar.f15381c;
            if (set != null) {
                return set.contains(vendor);
            }
        }
        return false;
    }
}
