package p362h;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* renamed from: h.n */
/* compiled from: GzipSource */
public final class C14199n implements C14180B {

    /* renamed from: a */
    private int f43087a = 0;

    /* renamed from: b */
    private final C14194i f43088b;

    /* renamed from: c */
    private final Inflater f43089c;

    /* renamed from: d */
    private final C14200o f43090d;

    /* renamed from: e */
    private final CRC32 f43091e = new CRC32();

    public C14199n(C14180B source) {
        if (source != null) {
            this.f43089c = new Inflater(true);
            this.f43088b = C14205t.m45683a(source);
            this.f43090d = new C14200o(this.f43088b, this.f43089c);
            return;
        }
        throw new IllegalArgumentException("source == null");
    }

    public long read(C14191g sink, long byteCount) throws IOException {
        C14191g gVar = sink;
        long j = byteCount;
        if (j < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("byteCount < 0: ");
            sb.append(j);
            throw new IllegalArgumentException(sb.toString());
        } else if (j == 0) {
            return 0;
        } else {
            if (this.f43087a == 0) {
                m45669a();
                this.f43087a = 1;
            }
            if (this.f43087a == 1) {
                long offset = gVar.f43073c;
                long result = this.f43090d.read(sink, j);
                if (result != -1) {
                    m45670a(sink, offset, result);
                    return result;
                }
                this.f43087a = 2;
            }
            if (this.f43087a == 2) {
                m45672b();
                this.f43087a = 3;
                if (!this.f43088b.mo44244q()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1;
        }
    }

    /* renamed from: a */
    private void m45669a() throws IOException {
        this.f43088b.mo44227e(10);
        byte flags = this.f43088b.mo44238k().mo44231g(3);
        boolean fhcrc = ((flags >> 1) & 1) == 1;
        if (fhcrc) {
            m45670a(this.f43088b.mo44238k(), 0, 10);
        }
        m45671a("ID1ID2", 8075, (int) this.f43088b.readShort());
        this.f43088b.skip(8);
        if (((flags >> 2) & 1) == 1) {
            this.f43088b.mo44227e(2);
            if (fhcrc) {
                m45670a(this.f43088b.mo44238k(), 0, 2);
            }
            int xlen = this.f43088b.mo44238k().mo44242o();
            this.f43088b.mo44227e((long) xlen);
            if (fhcrc) {
                m45670a(this.f43088b.mo44238k(), 0, (long) xlen);
            }
            this.f43088b.skip((long) xlen);
        }
        if (((flags >> 3) & 1) == 1) {
            long index = this.f43088b.mo44200a(0);
            if (index != -1) {
                if (fhcrc) {
                    m45670a(this.f43088b.mo44238k(), 0, index + 1);
                }
                this.f43088b.skip(index + 1);
            } else {
                throw new EOFException();
            }
        }
        if (((flags >> 4) & 1) == 1) {
            long index2 = this.f43088b.mo44200a(0);
            if (index2 != -1) {
                if (fhcrc) {
                    m45670a(this.f43088b.mo44238k(), 0, index2 + 1);
                }
                this.f43088b.skip(1 + index2);
            } else {
                throw new EOFException();
            }
        }
        if (fhcrc) {
            m45671a("FHCRC", (int) this.f43088b.mo44242o(), (int) (short) ((int) this.f43091e.getValue()));
            this.f43091e.reset();
        }
    }

    /* renamed from: b */
    private void m45672b() throws IOException {
        m45671a("CRC", this.f43088b.mo44253s(), (int) this.f43091e.getValue());
        m45671a("ISIZE", this.f43088b.mo44253s(), (int) this.f43089c.getBytesWritten());
    }

    public C14182D timeout() {
        return this.f43088b.timeout();
    }

    public void close() throws IOException {
        this.f43090d.close();
    }

    /* renamed from: a */
    private void m45670a(C14191g buffer, long offset, long byteCount) {
        C14209x s = buffer.f43072b;
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
            int pos = (int) (((long) s.f43110b) + offset);
            int toUpdate = (int) Math.min((long) (s.f43111c - pos), byteCount);
            this.f43091e.update(s.f43109a, pos, toUpdate);
            byteCount -= (long) toUpdate;
            offset = 0;
            s = s.f43114f;
        }
    }

    /* renamed from: a */
    private void m45671a(String name, int expected, int actual) throws IOException {
        if (actual != expected) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", new Object[]{name, Integer.valueOf(actual), Integer.valueOf(expected)}));
        }
    }
}
