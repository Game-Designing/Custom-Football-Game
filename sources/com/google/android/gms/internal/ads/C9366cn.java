package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdgr.zzb;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.ads.cn */
final class C9366cn extends zzdbt<zzdbq, zzdfx, zzdgh> {
    public C9366cn() {
        super(zzdbq.class, zzdfx.class, zzdgh.class, "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey");
    }

    public final int getVersion() {
        return 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final zzb mo28642c() {
        return zzb.ASYMMETRIC_PUBLIC;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public final /* synthetic */ zzdpk mo28646e(zzdmr zzdmr) throws zzdok {
        return zzdgh.m29390a(zzdmr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public final /* synthetic */ zzdpk mo28644d(zzdmr zzdmr) throws zzdok {
        return zzdfx.m29359a(zzdmr);
    }

    /* renamed from: f */
    public final /* synthetic */ zzdpk mo28648f(zzdpk zzdpk) throws GeneralSecurityException {
        throw new GeneralSecurityException("Not implemented.");
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public final /* synthetic */ Object mo28647e(zzdpk zzdpk) throws GeneralSecurityException {
        zzdfx zzdfx = (zzdfx) zzdpk;
        zzdft o = zzdfx.mo31446o();
        zzdfz l = o.mo31434l();
        zzdkc zzdkc = new zzdkc(zzdkr.m29602a(C9454gn.m23634a(l.mo31452m()), zzdfx.mo31444m().mo31539a(), zzdfx.mo31445n().mo31539a()), l.mo31453n().mo31539a(), C9454gn.m23636a(l.mo31451l()), C9454gn.m23635a(o.mo31436n()), new C9498in(o.mo31435m().mo31432l()));
        return zzdkc;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public final /* bridge */ /* synthetic */ void mo28645d(zzdpk zzdpk) throws GeneralSecurityException {
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final /* synthetic */ void mo28643c(zzdpk zzdpk) throws GeneralSecurityException {
        zzdfx zzdfx = (zzdfx) zzdpk;
        zzdlx.m29631a(zzdfx.mo31443l(), 0);
        C9454gn.m23637a(zzdfx.mo31446o());
    }
}
