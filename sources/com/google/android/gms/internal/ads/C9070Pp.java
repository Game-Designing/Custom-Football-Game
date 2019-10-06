package com.google.android.gms.internal.ads;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.ads.Pp */
final class C9070Pp extends C9049Op<zzdqu, zzdqu> {
    C9070Pp() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final boolean mo28488a(C9801wp wpVar) {
        return false;
    }

    /* renamed from: a */
    private static void m22898a(Object obj, zzdqu zzdqu) {
        ((zzdob) obj).zzhhd = zzdqu;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo28481a(Object obj) {
        ((zzdob) obj).zzhhd.mo31647a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public final /* synthetic */ int mo28494c(Object obj) {
        return ((zzdqu) obj).mo31651b();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public final /* synthetic */ int mo28498f(Object obj) {
        return ((zzdqu) obj).mo31653e();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public final /* synthetic */ Object mo28495c(Object obj, Object obj2) {
        zzdqu zzdqu = (zzdqu) obj;
        zzdqu zzdqu2 = (zzdqu) obj2;
        if (zzdqu2.equals(zzdqu.m29974c())) {
            return zzdqu;
        }
        return zzdqu.m29972a(zzdqu, zzdqu2);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final /* synthetic */ void mo28492b(Object obj, C9435fq fqVar) throws IOException {
        ((zzdqu) obj).mo31649a(fqVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ void mo28486a(Object obj, C9435fq fqVar) throws IOException {
        ((zzdqu) obj).mo31652b(fqVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final /* synthetic */ void mo28493b(Object obj, Object obj2) {
        m22898a(obj, (zzdqu) obj2);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public final /* synthetic */ Object mo28497e(Object obj) {
        zzdqu zzdqu = ((zzdob) obj).zzhhd;
        if (zzdqu != zzdqu.m29974c()) {
            return zzdqu;
        }
        zzdqu d = zzdqu.m29975d();
        m22898a(obj, d);
        return d;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public final /* synthetic */ Object mo28496d(Object obj) {
        return ((zzdob) obj).zzhhd;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ void mo28487a(Object obj, Object obj2) {
        m22898a(obj, (zzdqu) obj2);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final /* synthetic */ Object mo28490b(Object obj) {
        zzdqu zzdqu = (zzdqu) obj;
        zzdqu.mo31647a();
        return zzdqu;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ Object mo28480a() {
        return zzdqu.m29975d();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ void mo28485a(Object obj, int i, Object obj2) {
        ((zzdqu) obj).mo31648a((i << 3) | 3, (Object) (zzdqu) obj2);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ void mo28484a(Object obj, int i, zzdmr zzdmr) {
        ((zzdqu) obj).mo31648a((i << 3) | 2, (Object) zzdmr);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final /* synthetic */ void mo28491b(Object obj, int i, long j) {
        ((zzdqu) obj).mo31648a((i << 3) | 1, (Object) Long.valueOf(j));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ void mo28482a(Object obj, int i, int i2) {
        ((zzdqu) obj).mo31648a((i << 3) | 5, (Object) Integer.valueOf(i2));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ void mo28483a(Object obj, int i, long j) {
        ((zzdqu) obj).mo31648a(i << 3, (Object) Long.valueOf(j));
    }
}
