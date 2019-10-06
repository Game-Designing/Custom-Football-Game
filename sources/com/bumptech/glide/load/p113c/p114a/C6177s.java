package com.bumptech.glide.load.p113c.p114a;

import com.bumptech.glide.load.engine.p120a.C6245b;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.load.c.a.s */
/* compiled from: RecyclableBufferedInputStream */
public class C6177s extends FilterInputStream {

    /* renamed from: a */
    private volatile byte[] f10900a;

    /* renamed from: b */
    private int f10901b;

    /* renamed from: c */
    private int f10902c;

    /* renamed from: d */
    private int f10903d;

    /* renamed from: e */
    private int f10904e;

    /* renamed from: f */
    private final C6245b f10905f;

    /* renamed from: com.bumptech.glide.load.c.a.s$a */
    /* compiled from: RecyclableBufferedInputStream */
    static class C6178a extends IOException {
        C6178a(String detailMessage) {
            super(detailMessage);
        }
    }

    public C6177s(InputStream in, C6245b byteArrayPool) {
        this(in, byteArrayPool, 65536);
    }

    C6177s(InputStream in, C6245b byteArrayPool, int bufferSize) {
        super(in);
        this.f10903d = -1;
        this.f10905f = byteArrayPool;
        this.f10900a = (byte[]) byteArrayPool.mo19127a(bufferSize, byte[].class);
    }

    public synchronized int available() throws IOException {
        InputStream localIn;
        localIn = this.in;
        if (this.f10900a == null || localIn == null) {
            m11712c();
            throw null;
        }
        return (this.f10901b - this.f10904e) + localIn.available();
    }

    /* renamed from: c */
    private static IOException m11712c() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    /* renamed from: a */
    public synchronized void mo19003a() {
        this.f10902c = this.f10900a.length;
    }

    /* renamed from: b */
    public synchronized void mo19005b() {
        if (this.f10900a != null) {
            this.f10905f.put(this.f10900a);
            this.f10900a = null;
        }
    }

    public void close() throws IOException {
        if (this.f10900a != null) {
            this.f10905f.put(this.f10900a);
            this.f10900a = null;
        }
        InputStream localIn = this.in;
        this.in = null;
        if (localIn != null) {
            localIn.close();
        }
    }

    /* renamed from: a */
    private int m11711a(InputStream localIn, byte[] localBuf) throws IOException {
        int i = this.f10903d;
        if (i != -1) {
            int i2 = this.f10904e - i;
            int i3 = this.f10902c;
            if (i2 < i3) {
                if (i == 0 && i3 > localBuf.length && this.f10901b == localBuf.length) {
                    int newLength = localBuf.length * 2;
                    if (newLength > i3) {
                        newLength = this.f10902c;
                    }
                    byte[] newbuf = (byte[]) this.f10905f.mo19127a(newLength, byte[].class);
                    System.arraycopy(localBuf, 0, newbuf, 0, localBuf.length);
                    byte[] oldbuf = localBuf;
                    this.f10900a = newbuf;
                    localBuf = newbuf;
                    this.f10905f.put(oldbuf);
                } else {
                    int i4 = this.f10903d;
                    if (i4 > 0) {
                        System.arraycopy(localBuf, i4, localBuf, 0, localBuf.length - i4);
                    }
                }
                this.f10904e -= this.f10903d;
                this.f10903d = 0;
                this.f10901b = 0;
                int i5 = this.f10904e;
                int bytesread = localIn.read(localBuf, i5, localBuf.length - i5);
                this.f10901b = bytesread <= 0 ? this.f10904e : this.f10904e + bytesread;
                return bytesread;
            }
        }
        int result = localIn.read(localBuf);
        if (result > 0) {
            this.f10903d = -1;
            this.f10904e = 0;
            this.f10901b = result;
        }
        return result;
    }

    public synchronized void mark(int readlimit) {
        this.f10902c = Math.max(this.f10902c, readlimit);
        this.f10903d = this.f10904e;
    }

    public boolean markSupported() {
        return true;
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:19:0x0027=Splitter:B:19:0x0027, B:11:0x0019=Splitter:B:11:0x0019, B:28:0x003c=Splitter:B:28:0x003c} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int read() throws java.io.IOException {
        /*
            r6 = this;
            monitor-enter(r6)
            byte[] r0 = r6.f10900a     // Catch:{ all -> 0x0040 }
            java.io.InputStream r1 = r6.in     // Catch:{ all -> 0x0040 }
            r2 = 0
            if (r0 == 0) goto L_0x003c
            if (r1 == 0) goto L_0x003c
            int r3 = r6.f10904e     // Catch:{ all -> 0x0040 }
            int r4 = r6.f10901b     // Catch:{ all -> 0x0040 }
            r5 = -1
            if (r3 < r4) goto L_0x0019
            int r3 = r6.m11711a(r1, r0)     // Catch:{ all -> 0x0040 }
            if (r3 != r5) goto L_0x0019
            monitor-exit(r6)
            return r5
        L_0x0019:
            byte[] r3 = r6.f10900a     // Catch:{ all -> 0x0040 }
            if (r0 == r3) goto L_0x0027
            byte[] r3 = r6.f10900a     // Catch:{ all -> 0x0040 }
            r0 = r3
            if (r0 == 0) goto L_0x0023
            goto L_0x0027
        L_0x0023:
            m11712c()     // Catch:{ all -> 0x0040 }
            throw r2
        L_0x0027:
            int r2 = r6.f10901b     // Catch:{ all -> 0x0040 }
            int r3 = r6.f10904e     // Catch:{ all -> 0x0040 }
            int r2 = r2 - r3
            if (r2 <= 0) goto L_0x003a
            int r2 = r6.f10904e     // Catch:{ all -> 0x0040 }
            int r3 = r2 + 1
            r6.f10904e = r3     // Catch:{ all -> 0x0040 }
            byte r2 = r0[r2]     // Catch:{ all -> 0x0040 }
            r2 = r2 & 255(0xff, float:3.57E-43)
            monitor-exit(r6)
            return r2
        L_0x003a:
            monitor-exit(r6)
            return r5
        L_0x003c:
            m11712c()     // Catch:{ all -> 0x0040 }
            throw r2
        L_0x0040:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.p113c.p114a.C6177s.read():int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003b, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0051, code lost:
        return r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x005e, code lost:
        return r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int read(byte[] r7, int r8, int r9) throws java.io.IOException {
        /*
            r6 = this;
            monitor-enter(r6)
            byte[] r0 = r6.f10900a     // Catch:{ all -> 0x009e }
            r1 = 0
            if (r0 == 0) goto L_0x009a
            if (r9 != 0) goto L_0x000b
            r1 = 0
            monitor-exit(r6)
            return r1
        L_0x000b:
            java.io.InputStream r2 = r6.in     // Catch:{ all -> 0x009e }
            if (r2 == 0) goto L_0x0096
            int r3 = r6.f10904e     // Catch:{ all -> 0x009e }
            int r4 = r6.f10901b     // Catch:{ all -> 0x009e }
            if (r3 >= r4) goto L_0x003c
            int r3 = r6.f10901b     // Catch:{ all -> 0x009e }
            int r4 = r6.f10904e     // Catch:{ all -> 0x009e }
            int r3 = r3 - r4
            if (r3 < r9) goto L_0x001e
            r3 = r9
            goto L_0x0023
        L_0x001e:
            int r3 = r6.f10901b     // Catch:{ all -> 0x009e }
            int r4 = r6.f10904e     // Catch:{ all -> 0x009e }
            int r3 = r3 - r4
        L_0x0023:
            int r4 = r6.f10904e     // Catch:{ all -> 0x009e }
            java.lang.System.arraycopy(r0, r4, r7, r8, r3)     // Catch:{ all -> 0x009e }
            int r4 = r6.f10904e     // Catch:{ all -> 0x009e }
            int r4 = r4 + r3
            r6.f10904e = r4     // Catch:{ all -> 0x009e }
            if (r3 == r9) goto L_0x003a
            int r4 = r2.available()     // Catch:{ all -> 0x009e }
            if (r4 != 0) goto L_0x0036
            goto L_0x003a
        L_0x0036:
            int r8 = r8 + r3
            int r3 = r9 - r3
            goto L_0x003d
        L_0x003a:
            monitor-exit(r6)
            return r3
        L_0x003c:
            r3 = r9
        L_0x003d:
            int r4 = r6.f10903d     // Catch:{ all -> 0x009e }
            r5 = -1
            if (r4 != r5) goto L_0x0052
            int r4 = r0.length     // Catch:{ all -> 0x009e }
            if (r3 < r4) goto L_0x0052
            int r4 = r2.read(r7, r8, r3)     // Catch:{ all -> 0x009e }
            if (r4 != r5) goto L_0x0085
            if (r3 != r9) goto L_0x004e
            goto L_0x0050
        L_0x004e:
            int r5 = r9 - r3
        L_0x0050:
            monitor-exit(r6)
            return r5
        L_0x0052:
            int r4 = r6.m11711a(r2, r0)     // Catch:{ all -> 0x009e }
            if (r4 != r5) goto L_0x005f
            if (r3 != r9) goto L_0x005b
            goto L_0x005d
        L_0x005b:
            int r5 = r9 - r3
        L_0x005d:
            monitor-exit(r6)
            return r5
        L_0x005f:
            byte[] r4 = r6.f10900a     // Catch:{ all -> 0x009e }
            if (r0 == r4) goto L_0x006d
            byte[] r4 = r6.f10900a     // Catch:{ all -> 0x009e }
            r0 = r4
            if (r0 == 0) goto L_0x0069
            goto L_0x006d
        L_0x0069:
            m11712c()     // Catch:{ all -> 0x009e }
            throw r1
        L_0x006d:
            int r4 = r6.f10901b     // Catch:{ all -> 0x009e }
            int r5 = r6.f10904e     // Catch:{ all -> 0x009e }
            int r4 = r4 - r5
            if (r4 < r3) goto L_0x0076
            r4 = r3
            goto L_0x007b
        L_0x0076:
            int r4 = r6.f10901b     // Catch:{ all -> 0x009e }
            int r5 = r6.f10904e     // Catch:{ all -> 0x009e }
            int r4 = r4 - r5
        L_0x007b:
            int r5 = r6.f10904e     // Catch:{ all -> 0x009e }
            java.lang.System.arraycopy(r0, r5, r7, r8, r4)     // Catch:{ all -> 0x009e }
            int r5 = r6.f10904e     // Catch:{ all -> 0x009e }
            int r5 = r5 + r4
            r6.f10904e = r5     // Catch:{ all -> 0x009e }
        L_0x0085:
            int r3 = r3 - r4
            if (r3 != 0) goto L_0x008a
            monitor-exit(r6)
            return r9
        L_0x008a:
            int r5 = r2.available()     // Catch:{ all -> 0x009e }
            if (r5 != 0) goto L_0x0094
            int r1 = r9 - r3
            monitor-exit(r6)
            return r1
        L_0x0094:
            int r8 = r8 + r4
            goto L_0x003d
        L_0x0096:
            m11712c()     // Catch:{ all -> 0x009e }
            throw r1
        L_0x009a:
            m11712c()     // Catch:{ all -> 0x009e }
            throw r1
        L_0x009e:
            r7 = move-exception
            monitor-exit(r6)
            goto L_0x00a2
        L_0x00a1:
            throw r7
        L_0x00a2:
            goto L_0x00a1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.p113c.p114a.C6177s.read(byte[], int, int):int");
    }

    public synchronized void reset() throws IOException {
        if (this.f10900a == null) {
            throw new IOException("Stream is closed");
        } else if (-1 != this.f10903d) {
            this.f10904e = this.f10903d;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Mark has been invalidated, pos: ");
            sb.append(this.f10904e);
            sb.append(" markLimit: ");
            sb.append(this.f10902c);
            throw new C6178a(sb.toString());
        }
    }

    public synchronized long skip(long byteCount) throws IOException {
        if (byteCount < 1) {
            return 0;
        }
        byte[] localBuf = this.f10900a;
        if (localBuf != null) {
            InputStream localIn = this.in;
            if (localIn == null) {
                m11712c();
                throw null;
            } else if (((long) (this.f10901b - this.f10904e)) >= byteCount) {
                this.f10904e = (int) (((long) this.f10904e) + byteCount);
                return byteCount;
            } else {
                long read = ((long) this.f10901b) - ((long) this.f10904e);
                this.f10904e = this.f10901b;
                if (this.f10903d == -1 || byteCount > ((long) this.f10902c)) {
                    return localIn.skip(byteCount - read) + read;
                } else if (m11711a(localIn, localBuf) == -1) {
                    return read;
                } else {
                    if (((long) (this.f10901b - this.f10904e)) >= byteCount - read) {
                        this.f10904e = (int) ((((long) this.f10904e) + byteCount) - read);
                        return byteCount;
                    }
                    long read2 = (((long) this.f10901b) + read) - ((long) this.f10904e);
                    this.f10904e = this.f10901b;
                    return read2;
                }
            }
        } else {
            m11712c();
            throw null;
        }
    }
}
