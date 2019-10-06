package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.logging.Logger;

public final class zzddp implements zzdcc<zzdby> {

    /* renamed from: a */
    private static final Logger f27822a = Logger.getLogger(zzddp.class.getName());

    /* renamed from: com.google.android.gms.internal.ads.zzddp$a */
    static class C9872a implements zzdby {

        /* renamed from: a */
        private final zzdca<zzdby> f27823a;

        /* renamed from: b */
        private final byte[] f27824b;

        private C9872a(zzdca<zzdby> zzdca) {
            this.f27824b = new byte[]{0};
            this.f27823a = zzdca;
        }

        /* renamed from: a */
        public final byte[] mo31381a(byte[] bArr) throws GeneralSecurityException {
            if (this.f27823a.mo31385b().mo31387b().equals(zzdhm.LEGACY)) {
                return zzdjs.m29590a(this.f27823a.mo31385b().mo31388c(), ((zzdby) this.f27823a.mo31385b().mo31386a()).mo31381a(zzdjs.m29590a(bArr, this.f27824b)));
            }
            return zzdjs.m29590a(this.f27823a.mo31385b().mo31388c(), ((zzdby) this.f27823a.mo31385b().mo31386a()).mo31381a(bArr));
        }
    }

    /* renamed from: a */
    public final Class<zzdby> mo31389a() {
        return zzdby.class;
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo31390a(zzdca zzdca) throws GeneralSecurityException {
        return new C9872a(zzdca);
    }
}
