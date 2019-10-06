package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

public final class zzdcs implements zzdbj {

    /* renamed from: a */
    private static final byte[] f27791a = new byte[0];

    /* renamed from: b */
    private final zzdgw f27792b;

    /* renamed from: c */
    private final zzdbj f27793c;

    public zzdcs(zzdgw zzdgw, zzdbj zzdbj) {
        this.f27792b = zzdgw;
        this.f27793c = zzdbj;
    }

    /* renamed from: a */
    public final byte[] mo28854a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] byteArray = zzdcf.m29193b(this.f27792b).toByteArray();
        byte[] a = this.f27793c.mo28854a(byteArray, f27791a);
        byte[] a2 = ((zzdbj) zzdcf.m29188a(this.f27792b.mo31470l(), byteArray, zzdbj.class)).mo28854a(bArr, bArr2);
        return ByteBuffer.allocate(a.length + 4 + a2.length).putInt(a.length).put(a).put(a2).array();
    }
}
