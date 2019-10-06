package p362h;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.data.ExecutionDataWriter;

/* renamed from: h.g */
/* compiled from: Buffer */
public final class C14191g implements C14194i, C14193h, Cloneable, ByteChannel {

    /* renamed from: a */
    private static final byte[] f43071a = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    /* renamed from: b */
    C14209x f43072b;

    /* renamed from: c */
    long f43073c;

    /* renamed from: h.g$a */
    /* compiled from: Buffer */
    public static final class C14192a implements Closeable {

        /* renamed from: a */
        public C14191g f43074a;

        /* renamed from: b */
        public boolean f43075b;

        /* renamed from: c */
        private C14209x f43076c;

        /* renamed from: d */
        public long f43077d = -1;

        /* renamed from: e */
        public byte[] f43078e;

        /* renamed from: f */
        public int f43079f = -1;

        /* renamed from: g */
        public int f43080g = -1;

        /* renamed from: a */
        public int mo44267a() {
            long j = this.f43077d;
            if (j == this.f43074a.f43073c) {
                throw new IllegalStateException();
            } else if (j == -1) {
                return mo44269h(0);
            } else {
                return mo44269h(j + ((long) (this.f43080g - this.f43079f)));
            }
        }

        /* renamed from: h */
        public int mo44269h(long offset) {
            long nextOffset;
            C14209x next;
            long j = offset;
            if (j >= -1) {
                C14191g gVar = this.f43074a;
                long j2 = gVar.f43073c;
                if (j <= j2) {
                    if (j == -1 || j == j2) {
                        this.f43076c = null;
                        this.f43077d = j;
                        this.f43078e = null;
                        this.f43079f = -1;
                        this.f43080g = -1;
                        return -1;
                    }
                    long min = 0;
                    long max = gVar.f43073c;
                    C14209x head = gVar.f43072b;
                    C14209x tail = gVar.f43072b;
                    C14209x xVar = this.f43076c;
                    if (xVar != null) {
                        long segmentOffset = this.f43077d - ((long) (this.f43079f - xVar.f43110b));
                        if (segmentOffset > j) {
                            max = segmentOffset;
                            tail = this.f43076c;
                        } else {
                            min = segmentOffset;
                            head = this.f43076c;
                        }
                    }
                    if (max - j > j - min) {
                        next = head;
                        nextOffset = min;
                        while (true) {
                            int i = next.f43111c;
                            int i2 = next.f43110b;
                            if (j < ((long) (i - i2)) + nextOffset) {
                                break;
                            }
                            nextOffset += (long) (i - i2);
                            next = next.f43114f;
                        }
                    } else {
                        C14209x next2 = tail;
                        long nextOffset2 = max;
                        while (nextOffset > j) {
                            next2 = next.f43115g;
                            nextOffset2 = nextOffset - ((long) (next2.f43111c - next2.f43110b));
                        }
                    }
                    if (this.f43075b && next.f43112d) {
                        C14209x unsharedNext = next.mo44318d();
                        C14191g gVar2 = this.f43074a;
                        if (gVar2.f43072b == next) {
                            gVar2.f43072b = unsharedNext;
                        }
                        next = next.mo44313a(unsharedNext);
                        next.f43115g.mo44316b();
                    }
                    this.f43076c = next;
                    this.f43077d = j;
                    this.f43078e = next.f43109a;
                    this.f43079f = next.f43110b + ((int) (j - nextOffset));
                    this.f43080g = next.f43111c;
                    return this.f43080g - this.f43079f;
                }
            }
            throw new ArrayIndexOutOfBoundsException(String.format("offset=%s > size=%s", new Object[]{Long.valueOf(offset), Long.valueOf(this.f43074a.f43073c)}));
        }

        public void close() {
            if (this.f43074a != null) {
                this.f43074a = null;
                this.f43076c = null;
                this.f43077d = -1;
                this.f43078e = null;
                this.f43079f = -1;
                this.f43080g = -1;
                return;
            }
            throw new IllegalStateException("not attached to a buffer");
        }
    }

    public long size() {
        return this.f43073c;
    }

    /* renamed from: k */
    public C14191g mo44238k() {
        return this;
    }

    /* renamed from: c */
    public OutputStream mo44222c() {
        return new C14189e(this);
    }

    /* renamed from: m */
    public C14191g mo44240m() {
        return this;
    }

    /* renamed from: l */
    public C14193h mo44239l() {
        return this;
    }

    /* renamed from: q */
    public boolean mo44244q() {
        return this.f43073c == 0;
    }

    /* renamed from: e */
    public void mo44227e(long byteCount) throws EOFException {
        if (this.f43073c < byteCount) {
            throw new EOFException();
        }
    }

    public boolean request(long byteCount) {
        return this.f43073c >= byteCount;
    }

    /* renamed from: u */
    public InputStream mo44258u() {
        return new C14190f(this);
    }

    /* renamed from: a */
    public C14191g mo44206a(C14191g out, long offset, long byteCount) {
        if (out != null) {
            C14183E.m45554a(this.f43073c, offset, byteCount);
            if (byteCount == 0) {
                return this;
            }
            out.f43073c += byteCount;
            C14209x s = this.f43072b;
            while (true) {
                int i = s.f43111c;
                int i2 = s.f43110b;
                if (offset < ((long) (i - i2))) {
                    break;
                }
                offset -= (long) (i - i2);
                s = s.f43114f;
            }
            while (byteCount > 0) {
                C14209x copy = s.mo44317c();
                copy.f43110b = (int) (((long) copy.f43110b) + offset);
                copy.f43111c = Math.min(copy.f43110b + ((int) byteCount), copy.f43111c);
                C14209x xVar = out.f43072b;
                if (xVar == null) {
                    copy.f43115g = copy;
                    copy.f43114f = copy;
                    out.f43072b = copy;
                } else {
                    xVar.f43115g.mo44313a(copy);
                }
                byteCount -= (long) (copy.f43111c - copy.f43110b);
                offset = 0;
                s = s.f43114f;
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    /* renamed from: b */
    public long mo44218b() {
        long result = this.f43073c;
        if (result == 0) {
            return 0;
        }
        C14209x tail = this.f43072b.f43115g;
        int i = tail.f43111c;
        if (i < 8192 && tail.f43113e) {
            result -= (long) (i - tail.f43110b);
        }
        return result;
    }

    public byte readByte() {
        long j = this.f43073c;
        if (j != 0) {
            C14209x segment = this.f43072b;
            int pos = segment.f43110b;
            int limit = segment.f43111c;
            int pos2 = pos + 1;
            byte pos3 = segment.f43109a[pos];
            this.f43073c = j - 1;
            if (pos2 == limit) {
                this.f43072b = segment.mo44316b();
                C14210y.m45725a(segment);
            } else {
                segment.f43110b = pos2;
            }
            return pos3;
        }
        throw new IllegalStateException("size == 0");
    }

    /* renamed from: g */
    public byte mo44231g(long pos) {
        C14183E.m45554a(this.f43073c, pos, 1);
        long j = this.f43073c;
        if (j - pos > pos) {
            C14209x s = this.f43072b;
            while (true) {
                int i = s.f43111c;
                int i2 = s.f43110b;
                int segmentByteCount = i - i2;
                if (pos < ((long) segmentByteCount)) {
                    return s.f43109a[i2 + ((int) pos)];
                }
                pos -= (long) segmentByteCount;
                s = s.f43114f;
            }
        } else {
            long pos2 = pos - j;
            C14209x s2 = this.f43072b.f43115g;
            while (true) {
                int i3 = s2.f43111c;
                int i4 = s2.f43110b;
                pos2 += (long) (i3 - i4);
                if (pos2 >= 0) {
                    return s2.f43109a[i4 + ((int) pos2)];
                }
                s2 = s2.f43115g;
            }
        }
    }

    public short readShort() {
        long j = this.f43073c;
        if (j >= 2) {
            C14209x segment = this.f43072b;
            int pos = segment.f43110b;
            int limit = segment.f43111c;
            if (limit - pos < 2) {
                return (short) (((readByte() & 255) << 8) | (readByte() & 255));
            }
            byte[] data = segment.f43109a;
            int pos2 = pos + 1;
            int pos3 = pos2 + 1;
            int s = ((data[pos] & 255) << 8) | (data[pos2] & 255);
            this.f43073c = j - 2;
            if (pos3 == limit) {
                this.f43072b = segment.mo44316b();
                C14210y.m45725a(segment);
            } else {
                segment.f43110b = pos3;
            }
            return (short) s;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("size < 2: ");
        sb.append(this.f43073c);
        throw new IllegalStateException(sb.toString());
    }

    public int readInt() {
        long j = this.f43073c;
        if (j >= 4) {
            C14209x segment = this.f43072b;
            int pos = segment.f43110b;
            int limit = segment.f43111c;
            if (limit - pos < 4) {
                return ((readByte() & 255) << 24) | ((readByte() & 255) << ExecutionDataWriter.BLOCK_SESSIONINFO) | ((readByte() & 255) << 8) | (readByte() & 255);
            }
            byte[] data = segment.f43109a;
            int pos2 = pos + 1;
            int pos3 = pos2 + 1;
            int i = ((data[pos] & 255) << 24) | ((data[pos2] & 255) << ExecutionDataWriter.BLOCK_SESSIONINFO);
            int pos4 = pos3 + 1;
            int i2 = i | ((data[pos3] & 255) << 8);
            int pos5 = pos4 + 1;
            int i3 = i2 | (data[pos4] & 255);
            this.f43073c = j - 4;
            if (pos5 == limit) {
                this.f43072b = segment.mo44316b();
                C14210y.m45725a(segment);
            } else {
                segment.f43110b = pos5;
            }
            return i3;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("size < 4: ");
        sb.append(this.f43073c);
        throw new IllegalStateException(sb.toString());
    }

    public long readLong() {
        long j = this.f43073c;
        if (j >= 8) {
            C14209x segment = this.f43072b;
            int pos = segment.f43110b;
            int limit = segment.f43111c;
            if (limit - pos < 8) {
                return ((((long) readInt()) & 4294967295L) << 32) | (4294967295L & ((long) readInt()));
            }
            byte[] data = segment.f43109a;
            int pos2 = pos + 1;
            long j2 = (((long) data[pos]) & 255) << 56;
            int pos3 = pos2 + 1;
            int pos4 = pos3 + 1;
            int pos5 = pos4 + 1;
            int pos6 = pos5 + 1;
            int pos7 = pos6 + 1;
            int pos8 = pos7 + 1;
            int pos9 = pos8 + 1;
            long v = ((((long) data[pos2]) & 255) << 48) | j2 | ((((long) data[pos3]) & 255) << 40) | ((((long) data[pos4]) & 255) << 32) | ((((long) data[pos5]) & 255) << 24) | ((((long) data[pos6]) & 255) << 16) | ((((long) data[pos7]) & 255) << 8) | (((long) data[pos8]) & 255);
            this.f43073c = j - 8;
            if (pos9 == limit) {
                this.f43072b = segment.mo44316b();
                C14210y.m45725a(segment);
            } else {
                segment.f43110b = pos9;
            }
            return v;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("size < 8: ");
        sb.append(this.f43073c);
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: o */
    public short mo44242o() {
        return C14183E.m45553a(readShort());
    }

    /* renamed from: s */
    public int mo44253s() {
        return C14183E.m45552a(readInt());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00de, code lost:
        if (r4 == false) goto L_0x00e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
        return -r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
        return r1;
     */
    /* renamed from: r */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long mo44245r() {
        /*
            r20 = this;
            r0 = r20
            long r1 = r0.f43073c
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x00e4
            r1 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            r8 = -7
        L_0x0016:
            h.x r10 = r0.f43072b
            byte[] r11 = r10.f43109a
            int r12 = r10.f43110b
            int r13 = r10.f43111c
        L_0x001e:
            if (r12 >= r13) goto L_0x00b9
            byte r14 = r11[r12]
            r15 = 48
            if (r14 < r15) goto L_0x007f
            r15 = 57
            if (r14 > r15) goto L_0x007f
            r15 = 48
            int r15 = r15 - r14
            int r16 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r16 < 0) goto L_0x004c
            int r16 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r16 != 0) goto L_0x003e
            r16 = r6
            r7 = r5
            long r5 = (long) r15
            int r18 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r18 >= 0) goto L_0x0041
            goto L_0x004f
        L_0x003e:
            r16 = r6
            r7 = r5
        L_0x0041:
            r5 = 10
            long r1 = r1 * r5
            long r5 = (long) r15
            long r1 = r1 + r5
            r18 = r7
            r19 = r11
            goto L_0x008f
        L_0x004c:
            r16 = r6
            r7 = r5
        L_0x004f:
            h.g r5 = new h.g
            r5.<init>()
            r5.mo44205a(r1)
            h.g r5 = r5.writeByte(r14)
            if (r4 != 0) goto L_0x0060
            r5.readByte()
        L_0x0060:
            java.lang.NumberFormatException r6 = new java.lang.NumberFormatException
            r18 = r7
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r19 = r11
            java.lang.String r11 = "Number too large: "
            r7.append(r11)
            java.lang.String r11 = r5.mo44232h()
            r7.append(r11)
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            throw r6
        L_0x007f:
            r18 = r5
            r16 = r6
            r19 = r11
            r5 = 45
            if (r14 != r5) goto L_0x009a
            if (r3 != 0) goto L_0x009a
            r4 = 1
            r5 = 1
            long r8 = r8 - r5
        L_0x008f:
            int r12 = r12 + 1
            int r3 = r3 + 1
            r6 = r16
            r5 = r18
            r11 = r19
            goto L_0x001e
        L_0x009a:
            if (r3 == 0) goto L_0x009e
            r5 = 1
            goto L_0x00bf
        L_0x009e:
            java.lang.NumberFormatException r5 = new java.lang.NumberFormatException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Expected leading [0-9] or '-' character but was 0x"
            r6.append(r7)
            java.lang.String r7 = java.lang.Integer.toHexString(r14)
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        L_0x00b9:
            r18 = r5
            r16 = r6
            r19 = r11
        L_0x00bf:
            if (r12 != r13) goto L_0x00cb
            h.x r6 = r10.mo44316b()
            r0.f43072b = r6
            p362h.C14210y.m45725a(r10)
            goto L_0x00cd
        L_0x00cb:
            r10.f43110b = r12
        L_0x00cd:
            if (r5 != 0) goto L_0x00d8
            h.x r6 = r0.f43072b
            if (r6 != 0) goto L_0x00d4
            goto L_0x00d8
        L_0x00d4:
            r6 = r16
            goto L_0x0016
        L_0x00d8:
            long r6 = r0.f43073c
            long r10 = (long) r3
            long r6 = r6 - r10
            r0.f43073c = r6
            if (r4 == 0) goto L_0x00e2
            r6 = r1
            goto L_0x00e3
        L_0x00e2:
            long r6 = -r1
        L_0x00e3:
            return r6
        L_0x00e4:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "size == 0"
            r1.<init>(r2)
            goto L_0x00ed
        L_0x00ec:
            throw r1
        L_0x00ed:
            goto L_0x00ec
        */
        throw new UnsupportedOperationException("Method not decompiled: p362h.C14191g.mo44245r():long");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0092, code lost:
        if (r8 != r9) goto L_0x009e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0094, code lost:
        r15.f43072b = r6.mo44316b();
        p362h.C14210y.m45725a(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x009e, code lost:
        r6.f43110b = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a0, code lost:
        if (r5 != false) goto L_0x00a6;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0077 A[SYNTHETIC] */
    /* renamed from: t */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long mo44256t() {
        /*
            r15 = this;
            long r0 = r15.f43073c
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x00ad
            r0 = 0
            r4 = 0
            r5 = 0
        L_0x000c:
            h.x r6 = r15.f43072b
            byte[] r7 = r6.f43109a
            int r8 = r6.f43110b
            int r9 = r6.f43111c
        L_0x0014:
            if (r8 >= r9) goto L_0x0092
            byte r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L_0x0023
            r11 = 57
            if (r10 > r11) goto L_0x0023
            int r11 = r10 + -48
            goto L_0x003c
        L_0x0023:
            r11 = 97
            if (r10 < r11) goto L_0x0030
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L_0x0030
            int r11 = r10 + -97
            int r11 = r11 + 10
            goto L_0x003c
        L_0x0030:
            r11 = 65
            if (r10 < r11) goto L_0x0073
            r11 = 70
            if (r10 > r11) goto L_0x0073
            int r11 = r10 + -65
            int r11 = r11 + 10
        L_0x003c:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r0
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L_0x004c
            r12 = 4
            long r0 = r0 << r12
            long r12 = (long) r11
            long r0 = r0 | r12
            int r8 = r8 + 1
            int r4 = r4 + 1
            goto L_0x0014
        L_0x004c:
            h.g r2 = new h.g
            r2.<init>()
            r2.mo44219b(r0)
            h.g r2 = r2.writeByte(r10)
            java.lang.NumberFormatException r3 = new java.lang.NumberFormatException
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "Number too large: "
            r12.append(r13)
            java.lang.String r13 = r2.mo44232h()
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            r3.<init>(r12)
            throw r3
        L_0x0073:
            if (r4 == 0) goto L_0x0077
            r5 = 1
            goto L_0x0092
        L_0x0077:
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r11 = "Expected leading [0-9a-fA-F] character but was 0x"
            r3.append(r11)
            java.lang.String r11 = java.lang.Integer.toHexString(r10)
            r3.append(r11)
            java.lang.String r3 = r3.toString()
            r2.<init>(r3)
            throw r2
        L_0x0092:
            if (r8 != r9) goto L_0x009e
            h.x r10 = r6.mo44316b()
            r15.f43072b = r10
            p362h.C14210y.m45725a(r6)
            goto L_0x00a0
        L_0x009e:
            r6.f43110b = r8
        L_0x00a0:
            if (r5 != 0) goto L_0x00a6
            h.x r6 = r15.f43072b
            if (r6 != 0) goto L_0x000c
        L_0x00a6:
            long r2 = r15.f43073c
            long r6 = (long) r4
            long r2 = r2 - r6
            r15.f43073c = r2
            return r0
        L_0x00ad:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "size == 0"
            r0.<init>(r1)
            goto L_0x00b6
        L_0x00b5:
            throw r0
        L_0x00b6:
            goto L_0x00b5
        */
        throw new UnsupportedOperationException("Method not decompiled: p362h.C14191g.mo44256t():long");
    }

    /* renamed from: d */
    public C14195j mo44225d() {
        return new C14195j(mo44243p());
    }

    /* renamed from: f */
    public C14195j mo44230f(long byteCount) throws EOFException {
        return new C14195j(mo44226d(byteCount));
    }

    /* renamed from: a */
    public void mo44215a(C14191g sink, long byteCount) throws EOFException {
        long j = this.f43073c;
        if (j >= byteCount) {
            sink.write(this, byteCount);
        } else {
            sink.write(this, j);
            throw new EOFException();
        }
    }

    /* renamed from: a */
    public long mo44202a(C14179A sink) throws IOException {
        long byteCount = this.f43073c;
        if (byteCount > 0) {
            sink.write(this, byteCount);
        }
        return byteCount;
    }

    /* renamed from: h */
    public String mo44232h() {
        try {
            return mo44212a(this.f43073c, C14183E.f43062a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: h */
    public String mo44233h(long byteCount) throws EOFException {
        return mo44212a(byteCount, C14183E.f43062a);
    }

    /* renamed from: a */
    public String mo44213a(Charset charset) {
        try {
            return mo44212a(this.f43073c, charset);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: a */
    public String mo44212a(long byteCount, Charset charset) throws EOFException {
        C14183E.m45554a(this.f43073c, 0, byteCount);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (byteCount > 2147483647L) {
            StringBuilder sb = new StringBuilder();
            sb.append("byteCount > Integer.MAX_VALUE: ");
            sb.append(byteCount);
            throw new IllegalArgumentException(sb.toString());
        } else if (byteCount == 0) {
            return "";
        } else {
            C14209x s = this.f43072b;
            int i = s.f43110b;
            if (((long) i) + byteCount > ((long) s.f43111c)) {
                return new String(mo44226d(byteCount), charset);
            }
            String result = new String(s.f43109a, i, (int) byteCount, charset);
            s.f43110b = (int) (((long) s.f43110b) + byteCount);
            this.f43073c -= byteCount;
            if (s.f43110b == s.f43111c) {
                this.f43072b = s.mo44316b();
                C14210y.m45725a(s);
            }
            return result;
        }
    }

    /* renamed from: n */
    public String mo44241n() throws EOFException {
        return mo44223c(Long.MAX_VALUE);
    }

    /* renamed from: c */
    public String mo44223c(long limit) throws EOFException {
        if (limit >= 0) {
            long scanLength = Long.MAX_VALUE;
            if (limit != Long.MAX_VALUE) {
                scanLength = limit + 1;
            }
            long newline = mo44201a(10, 0, scanLength);
            if (newline != -1) {
                return mo44235i(newline);
            }
            if (scanLength < size() && mo44231g(scanLength - 1) == 13 && mo44231g(scanLength) == 10) {
                return mo44235i(scanLength);
            }
            C14191g data = new C14191g();
            mo44206a(data, 0, Math.min(32, size()));
            StringBuilder sb = new StringBuilder();
            sb.append("\\n not found: limit=");
            sb.append(Math.min(size(), limit));
            sb.append(" content=");
            sb.append(data.mo44225d().mo44280f());
            sb.append(8230);
            throw new EOFException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("limit < 0: ");
        sb2.append(limit);
        throw new IllegalArgumentException(sb2.toString());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public String mo44235i(long newline) throws EOFException {
        if (newline <= 0 || mo44231g(newline - 1) != 13) {
            String result = mo44233h(newline);
            skip(1);
            return result;
        }
        String result2 = mo44233h(newline - 1);
        skip(2);
        return result2;
    }

    /* renamed from: w */
    public int mo44259w() throws EOFException {
        int min;
        int byteCount;
        int codePoint;
        if (this.f43073c != 0) {
            int b0 = mo44231g(0);
            if ((b0 & 128) == 0) {
                codePoint = b0 & Opcodes.LAND;
                byteCount = 1;
                min = 0;
            } else if ((b0 & 224) == 192) {
                codePoint = b0 & 31;
                byteCount = 2;
                min = 128;
            } else if ((b0 & 240) == 224) {
                codePoint = b0 & 15;
                byteCount = 3;
                min = Opcodes.ACC_STRICT;
            } else if ((b0 & 248) == 240) {
                codePoint = b0 & 7;
                byteCount = 4;
                min = 65536;
            } else {
                skip(1);
                return 65533;
            }
            if (this.f43073c >= ((long) byteCount)) {
                int i = 1;
                while (i < byteCount) {
                    int b = mo44231g((long) i);
                    if ((b & Opcodes.CHECKCAST) == 128) {
                        codePoint = (codePoint << 6) | (b & 63);
                        i++;
                    } else {
                        skip((long) i);
                        return 65533;
                    }
                }
                skip((long) byteCount);
                if (codePoint > 1114111) {
                    return 65533;
                }
                if ((codePoint < 55296 || codePoint > 57343) && codePoint >= min) {
                    return codePoint;
                }
                return 65533;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("size < ");
            sb.append(byteCount);
            sb.append(": ");
            sb.append(this.f43073c);
            sb.append(" (to read code point prefixed 0x");
            sb.append(Integer.toHexString(b0));
            sb.append(")");
            throw new EOFException(sb.toString());
        }
        throw new EOFException();
    }

    /* renamed from: p */
    public byte[] mo44243p() {
        try {
            return mo44226d(this.f43073c);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: d */
    public byte[] mo44226d(long byteCount) throws EOFException {
        C14183E.m45554a(this.f43073c, 0, byteCount);
        if (byteCount <= 2147483647L) {
            byte[] result = new byte[((int) byteCount)];
            readFully(result);
            return result;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("byteCount > Integer.MAX_VALUE: ");
        sb.append(byteCount);
        throw new IllegalArgumentException(sb.toString());
    }

    public void readFully(byte[] sink) throws EOFException {
        int offset = 0;
        while (offset < sink.length) {
            int read = mo44199a(sink, offset, sink.length - offset);
            if (read != -1) {
                offset += read;
            } else {
                throw new EOFException();
            }
        }
    }

    /* renamed from: a */
    public int mo44199a(byte[] sink, int offset, int byteCount) {
        C14183E.m45554a((long) sink.length, (long) offset, (long) byteCount);
        C14209x s = this.f43072b;
        if (s == null) {
            return -1;
        }
        int toCopy = Math.min(byteCount, s.f43111c - s.f43110b);
        System.arraycopy(s.f43109a, s.f43110b, sink, offset, toCopy);
        s.f43110b += toCopy;
        this.f43073c -= (long) toCopy;
        if (s.f43110b == s.f43111c) {
            this.f43072b = s.mo44316b();
            C14210y.m45725a(s);
        }
        return toCopy;
    }

    public int read(ByteBuffer sink) throws IOException {
        C14209x s = this.f43072b;
        if (s == null) {
            return -1;
        }
        int toCopy = Math.min(sink.remaining(), s.f43111c - s.f43110b);
        sink.put(s.f43109a, s.f43110b, toCopy);
        s.f43110b += toCopy;
        this.f43073c -= (long) toCopy;
        if (s.f43110b == s.f43111c) {
            this.f43072b = s.mo44316b();
            C14210y.m45725a(s);
        }
        return toCopy;
    }

    /* renamed from: a */
    public void mo44214a() {
        try {
            skip(this.f43073c);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public void skip(long byteCount) throws EOFException {
        while (byteCount > 0) {
            C14209x xVar = this.f43072b;
            if (xVar != null) {
                int toSkip = (int) Math.min(byteCount, (long) (xVar.f43111c - xVar.f43110b));
                this.f43073c -= (long) toSkip;
                byteCount -= (long) toSkip;
                C14209x xVar2 = this.f43072b;
                xVar2.f43110b += toSkip;
                if (xVar2.f43110b == xVar2.f43111c) {
                    C14209x toRecycle = this.f43072b;
                    this.f43072b = toRecycle.mo44316b();
                    C14210y.m45725a(toRecycle);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    /* renamed from: a */
    public C14191g mo44207a(C14195j byteString) {
        if (byteString != null) {
            byteString.mo44273a(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    /* renamed from: f */
    public C14191g mo44229f(String string) {
        mo44208a(string, 0, string.length());
        return this;
    }

    /* renamed from: a */
    public C14191g mo44208a(String string, int beginIndex, int endIndex) {
        if (string == null) {
            throw new IllegalArgumentException("string == null");
        } else if (beginIndex < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("beginIndex < 0: ");
            sb.append(beginIndex);
            throw new IllegalArgumentException(sb.toString());
        } else if (endIndex < beginIndex) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("endIndex < beginIndex: ");
            sb2.append(endIndex);
            sb2.append(" < ");
            sb2.append(beginIndex);
            throw new IllegalArgumentException(sb2.toString());
        } else if (endIndex <= string.length()) {
            int runSize = beginIndex;
            while (runSize < endIndex) {
                int c = string.charAt(runSize);
                if (c < 128) {
                    C14209x tail = mo44220b(1);
                    byte[] data = tail.f43109a;
                    int segmentOffset = tail.f43111c - runSize;
                    int runLimit = Math.min(endIndex, 8192 - segmentOffset);
                    int i = runSize + 1;
                    data[runSize + segmentOffset] = (byte) c;
                    while (i < runLimit) {
                        int c2 = string.charAt(i);
                        if (c2 >= 128) {
                            break;
                        }
                        int i2 = i + 1;
                        data[i + segmentOffset] = (byte) c2;
                        i = i2;
                    }
                    int i3 = i + segmentOffset;
                    int i4 = tail.f43111c;
                    int runSize2 = i3 - i4;
                    tail.f43111c = i4 + runSize2;
                    this.f43073c += (long) runSize2;
                    runSize = i;
                } else if (c < 2048) {
                    writeByte((c >> 6) | Opcodes.CHECKCAST);
                    writeByte(128 | (c & 63));
                    runSize++;
                } else if (c < 55296 || c > 57343) {
                    writeByte((c >> 12) | 224);
                    writeByte(((c >> 6) & 63) | 128);
                    writeByte(128 | (c & 63));
                    runSize++;
                } else {
                    int low = runSize + 1 < endIndex ? string.charAt(runSize + 1) : 0;
                    if (c > 56319 || low < 56320 || low > 57343) {
                        writeByte(63);
                        runSize++;
                    } else {
                        int codePoint = (((-55297 & c) << 10) | (-56321 & low)) + 65536;
                        writeByte((codePoint >> 18) | 240);
                        writeByte(((codePoint >> 12) & 63) | 128);
                        writeByte(((codePoint >> 6) & 63) | 128);
                        writeByte(128 | (codePoint & 63));
                        runSize += 2;
                    }
                }
            }
            return this;
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("endIndex > string.length: ");
            sb3.append(endIndex);
            sb3.append(" > ");
            sb3.append(string.length());
            throw new IllegalArgumentException(sb3.toString());
        }
    }

    /* renamed from: c */
    public C14191g mo44221c(int codePoint) {
        if (codePoint < 128) {
            writeByte(codePoint);
        } else if (codePoint < 2048) {
            writeByte((codePoint >> 6) | Opcodes.CHECKCAST);
            writeByte(128 | (codePoint & 63));
        } else if (codePoint < 65536) {
            if (codePoint < 55296 || codePoint > 57343) {
                writeByte((codePoint >> 12) | 224);
                writeByte(((codePoint >> 6) & 63) | 128);
                writeByte(128 | (codePoint & 63));
            } else {
                writeByte(63);
            }
        } else if (codePoint <= 1114111) {
            writeByte((codePoint >> 18) | 240);
            writeByte(((codePoint >> 12) & 63) | 128);
            writeByte(((codePoint >> 6) & 63) | 128);
            writeByte(128 | (codePoint & 63));
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Unexpected code point: ");
            sb.append(Integer.toHexString(codePoint));
            throw new IllegalArgumentException(sb.toString());
        }
        return this;
    }

    /* renamed from: a */
    public C14191g mo44210a(String string, Charset charset) {
        mo44209a(string, 0, string.length(), charset);
        return this;
    }

    /* renamed from: a */
    public C14191g mo44209a(String string, int beginIndex, int endIndex, Charset charset) {
        if (string == null) {
            throw new IllegalArgumentException("string == null");
        } else if (beginIndex < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("beginIndex < 0: ");
            sb.append(beginIndex);
            throw new IllegalAccessError(sb.toString());
        } else if (endIndex < beginIndex) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("endIndex < beginIndex: ");
            sb2.append(endIndex);
            sb2.append(" < ");
            sb2.append(beginIndex);
            throw new IllegalArgumentException(sb2.toString());
        } else if (endIndex > string.length()) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("endIndex > string.length: ");
            sb3.append(endIndex);
            sb3.append(" > ");
            sb3.append(string.length());
            throw new IllegalArgumentException(sb3.toString());
        } else if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (charset.equals(C14183E.f43062a)) {
            mo44208a(string, beginIndex, endIndex);
            return this;
        } else {
            byte[] data = string.substring(beginIndex, endIndex).getBytes(charset);
            write(data, 0, data.length);
            return this;
        }
    }

    public C14191g write(byte[] source) {
        if (source != null) {
            write(source, 0, source.length);
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public C14191g write(byte[] source, int offset, int byteCount) {
        if (source != null) {
            C14183E.m45554a((long) source.length, (long) offset, (long) byteCount);
            int limit = offset + byteCount;
            while (offset < limit) {
                C14209x tail = mo44220b(1);
                int toCopy = Math.min(limit - offset, 8192 - tail.f43111c);
                System.arraycopy(source, offset, tail.f43109a, tail.f43111c, toCopy);
                offset += toCopy;
                tail.f43111c += toCopy;
            }
            this.f43073c += (long) byteCount;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public int write(ByteBuffer source) throws IOException {
        if (source != null) {
            int byteCount = source.remaining();
            int remaining = byteCount;
            while (remaining > 0) {
                C14209x tail = mo44220b(1);
                int toCopy = Math.min(remaining, 8192 - tail.f43111c);
                source.get(tail.f43109a, tail.f43111c, toCopy);
                remaining -= toCopy;
                tail.f43111c += toCopy;
            }
            this.f43073c += (long) byteCount;
            return byteCount;
        }
        throw new IllegalArgumentException("source == null");
    }

    /* renamed from: a */
    public long mo44203a(C14180B source) throws IOException {
        if (source != null) {
            long totalBytesRead = 0;
            while (true) {
                long read = source.read(this, 8192);
                long readCount = read;
                if (read == -1) {
                    return totalBytesRead;
                }
                totalBytesRead += readCount;
            }
        } else {
            throw new IllegalArgumentException("source == null");
        }
    }

    public C14191g writeByte(int b) {
        C14209x tail = mo44220b(1);
        byte[] bArr = tail.f43109a;
        int i = tail.f43111c;
        tail.f43111c = i + 1;
        bArr[i] = (byte) b;
        this.f43073c++;
        return this;
    }

    public C14191g writeShort(int s) {
        C14209x tail = mo44220b(2);
        byte[] data = tail.f43109a;
        int limit = tail.f43111c;
        int limit2 = limit + 1;
        data[limit] = (byte) ((s >>> 8) & 255);
        int limit3 = limit2 + 1;
        data[limit2] = (byte) (s & 255);
        tail.f43111c = limit3;
        this.f43073c += 2;
        return this;
    }

    public C14191g writeInt(int i) {
        C14209x tail = mo44220b(4);
        byte[] data = tail.f43109a;
        int limit = tail.f43111c;
        int limit2 = limit + 1;
        data[limit] = (byte) ((i >>> 24) & 255);
        int limit3 = limit2 + 1;
        data[limit2] = (byte) ((i >>> 16) & 255);
        int limit4 = limit3 + 1;
        data[limit3] = (byte) ((i >>> 8) & 255);
        int limit5 = limit4 + 1;
        data[limit4] = (byte) (i & 255);
        tail.f43111c = limit5;
        this.f43073c += 4;
        return this;
    }

    /* renamed from: j */
    public C14191g mo44237j(long v) {
        C14209x tail = mo44220b(8);
        byte[] data = tail.f43109a;
        int limit = tail.f43111c;
        int limit2 = limit + 1;
        data[limit] = (byte) ((int) ((v >>> 56) & 255));
        int limit3 = limit2 + 1;
        data[limit2] = (byte) ((int) ((v >>> 48) & 255));
        int limit4 = limit3 + 1;
        data[limit3] = (byte) ((int) ((v >>> 40) & 255));
        int limit5 = limit4 + 1;
        data[limit4] = (byte) ((int) ((v >>> 32) & 255));
        int limit6 = limit5 + 1;
        data[limit5] = (byte) ((int) ((v >>> 24) & 255));
        int limit7 = limit6 + 1;
        data[limit6] = (byte) ((int) ((v >>> 16) & 255));
        int limit8 = limit7 + 1;
        data[limit7] = (byte) ((int) ((v >>> 8) & 255));
        int limit9 = limit8 + 1;
        data[limit8] = (byte) ((int) (v & 255));
        tail.f43111c = limit9;
        this.f43073c += 8;
        return this;
    }

    /* renamed from: a */
    public C14191g mo44205a(long v) {
        if (v == 0) {
            writeByte(48);
            return this;
        }
        boolean negative = false;
        if (v < 0) {
            v = -v;
            if (v < 0) {
                mo44229f("-9223372036854775808");
                return this;
            }
            negative = true;
        }
        int width = v < 100000000 ? v < 10000 ? v < 100 ? v < 10 ? 1 : 2 : v < 1000 ? 3 : 4 : v < 1000000 ? v < 100000 ? 5 : 6 : v < 10000000 ? 7 : 8 : v < 1000000000000L ? v < 10000000000L ? v < 1000000000 ? 9 : 10 : v < 100000000000L ? 11 : 12 : v < 1000000000000000L ? v < 10000000000000L ? 13 : v < 100000000000000L ? 14 : 15 : v < 100000000000000000L ? v < 10000000000000000L ? 16 : 17 : v < 1000000000000000000L ? 18 : 19;
        if (negative) {
            width++;
        }
        C14209x tail = mo44220b(width);
        byte[] data = tail.f43109a;
        int pos = tail.f43111c + width;
        while (v != 0) {
            pos--;
            data[pos] = f43071a[(int) (v % 10)];
            v /= 10;
        }
        if (negative) {
            data[pos - 1] = 45;
        }
        tail.f43111c += width;
        this.f43073c += (long) width;
        return this;
    }

    /* renamed from: b */
    public C14191g mo44219b(long v) {
        if (v == 0) {
            writeByte(48);
            return this;
        }
        int width = (Long.numberOfTrailingZeros(Long.highestOneBit(v)) / 4) + 1;
        C14209x tail = mo44220b(width);
        byte[] data = tail.f43109a;
        int start = tail.f43111c;
        for (int pos = (tail.f43111c + width) - 1; pos >= start; pos--) {
            data[pos] = f43071a[(int) (15 & v)];
            v >>>= 4;
        }
        tail.f43111c += width;
        this.f43073c += (long) width;
        return this;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public C14209x mo44220b(int minimumCapacity) {
        if (minimumCapacity < 1 || minimumCapacity > 8192) {
            throw new IllegalArgumentException();
        }
        C14209x xVar = this.f43072b;
        if (xVar == null) {
            this.f43072b = C14210y.m45724a();
            C14209x xVar2 = this.f43072b;
            xVar2.f43115g = xVar2;
            xVar2.f43114f = xVar2;
            return xVar2;
        }
        C14209x tail = xVar.f43115g;
        if (tail.f43111c + minimumCapacity > 8192 || !tail.f43113e) {
            tail = tail.mo44313a(C14210y.m45724a());
        }
        return tail;
    }

    public void write(C14191g source, long byteCount) {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        } else if (source != this) {
            C14183E.m45554a(source.f43073c, 0, byteCount);
            while (byteCount > 0) {
                C14209x xVar = source.f43072b;
                if (byteCount < ((long) (xVar.f43111c - xVar.f43110b))) {
                    C14209x xVar2 = this.f43072b;
                    C14209x tail = xVar2 != null ? xVar2.f43115g : null;
                    if (tail != null && tail.f43113e) {
                        if ((((long) tail.f43111c) + byteCount) - ((long) (tail.f43112d ? 0 : tail.f43110b)) <= 8192) {
                            source.f43072b.mo44315a(tail, (int) byteCount);
                            source.f43073c -= byteCount;
                            this.f43073c += byteCount;
                            return;
                        }
                    }
                    source.f43072b = source.f43072b.mo44312a((int) byteCount);
                }
                C14209x segmentToMove = source.f43072b;
                long movedByteCount = (long) (segmentToMove.f43111c - segmentToMove.f43110b);
                source.f43072b = segmentToMove.mo44316b();
                C14209x xVar3 = this.f43072b;
                if (xVar3 == null) {
                    this.f43072b = segmentToMove;
                    C14209x xVar4 = this.f43072b;
                    xVar4.f43115g = xVar4;
                    xVar4.f43114f = xVar4;
                } else {
                    xVar3.f43115g.mo44313a(segmentToMove).mo44314a();
                }
                source.f43073c -= movedByteCount;
                this.f43073c += movedByteCount;
                byteCount -= movedByteCount;
            }
        } else {
            throw new IllegalArgumentException("source == this");
        }
    }

    public long read(C14191g sink, long byteCount) {
        if (sink == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (byteCount >= 0) {
            long j = this.f43073c;
            if (j == 0) {
                return -1;
            }
            if (byteCount > j) {
                byteCount = this.f43073c;
            }
            sink.write(this, byteCount);
            return byteCount;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("byteCount < 0: ");
            sb.append(byteCount);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* renamed from: a */
    public long mo44200a(byte b) {
        return mo44201a(b, 0, Long.MAX_VALUE);
    }

    /* renamed from: a */
    public long mo44201a(byte b, long fromIndex, long toIndex) {
        long offset;
        if (fromIndex < 0 || toIndex < fromIndex) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", new Object[]{Long.valueOf(this.f43073c), Long.valueOf(fromIndex), Long.valueOf(toIndex)}));
        }
        if (toIndex > this.f43073c) {
            toIndex = this.f43073c;
        }
        if (fromIndex == toIndex) {
            return -1;
        }
        C14209x s = this.f43072b;
        if (s == null) {
            return -1;
        }
        if (this.f43073c - fromIndex >= fromIndex) {
            long offset2 = 0;
            while (true) {
                long j = ((long) (s.f43111c - s.f43110b)) + offset;
                long nextOffset = j;
                if (j >= fromIndex) {
                    break;
                }
                s = s.f43114f;
                offset2 = nextOffset;
            }
        } else {
            offset = this.f43073c;
            while (offset > fromIndex) {
                s = s.f43115g;
                offset -= (long) (s.f43111c - s.f43110b);
            }
        }
        while (offset < toIndex) {
            byte[] data = s.f43109a;
            int limit = (int) Math.min((long) s.f43111c, (((long) s.f43110b) + toIndex) - offset);
            for (int pos = (int) ((((long) s.f43110b) + fromIndex) - offset); pos < limit; pos++) {
                if (data[pos] == b) {
                    return ((long) (pos - s.f43110b)) + offset;
                }
            }
            offset += (long) (s.f43111c - s.f43110b);
            fromIndex = offset;
            s = s.f43114f;
        }
        return -1;
    }

    /* renamed from: a */
    public boolean mo44216a(long offset, C14195j bytes) {
        return mo44217a(offset, bytes, 0, bytes.mo44285s());
    }

    /* renamed from: a */
    public boolean mo44217a(long offset, C14195j bytes, int bytesOffset, int byteCount) {
        if (offset < 0 || bytesOffset < 0 || byteCount < 0 || this.f43073c - offset < ((long) byteCount) || bytes.mo44285s() - bytesOffset < byteCount) {
            return false;
        }
        for (int i = 0; i < byteCount; i++) {
            if (mo44231g(((long) i) + offset) != bytes.mo44270a(bytesOffset + i)) {
                return false;
            }
        }
        return true;
    }

    public void flush() {
    }

    public boolean isOpen() {
        return true;
    }

    public void close() {
    }

    public C14182D timeout() {
        return C14182D.NONE;
    }

    public boolean equals(Object o) {
        Object obj = o;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C14191g)) {
            return false;
        }
        C14191g that = (C14191g) obj;
        long j = this.f43073c;
        if (j != that.f43073c) {
            return false;
        }
        if (j == 0) {
            return true;
        }
        C14209x sa = this.f43072b;
        C14209x sb = that.f43072b;
        int posA = sa.f43110b;
        int posB = sb.f43110b;
        long pos = 0;
        while (pos < this.f43073c) {
            long count = (long) Math.min(sa.f43111c - posA, sb.f43111c - posB);
            int i = 0;
            while (((long) i) < count) {
                int posA2 = posA + 1;
                int posB2 = posB + 1;
                if (sa.f43109a[posA] != sb.f43109a[posB]) {
                    return false;
                }
                i++;
                posA = posA2;
                posB = posB2;
            }
            if (posA == sa.f43111c) {
                sa = sa.f43114f;
                posA = sa.f43110b;
            }
            if (posB == sb.f43111c) {
                sb = sb.f43114f;
                posB = sb.f43110b;
            }
            pos += count;
        }
        return true;
    }

    public int hashCode() {
        C14209x s = this.f43072b;
        if (s == null) {
            return 0;
        }
        int result = 1;
        do {
            for (int pos = s.f43110b; pos < s.f43111c; pos++) {
                result = (result * 31) + s.f43109a[pos];
            }
            s = s.f43114f;
        } while (s != this.f43072b);
        return result;
    }

    public String toString() {
        return mo44266x().toString();
    }

    public C14191g clone() {
        C14191g result = new C14191g();
        if (this.f43073c == 0) {
            return result;
        }
        result.f43072b = this.f43072b.mo44317c();
        C14209x xVar = result.f43072b;
        xVar.f43115g = xVar;
        xVar.f43114f = xVar;
        for (C14209x s = this.f43072b.f43114f; s != this.f43072b; s = s.f43114f) {
            result.f43072b.f43115g.mo44313a(s.mo44317c());
        }
        result.f43073c = this.f43073c;
        return result;
    }

    /* renamed from: x */
    public C14195j mo44266x() {
        long j = this.f43073c;
        if (j <= 2147483647L) {
            return mo44211a((int) j);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("size > Integer.MAX_VALUE: ");
        sb.append(this.f43073c);
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: a */
    public C14195j mo44211a(int byteCount) {
        if (byteCount == 0) {
            return C14195j.f43082b;
        }
        return new C14211z(this, byteCount);
    }

    /* renamed from: a */
    public C14192a mo44204a(C14192a unsafeCursor) {
        if (unsafeCursor.f43074a == null) {
            unsafeCursor.f43074a = this;
            unsafeCursor.f43075b = true;
            return unsafeCursor;
        }
        throw new IllegalStateException("already attached to a buffer");
    }
}
