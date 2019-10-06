package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzwt.zza;
import java.io.IOException;

public final class zzxk extends zzdrr<zzxk> {

    /* renamed from: c */
    public String f29673c = null;

    /* renamed from: d */
    private zza[] f29674d = new zza[0];

    /* renamed from: e */
    private zzwx f29675e = null;

    /* renamed from: f */
    private zzwx f29676f = null;

    /* renamed from: g */
    private zzwx f29677g = null;

    /* renamed from: a */
    public final void mo31670a(zzdrp zzdrp) throws IOException {
        String str = this.f29673c;
        if (str != null) {
            zzdrp.mo31664a(1, str);
        }
        zza[] zzaArr = this.f29674d;
        if (zzaArr != null && zzaArr.length > 0) {
            int i = 0;
            while (true) {
                zza[] zzaArr2 = this.f29674d;
                if (i >= zzaArr2.length) {
                    break;
                }
                zza zza = zzaArr2[i];
                if (zza != null) {
                    zzdrp.mo31662a(2, (zzdpk) zza);
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
        String str = this.f29673c;
        if (str != null) {
            c += zzdrp.m29998b(1, str);
        }
        zza[] zzaArr = this.f29674d;
        if (zzaArr != null && zzaArr.length > 0) {
            int i = 0;
            while (true) {
                zza[] zzaArr2 = this.f29674d;
                if (i >= zzaArr2.length) {
                    break;
                }
                zza zza = zzaArr2[i];
                if (zza != null) {
                    c += zzdni.m29719c(2, (zzdpk) zza);
                }
                i++;
            }
        }
        return c;
    }
}
