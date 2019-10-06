package p362h;

import java.io.IOException;
import java.io.OutputStream;

/* renamed from: h.p */
/* compiled from: Okio */
class C14201p implements C14179A {

    /* renamed from: a */
    final /* synthetic */ C14182D f43096a;

    /* renamed from: b */
    final /* synthetic */ OutputStream f43097b;

    C14201p(C14182D d, OutputStream outputStream) {
        this.f43096a = d;
        this.f43097b = outputStream;
    }

    public void write(C14191g source, long byteCount) throws IOException {
        C14183E.m45554a(source.f43073c, 0, byteCount);
        while (byteCount > 0) {
            this.f43096a.throwIfReached();
            C14209x head = source.f43072b;
            int toCopy = (int) Math.min(byteCount, (long) (head.f43111c - head.f43110b));
            this.f43097b.write(head.f43109a, head.f43110b, toCopy);
            head.f43110b += toCopy;
            byteCount -= (long) toCopy;
            source.f43073c -= (long) toCopy;
            if (head.f43110b == head.f43111c) {
                source.f43072b = head.mo44316b();
                C14210y.m45725a(head);
            }
        }
    }

    public void flush() throws IOException {
        this.f43097b.flush();
    }

    public void close() throws IOException {
        this.f43097b.close();
    }

    public C14182D timeout() {
        return this.f43096a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("sink(");
        sb.append(this.f43097b);
        sb.append(")");
        return sb.toString();
    }
}
