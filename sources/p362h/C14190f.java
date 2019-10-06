package p362h;

import java.io.InputStream;

/* renamed from: h.f */
/* compiled from: Buffer */
class C14190f extends InputStream {

    /* renamed from: a */
    final /* synthetic */ C14191g f43070a;

    C14190f(C14191g this$0) {
        this.f43070a = this$0;
    }

    public int read() {
        C14191g gVar = this.f43070a;
        if (gVar.f43073c > 0) {
            return gVar.readByte() & 255;
        }
        return -1;
    }

    public int read(byte[] sink, int offset, int byteCount) {
        return this.f43070a.mo44199a(sink, offset, byteCount);
    }

    public int available() {
        return (int) Math.min(this.f43070a.f43073c, 2147483647L);
    }

    public void close() {
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f43070a);
        sb.append(".inputStream()");
        return sb.toString();
    }
}
