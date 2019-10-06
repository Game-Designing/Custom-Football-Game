package com.mopub.volley.toolbox;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ByteArrayPool {

    /* renamed from: a */
    protected static final Comparator<byte[]> f36480a = new C11694a();

    /* renamed from: b */
    private final List<byte[]> f36481b = new ArrayList();

    /* renamed from: c */
    private final List<byte[]> f36482c = new ArrayList(64);

    /* renamed from: d */
    private int f36483d = 0;

    /* renamed from: e */
    private final int f36484e;

    public ByteArrayPool(int sizeLimit) {
        this.f36484e = sizeLimit;
    }

    public synchronized byte[] getBuf(int len) {
        for (int i = 0; i < this.f36482c.size(); i++) {
            byte[] buf = (byte[]) this.f36482c.get(i);
            if (buf.length >= len) {
                this.f36483d -= buf.length;
                this.f36482c.remove(i);
                this.f36481b.remove(buf);
                return buf;
            }
        }
        return new byte[len];
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void returnBuf(byte[] r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            if (r4 == 0) goto L_0x002e
            int r0 = r4.length     // Catch:{ all -> 0x002b }
            int r1 = r3.f36484e     // Catch:{ all -> 0x002b }
            if (r0 <= r1) goto L_0x0009
            goto L_0x002e
        L_0x0009:
            java.util.List<byte[]> r0 = r3.f36481b     // Catch:{ all -> 0x002b }
            r0.add(r4)     // Catch:{ all -> 0x002b }
            java.util.List<byte[]> r0 = r3.f36482c     // Catch:{ all -> 0x002b }
            java.util.Comparator<byte[]> r1 = f36480a     // Catch:{ all -> 0x002b }
            int r0 = java.util.Collections.binarySearch(r0, r4, r1)     // Catch:{ all -> 0x002b }
            if (r0 >= 0) goto L_0x001b
            int r1 = -r0
            int r0 = r1 + -1
        L_0x001b:
            java.util.List<byte[]> r1 = r3.f36482c     // Catch:{ all -> 0x002b }
            r1.add(r0, r4)     // Catch:{ all -> 0x002b }
            int r1 = r3.f36483d     // Catch:{ all -> 0x002b }
            int r2 = r4.length     // Catch:{ all -> 0x002b }
            int r1 = r1 + r2
            r3.f36483d = r1     // Catch:{ all -> 0x002b }
            r3.m38613a()     // Catch:{ all -> 0x002b }
            monitor-exit(r3)
            return
        L_0x002b:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        L_0x002e:
            monitor-exit(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mopub.volley.toolbox.ByteArrayPool.returnBuf(byte[]):void");
    }

    /* renamed from: a */
    private synchronized void m38613a() {
        while (this.f36483d > this.f36484e) {
            byte[] buf = (byte[]) this.f36481b.remove(0);
            this.f36482c.remove(buf);
            this.f36483d -= buf.length;
        }
    }
}
