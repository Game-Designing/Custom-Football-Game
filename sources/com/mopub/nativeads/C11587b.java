package com.mopub.nativeads;

import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p019d.p143b.p149c.C7247a;

/* renamed from: com.mopub.nativeads.b */
/* compiled from: AppLovinCustomEventNative */
class C11587b implements Runnable {

    /* renamed from: a */
    private static transient /* synthetic */ boolean[] f36117a;

    /* renamed from: b */
    final /* synthetic */ List f36118b;

    /* renamed from: c */
    final /* synthetic */ C7247a f36119c;

    /* renamed from: d */
    final /* synthetic */ AppLovinCustomEventNative f36120d;

    /* renamed from: a */
    private static /* synthetic */ boolean[] m38413a() {
        boolean[] zArr = f36117a;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5554028682910294573L, "com/mopub/nativeads/AppLovinCustomEventNative$1", 2);
        f36117a = probes;
        return probes;
    }

    C11587b(AppLovinCustomEventNative this$0, List list, C7247a aVar) {
        boolean[] a = m38413a();
        this.f36120d = this$0;
        this.f36118b = list;
        this.f36119c = aVar;
        a[0] = true;
    }

    public void run() {
        boolean[] a = m38413a();
        NativeImageHelper.preCacheImages(AppLovinCustomEventNative.m38091a(this.f36120d), this.f36118b, new C11584a(this));
        a[1] = true;
    }
}
