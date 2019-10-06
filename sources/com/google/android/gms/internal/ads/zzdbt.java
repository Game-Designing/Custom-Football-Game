package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdgr.zzb;
import com.google.android.gms.internal.ads.zzdpk;
import java.security.GeneralSecurityException;

public abstract class zzdbt<P, KeyProto extends zzdpk, KeyFormatProto extends zzdpk> implements zzdbs<P> {

    /* renamed from: a */
    private final Class<P> f27767a;

    /* renamed from: b */
    private final Class<KeyProto> f27768b;

    /* renamed from: c */
    private final Class<KeyFormatProto> f27769c;

    /* renamed from: d */
    private final String f27770d;

    protected zzdbt(Class<P> cls, Class<KeyProto> cls2, Class<KeyFormatProto> cls3, String str) {
        this.f27767a = cls;
        this.f27768b = cls2;
        this.f27769c = cls3;
        this.f27770d = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract zzb mo28642c();

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract void mo28643c(KeyProto keyproto) throws GeneralSecurityException;

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public abstract KeyProto mo28644d(zzdmr zzdmr) throws zzdok;

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public abstract void mo28645d(KeyFormatProto keyformatproto) throws GeneralSecurityException;

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public abstract KeyFormatProto mo28646e(zzdmr zzdmr) throws zzdok;

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public abstract P mo28647e(KeyProto keyproto) throws GeneralSecurityException;

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public abstract KeyProto mo28648f(KeyFormatProto keyformatproto) throws GeneralSecurityException;

    /* renamed from: a */
    private static <Casted> Casted m29144a(Object obj, String str, Class<Casted> cls) throws GeneralSecurityException {
        if (cls.isInstance(obj)) {
            return obj;
        }
        throw new GeneralSecurityException(str);
    }

    /* renamed from: c */
    public final P mo31376c(zzdmr zzdmr) throws GeneralSecurityException {
        try {
            return m29145g(mo28644d(zzdmr));
        } catch (zzdok e) {
            String str = "Failures parsing proto of type ";
            String valueOf = String.valueOf(this.f27768b.getName());
            throw new GeneralSecurityException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), e);
        }
    }

    /* renamed from: b */
    public final P mo31374b(zzdpk zzdpk) throws GeneralSecurityException {
        String valueOf = String.valueOf(this.f27768b.getName());
        String str = "Expected proto of type ";
        m29144a(zzdpk, valueOf.length() != 0 ? str.concat(valueOf) : new String(str), this.f27768b);
        return m29145g(zzdpk);
    }

    /* renamed from: b */
    public final zzdpk mo31373b(zzdmr zzdmr) throws GeneralSecurityException {
        try {
            return m29146h(mo28646e(zzdmr));
        } catch (zzdok e) {
            String str = "Failures parsing proto of type ";
            String valueOf = String.valueOf(this.f27769c.getName());
            throw new GeneralSecurityException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), e);
        }
    }

    /* renamed from: a */
    public final zzdpk mo31371a(zzdpk zzdpk) throws GeneralSecurityException {
        String valueOf = String.valueOf(this.f27769c.getName());
        String str = "Expected proto of type ";
        m29144a(zzdpk, valueOf.length() != 0 ? str.concat(valueOf) : new String(str), this.f27769c);
        return m29146h(zzdpk);
    }

    /* renamed from: b */
    public final String mo31375b() {
        return this.f27770d;
    }

    /* renamed from: a */
    public final zzdgr mo31370a(zzdmr zzdmr) throws GeneralSecurityException {
        try {
            return (zzdgr) zzdgr.m29429o().mo31469a(this.f27770d).mo31468a(m29146h(mo28646e(zzdmr)).mo31531b()).mo31467a(mo28642c()).mo31612g();
        } catch (zzdok e) {
            throw new GeneralSecurityException("Unexpected proto", e);
        }
    }

    /* renamed from: a */
    public final Class<P> mo31372a() {
        return this.f27767a;
    }

    /* renamed from: g */
    private final P m29145g(KeyProto keyproto) throws GeneralSecurityException {
        mo28643c(keyproto);
        return mo28647e(keyproto);
    }

    /* renamed from: h */
    private final KeyProto m29146h(KeyFormatProto keyformatproto) throws GeneralSecurityException {
        mo28645d(keyformatproto);
        KeyProto f = mo28648f(keyformatproto);
        mo28643c(f);
        return f;
    }
}
