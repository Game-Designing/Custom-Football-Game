package com.google.android.gms.internal.ads;

@zzard
public final class zzvk {

    /* renamed from: a */
    private final zzva f29536a;

    /* renamed from: b */
    private final int f29537b;

    /* renamed from: c */
    private String f29538c;

    /* renamed from: d */
    private String f29539d;

    /* renamed from: e */
    private final boolean f29540e = false;

    /* renamed from: f */
    private final int f29541f;

    /* renamed from: g */
    private final int f29542g;

    public zzvk(int i, int i2, int i3) {
        this.f29537b = i;
        if (i2 > 64 || i2 < 0) {
            this.f29541f = 64;
        } else {
            this.f29541f = i2;
        }
        if (i3 <= 0) {
            this.f29542g = 1;
        } else {
            this.f29542g = i3;
        }
        this.f29536a = new zzvj(this.f29541f);
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0113 A[SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String mo32312a(java.util.ArrayList<java.lang.String> r17, java.util.ArrayList<com.google.android.gms.internal.ads.zzuz> r18) {
        /*
            r16 = this;
            r1 = r16
            r0 = r18
            com.google.android.gms.internal.ads.zzvl r2 = new com.google.android.gms.internal.ads.zzvl
            r2.<init>(r1)
            java.util.Collections.sort(r0, r2)
            java.util.HashSet r2 = new java.util.HashSet
            r2.<init>()
            r4 = 0
        L_0x0012:
            int r5 = r18.size()
            java.lang.String r6 = ""
            if (r4 >= r5) goto L_0x0121
            java.lang.Object r5 = r0.get(r4)
            com.google.android.gms.internal.ads.zzuz r5 = (com.google.android.gms.internal.ads.zzuz) r5
            int r5 = r5.mo32299e()
            r7 = r17
            java.lang.Object r5 = r7.get(r5)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            java.text.Normalizer$Form r8 = java.text.Normalizer.Form.NFKC
            java.lang.String r5 = java.text.Normalizer.normalize(r5, r8)
            java.util.Locale r8 = java.util.Locale.US
            java.lang.String r5 = r5.toLowerCase(r8)
            java.lang.String r8 = "\n"
            java.lang.String[] r5 = r5.split(r8)
            int r8 = r5.length
            if (r8 == 0) goto L_0x0119
            r8 = 0
        L_0x0043:
            int r10 = r5.length
            if (r8 >= r10) goto L_0x0117
            r10 = r5[r8]
            java.lang.String r11 = "'"
            int r11 = r10.indexOf(r11)
            r12 = -1
            if (r11 == r12) goto L_0x00ad
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>(r10)
            r12 = 1
            r13 = 0
        L_0x005a:
            int r14 = r12 + 2
            int r15 = r11.length()
            if (r14 > r15) goto L_0x009e
            char r15 = r11.charAt(r12)
            r3 = 39
            if (r15 != r3) goto L_0x009b
            int r3 = r12 + -1
            char r3 = r11.charAt(r3)
            r13 = 32
            if (r3 == r13) goto L_0x0097
            int r3 = r12 + 1
            char r15 = r11.charAt(r3)
            r9 = 115(0x73, float:1.61E-43)
            if (r15 == r9) goto L_0x0086
            char r3 = r11.charAt(r3)
            r9 = 83
            if (r3 != r9) goto L_0x0097
        L_0x0086:
            int r3 = r11.length()
            if (r14 == r3) goto L_0x0092
            char r3 = r11.charAt(r14)
            if (r3 != r13) goto L_0x0097
        L_0x0092:
            r11.insert(r12, r13)
            r12 = r14
            goto L_0x009a
        L_0x0097:
            r11.setCharAt(r12, r13)
        L_0x009a:
            r13 = 1
        L_0x009b:
            r3 = 1
            int r12 = r12 + r3
            goto L_0x005a
        L_0x009e:
            if (r13 == 0) goto L_0x00a5
            java.lang.String r3 = r11.toString()
            goto L_0x00a6
        L_0x00a5:
            r3 = 0
        L_0x00a6:
            if (r3 == 0) goto L_0x00ad
            r1.f29539d = r3
            goto L_0x00ae
        L_0x00ad:
            r3 = r10
        L_0x00ae:
            r9 = 1
            java.lang.String[] r3 = com.google.android.gms.internal.ads.zzve.m31287a(r3, r9)
            int r10 = r3.length
            int r11 = r1.f29542g
            if (r10 < r11) goto L_0x0113
            r10 = 0
        L_0x00b9:
            int r11 = r3.length
            if (r10 >= r11) goto L_0x0109
            r12 = r6
            r11 = 0
        L_0x00c0:
            int r13 = r1.f29542g
            if (r11 >= r13) goto L_0x00f6
            int r13 = r10 + r11
            int r14 = r3.length
            if (r13 < r14) goto L_0x00cc
            r11 = 0
            goto L_0x00f7
        L_0x00cc:
            if (r11 <= 0) goto L_0x00d8
            java.lang.String r12 = java.lang.String.valueOf(r12)
            java.lang.String r14 = " "
            java.lang.String r12 = r12.concat(r14)
        L_0x00d8:
            java.lang.String r12 = java.lang.String.valueOf(r12)
            r13 = r3[r13]
            java.lang.String r13 = java.lang.String.valueOf(r13)
            int r14 = r13.length()
            if (r14 == 0) goto L_0x00ed
            java.lang.String r12 = r12.concat(r13)
            goto L_0x00f3
        L_0x00ed:
            java.lang.String r13 = new java.lang.String
            r13.<init>(r12)
            r12 = r13
        L_0x00f3:
            int r11 = r11 + 1
            goto L_0x00c0
        L_0x00f6:
            r11 = 1
        L_0x00f7:
            if (r11 == 0) goto L_0x0109
            r2.add(r12)
            int r11 = r2.size()
            int r12 = r1.f29537b
            if (r11 < r12) goto L_0x0106
            r9 = 0
            goto L_0x011b
        L_0x0106:
            int r10 = r10 + 1
            goto L_0x00b9
        L_0x0109:
            int r3 = r2.size()
            int r10 = r1.f29537b
            if (r3 < r10) goto L_0x0113
            r9 = 0
            goto L_0x011b
        L_0x0113:
            int r8 = r8 + 1
            goto L_0x0043
        L_0x0117:
            r9 = 1
            goto L_0x011a
        L_0x0119:
            r9 = 1
        L_0x011a:
        L_0x011b:
            if (r9 == 0) goto L_0x0121
            int r4 = r4 + 1
            goto L_0x0012
        L_0x0121:
            com.google.android.gms.internal.ads.Bt r3 = new com.google.android.gms.internal.ads.Bt
            r3.<init>()
            r1.f29538c = r6
            java.util.Iterator r0 = r2.iterator()
        L_0x012c:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0148
            java.lang.Object r2 = r0.next()
            java.lang.String r2 = (java.lang.String) r2
            com.google.android.gms.internal.ads.zzva r4 = r1.f29536a     // Catch:{ IOException -> 0x0142 }
            byte[] r2 = r4.mo32305a(r2)     // Catch:{ IOException -> 0x0142 }
            r3.mo28066a(r2)     // Catch:{ IOException -> 0x0142 }
            goto L_0x012c
        L_0x0142:
            r0 = move-exception
            java.lang.String r2 = "Error while writing hash to byteStream"
            com.google.android.gms.internal.ads.zzbad.m26356b(r2, r0)
        L_0x0148:
            java.lang.String r0 = r3.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvk.mo32312a(java.util.ArrayList, java.util.ArrayList):java.lang.String");
    }
}
