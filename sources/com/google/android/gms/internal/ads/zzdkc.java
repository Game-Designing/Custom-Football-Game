package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.interfaces.ECPublicKey;

public final class zzdkc implements zzdbq {

    /* renamed from: a */
    private static final byte[] f27916a = new byte[0];

    /* renamed from: b */
    private final zzdke f27917b;

    /* renamed from: c */
    private final String f27918c;

    /* renamed from: d */
    private final byte[] f27919d;

    /* renamed from: e */
    private final zzdkv f27920e;

    /* renamed from: f */
    private final zzdka f27921f;

    public zzdkc(ECPublicKey eCPublicKey, byte[] bArr, String str, zzdkv zzdkv, zzdka zzdka) throws GeneralSecurityException {
        zzdkr.m29605a(eCPublicKey);
        this.f27917b = new zzdke(eCPublicKey);
        this.f27919d = bArr;
        this.f27918c = str;
        this.f27920e = zzdkv;
        this.f27921f = zzdka;
    }

    /* renamed from: a */
    public final byte[] mo28946a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        zzdkf a = this.f27917b.mo31522a(this.f27918c, this.f27919d, bArr2, this.f27921f.mo29006a(), this.f27920e);
        byte[] a2 = this.f27921f.mo29007a(a.mo31524b()).mo28854a(bArr, f27916a);
        byte[] a3 = a.mo31523a();
        return ByteBuffer.allocate(a3.length + a2.length).put(a3).put(a2).array();
    }
}
