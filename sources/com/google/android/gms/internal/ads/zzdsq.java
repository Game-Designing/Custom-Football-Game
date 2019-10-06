package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzdsq extends zzdrr<zzdsq> {

    /* renamed from: c */
    public String f28252c = null;

    /* renamed from: d */
    public Long f28253d = null;

    /* renamed from: e */
    public Boolean f28254e = null;

    /* renamed from: a */
    public final void mo31670a(zzdrp zzdrp) throws IOException {
        String str = this.f28252c;
        if (str != null) {
            zzdrp.mo31664a(1, str);
        }
        Long l = this.f28253d;
        if (l != null) {
            long longValue = l.longValue();
            zzdrp.mo31668b(2, 0);
            zzdrp.mo31667a(longValue);
        }
        Boolean bool = this.f28254e;
        if (bool != null) {
            zzdrp.mo31665a(3, bool.booleanValue());
        }
        super.mo31670a(zzdrp);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final int mo31672c() {
        int c = super.mo31672c();
        String str = this.f28252c;
        if (str != null) {
            c += zzdrp.m29998b(1, str);
        }
        Long l = this.f28253d;
        if (l != null) {
            c += zzdrp.m29989a(2) + zzdrp.m30000b(l.longValue());
        }
        Boolean bool = this.f28254e;
        if (bool == null) {
            return c;
        }
        bool.booleanValue();
        return c + zzdrp.m29989a(3) + 1;
    }
}
