package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

public final class zzmx implements zzlx {

    /* renamed from: a */
    private int f28916a = -1;

    /* renamed from: b */
    private int f28917b = -1;

    /* renamed from: c */
    private C9138Sr f28918c;

    /* renamed from: d */
    private float f28919d = 1.0f;

    /* renamed from: e */
    private float f28920e = 1.0f;

    /* renamed from: f */
    private ByteBuffer f28921f = zzlx.f28841a;

    /* renamed from: g */
    private ShortBuffer f28922g = this.f28921f.asShortBuffer();

    /* renamed from: h */
    private ByteBuffer f28923h = zzlx.f28841a;

    /* renamed from: i */
    private long f28924i;

    /* renamed from: j */
    private long f28925j;

    /* renamed from: k */
    private boolean f28926k;

    /* renamed from: a */
    public final float mo32008a(float f) {
        this.f28919d = zzsy.m31143a(f, 0.1f, 8.0f);
        return this.f28919d;
    }

    /* renamed from: b */
    public final float mo32009b(float f) {
        this.f28920e = zzsy.m31143a(f, 0.1f, 8.0f);
        return f;
    }

    /* renamed from: g */
    public final long mo32010g() {
        return this.f28924i;
    }

    /* renamed from: h */
    public final long mo32011h() {
        return this.f28925j;
    }

    /* renamed from: a */
    public final boolean mo28503a(int i, int i2, int i3) throws zzly {
        if (i3 != 2) {
            throw new zzly(i, i2, i3);
        } else if (this.f28917b == i && this.f28916a == i2) {
            return false;
        } else {
            this.f28917b = i;
            this.f28916a = i2;
            return true;
        }
    }

    /* renamed from: a */
    public final boolean mo28502a() {
        return Math.abs(this.f28919d - 1.0f) >= 0.01f || Math.abs(this.f28920e - 1.0f) >= 0.01f;
    }

    /* renamed from: e */
    public final int mo28507e() {
        return this.f28916a;
    }

    /* renamed from: f */
    public final int mo28508f() {
        return 2;
    }

    /* renamed from: a */
    public final void mo28500a(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.f28924i += (long) remaining;
            this.f28918c.mo28608a(asShortBuffer);
            byteBuffer.position(byteBuffer.position() + remaining);
        }
        int b = (this.f28918c.mo28609b() * this.f28916a) << 1;
        if (b > 0) {
            if (this.f28921f.capacity() < b) {
                this.f28921f = ByteBuffer.allocateDirect(b).order(ByteOrder.nativeOrder());
                this.f28922g = this.f28921f.asShortBuffer();
            } else {
                this.f28921f.clear();
                this.f28922g.clear();
            }
            this.f28918c.mo28611b(this.f28922g);
            this.f28925j += (long) b;
            this.f28921f.limit(b);
            this.f28923h = this.f28921f;
        }
    }

    /* renamed from: c */
    public final void mo28505c() {
        this.f28918c.mo28606a();
        this.f28926k = true;
    }

    /* renamed from: d */
    public final ByteBuffer mo28506d() {
        ByteBuffer byteBuffer = this.f28923h;
        this.f28923h = zzlx.f28841a;
        return byteBuffer;
    }

    /* renamed from: b */
    public final boolean mo28504b() {
        if (this.f28926k) {
            C9138Sr sr = this.f28918c;
            if (sr == null || sr.mo28609b() == 0) {
                return true;
            }
        }
        return false;
    }

    public final void flush() {
        this.f28918c = new C9138Sr(this.f28917b, this.f28916a);
        this.f28918c.mo28607a(this.f28919d);
        this.f28918c.mo28610b(this.f28920e);
        this.f28923h = zzlx.f28841a;
        this.f28924i = 0;
        this.f28925j = 0;
        this.f28926k = false;
    }

    public final void reset() {
        this.f28918c = null;
        this.f28921f = zzlx.f28841a;
        this.f28922g = this.f28921f.asShortBuffer();
        this.f28923h = zzlx.f28841a;
        this.f28916a = -1;
        this.f28917b = -1;
        this.f28924i = 0;
        this.f28925j = 0;
        this.f28926k = false;
    }
}
