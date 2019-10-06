package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

public final class zzal {

    /* renamed from: a */
    private static final Comparator<byte[]> f24395a = new C8971La();

    /* renamed from: b */
    private final List<byte[]> f24396b = new ArrayList();

    /* renamed from: c */
    private final List<byte[]> f24397c = new ArrayList(64);

    /* renamed from: d */
    private int f24398d = 0;

    /* renamed from: e */
    private final int f24399e = Opcodes.ACC_SYNTHETIC;

    public zzal(int i) {
    }

    /* renamed from: a */
    public final synchronized byte[] mo29800a(int i) {
        for (int i2 = 0; i2 < this.f24397c.size(); i2++) {
            byte[] bArr = (byte[]) this.f24397c.get(i2);
            if (bArr.length >= i) {
                this.f24398d -= bArr.length;
                this.f24397c.remove(i2);
                this.f24396b.remove(bArr);
                return bArr;
            }
        }
        return new byte[i];
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002f, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void mo29799a(byte[] r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            if (r3 == 0) goto L_0x002e
            int r0 = r3.length     // Catch:{ all -> 0x002b }
            int r1 = r2.f24399e     // Catch:{ all -> 0x002b }
            if (r0 <= r1) goto L_0x0009
            goto L_0x002e
        L_0x0009:
            java.util.List<byte[]> r0 = r2.f24396b     // Catch:{ all -> 0x002b }
            r0.add(r3)     // Catch:{ all -> 0x002b }
            java.util.List<byte[]> r0 = r2.f24397c     // Catch:{ all -> 0x002b }
            java.util.Comparator<byte[]> r1 = f24395a     // Catch:{ all -> 0x002b }
            int r0 = java.util.Collections.binarySearch(r0, r3, r1)     // Catch:{ all -> 0x002b }
            if (r0 >= 0) goto L_0x001b
            int r0 = -r0
            int r0 = r0 + -1
        L_0x001b:
            java.util.List<byte[]> r1 = r2.f24397c     // Catch:{ all -> 0x002b }
            r1.add(r0, r3)     // Catch:{ all -> 0x002b }
            int r0 = r2.f24398d     // Catch:{ all -> 0x002b }
            int r3 = r3.length     // Catch:{ all -> 0x002b }
            int r0 = r0 + r3
            r2.f24398d = r0     // Catch:{ all -> 0x002b }
            r2.m25177a()     // Catch:{ all -> 0x002b }
            monitor-exit(r2)
            return
        L_0x002b:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        L_0x002e:
            monitor-exit(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzal.mo29799a(byte[]):void");
    }

    /* renamed from: a */
    private final synchronized void m25177a() {
        while (this.f24398d > this.f24399e) {
            byte[] bArr = (byte[]) this.f24396b.remove(0);
            this.f24397c.remove(bArr);
            this.f24398d -= bArr.length;
        }
    }
}
