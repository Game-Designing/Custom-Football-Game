package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdgr.zzb;
import java.security.GeneralSecurityException;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.google.android.gms.internal.ads.jn */
final class C9520jn extends zzdbt<zzdby, zzdgl, zzdgn> {
    public C9520jn() {
        super(zzdby.class, zzdgl.class, zzdgn.class, "type.googleapis.com/google.crypto.tink.HmacKey");
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
    private static void m23719a(zzdgp zzdgp) throws GeneralSecurityException {
        if (zzdgp.mo31463m() >= 10) {
            int i = C9542kn.f22692a[zzdgp.mo31462l().ordinal()];
            String str = "tag size too big";
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        throw new GeneralSecurityException("unknown hash type");
                    } else if (zzdgp.mo31463m() > 64) {
                        throw new GeneralSecurityException(str);
                    }
                } else if (zzdgp.mo31463m() > 32) {
                    throw new GeneralSecurityException(str);
                }
            } else if (zzdgp.mo31463m() > 20) {
                throw new GeneralSecurityException(str);
            }
        } else {
            throw new GeneralSecurityException("tag size too small");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public final /* synthetic */ zzdpk mo28646e(zzdmr zzdmr) throws zzdok {
        return zzdgn.m29412a(zzdmr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public final /* synthetic */ zzdpk mo28644d(zzdmr zzdmr) throws zzdok {
        return zzdgl.m29395a(zzdmr);
    }

    /* renamed from: f */
    public final /* synthetic */ zzdpk mo28648f(zzdpk zzdpk) throws GeneralSecurityException {
        zzdgn zzdgn = (zzdgn) zzdpk;
        return (zzdgl) zzdgl.m29402o().mo31457a(0).mo31458a(zzdgn.mo31461m()).mo31459a(zzdmr.m29656b(zzdlo.m29627a(zzdgn.mo31460l()))).mo31612g();
    }

    /* renamed from: e */
    public final /* synthetic */ Object mo28647e(zzdpk zzdpk) throws GeneralSecurityException {
        zzdgl zzdgl = (zzdgl) zzdpk;
        zzdgj l = zzdgl.mo31456n().mo31462l();
        SecretKeySpec secretKeySpec = new SecretKeySpec(zzdgl.mo31455m().mo31539a(), "HMAC");
        int m = zzdgl.mo31456n().mo31463m();
        int i = C9542kn.f22692a[l.ordinal()];
        if (i == 1) {
            return new zzdll("HMACSHA1", secretKeySpec, m);
        }
        if (i == 2) {
            return new zzdll("HMACSHA256", secretKeySpec, m);
        }
        if (i == 3) {
            return new zzdll("HMACSHA512", secretKeySpec, m);
        }
        throw new GeneralSecurityException("unknown hash");
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public final /* synthetic */ void mo28645d(zzdpk zzdpk) throws GeneralSecurityException {
        zzdgn zzdgn = (zzdgn) zzdpk;
        if (zzdgn.mo31460l() >= 16) {
            m23719a(zzdgn.mo31461m());
            return;
        }
        throw new GeneralSecurityException("key too short");
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final /* synthetic */ void mo28643c(zzdpk zzdpk) throws GeneralSecurityException {
        zzdgl zzdgl = (zzdgl) zzdpk;
        zzdlx.m29631a(zzdgl.mo31454l(), 0);
        if (zzdgl.mo31455m().size() >= 16) {
            m23719a(zzdgl.mo31456n());
            return;
        }
        throw new GeneralSecurityException("key too short");
    }
}
