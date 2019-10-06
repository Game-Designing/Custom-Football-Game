package com.google.android.gms.internal.ads;

import java.nio.ShortBuffer;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.ads.Sr */
final class C9138Sr {

    /* renamed from: a */
    private final int f21737a;

    /* renamed from: b */
    private final int f21738b;

    /* renamed from: c */
    private final int f21739c;

    /* renamed from: d */
    private final int f21740d;

    /* renamed from: e */
    private final int f21741e = (this.f21740d * 2);

    /* renamed from: f */
    private final short[] f21742f;

    /* renamed from: g */
    private int f21743g;

    /* renamed from: h */
    private short[] f21744h;

    /* renamed from: i */
    private int f21745i;

    /* renamed from: j */
    private short[] f21746j;

    /* renamed from: k */
    private int f21747k;

    /* renamed from: l */
    private short[] f21748l;

    /* renamed from: m */
    private int f21749m;

    /* renamed from: n */
    private int f21750n;

    /* renamed from: o */
    private float f21751o;

    /* renamed from: p */
    private float f21752p;

    /* renamed from: q */
    private int f21753q;

    /* renamed from: r */
    private int f21754r;

    /* renamed from: s */
    private int f21755s;

    /* renamed from: t */
    private int f21756t;

    /* renamed from: u */
    private int f21757u;

    /* renamed from: v */
    private int f21758v;

    /* renamed from: w */
    private int f21759w;

    /* renamed from: x */
    private int f21760x;

    public C9138Sr(int i, int i2) {
        this.f21737a = i;
        this.f21738b = i2;
        this.f21739c = i / 400;
        this.f21740d = i / 65;
        int i3 = this.f21741e;
        this.f21742f = new short[i3];
        this.f21743g = i3;
        this.f21744h = new short[(i3 * i2)];
        this.f21745i = i3;
        this.f21746j = new short[(i3 * i2)];
        this.f21747k = i3;
        this.f21748l = new short[(i3 * i2)];
        this.f21749m = 0;
        this.f21750n = 0;
        this.f21757u = 0;
        this.f21751o = 1.0f;
        this.f21752p = 1.0f;
    }

    /* renamed from: a */
    public final void mo28607a(float f) {
        this.f21751o = f;
    }

    /* renamed from: b */
    public final void mo28610b(float f) {
        this.f21752p = f;
    }

    /* renamed from: a */
    public final void mo28608a(ShortBuffer shortBuffer) {
        int remaining = shortBuffer.remaining();
        int i = this.f21738b;
        int i2 = remaining / i;
        int i3 = (i * i2) << 1;
        m23073b(i2);
        shortBuffer.get(this.f21744h, this.f21753q * this.f21738b, i3 / 2);
        this.f21753q += i2;
        m23075c();
    }

    /* renamed from: b */
    public final void mo28611b(ShortBuffer shortBuffer) {
        int min = Math.min(shortBuffer.remaining() / this.f21738b, this.f21754r);
        shortBuffer.put(this.f21746j, 0, this.f21738b * min);
        this.f21754r -= min;
        short[] sArr = this.f21746j;
        int i = this.f21738b;
        System.arraycopy(sArr, min * i, sArr, 0, this.f21754r * i);
    }

    /* renamed from: a */
    public final void mo28606a() {
        int i;
        int i2 = this.f21753q;
        float f = this.f21751o;
        float f2 = this.f21752p;
        int i3 = this.f21754r + ((int) ((((((float) i2) / (f / f2)) + ((float) this.f21755s)) / f2) + 0.5f));
        m23073b((this.f21741e * 2) + i2);
        int i4 = 0;
        while (true) {
            i = this.f21741e;
            int i5 = i * 2;
            int i6 = this.f21738b;
            if (i4 >= i5 * i6) {
                break;
            }
            this.f21744h[(i6 * i2) + i4] = 0;
            i4++;
        }
        this.f21753q += i * 2;
        m23075c();
        if (this.f21754r > i3) {
            this.f21754r = i3;
        }
        this.f21753q = 0;
        this.f21756t = 0;
        this.f21755s = 0;
    }

    /* renamed from: b */
    public final int mo28609b() {
        return this.f21754r;
    }

    /* renamed from: a */
    private final void m23070a(int i) {
        int i2 = this.f21754r + i;
        int i3 = this.f21745i;
        if (i2 > i3) {
            this.f21745i = i3 + (i3 / 2) + i;
            this.f21746j = Arrays.copyOf(this.f21746j, this.f21745i * this.f21738b);
        }
    }

    /* renamed from: b */
    private final void m23073b(int i) {
        int i2 = this.f21753q + i;
        int i3 = this.f21743g;
        if (i2 > i3) {
            this.f21743g = i3 + (i3 / 2) + i;
            this.f21744h = Arrays.copyOf(this.f21744h, this.f21743g * this.f21738b);
        }
    }

    /* renamed from: a */
    private final void m23072a(short[] sArr, int i, int i2) {
        m23070a(i2);
        int i3 = this.f21738b;
        System.arraycopy(sArr, i * i3, this.f21746j, this.f21754r * i3, i3 * i2);
        this.f21754r += i2;
    }

    /* renamed from: b */
    private final void m23074b(short[] sArr, int i, int i2) {
        int i3 = this.f21741e / i2;
        int i4 = this.f21738b;
        int i5 = i2 * i4;
        int i6 = i * i4;
        for (int i7 = 0; i7 < i3; i7++) {
            int i8 = 0;
            for (int i9 = 0; i9 < i5; i9++) {
                i8 += sArr[(i7 * i5) + i6 + i9];
            }
            this.f21742f[i7] = (short) (i8 / i5);
        }
    }

    /* renamed from: a */
    private final int m23069a(short[] sArr, int i, int i2, int i3) {
        int i4 = i * this.f21738b;
        int i5 = 1;
        int i6 = 0;
        int i7 = 0;
        int i8 = 255;
        while (i2 <= i3) {
            int i9 = 0;
            for (int i10 = 0; i10 < i2; i10++) {
                short s = sArr[i4 + i10];
                short s2 = sArr[i4 + i2 + i10];
                i9 += s >= s2 ? s - s2 : s2 - s;
            }
            if (i9 * i6 < i5 * i2) {
                i6 = i2;
                i5 = i9;
            }
            if (i9 * i8 > i7 * i2) {
                i8 = i2;
                i7 = i9;
            }
            i2++;
        }
        this.f21759w = i5 / i6;
        this.f21760x = i7 / i8;
        return i6;
    }

    /* renamed from: c */
    private final void m23075c() {
        int i;
        int i2;
        int i3;
        int i4;
        boolean z;
        int i5;
        int i6;
        int i7;
        int i8 = this.f21754r;
        float f = this.f21751o / this.f21752p;
        double d = (double) f;
        int i9 = 1;
        if (d > 1.00001d || d < 0.99999d) {
            int i10 = this.f21753q;
            if (i10 >= this.f21741e) {
                int i11 = 0;
                while (true) {
                    int i12 = this.f21756t;
                    if (i12 > 0) {
                        int min = Math.min(this.f21741e, i12);
                        m23072a(this.f21744h, i11, min);
                        this.f21756t -= min;
                        i11 += min;
                    } else {
                        short[] sArr = this.f21744h;
                        int i13 = this.f21737a;
                        int i14 = i13 > 4000 ? i13 / 4000 : 1;
                        if (this.f21738b == i9 && i14 == i9) {
                            i4 = m23069a(sArr, i11, this.f21739c, this.f21740d);
                        } else {
                            m23074b(sArr, i11, i14);
                            int a = m23069a(this.f21742f, 0, this.f21739c / i14, this.f21740d / i14);
                            if (i14 != i9) {
                                int i15 = a * i14;
                                int i16 = i14 << 2;
                                int i17 = i15 - i16;
                                int i18 = i15 + i16;
                                int i19 = this.f21739c;
                                if (i17 >= i19) {
                                    i19 = i17;
                                }
                                int i20 = this.f21740d;
                                if (i18 > i20) {
                                    i18 = i20;
                                }
                                if (this.f21738b == i9) {
                                    i4 = m23069a(sArr, i11, i19, i18);
                                } else {
                                    m23074b(sArr, i11, i9);
                                    i4 = m23069a(this.f21742f, 0, i19, i18);
                                }
                            } else {
                                i4 = a;
                            }
                        }
                        int i21 = this.f21759w;
                        int i22 = this.f21760x;
                        if (i21 == 0 || this.f21757u == 0) {
                            z = false;
                        } else if (i22 > i21 * 3) {
                            z = false;
                        } else if ((i21 << 1) <= this.f21758v * 3) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (z) {
                            i5 = this.f21757u;
                        } else {
                            i5 = i4;
                        }
                        this.f21758v = this.f21759w;
                        this.f21757u = i4;
                        if (d > 1.0d) {
                            short[] sArr2 = this.f21744h;
                            if (f >= 2.0f) {
                                i7 = (int) (((float) i5) / (f - 1.0f));
                            } else {
                                this.f21756t = (int) ((((float) i5) * (2.0f - f)) / (f - 1.0f));
                                i7 = i5;
                            }
                            m23070a(i7);
                            int i23 = i7;
                            int i24 = i5;
                            m23071a(i7, this.f21738b, this.f21746j, this.f21754r, sArr2, i11, sArr2, i11 + i5);
                            this.f21754r += i23;
                            i11 += i24 + i23;
                        } else {
                            int i25 = i5;
                            short[] sArr3 = this.f21744h;
                            if (f < 0.5f) {
                                i6 = (int) ((((float) i25) * f) / (1.0f - f));
                            } else {
                                this.f21756t = (int) ((((float) i25) * ((2.0f * f) - 1.0f)) / (1.0f - f));
                                i6 = i25;
                            }
                            int i26 = i25 + i6;
                            m23070a(i26);
                            int i27 = this.f21738b;
                            System.arraycopy(sArr3, i11 * i27, this.f21746j, this.f21754r * i27, i27 * i25);
                            int i28 = i26;
                            m23071a(i6, this.f21738b, this.f21746j, this.f21754r + i25, sArr3, i25 + i11, sArr3, i11);
                            this.f21754r += i28;
                            i11 += i6;
                        }
                    }
                    if (this.f21741e + i11 > i10) {
                        break;
                    }
                    i9 = 1;
                }
                int i29 = this.f21753q - i11;
                short[] sArr4 = this.f21744h;
                int i30 = this.f21738b;
                System.arraycopy(sArr4, i11 * i30, sArr4, 0, i30 * i29);
                this.f21753q = i29;
            }
        } else {
            m23072a(this.f21744h, 0, this.f21753q);
            this.f21753q = 0;
        }
        float f2 = this.f21752p;
        if (f2 != 1.0f && this.f21754r != i8) {
            int i31 = this.f21737a;
            int i32 = (int) (((float) i31) / f2);
            while (true) {
                if (i32 <= 16384 && i31 <= 16384) {
                    break;
                }
                i32 /= 2;
                i31 /= 2;
            }
            int i33 = this.f21754r - i8;
            int i34 = this.f21755s + i33;
            int i35 = this.f21747k;
            if (i34 > i35) {
                this.f21747k = i35 + (i35 / 2) + i33;
                this.f21748l = Arrays.copyOf(this.f21748l, this.f21747k * this.f21738b);
            }
            short[] sArr5 = this.f21746j;
            int i36 = this.f21738b;
            System.arraycopy(sArr5, i8 * i36, this.f21748l, this.f21755s * i36, i36 * i33);
            this.f21754r = i8;
            this.f21755s += i33;
            int i37 = 0;
            while (true) {
                i = this.f21755s;
                if (i37 >= i - 1) {
                    break;
                }
                while (true) {
                    i2 = this.f21749m;
                    int i38 = (i2 + 1) * i32;
                    i3 = this.f21750n;
                    if (i38 <= i3 * i31) {
                        break;
                    }
                    m23070a(1);
                    int i39 = 0;
                    while (true) {
                        int i40 = this.f21738b;
                        if (i39 >= i40) {
                            break;
                        }
                        short[] sArr6 = this.f21746j;
                        int i41 = (this.f21754r * i40) + i39;
                        short[] sArr7 = this.f21748l;
                        int i42 = (i37 * i40) + i39;
                        short s = sArr7[i42];
                        short s2 = sArr7[i42 + i40];
                        int i43 = this.f21750n * i31;
                        int i44 = this.f21749m;
                        int i45 = i44 * i32;
                        int i46 = (i44 + 1) * i32;
                        int i47 = i46 - i43;
                        int i48 = i46 - i45;
                        sArr6[i41] = (short) (((s * i47) + ((i48 - i47) * s2)) / i48);
                        i39++;
                    }
                    this.f21750n++;
                    this.f21754r++;
                }
                this.f21749m = i2 + 1;
                if (this.f21749m == i31) {
                    this.f21749m = 0;
                    zzsk.m31082b(i3 == i32);
                    this.f21750n = 0;
                }
                i37++;
            }
            int i49 = i - 1;
            if (i49 != 0) {
                short[] sArr8 = this.f21748l;
                int i50 = this.f21738b;
                System.arraycopy(sArr8, i49 * i50, sArr8, 0, (i - i49) * i50);
                this.f21755s -= i49;
            }
        }
    }

    /* renamed from: a */
    private static void m23071a(int i, int i2, short[] sArr, int i3, short[] sArr2, int i4, short[] sArr3, int i5) {
        for (int i6 = 0; i6 < i2; i6++) {
            int i7 = (i4 * i2) + i6;
            int i8 = (i5 * i2) + i6;
            int i9 = (i3 * i2) + i6;
            for (int i10 = 0; i10 < i; i10++) {
                sArr[i9] = (short) (((sArr2[i7] * (i - i10)) + (sArr3[i8] * i10)) / i);
                i9 += i2;
                i7 += i2;
                i8 += i2;
            }
        }
    }
}
