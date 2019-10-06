package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdgr.zzb;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.ads.Xm */
final class C9238Xm extends zzdbt<zzdbj, zzdet, zzdev> {
    public C9238Xm() {
        super(zzdbj.class, zzdet.class, zzdev.class, "type.googleapis.com/google.crypto.tink.AesGcmKey");
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
        return zzdev.m29301a(zzdmr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public final /* synthetic */ zzdpk mo28644d(zzdmr zzdmr) throws zzdok {
        return zzdet.m29289a(zzdmr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public final /* synthetic */ zzdpk mo28648f(zzdpk zzdpk) throws GeneralSecurityException {
        return (zzdet) zzdet.m29294n().mo31426a(zzdmr.m29656b(zzdlo.m29627a(((zzdev) zzdpk).mo31427l()))).mo31425a(0).mo31612g();
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public final /* synthetic */ Object mo28647e(zzdpk zzdpk) throws GeneralSecurityException {
        return new zzdjm(((zzdet) zzdpk).mo31424m().mo31539a());
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public final /* synthetic */ void mo28645d(zzdpk zzdpk) throws GeneralSecurityException {
        zzdlx.m29630a(((zzdev) zzdpk).mo31427l());
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final /* synthetic */ void mo28643c(zzdpk zzdpk) throws GeneralSecurityException {
        zzdet zzdet = (zzdet) zzdpk;
        zzdlx.m29631a(zzdet.mo31423l(), 0);
        zzdlx.m29630a(zzdet.mo31424m().size());
    }
}
