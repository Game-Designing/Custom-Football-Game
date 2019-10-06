package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdha.zzb;
import java.security.GeneralSecurityException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class zzdcf {

    /* renamed from: a */
    private static final Logger f27781a = Logger.getLogger(zzdcf.class.getName());

    /* renamed from: b */
    private static final ConcurrentMap<String, zzdbs> f27782b = new ConcurrentHashMap();

    /* renamed from: c */
    private static final ConcurrentMap<String, Boolean> f27783c = new ConcurrentHashMap();

    /* renamed from: d */
    private static final ConcurrentMap<String, zzdbk> f27784d = new ConcurrentHashMap();

    /* renamed from: e */
    private static final ConcurrentMap<Class<?>, zzdcc<?>> f27785e = new ConcurrentHashMap();

    /* renamed from: a */
    public static synchronized void m29192a(String str, zzdbk<?> zzdbk) throws GeneralSecurityException {
        synchronized (zzdcf.class) {
            if (f27784d.containsKey(str.toLowerCase())) {
                if (!zzdbk.getClass().equals(((zzdbk) f27784d.get(str.toLowerCase())).getClass())) {
                    Logger logger = f27781a;
                    Level level = Level.WARNING;
                    String str2 = "com.google.crypto.tink.Registry";
                    String str3 = "addCatalogue";
                    String str4 = "Attempted overwrite of a catalogueName catalogue for name ";
                    String valueOf = String.valueOf(str);
                    logger.logp(level, str2, str3, valueOf.length() != 0 ? str4.concat(valueOf) : new String(str4));
                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 47);
                    sb.append("catalogue for name ");
                    sb.append(str);
                    sb.append(" has been already registered");
                    throw new GeneralSecurityException(sb.toString());
                }
            }
            f27784d.put(str.toLowerCase(), zzdbk);
        }
    }

    /* renamed from: a */
    public static zzdbk<?> m29179a(String str) throws GeneralSecurityException {
        if (str != null) {
            zzdbk<?> zzdbk = (zzdbk) f27784d.get(str.toLowerCase());
            if (zzdbk != null) {
                return zzdbk;
            }
            String format = String.format("no catalogue found for %s. ", new Object[]{str});
            if (str.toLowerCase().startsWith("tinkaead")) {
                format = String.valueOf(format).concat("Maybe call AeadConfig.register().");
            }
            if (str.toLowerCase().startsWith("tinkdeterministicaead")) {
                format = String.valueOf(format).concat("Maybe call DeterministicAeadConfig.register().");
            } else if (str.toLowerCase().startsWith("tinkstreamingaead")) {
                format = String.valueOf(format).concat("Maybe call StreamingAeadConfig.register().");
            } else if (str.toLowerCase().startsWith("tinkhybriddecrypt") || str.toLowerCase().startsWith("tinkhybridencrypt")) {
                format = String.valueOf(format).concat("Maybe call HybridConfig.register().");
            } else if (str.toLowerCase().startsWith("tinkmac")) {
                format = String.valueOf(format).concat("Maybe call MacConfig.register().");
            } else if (str.toLowerCase().startsWith("tinkpublickeysign") || str.toLowerCase().startsWith("tinkpublickeyverify")) {
                format = String.valueOf(format).concat("Maybe call SignatureConfig.register().");
            } else if (str.toLowerCase().startsWith("tink")) {
                format = String.valueOf(format).concat("Maybe call TinkConfig.register().");
            }
            throw new GeneralSecurityException(format);
        }
        throw new IllegalArgumentException("catalogueName must be non-null.");
    }

    /* renamed from: a */
    private static <T> T m29185a(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    /* renamed from: a */
    public static synchronized <P> void m29189a(zzdbs<P> zzdbs) throws GeneralSecurityException {
        synchronized (zzdcf.class) {
            m29190a(zzdbs, true);
        }
    }

    /* renamed from: a */
    public static synchronized <P> void m29190a(zzdbs<P> zzdbs, boolean z) throws GeneralSecurityException {
        synchronized (zzdcf.class) {
            if (zzdbs != null) {
                String b = zzdbs.mo31375b();
                if (f27782b.containsKey(b)) {
                    zzdbs a = m29180a(b, null);
                    boolean booleanValue = ((Boolean) f27783c.get(b)).booleanValue();
                    if (!zzdbs.getClass().equals(a.getClass()) || (!booleanValue && z)) {
                        Logger logger = f27781a;
                        Level level = Level.WARNING;
                        String str = "com.google.crypto.tink.Registry";
                        String str2 = "registerKeyManager";
                        String str3 = "Attempted overwrite of a registered key manager for key type ";
                        String valueOf = String.valueOf(b);
                        logger.logp(level, str, str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
                        throw new GeneralSecurityException(String.format("typeUrl (%s) is already registered with %s, cannot be re-registered with %s", new Object[]{b, a.getClass().getName(), zzdbs.getClass().getName()}));
                    }
                }
                f27782b.put(b, zzdbs);
                f27783c.put(b, Boolean.valueOf(z));
            } else {
                throw new IllegalArgumentException("key manager must be non-null.");
            }
        }
    }

    /* renamed from: a */
    public static synchronized <P> void m29191a(zzdcc<P> zzdcc) throws GeneralSecurityException {
        synchronized (zzdcf.class) {
            if (zzdcc != null) {
                Class a = zzdcc.mo31389a();
                if (f27785e.containsKey(a)) {
                    zzdcc zzdcc2 = (zzdcc) f27785e.get(a);
                    if (!zzdcc.getClass().equals(zzdcc2.getClass())) {
                        Logger logger = f27781a;
                        Level level = Level.WARNING;
                        String str = "com.google.crypto.tink.Registry";
                        String str2 = "registerPrimitiveWrapper";
                        String str3 = "Attempted overwrite of a registered SetWrapper for type ";
                        String valueOf = String.valueOf(a.toString());
                        logger.logp(level, str, str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
                        throw new GeneralSecurityException(String.format("SetWrapper for primitive (%s) is already registered to be %s, cannot be re-registered with %s", new Object[]{a.getName(), zzdcc2.getClass().getName(), zzdcc.getClass().getName()}));
                    }
                }
                f27785e.put(a, zzdcc);
            } else {
                throw new IllegalArgumentException("wrapper must be non-null");
            }
        }
    }

    /* renamed from: a */
    private static <P> zzdbs<P> m29180a(String str, Class<P> cls) throws GeneralSecurityException {
        zzdbs<P> zzdbs = (zzdbs) f27782b.get(str);
        if (zzdbs == null) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 78);
            sb.append("No key manager found for key type: ");
            sb.append(str);
            sb.append(".  Check the configuration of the registry.");
            throw new GeneralSecurityException(sb.toString());
        } else if (cls == null || zzdbs.mo31372a().equals(cls)) {
            return zzdbs;
        } else {
            String name = zzdbs.mo31372a().getName();
            String name2 = cls.getName();
            StringBuilder sb2 = new StringBuilder(String.valueOf(name).length() + 80 + String.valueOf(str).length() + String.valueOf(name2).length());
            sb2.append("Primitive type ");
            sb2.append(name);
            sb2.append(" of keymanager for type ");
            sb2.append(str);
            sb2.append(" does not match requested primitive type ");
            sb2.append(name2);
            throw new GeneralSecurityException(sb2.toString());
        }
    }

    /* renamed from: a */
    public static synchronized zzdgr m29182a(zzdgw zzdgw) throws GeneralSecurityException {
        zzdgr a;
        synchronized (zzdcf.class) {
            zzdbs a2 = m29180a(zzdgw.mo31470l(), null);
            if (((Boolean) f27783c.get(zzdgw.mo31470l())).booleanValue()) {
                a = a2.mo31370a(zzdgw.mo31471m());
            } else {
                String str = "newKey-operation not permitted for key type ";
                String valueOf = String.valueOf(zzdgw.mo31470l());
                throw new GeneralSecurityException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            }
        }
        return a;
    }

    /* renamed from: b */
    public static synchronized zzdpk m29193b(zzdgw zzdgw) throws GeneralSecurityException {
        zzdpk b;
        synchronized (zzdcf.class) {
            zzdbs a = m29180a(zzdgw.mo31470l(), null);
            if (((Boolean) f27783c.get(zzdgw.mo31470l())).booleanValue()) {
                b = a.mo31373b(zzdgw.mo31471m());
            } else {
                String str = "newKey-operation not permitted for key type ";
                String valueOf = String.valueOf(zzdgw.mo31470l());
                throw new GeneralSecurityException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            }
        }
        return b;
    }

    /* renamed from: a */
    public static synchronized zzdpk m29183a(String str, zzdpk zzdpk) throws GeneralSecurityException {
        zzdpk a;
        synchronized (zzdcf.class) {
            zzdbs a2 = m29180a(str, null);
            if (((Boolean) f27783c.get(str)).booleanValue()) {
                a = a2.mo31371a(zzdpk);
            } else {
                String str2 = "newKey-operation not permitted for key type ";
                String valueOf = String.valueOf(str);
                throw new GeneralSecurityException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            }
        }
        return a;
    }

    /* renamed from: a */
    public static <P> P m29187a(String str, zzdpk zzdpk, Class<P> cls) throws GeneralSecurityException {
        m29185a((T) cls);
        return m29180a(str, cls).mo31374b(zzdpk);
    }

    /* renamed from: a */
    private static <P> P m29186a(String str, zzdmr zzdmr, Class<P> cls) throws GeneralSecurityException {
        return m29180a(str, cls).mo31376c(zzdmr);
    }

    /* renamed from: a */
    public static <P> P m29188a(String str, byte[] bArr, Class<P> cls) throws GeneralSecurityException {
        zzdmr b = zzdmr.m29656b(bArr);
        m29185a((T) cls);
        return m29186a(str, b, cls);
    }

    /* renamed from: a */
    public static <P> zzdca<P> m29181a(zzdbu zzdbu, zzdbs<P> zzdbs, Class<P> cls) throws GeneralSecurityException {
        m29185a((T) cls);
        Class cls2 = cls;
        C9108Rm.m22946b(zzdbu.mo31377a());
        zzdca<P> a = zzdca.m29169a(cls2);
        for (zzb zzb : zzdbu.mo31377a().mo31488m()) {
            if (zzb.mo31493o() == zzdgu.ENABLED) {
                zzdcb a2 = a.mo31382a(m29186a(zzb.mo31492n().mo31464l(), zzb.mo31492n().mo31465m(), cls2), zzb);
                if (zzb.mo31494p() == zzdbu.mo31377a().mo31487l()) {
                    a.mo31384a(a2);
                }
            }
        }
        return a;
    }

    /* renamed from: a */
    public static <P> P m29184a(zzdca<P> zzdca) throws GeneralSecurityException {
        zzdcc zzdcc = (zzdcc) f27785e.get(zzdca.mo31383a());
        if (zzdcc != null) {
            return zzdcc.mo31390a(zzdca);
        }
        String str = "No wrapper found for ";
        String valueOf = String.valueOf(zzdca.mo31383a().getName());
        throw new GeneralSecurityException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }
}
