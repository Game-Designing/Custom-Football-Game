package p362h;

import java.io.IOException;

/* renamed from: h.l */
/* compiled from: ForwardingSource */
public abstract class C14197l implements C14180B {
    private final C14180B delegate;

    public C14197l(C14180B delegate2) {
        if (delegate2 != null) {
            this.delegate = delegate2;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public final C14180B delegate() {
        return this.delegate;
    }

    public long read(C14191g sink, long byteCount) throws IOException {
        return this.delegate.read(sink, byteCount);
    }

    public C14182D timeout() {
        return this.delegate.timeout();
    }

    public void close() throws IOException {
        this.delegate.close();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("(");
        sb.append(this.delegate.toString());
        sb.append(")");
        return sb.toString();
    }
}
