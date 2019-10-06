package p362h;

import java.io.IOException;

/* renamed from: h.b */
/* compiled from: AsyncTimeout */
class C14185b implements C14180B {

    /* renamed from: a */
    final /* synthetic */ C14180B f43065a;

    /* renamed from: b */
    final /* synthetic */ C14186c f43066b;

    C14185b(C14186c this$0, C14180B b) {
        this.f43066b = this$0;
        this.f43065a = b;
    }

    public long read(C14191g sink, long byteCount) throws IOException {
        this.f43066b.enter();
        try {
            long result = this.f43065a.read(sink, byteCount);
            this.f43066b.exit(true);
            return result;
        } catch (IOException e) {
            throw this.f43066b.exit(e);
        } catch (Throwable th) {
            this.f43066b.exit(false);
            throw th;
        }
    }

    public void close() throws IOException {
        try {
            this.f43065a.close();
            this.f43066b.exit(true);
        } catch (IOException e) {
            throw this.f43066b.exit(e);
        } catch (Throwable th) {
            this.f43066b.exit(false);
            throw th;
        }
    }

    public C14182D timeout() {
        return this.f43066b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AsyncTimeout.source(");
        sb.append(this.f43065a);
        sb.append(")");
        return sb.toString();
    }
}
