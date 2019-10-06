package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;

@TargetApi(16)
@zzard
public final class zzbgp extends zzbft implements zzbfi {

    /* renamed from: d */
    private zzbfa f25320d;

    /* renamed from: e */
    private String f25321e;

    /* renamed from: f */
    private boolean f25322f;

    /* renamed from: g */
    private Exception f25323g;

    /* renamed from: h */
    private boolean f25324h;

    public zzbgp(zzbdf zzbdf, zzbde zzbde) {
        super(zzbdf);
        this.f25320d = new zzbfa(zzbdf.getContext(), zzbde);
        this.f25320d.mo30509a((zzbfi) this);
    }

    /* renamed from: a */
    public final void mo30473a(boolean z, long j) {
        zzbdf zzbdf = (zzbdf) this.f25279c.get();
        if (zzbdf != null) {
            zzbbm.f25064a.execute(new C8912Ie(zzbdf, z, j));
        }
    }

    /* renamed from: a */
    public final void mo30469a(int i) {
    }

    /* renamed from: a */
    public final void mo30470a(int i, int i2) {
    }

    /* renamed from: a */
    public final void mo30472a(String str, Exception exc) {
        this.f25323g = exc;
        zzbad.m26358c("Precache error", exc);
        m26773d(str);
    }

    /* renamed from: c */
    public final void mo30551c(int i) {
        this.f25320d.mo30533g().mo30498d(i);
    }

    /* renamed from: b */
    public final void mo30550b(int i) {
        this.f25320d.mo30533g().mo30497c(i);
    }

    /* renamed from: d */
    public final void mo30552d(int i) {
        this.f25320d.mo30533g().mo30490a(i);
    }

    /* renamed from: e */
    public final void mo30553e(int i) {
        this.f25320d.mo30533g().mo30495b(i);
    }

    /* renamed from: a */
    public final void mo27353a() {
        zzbfa zzbfa = this.f25320d;
        if (zzbfa != null) {
            zzbfa.mo30509a((zzbfi) null);
            this.f25320d.mo30530c();
        }
        super.mo27353a();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final String mo30548b(String str) {
        String valueOf = String.valueOf("cache:");
        String valueOf2 = String.valueOf(super.mo30548b(str));
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    /* renamed from: a */
    public final boolean mo30546a(String str) {
        return mo30547a(str, new String[]{str});
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0087, code lost:
        if (r11.f25323g == null) goto L_0x008e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0089, code lost:
        r1 = "badUrl";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x008d, code lost:
        throw r11.f25323g;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x008e, code lost:
        r1 = "externalAbort";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0097, code lost:
        throw new java.io.IOException("Abort requested before buffering finished. ");
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean mo30547a(java.lang.String r34, java.lang.String[] r35) {
        /*
            r33 = this;
            r11 = r33
            r12 = r34
            r0 = r35
            r11.f25321e = r12
            java.lang.String r13 = r33.mo30548b(r34)
            java.lang.String r14 = "error"
            int r1 = r0.length     // Catch:{ Exception -> 0x0165 }
            android.net.Uri[] r1 = new android.net.Uri[r1]     // Catch:{ Exception -> 0x0165 }
            r2 = 0
        L_0x0012:
            int r3 = r0.length     // Catch:{ Exception -> 0x0165 }
            if (r2 >= r3) goto L_0x0023
            r3 = r0[r2]     // Catch:{ Exception -> 0x0020 }
            android.net.Uri r3 = android.net.Uri.parse(r3)     // Catch:{ Exception -> 0x0020 }
            r1[r2] = r3     // Catch:{ Exception -> 0x0020 }
            int r2 = r2 + 1
            goto L_0x0012
        L_0x0020:
            r0 = move-exception
            goto L_0x0168
        L_0x0023:
            com.google.android.gms.internal.ads.zzbfa r0 = r11.f25320d     // Catch:{ Exception -> 0x0165 }
            java.lang.String r2 = r11.f25278b     // Catch:{ Exception -> 0x0165 }
            r0.mo30524a(r1, r2)     // Catch:{ Exception -> 0x0165 }
            java.lang.ref.WeakReference<com.google.android.gms.internal.ads.zzbdf> r0 = r11.f25279c     // Catch:{ Exception -> 0x0165 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x0165 }
            com.google.android.gms.internal.ads.zzbdf r0 = (com.google.android.gms.internal.ads.zzbdf) r0     // Catch:{ Exception -> 0x0165 }
            if (r0 == 0) goto L_0x0037
            r0.mo28727a(r13, r11)     // Catch:{ Exception -> 0x0020 }
        L_0x0037:
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzk.zzln()     // Catch:{ Exception -> 0x0165 }
            long r16 = r0.mo27935b()     // Catch:{ Exception -> 0x0165 }
            com.google.android.gms.internal.ads.zzacj<java.lang.Long> r1 = com.google.android.gms.internal.ads.zzacu.f23926F     // Catch:{ Exception -> 0x0165 }
            com.google.android.gms.internal.ads.zzacr r2 = com.google.android.gms.internal.ads.zzyt.m31536e()     // Catch:{ Exception -> 0x0165 }
            java.lang.Object r1 = r2.mo29599a(r1)     // Catch:{ Exception -> 0x0165 }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ Exception -> 0x0165 }
            long r9 = r1.longValue()     // Catch:{ Exception -> 0x0165 }
            com.google.android.gms.internal.ads.zzacj<java.lang.Long> r1 = com.google.android.gms.internal.ads.zzacu.f23920E     // Catch:{ Exception -> 0x0165 }
            com.google.android.gms.internal.ads.zzacr r2 = com.google.android.gms.internal.ads.zzyt.m31536e()     // Catch:{ Exception -> 0x0165 }
            java.lang.Object r1 = r2.mo29599a(r1)     // Catch:{ Exception -> 0x0165 }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ Exception -> 0x0165 }
            long r1 = r1.longValue()     // Catch:{ Exception -> 0x0165 }
            r3 = 1000(0x3e8, double:4.94E-321)
            long r6 = r1 * r3
            com.google.android.gms.internal.ads.zzacj<java.lang.Integer> r1 = com.google.android.gms.internal.ads.zzacu.f23914D     // Catch:{ Exception -> 0x0165 }
            com.google.android.gms.internal.ads.zzacr r2 = com.google.android.gms.internal.ads.zzyt.m31536e()     // Catch:{ Exception -> 0x0165 }
            java.lang.Object r1 = r2.mo29599a(r1)     // Catch:{ Exception -> 0x0165 }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ Exception -> 0x0165 }
            int r1 = r1.intValue()     // Catch:{ Exception -> 0x0165 }
            long r4 = (long) r1     // Catch:{ Exception -> 0x0165 }
            r1 = -1
        L_0x0076:
            monitor-enter(r33)     // Catch:{ Exception -> 0x0165 }
            long r18 = r0.mo27935b()     // Catch:{ all -> 0x015e }
            long r18 = r18 - r16
            int r3 = (r18 > r6 ? 1 : (r18 == r6 ? 0 : -1))
            if (r3 > 0) goto L_0x0131
            boolean r3 = r11.f25322f     // Catch:{ all -> 0x015e }
            if (r3 == 0) goto L_0x0098
            java.lang.Exception r0 = r11.f25323g     // Catch:{ all -> 0x0163 }
            if (r0 == 0) goto L_0x008e
            java.lang.String r1 = "badUrl"
            java.lang.Exception r0 = r11.f25323g     // Catch:{ all -> 0x0157 }
            throw r0     // Catch:{ all -> 0x0157 }
        L_0x008e:
            java.lang.String r1 = "externalAbort"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0157 }
            java.lang.String r2 = "Abort requested before buffering finished. "
            r0.<init>(r2)     // Catch:{ all -> 0x0157 }
            throw r0     // Catch:{ all -> 0x0157 }
        L_0x0098:
            boolean r3 = r11.f25324h     // Catch:{ all -> 0x015e }
            r18 = 1
            if (r3 == 0) goto L_0x00a1
            monitor-exit(r33)     // Catch:{ all -> 0x0163 }
            goto L_0x0103
        L_0x00a1:
            com.google.android.gms.internal.ads.zzbfa r3 = r11.f25320d     // Catch:{ all -> 0x015e }
            com.google.android.gms.internal.ads.zzkv r3 = r3.mo30531f()     // Catch:{ all -> 0x015e }
            if (r3 == 0) goto L_0x0125
            r20 = r14
            long r14 = r3.getDuration()     // Catch:{ all -> 0x015a }
            r21 = 0
            int r8 = (r14 > r21 ? 1 : (r14 == r21 ? 0 : -1))
            if (r8 <= 0) goto L_0x0104
            long r23 = r3.mo29277b()     // Catch:{ all -> 0x015a }
            int r3 = (r23 > r1 ? 1 : (r23 == r1 ? 0 : -1))
            if (r3 == 0) goto L_0x00e5
            int r1 = (r23 > r21 ? 1 : (r23 == r21 ? 0 : -1))
            if (r1 <= 0) goto L_0x00c3
            r8 = 1
            goto L_0x00c4
        L_0x00c3:
            r8 = 0
        L_0x00c4:
            int r25 = com.google.android.gms.internal.ads.zzbfa.m26660d()     // Catch:{ all -> 0x015a }
            int r26 = com.google.android.gms.internal.ads.zzbfa.m26661e()     // Catch:{ all -> 0x015a }
            r1 = r33
            r2 = r34
            r3 = r13
            r27 = r4
            r4 = r23
            r29 = r6
            r6 = r14
            r31 = r9
            r9 = r25
            r10 = r26
            r1.mo30544a(r2, r3, r4, r6, r8, r9, r10)     // Catch:{ all -> 0x015a }
            r1 = r23
            goto L_0x00eb
        L_0x00e5:
            r27 = r4
            r29 = r6
            r31 = r9
        L_0x00eb:
            int r3 = (r23 > r14 ? 1 : (r23 == r14 ? 0 : -1))
            if (r3 < 0) goto L_0x00f4
            r11.mo30542a(r12, r13, r14)     // Catch:{ all -> 0x015a }
            monitor-exit(r33)     // Catch:{ all -> 0x015a }
            goto L_0x0103
        L_0x00f4:
            com.google.android.gms.internal.ads.zzbfa r3 = r11.f25320d     // Catch:{ all -> 0x015a }
            long r3 = r3.mo30526b()     // Catch:{ all -> 0x015a }
            int r5 = (r3 > r27 ? 1 : (r3 == r27 ? 0 : -1))
            if (r5 < 0) goto L_0x010a
            int r3 = (r23 > r21 ? 1 : (r23 == r21 ? 0 : -1))
            if (r3 <= 0) goto L_0x010a
            monitor-exit(r33)     // Catch:{ all -> 0x015a }
        L_0x0103:
            return r18
        L_0x0104:
            r27 = r4
            r29 = r6
            r31 = r9
        L_0x010a:
            r3 = r31
            r11.wait(r3)     // Catch:{ InterruptedException -> 0x011a }
            monitor-exit(r33)     // Catch:{ all -> 0x015a }
            r9 = r3
            r14 = r20
            r4 = r27
            r6 = r29
            goto L_0x0076
        L_0x011a:
            r0 = move-exception
            java.lang.String r1 = "interrupted"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0157 }
            java.lang.String r2 = "Wait interrupted."
            r0.<init>(r2)     // Catch:{ all -> 0x0157 }
            throw r0     // Catch:{ all -> 0x0157 }
        L_0x0125:
            r20 = r14
            java.lang.String r1 = "exoPlayerReleased"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0157 }
            java.lang.String r2 = "ExoPlayer was released during preloading."
            r0.<init>(r2)     // Catch:{ all -> 0x0157 }
            throw r0     // Catch:{ all -> 0x0157 }
        L_0x0131:
            r29 = r6
            r20 = r14
            java.lang.String r1 = "downloadTimeout"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0157 }
            r2 = 47
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0157 }
            r3.<init>(r2)     // Catch:{ all -> 0x0157 }
            java.lang.String r2 = "Timeout reached. Limit: "
            r3.append(r2)     // Catch:{ all -> 0x0157 }
            r4 = r29
            r3.append(r4)     // Catch:{ all -> 0x0157 }
            java.lang.String r2 = " ms"
            r3.append(r2)     // Catch:{ all -> 0x0157 }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x0157 }
            r0.<init>(r2)     // Catch:{ all -> 0x0157 }
            throw r0     // Catch:{ all -> 0x0157 }
        L_0x0157:
            r0 = move-exception
            r14 = r1
            goto L_0x0161
        L_0x015a:
            r0 = move-exception
            r14 = r20
            goto L_0x0161
        L_0x015e:
            r0 = move-exception
            r20 = r14
        L_0x0161:
            monitor-exit(r33)     // Catch:{ all -> 0x0163 }
            throw r0     // Catch:{ Exception -> 0x0020 }
        L_0x0163:
            r0 = move-exception
            goto L_0x0161
        L_0x0165:
            r0 = move-exception
            r20 = r14
        L_0x0168:
            java.lang.String r1 = r0.getMessage()
            java.lang.String r2 = java.lang.String.valueOf(r34)
            int r2 = r2.length()
            int r2 = r2 + 34
            java.lang.String r3 = java.lang.String.valueOf(r1)
            int r3 = r3.length()
            int r2 = r2 + r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r2 = "Failed to preload url "
            r3.append(r2)
            r3.append(r12)
            java.lang.String r2 = " Exception: "
            r3.append(r2)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            com.google.android.gms.internal.ads.zzbad.m26359d(r1)
            r33.mo27353a()
            java.lang.String r0 = m26772b(r14, r0)
            r11.mo30545a(r12, r13, r14, r0)
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbgp.mo30547a(java.lang.String, java.lang.String[]):boolean");
    }

    /* renamed from: b */
    public final void mo30549b() {
        m26773d((String) null);
    }

    /* renamed from: d */
    private final void m26773d(String str) {
        synchronized (this) {
            this.f25322f = true;
            notify();
            mo27353a();
        }
        String str2 = this.f25321e;
        if (str2 != null) {
            String b = mo30548b(str2);
            Exception exc = this.f25323g;
            if (exc != null) {
                mo30545a(this.f25321e, b, "badUrl", m26772b(str, exc));
                return;
            }
            mo30545a(this.f25321e, b, "externalAbort", "Programmatic precache abort.");
        }
    }

    /* renamed from: c */
    public final zzbfa mo30568c() {
        synchronized (this) {
            this.f25324h = true;
            notify();
        }
        this.f25320d.mo30509a((zzbfi) null);
        zzbfa zzbfa = this.f25320d;
        this.f25320d = null;
        return zzbfa;
    }

    /* renamed from: b */
    private static String m26772b(String str, Exception exc) {
        String canonicalName = exc.getClass().getCanonicalName();
        String message = exc.getMessage();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(canonicalName).length() + String.valueOf(message).length());
        sb.append(str);
        sb.append("/");
        sb.append(canonicalName);
        sb.append(":");
        sb.append(message);
        return sb.toString();
    }
}
