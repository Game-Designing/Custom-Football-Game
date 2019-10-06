package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzuo.zze;
import java.io.IOException;
import java.util.Arrays;

public final class zzxe {

    /* renamed from: a */
    private static final zzxe f30372a = new zzxe(0, new int[0], new Object[0], false);

    /* renamed from: b */
    private int f30373b;

    /* renamed from: c */
    private int[] f30374c;

    /* renamed from: d */
    private Object[] f30375d;

    /* renamed from: e */
    private int f30376e;

    /* renamed from: f */
    private boolean f30377f;

    /* renamed from: c */
    public static zzxe m32585c() {
        return f30372a;
    }

    /* renamed from: a */
    static zzxe m32583a(zzxe zzxe, zzxe zzxe2) {
        int i = zzxe.f30373b + zzxe2.f30373b;
        int[] copyOf = Arrays.copyOf(zzxe.f30374c, i);
        System.arraycopy(zzxe2.f30374c, 0, copyOf, zzxe.f30373b, zzxe2.f30373b);
        Object[] copyOf2 = Arrays.copyOf(zzxe.f30375d, i);
        System.arraycopy(zzxe2.f30375d, 0, copyOf2, zzxe.f30373b, zzxe2.f30373b);
        return new zzxe(i, copyOf, copyOf2, true);
    }

    private zzxe() {
        this(0, new int[8], new Object[8], true);
    }

    private zzxe(int i, int[] iArr, Object[] objArr, boolean z) {
        this.f30376e = -1;
        this.f30373b = i;
        this.f30374c = iArr;
        this.f30375d = objArr;
        this.f30377f = z;
    }

    /* renamed from: a */
    public final void mo32935a() {
        this.f30377f = false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo32936a(C9986lb lbVar) throws IOException {
        if (lbVar.mo32632b() == zze.f30340m) {
            for (int i = this.f30373b - 1; i >= 0; i--) {
                lbVar.mo32625a(this.f30374c[i] >>> 3, this.f30375d[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.f30373b; i2++) {
            lbVar.mo32625a(this.f30374c[i2] >>> 3, this.f30375d[i2]);
        }
    }

    /* renamed from: b */
    public final void mo32939b(C9986lb lbVar) throws IOException {
        if (this.f30373b != 0) {
            if (lbVar.mo32632b() == zze.f30339l) {
                for (int i = 0; i < this.f30373b; i++) {
                    m32584a(this.f30374c[i], this.f30375d[i], lbVar);
                }
                return;
            }
            for (int i2 = this.f30373b - 1; i2 >= 0; i2--) {
                m32584a(this.f30374c[i2], this.f30375d[i2], lbVar);
            }
        }
    }

    /* renamed from: a */
    private static void m32584a(int i, Object obj, C9986lb lbVar) throws IOException {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            lbVar.mo32647e(i2, ((Long) obj).longValue());
        } else if (i3 == 1) {
            lbVar.mo32635b(i2, ((Long) obj).longValue());
        } else if (i3 == 2) {
            lbVar.mo32624a(i2, (zzte) obj);
        } else if (i3 != 3) {
            if (i3 == 5) {
                lbVar.mo32643d(i2, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzuv.m32552c());
        } else if (lbVar.mo32632b() == zze.f30339l) {
            lbVar.mo32633b(i2);
            ((zzxe) obj).mo32939b(lbVar);
            lbVar.mo32619a(i2);
        } else {
            lbVar.mo32619a(i2);
            ((zzxe) obj).mo32939b(lbVar);
            lbVar.mo32633b(i2);
        }
    }

    /* renamed from: d */
    public final int mo32940d() {
        int i = this.f30376e;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.f30373b; i3++) {
            i2 += zztv.m32427d(this.f30374c[i3] >>> 3, (zzte) this.f30375d[i3]);
        }
        this.f30376e = i2;
        return i2;
    }

    /* renamed from: b */
    public final int mo32938b() {
        int i;
        int i2 = this.f30376e;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.f30373b; i4++) {
            int i5 = this.f30374c[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 == 0) {
                i = zztv.m32430e(i6, ((Long) this.f30375d[i4]).longValue());
            } else if (i7 == 1) {
                i = zztv.m32438g(i6, ((Long) this.f30375d[i4]).longValue());
            } else if (i7 == 2) {
                i = zztv.m32423c(i6, (zzte) this.f30375d[i4]);
            } else if (i7 == 3) {
                i = (zztv.m32429e(i6) << 1) + ((zzxe) this.f30375d[i4]).mo32938b();
            } else if (i7 == 5) {
                i = zztv.m32445i(i6, ((Integer) this.f30375d[i4]).intValue());
            } else {
                throw new IllegalStateException(zzuv.m32552c());
            }
            i3 += i;
        }
        this.f30376e = i3;
        return i3;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzxe)) {
            return false;
        }
        zzxe zzxe = (zzxe) obj;
        int i = this.f30373b;
        if (i == zzxe.f30373b) {
            int[] iArr = this.f30374c;
            int[] iArr2 = zzxe.f30374c;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    z = true;
                    break;
                } else if (iArr[i2] != iArr2[i2]) {
                    z = false;
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                Object[] objArr = this.f30375d;
                Object[] objArr2 = zzxe.f30375d;
                int i3 = this.f30373b;
                int i4 = 0;
                while (true) {
                    if (i4 >= i3) {
                        z2 = true;
                        break;
                    } else if (!objArr[i4].equals(objArr2[i4])) {
                        z2 = false;
                        break;
                    } else {
                        i4++;
                    }
                }
                if (!z2) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.f30373b;
        int i2 = (i + 527) * 31;
        int[] iArr = this.f30374c;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.f30375d;
        for (int i7 = 0; i7 < this.f30373b; i7++) {
            i3 = (i3 * 31) + objArr[i7].hashCode();
        }
        return i6 + i3;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo32937a(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.f30373b; i2++) {
            C10010wa.m32211a(sb, i, String.valueOf(this.f30374c[i2] >>> 3), this.f30375d[i2]);
        }
    }
}
