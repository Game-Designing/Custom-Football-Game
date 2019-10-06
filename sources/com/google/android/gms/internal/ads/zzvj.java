package com.google.android.gms.internal.ads;

import java.security.MessageDigest;

@zzard
public final class zzvj extends zzva {

    /* renamed from: c */
    private MessageDigest f29533c;

    /* renamed from: d */
    private final int f29534d;

    /* renamed from: e */
    private final int f29535e;

    public zzvj(int i) {
        int i2 = i / 8;
        if (i % 8 > 0) {
            i2++;
        }
        this.f29534d = i2;
        this.f29535e = i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x006c, code lost:
        return r1;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] mo32305a(java.lang.String r9) {
        /*
            r8 = this;
            java.lang.Object r0 = r8.f29524b
            monitor-enter(r0)
            java.security.MessageDigest r1 = r8.mo32304a()     // Catch:{ all -> 0x006d }
            r8.f29533c = r1     // Catch:{ all -> 0x006d }
            java.security.MessageDigest r1 = r8.f29533c     // Catch:{ all -> 0x006d }
            r2 = 0
            if (r1 != 0) goto L_0x0012
            byte[] r9 = new byte[r2]     // Catch:{ all -> 0x006d }
            monitor-exit(r0)     // Catch:{ all -> 0x006d }
            return r9
        L_0x0012:
            java.security.MessageDigest r1 = r8.f29533c     // Catch:{ all -> 0x006d }
            r1.reset()     // Catch:{ all -> 0x006d }
            java.security.MessageDigest r1 = r8.f29533c     // Catch:{ all -> 0x006d }
            java.lang.String r3 = "UTF-8"
            java.nio.charset.Charset r3 = java.nio.charset.Charset.forName(r3)     // Catch:{ all -> 0x006d }
            byte[] r9 = r9.getBytes(r3)     // Catch:{ all -> 0x006d }
            r1.update(r9)     // Catch:{ all -> 0x006d }
            java.security.MessageDigest r9 = r8.f29533c     // Catch:{ all -> 0x006d }
            byte[] r9 = r9.digest()     // Catch:{ all -> 0x006d }
            int r1 = r9.length     // Catch:{ all -> 0x006d }
            int r3 = r8.f29534d     // Catch:{ all -> 0x006d }
            if (r1 <= r3) goto L_0x0034
            int r1 = r8.f29534d     // Catch:{ all -> 0x006d }
            goto L_0x0035
        L_0x0034:
            int r1 = r9.length     // Catch:{ all -> 0x006d }
        L_0x0035:
            byte[] r1 = new byte[r1]     // Catch:{ all -> 0x006d }
            int r3 = r1.length     // Catch:{ all -> 0x006d }
            java.lang.System.arraycopy(r9, r2, r1, r2, r3)     // Catch:{ all -> 0x006d }
            int r9 = r8.f29535e     // Catch:{ all -> 0x006d }
            r3 = 8
            int r9 = r9 % r3
            if (r9 <= 0) goto L_0x006b
            r4 = 0
        L_0x0045:
            int r9 = r1.length     // Catch:{ all -> 0x006d }
            if (r2 >= r9) goto L_0x0054
            if (r2 <= 0) goto L_0x004b
            long r4 = r4 << r3
        L_0x004b:
            byte r9 = r1[r2]     // Catch:{ all -> 0x006d }
            r9 = r9 & 255(0xff, float:3.57E-43)
            long r6 = (long) r9     // Catch:{ all -> 0x006d }
            long r4 = r4 + r6
            int r2 = r2 + 1
            goto L_0x0045
        L_0x0054:
            int r9 = r8.f29535e     // Catch:{ all -> 0x006d }
            int r9 = r9 % r3
            int r9 = 8 - r9
            long r4 = r4 >>> r9
            int r9 = r8.f29534d     // Catch:{ all -> 0x006d }
            int r9 = r9 + -1
        L_0x005e:
            if (r9 < 0) goto L_0x006b
            r6 = 255(0xff, double:1.26E-321)
            long r6 = r6 & r4
            int r2 = (int) r6     // Catch:{ all -> 0x006d }
            byte r2 = (byte) r2     // Catch:{ all -> 0x006d }
            r1[r9] = r2     // Catch:{ all -> 0x006d }
            long r4 = r4 >>> r3
            int r9 = r9 + -1
            goto L_0x005e
        L_0x006b:
            monitor-exit(r0)     // Catch:{ all -> 0x006d }
            return r1
        L_0x006d:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x006d }
            goto L_0x0071
        L_0x0070:
            throw r9
        L_0x0071:
            goto L_0x0070
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvj.mo32305a(java.lang.String):byte[]");
    }
}
