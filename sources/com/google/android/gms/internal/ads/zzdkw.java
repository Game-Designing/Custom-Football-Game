package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

public final class zzdkw implements zzdbj {

    /* renamed from: a */
    private final zzdlk f27937a;

    /* renamed from: b */
    private final zzdby f27938b;

    /* renamed from: c */
    private final int f27939c;

    public zzdkw(zzdlk zzdlk, zzdby zzdby, int i) {
        this.f27937a = zzdlk;
        this.f27938b = zzdby;
        this.f27939c = i;
    }

    /* renamed from: a */
    public final byte[] mo28854a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] a = this.f27937a.mo28835a(bArr);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        byte[] copyOf = Arrays.copyOf(ByteBuffer.allocate(8).putLong(((long) bArr2.length) * 8).array(), 8);
        return zzdjs.m29590a(a, this.f27938b.mo31381a(zzdjs.m29590a(bArr2, a, copyOf)));
    }
}
