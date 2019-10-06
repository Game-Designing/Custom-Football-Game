package p362h;

import java.io.IOException;

/* renamed from: h.a */
/* compiled from: AsyncTimeout */
class C14184a implements C14179A {

    /* renamed from: a */
    final /* synthetic */ C14179A f43063a;

    /* renamed from: b */
    final /* synthetic */ C14186c f43064b;

    C14184a(C14186c this$0, C14179A a) {
        this.f43064b = this$0;
        this.f43063a = a;
    }

    public void write(C14191g source, long byteCount) throws IOException {
        C14183E.m45554a(source.f43073c, 0, byteCount);
        while (byteCount > 0) {
            long toWrite = 0;
            C14209x s = source.f43072b;
            while (true) {
                if (toWrite >= 65536) {
                    break;
                }
                toWrite += (long) (s.f43111c - s.f43110b);
                if (toWrite >= byteCount) {
                    toWrite = byteCount;
                    break;
                }
                s = s.f43114f;
            }
            this.f43064b.enter();
            try {
                this.f43063a.write(source, toWrite);
                byteCount -= toWrite;
                this.f43064b.exit(true);
            } catch (IOException e) {
                throw this.f43064b.exit(e);
            } catch (Throwable th) {
                this.f43064b.exit(false);
                throw th;
            }
        }
    }

    public void flush() throws IOException {
        this.f43064b.enter();
        try {
            this.f43063a.flush();
            this.f43064b.exit(true);
        } catch (IOException e) {
            throw this.f43064b.exit(e);
        } catch (Throwable th) {
            this.f43064b.exit(false);
            throw th;
        }
    }

    public void close() throws IOException {
        this.f43064b.enter();
        try {
            this.f43063a.close();
            this.f43064b.exit(true);
        } catch (IOException e) {
            throw this.f43064b.exit(e);
        } catch (Throwable th) {
            this.f43064b.exit(false);
            throw th;
        }
    }

    public C14182D timeout() {
        return this.f43064b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AsyncTimeout.sink(");
        sb.append(this.f43063a);
        sb.append(")");
        return sb.toString();
    }
}
