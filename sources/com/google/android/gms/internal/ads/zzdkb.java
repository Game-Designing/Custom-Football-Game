package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;

public final class zzdkb implements zzdbp {

    /* renamed from: a */
    private static final byte[] f27909a = new byte[0];

    /* renamed from: b */
    private final ECPrivateKey f27910b;

    /* renamed from: c */
    private final zzdkd f27911c;

    /* renamed from: d */
    private final String f27912d;

    /* renamed from: e */
    private final byte[] f27913e;

    /* renamed from: f */
    private final zzdkv f27914f;

    /* renamed from: g */
    private final zzdka f27915g;

    public zzdkb(ECPrivateKey eCPrivateKey, byte[] bArr, String str, zzdkv zzdkv, zzdka zzdka) throws GeneralSecurityException {
        this.f27910b = eCPrivateKey;
        this.f27911c = new zzdkd(eCPrivateKey);
        this.f27913e = bArr;
        this.f27912d = str;
        this.f27914f = zzdkv;
        this.f27915g = zzdka;
    }
}
