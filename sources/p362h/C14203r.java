package p362h;

import java.io.IOException;

/* renamed from: h.r */
/* compiled from: Okio */
class C14203r implements C14179A {
    C14203r() {
    }

    public void write(C14191g source, long byteCount) throws IOException {
        source.skip(byteCount);
    }

    public void flush() throws IOException {
    }

    public C14182D timeout() {
        return C14182D.NONE;
    }

    public void close() throws IOException {
    }
}
