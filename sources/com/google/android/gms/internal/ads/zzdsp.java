package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzdsp extends zzdrr<zzdsp> {

    /* renamed from: c */
    private static volatile zzdsp[] f28242c;

    /* renamed from: d */
    public Integer f28243d = null;

    /* renamed from: e */
    public String f28244e = null;

    /* renamed from: f */
    public zzdsm f28245f = null;

    /* renamed from: g */
    private zzdsn f28246g = null;

    /* renamed from: h */
    private Integer f28247h = null;

    /* renamed from: i */
    private int[] f28248i = zzdry.f28171e;

    /* renamed from: j */
    private String f28249j = null;

    /* renamed from: k */
    public Integer f28250k = null;

    /* renamed from: l */
    public String[] f28251l = zzdry.f28176j;

    /* renamed from: d */
    public static zzdsp[] m30076d() {
        if (f28242c == null) {
            synchronized (zzdrv.f28165c) {
                if (f28242c == null) {
                    f28242c = new zzdsp[0];
                }
            }
        }
        return f28242c;
    }

    /* renamed from: a */
    public final void mo31670a(zzdrp zzdrp) throws IOException {
        zzdrp.mo31669c(1, this.f28243d.intValue());
        String str = this.f28244e;
        if (str != null) {
            zzdrp.mo31664a(2, str);
        }
        zzdsm zzdsm = this.f28245f;
        if (zzdsm != null) {
            zzdrp.mo31663a(3, (zzdrw) zzdsm);
        }
        int[] iArr = this.f28248i;
        int i = 0;
        if (iArr != null && iArr.length > 0) {
            int i2 = 0;
            while (true) {
                int[] iArr2 = this.f28248i;
                if (i2 >= iArr2.length) {
                    break;
                }
                zzdrp.mo31669c(6, iArr2[i2]);
                i2++;
            }
        }
        Integer num = this.f28250k;
        if (num != null) {
            zzdrp.mo31669c(8, num.intValue());
        }
        String[] strArr = this.f28251l;
        if (strArr != null && strArr.length > 0) {
            while (true) {
                String[] strArr2 = this.f28251l;
                if (i >= strArr2.length) {
                    break;
                }
                String str2 = strArr2[i];
                if (str2 != null) {
                    zzdrp.mo31664a(9, str2);
                }
                i++;
            }
        }
        super.mo31670a(zzdrp);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final int mo31672c() {
        int[] iArr;
        int c = super.mo31672c() + zzdrp.m29990a(1, this.f28243d.intValue());
        String str = this.f28244e;
        if (str != null) {
            c += zzdrp.m29998b(2, str);
        }
        zzdsm zzdsm = this.f28245f;
        if (zzdsm != null) {
            c += zzdrp.m29997b(3, (zzdrw) zzdsm);
        }
        int[] iArr2 = this.f28248i;
        int i = 0;
        if (iArr2 != null && iArr2.length > 0) {
            int i2 = 0;
            int i3 = 0;
            while (true) {
                iArr = this.f28248i;
                if (i2 >= iArr.length) {
                    break;
                }
                i3 += zzdrp.m29996b(iArr[i2]);
                i2++;
            }
            c = c + i3 + (iArr.length * 1);
        }
        Integer num = this.f28250k;
        if (num != null) {
            c += zzdrp.m29990a(8, num.intValue());
        }
        String[] strArr = this.f28251l;
        if (strArr == null || strArr.length <= 0) {
            return c;
        }
        int i4 = 0;
        int i5 = 0;
        while (true) {
            String[] strArr2 = this.f28251l;
            if (i >= strArr2.length) {
                return c + i4 + (i5 * 1);
            }
            String str2 = strArr2[i];
            if (str2 != null) {
                i5++;
                i4 += zzdrp.m29992a(str2);
            }
            i++;
        }
    }
}
