package p362h;

import java.io.IOException;

/* renamed from: h.k */
/* compiled from: ForwardingSink */
public abstract class C14196k implements C14179A {
    private final C14179A delegate;

    public C14196k(C14179A delegate2) {
        if (delegate2 != null) {
            this.delegate = delegate2;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public final C14179A delegate() {
        return this.delegate;
    }

    public void write(C14191g source, long byteCount) throws IOException {
        this.delegate.write(source, byteCount);
    }

    public void flush() throws IOException {
        this.delegate.flush();
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
