package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;

public final class zzcvf implements zzcuz<Bundle> {

    /* renamed from: a */
    private final boolean f27437a;

    /* renamed from: b */
    private final boolean f27438b;

    /* renamed from: c */
    private final String f27439c;

    /* renamed from: d */
    private final boolean f27440d;

    /* renamed from: e */
    private final boolean f27441e;

    /* renamed from: f */
    private final boolean f27442f;

    /* renamed from: g */
    private final String f27443g;

    /* renamed from: h */
    private final String f27444h;

    /* renamed from: i */
    private final String f27445i;

    /* renamed from: j */
    private final String f27446j;

    /* renamed from: k */
    private final boolean f27447k;

    /* renamed from: l */
    private final String f27448l;

    public zzcvf(boolean z, boolean z2, String str, boolean z3, boolean z4, boolean z5, String str2, String str3, String str4, String str5, boolean z6, String str6) {
        this.f27437a = z;
        this.f27438b = z2;
        this.f27439c = str;
        this.f27440d = z3;
        this.f27441e = z4;
        this.f27442f = z5;
        this.f27443g = str2;
        this.f27444h = str3;
        this.f27445i = str4;
        this.f27446j = str5;
        this.f27447k = z6;
        this.f27448l = str6;
    }

    /* renamed from: a */
    public final /* synthetic */ void mo28065a(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putBoolean("cog", this.f27437a);
        bundle.putBoolean("coh", this.f27438b);
        bundle.putString("gl", this.f27439c);
        bundle.putBoolean("simulator", this.f27440d);
        bundle.putBoolean("is_latchsky", this.f27441e);
        bundle.putBoolean("is_sidewinder", this.f27442f);
        bundle.putString("hl", this.f27443g);
        bundle.putString("mv", this.f27444h);
        bundle.putString("submodel", this.f27448l);
        String str = "device";
        Bundle a = zzcxz.m28989a(bundle, str);
        bundle.putBundle(str, a);
        a.putString("build", this.f27446j);
        String str2 = "browser";
        Bundle a2 = zzcxz.m28989a(a, str2);
        a.putBundle(str2, a2);
        a2.putBoolean("is_browser_custom_tabs_capable", this.f27447k);
        if (!TextUtils.isEmpty(this.f27445i)) {
            String str3 = "play_store";
            Bundle a3 = zzcxz.m28989a(a, str3);
            a.putBundle(str3, a3);
            a3.putString("package_version", this.f27445i);
        }
    }
}
