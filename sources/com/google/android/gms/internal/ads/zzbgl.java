package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;

@TargetApi(16)
@zzard
public abstract class zzbgl extends zzbft {

    /* renamed from: d */
    private final zzbdk f25307d = new zzbdk();

    /* renamed from: e */
    private boolean f25308e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public String f25309f = null;

    /* renamed from: g */
    private boolean f25310g;

    public zzbgl(zzbdf zzbdf) {
        super(zzbdf);
        this.f25307d.mo30444a((zzbdo) new C8870Ge(this));
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract int mo30561c();

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract zzhn mo30562c(String str);

    /* renamed from: a */
    public void mo27353a() {
        this.f25307d.mo30447d();
        super.mo27353a();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final String mo30548b(String str) {
        String valueOf = String.valueOf("cache:");
        String valueOf2 = String.valueOf(super.mo30548b(str));
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0082, code lost:
        if (android.text.TextUtils.isEmpty(r9.f25309f) != false) goto L_0x0089;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0084, code lost:
        r1 = "badUrl";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r14 = r9.f25309f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0089, code lost:
        r1 = "externalAbort";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0092, code lost:
        throw new java.io.IOException("Abort requested before buffering finished. ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
        java.lang.Thread.sleep(r18);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x012b, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x012c, code lost:
        r12 = r1;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean mo30546a(java.lang.String r32) {
        /*
            r31 = this;
            r9 = r31
            r10 = r32
            com.google.android.gms.internal.ads.zzhn r0 = r31.mo30562c(r32)
            java.lang.String r11 = r31.mo30548b(r32)
            java.lang.String r12 = "error"
            r13 = 0
            r14 = 0
            com.google.android.gms.internal.ads.zzbdk r1 = r9.f25307d     // Catch:{ IOException -> 0x014f }
            boolean r0 = r1.mo30446a(r0)     // Catch:{ IOException -> 0x014f }
            if (r0 == 0) goto L_0x0140
            com.google.android.gms.internal.ads.zzbdk r0 = r9.f25307d     // Catch:{ IOException -> 0x014f }
            com.google.android.gms.internal.ads.zzge r0 = r0.mo30448e()     // Catch:{ IOException -> 0x014f }
            if (r0 == 0) goto L_0x0131
            java.lang.ref.WeakReference<com.google.android.gms.internal.ads.zzbdf> r1 = r9.f25279c     // Catch:{ IOException -> 0x014f }
            java.lang.Object r1 = r1.get()     // Catch:{ IOException -> 0x014f }
            com.google.android.gms.internal.ads.zzbdf r1 = (com.google.android.gms.internal.ads.zzbdf) r1     // Catch:{ IOException -> 0x014f }
            if (r1 == 0) goto L_0x002e
            r1.mo28727a(r11, r9)     // Catch:{ IOException -> 0x014f }
        L_0x002e:
            com.google.android.gms.common.util.Clock r15 = com.google.android.gms.ads.internal.zzk.zzln()     // Catch:{ IOException -> 0x014f }
            long r16 = r15.mo27935b()     // Catch:{ IOException -> 0x014f }
            com.google.android.gms.internal.ads.zzacj<java.lang.Long> r1 = com.google.android.gms.internal.ads.zzacu.f23926F     // Catch:{ IOException -> 0x014f }
            com.google.android.gms.internal.ads.zzacr r2 = com.google.android.gms.internal.ads.zzyt.m31536e()     // Catch:{ IOException -> 0x014f }
            java.lang.Object r1 = r2.mo29599a(r1)     // Catch:{ IOException -> 0x014f }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ IOException -> 0x014f }
            long r18 = r1.longValue()     // Catch:{ IOException -> 0x014f }
            com.google.android.gms.internal.ads.zzacj<java.lang.Long> r1 = com.google.android.gms.internal.ads.zzacu.f23920E     // Catch:{ IOException -> 0x014f }
            com.google.android.gms.internal.ads.zzacr r2 = com.google.android.gms.internal.ads.zzyt.m31536e()     // Catch:{ IOException -> 0x014f }
            java.lang.Object r1 = r2.mo29599a(r1)     // Catch:{ IOException -> 0x014f }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ IOException -> 0x014f }
            long r1 = r1.longValue()     // Catch:{ IOException -> 0x014f }
            r3 = 1000(0x3e8, double:4.94E-321)
            long r20 = r1 * r3
            com.google.android.gms.internal.ads.zzacj<java.lang.Integer> r1 = com.google.android.gms.internal.ads.zzacu.f23914D     // Catch:{ IOException -> 0x014f }
            com.google.android.gms.internal.ads.zzacr r2 = com.google.android.gms.internal.ads.zzyt.m31536e()     // Catch:{ IOException -> 0x014f }
            java.lang.Object r1 = r2.mo29599a(r1)     // Catch:{ IOException -> 0x014f }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ IOException -> 0x014f }
            int r1 = r1.intValue()     // Catch:{ IOException -> 0x014f }
            long r6 = (long) r1     // Catch:{ IOException -> 0x014f }
            r1 = -1
        L_0x006d:
            monitor-enter(r31)     // Catch:{ IOException -> 0x014f }
            long r3 = r15.mo27935b()     // Catch:{ all -> 0x012e }
            long r3 = r3 - r16
            int r5 = (r3 > r20 ? 1 : (r3 == r20 ? 0 : -1))
            if (r5 > 0) goto L_0x00f9
            boolean r3 = r9.f25308e     // Catch:{ all -> 0x012e }
            if (r3 == 0) goto L_0x0093
            java.lang.String r0 = r9.f25309f     // Catch:{ all -> 0x012e }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x012e }
            if (r0 != 0) goto L_0x0089
            java.lang.String r1 = "badUrl"
            java.lang.String r14 = r9.f25309f     // Catch:{ all -> 0x012b }
            goto L_0x008b
        L_0x0089:
            java.lang.String r1 = "externalAbort"
        L_0x008b:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x012b }
            java.lang.String r2 = "Abort requested before buffering finished. "
            r0.<init>(r2)     // Catch:{ all -> 0x012b }
            throw r0     // Catch:{ all -> 0x012b }
        L_0x0093:
            boolean r3 = r9.f25310g     // Catch:{ all -> 0x012e }
            r22 = 1
            if (r3 == 0) goto L_0x009b
            monitor-exit(r31)     // Catch:{ all -> 0x012e }
            goto L_0x00e2
        L_0x009b:
            long r4 = r0.getDuration()     // Catch:{ all -> 0x012e }
            r23 = 0
            int r3 = (r4 > r23 ? 1 : (r4 == r23 ? 0 : -1))
            if (r3 <= 0) goto L_0x00e3
            long r25 = r0.mo28336b()     // Catch:{ all -> 0x012e }
            int r3 = (r25 > r1 ? 1 : (r25 == r1 ? 0 : -1))
            if (r3 == 0) goto L_0x00c7
            int r1 = (r25 > r23 ? 1 : (r25 == r23 ? 0 : -1))
            if (r1 <= 0) goto L_0x00b3
            r8 = 1
            goto L_0x00b4
        L_0x00b3:
            r8 = 0
        L_0x00b4:
            r1 = r31
            r2 = r32
            r3 = r11
            r27 = r4
            r4 = r25
            r29 = r6
            r6 = r27
            r1.mo30543a(r2, r3, r4, r6, r8)     // Catch:{ all -> 0x012e }
            r1 = r25
            goto L_0x00cb
        L_0x00c7:
            r27 = r4
            r29 = r6
        L_0x00cb:
            r3 = r27
            int r5 = (r25 > r3 ? 1 : (r25 == r3 ? 0 : -1))
            if (r5 < 0) goto L_0x00d6
            r9.mo30542a(r10, r11, r3)     // Catch:{ all -> 0x012e }
            monitor-exit(r31)     // Catch:{ all -> 0x012e }
            goto L_0x00e2
        L_0x00d6:
            r31.mo30561c()     // Catch:{ all -> 0x012e }
            int r3 = (r23 > r29 ? 1 : (r23 == r29 ? 0 : -1))
            if (r3 < 0) goto L_0x00e5
            int r3 = (r25 > r23 ? 1 : (r25 == r23 ? 0 : -1))
            if (r3 <= 0) goto L_0x00e5
            monitor-exit(r31)     // Catch:{ all -> 0x012e }
        L_0x00e2:
            return r22
        L_0x00e3:
            r29 = r6
        L_0x00e5:
            monitor-exit(r31)     // Catch:{ all -> 0x012e }
            java.lang.Thread.sleep(r18)     // Catch:{ InterruptedException -> 0x00ec }
            r6 = r29
            goto L_0x006d
        L_0x00ec:
            r0 = move-exception
            java.lang.String r12 = "error"
            java.lang.String r14 = "Sleep interrupted."
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x014f }
            java.lang.String r1 = "Interrupted sleep."
            r0.<init>(r1)     // Catch:{ IOException -> 0x014f }
            throw r0     // Catch:{ IOException -> 0x014f }
        L_0x00f9:
            java.lang.String r1 = "downloadTimeout"
            java.lang.String r0 = java.lang.Long.toString(r20)     // Catch:{ all -> 0x012b }
            java.lang.String r2 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x012b }
            int r2 = r2.length()     // Catch:{ all -> 0x012b }
            int r2 = r2 + 27
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x012b }
            r3.<init>(r2)     // Catch:{ all -> 0x012b }
            java.lang.String r2 = "Timeout reached. Limit: "
            r3.append(r2)     // Catch:{ all -> 0x012b }
            r3.append(r0)     // Catch:{ all -> 0x012b }
            java.lang.String r0 = " ms"
            r3.append(r0)     // Catch:{ all -> 0x012b }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x012b }
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0127 }
            java.lang.String r3 = "Timed out while buffering."
            r0.<init>(r3)     // Catch:{ all -> 0x0127 }
            throw r0     // Catch:{ all -> 0x0127 }
        L_0x0127:
            r0 = move-exception
            r12 = r1
            r14 = r2
            goto L_0x012f
        L_0x012b:
            r0 = move-exception
            r12 = r1
            goto L_0x012f
        L_0x012e:
            r0 = move-exception
        L_0x012f:
            monitor-exit(r31)     // Catch:{ all -> 0x012e }
            throw r0     // Catch:{ IOException -> 0x014f }
        L_0x0131:
            java.lang.String r12 = "playerFailed"
            java.lang.String r14 = "ExoPlayer not created"
            r31.mo27353a()     // Catch:{ IOException -> 0x014f }
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x014f }
            java.lang.String r1 = "Failed to get ExoPlayer"
            r0.<init>(r1)     // Catch:{ IOException -> 0x014f }
            throw r0     // Catch:{ IOException -> 0x014f }
        L_0x0140:
            java.lang.String r12 = "playerFailed"
            java.lang.String r14 = "ExoPlayer prepare failed"
            r31.mo27353a()     // Catch:{ IOException -> 0x014f }
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x014f }
            java.lang.String r1 = "Failed to prepare AdExoPlayerHelper"
            r0.<init>(r1)     // Catch:{ IOException -> 0x014f }
            throw r0     // Catch:{ IOException -> 0x014f }
        L_0x014f:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            java.lang.String r1 = java.lang.String.valueOf(r32)
            int r1 = r1.length()
            int r1 = r1 + 34
            java.lang.String r2 = java.lang.String.valueOf(r0)
            int r2 = r2.length()
            int r1 = r1 + r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            java.lang.String r1 = "Failed to preload url "
            r2.append(r1)
            r2.append(r10)
            java.lang.String r1 = " Exception: "
            r2.append(r1)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.google.android.gms.internal.ads.zzbad.m26359d(r0)
            r9.mo30545a(r10, r11, r12, r14)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbgl.mo30546a(java.lang.String):boolean");
    }

    /* renamed from: b */
    public final void mo30549b() {
        synchronized (this) {
            this.f25308e = true;
        }
    }

    /* renamed from: d */
    public final void mo30563d() {
        synchronized (this) {
            this.f25310g = true;
            this.f25307d.mo30443a();
        }
    }

    /* renamed from: e */
    public final zzbdk mo30564e() {
        return this.f25307d;
    }
}
