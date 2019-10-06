package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzxo extends zzdrr<zzxo> {

    /* renamed from: c */
    public Integer f29698c = null;

    /* renamed from: d */
    public Integer f29699d = null;

    /* renamed from: e */
    public Integer f29700e = null;

    /* renamed from: a */
    public final void mo31670a(zzdrp zzdrp) throws IOException {
        Integer num = this.f29698c;
        if (num != null) {
            zzdrp.mo31669c(1, num.intValue());
        }
        Integer num2 = this.f29699d;
        if (num2 != null) {
            zzdrp.mo31669c(2, num2.intValue());
        }
        Integer num3 = this.f29700e;
        if (num3 != null) {
            zzdrp.mo31669c(3, num3.intValue());
        }
        super.mo31670a(zzdrp);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final int mo31672c() {
        int c = super.mo31672c();
        Integer num = this.f29698c;
        if (num != null) {
            c += zzdrp.m29990a(1, num.intValue());
        }
        Integer num2 = this.f29699d;
        if (num2 != null) {
            c += zzdrp.m29990a(2, num2.intValue());
        }
        Integer num3 = this.f29700e;
        if (num3 != null) {
            return c + zzdrp.m29990a(3, num3.intValue());
        }
        return c;
    }
}
