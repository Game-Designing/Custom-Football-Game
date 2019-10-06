package com.google.android.gms.internal.ads;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.io.IOException;
import java.util.Arrays;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.data.ExecutionDataWriter;

/* renamed from: com.google.android.gms.internal.ads.Co */
final class C8796Co extends zzdnd {

    /* renamed from: f */
    private final byte[] f20562f;

    /* renamed from: g */
    private final boolean f20563g;

    /* renamed from: h */
    private int f20564h;

    /* renamed from: i */
    private int f20565i;

    /* renamed from: j */
    private int f20566j;

    /* renamed from: k */
    private int f20567k;

    /* renamed from: l */
    private int f20568l;

    /* renamed from: m */
    private int f20569m;

    private C8796Co(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.f20569m = MoPubClientPositioning.NO_REPEAT;
        this.f20562f = bArr;
        this.f20564h = i2 + i;
        this.f20566j = i;
        this.f20567k = this.f20566j;
        this.f20563g = z;
    }

    /* renamed from: d */
    public final int mo28086d() throws IOException {
        if (mo28102s()) {
            this.f20568l = 0;
            return 0;
        }
        this.f20568l = m22342v();
        int i = this.f20568l;
        if ((i >>> 3) != 0) {
            return i;
        }
        throw zzdok.m29931d();
    }

    /* renamed from: a */
    public final void mo28081a(int i) throws zzdok {
        if (this.f20568l != i) {
            throw zzdok.m29932e();
        }
    }

    /* renamed from: b */
    public final boolean mo28083b(int i) throws IOException {
        int d;
        int i2 = i & 7;
        int i3 = 0;
        if (i2 == 0) {
            if (this.f20564h - this.f20566j >= 10) {
                while (i3 < 10) {
                    byte[] bArr = this.f20562f;
                    int i4 = this.f20566j;
                    this.f20566j = i4 + 1;
                    if (bArr[i4] < 0) {
                        i3++;
                    }
                }
                throw zzdok.m29930c();
            }
            while (i3 < 10) {
                if (m22340A() < 0) {
                    i3++;
                }
            }
            throw zzdok.m29930c();
            return true;
        } else if (i2 == 1) {
            m22341f(8);
            return true;
        } else if (i2 == 2) {
            m22341f(m22342v());
            return true;
        } else if (i2 == 3) {
            do {
                d = mo28086d();
                if (d == 0) {
                    break;
                }
            } while (mo28083b(d));
            mo28081a(((i >>> 3) << 3) | 4);
            return true;
        } else if (i2 == 4) {
            return false;
        } else {
            if (i2 == 5) {
                m22341f(4);
                return true;
            }
            throw zzdok.m29933f();
        }
    }

    /* renamed from: a */
    public final double mo28080a() throws IOException {
        return Double.longBitsToDouble(m22345y());
    }

    /* renamed from: b */
    public final float mo28082b() throws IOException {
        return Float.intBitsToFloat(m22344x());
    }

    /* renamed from: e */
    public final long mo28088e() throws IOException {
        return m22343w();
    }

    /* renamed from: f */
    public final long mo28089f() throws IOException {
        return m22343w();
    }

    /* renamed from: g */
    public final int mo28090g() throws IOException {
        return m22342v();
    }

    /* renamed from: h */
    public final long mo28091h() throws IOException {
        return m22345y();
    }

    /* renamed from: i */
    public final int mo28092i() throws IOException {
        return m22344x();
    }

    /* renamed from: j */
    public final boolean mo28093j() throws IOException {
        return m22343w() != 0;
    }

    /* renamed from: c */
    public final String mo28085c() throws IOException {
        int v = m22342v();
        if (v > 0) {
            int i = this.f20564h;
            int i2 = this.f20566j;
            if (v <= i - i2) {
                String str = new String(this.f20562f, i2, v, zzdod.f28084a);
                this.f20566j += v;
                return str;
            }
        }
        if (v == 0) {
            return "";
        }
        if (v < 0) {
            throw zzdok.m29929b();
        }
        throw zzdok.m29928a();
    }

    /* renamed from: k */
    public final String mo28094k() throws IOException {
        int v = m22342v();
        if (v > 0) {
            int i = this.f20564h;
            int i2 = this.f20566j;
            if (v <= i - i2) {
                String b = C9199Vp.m23155b(this.f20562f, i2, v);
                this.f20566j += v;
                return b;
            }
        }
        if (v == 0) {
            return "";
        }
        if (v <= 0) {
            throw zzdok.m29929b();
        }
        throw zzdok.m29928a();
    }

    /* renamed from: l */
    public final zzdmr mo28095l() throws IOException {
        byte[] bArr;
        int v = m22342v();
        if (v > 0) {
            int i = this.f20564h;
            int i2 = this.f20566j;
            if (v <= i - i2) {
                zzdmr a = zzdmr.m29653a(this.f20562f, i2, v);
                this.f20566j += v;
                return a;
            }
        }
        if (v == 0) {
            return zzdmr.f27972a;
        }
        if (v > 0) {
            int i3 = this.f20564h;
            int i4 = this.f20566j;
            if (v <= i3 - i4) {
                this.f20566j = v + i4;
                bArr = Arrays.copyOfRange(this.f20562f, i4, this.f20566j);
                return zzdmr.m29652a(bArr);
            }
        }
        if (v > 0) {
            throw zzdok.m29928a();
        } else if (v == 0) {
            bArr = zzdod.f28086c;
            return zzdmr.m29652a(bArr);
        } else {
            throw zzdok.m29929b();
        }
    }

    /* renamed from: m */
    public final int mo28096m() throws IOException {
        return m22342v();
    }

    /* renamed from: n */
    public final int mo28097n() throws IOException {
        return m22342v();
    }

    /* renamed from: o */
    public final int mo28098o() throws IOException {
        return m22344x();
    }

    /* renamed from: p */
    public final long mo28099p() throws IOException {
        return m22345y();
    }

    /* renamed from: q */
    public final int mo28100q() throws IOException {
        return zzdnd.m29672e(m22342v());
    }

    /* renamed from: r */
    public final long mo28101r() throws IOException {
        return zzdnd.m29670a(m22343w());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0066, code lost:
        if (r2[r3] >= 0) goto L_0x006a;
     */
    /* renamed from: v */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int m22342v() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.f20566j
            int r1 = r5.f20564h
            if (r1 == r0) goto L_0x006d
            byte[] r2 = r5.f20562f
            int r3 = r0 + 1
            byte r0 = r2[r0]
            if (r0 < 0) goto L_0x0011
            r5.f20566j = r3
            return r0
        L_0x0011:
            int r1 = r1 - r3
            r4 = 9
            if (r1 < r4) goto L_0x006d
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x0022
            r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
            goto L_0x006a
        L_0x0022:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L_0x002f
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            r1 = r3
            goto L_0x006a
        L_0x002f:
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x003d
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L_0x006a
        L_0x003d:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r4 = r1 << 28
            r0 = r0 ^ r4
            r4 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r4
            if (r1 >= 0) goto L_0x0069
            int r1 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x006a
            int r3 = r1 + 1
            byte r1 = r2[r1]
            if (r1 >= 0) goto L_0x0069
            int r1 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x006a
            int r3 = r1 + 1
            byte r1 = r2[r1]
            if (r1 >= 0) goto L_0x0069
            int r1 = r3 + 1
            byte r2 = r2[r3]
            if (r2 < 0) goto L_0x006d
            goto L_0x006a
        L_0x0069:
            r1 = r3
        L_0x006a:
            r5.f20566j = r1
            return r0
        L_0x006d:
            long r0 = r5.mo28104u()
            int r1 = (int) r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.C8796Co.m22342v():int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b7, code lost:
        if (((long) r2[r0]) >= 0) goto L_0x00bb;
     */
    /* renamed from: w */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final long m22343w() throws java.io.IOException {
        /*
            r11 = this;
            int r0 = r11.f20566j
            int r1 = r11.f20564h
            if (r1 == r0) goto L_0x00be
            byte[] r2 = r11.f20562f
            int r3 = r0 + 1
            byte r0 = r2[r0]
            if (r0 < 0) goto L_0x0012
            r11.f20566j = r3
            long r0 = (long) r0
            return r0
        L_0x0012:
            int r1 = r1 - r3
            r4 = 9
            if (r1 < r4) goto L_0x00be
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x0026
            r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
            long r2 = (long) r0
            r3 = r2
            goto L_0x00bb
        L_0x0026:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L_0x0037
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            long r0 = (long) r0
            r9 = r0
            r1 = r3
            r3 = r9
            goto L_0x00bb
        L_0x0037:
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x0048
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            long r2 = (long) r0
            r3 = r2
            goto L_0x00bb
        L_0x0048:
            long r3 = (long) r0
            int r0 = r1 + 1
            byte r1 = r2[r1]
            long r5 = (long) r1
            r1 = 28
            long r5 = r5 << r1
            long r3 = r3 ^ r5
            r5 = 0
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 < 0) goto L_0x005f
            r1 = 266354560(0xfe03f80, double:1.315966377E-315)
            long r1 = r1 ^ r3
            r3 = r1
            r1 = r0
            goto L_0x00bb
        L_0x005f:
            int r1 = r0 + 1
            byte r0 = r2[r0]
            long r7 = (long) r0
            r0 = 35
            long r7 = r7 << r0
            long r3 = r3 ^ r7
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x0073
            r5 = -34093383808(0xfffffff80fe03f80, double:NaN)
            long r3 = r3 ^ r5
            goto L_0x00bb
        L_0x0073:
            int r0 = r1 + 1
            byte r1 = r2[r1]
            long r7 = (long) r1
            r1 = 42
            long r7 = r7 << r1
            long r3 = r3 ^ r7
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 < 0) goto L_0x0089
            r1 = 4363953127296(0x3f80fe03f80, double:2.1560793202584E-311)
            long r1 = r1 ^ r3
            r3 = r1
            r1 = r0
            goto L_0x00bb
        L_0x0089:
            int r1 = r0 + 1
            byte r0 = r2[r0]
            long r7 = (long) r0
            r0 = 49
            long r7 = r7 << r0
            long r3 = r3 ^ r7
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x009d
            r5 = -558586000294016(0xfffe03f80fe03f80, double:NaN)
            long r3 = r3 ^ r5
            goto L_0x00bb
        L_0x009d:
            int r0 = r1 + 1
            byte r1 = r2[r1]
            long r7 = (long) r1
            r1 = 56
            long r7 = r7 << r1
            long r3 = r3 ^ r7
            r7 = 71499008037633920(0xfe03f80fe03f80, double:6.838959413692434E-304)
            long r3 = r3 ^ r7
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 >= 0) goto L_0x00ba
            int r1 = r0 + 1
            byte r0 = r2[r0]
            long r7 = (long) r0
            int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r0 < 0) goto L_0x00be
            goto L_0x00bb
        L_0x00ba:
            r1 = r0
        L_0x00bb:
            r11.f20566j = r1
            return r3
        L_0x00be:
            long r0 = r11.mo28104u()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.C8796Co.m22343w():long");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: u */
    public final long mo28104u() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte A = m22340A();
            j |= ((long) (A & Byte.MAX_VALUE)) << i;
            if ((A & 128) == 0) {
                return j;
            }
        }
        throw zzdok.m29930c();
    }

    /* renamed from: x */
    private final int m22344x() throws IOException {
        int i = this.f20566j;
        if (this.f20564h - i >= 4) {
            byte[] bArr = this.f20562f;
            this.f20566j = i + 4;
            return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << ExecutionDataWriter.BLOCK_SESSIONINFO);
        }
        throw zzdok.m29928a();
    }

    /* renamed from: y */
    private final long m22345y() throws IOException {
        int i = this.f20566j;
        if (this.f20564h - i >= 8) {
            byte[] bArr = this.f20562f;
            this.f20566j = i + 8;
            return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
        }
        throw zzdok.m29928a();
    }

    /* renamed from: c */
    public final int mo28084c(int i) throws zzdok {
        if (i >= 0) {
            int t = i + mo28103t();
            int i2 = this.f20569m;
            if (t <= i2) {
                this.f20569m = t;
                m22346z();
                return i2;
            }
            throw zzdok.m29928a();
        }
        throw zzdok.m29929b();
    }

    /* renamed from: z */
    private final void m22346z() {
        this.f20564h += this.f20565i;
        int i = this.f20564h;
        int i2 = i - this.f20567k;
        int i3 = this.f20569m;
        if (i2 > i3) {
            this.f20565i = i2 - i3;
            this.f20564h = i - this.f20565i;
            return;
        }
        this.f20565i = 0;
    }

    /* renamed from: d */
    public final void mo28087d(int i) {
        this.f20569m = i;
        m22346z();
    }

    /* renamed from: s */
    public final boolean mo28102s() throws IOException {
        return this.f20566j == this.f20564h;
    }

    /* renamed from: t */
    public final int mo28103t() {
        return this.f20566j - this.f20567k;
    }

    /* renamed from: A */
    private final byte m22340A() throws IOException {
        int i = this.f20566j;
        if (i != this.f20564h) {
            byte[] bArr = this.f20562f;
            this.f20566j = i + 1;
            return bArr[i];
        }
        throw zzdok.m29928a();
    }

    /* renamed from: f */
    private final void m22341f(int i) throws IOException {
        if (i >= 0) {
            int i2 = this.f20564h;
            int i3 = this.f20566j;
            if (i <= i2 - i3) {
                this.f20566j = i3 + i;
                return;
            }
        }
        if (i < 0) {
            throw zzdok.m29929b();
        }
        throw zzdok.m29928a();
    }
}
