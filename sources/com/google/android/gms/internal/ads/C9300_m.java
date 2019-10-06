package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdgr.zzb;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.ads._m */
final class C9300_m extends zzdbt<zzdbj, zzdhi, zzdhk> {
    public C9300_m() {
        super(zzdbj.class, zzdhi.class, zzdhk.class, "type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey");
    }

    public final int getVersion() {
        return 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final zzb mo28642c() {
        return zzb.REMOTE;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public final /* synthetic */ zzdpk mo28646e(zzdmr zzdmr) throws zzdok {
        return zzdhk.m29544a(zzdmr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public final /* synthetic */ zzdpk mo28644d(zzdmr zzdmr) throws zzdok {
        return zzdhi.m29532a(zzdmr);
    }

    /* renamed from: f */
    public final /* synthetic */ zzdpk mo28648f(zzdpk zzdpk) throws GeneralSecurityException {
        return (zzdhi) zzdhi.m29537n().mo31509a((zzdhk) zzdpk).mo31508a(0).mo31612g();
    }

    /* renamed from: e */
    public final /* synthetic */ Object mo28647e(zzdpk zzdpk) throws GeneralSecurityException {
        zzdhi zzdhi = (zzdhi) zzdpk;
        String l = zzdhi.mo31507m().mo31510l();
        return new zzdcs(zzdhi.mo31507m().mo31511m(), zzdbx.m29165a(l).mo31380b(l));
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public final /* bridge */ /* synthetic */ void mo28645d(zzdpk zzdpk) throws GeneralSecurityException {
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final /* synthetic */ void mo28643c(zzdpk zzdpk) throws GeneralSecurityException {
        zzdlx.m29631a(((zzdhi) zzdpk).mo31506l(), 0);
    }
}
