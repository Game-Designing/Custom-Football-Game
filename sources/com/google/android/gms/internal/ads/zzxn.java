package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzwt.zzg;
import com.google.android.gms.internal.ads.zzwt.zzi;
import com.google.android.gms.internal.ads.zzwt.zzv;
import java.io.IOException;

public final class zzxn extends zzdrr<zzxn> {

    /* renamed from: c */
    private Integer f29686c = null;

    /* renamed from: d */
    public String f29687d = null;

    /* renamed from: e */
    private Integer f29688e = null;

    /* renamed from: f */
    private zzwx f29689f = null;

    /* renamed from: g */
    private zzxo f29690g = null;

    /* renamed from: h */
    public long[] f29691h = zzdry.f28172f;

    /* renamed from: i */
    public zzxl f29692i = null;

    /* renamed from: j */
    private zzxm f29693j = null;

    /* renamed from: k */
    private zzg f29694k = null;

    /* renamed from: l */
    public zzxj f29695l = null;

    /* renamed from: m */
    public zzi f29696m = null;

    /* renamed from: n */
    public zzv f29697n = null;

    /* renamed from: a */
    public final void mo31670a(zzdrp zzdrp) throws IOException {
        String str = this.f29687d;
        if (str != null) {
            zzdrp.mo31664a(10, str);
        }
        long[] jArr = this.f29691h;
        if (jArr != null && jArr.length > 0) {
            int i = 0;
            while (true) {
                long[] jArr2 = this.f29691h;
                if (i >= jArr2.length) {
                    break;
                }
                long j = jArr2[i];
                zzdrp.mo31668b(14, 0);
                zzdrp.mo31667a(j);
                i++;
            }
        }
        zzxl zzxl = this.f29692i;
        if (zzxl != null) {
            zzdrp.mo31663a(15, (zzdrw) zzxl);
        }
        zzxj zzxj = this.f29695l;
        if (zzxj != null) {
            zzdrp.mo31663a(18, (zzdrw) zzxj);
        }
        zzi zzi = this.f29696m;
        if (zzi != null) {
            zzdrp.mo31662a(19, (zzdpk) zzi);
        }
        zzv zzv = this.f29697n;
        if (zzv != null) {
            zzdrp.mo31662a(20, (zzdpk) zzv);
        }
        super.mo31670a(zzdrp);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final int mo31672c() {
        long[] jArr;
        int c = super.mo31672c();
        String str = this.f29687d;
        if (str != null) {
            c += zzdrp.m29998b(10, str);
        }
        long[] jArr2 = this.f29691h;
        if (jArr2 != null && jArr2.length > 0) {
            int i = 0;
            int i2 = 0;
            while (true) {
                jArr = this.f29691h;
                if (i >= jArr.length) {
                    break;
                }
                i2 += zzdrp.m30000b(jArr[i]);
                i++;
            }
            c = c + i2 + (jArr.length * 1);
        }
        zzxl zzxl = this.f29692i;
        if (zzxl != null) {
            c += zzdrp.m29997b(15, (zzdrw) zzxl);
        }
        zzxj zzxj = this.f29695l;
        if (zzxj != null) {
            c += zzdrp.m29997b(18, (zzdrw) zzxj);
        }
        zzi zzi = this.f29696m;
        if (zzi != null) {
            c += zzdni.m29719c(19, (zzdpk) zzi);
        }
        zzv zzv = this.f29697n;
        if (zzv != null) {
            return c + zzdni.m29719c(20, (zzdpk) zzv);
        }
        return c;
    }
}
