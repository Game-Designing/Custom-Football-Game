package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob.zze;
import java.io.IOException;
import java.util.Arrays;

public final class zzdqu {

    /* renamed from: a */
    private static final zzdqu f28114a = new zzdqu(0, new int[0], new Object[0], false);

    /* renamed from: b */
    private int f28115b;

    /* renamed from: c */
    private int[] f28116c;

    /* renamed from: d */
    private Object[] f28117d;

    /* renamed from: e */
    private int f28118e;

    /* renamed from: f */
    private boolean f28119f;

    /* renamed from: c */
    public static zzdqu m29974c() {
        return f28114a;
    }

    /* renamed from: d */
    static zzdqu m29975d() {
        return new zzdqu();
    }

    /* renamed from: a */
    static zzdqu m29972a(zzdqu zzdqu, zzdqu zzdqu2) {
        int i = zzdqu.f28115b + zzdqu2.f28115b;
        int[] copyOf = Arrays.copyOf(zzdqu.f28116c, i);
        System.arraycopy(zzdqu2.f28116c, 0, copyOf, zzdqu.f28115b, zzdqu2.f28115b);
        Object[] copyOf2 = Arrays.copyOf(zzdqu.f28117d, i);
        System.arraycopy(zzdqu2.f28117d, 0, copyOf2, zzdqu.f28115b, zzdqu2.f28115b);
        return new zzdqu(i, copyOf, copyOf2, true);
    }

    private zzdqu() {
        this(0, new int[8], new Object[8], true);
    }

    private zzdqu(int i, int[] iArr, Object[] objArr, boolean z) {
        this.f28118e = -1;
        this.f28115b = i;
        this.f28116c = iArr;
        this.f28117d = objArr;
        this.f28119f = z;
    }

    /* renamed from: a */
    public final void mo31647a() {
        this.f28119f = false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo31649a(C9435fq fqVar) throws IOException {
        if (fqVar.mo28201a() == zze.f28082m) {
            for (int i = this.f28115b - 1; i >= 0; i--) {
                fqVar.mo28207a(this.f28116c[i] >>> 3, this.f28117d[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.f28115b; i2++) {
            fqVar.mo28207a(this.f28116c[i2] >>> 3, this.f28117d[i2]);
        }
    }

    /* renamed from: b */
    public final void mo31652b(C9435fq fqVar) throws IOException {
        if (this.f28115b != 0) {
            if (fqVar.mo28201a() == zze.f28081l) {
                for (int i = 0; i < this.f28115b; i++) {
                    m29973a(this.f28116c[i], this.f28117d[i], fqVar);
                }
                return;
            }
            for (int i2 = this.f28115b - 1; i2 >= 0; i2--) {
                m29973a(this.f28116c[i2], this.f28117d[i2], fqVar);
            }
        }
    }

    /* renamed from: a */
    private static void m29973a(int i, Object obj, C9435fq fqVar) throws IOException {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            fqVar.mo28229f(i2, ((Long) obj).longValue());
        } else if (i3 == 1) {
            fqVar.mo28223d(i2, ((Long) obj).longValue());
        } else if (i3 == 2) {
            fqVar.mo28206a(i2, (zzdmr) obj);
        } else if (i3 != 3) {
            if (i3 == 5) {
                fqVar.mo28205a(i2, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzdok.m29933f());
        } else if (fqVar.mo28201a() == zze.f28081l) {
            fqVar.mo28214b(i2);
            ((zzdqu) obj).mo31652b(fqVar);
            fqVar.mo28202a(i2);
        } else {
            fqVar.mo28202a(i2);
            ((zzdqu) obj).mo31652b(fqVar);
            fqVar.mo28214b(i2);
        }
    }

    /* renamed from: e */
    public final int mo31653e() {
        int i = this.f28118e;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.f28115b; i3++) {
            i2 += zzdni.m29723d(this.f28116c[i3] >>> 3, (zzdmr) this.f28117d[i3]);
        }
        this.f28118e = i2;
        return i2;
    }

    /* renamed from: b */
    public final int mo31651b() {
        int i;
        int i2 = this.f28118e;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.f28115b; i4++) {
            int i5 = this.f28116c[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 == 0) {
                i = zzdni.m29729e(i6, ((Long) this.f28117d[i4]).longValue());
            } else if (i7 == 1) {
                i = zzdni.m29737g(i6, ((Long) this.f28117d[i4]).longValue());
            } else if (i7 == 2) {
                i = zzdni.m29718c(i6, (zzdmr) this.f28117d[i4]);
            } else if (i7 == 3) {
                i = (zzdni.m29727e(i6) << 1) + ((zzdqu) this.f28117d[i4]).mo31651b();
            } else if (i7 == 5) {
                i = zzdni.m29728e(i6, ((Integer) this.f28117d[i4]).intValue());
            } else {
                throw new IllegalStateException(zzdok.m29933f());
            }
            i3 += i;
        }
        this.f28118e = i3;
        return i3;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzdqu)) {
            return false;
        }
        zzdqu zzdqu = (zzdqu) obj;
        int i = this.f28115b;
        if (i == zzdqu.f28115b) {
            int[] iArr = this.f28116c;
            int[] iArr2 = zzdqu.f28116c;
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
                Object[] objArr = this.f28117d;
                Object[] objArr2 = zzdqu.f28117d;
                int i3 = this.f28115b;
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
        int i = this.f28115b;
        int i2 = (i + 527) * 31;
        int[] iArr = this.f28116c;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.f28117d;
        for (int i7 = 0; i7 < this.f28115b; i7++) {
            i3 = (i3 * 31) + objArr[i7].hashCode();
        }
        return i6 + i3;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo31650a(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.f28115b; i2++) {
            C9566lp.m23862a(sb, i, String.valueOf(this.f28116c[i2] >>> 3), this.f28117d[i2]);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo31648a(int i, Object obj) {
        if (this.f28119f) {
            int i2 = this.f28115b;
            if (i2 == this.f28116c.length) {
                int i3 = this.f28115b + (i2 < 4 ? 8 : i2 >> 1);
                this.f28116c = Arrays.copyOf(this.f28116c, i3);
                this.f28117d = Arrays.copyOf(this.f28117d, i3);
            }
            int[] iArr = this.f28116c;
            int i4 = this.f28115b;
            iArr[i4] = i;
            this.f28117d[i4] = obj;
            this.f28115b = i4 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }
}
