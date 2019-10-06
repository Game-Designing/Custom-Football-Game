package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: com.google.android.gms.internal.ads.Rr */
final class C9113Rr implements zzlx {

    /* renamed from: a */
    private int f21674a = -1;

    /* renamed from: b */
    private int f21675b = -1;

    /* renamed from: c */
    private int f21676c = 0;

    /* renamed from: d */
    private ByteBuffer f21677d;

    /* renamed from: e */
    private ByteBuffer f21678e;

    /* renamed from: f */
    private boolean f21679f;

    public C9113Rr() {
        ByteBuffer byteBuffer = zzlx.f28841a;
        this.f21677d = byteBuffer;
        this.f21678e = byteBuffer;
    }

    /* renamed from: a */
    public final boolean mo28503a(int i, int i2, int i3) throws zzly {
        if (i3 != 3 && i3 != 2 && i3 != Integer.MIN_VALUE && i3 != 1073741824) {
            throw new zzly(i, i2, i3);
        } else if (this.f21674a == i && this.f21675b == i2 && this.f21676c == i3) {
            return false;
        } else {
            this.f21674a = i;
            this.f21675b = i2;
            this.f21676c = i3;
            if (i3 == 2) {
                this.f21677d = zzlx.f28841a;
            }
            return true;
        }
    }

    /* renamed from: a */
    public final boolean mo28502a() {
        int i = this.f21676c;
        return (i == 0 || i == 2) ? false : true;
    }

    /* renamed from: e */
    public final int mo28507e() {
        return this.f21675b;
    }

    /* renamed from: f */
    public final int mo28508f() {
        return 2;
    }

    /* renamed from: a */
    public final void mo28500a(ByteBuffer byteBuffer) {
        int i;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i2 = limit - position;
        int i3 = this.f21676c;
        if (i3 == Integer.MIN_VALUE) {
            i = (i2 / 3) << 1;
        } else if (i3 == 3) {
            i = i2 << 1;
        } else if (i3 == 1073741824) {
            i = i2 / 2;
        } else {
            throw new IllegalStateException();
        }
        if (this.f21677d.capacity() < i) {
            this.f21677d = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
        } else {
            this.f21677d.clear();
        }
        int i4 = this.f21676c;
        if (i4 == Integer.MIN_VALUE) {
            while (position < limit) {
                this.f21677d.put(byteBuffer.get(position + 1));
                this.f21677d.put(byteBuffer.get(position + 2));
                position += 3;
            }
        } else if (i4 == 3) {
            while (position < limit) {
                this.f21677d.put(0);
                this.f21677d.put((byte) ((byteBuffer.get(position) & 255) - 128));
                position++;
            }
        } else if (i4 == 1073741824) {
            while (position < limit) {
                this.f21677d.put(byteBuffer.get(position + 2));
                this.f21677d.put(byteBuffer.get(position + 3));
                position += 4;
            }
        } else {
            throw new IllegalStateException();
        }
        byteBuffer.position(byteBuffer.limit());
        this.f21677d.flip();
        this.f21678e = this.f21677d;
    }

    /* renamed from: c */
    public final void mo28505c() {
        this.f21679f = true;
    }

    /* renamed from: d */
    public final ByteBuffer mo28506d() {
        ByteBuffer byteBuffer = this.f21678e;
        this.f21678e = zzlx.f28841a;
        return byteBuffer;
    }

    /* renamed from: b */
    public final boolean mo28504b() {
        return this.f21679f && this.f21678e == zzlx.f28841a;
    }

    public final void flush() {
        this.f21678e = zzlx.f28841a;
        this.f21679f = false;
    }

    public final void reset() {
        flush();
        this.f21677d = zzlx.f28841a;
        this.f21674a = -1;
        this.f21675b = -1;
        this.f21676c = 0;
    }
}
