package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzwt.zzn;
import java.io.IOException;

public final class zzxl extends zzdrr<zzxl> {

    /* renamed from: c */
    public String f29678c = null;

    /* renamed from: d */
    private zzn f29679d = null;

    /* renamed from: e */
    private Integer f29680e = null;

    /* renamed from: f */
    public zzxo f29681f = null;

    /* renamed from: g */
    private Integer f29682g = null;

    /* renamed from: h */
    private zzwx f29683h = null;

    /* renamed from: i */
    private zzwx f29684i = null;

    /* renamed from: j */
    private zzwx f29685j = null;

    /* renamed from: a */
    public final void mo31670a(zzdrp zzdrp) throws IOException {
        String str = this.f29678c;
        if (str != null) {
            zzdrp.mo31664a(1, str);
        }
        zzxo zzxo = this.f29681f;
        if (zzxo != null) {
            zzdrp.mo31663a(4, (zzdrw) zzxo);
        }
        super.mo31670a(zzdrp);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final int mo31672c() {
        int c = super.mo31672c();
        String str = this.f29678c;
        if (str != null) {
            c += zzdrp.m29998b(1, str);
        }
        zzxo zzxo = this.f29681f;
        if (zzxo != null) {
            return c + zzdrp.m29997b(4, (zzdrw) zzxo);
        }
        return c;
    }
}
