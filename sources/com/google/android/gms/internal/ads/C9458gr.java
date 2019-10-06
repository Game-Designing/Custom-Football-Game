package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.google.android.gms.internal.ads.gr */
final class C9458gr {
    /* renamed from: a */
    public static zzix m23653a(zzir zzir, zzis zzis) {
        boolean z;
        boolean z2;
        long j;
        long j2;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        String str;
        boolean z3;
        zzir zzir2 = zzir;
        zzir d = zzir2.mo31866d(C9436fr.f22349s);
        zzkm zzkm = d.mo31865c(C9436fr.f22306B).f28621ba;
        zzkm.mo31890a(16);
        int c = zzkm.mo31895c();
        if (c != 1936684398 && c != 1986618469 && c != 1952807028 && c != 1953325924) {
            return null;
        }
        zzkm zzkm2 = zzir2.mo31865c(C9436fr.f22356z).f28621ba;
        int i8 = 8;
        zzkm2.mo31890a(8);
        int a = C9436fr.m23619a(zzkm2.mo31895c());
        zzkm2.mo31894b(a == 0 ? 8 : 16);
        int c2 = zzkm2.mo31895c();
        zzkm2.mo31894b(4);
        int a2 = zzkm2.mo31889a();
        int i9 = a == 0 ? 4 : 8;
        int i10 = 0;
        while (true) {
            z = true;
            if (i10 >= i9) {
                z2 = true;
                break;
            } else if (zzkm2.f28743a[a2 + i10] != -1) {
                z2 = false;
                break;
            } else {
                i10++;
            }
        }
        if (z2) {
            zzkm2.mo31894b(i9);
            j = -1;
        } else {
            j = a == 0 ? zzkm2.mo31899g() : zzkm2.mo31902j();
        }
        Pair create = Pair.create(Integer.valueOf(c2), Long.valueOf(j));
        int intValue = ((Integer) create.first).intValue();
        long longValue = ((Long) create.second).longValue();
        zzkm zzkm3 = zzis.f28621ba;
        zzkm3.mo31890a(8);
        zzkm3.mo31894b(C9436fr.m23619a(zzkm3.mo31895c()) == 0 ? 8 : 16);
        long g = zzkm3.mo31899g();
        if (longValue == -1) {
            j2 = -1;
        } else {
            j2 = zzkq.m30565a(longValue, 1000000, g);
        }
        zzir d2 = d.mo31866d(C9436fr.f22350t).mo31866d(C9436fr.f22351u);
        zzkm zzkm4 = d.mo31865c(C9436fr.f22305A).f28621ba;
        zzkm4.mo31890a(8);
        if (C9436fr.m23619a(zzkm4.mo31895c()) != 0) {
            i8 = 16;
        }
        zzkm4.mo31894b(i8);
        long g2 = zzkm4.mo31899g();
        zzkm zzkm5 = d2.mo31865c(C9436fr.f22307C).f28621ba;
        zzkm5.mo31890a(12);
        int c3 = zzkm5.mo31895c();
        C9480hr hrVar = new C9480hr(c3);
        int i11 = 0;
        while (i11 < c3) {
            int a3 = zzkm5.mo31889a();
            int c4 = zzkm5.mo31895c();
            String str2 = "childAtomSize should be positive";
            zzkh.m30536a(c4 > 0, str2);
            int c5 = zzkm5.mo31895c();
            if (c5 == C9436fr.f22332b || c5 == C9436fr.f22333c) {
                i5 = c3;
                i2 = intValue;
                i6 = c;
                i7 = c4;
            } else if (c5 == C9436fr.f22313I) {
                i5 = c3;
                i2 = intValue;
                i6 = c;
                i7 = c4;
            } else {
                if (c5 == C9436fr.f22336f || c5 == C9436fr.f22314J) {
                    i = c3;
                    i4 = c4;
                } else if (c5 == C9436fr.f22337g) {
                    i = c3;
                    i4 = c4;
                } else {
                    if (c5 == C9436fr.f22320P) {
                        hrVar.f22429b = zzhj.m30354a();
                        i = c3;
                        i2 = intValue;
                        i3 = c;
                        i4 = c4;
                    } else if (c5 == C9436fr.f22323S) {
                        zzkm5.mo31890a(a3 + 8);
                        zzkm5.mo31894b(24);
                        int f = zzkm5.mo31898f();
                        int f2 = zzkm5.mo31898f();
                        zzkm5.mo31894b(50);
                        ArrayList arrayList = new ArrayList(z ? 1 : 0);
                        int a4 = zzkm5.mo31889a();
                        while (a4 - a3 < c4) {
                            zzkm5.mo31890a(a4);
                            int a5 = zzkm5.mo31889a();
                            int c6 = zzkm5.mo31895c();
                            if (c6 <= 0) {
                                z = false;
                            }
                            zzkh.m30536a(z, str2);
                            int i12 = c3;
                            if (zzkm5.mo31895c() == C9436fr.f22334d) {
                                arrayList.add(m23655a(zzkm5, a5));
                            }
                            a4 += c6;
                            c3 = i12;
                            z = true;
                        }
                        i = c3;
                        i4 = c4;
                        hrVar.f22429b = zzhj.m30358a("video/mp4v-es", -1, j2, f, f2, arrayList);
                        i2 = intValue;
                        i3 = c;
                        z = true;
                    } else {
                        i = c3;
                        i4 = c4;
                        i2 = intValue;
                        i3 = c;
                        z = true;
                    }
                    zzkm5.mo31890a(a3 + i4);
                    i11++;
                    c3 = i;
                    c = i3;
                    intValue = i2;
                }
                zzkm5.mo31890a(a3 + 8);
                zzkm5.mo31894b(16);
                int f3 = zzkm5.mo31898f();
                int f4 = zzkm5.mo31898f();
                zzkm5.mo31894b(4);
                int h = zzkm5.mo31900h();
                int a6 = zzkm5.mo31889a();
                int i13 = f3;
                int i14 = h;
                byte[] bArr = null;
                while (true) {
                    if (a6 - a3 < i4) {
                        zzkm5.mo31890a(a6);
                        int a7 = zzkm5.mo31889a();
                        int c7 = zzkm5.mo31895c();
                        if (c7 > 0) {
                            i3 = c;
                            z3 = true;
                        } else {
                            i3 = c;
                            z3 = false;
                        }
                        zzkh.m30536a(z3, str2);
                        int c8 = zzkm5.mo31895c();
                        i2 = intValue;
                        if (c5 != C9436fr.f22336f && c5 != C9436fr.f22314J) {
                            if (c5 != C9436fr.f22337g || c8 != C9436fr.f22338h) {
                                if (c5 == C9436fr.f22339i && c8 == C9436fr.f22340j) {
                                    zzkm5.mo31890a(a7 + 8);
                                    hrVar.f22429b = zzkg.m30533b(zzkm5);
                                    z = true;
                                    break;
                                }
                            } else {
                                zzkm5.mo31890a(a7 + 8);
                                hrVar.f22429b = zzkg.m30532a(zzkm5);
                                z = true;
                                break;
                            }
                        } else if (c8 == C9436fr.f22334d) {
                            bArr = m23655a(zzkm5, a7);
                            Pair a8 = zzki.m30538a(bArr);
                            i14 = ((Integer) a8.first).intValue();
                            i13 = ((Integer) a8.second).intValue();
                        } else if (c8 == C9436fr.f22309E) {
                            hrVar.f22428a[i11] = m23654a(zzkm5, a7, c7);
                        }
                        a6 += c7;
                        c = i3;
                        intValue = i2;
                    } else {
                        i2 = intValue;
                        i3 = c;
                        if (c5 == C9436fr.f22337g) {
                            str = "audio/ac3";
                        } else if (c5 == C9436fr.f22339i) {
                            str = "audio/eac3";
                        } else {
                            str = "audio/mp4a-latm";
                        }
                        hrVar.f22429b = zzhj.m30360b(str, f4, j2, i13, i14, bArr == null ? null : Collections.singletonList(bArr));
                        z = true;
                    }
                }
                zzkm5.mo31890a(a3 + i4);
                i11++;
                c3 = i;
                c = i3;
                intValue = i2;
            }
            zzkm5.mo31890a(a3 + 8);
            zzkm5.mo31894b(24);
            int f5 = zzkm5.mo31898f();
            int f6 = zzkm5.mo31898f();
            zzkm5.mo31894b(50);
            int a9 = zzkm5.mo31889a();
            float f7 = 1.0f;
            List list = null;
            while (true) {
                if (a9 - a3 >= i4) {
                    z = true;
                    break;
                }
                zzkm5.mo31890a(a9);
                int a10 = zzkm5.mo31889a();
                int c9 = zzkm5.mo31895c();
                if (c9 == 0 && zzkm5.mo31889a() - a3 == i4) {
                    z = true;
                    break;
                }
                zzkh.m30536a(c9 > 0, str2);
                int c10 = zzkm5.mo31895c();
                if (c10 == C9436fr.f22352v) {
                    zzkm5.mo31890a(a10 + 8 + 4);
                    int e = (zzkm5.mo31897e() & 3) + 1;
                    if (e != 3) {
                        ArrayList arrayList2 = new ArrayList();
                        int e2 = zzkm5.mo31897e() & 31;
                        for (int i15 = 0; i15 < e2; i15++) {
                            arrayList2.add(zzkj.m30540a(zzkm5));
                        }
                        int e3 = zzkm5.mo31897e();
                        for (int i16 = 0; i16 < e3; i16++) {
                            arrayList2.add(zzkj.m30540a(zzkm5));
                        }
                        Pair create2 = Pair.create(arrayList2, Integer.valueOf(e));
                        List list2 = (List) create2.first;
                        hrVar.f22430c = ((Integer) create2.second).intValue();
                        list = list2;
                    } else {
                        throw new IllegalStateException();
                    }
                } else if (c10 == C9436fr.f22309E) {
                    hrVar.f22428a[i11] = m23654a(zzkm5, a10, c9);
                } else if (c10 == C9436fr.f22319O) {
                    zzkm5.mo31890a(a10 + 8);
                    f7 = ((float) zzkm5.mo31901i()) / ((float) zzkm5.mo31901i());
                }
                a9 += c9;
            }
            hrVar.f22429b = zzhj.m30357a("video/avc", -1, j2, f5, f6, f7, list);
            zzkm5.mo31890a(a3 + i4);
            i11++;
            c3 = i;
            c = i3;
            intValue = i2;
        }
        int i17 = intValue;
        int i18 = c;
        zzix zzix = new zzix(intValue, c, g2, j2, hrVar.f22429b, hrVar.f22428a, hrVar.f22430c);
        return zzix;
    }

    /* renamed from: a */
    private static zziy m23654a(zzkm zzkm, int i, int i2) {
        zziy zziy;
        int i3 = i + 8;
        zziy zziy2 = null;
        while (i3 - i < i2) {
            zzkm.mo31890a(i3);
            int c = zzkm.mo31895c();
            int c2 = zzkm.mo31895c();
            if (c2 == C9436fr.f22315K) {
                zzkm.mo31895c();
            } else if (c2 == C9436fr.f22310F) {
                zzkm.mo31894b(4);
                zzkm.mo31895c();
                zzkm.mo31895c();
            } else if (c2 == C9436fr.f22311G) {
                int i4 = i3 + 8;
                while (true) {
                    if (i4 - i3 >= c) {
                        zziy = null;
                        break;
                    }
                    zzkm.mo31890a(i4);
                    int c3 = zzkm.mo31895c();
                    if (zzkm.mo31895c() == C9436fr.f22312H) {
                        zzkm.mo31894b(4);
                        int c4 = zzkm.mo31895c();
                        boolean z = true;
                        if ((c4 >> 8) != 1) {
                            z = false;
                        }
                        int i5 = c4 & 255;
                        byte[] bArr = new byte[16];
                        zzkm.mo31892a(bArr, 0, 16);
                        zziy = new zziy(z, i5, bArr);
                    } else {
                        i4 += c3;
                    }
                }
                zziy2 = zziy;
            }
            i3 += c;
        }
        return zziy2;
    }

    /* renamed from: a */
    private static byte[] m23655a(zzkm zzkm, int i) {
        zzkm.mo31890a(i + 8 + 4);
        zzkm.mo31894b(1);
        int e = zzkm.mo31897e();
        while (e > 127) {
            e = zzkm.mo31897e();
        }
        zzkm.mo31894b(2);
        int e2 = zzkm.mo31897e();
        if ((e2 & 128) != 0) {
            zzkm.mo31894b(2);
        }
        if ((e2 & 64) != 0) {
            zzkm.mo31894b(zzkm.mo31898f());
        }
        if ((e2 & 32) != 0) {
            zzkm.mo31894b(2);
        }
        zzkm.mo31894b(1);
        int e3 = zzkm.mo31897e();
        while (e3 > 127) {
            e3 = zzkm.mo31897e();
        }
        zzkm.mo31894b(13);
        zzkm.mo31894b(1);
        int e4 = zzkm.mo31897e();
        int i2 = e4 & Opcodes.LAND;
        while (e4 > 127) {
            e4 = zzkm.mo31897e();
            i2 = (i2 << 8) | (e4 & Opcodes.LAND);
        }
        byte[] bArr = new byte[i2];
        zzkm.mo31892a(bArr, 0, i2);
        return bArr;
    }
}
