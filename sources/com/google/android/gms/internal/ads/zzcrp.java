package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzcrp implements zzcva<zzcro> {

    /* renamed from: a */
    private final zzcva<zzcvf> f27290a;

    /* renamed from: b */
    private final zzcxv f27291b;

    /* renamed from: c */
    private final Context f27292c;

    /* renamed from: d */
    private final zzawm f27293d;

    public zzcrp(zzcsk<zzcvf> zzcsk, zzcxv zzcxv, Context context, zzawm zzawm) {
        this.f27290a = zzcsk;
        this.f27291b = zzcxv;
        this.f27292c = context;
        this.f27293d = zzawm;
    }

    /* renamed from: a */
    public final zzbbh<zzcro> mo28586a() {
        return zzbar.m26380a(this.f27290a.mo28586a(), (zzbam<A, B>) new C9474hl<A,B>(this), zzbbm.f25065b);
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0070  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ com.google.android.gms.internal.ads.zzcro mo31252a(com.google.android.gms.internal.ads.zzcvf r17) {
        /*
            r16 = this;
            r0 = r16
            com.google.android.gms.internal.ads.zzcxv r1 = r0.f27291b
            com.google.android.gms.internal.ads.zzyd r3 = r1.f27601e
            com.google.android.gms.internal.ads.zzyd[] r1 = r3.f29774g
            r2 = 0
            if (r1 != 0) goto L_0x0014
            java.lang.String r1 = r3.f29768a
            boolean r6 = r3.f29776i
            r10 = r1
            r11 = r6
            goto L_0x003a
        L_0x0014:
            int r6 = r1.length
            r10 = r2
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 0
        L_0x001c:
            if (r7 >= r6) goto L_0x003a
            r12 = r1[r7]
            boolean r13 = r12.f29776i
            if (r13 != 0) goto L_0x002a
            if (r8 != 0) goto L_0x002a
            java.lang.String r8 = r12.f29768a
            r10 = r8
            r8 = 1
        L_0x002a:
            boolean r12 = r12.f29776i
            if (r12 == 0) goto L_0x0033
            if (r9 != 0) goto L_0x0033
            r9 = 1
            r11 = 1
        L_0x0033:
            if (r8 == 0) goto L_0x0037
            if (r9 != 0) goto L_0x003a
        L_0x0037:
            int r7 = r7 + 1
            goto L_0x001c
        L_0x003a:
            android.content.Context r1 = r0.f27292c
            android.content.res.Resources r1 = r1.getResources()
            if (r1 == 0) goto L_0x0061
            android.util.DisplayMetrics r1 = r1.getDisplayMetrics()
            if (r1 == 0) goto L_0x0061
            float r2 = r1.density
            int r7 = r1.widthPixels
            int r1 = r1.heightPixels
            com.google.android.gms.internal.ads.zzawm r8 = r0.f27293d
            com.google.android.gms.internal.ads.zzaxb r8 = r8.mo30177i()
            java.lang.String r8 = r8.mo30199a()
            r9 = r1
            r1 = r8
            r8 = r7
            r7 = r2
            goto L_0x0065
        L_0x0061:
            r1 = r2
            r7 = 0
            r8 = 0
            r9 = 0
        L_0x0065:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            com.google.android.gms.internal.ads.zzyd[] r12 = r3.f29774g
            if (r12 == 0) goto L_0x00d2
            int r13 = r12.length
            r14 = 0
            r15 = 0
        L_0x0074:
            java.lang.String r4 = "|"
            if (r14 >= r13) goto L_0x00bf
            r5 = r12[r14]
            boolean r6 = r5.f29776i
            if (r6 == 0) goto L_0x0081
            r6 = 0
            r15 = 1
            goto L_0x00bc
        L_0x0081:
            int r6 = r2.length()
            if (r6 == 0) goto L_0x008a
            r2.append(r4)
        L_0x008a:
            int r4 = r5.f29772e
            r6 = -1
            if (r4 != r6) goto L_0x009b
            r4 = 0
            int r6 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x009b
            int r4 = r5.f29773f
            float r4 = (float) r4
            float r4 = r4 / r7
            int r4 = (int) r4
            goto L_0x009d
        L_0x009b:
            int r4 = r5.f29772e
        L_0x009d:
            r2.append(r4)
            java.lang.String r4 = "x"
            r2.append(r4)
            int r4 = r5.f29769b
            r6 = -2
            if (r4 != r6) goto L_0x00b6
            r6 = 0
            int r4 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x00b7
            int r4 = r5.f29770c
            float r4 = (float) r4
            float r4 = r4 / r7
            int r4 = (int) r4
            goto L_0x00b9
        L_0x00b6:
            r6 = 0
        L_0x00b7:
            int r4 = r5.f29769b
        L_0x00b9:
            r2.append(r4)
        L_0x00bc:
            int r14 = r14 + 1
            goto L_0x0074
        L_0x00bf:
            if (r15 == 0) goto L_0x00d2
            int r5 = r2.length()
            if (r5 == 0) goto L_0x00cc
            r5 = 0
            r2.insert(r5, r4)
            goto L_0x00cd
        L_0x00cc:
            r5 = 0
        L_0x00cd:
            java.lang.String r4 = "320x50"
            r2.insert(r5, r4)
        L_0x00d2:
            java.lang.String r6 = r2.toString()
            com.google.android.gms.internal.ads.zzcro r12 = new com.google.android.gms.internal.ads.zzcro
            r2 = r12
            r4 = r10
            r5 = r11
            r10 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcrp.mo31252a(com.google.android.gms.internal.ads.zzcvf):com.google.android.gms.internal.ads.zzcro");
    }
}
