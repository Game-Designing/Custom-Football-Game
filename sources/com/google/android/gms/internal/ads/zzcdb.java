package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzcdb extends zzbpc {

    /* renamed from: f */
    private final Context f26404f;

    /* renamed from: g */
    private final zzbwz f26405g;

    /* renamed from: h */
    private final zzbup f26406h;

    /* renamed from: i */
    private final zzbrp f26407i;

    /* renamed from: j */
    private final zzbpv f26408j;

    /* renamed from: k */
    private final zzatq f26409k;

    /* renamed from: l */
    private final zzdan f26410l;

    /* renamed from: m */
    private boolean f26411m = false;

    zzcdb(Context context, zzbwz zzbwz, zzbup zzbup, zzbrp zzbrp, zzbry zzbry, zzbpv zzbpv, zzcxm zzcxm, zzdan zzdan) {
        this.f26404f = context;
        this.f26405g = zzbwz;
        this.f26406h = zzbup;
        this.f26407i = zzbrp;
        this.f25748c = zzbry;
        this.f26408j = zzbpv;
        this.f26410l = zzdan;
        this.f26409k = new zzaup(zzcxm.f27561l);
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=android.app.Activity, code=android.content.Context, for r4v0, types: [android.content.Context, android.app.Activity] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo31120a(boolean r3, android.content.Context r4) {
        /*
            r2 = this;
            com.google.android.gms.internal.ads.zzacj<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzacu.f23963La
            com.google.android.gms.internal.ads.zzacr r1 = com.google.android.gms.internal.ads.zzyt.m31536e()
            java.lang.Object r0 = r1.mo29599a(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0048
            com.google.android.gms.ads.internal.zzk.zzlg()
            android.content.Context r0 = r2.f26404f
            boolean r0 = com.google.android.gms.internal.ads.zzaxi.m26139g(r0)
            if (r0 == 0) goto L_0x0048
            java.lang.String r3 = "Rewarded ad can not be shown when app is not in foreground."
            com.google.android.gms.internal.ads.zzbad.m26359d(r3)
            com.google.android.gms.internal.ads.zzbrp r3 = r2.f26407i
            r4 = 3
            r3.mo30876d(r4)
            com.google.android.gms.internal.ads.zzacj<java.lang.Boolean> r3 = com.google.android.gms.internal.ads.zzacu.f23969Ma
            com.google.android.gms.internal.ads.zzacr r4 = com.google.android.gms.internal.ads.zzyt.m31536e()
            java.lang.Object r3 = r4.mo29599a(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x0047
            com.google.android.gms.internal.ads.zzdan r3 = r2.f26410l
            com.google.android.gms.internal.ads.zzcxu r4 = r2.f25746a
            com.google.android.gms.internal.ads.zzcxs r4 = r4.f27596b
            com.google.android.gms.internal.ads.zzcxo r4 = r4.f27591b
            java.lang.String r4 = r4.f27580b
            r3.mo31351a(r4)
        L_0x0047:
            return
        L_0x0048:
            boolean r0 = r2.f26411m
            r1 = 1
            if (r0 == 0) goto L_0x0058
            java.lang.String r3 = "The rewarded ad have been showed."
            com.google.android.gms.internal.ads.zzbad.m26359d(r3)
            com.google.android.gms.internal.ads.zzbrp r3 = r2.f26407i
            r3.mo30876d(r1)
            return
        L_0x0058:
            r2.f26411m = r1
            com.google.android.gms.internal.ads.zzbup r0 = r2.f26406h
            r0.mo30918F()
            if (r4 != 0) goto L_0x0063
            android.content.Context r4 = r2.f26404f
        L_0x0063:
            com.google.android.gms.internal.ads.zzbwz r0 = r2.f26405g
            r0.mo28355a(r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcdb.mo31120a(boolean, android.app.Activity):void");
    }

    /* renamed from: h */
    public final zzatq mo31123h() {
        return this.f26409k;
    }

    /* renamed from: g */
    public final zzbry mo31122g() {
        return this.f25748c;
    }

    /* renamed from: f */
    public final boolean mo31121f() {
        return this.f26408j.mo30863a();
    }
}
