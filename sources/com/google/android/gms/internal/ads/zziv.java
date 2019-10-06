package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public final class zziv implements zzid, zzio {

    /* renamed from: a */
    private final zzkm f28622a = new zzkm(zzkj.f28740a);

    /* renamed from: b */
    private final zzkm f28623b = new zzkm(4);

    /* renamed from: c */
    private final zzkm f28624c = new zzkm(16);

    /* renamed from: d */
    private final Stack<zzir> f28625d = new Stack<>();

    /* renamed from: e */
    private int f28626e = 0;

    /* renamed from: f */
    private long f28627f;

    /* renamed from: g */
    private int f28628g;

    /* renamed from: h */
    private long f28629h;

    /* renamed from: i */
    private int f28630i;

    /* renamed from: j */
    private zzkm f28631j;

    /* renamed from: k */
    private int f28632k;

    /* renamed from: l */
    private int f28633l;

    /* renamed from: m */
    private int f28634m;

    /* renamed from: n */
    private zzif f28635n;

    /* renamed from: o */
    private C9502ir[] f28636o;

    /* renamed from: a */
    public final void mo31857a(zzif zzif) {
        this.f28635n = zzif;
    }

    /* renamed from: a */
    public final void mo31856a() {
        this.f28627f = 0;
        this.f28633l = 0;
        this.f28634m = 0;
    }

    /* renamed from: a */
    public final int mo31855a(zzie zzie, zzij zzij) throws IOException, InterruptedException {
        zziv zziv;
        C9502ir[] irVarArr;
        boolean z;
        zzir zzir;
        boolean z2;
        int i;
        zziv zziv2;
        ArrayList arrayList;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        long j;
        int i10;
        int[] iArr;
        int i11;
        zzkm zzkm;
        zziv zziv3 = this;
        zzie zzie2 = zzie;
        zzij zzij2 = zzij;
        while (true) {
            int i12 = zziv.f28626e;
            if (i12 == 0) {
                zziv zziv4 = zziv;
                zzie zzie3 = zzie;
                boolean z3 = false;
                if (zzie3.mo31841a(zziv4.f28624c.f28743a, 0, 8, true)) {
                    zziv4.f28624c.mo31890a(0);
                    zziv4.f28629h = zziv4.f28624c.mo31899g();
                    zziv4.f28628g = zziv4.f28624c.mo31895c();
                    if (zziv4.f28629h == 1) {
                        zzie3.readFully(zziv4.f28624c.f28743a, 8, 8);
                        zziv4.f28629h = zziv4.f28624c.mo31896d();
                        zziv4.f28627f += 16;
                        zziv4.f28630i = 16;
                    } else {
                        zziv4.f28627f += 8;
                        zziv4.f28630i = 8;
                    }
                    int i13 = zziv4.f28628g;
                    if (i13 == C9436fr.f22346p || i13 == C9436fr.f22348r || i13 == C9436fr.f22349s || i13 == C9436fr.f22350t || i13 == C9436fr.f22351u) {
                        long j2 = zziv4.f28629h;
                        if (j2 == 1) {
                            zziv4.f28625d.add(new zzir(zziv4.f28628g, (zziv4.f28627f + j2) - ((long) zziv4.f28630i)));
                        } else {
                            zziv4.f28625d.add(new zzir(zziv4.f28628g, (zziv4.f28627f + j2) - ((long) zziv4.f28630i)));
                        }
                        zziv4.f28626e = 0;
                        z3 = true;
                    } else {
                        int i14 = zziv4.f28628g;
                        if (i14 == C9436fr.f22305A || i14 == C9436fr.f22347q || i14 == C9436fr.f22306B || i14 == C9436fr.f22321Q || i14 == C9436fr.f22322R || i14 == C9436fr.f22307C || i14 == C9436fr.f22332b || i14 == C9436fr.f22352v || i14 == C9436fr.f22336f || i14 == C9436fr.f22334d || i14 == C9436fr.f22324T || i14 == C9436fr.f22325U || i14 == C9436fr.f22326V || i14 == C9436fr.f22327W || i14 == C9436fr.f22328X || i14 == C9436fr.f22329Y || i14 == C9436fr.f22330Z || i14 == C9436fr.f22356z) {
                            zzkh.m30537b(zziv4.f28629h < 2147483647L);
                            zziv4.f28631j = new zzkm((int) zziv4.f28629h);
                            System.arraycopy(zziv4.f28624c.f28743a, 0, zziv4.f28631j.f28743a, 0, 8);
                            z3 = true;
                            zziv4.f28626e = 1;
                        } else {
                            z3 = true;
                            zziv4.f28631j = null;
                            zziv4.f28626e = 1;
                        }
                    }
                }
                if (!z3) {
                    return -1;
                }
                zzij2 = zzij;
                zziv3 = zziv4;
                zzie2 = zzie3;
            } else if (i12 != 1) {
                long j3 = Long.MAX_VALUE;
                int i15 = 0;
                int i16 = -1;
                while (true) {
                    irVarArr = zziv.f28636o;
                    if (i15 >= irVarArr.length) {
                        break;
                    }
                    C9502ir irVar = irVarArr[i15];
                    int i17 = irVar.f22575d;
                    C9524jr jrVar = irVar.f22573b;
                    if (i17 != jrVar.f22625a) {
                        long j4 = jrVar.f22626b[i17];
                        if (j4 < j3) {
                            i16 = i15;
                            j3 = j4;
                        }
                    }
                    i15++;
                }
                if (i16 == -1) {
                    return -1;
                }
                C9502ir irVar2 = irVarArr[i16];
                int i18 = irVar2.f22575d;
                long j5 = irVar2.f22573b.f22626b[i18];
                long j6 = j5;
                long position = (j5 - zzie.getPosition()) + ((long) zziv.f28633l);
                if (position < 0 || position >= 262144) {
                    zzij2.f28617a = j6;
                    return 1;
                }
                zzie2.mo31840a((int) position);
                zziv.f28632k = irVar2.f22573b.f22627c[i18];
                int i19 = irVar2.f22572a.f28643g;
                if (i19 == -1) {
                    while (true) {
                        int i20 = zziv.f28633l;
                        int i21 = zziv.f28632k;
                        if (i20 >= i21) {
                            break;
                        }
                        int a = irVar2.f22574c.mo31844a(zzie2, i21 - i20);
                        zziv.f28633l += a;
                        zziv.f28634m -= a;
                    }
                } else {
                    byte[] bArr = zziv.f28623b.f28743a;
                    bArr[0] = 0;
                    bArr[1] = 0;
                    bArr[2] = 0;
                    int i22 = 4 - i19;
                    while (zziv.f28633l < zziv.f28632k) {
                        int i23 = zziv.f28634m;
                        if (i23 == 0) {
                            zzie2.readFully(zziv.f28623b.f28743a, i22, i19);
                            zziv.f28623b.mo31890a(0);
                            zziv.f28634m = zziv.f28623b.mo31901i();
                            zziv.f28622a.mo31890a(0);
                            irVar2.f22574c.mo31848a(zziv.f28622a, 4);
                            zziv.f28633l += 4;
                            zziv.f28632k += i22;
                        } else {
                            int a2 = irVar2.f22574c.mo31844a(zzie2, i23);
                            zziv.f28633l += a2;
                            zziv.f28634m -= a2;
                        }
                    }
                }
                zzip zzip = irVar2.f22574c;
                C9524jr jrVar2 = irVar2.f22573b;
                zzip.mo28863a(jrVar2.f22628d[i18], jrVar2.f22629e[i18], zziv.f28632k, 0, null);
                irVar2.f22575d++;
                zziv.f28633l = 0;
                zziv.f28634m = 0;
                return 0;
            } else {
                zziv.f28626e = 0;
                long j7 = zziv.f28627f;
                long j8 = zziv.f28629h;
                int i24 = zziv.f28630i;
                zziv.f28627f = j7 + (j8 - ((long) i24));
                long j9 = j8 - ((long) i24);
                boolean z4 = zziv.f28631j == null && (j8 >= 262144 || j8 > 2147483647L);
                if (z4) {
                    zzij2.f28617a = zziv.f28627f;
                } else {
                    zzkm zzkm2 = zziv.f28631j;
                    if (zzkm2 != null) {
                        zzie2.readFully(zzkm2.f28743a, zziv.f28630i, (int) j9);
                        if (!zziv.f28625d.isEmpty()) {
                            ((zzir) zziv.f28625d.peek()).f28619ca.add(new zzis(zziv.f28628g, zziv.f28631j));
                        }
                    } else {
                        zzie2.mo31840a((int) j9);
                    }
                }
                while (!zziv.f28625d.isEmpty() && ((zzir) zziv.f28625d.peek()).f28618ba == zziv.f28627f) {
                    zzir zzir2 = (zzir) zziv.f28625d.pop();
                    if (zzir2.f22357aa == C9436fr.f22346p) {
                        ArrayList arrayList2 = new ArrayList();
                        int i25 = 0;
                        while (i25 < zzir2.f28620da.size()) {
                            zzir zzir3 = (zzir) zzir2.f28620da.get(i25);
                            if (zzir3.f22357aa == C9436fr.f22348r) {
                                zzix a3 = C9458gr.m23653a(zzir3, zzir2.mo31865c(C9436fr.f22347q));
                                if (a3 != null) {
                                    int i26 = a3.f28638b;
                                    if (i26 == 1936684398 || i26 == 1986618469) {
                                        zzir d = zzir3.mo31866d(C9436fr.f22349s).mo31866d(C9436fr.f22350t).mo31866d(C9436fr.f22351u);
                                        zzkm zzkm3 = d.mo31865c(C9436fr.f22328X).f28621ba;
                                        zzis c = d.mo31865c(C9436fr.f22329Y);
                                        if (c == null) {
                                            c = d.mo31865c(C9436fr.f22330Z);
                                        }
                                        zzkm zzkm4 = c.f28621ba;
                                        zzkm zzkm5 = d.mo31865c(C9436fr.f22327W).f28621ba;
                                        zzkm zzkm6 = d.mo31865c(C9436fr.f22324T).f28621ba;
                                        zzis c2 = d.mo31865c(C9436fr.f22325U);
                                        zzkm zzkm7 = c2 != null ? c2.f28621ba : null;
                                        zzis c3 = d.mo31865c(C9436fr.f22326V);
                                        zzkm zzkm8 = c3 != null ? c3.f28621ba : null;
                                        zzkm3.mo31890a(12);
                                        int i27 = zzkm3.mo31901i();
                                        int i28 = zzkm3.mo31901i();
                                        int[] iArr2 = new int[i28];
                                        long[] jArr = new long[i28];
                                        z2 = z4;
                                        long[] jArr2 = new long[i28];
                                        zzir = zzir2;
                                        int[] iArr3 = new int[i28];
                                        ArrayList arrayList3 = arrayList2;
                                        zzkm4.mo31890a(12);
                                        int i29 = i25;
                                        int i30 = zzkm4.mo31901i();
                                        zzkm5.mo31890a(12);
                                        int i31 = zzkm5.mo31901i() - 1;
                                        zzix zzix = a3;
                                        if (zzkm5.mo31895c() == 1) {
                                            int i32 = zzkm5.mo31901i();
                                            zzkm5.mo31894b(4);
                                            if (i31 > 0) {
                                                i2 = zzkm5.mo31901i() - 1;
                                            } else {
                                                i2 = -1;
                                            }
                                            int i33 = i32;
                                            zzkm6.mo31890a(12);
                                            int i34 = zzkm6.mo31901i() - 1;
                                            int i35 = zzkm6.mo31901i();
                                            int i36 = zzkm6.mo31901i();
                                            if (zzkm8 != null) {
                                                i5 = i34;
                                                zzkm8.mo31890a(12);
                                                i6 = zzkm8.mo31901i() - 1;
                                                i4 = zzkm8.mo31901i();
                                                i3 = zzkm8.mo31895c();
                                            } else {
                                                i5 = i34;
                                                i6 = 0;
                                                i4 = 0;
                                                i3 = 0;
                                            }
                                            if (zzkm7 != null) {
                                                i7 = i6;
                                                zzkm7.mo31890a(12);
                                                i9 = zzkm7.mo31901i();
                                                i8 = zzkm7.mo31901i() - 1;
                                            } else {
                                                i7 = i6;
                                                i9 = 0;
                                                i8 = -1;
                                            }
                                            int i37 = i9;
                                            int i38 = i31;
                                            if (c.f22357aa == C9436fr.f22329Y) {
                                                j = zzkm4.mo31899g();
                                            } else {
                                                j = zzkm4.mo31902j();
                                            }
                                            int i39 = i2;
                                            int i40 = i8;
                                            int i41 = i33;
                                            int i42 = i5;
                                            int i43 = i3;
                                            int i44 = i38;
                                            int i45 = 0;
                                            int i46 = 0;
                                            int i47 = i4;
                                            zzkm zzkm9 = zzkm5;
                                            int i48 = i36;
                                            long j10 = 0;
                                            while (i45 < i28) {
                                                jArr2[i45] = j;
                                                iArr2[i45] = i27 == 0 ? zzkm3.mo31901i() : i27;
                                                int[] iArr4 = iArr2;
                                                long[] jArr3 = jArr2;
                                                jArr[i45] = j10 + ((long) i43);
                                                iArr3[i45] = zzkm7 == null ? 1 : 0;
                                                if (i45 == i40) {
                                                    iArr3[i45] = 1;
                                                    i37--;
                                                    if (i37 > 0) {
                                                        i40 = zzkm7.mo31901i() - 1;
                                                    }
                                                }
                                                j10 += (long) i48;
                                                i35--;
                                                if (i35 == 0 && i42 > 0) {
                                                    i42--;
                                                    i35 = zzkm6.mo31901i();
                                                    i48 = zzkm6.mo31901i();
                                                }
                                                if (zzkm8 != null) {
                                                    i47--;
                                                    if (i47 == 0 && i7 > 0) {
                                                        i7--;
                                                        i47 = zzkm8.mo31901i();
                                                        i43 = zzkm8.mo31895c();
                                                    }
                                                }
                                                i33--;
                                                if (i33 == 0) {
                                                    int i49 = i46 + 1;
                                                    if (i49 < i30) {
                                                        i10 = i43;
                                                        if (c.f22357aa == C9436fr.f22329Y) {
                                                            j = zzkm4.mo31899g();
                                                        } else {
                                                            j = zzkm4.mo31902j();
                                                        }
                                                    } else {
                                                        i10 = i43;
                                                    }
                                                    int i50 = i39;
                                                    if (i49 == i50) {
                                                        i41 = zzkm9.mo31901i();
                                                        i11 = i50;
                                                        zzkm = zzkm9;
                                                        zzkm.mo31894b(4);
                                                        i44--;
                                                        if (i44 > 0) {
                                                            i11 = zzkm.mo31901i() - 1;
                                                        }
                                                    } else {
                                                        i11 = i50;
                                                        zzkm = zzkm9;
                                                    }
                                                    if (i49 < i30) {
                                                        i46 = i49;
                                                        iArr = iArr3;
                                                        i33 = i41;
                                                    } else {
                                                        i46 = i49;
                                                        iArr = iArr3;
                                                    }
                                                } else {
                                                    i10 = i43;
                                                    zzkm = zzkm9;
                                                    i11 = i39;
                                                    iArr = iArr3;
                                                    j += (long) iArr4[i45];
                                                }
                                                i45++;
                                                i39 = i11;
                                                iArr3 = iArr;
                                                iArr2 = iArr4;
                                                jArr2 = jArr3;
                                                zzkm9 = zzkm;
                                                i43 = i10;
                                            }
                                            int[] iArr5 = iArr2;
                                            long[] jArr4 = jArr2;
                                            int[] iArr6 = iArr3;
                                            zzix zzix2 = zzix;
                                            zzkq.m30567a(jArr, 1000000, zzix2.f28639c);
                                            zzkh.m30535a(i37 == 0);
                                            zzkh.m30535a(i35 == 0);
                                            zzkh.m30535a(i33 == 0);
                                            zzkh.m30535a(i42 == 0);
                                            zzkh.m30535a(i7 == 0);
                                            C9524jr jrVar3 = new C9524jr(jArr4, iArr5, jArr, iArr6);
                                            if (jrVar3.f22625a != 0) {
                                                zziv2 = this;
                                                i = i29;
                                                C9502ir irVar3 = new C9502ir(zzix2, jrVar3, zziv2.f28635n.mo31860c(i));
                                                irVar3.f22574c.mo31847a(zzix2.f28641e);
                                                arrayList = arrayList3;
                                                arrayList.add(irVar3);
                                            } else {
                                                zziv2 = this;
                                                arrayList = arrayList3;
                                                i = i29;
                                            }
                                        } else {
                                            throw new IllegalStateException(String.valueOf("stsc first chunk must be 1"));
                                        }
                                    } else {
                                        z2 = z4;
                                        zzir = zzir2;
                                        i = i25;
                                        zziv2 = zziv;
                                        arrayList = arrayList2;
                                    }
                                } else {
                                    z2 = z4;
                                    zzir = zzir2;
                                    i = i25;
                                    zziv2 = zziv;
                                    arrayList = arrayList2;
                                }
                            } else {
                                z2 = z4;
                                zzir = zzir2;
                                i = i25;
                                zziv2 = zziv;
                                arrayList = arrayList2;
                            }
                            i25 = i + 1;
                            zzie zzie4 = zzie;
                            zzij zzij3 = zzij;
                            arrayList2 = arrayList;
                            zziv = zziv2;
                            z4 = z2;
                            zzir2 = zzir;
                        }
                        boolean z5 = z4;
                        zziv zziv5 = zziv;
                        zziv5.f28636o = (C9502ir[]) arrayList2.toArray(new C9502ir[0]);
                        zziv5.f28635n.mo31861f();
                        zziv5.f28635n.mo31859a((zzio) zziv5);
                        zziv5.f28626e = 2;
                        zzie zzie5 = zzie;
                        zzij zzij4 = zzij;
                        zziv = zziv5;
                        z = z5;
                    } else {
                        boolean z6 = z4;
                        zzir zzir4 = zzir2;
                        zziv zziv6 = zziv;
                        if (!zziv6.f28625d.isEmpty()) {
                            ((zzir) zziv6.f28625d.peek()).f28620da.add(zzir4);
                        }
                        zzie zzie6 = zzie;
                        zzij zzij5 = zzij;
                        zziv = zziv6;
                        z = z6;
                    }
                }
                boolean z7 = z4;
                zziv zziv7 = zziv;
                if (z7) {
                    return 1;
                }
                zzie2 = zzie;
                zzij2 = zzij;
                zziv3 = zziv7;
            }
        }
    }

    /* renamed from: c */
    public final boolean mo31839c() {
        return true;
    }

    /* renamed from: a */
    public final long mo31838a(long j) {
        int i;
        long j2 = Long.MAX_VALUE;
        int i2 = 0;
        while (true) {
            C9502ir[] irVarArr = this.f28636o;
            if (i2 >= irVarArr.length) {
                return j2;
            }
            C9524jr jrVar = irVarArr[i2].f22573b;
            int a = zzkq.m30564a(jrVar.f22628d, j, true, false);
            while (true) {
                if (a >= 0) {
                    if (jrVar.f22628d[a] <= j && (jrVar.f22629e[a] & 1) != 0) {
                        break;
                    }
                    a--;
                } else {
                    a = -1;
                    break;
                }
            }
            if (i == -1) {
                i = zzkq.m30570b(jrVar.f22628d, j, true, false);
                while (true) {
                    long[] jArr = jrVar.f22628d;
                    if (i < jArr.length) {
                        if (jArr[i] >= j && (jrVar.f22629e[i] & 1) != 0) {
                            break;
                        }
                        i++;
                    } else {
                        i = -1;
                        break;
                    }
                }
            }
            C9502ir[] irVarArr2 = this.f28636o;
            irVarArr2[i2].f22575d = i;
            long j3 = jrVar.f22626b[irVarArr2[i2].f22575d];
            if (j3 < j2) {
                j2 = j3;
            }
            i2++;
        }
    }
}
