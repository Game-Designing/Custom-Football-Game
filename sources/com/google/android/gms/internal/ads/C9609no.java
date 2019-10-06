package com.google.android.gms.internal.ads;

import java.io.IOException;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.data.ExecutionDataWriter;

/* renamed from: com.google.android.gms.internal.ads.no */
final class C9609no {
    /* renamed from: a */
    static int m23962a(byte[] bArr, int i, C9631oo ooVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return m23957a((int) b, bArr, i2, ooVar);
        }
        ooVar.f22846a = b;
        return i2;
    }

    /* renamed from: a */
    static int m23957a(int i, byte[] bArr, int i2, C9631oo ooVar) {
        int i3 = i & Opcodes.LAND;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            ooVar.f22846a = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & Byte.MAX_VALUE) << 7);
        int i6 = i4 + 1;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            ooVar.f22846a = i5 | (b2 << 14);
            return i6;
        }
        int i7 = i5 | ((b2 & Byte.MAX_VALUE) << 14);
        int i8 = i6 + 1;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            ooVar.f22846a = i7 | (b3 << 21);
            return i8;
        }
        int i9 = i7 | ((b3 & Byte.MAX_VALUE) << 21);
        int i10 = i8 + 1;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            ooVar.f22846a = i9 | (b4 << 28);
            return i10;
        }
        int i11 = i9 | ((b4 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                ooVar.f22846a = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    /* renamed from: b */
    static int m23964b(byte[] bArr, int i, C9631oo ooVar) {
        int i2 = i + 1;
        long j = (long) bArr[i];
        if (j >= 0) {
            ooVar.f22847b = j;
            return i2;
        }
        long j2 = j & 127;
        int i3 = i2 + 1;
        byte b = bArr[i2];
        long j3 = j2 | (((long) (b & Byte.MAX_VALUE)) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            i4 += 7;
            j3 |= ((long) (b2 & Byte.MAX_VALUE)) << i4;
            int i6 = i5;
            b = b2;
            i3 = i6;
        }
        ooVar.f22847b = j3;
        return i3;
    }

    /* renamed from: a */
    static int m23961a(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << ExecutionDataWriter.BLOCK_SESSIONINFO);
    }

    /* renamed from: b */
    static long m23965b(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    /* renamed from: c */
    static double m23966c(byte[] bArr, int i) {
        return Double.longBitsToDouble(m23965b(bArr, i));
    }

    /* renamed from: d */
    static float m23968d(byte[] bArr, int i) {
        return Float.intBitsToFloat(m23961a(bArr, i));
    }

    /* renamed from: c */
    static int m23967c(byte[] bArr, int i, C9631oo ooVar) throws zzdok {
        int a = m23962a(bArr, i, ooVar);
        int i2 = ooVar.f22846a;
        if (i2 < 0) {
            throw zzdok.m29929b();
        } else if (i2 == 0) {
            ooVar.f22848c = "";
            return a;
        } else {
            ooVar.f22848c = new String(bArr, a, i2, zzdod.f28084a);
            return a + i2;
        }
    }

    /* renamed from: d */
    static int m23969d(byte[] bArr, int i, C9631oo ooVar) throws zzdok {
        int a = m23962a(bArr, i, ooVar);
        int i2 = ooVar.f22846a;
        if (i2 < 0) {
            throw zzdok.m29929b();
        } else if (i2 == 0) {
            ooVar.f22848c = "";
            return a;
        } else {
            ooVar.f22848c = C9199Vp.m23155b(bArr, a, i2);
            return a + i2;
        }
    }

    /* renamed from: e */
    static int m23970e(byte[] bArr, int i, C9631oo ooVar) throws zzdok {
        int a = m23962a(bArr, i, ooVar);
        int i2 = ooVar.f22846a;
        if (i2 < 0) {
            throw zzdok.m29929b();
        } else if (i2 > bArr.length - a) {
            throw zzdok.m29928a();
        } else if (i2 == 0) {
            ooVar.f22848c = zzdmr.f27972a;
            return a;
        } else {
            ooVar.f22848c = zzdmr.m29653a(bArr, a, i2);
            return a + i2;
        }
    }

    /* renamed from: a */
    static int m23960a(C9822xp xpVar, byte[] bArr, int i, int i2, C9631oo ooVar) throws IOException {
        int i3;
        int i4;
        int i5 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            i4 = m23957a((int) b, bArr, i5, ooVar);
            i3 = ooVar.f22846a;
        } else {
            i4 = i5;
            i3 = b;
        }
        if (i3 < 0 || i3 > i2 - i4) {
            throw zzdok.m29928a();
        }
        Object a = xpVar.mo29080a();
        int i6 = i3 + i4;
        xpVar.mo29084a(a, bArr, i4, i6, ooVar);
        xpVar.mo29088d(a);
        ooVar.f22848c = a;
        return i6;
    }

    /* renamed from: a */
    static int m23959a(C9822xp xpVar, byte[] bArr, int i, int i2, int i3, C9631oo ooVar) throws IOException {
        C9588mp mpVar = (C9588mp) xpVar;
        Object a = mpVar.mo29080a();
        int a2 = mpVar.mo29079a(a, bArr, i, i2, i3, ooVar);
        mpVar.mo29088d(a);
        ooVar.f22848c = a;
        return a2;
    }

    /* renamed from: a */
    static int m23955a(int i, byte[] bArr, int i2, int i3, zzdoj<?> zzdoj, C9631oo ooVar) {
        C9156To to = (C9156To) zzdoj;
        int a = m23962a(bArr, i2, ooVar);
        to.mo28619d(ooVar.f22846a);
        while (a < i3) {
            int a2 = m23962a(bArr, a, ooVar);
            if (i != ooVar.f22846a) {
                break;
            }
            a = m23962a(bArr, a2, ooVar);
            to.mo28619d(ooVar.f22846a);
        }
        return a;
    }

    /* renamed from: a */
    static int m23963a(byte[] bArr, int i, zzdoj<?> zzdoj, C9631oo ooVar) throws IOException {
        C9156To to = (C9156To) zzdoj;
        int a = m23962a(bArr, i, ooVar);
        int i2 = ooVar.f22846a + a;
        while (a < i2) {
            a = m23962a(bArr, a, ooVar);
            to.mo28619d(ooVar.f22846a);
        }
        if (a == i2) {
            return a;
        }
        throw zzdok.m29928a();
    }

    /* renamed from: a */
    static int m23958a(C9822xp<?> xpVar, int i, byte[] bArr, int i2, int i3, zzdoj<?> zzdoj, C9631oo ooVar) throws IOException {
        int a = m23960a((C9822xp) xpVar, bArr, i2, i3, ooVar);
        zzdoj.add(ooVar.f22848c);
        while (a < i3) {
            int a2 = m23962a(bArr, a, ooVar);
            if (i != ooVar.f22846a) {
                break;
            }
            a = m23960a((C9822xp) xpVar, bArr, a2, i3, ooVar);
            zzdoj.add(ooVar.f22848c);
        }
        return a;
    }

    /* renamed from: a */
    static int m23956a(int i, byte[] bArr, int i2, int i3, zzdqu zzdqu, C9631oo ooVar) throws zzdok {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                int b = m23964b(bArr, i2, ooVar);
                zzdqu.mo31648a(i, (Object) Long.valueOf(ooVar.f22847b));
                return b;
            } else if (i4 == 1) {
                zzdqu.mo31648a(i, (Object) Long.valueOf(m23965b(bArr, i2)));
                return i2 + 8;
            } else if (i4 == 2) {
                int a = m23962a(bArr, i2, ooVar);
                int i5 = ooVar.f22846a;
                if (i5 < 0) {
                    throw zzdok.m29929b();
                } else if (i5 <= bArr.length - a) {
                    if (i5 == 0) {
                        zzdqu.mo31648a(i, (Object) zzdmr.f27972a);
                    } else {
                        zzdqu.mo31648a(i, (Object) zzdmr.m29653a(bArr, a, i5));
                    }
                    return a + i5;
                } else {
                    throw zzdok.m29928a();
                }
            } else if (i4 == 3) {
                zzdqu d = zzdqu.m29975d();
                int i6 = (i & -8) | 4;
                int i7 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int a2 = m23962a(bArr, i2, ooVar);
                    int i8 = ooVar.f22846a;
                    if (i8 == i6) {
                        i7 = i8;
                        i2 = a2;
                        break;
                    }
                    i7 = i8;
                    i2 = m23956a(i8, bArr, a2, i3, d, ooVar);
                }
                if (i2 > i3 || i7 != i6) {
                    throw zzdok.m29934g();
                }
                zzdqu.mo31648a(i, (Object) d);
                return i2;
            } else if (i4 == 5) {
                zzdqu.mo31648a(i, (Object) Integer.valueOf(m23961a(bArr, i2)));
                return i2 + 4;
            } else {
                throw zzdok.m29931d();
            }
        } else {
            throw zzdok.m29931d();
        }
    }

    /* renamed from: a */
    static int m23954a(int i, byte[] bArr, int i2, int i3, C9631oo ooVar) throws zzdok {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                return m23964b(bArr, i2, ooVar);
            }
            if (i4 == 1) {
                return i2 + 8;
            }
            if (i4 == 2) {
                return m23962a(bArr, i2, ooVar) + ooVar.f22846a;
            }
            if (i4 == 3) {
                int i5 = (i & -8) | 4;
                int i6 = 0;
                while (i2 < i3) {
                    i2 = m23962a(bArr, i2, ooVar);
                    i6 = ooVar.f22846a;
                    if (i6 == i5) {
                        break;
                    }
                    i2 = m23954a(i6, bArr, i2, i3, ooVar);
                }
                if (i2 <= i3 && i6 == i5) {
                    return i2;
                }
                throw zzdok.m29934g();
            } else if (i4 == 5) {
                return i2 + 4;
            } else {
                throw zzdok.m29931d();
            }
        } else {
            throw zzdok.m29931d();
        }
    }
}
