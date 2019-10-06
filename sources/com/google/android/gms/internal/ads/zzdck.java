package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.logging.Logger;

public class zzdck implements zzdcc<zzdbj> {

    /* renamed from: a */
    private static final Logger f27789a = Logger.getLogger(zzdck.class.getName());

    /* renamed from: com.google.android.gms.internal.ads.zzdck$a */
    static class C9870a implements zzdbj {

        /* renamed from: a */
        private final zzdca<zzdbj> f27790a;

        private C9870a(zzdca<zzdbj> zzdca) {
            this.f27790a = zzdca;
        }

        /* renamed from: a */
        public final byte[] mo28854a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            return zzdjs.m29590a(this.f27790a.mo31385b().mo31388c(), ((zzdbj) this.f27790a.mo31385b().mo31386a()).mo28854a(bArr, bArr2));
        }
    }

    /* renamed from: a */
    public final Class<zzdbj> mo31389a() {
        return zzdbj.class;
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo31390a(zzdca zzdca) throws GeneralSecurityException {
        return new C9870a(zzdca);
    }
}
