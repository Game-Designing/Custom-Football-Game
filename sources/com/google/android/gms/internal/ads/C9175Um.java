package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdgr.zzb;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.ads.Um */
final class C9175Um extends zzdbt<zzdbj, zzddr, zzddt> {
    public C9175Um() throws GeneralSecurityException {
        super(zzdbj.class, zzddr.class, zzddt.class, "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        zzdcf.m29189a((zzdbs<P>) new C9196Vm<P>());
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
        return zzddt.m29229a(zzdmr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public final /* synthetic */ zzdpk mo28644d(zzdmr zzdmr) throws zzdok {
        return zzddr.m29213a(zzdmr);
    }

    /* renamed from: f */
    public final /* synthetic */ zzdpk mo28648f(zzdpk zzdpk) throws GeneralSecurityException {
        zzddt zzddt = (zzddt) zzdpk;
        zzdeb zzdeb = (zzdeb) zzdcf.m29183a("type.googleapis.com/google.crypto.tink.AesCtrKey", (zzdpk) zzddt.mo31401l());
        return (zzddr) zzddr.m29220o().mo31399a(zzdeb).mo31400a((zzdgl) zzdcf.m29183a("type.googleapis.com/google.crypto.tink.HmacKey", (zzdpk) zzddt.mo31402m())).mo31398a(0).mo31612g();
    }

    /* renamed from: e */
    public final /* synthetic */ Object mo28647e(zzdpk zzdpk) throws GeneralSecurityException {
        zzddr zzddr = (zzddr) zzdpk;
        return new zzdkw((zzdlk) zzdcf.m29187a("type.googleapis.com/google.crypto.tink.AesCtrKey", (zzdpk) zzddr.mo31396m(), zzdlk.class), (zzdby) zzdcf.m29187a("type.googleapis.com/google.crypto.tink.HmacKey", (zzdpk) zzddr.mo31397n(), zzdby.class), zzddr.mo31397n().mo31456n().mo31463m());
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public final /* synthetic */ void mo28645d(zzdpk zzdpk) throws GeneralSecurityException {
        zzdlx.m29630a(((zzddt) zzdpk).mo31401l().mo31411l());
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final /* synthetic */ void mo28643c(zzdpk zzdpk) throws GeneralSecurityException {
        zzdlx.m29631a(((zzddr) zzdpk).mo31395l(), 0);
    }
}
