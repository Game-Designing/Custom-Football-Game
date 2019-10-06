package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.ads.Or */
final class C9051Or implements zzlx {

    /* renamed from: a */
    private int f21558a = -1;

    /* renamed from: b */
    private int f21559b = -1;

    /* renamed from: c */
    private int[] f21560c;

    /* renamed from: d */
    private boolean f21561d;

    /* renamed from: e */
    private int[] f21562e;

    /* renamed from: f */
    private ByteBuffer f21563f;

    /* renamed from: g */
    private ByteBuffer f21564g;

    /* renamed from: h */
    private boolean f21565h;

    public C9051Or() {
        ByteBuffer byteBuffer = zzlx.f28841a;
        this.f21563f = byteBuffer;
        this.f21564g = byteBuffer;
    }

    /* renamed from: a */
    public final void mo28501a(int[] iArr) {
        this.f21560c = iArr;
    }

    /* renamed from: a */
    public final boolean mo28503a(int i, int i2, int i3) throws zzly {
        boolean z = !Arrays.equals(this.f21560c, this.f21562e);
        this.f21562e = this.f21560c;
        if (this.f21562e == null) {
            this.f21561d = false;
            return z;
        } else if (i3 != 2) {
            throw new zzly(i, i2, i3);
        } else if (!z && this.f21559b == i && this.f21558a == i2) {
            return false;
        } else {
            this.f21559b = i;
            this.f21558a = i2;
            this.f21561d = i2 != this.f21562e.length;
            int i4 = 0;
            while (true) {
                int[] iArr = this.f21562e;
                if (i4 >= iArr.length) {
                    return true;
                }
                int i5 = iArr[i4];
                if (i5 < i2) {
                    this.f21561d = (i5 != i4) | this.f21561d;
                    i4++;
                } else {
                    throw new zzly(i, i2, i3);
                }
            }
        }
    }

    /* renamed from: a */
    public final boolean mo28502a() {
        return this.f21561d;
    }

    /* renamed from: e */
    public final int mo28507e() {
        int[] iArr = this.f21562e;
        return iArr == null ? this.f21558a : iArr.length;
    }

    /* renamed from: f */
    public final int mo28508f() {
        return 2;
    }

    /* renamed from: a */
    public final void mo28500a(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int length = (((limit - position) / (this.f21558a * 2)) * this.f21562e.length) << 1;
        if (this.f21563f.capacity() < length) {
            this.f21563f = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
        } else {
            this.f21563f.clear();
        }
        while (position < limit) {
            for (int i : this.f21562e) {
                this.f21563f.putShort(byteBuffer.getShort((i * 2) + position));
            }
            position += this.f21558a << 1;
        }
        byteBuffer.position(limit);
        this.f21563f.flip();
        this.f21564g = this.f21563f;
    }

    /* renamed from: c */
    public final void mo28505c() {
        this.f21565h = true;
    }

    /* renamed from: d */
    public final ByteBuffer mo28506d() {
        ByteBuffer byteBuffer = this.f21564g;
        this.f21564g = zzlx.f28841a;
        return byteBuffer;
    }

    /* renamed from: b */
    public final boolean mo28504b() {
        return this.f21565h && this.f21564g == zzlx.f28841a;
    }

    public final void flush() {
        this.f21564g = zzlx.f28841a;
        this.f21565h = false;
    }

    public final void reset() {
        flush();
        this.f21563f = zzlx.f28841a;
        this.f21558a = -1;
        this.f21559b = -1;
        this.f21562e = null;
        this.f21561d = false;
    }
}
