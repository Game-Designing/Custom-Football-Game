package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzdso extends zzdrr<zzdso> {

    /* renamed from: c */
    public Integer f28239c = null;

    /* renamed from: d */
    public String f28240d = null;

    /* renamed from: e */
    public byte[] f28241e = null;

    /* renamed from: a */
    public final void mo31670a(zzdrp zzdrp) throws IOException {
        Integer num = this.f28239c;
        if (num != null) {
            zzdrp.mo31669c(1, num.intValue());
        }
        String str = this.f28240d;
        if (str != null) {
            zzdrp.mo31664a(2, str);
        }
        byte[] bArr = this.f28241e;
        if (bArr != null) {
            zzdrp.mo31666a(3, bArr);
        }
        super.mo31670a(zzdrp);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final int mo31672c() {
        int c = super.mo31672c();
        Integer num = this.f28239c;
        if (num != null) {
            c += zzdrp.m29990a(1, num.intValue());
        }
        String str = this.f28240d;
        if (str != null) {
            c += zzdrp.m29998b(2, str);
        }
        byte[] bArr = this.f28241e;
        if (bArr != null) {
            return c + zzdrp.m29999b(3, bArr);
        }
        return c;
    }
}
