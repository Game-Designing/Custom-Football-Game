package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzcsc implements zzcuz<Bundle> {

    /* renamed from: a */
    private final int f27313a;

    /* renamed from: b */
    private final boolean f27314b;

    /* renamed from: c */
    private final boolean f27315c;

    /* renamed from: d */
    private final int f27316d;

    /* renamed from: e */
    private final int f27317e;

    /* renamed from: f */
    private final int f27318f;

    /* renamed from: g */
    private final float f27319g;

    /* renamed from: h */
    private final boolean f27320h;

    public zzcsc(int i, boolean z, boolean z2, int i2, int i3, int i4, float f, boolean z3) {
        this.f27313a = i;
        this.f27314b = z;
        this.f27315c = z2;
        this.f27316d = i2;
        this.f27317e = i3;
        this.f27318f = i4;
        this.f27319g = f;
        this.f27320h = z3;
    }

    /* renamed from: a */
    public final /* synthetic */ void mo28065a(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putInt("am", this.f27313a);
        bundle.putBoolean("ma", this.f27314b);
        bundle.putBoolean("sp", this.f27315c);
        bundle.putInt("muv", this.f27316d);
        bundle.putInt("rm", this.f27317e);
        bundle.putInt("riv", this.f27318f);
        bundle.putFloat("android_app_volume", this.f27319g);
        bundle.putBoolean("android_app_muted", this.f27320h);
    }
}
