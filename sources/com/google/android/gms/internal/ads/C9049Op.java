package com.google.android.gms.internal.ads;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.ads.Op */
abstract class C9049Op<T, B> {
    C9049Op() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public abstract B mo28480a();

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public abstract void mo28481a(Object obj);

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public abstract void mo28482a(B b, int i, int i2);

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public abstract void mo28483a(B b, int i, long j);

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public abstract void mo28484a(B b, int i, zzdmr zzdmr);

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public abstract void mo28485a(B b, int i, T t);

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public abstract void mo28486a(T t, C9435fq fqVar) throws IOException;

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public abstract void mo28487a(Object obj, T t);

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public abstract boolean mo28488a(C9801wp wpVar);

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public abstract T mo28490b(B b);

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public abstract void mo28491b(B b, int i, long j);

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public abstract void mo28492b(T t, C9435fq fqVar) throws IOException;

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public abstract void mo28493b(Object obj, B b);

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public abstract int mo28494c(T t);

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public abstract T mo28495c(T t, T t2);

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public abstract T mo28496d(Object obj);

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public abstract B mo28497e(Object obj);

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public abstract int mo28498f(T t);

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final boolean mo28489a(B b, C9801wp wpVar) throws IOException {
        int tag = wpVar.getTag();
        int i = tag >>> 3;
        int i2 = tag & 7;
        if (i2 == 0) {
            mo28483a(b, i, wpVar.mo28136d());
            return true;
        } else if (i2 == 1) {
            mo28491b(b, i, wpVar.mo28138e());
            return true;
        } else if (i2 == 2) {
            mo28484a(b, i, wpVar.mo28161p());
            return true;
        } else if (i2 == 3) {
            Object a = mo28480a();
            int i3 = 4 | (i << 3);
            while (wpVar.mo28157n() != Integer.MAX_VALUE) {
                if (!mo28489a((B) a, wpVar)) {
                    break;
                }
            }
            if (i3 == wpVar.getTag()) {
                mo28485a(b, i, (T) mo28490b(a));
                return true;
            }
            throw zzdok.m29932e();
        } else if (i2 == 4) {
            return false;
        } else {
            if (i2 == 5) {
                mo28482a(b, i, wpVar.mo28142g());
                return true;
            }
            throw zzdok.m29933f();
        }
    }
}
