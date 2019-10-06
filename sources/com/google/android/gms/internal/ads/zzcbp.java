package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.concurrent.Executor;

public final class zzcbp {

    /* renamed from: a */
    private final Executor f26317a;

    /* renamed from: b */
    private final zzbmy f26318b;

    /* renamed from: c */
    private final zzbva f26319c;

    zzcbp(Executor executor, zzbmy zzbmy, zzbva zzbva) {
        this.f26317a = executor;
        this.f26319c = zzbva;
        this.f26318b = zzbmy;
    }

    /* renamed from: a */
    public final void mo31103a(zzbgz zzbgz) {
        if (zzbgz != null) {
            this.f26319c.mo30923a(zzbgz.getView());
            this.f26319c.mo30897a(new C9233Xh(zzbgz), this.f26317a);
            this.f26319c.mo30897a(new C9254Yh(zzbgz), this.f26317a);
            this.f26319c.mo30897a(this.f26318b, this.f26317a);
            this.f26318b.mo30746a(zzbgz);
            zzbgz.mo28726a("/trackActiveViewUnit", (zzaho<? super zzbgz>) new C9275Zh<Object>(this));
            zzbgz.mo28726a("/untrackActiveViewUnit", (zzaho<? super zzbgz>) new C9295_h<Object>(this));
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ void mo31104a(zzbgz zzbgz, Map map) {
        this.f26318b.mo30744C();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final /* synthetic */ void mo31105b(zzbgz zzbgz, Map map) {
        this.f26318b.mo30745D();
    }
}
