package p362h;

import java.io.IOException;
import java.io.InputStream;

/* renamed from: h.v */
/* compiled from: RealBufferedSource */
class C14207v extends InputStream {

    /* renamed from: a */
    final /* synthetic */ C14208w f43105a;

    C14207v(C14208w this$0) {
        this.f43105a = this$0;
    }

    public int read() throws IOException {
        C14208w wVar = this.f43105a;
        if (!wVar.f43108c) {
            C14191g gVar = wVar.f43106a;
            if (gVar.f43073c == 0 && wVar.f43107b.read(gVar, 8192) == -1) {
                return -1;
            }
            return this.f43105a.f43106a.readByte() & 255;
        }
        throw new IOException("closed");
    }

    public int read(byte[] data, int offset, int byteCount) throws IOException {
        if (!this.f43105a.f43108c) {
            C14183E.m45554a((long) data.length, (long) offset, (long) byteCount);
            C14208w wVar = this.f43105a;
            C14191g gVar = wVar.f43106a;
            if (gVar.f43073c == 0 && wVar.f43107b.read(gVar, 8192) == -1) {
                return -1;
            }
            return this.f43105a.f43106a.mo44199a(data, offset, byteCount);
        }
        throw new IOException("closed");
    }

    public int available() throws IOException {
        C14208w wVar = this.f43105a;
        if (!wVar.f43108c) {
            return (int) Math.min(wVar.f43106a.f43073c, 2147483647L);
        }
        throw new IOException("closed");
    }

    public void close() throws IOException {
        this.f43105a.close();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f43105a);
        sb.append(".inputStream()");
        return sb.toString();
    }
}
