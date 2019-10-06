package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzwt.zza;
import com.google.android.gms.internal.ads.zzwt.zzb;
import com.google.android.gms.internal.ads.zzwt.zzc;
import com.google.android.gms.internal.ads.zzwt.zze;
import com.google.android.gms.internal.ads.zzwt.zzf;
import com.google.android.gms.internal.ads.zzwt.zzh;
import com.google.android.gms.internal.ads.zzwt.zzj;
import java.io.IOException;

public final class zzxj extends zzdrr<zzxj> {

    /* renamed from: c */
    public Integer f29662c = null;

    /* renamed from: d */
    private zzwx f29663d = null;

    /* renamed from: e */
    private zzb f29664e = null;

    /* renamed from: f */
    public zzxk f29665f = null;

    /* renamed from: g */
    private zza[] f29666g = new zza[0];

    /* renamed from: h */
    private zzc f29667h = null;

    /* renamed from: i */
    private zzj f29668i = null;

    /* renamed from: j */
    private zzh f29669j = null;

    /* renamed from: k */
    private zze f29670k = null;

    /* renamed from: l */
    private zzf f29671l = null;

    /* renamed from: m */
    private zzxp[] f29672m = zzxp.m31497d();

    /* renamed from: a */
    public final void mo31670a(zzdrp zzdrp) throws IOException {
        Integer num = this.f29662c;
        if (num != null) {
            zzdrp.mo31669c(7, num.intValue());
        }
        zzxk zzxk = this.f29665f;
        if (zzxk != null) {
            zzdrp.mo31663a(10, (zzdrw) zzxk);
        }
        zza[] zzaArr = this.f29666g;
        int i = 0;
        if (zzaArr != null && zzaArr.length > 0) {
            int i2 = 0;
            while (true) {
                zza[] zzaArr2 = this.f29666g;
                if (i2 >= zzaArr2.length) {
                    break;
                }
                zza zza = zzaArr2[i2];
                if (zza != null) {
                    zzdrp.mo31662a(11, (zzdpk) zza);
                }
                i2++;
            }
        }
        zzxp[] zzxpArr = this.f29672m;
        if (zzxpArr != null && zzxpArr.length > 0) {
            while (true) {
                zzxp[] zzxpArr2 = this.f29672m;
                if (i >= zzxpArr2.length) {
                    break;
                }
                zzxp zzxp = zzxpArr2[i];
                if (zzxp != null) {
                    zzdrp.mo31663a(17, (zzdrw) zzxp);
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
        Integer num = this.f29662c;
        if (num != null) {
            c += zzdrp.m29990a(7, num.intValue());
        }
        zzxk zzxk = this.f29665f;
        if (zzxk != null) {
            c += zzdrp.m29997b(10, (zzdrw) zzxk);
        }
        zza[] zzaArr = this.f29666g;
        int i = 0;
        if (zzaArr != null && zzaArr.length > 0) {
            int i2 = c;
            int i3 = 0;
            while (true) {
                zza[] zzaArr2 = this.f29666g;
                if (i3 >= zzaArr2.length) {
                    break;
                }
                zza zza = zzaArr2[i3];
                if (zza != null) {
                    i2 += zzdni.m29719c(11, (zzdpk) zza);
                }
                i3++;
            }
            c = i2;
        }
        zzxp[] zzxpArr = this.f29672m;
        if (zzxpArr != null && zzxpArr.length > 0) {
            while (true) {
                zzxp[] zzxpArr2 = this.f29672m;
                if (i >= zzxpArr2.length) {
                    break;
                }
                zzxp zzxp = zzxpArr2[i];
                if (zzxp != null) {
                    c += zzdrp.m29997b(17, (zzdrw) zzxp);
                }
                i++;
            }
        }
        return c;
    }
}
