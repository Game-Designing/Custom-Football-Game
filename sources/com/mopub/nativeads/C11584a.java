package com.mopub.nativeads;

import com.mopub.nativeads.NativeImageHelper.ImageListener;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: com.mopub.nativeads.a */
/* compiled from: AppLovinCustomEventNative */
class C11584a implements ImageListener {

    /* renamed from: a */
    private static transient /* synthetic */ boolean[] f36112a;

    /* renamed from: b */
    final /* synthetic */ C11587b f36113b;

    /* renamed from: a */
    private static /* synthetic */ boolean[] m38411a() {
        boolean[] zArr = f36112a;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3253107818752421687L, "com/mopub/nativeads/AppLovinCustomEventNative$1$1", 3);
        f36112a = probes;
        return probes;
    }

    C11584a(C11587b this$1) {
        boolean[] a = m38411a();
        this.f36113b = this$1;
        a[0] = true;
    }

    public void onImagesCached() {
        boolean[] a = m38411a();
        C11587b bVar = this.f36113b;
        AppLovinCustomEventNative.m38096a(bVar.f36120d, bVar.f36119c);
        a[1] = true;
    }

    public void onImagesFailedToCache(NativeErrorCode nativeErrorCode) {
        boolean[] a = m38411a();
        C11587b bVar = this.f36113b;
        AppLovinCustomEventNative.m38096a(bVar.f36120d, bVar.f36119c);
        a[2] = true;
    }
}
