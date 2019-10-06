package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrz.zza.zzc;
import java.io.IOException;

public final class zzdsj extends zzdrr<zzdsj> {

    /* renamed from: c */
    public Integer f28212c = null;

    /* renamed from: d */
    private zzc f28213d = null;

    /* renamed from: e */
    public String f28214e = null;

    /* renamed from: f */
    public String f28215f = null;

    /* renamed from: g */
    private String f28216g = null;

    /* renamed from: h */
    public zzdsk f28217h = null;

    /* renamed from: i */
    public zzdsp[] f28218i = zzdsp.m30076d();

    /* renamed from: j */
    public String f28219j = null;

    /* renamed from: k */
    public zzdso f28220k = null;

    /* renamed from: l */
    private Boolean f28221l = null;

    /* renamed from: m */
    private String[] f28222m;

    /* renamed from: n */
    private String f28223n;

    /* renamed from: o */
    private Boolean f28224o;

    /* renamed from: p */
    private Boolean f28225p;

    /* renamed from: q */
    private byte[] f28226q;

    /* renamed from: r */
    public zzdsq f28227r;

    /* renamed from: s */
    public String[] f28228s;

    /* renamed from: t */
    public String[] f28229t;

    public zzdsj() {
        String[] strArr = zzdry.f28176j;
        this.f28222m = strArr;
        this.f28223n = null;
        this.f28224o = null;
        this.f28225p = null;
        this.f28226q = null;
        this.f28227r = null;
        this.f28228s = strArr;
        this.f28229t = strArr;
        this.f28156b = null;
        this.f28166a = -1;
    }

    /* renamed from: a */
    public final void mo31670a(zzdrp zzdrp) throws IOException {
        String str = this.f28214e;
        if (str != null) {
            zzdrp.mo31664a(1, str);
        }
        String str2 = this.f28215f;
        if (str2 != null) {
            zzdrp.mo31664a(2, str2);
        }
        zzdsp[] zzdspArr = this.f28218i;
        int i = 0;
        if (zzdspArr != null && zzdspArr.length > 0) {
            int i2 = 0;
            while (true) {
                zzdsp[] zzdspArr2 = this.f28218i;
                if (i2 >= zzdspArr2.length) {
                    break;
                }
                zzdsp zzdsp = zzdspArr2[i2];
                if (zzdsp != null) {
                    zzdrp.mo31663a(4, (zzdrw) zzdsp);
                }
                i2++;
            }
        }
        String[] strArr = this.f28222m;
        if (strArr != null && strArr.length > 0) {
            int i3 = 0;
            while (true) {
                String[] strArr2 = this.f28222m;
                if (i3 >= strArr2.length) {
                    break;
                }
                String str3 = strArr2[i3];
                if (str3 != null) {
                    zzdrp.mo31664a(6, str3);
                }
                i3++;
            }
        }
        Integer num = this.f28212c;
        if (num != null) {
            zzdrp.mo31669c(10, num.intValue());
        }
        zzdsk zzdsk = this.f28217h;
        if (zzdsk != null) {
            zzdrp.mo31663a(12, (zzdrw) zzdsk);
        }
        String str4 = this.f28219j;
        if (str4 != null) {
            zzdrp.mo31664a(13, str4);
        }
        zzdso zzdso = this.f28220k;
        if (zzdso != null) {
            zzdrp.mo31663a(14, (zzdrw) zzdso);
        }
        zzdsq zzdsq = this.f28227r;
        if (zzdsq != null) {
            zzdrp.mo31663a(17, (zzdrw) zzdsq);
        }
        String[] strArr3 = this.f28228s;
        if (strArr3 != null && strArr3.length > 0) {
            int i4 = 0;
            while (true) {
                String[] strArr4 = this.f28228s;
                if (i4 >= strArr4.length) {
                    break;
                }
                String str5 = strArr4[i4];
                if (str5 != null) {
                    zzdrp.mo31664a(20, str5);
                }
                i4++;
            }
        }
        String[] strArr5 = this.f28229t;
        if (strArr5 != null && strArr5.length > 0) {
            while (true) {
                String[] strArr6 = this.f28229t;
                if (i >= strArr6.length) {
                    break;
                }
                String str6 = strArr6[i];
                if (str6 != null) {
                    zzdrp.mo31664a(21, str6);
                }
                i++;
            }
        }
        super.mo31670a(zzdrp);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final int mo31672c() {
        int c = super.mo31672c();
        String str = this.f28214e;
        if (str != null) {
            c += zzdrp.m29998b(1, str);
        }
        String str2 = this.f28215f;
        if (str2 != null) {
            c += zzdrp.m29998b(2, str2);
        }
        zzdsp[] zzdspArr = this.f28218i;
        int i = 0;
        if (zzdspArr != null && zzdspArr.length > 0) {
            int i2 = c;
            int i3 = 0;
            while (true) {
                zzdsp[] zzdspArr2 = this.f28218i;
                if (i3 >= zzdspArr2.length) {
                    break;
                }
                zzdsp zzdsp = zzdspArr2[i3];
                if (zzdsp != null) {
                    i2 += zzdrp.m29997b(4, (zzdrw) zzdsp);
                }
                i3++;
            }
            c = i2;
        }
        String[] strArr = this.f28222m;
        if (strArr != null && strArr.length > 0) {
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (true) {
                String[] strArr2 = this.f28222m;
                if (i4 >= strArr2.length) {
                    break;
                }
                String str3 = strArr2[i4];
                if (str3 != null) {
                    i6++;
                    i5 += zzdrp.m29992a(str3);
                }
                i4++;
            }
            c = c + i5 + (i6 * 1);
        }
        Integer num = this.f28212c;
        if (num != null) {
            c += zzdrp.m29990a(10, num.intValue());
        }
        zzdsk zzdsk = this.f28217h;
        if (zzdsk != null) {
            c += zzdrp.m29997b(12, (zzdrw) zzdsk);
        }
        String str4 = this.f28219j;
        if (str4 != null) {
            c += zzdrp.m29998b(13, str4);
        }
        zzdso zzdso = this.f28220k;
        if (zzdso != null) {
            c += zzdrp.m29997b(14, (zzdrw) zzdso);
        }
        zzdsq zzdsq = this.f28227r;
        if (zzdsq != null) {
            c += zzdrp.m29997b(17, (zzdrw) zzdsq);
        }
        String[] strArr3 = this.f28228s;
        if (strArr3 != null && strArr3.length > 0) {
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            while (true) {
                String[] strArr4 = this.f28228s;
                if (i7 >= strArr4.length) {
                    break;
                }
                String str5 = strArr4[i7];
                if (str5 != null) {
                    i9++;
                    i8 += zzdrp.m29992a(str5);
                }
                i7++;
            }
            c = c + i8 + (i9 * 2);
        }
        String[] strArr5 = this.f28229t;
        if (strArr5 == null || strArr5.length <= 0) {
            return c;
        }
        int i10 = 0;
        int i11 = 0;
        while (true) {
            String[] strArr6 = this.f28229t;
            if (i >= strArr6.length) {
                return c + i10 + (i11 * 2);
            }
            String str6 = strArr6[i];
            if (str6 != null) {
                i11++;
                i10 += zzdrp.m29992a(str6);
            }
            i++;
        }
    }
}
