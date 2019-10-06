package p362h;

import java.io.IOException;
import java.nio.ByteBuffer;

/* renamed from: h.u */
/* compiled from: RealBufferedSink */
final class C14206u implements C14193h {

    /* renamed from: a */
    public final C14191g f43102a = new C14191g();

    /* renamed from: b */
    public final C14179A f43103b;

    /* renamed from: c */
    boolean f43104c;

    C14206u(C14179A sink) {
        if (sink != null) {
            this.f43103b = sink;
            return;
        }
        throw new NullPointerException("sink == null");
    }

    /* renamed from: k */
    public C14191g mo44238k() {
        return this.f43102a;
    }

    public void write(C14191g source, long byteCount) throws IOException {
        if (!this.f43104c) {
            this.f43102a.write(source, byteCount);
            mo44240m();
            return;
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: a */
    public C14193h mo44207a(C14195j byteString) throws IOException {
        if (!this.f43104c) {
            this.f43102a.mo44207a(byteString);
            mo44240m();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: f */
    public C14193h mo44229f(String string) throws IOException {
        if (!this.f43104c) {
            this.f43102a.mo44229f(string);
            mo44240m();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public C14193h write(byte[] source) throws IOException {
        if (!this.f43104c) {
            this.f43102a.write(source);
            mo44240m();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public C14193h write(byte[] source, int offset, int byteCount) throws IOException {
        if (!this.f43104c) {
            this.f43102a.write(source, offset, byteCount);
            mo44240m();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public int write(ByteBuffer source) throws IOException {
        if (!this.f43104c) {
            int result = this.f43102a.write(source);
            mo44240m();
            return result;
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: a */
    public long mo44203a(C14180B source) throws IOException {
        if (source != null) {
            long totalBytesRead = 0;
            while (true) {
                long read = source.read(this.f43102a, 8192);
                long readCount = read;
                if (read == -1) {
                    return totalBytesRead;
                }
                totalBytesRead += readCount;
                mo44240m();
            }
        } else {
            throw new IllegalArgumentException("source == null");
        }
    }

    public C14193h writeByte(int b) throws IOException {
        if (!this.f43104c) {
            this.f43102a.writeByte(b);
            mo44240m();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public C14193h writeShort(int s) throws IOException {
        if (!this.f43104c) {
            this.f43102a.writeShort(s);
            mo44240m();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public C14193h writeInt(int i) throws IOException {
        if (!this.f43104c) {
            this.f43102a.writeInt(i);
            mo44240m();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: a */
    public C14193h mo44205a(long v) throws IOException {
        if (!this.f43104c) {
            this.f43102a.mo44205a(v);
            mo44240m();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: b */
    public C14193h mo44219b(long v) throws IOException {
        if (!this.f43104c) {
            this.f43102a.mo44219b(v);
            mo44240m();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: m */
    public C14193h mo44240m() throws IOException {
        if (!this.f43104c) {
            long byteCount = this.f43102a.mo44218b();
            if (byteCount > 0) {
                this.f43103b.write(this.f43102a, byteCount);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: l */
    public C14193h mo44239l() throws IOException {
        if (!this.f43104c) {
            long byteCount = this.f43102a.size();
            if (byteCount > 0) {
                this.f43103b.write(this.f43102a, byteCount);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public void flush() throws IOException {
        if (!this.f43104c) {
            C14191g gVar = this.f43102a;
            long j = gVar.f43073c;
            if (j > 0) {
                this.f43103b.write(gVar, j);
            }
            this.f43103b.flush();
            return;
        }
        throw new IllegalStateException("closed");
    }

    public boolean isOpen() {
        return !this.f43104c;
    }

    public void close() throws IOException {
        if (!this.f43104c) {
            Throwable thrown = null;
            try {
                if (this.f43102a.f43073c > 0) {
                    this.f43103b.write(this.f43102a, this.f43102a.f43073c);
                }
            } catch (Throwable e) {
                thrown = e;
            }
            try {
                this.f43103b.close();
            } catch (Throwable e2) {
                if (thrown == null) {
                    thrown = e2;
                }
            }
            this.f43104c = true;
            if (thrown != null) {
                C14183E.m45555a(thrown);
                throw null;
            }
        }
    }

    public C14182D timeout() {
        return this.f43103b.timeout();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("buffer(");
        sb.append(this.f43103b);
        sb.append(")");
        return sb.toString();
    }
}
