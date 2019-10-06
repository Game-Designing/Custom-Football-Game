package p362h;

import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: h.x */
/* compiled from: Segment */
final class C14209x {

    /* renamed from: a */
    final byte[] f43109a;

    /* renamed from: b */
    int f43110b;

    /* renamed from: c */
    int f43111c;

    /* renamed from: d */
    boolean f43112d;

    /* renamed from: e */
    boolean f43113e;

    /* renamed from: f */
    C14209x f43114f;

    /* renamed from: g */
    C14209x f43115g;

    C14209x() {
        this.f43109a = new byte[Opcodes.ACC_ANNOTATION];
        this.f43113e = true;
        this.f43112d = false;
    }

    C14209x(byte[] data, int pos, int limit, boolean shared, boolean owner) {
        this.f43109a = data;
        this.f43110b = pos;
        this.f43111c = limit;
        this.f43112d = shared;
        this.f43113e = owner;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public C14209x mo44317c() {
        this.f43112d = true;
        C14209x xVar = new C14209x(this.f43109a, this.f43110b, this.f43111c, true, false);
        return xVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public C14209x mo44318d() {
        C14209x xVar = new C14209x((byte[]) this.f43109a.clone(), this.f43110b, this.f43111c, false, true);
        return xVar;
    }

    /* renamed from: b */
    public C14209x mo44316b() {
        C14209x result = this.f43114f;
        if (result == this) {
            result = null;
        }
        C14209x xVar = this.f43115g;
        xVar.f43114f = this.f43114f;
        this.f43114f.f43115g = xVar;
        this.f43114f = null;
        this.f43115g = null;
        return result;
    }

    /* renamed from: a */
    public C14209x mo44313a(C14209x segment) {
        segment.f43115g = this;
        segment.f43114f = this.f43114f;
        this.f43114f.f43115g = segment;
        this.f43114f = segment;
        return segment;
    }

    /* renamed from: a */
    public C14209x mo44312a(int byteCount) {
        C14209x prefix;
        if (byteCount <= 0 || byteCount > this.f43111c - this.f43110b) {
            throw new IllegalArgumentException();
        }
        if (byteCount >= 1024) {
            prefix = mo44317c();
        } else {
            prefix = C14210y.m45724a();
            System.arraycopy(this.f43109a, this.f43110b, prefix.f43109a, 0, byteCount);
        }
        prefix.f43111c = prefix.f43110b + byteCount;
        this.f43110b += byteCount;
        this.f43115g.mo44313a(prefix);
        return prefix;
    }

    /* renamed from: a */
    public void mo44314a() {
        C14209x xVar = this.f43115g;
        if (xVar == this) {
            throw new IllegalStateException();
        } else if (xVar.f43113e) {
            int byteCount = this.f43111c - this.f43110b;
            if (byteCount <= (8192 - xVar.f43111c) + (xVar.f43112d ? 0 : xVar.f43110b)) {
                mo44315a(this.f43115g, byteCount);
                mo44316b();
                C14210y.m45725a(this);
            }
        }
    }

    /* renamed from: a */
    public void mo44315a(C14209x sink, int byteCount) {
        if (sink.f43113e) {
            int i = sink.f43111c;
            if (i + byteCount > 8192) {
                if (!sink.f43112d) {
                    int i2 = i + byteCount;
                    int i3 = sink.f43110b;
                    if (i2 - i3 <= 8192) {
                        byte[] bArr = sink.f43109a;
                        System.arraycopy(bArr, i3, bArr, 0, i - i3);
                        sink.f43111c -= sink.f43110b;
                        sink.f43110b = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.f43109a, this.f43110b, sink.f43109a, sink.f43111c, byteCount);
            sink.f43111c += byteCount;
            this.f43110b += byteCount;
            return;
        }
        throw new IllegalArgumentException();
    }
}
