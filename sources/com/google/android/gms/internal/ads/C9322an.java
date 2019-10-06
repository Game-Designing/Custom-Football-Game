package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdgr.zzb;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.ads.an */
final class C9322an extends zzdbt<zzdbj, zzdig, zzdgh> {
    public C9322an() {
        super(zzdbj.class, zzdig.class, zzdgh.class, "type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
    }

    public final int getVersion() {
        return 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final zzb mo28642c() {
        return zzb.SYMMETRIC;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public final /* synthetic */ zzdpk mo28646e(zzdmr zzdmr) throws zzdok {
        return zzdgh.m29390a(zzdmr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public final /* synthetic */ zzdpk mo28644d(zzdmr zzdmr) throws zzdok {
        return zzdig.m29562a(zzdmr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public final /* synthetic */ zzdpk mo28648f(zzdpk zzdpk) throws GeneralSecurityException {
        return (zzdig) zzdig.m29567n().mo31517a(0).mo31518a(zzdmr.m29656b(zzdlo.m29627a(32))).mo31612g();
    }

    /* renamed from: e */
    public final /* synthetic */ Object mo28647e(zzdpk zzdpk) throws GeneralSecurityException {
        return new zzdma(((zzdig) zzdpk).mo31516m().mo31539a());
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public final /* bridge */ /* synthetic */ void mo28645d(zzdpk zzdpk) throws GeneralSecurityException {
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final /* synthetic */ void mo28643c(zzdpk zzdpk) throws GeneralSecurityException {
        zzdig zzdig = (zzdig) zzdpk;
        zzdlx.m29631a(zzdig.mo31515l(), 0);
        if (zzdig.mo31516m().size() != 32) {
            throw new GeneralSecurityException("invalid XChaCha20Poly1305Key: incorrect key length");
        }
    }
}
