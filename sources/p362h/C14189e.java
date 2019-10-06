package p362h;

import java.io.OutputStream;

/* renamed from: h.e */
/* compiled from: Buffer */
class C14189e extends OutputStream {

    /* renamed from: a */
    final /* synthetic */ C14191g f43069a;

    C14189e(C14191g this$0) {
        this.f43069a = this$0;
    }

    public void write(int b) {
        this.f43069a.writeByte((int) (byte) b);
    }

    public void write(byte[] data, int offset, int byteCount) {
        this.f43069a.write(data, offset, byteCount);
    }

    public void flush() {
    }

    public void close() {
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f43069a);
        sb.append(".outputStream()");
        return sb.toString();
    }
}
