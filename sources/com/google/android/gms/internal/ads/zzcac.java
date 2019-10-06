package com.google.android.gms.internal.ads;

import java.util.Map;
import p002b.p003c.p053g.p061f.C1253b;

public final class zzcac implements zzbrw {

    /* renamed from: a */
    private final zzbyt f26237a;

    /* renamed from: b */
    private final zzbyx f26238b;

    public zzcac(zzbyt zzbyt, zzbyx zzbyx) {
        this.f26237a = zzbyt;
        this.f26238b = zzbyx;
    }

    public final void onAdImpression() {
        if (this.f26237a.mo31022t() != null) {
            zzbgz s = this.f26237a.mo31021s();
            zzbgz r = this.f26237a.mo31020r();
            if (s == null) {
                if (r != null) {
                    s = r;
                } else {
                    s = null;
                }
            }
            if (this.f26238b.mo31032d() && s != null) {
                s.mo28729a("onSdkImpression", (Map<String, ?>) new C1253b<String,Object>());
            }
        }
    }
}
