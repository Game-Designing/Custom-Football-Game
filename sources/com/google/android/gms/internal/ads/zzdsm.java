package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrz.zzb.zzd.C15011zzb;
import java.io.IOException;

public final class zzdsm extends zzdrr<zzdsm> {

    /* renamed from: c */
    private C15011zzb f28234c = null;

    /* renamed from: d */
    public zzdsl[] f28235d = zzdsl.m30067d();

    /* renamed from: e */
    private byte[] f28236e = null;

    /* renamed from: f */
    private byte[] f28237f = null;

    /* renamed from: g */
    private Integer f28238g = null;

    /* renamed from: a */
    public final void mo31670a(zzdrp zzdrp) throws IOException {
        zzdsl[] zzdslArr = this.f28235d;
        if (zzdslArr != null && zzdslArr.length > 0) {
            int i = 0;
            while (true) {
                zzdsl[] zzdslArr2 = this.f28235d;
                if (i >= zzdslArr2.length) {
                    break;
                }
                zzdsl zzdsl = zzdslArr2[i];
                if (zzdsl != null) {
                    zzdrp.mo31663a(2, (zzdrw) zzdsl);
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
        zzdsl[] zzdslArr = this.f28235d;
        if (zzdslArr != null && zzdslArr.length > 0) {
            int i = 0;
            while (true) {
                zzdsl[] zzdslArr2 = this.f28235d;
                if (i >= zzdslArr2.length) {
                    break;
                }
                zzdsl zzdsl = zzdslArr2[i];
                if (zzdsl != null) {
                    c += zzdrp.m29997b(2, (zzdrw) zzdsl);
                }
                i++;
            }
        }
        return c;
    }
}
