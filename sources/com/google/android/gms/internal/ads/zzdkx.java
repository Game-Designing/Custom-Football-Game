package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdky;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;

public final class zzdkx<T_WRAPPER extends zzdky<T_ENGINE>, T_ENGINE> {

    /* renamed from: a */
    private static final Logger f27940a = Logger.getLogger(zzdkx.class.getName());

    /* renamed from: b */
    private static final List<Provider> f27941b;

    /* renamed from: c */
    public static final zzdkx<zzdkz, Cipher> f27942c = new zzdkx<>(new zzdkz());

    /* renamed from: d */
    public static final zzdkx<zzdld, Mac> f27943d = new zzdkx<>(new zzdld());

    /* renamed from: e */
    public static final zzdkx<zzdlf, Signature> f27944e = new zzdkx<>(new zzdlf());

    /* renamed from: f */
    public static final zzdkx<zzdle, MessageDigest> f27945f = new zzdkx<>(new zzdle());

    /* renamed from: g */
    public static final zzdkx<zzdla, KeyAgreement> f27946g = new zzdkx<>(new zzdla());

    /* renamed from: h */
    public static final zzdkx<zzdlc, KeyPairGenerator> f27947h = new zzdkx<>(new zzdlc());

    /* renamed from: i */
    public static final zzdkx<zzdlb, KeyFactory> f27948i = new zzdkx<>(new zzdlb());

    /* renamed from: j */
    private T_WRAPPER f27949j;

    /* renamed from: k */
    private List<Provider> f27950k = f27941b;

    /* renamed from: l */
    private boolean f27951l = true;

    private zzdkx(T_WRAPPER t_wrapper) {
        this.f27949j = t_wrapper;
    }

    /* renamed from: a */
    public final T_ENGINE mo31525a(String str) throws GeneralSecurityException {
        for (Provider provider : this.f27950k) {
            if (m29610a(str, provider)) {
                return this.f27949j.mo31526a(str, provider);
            }
        }
        if (this.f27951l) {
            return this.f27949j.mo31526a(str, null);
        }
        throw new GeneralSecurityException("No good Provider found.");
    }

    /* renamed from: a */
    private final boolean m29610a(String str, Provider provider) {
        try {
            this.f27949j.mo31526a(str, provider);
            return true;
        } catch (Exception e) {
            zzdmb.m29635a(e);
            return false;
        }
    }

    static {
        if (zzdlv.m29629a()) {
            String[] strArr = {"GmsCore_OpenSSL", "AndroidOpenSSL"};
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 2; i++) {
                String str = strArr[i];
                Provider provider = Security.getProvider(str);
                if (provider != null) {
                    arrayList.add(provider);
                } else {
                    f27940a.logp(Level.INFO, "com.google.crypto.tink.subtle.EngineFactory", "toProviderList", String.format("Provider %s not available", new Object[]{str}));
                }
            }
            f27941b = arrayList;
        } else {
            f27941b = new ArrayList();
        }
    }
}
