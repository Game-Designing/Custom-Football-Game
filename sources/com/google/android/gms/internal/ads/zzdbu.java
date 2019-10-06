package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

public final class zzdbu {

    /* renamed from: a */
    private zzdha f27771a;

    private zzdbu(zzdha zzdha) {
        this.f27771a = zzdha;
    }

    /* renamed from: a */
    static final zzdbu m29161a(zzdha zzdha) throws GeneralSecurityException {
        if (zzdha != null && zzdha.mo31489n() > 0) {
            return new zzdbu(zzdha);
        }
        throw new GeneralSecurityException("empty keyset");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final zzdha mo31377a() {
        return this.f27771a;
    }

    public final String toString() {
        return C9108Rm.m22945a(this.f27771a).toString();
    }
}
