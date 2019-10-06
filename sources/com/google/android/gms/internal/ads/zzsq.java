package com.google.android.gms.internal.ads;

import android.util.Log;
import java.nio.ByteBuffer;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

public final class zzsq {

    /* renamed from: a */
    public static final byte[] f29316a = {0, 0, 0, 1};

    /* renamed from: b */
    private static final float[] f29317b = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};

    /* renamed from: c */
    private static final Object f29318c = new Object();

    /* renamed from: d */
    private static int[] f29319d = new int[10];

    /* renamed from: a */
    public static void m31101a(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i + 1;
            if (i3 < position) {
                byte b = byteBuffer.get(i) & 255;
                if (i2 == 3) {
                    if (b == 1 && (byteBuffer.get(i3) & 31) == 7) {
                        ByteBuffer duplicate = byteBuffer.duplicate();
                        duplicate.position(i - 3);
                        duplicate.limit(position);
                        byteBuffer.position(0);
                        byteBuffer.put(duplicate);
                        return;
                    }
                } else if (b == 0) {
                    i2++;
                }
                if (b != 0) {
                    i2 = 0;
                }
                i = i3;
            } else {
                byteBuffer.clear();
                return;
            }
        }
    }

    /* renamed from: a */
    public static zzsr m31100a(byte[] bArr, int i, int i2) {
        boolean z;
        int i3;
        boolean z2;
        int i4;
        int i5;
        int i6;
        float f;
        int i7;
        int i8;
        boolean z3;
        zzsu zzsu = new zzsu(bArr, i, i2);
        zzsu.mo32220b(8);
        int a = zzsu.mo32217a(8);
        zzsu.mo32220b(16);
        int b = zzsu.mo32219b();
        int i9 = 1;
        if (a == 100 || a == 110 || a == 122 || a == 244 || a == 44 || a == 83 || a == 86 || a == 118 || a == 128 || a == 138) {
            i3 = zzsu.mo32219b();
            if (i3 == 3) {
                z3 = zzsu.mo32218a();
            } else {
                z3 = false;
            }
            zzsu.mo32219b();
            zzsu.mo32219b();
            zzsu.mo32220b(1);
            if (zzsu.mo32218a()) {
                int i10 = i3 != 3 ? 8 : 12;
                int i11 = 0;
                while (i11 < i10) {
                    if (zzsu.mo32218a()) {
                        int i12 = i11 < 6 ? 16 : 64;
                        int i13 = 8;
                        int i14 = 8;
                        for (int i15 = 0; i15 < i12; i15++) {
                            if (i13 != 0) {
                                i13 = ((zzsu.mo32221c() + i14) + Opcodes.ACC_NATIVE) % Opcodes.ACC_NATIVE;
                            }
                            if (i13 != 0) {
                                i14 = i13;
                            }
                        }
                    }
                    i11++;
                }
            }
            z = z3;
        } else {
            i3 = 1;
            z = false;
        }
        int b2 = zzsu.mo32219b() + 4;
        int b3 = zzsu.mo32219b();
        if (b3 == 0) {
            i4 = zzsu.mo32219b() + 4;
            z2 = false;
        } else if (b3 == 1) {
            boolean a2 = zzsu.mo32218a();
            zzsu.mo32221c();
            zzsu.mo32221c();
            long b4 = (long) zzsu.mo32219b();
            for (int i16 = 0; ((long) i16) < b4; i16++) {
                zzsu.mo32219b();
            }
            z2 = a2;
            i4 = 0;
        } else {
            i4 = 0;
            z2 = false;
        }
        zzsu.mo32219b();
        zzsu.mo32220b(1);
        int b5 = zzsu.mo32219b() + 1;
        int b6 = zzsu.mo32219b() + 1;
        boolean a3 = zzsu.mo32218a();
        int i17 = (true - (a3 ? 1 : 0)) * b6;
        if (!a3) {
            zzsu.mo32220b(1);
        }
        zzsu.mo32220b(1);
        int i18 = b5 << 4;
        int i19 = i17 << 4;
        if (zzsu.mo32218a()) {
            int b7 = zzsu.mo32219b();
            int b8 = zzsu.mo32219b();
            int b9 = zzsu.mo32219b();
            int b10 = zzsu.mo32219b();
            if (i3 == 0) {
                i7 = true - a3;
                i8 = 1;
            } else {
                i8 = i3 == 3 ? 1 : 2;
                if (i3 == 1) {
                    i9 = 2;
                }
                i7 = (true - a3) * i9;
            }
            i6 = i18 - ((b7 + b8) * i8);
            i5 = i19 - ((b9 + b10) * i7);
        } else {
            i6 = i18;
            i5 = i19;
        }
        float f2 = 1.0f;
        if (zzsu.mo32218a() && zzsu.mo32218a()) {
            int a4 = zzsu.mo32217a(8);
            if (a4 == 255) {
                int a5 = zzsu.mo32217a(16);
                int a6 = zzsu.mo32217a(16);
                if (!(a5 == 0 || a6 == 0)) {
                    f2 = ((float) a5) / ((float) a6);
                }
                f = f2;
            } else {
                float[] fArr = f29317b;
                if (a4 < fArr.length) {
                    f = fArr[a4];
                } else {
                    StringBuilder sb = new StringBuilder(46);
                    sb.append("Unexpected aspect_ratio_idc value: ");
                    sb.append(a4);
                    Log.w("NalUnitUtil", sb.toString());
                }
            }
            zzsr zzsr = new zzsr(b, i6, i5, f, z, a3, b2, b3, i4, z2);
            return zzsr;
        }
        f = 1.0f;
        zzsr zzsr2 = new zzsr(b, i6, i5, f, z, a3, b2, b3, i4, z2);
        return zzsr2;
    }
}
