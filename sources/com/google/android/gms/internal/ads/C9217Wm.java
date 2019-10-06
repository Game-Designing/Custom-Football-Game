package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdgr.zzb;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.ads.Wm */
final class C9217Wm extends zzdbt<zzdbj, zzdeh, zzdej> {
    public C9217Wm() {
        super(zzdbj.class, zzdeh.class, zzdej.class, "type.googleapis.com/google.crypto.tink.AesEaxKey");
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
        return zzdej.m29280a(zzdmr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public final /* synthetic */ zzdpk mo28644d(zzdmr zzdmr) throws zzdok {
        return zzdeh.m29264a(zzdmr);
    }

    /* renamed from: f */
    public final /* synthetic */ zzdpk mo28648f(zzdpk zzdpk) throws GeneralSecurityException {
        zzdej zzdej = (zzdej) zzdpk;
        return (zzdeh) zzdeh.m29271o().mo31419a(zzdmr.m29656b(zzdlo.m29627a(zzdej.mo31420l()))).mo31418a(zzdej.mo31421m()).mo31417a(0).mo31612g();
    }

    /* renamed from: e */
    public final /* synthetic */ Object mo28647e(zzdpk zzdpk) throws GeneralSecurityException {
        zzdeh zzdeh = (zzdeh) zzdpk;
        return new zzdjk(zzdeh.mo31415m().mo31539a(), zzdeh.mo31416n().mo31422l());
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public final /* synthetic */ void mo28645d(zzdpk zzdpk) throws GeneralSecurityException {
        zzdej zzdej = (zzdej) zzdpk;
        zzdlx.m29630a(zzdej.mo31420l());
        if (zzdej.mo31421m().mo31422l() != 12 && zzdej.mo31421m().mo31422l() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final /* synthetic */ void mo28643c(zzdpk zzdpk) throws GeneralSecurityException {
        zzdeh zzdeh = (zzdeh) zzdpk;
        zzdlx.m29631a(zzdeh.mo31414l(), 0);
        zzdlx.m29630a(zzdeh.mo31415m().size());
        if (zzdeh.mo31416n().mo31422l() != 12 && zzdeh.mo31416n().mo31422l() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }
}
