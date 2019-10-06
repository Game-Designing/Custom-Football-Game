package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdgr.zzb;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.ads.Vm */
final class C9196Vm extends zzdbt<zzdlk, zzdeb, zzded> {
    public C9196Vm() {
        super(zzdlk.class, zzdeb.class, zzded.class, "type.googleapis.com/google.crypto.tink.AesCtrKey");
    }

    public final int getVersion() {
        return 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final zzb mo28642c() {
        return zzb.SYMMETRIC;
    }

    /* renamed from: a */
    private static void m23135a(zzdef zzdef) throws GeneralSecurityException {
        if (zzdef.mo31413l() < 12 || zzdef.mo31413l() > 16) {
            throw new GeneralSecurityException("invalid IV size");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public final /* synthetic */ zzdpk mo28646e(zzdmr zzdmr) throws zzdok {
        return zzded.m29254a(zzdmr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public final /* synthetic */ zzdpk mo28644d(zzdmr zzdmr) throws zzdok {
        return zzdeb.m29237a(zzdmr);
    }

    /* renamed from: f */
    public final /* synthetic */ zzdpk mo28648f(zzdpk zzdpk) throws GeneralSecurityException {
        zzded zzded = (zzded) zzdpk;
        return (zzdeb) zzdeb.m29244o().mo31409a(zzded.mo31412m()).mo31410a(zzdmr.m29656b(zzdlo.m29627a(zzded.mo31411l()))).mo31408a(0).mo31612g();
    }

    /* renamed from: e */
    public final /* synthetic */ Object mo28647e(zzdpk zzdpk) throws GeneralSecurityException {
        zzdeb zzdeb = (zzdeb) zzdpk;
        return new zzdjj(zzdeb.mo31406m().mo31539a(), zzdeb.mo31407n().mo31413l());
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public final /* synthetic */ void mo28645d(zzdpk zzdpk) throws GeneralSecurityException {
        zzded zzded = (zzded) zzdpk;
        zzdlx.m29630a(zzded.mo31411l());
        m23135a(zzded.mo31412m());
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final /* synthetic */ void mo28643c(zzdpk zzdpk) throws GeneralSecurityException {
        zzdeb zzdeb = (zzdeb) zzdpk;
        zzdlx.m29631a(zzdeb.mo31405l(), 0);
        zzdlx.m29630a(zzdeb.mo31406m().size());
        m23135a(zzdeb.mo31407n());
    }
}
