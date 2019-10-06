package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.text.TextUtils;
import android.util.Pair;
import java.util.HashMap;

@TargetApi(16)
public final class zzgx {

    /* renamed from: a */
    private static final HashMap<C9880a, Pair<String, CodecCapabilities>> f28485a = new HashMap<>();

    /* renamed from: com.google.android.gms.internal.ads.zzgx$a */
    static final class C9880a {

        /* renamed from: a */
        public final String f28486a;

        /* renamed from: b */
        public final boolean f28487b;

        public C9880a(String str, boolean z) {
            this.f28486a = str;
            this.f28487b = z;
        }

        public final int hashCode() {
            String str = this.f28486a;
            return (((str == null ? 0 : str.hashCode()) + 31) * 31) + (this.f28487b ? 1231 : 1237);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != C9880a.class) {
                return false;
            }
            C9880a aVar = (C9880a) obj;
            if (!TextUtils.equals(this.f28486a, aVar.f28486a) || this.f28487b != aVar.f28487b) {
                return false;
            }
            return true;
        }
    }

    /* renamed from: a */
    public static zzgc m30326a(String str, boolean z) throws zzgz {
        boolean z2;
        Pair b = m30327b(str, z);
        if (b == null) {
            return null;
        }
        String str2 = (String) b.first;
        CodecCapabilities codecCapabilities = (CodecCapabilities) b.second;
        if (zzkq.f28747a >= 19) {
            z2 = codecCapabilities.isFeatureSupported("adaptive-playback");
        } else {
            z2 = false;
        }
        return new zzgc(str2, z2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0079, code lost:
        return r2;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized android.util.Pair<java.lang.String, android.media.MediaCodecInfo.CodecCapabilities> m30327b(java.lang.String r6, boolean r7) throws com.google.android.gms.internal.ads.zzgz {
        /*
            java.lang.Class<com.google.android.gms.internal.ads.zzgx> r0 = com.google.android.gms.internal.ads.zzgx.class
            monitor-enter(r0)
            com.google.android.gms.internal.ads.zzgx$a r1 = new com.google.android.gms.internal.ads.zzgx$a     // Catch:{ all -> 0x007a }
            r1.<init>(r6, r7)     // Catch:{ all -> 0x007a }
            java.util.HashMap<com.google.android.gms.internal.ads.zzgx$a, android.util.Pair<java.lang.String, android.media.MediaCodecInfo$CodecCapabilities>> r2 = f28485a     // Catch:{ all -> 0x007a }
            boolean r2 = r2.containsKey(r1)     // Catch:{ all -> 0x007a }
            if (r2 == 0) goto L_0x001a
            java.util.HashMap<com.google.android.gms.internal.ads.zzgx$a, android.util.Pair<java.lang.String, android.media.MediaCodecInfo$CodecCapabilities>> r6 = f28485a     // Catch:{ all -> 0x007a }
            java.lang.Object r6 = r6.get(r1)     // Catch:{ all -> 0x007a }
            android.util.Pair r6 = (android.util.Pair) r6     // Catch:{ all -> 0x007a }
            monitor-exit(r0)
            return r6
        L_0x001a:
            int r2 = com.google.android.gms.internal.ads.zzkq.f28747a     // Catch:{ all -> 0x007a }
            r3 = 0
            r4 = 21
            if (r2 < r4) goto L_0x0027
            com.google.android.gms.internal.ads.Tq r2 = new com.google.android.gms.internal.ads.Tq     // Catch:{ all -> 0x007a }
            r2.<init>(r7)     // Catch:{ all -> 0x007a }
            goto L_0x002c
        L_0x0027:
            com.google.android.gms.internal.ads.Sq r2 = new com.google.android.gms.internal.ads.Sq     // Catch:{ all -> 0x007a }
            r2.<init>()     // Catch:{ all -> 0x007a }
        L_0x002c:
            android.util.Pair r2 = m30325a(r1, r2)     // Catch:{ all -> 0x007a }
            if (r7 == 0) goto L_0x0078
            if (r2 != 0) goto L_0x0078
            int r7 = com.google.android.gms.internal.ads.zzkq.f28747a     // Catch:{ all -> 0x007a }
            if (r7 < r4) goto L_0x0078
            com.google.android.gms.internal.ads.Sq r7 = new com.google.android.gms.internal.ads.Sq     // Catch:{ all -> 0x007a }
            r7.<init>()     // Catch:{ all -> 0x007a }
            android.util.Pair r2 = m30325a(r1, r7)     // Catch:{ all -> 0x007a }
            if (r2 == 0) goto L_0x0078
            java.lang.String r7 = "MediaCodecUtil"
            java.lang.Object r1 = r2.first     // Catch:{ all -> 0x007a }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x007a }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x007a }
            java.lang.String r4 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x007a }
            int r4 = r4.length()     // Catch:{ all -> 0x007a }
            int r4 = r4 + 63
            java.lang.String r5 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x007a }
            int r5 = r5.length()     // Catch:{ all -> 0x007a }
            int r4 = r4 + r5
            r3.<init>(r4)     // Catch:{ all -> 0x007a }
            java.lang.String r4 = "MediaCodecList API didn't list secure decoder for: "
            r3.append(r4)     // Catch:{ all -> 0x007a }
            r3.append(r6)     // Catch:{ all -> 0x007a }
            java.lang.String r6 = ". Assuming: "
            r3.append(r6)     // Catch:{ all -> 0x007a }
            r3.append(r1)     // Catch:{ all -> 0x007a }
            java.lang.String r6 = r3.toString()     // Catch:{ all -> 0x007a }
            android.util.Log.w(r7, r6)     // Catch:{ all -> 0x007a }
        L_0x0078:
            monitor-exit(r0)
            return r2
        L_0x007a:
            r6 = move-exception
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgx.m30327b(java.lang.String, boolean):android.util.Pair");
    }

    /* renamed from: a */
    private static Pair<String, CodecCapabilities> m30325a(C9880a aVar, C9112Rq rq) throws zzgz {
        C9880a aVar2 = aVar;
        C9112Rq rq2 = rq;
        try {
            String str = aVar2.f28486a;
            int a = rq.mo28574a();
            boolean b = rq.mo28577b();
            boolean z = false;
            int i = 0;
            while (i < a) {
                MediaCodecInfo a2 = rq2.mo28575a(i);
                String name = a2.getName();
                if (!a2.isEncoder() && name.startsWith("OMX.")) {
                    String str2 = ".secure";
                    if (!b) {
                        if (name.endsWith(str2)) {
                            continue;
                        }
                    }
                    String[] supportedTypes = a2.getSupportedTypes();
                    int i2 = 0;
                    while (i2 < supportedTypes.length) {
                        String str3 = supportedTypes[i2];
                        if (str3.equalsIgnoreCase(str)) {
                            CodecCapabilities capabilitiesForType = a2.getCapabilitiesForType(str3);
                            boolean a3 = rq2.mo28576a(aVar2.f28486a, capabilitiesForType);
                            if (!b) {
                                f28485a.put(aVar2.f28487b ? new C9880a(str, z) : aVar2, Pair.create(name, capabilitiesForType));
                                if (a3) {
                                    f28485a.put(aVar2.f28487b ? aVar2 : new C9880a(str, true), Pair.create(String.valueOf(name).concat(str2), capabilitiesForType));
                                }
                            } else {
                                f28485a.put(aVar2.f28487b == a3 ? aVar2 : new C9880a(str, a3), Pair.create(name, capabilitiesForType));
                            }
                            if (f28485a.containsKey(aVar2)) {
                                return (Pair) f28485a.get(aVar2);
                            }
                        }
                        i2++;
                        z = false;
                    }
                    continue;
                }
                i++;
                z = false;
            }
            return null;
        } catch (Exception e) {
            throw new zzgz(e);
        }
    }
}
