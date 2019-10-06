package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.google.android.gms.internal.ads.gn */
final class C9454gn {
    /* renamed from: a */
    public static void m23637a(zzdft zzdft) throws GeneralSecurityException {
        zzdkr.m29603a(m23634a(zzdft.mo31434l().mo31452m()));
        m23636a(zzdft.mo31434l().mo31451l());
        if (zzdft.mo31436n() != zzdfd.UNKNOWN_FORMAT) {
            zzdcf.m29182a(zzdft.mo31435m().mo31432l());
            return;
        }
        throw new GeneralSecurityException("unknown EC point format");
    }

    /* renamed from: a */
    public static String m23636a(zzdgj zzdgj) throws NoSuchAlgorithmException {
        int i = C9476hn.f22421a[zzdgj.ordinal()];
        if (i == 1) {
            return "HmacSha1";
        }
        if (i == 2) {
            return "HmacSha256";
        }
        if (i == 3) {
            return "HmacSha512";
        }
        String valueOf = String.valueOf(zzdgj);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
        sb.append("hash unsupported for HMAC: ");
        sb.append(valueOf);
        throw new NoSuchAlgorithmException(sb.toString());
    }

    /* renamed from: a */
    public static zzdkt m23634a(zzdgf zzdgf) throws GeneralSecurityException {
        int i = C9476hn.f22422b[zzdgf.ordinal()];
        if (i == 1) {
            return zzdkt.NIST_P256;
        }
        if (i == 2) {
            return zzdkt.NIST_P384;
        }
        if (i == 3) {
            return zzdkt.NIST_P521;
        }
        String valueOf = String.valueOf(zzdgf);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 20);
        sb.append("unknown curve type: ");
        sb.append(valueOf);
        throw new GeneralSecurityException(sb.toString());
    }

    /* renamed from: a */
    public static zzdkv m23635a(zzdfd zzdfd) throws GeneralSecurityException {
        int i = C9476hn.f22423c[zzdfd.ordinal()];
        if (i == 1) {
            return zzdkv.UNCOMPRESSED;
        }
        if (i == 2) {
            return zzdkv.DO_NOT_USE_CRUNCHY_UNCOMPRESSED;
        }
        if (i == 3) {
            return zzdkv.COMPRESSED;
        }
        String valueOf = String.valueOf(zzdfd);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
        sb.append("unknown point format: ");
        sb.append(valueOf);
        throw new GeneralSecurityException(sb.toString());
    }
}
