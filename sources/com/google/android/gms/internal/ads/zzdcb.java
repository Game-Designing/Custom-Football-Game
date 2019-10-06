package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzdcb<P> {

    /* renamed from: a */
    private final P f27777a;

    /* renamed from: b */
    private final byte[] f27778b;

    /* renamed from: c */
    private final zzdgu f27779c;

    /* renamed from: d */
    private final zzdhm f27780d;

    public zzdcb(P p, byte[] bArr, zzdgu zzdgu, zzdhm zzdhm) {
        this.f27777a = p;
        this.f27778b = Arrays.copyOf(bArr, bArr.length);
        this.f27779c = zzdgu;
        this.f27780d = zzdhm;
    }

    /* renamed from: a */
    public final P mo31386a() {
        return this.f27777a;
    }

    /* renamed from: b */
    public final zzdhm mo31387b() {
        return this.f27780d;
    }

    /* renamed from: c */
    public final byte[] mo31388c() {
        byte[] bArr = this.f27778b;
        if (bArr == null) {
            return null;
        }
        return Arrays.copyOf(bArr, bArr.length);
    }
}
