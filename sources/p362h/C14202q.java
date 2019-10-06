package p362h;

import java.io.IOException;
import java.io.InputStream;

/* renamed from: h.q */
/* compiled from: Okio */
class C14202q implements C14180B {

    /* renamed from: a */
    final /* synthetic */ C14182D f43098a;

    /* renamed from: b */
    final /* synthetic */ InputStream f43099b;

    C14202q(C14182D d, InputStream inputStream) {
        this.f43098a = d;
        this.f43099b = inputStream;
    }

    public long read(C14191g sink, long byteCount) throws IOException {
        if (byteCount < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("byteCount < 0: ");
            sb.append(byteCount);
            throw new IllegalArgumentException(sb.toString());
        } else if (byteCount == 0) {
            return 0;
        } else {
            try {
                this.f43098a.throwIfReached();
                C14209x tail = sink.mo44220b(1);
                int bytesRead = this.f43099b.read(tail.f43109a, tail.f43111c, (int) Math.min(byteCount, (long) (8192 - tail.f43111c)));
                if (bytesRead == -1) {
                    return -1;
                }
                tail.f43111c += bytesRead;
                sink.f43073c += (long) bytesRead;
                return (long) bytesRead;
            } catch (AssertionError e) {
                if (C14205t.m45684a(e)) {
                    throw new IOException(e);
                }
                throw e;
            }
        }
    }

    public void close() throws IOException {
        this.f43099b.close();
    }

    public C14182D timeout() {
        return this.f43098a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("source(");
        sb.append(this.f43099b);
        sb.append(")");
        return sb.toString();
    }
}
