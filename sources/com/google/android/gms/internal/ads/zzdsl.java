package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzdsl extends zzdrr<zzdsl> {

    /* renamed from: c */
    private static volatile zzdsl[] f28231c;

    /* renamed from: d */
    public byte[] f28232d = null;

    /* renamed from: e */
    public byte[] f28233e = null;

    /* renamed from: d */
    public static zzdsl[] m30067d() {
        if (f28231c == null) {
            synchronized (zzdrv.f28165c) {
                if (f28231c == null) {
                    f28231c = new zzdsl[0];
                }
            }
        }
        return f28231c;
    }

    /* renamed from: a */
    public final void mo31670a(zzdrp zzdrp) throws IOException {
        zzdrp.mo31666a(1, this.f28232d);
        byte[] bArr = this.f28233e;
        if (bArr != null) {
            zzdrp.mo31666a(2, bArr);
        }
        super.mo31670a(zzdrp);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final int mo31672c() {
        int c = super.mo31672c() + zzdrp.m29999b(1, this.f28232d);
        byte[] bArr = this.f28233e;
        if (bArr != null) {
            return c + zzdrp.m29999b(2, bArr);
        }
        return c;
    }
}
