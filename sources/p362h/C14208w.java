package p362h;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* renamed from: h.w */
/* compiled from: RealBufferedSource */
final class C14208w implements C14194i {

    /* renamed from: a */
    public final C14191g f43106a = new C14191g();

    /* renamed from: b */
    public final C14180B f43107b;

    /* renamed from: c */
    boolean f43108c;

    C14208w(C14180B source) {
        if (source != null) {
            this.f43107b = source;
            return;
        }
        throw new NullPointerException("source == null");
    }

    /* renamed from: k */
    public C14191g mo44238k() {
        return this.f43106a;
    }

    public long read(C14191g sink, long byteCount) throws IOException {
        if (sink == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (byteCount < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("byteCount < 0: ");
            sb.append(byteCount);
            throw new IllegalArgumentException(sb.toString());
        } else if (!this.f43108c) {
            C14191g gVar = this.f43106a;
            if (gVar.f43073c == 0 && this.f43107b.read(gVar, 8192) == -1) {
                return -1;
            }
            return this.f43106a.read(sink, Math.min(byteCount, this.f43106a.f43073c));
        } else {
            throw new IllegalStateException("closed");
        }
    }

    /* renamed from: q */
    public boolean mo44244q() throws IOException {
        if (!this.f43108c) {
            return this.f43106a.mo44244q() && this.f43107b.read(this.f43106a, 8192) == -1;
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: e */
    public void mo44227e(long byteCount) throws IOException {
        if (!request(byteCount)) {
            throw new EOFException();
        }
    }

    public boolean request(long byteCount) throws IOException {
        C14191g gVar;
        if (byteCount < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("byteCount < 0: ");
            sb.append(byteCount);
            throw new IllegalArgumentException(sb.toString());
        } else if (!this.f43108c) {
            do {
                gVar = this.f43106a;
                if (gVar.f43073c >= byteCount) {
                    return true;
                }
            } while (this.f43107b.read(gVar, 8192) != -1);
            return false;
        } else {
            throw new IllegalStateException("closed");
        }
    }

    public byte readByte() throws IOException {
        mo44227e(1);
        return this.f43106a.readByte();
    }

    /* renamed from: f */
    public C14195j mo44230f(long byteCount) throws IOException {
        mo44227e(byteCount);
        return this.f43106a.mo44230f(byteCount);
    }

    /* renamed from: p */
    public byte[] mo44243p() throws IOException {
        this.f43106a.mo44203a(this.f43107b);
        return this.f43106a.mo44243p();
    }

    /* renamed from: d */
    public byte[] mo44226d(long byteCount) throws IOException {
        mo44227e(byteCount);
        return this.f43106a.mo44226d(byteCount);
    }

    public void readFully(byte[] sink) throws IOException {
        try {
            mo44227e((long) sink.length);
            this.f43106a.readFully(sink);
        } catch (EOFException e) {
            int offset = 0;
            while (true) {
                C14191g gVar = this.f43106a;
                long j = gVar.f43073c;
                if (j > 0) {
                    int read = gVar.mo44199a(sink, offset, (int) j);
                    if (read != -1) {
                        offset += read;
                    } else {
                        throw new AssertionError();
                    }
                } else {
                    throw e;
                }
            }
        }
    }

    public int read(ByteBuffer sink) throws IOException {
        C14191g gVar = this.f43106a;
        if (gVar.f43073c == 0 && this.f43107b.read(gVar, 8192) == -1) {
            return -1;
        }
        return this.f43106a.read(sink);
    }

    /* renamed from: a */
    public void mo44215a(C14191g sink, long byteCount) throws IOException {
        try {
            mo44227e(byteCount);
            this.f43106a.mo44215a(sink, byteCount);
        } catch (EOFException e) {
            sink.mo44203a((C14180B) this.f43106a);
            throw e;
        }
    }

    /* renamed from: a */
    public long mo44202a(C14179A sink) throws IOException {
        if (sink != null) {
            long totalBytesWritten = 0;
            while (this.f43107b.read(this.f43106a, 8192) != -1) {
                long emitByteCount = this.f43106a.mo44218b();
                if (emitByteCount > 0) {
                    totalBytesWritten += emitByteCount;
                    sink.write(this.f43106a, emitByteCount);
                }
            }
            if (this.f43106a.size() <= 0) {
                return totalBytesWritten;
            }
            long totalBytesWritten2 = totalBytesWritten + this.f43106a.size();
            C14191g gVar = this.f43106a;
            sink.write(gVar, gVar.size());
            return totalBytesWritten2;
        }
        throw new IllegalArgumentException("sink == null");
    }

    /* renamed from: a */
    public String mo44213a(Charset charset) throws IOException {
        if (charset != null) {
            this.f43106a.mo44203a(this.f43107b);
            return this.f43106a.mo44213a(charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    /* renamed from: n */
    public String mo44241n() throws IOException {
        return mo44223c(Long.MAX_VALUE);
    }

    /* renamed from: c */
    public String mo44223c(long limit) throws IOException {
        long j = limit;
        if (j >= 0) {
            long scanLength = j == Long.MAX_VALUE ? Long.MAX_VALUE : j + 1;
            long newline = mo44307a(10, 0, scanLength);
            if (newline != -1) {
                return this.f43106a.mo44235i(newline);
            }
            if (scanLength < Long.MAX_VALUE && request(scanLength) && this.f43106a.mo44231g(scanLength - 1) == 13 && request(1 + scanLength) && this.f43106a.mo44231g(scanLength) == 10) {
                return this.f43106a.mo44235i(scanLength);
            }
            C14191g data = new C14191g();
            C14191g gVar = this.f43106a;
            gVar.mo44206a(data, 0, Math.min(32, gVar.size()));
            StringBuilder sb = new StringBuilder();
            sb.append("\\n not found: limit=");
            sb.append(Math.min(this.f43106a.size(), j));
            sb.append(" content=");
            sb.append(data.mo44225d().mo44280f());
            sb.append(8230);
            throw new EOFException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("limit < 0: ");
        sb2.append(j);
        throw new IllegalArgumentException(sb2.toString());
    }

    public short readShort() throws IOException {
        mo44227e(2);
        return this.f43106a.readShort();
    }

    /* renamed from: o */
    public short mo44242o() throws IOException {
        mo44227e(2);
        return this.f43106a.mo44242o();
    }

    public int readInt() throws IOException {
        mo44227e(4);
        return this.f43106a.readInt();
    }

    /* renamed from: s */
    public int mo44253s() throws IOException {
        mo44227e(4);
        return this.f43106a.mo44253s();
    }

    public long readLong() throws IOException {
        mo44227e(8);
        return this.f43106a.readLong();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002b  */
    /* renamed from: r */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long mo44245r() throws java.io.IOException {
        /*
            r6 = this;
            r0 = 1
            r6.mo44227e(r0)
            r0 = 0
        L_0x0006:
            int r1 = r0 + 1
            long r1 = (long) r1
            boolean r1 = r6.request(r1)
            if (r1 == 0) goto L_0x0041
            h.g r1 = r6.f43106a
            long r2 = (long) r0
            byte r1 = r1.mo44231g(r2)
            r2 = 48
            if (r1 < r2) goto L_0x001e
            r2 = 57
            if (r1 <= r2) goto L_0x0025
        L_0x001e:
            if (r0 != 0) goto L_0x0028
            r2 = 45
            if (r1 == r2) goto L_0x0025
            goto L_0x0028
        L_0x0025:
            int r0 = r0 + 1
            goto L_0x0006
        L_0x0028:
            if (r0 == 0) goto L_0x002b
            goto L_0x0041
        L_0x002b:
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r4 = 0
            java.lang.Byte r5 = java.lang.Byte.valueOf(r1)
            r3[r4] = r5
            java.lang.String r4 = "Expected leading [0-9] or '-' character but was %#x"
            java.lang.String r3 = java.lang.String.format(r4, r3)
            r2.<init>(r3)
            throw r2
        L_0x0041:
            h.g r0 = r6.f43106a
            long r0 = r0.mo44245r()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p362h.C14208w.mo44245r():long");
    }

    /* renamed from: t */
    public long mo44256t() throws IOException {
        mo44227e(1);
        int pos = 0;
        while (true) {
            if (!request((long) (pos + 1))) {
                break;
            }
            byte b = this.f43106a.mo44231g((long) pos);
            if ((b >= 48 && b <= 57) || ((b >= 97 && b <= 102) || (b >= 65 && b <= 70))) {
                pos++;
            } else if (pos == 0) {
                throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", new Object[]{Byte.valueOf(b)}));
            }
        }
        return this.f43106a.mo44256t();
    }

    public void skip(long byteCount) throws IOException {
        if (!this.f43108c) {
            while (byteCount > 0) {
                C14191g gVar = this.f43106a;
                if (gVar.f43073c == 0 && this.f43107b.read(gVar, 8192) == -1) {
                    throw new EOFException();
                }
                long toSkip = Math.min(byteCount, this.f43106a.size());
                this.f43106a.skip(toSkip);
                byteCount -= toSkip;
            }
            return;
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: a */
    public long mo44200a(byte b) throws IOException {
        return mo44307a(b, 0, Long.MAX_VALUE);
    }

    /* renamed from: a */
    public long mo44307a(byte b, long fromIndex, long toIndex) throws IOException {
        if (this.f43108c) {
            throw new IllegalStateException("closed");
        } else if (fromIndex < 0 || toIndex < fromIndex) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", new Object[]{Long.valueOf(fromIndex), Long.valueOf(toIndex)}));
        } else {
            long fromIndex2 = fromIndex;
            while (fromIndex2 < toIndex) {
                long result = this.f43106a.mo44201a(b, fromIndex2, toIndex);
                if (result != -1) {
                    return result;
                }
                C14191g gVar = this.f43106a;
                long lastBufferSize = gVar.f43073c;
                if (lastBufferSize >= toIndex || this.f43107b.read(gVar, 8192) == -1) {
                    return -1;
                }
                fromIndex2 = Math.max(fromIndex2, lastBufferSize);
            }
            return -1;
        }
    }

    /* renamed from: a */
    public boolean mo44216a(long offset, C14195j bytes) throws IOException {
        return mo44308a(offset, bytes, 0, bytes.mo44285s());
    }

    /* renamed from: a */
    public boolean mo44308a(long offset, C14195j bytes, int bytesOffset, int byteCount) throws IOException {
        if (this.f43108c) {
            throw new IllegalStateException("closed");
        } else if (offset < 0 || bytesOffset < 0 || byteCount < 0 || bytes.mo44285s() - bytesOffset < byteCount) {
            return false;
        } else {
            for (int i = 0; i < byteCount; i++) {
                long bufferOffset = ((long) i) + offset;
                if (!request(1 + bufferOffset) || this.f43106a.mo44231g(bufferOffset) != bytes.mo44270a(bytesOffset + i)) {
                    return false;
                }
            }
            return true;
        }
    }

    /* renamed from: u */
    public InputStream mo44258u() {
        return new C14207v(this);
    }

    public boolean isOpen() {
        return !this.f43108c;
    }

    public void close() throws IOException {
        if (!this.f43108c) {
            this.f43108c = true;
            this.f43107b.close();
            this.f43106a.mo44214a();
        }
    }

    public C14182D timeout() {
        return this.f43107b.timeout();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("buffer(");
        sb.append(this.f43107b);
        sb.append(")");
        return sb.toString();
    }
}
