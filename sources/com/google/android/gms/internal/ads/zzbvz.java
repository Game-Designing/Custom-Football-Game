package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Collections;
import java.util.Set;

public class zzbvz {

    /* renamed from: a */
    private final zzbwz f25923a;

    /* renamed from: b */
    private final zzbgz f25924b;

    public zzbvz(zzbwz zzbwz) {
        this(zzbwz, null);
    }

    public zzbvz(zzbwz zzbwz, zzbgz zzbgz) {
        this.f25923a = zzbwz;
        this.f25924b = zzbgz;
    }

    /* renamed from: b */
    public final zzbwz mo30936b() {
        return this.f25923a;
    }

    /* renamed from: a */
    public final zzbgz mo30935a() {
        return this.f25924b;
    }

    /* renamed from: c */
    public final View mo30937c() {
        zzbgz zzbgz = this.f25924b;
        if (zzbgz == null) {
            return null;
        }
        return zzbgz.getWebView();
    }

    /* renamed from: a */
    public Set<zzbuz<zzbrl>> mo28380a(zzbxc zzbxc) {
        return Collections.singleton(zzbuz.m27828a(zzbxc, zzbbm.f25065b));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public final /* synthetic */ void mo30938d() {
        if (this.f25924b.mo28758i() != null) {
            this.f25924b.mo28758i().close();
        }
    }
}
