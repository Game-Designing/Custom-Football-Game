package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdgr.zzb;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;

/* renamed from: com.google.android.gms.internal.ads.bn */
final class C9344bn extends zzdbt<zzdbp, zzdfv, zzdfr> implements zzdbs<zzdbp> {
    public C9344bn() {
        super(zzdbp.class, zzdfv.class, zzdfr.class, "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey");
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final zzb mo28642c() {
        return zzb.ASYMMETRIC_PRIVATE;
    }

    public final int getVersion() {
        return 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public final /* synthetic */ zzdpk mo28646e(zzdmr zzdmr) throws zzdok {
        return zzdfr.m29333a(zzdmr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public final /* synthetic */ zzdpk mo28644d(zzdmr zzdmr) throws zzdok {
        return zzdfv.m29343a(zzdmr);
    }

    /* renamed from: f */
    public final /* synthetic */ zzdpk mo28648f(zzdpk zzdpk) throws GeneralSecurityException {
        zzdfr zzdfr = (zzdfr) zzdpk;
        KeyPair a = zzdkr.m29600a(zzdkr.m29603a(C9454gn.m23634a(zzdfr.mo31433l().mo31434l().mo31452m())));
        ECPublicKey eCPublicKey = (ECPublicKey) a.getPublic();
        ECPrivateKey eCPrivateKey = (ECPrivateKey) a.getPrivate();
        ECPoint w = eCPublicKey.getW();
        return (zzdfv) zzdfv.m29350o().mo31440a(0).mo31441a((zzdfx) zzdfx.m29368p().mo31447a(0).mo31448a(zzdfr.mo31433l()).mo31449a(zzdmr.m29656b(w.getAffineX().toByteArray())).mo31450b(zzdmr.m29656b(w.getAffineY().toByteArray())).mo31612g()).mo31442a(zzdmr.m29656b(eCPrivateKey.getS().toByteArray())).mo31612g();
    }

    /* renamed from: e */
    public final /* synthetic */ Object mo28647e(zzdpk zzdpk) throws GeneralSecurityException {
        zzdfv zzdfv = (zzdfv) zzdpk;
        zzdft o = zzdfv.mo31439n().mo31446o();
        zzdfz l = o.mo31434l();
        zzdkb zzdkb = new zzdkb(zzdkr.m29601a(C9454gn.m23634a(l.mo31452m()), zzdfv.mo31438m().mo31539a()), l.mo31453n().mo31539a(), C9454gn.m23636a(l.mo31451l()), C9454gn.m23635a(o.mo31436n()), new C9498in(o.mo31435m().mo31432l()));
        return zzdkb;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public final /* synthetic */ void mo28645d(zzdpk zzdpk) throws GeneralSecurityException {
        C9454gn.m23637a(((zzdfr) zzdpk).mo31433l());
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final /* synthetic */ void mo28643c(zzdpk zzdpk) throws GeneralSecurityException {
        zzdfv zzdfv = (zzdfv) zzdpk;
        zzdlx.m29631a(zzdfv.mo31437l(), 0);
        C9454gn.m23637a(zzdfv.mo31439n().mo31446o());
    }
}
