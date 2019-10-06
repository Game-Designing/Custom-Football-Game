package p362h;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* renamed from: h.o */
/* compiled from: InflaterSource */
public final class C14200o implements C14180B {

    /* renamed from: a */
    private final C14194i f43092a;

    /* renamed from: b */
    private final Inflater f43093b;

    /* renamed from: c */
    private int f43094c;

    /* renamed from: d */
    private boolean f43095d;

    C14200o(C14194i source, Inflater inflater) {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        } else if (inflater != null) {
            this.f43092a = source;
            this.f43093b = inflater;
        } else {
            throw new IllegalArgumentException("inflater == null");
        }
    }

    public long read(C14191g sink, long byteCount) throws IOException {
        C14209x tail;
        if (byteCount < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("byteCount < 0: ");
            sb.append(byteCount);
            throw new IllegalArgumentException(sb.toString());
        } else if (this.f43095d) {
            throw new IllegalStateException("closed");
        } else if (byteCount == 0) {
            return 0;
        } else {
            while (true) {
                boolean sourceExhausted = mo44296a();
                try {
                    tail = sink.mo44220b(1);
                    int bytesInflated = this.f43093b.inflate(tail.f43109a, tail.f43111c, (int) Math.min(byteCount, (long) (8192 - tail.f43111c)));
                    if (bytesInflated > 0) {
                        tail.f43111c += bytesInflated;
                        sink.f43073c += (long) bytesInflated;
                        return (long) bytesInflated;
                    } else if (this.f43093b.finished()) {
                        break;
                    } else if (this.f43093b.needsDictionary()) {
                        break;
                    } else if (sourceExhausted) {
                        throw new EOFException("source exhausted prematurely");
                    }
                } catch (DataFormatException e) {
                    throw new IOException(e);
                }
            }
            m45673b();
            if (tail.f43110b == tail.f43111c) {
                sink.f43072b = tail.mo44316b();
                C14210y.m45725a(tail);
            }
            return -1;
        }
    }

    /* renamed from: a */
    public boolean mo44296a() throws IOException {
        if (!this.f43093b.needsInput()) {
            return false;
        }
        m45673b();
        if (this.f43093b.getRemaining() != 0) {
            throw new IllegalStateException("?");
        } else if (this.f43092a.mo44244q()) {
            return true;
        } else {
            C14209x head = this.f43092a.mo44238k().f43072b;
            int i = head.f43111c;
            int i2 = head.f43110b;
            this.f43094c = i - i2;
            this.f43093b.setInput(head.f43109a, i2, this.f43094c);
            return false;
        }
    }

    /* renamed from: b */
    private void m45673b() throws IOException {
        int i = this.f43094c;
        if (i != 0) {
            int toRelease = i - this.f43093b.getRemaining();
            this.f43094c -= toRelease;
            this.f43092a.skip((long) toRelease);
        }
    }

    public C14182D timeout() {
        return this.f43092a.timeout();
    }

    public void close() throws IOException {
        if (!this.f43095d) {
            this.f43093b.end();
            this.f43095d = true;
            this.f43092a.close();
        }
    }
}
