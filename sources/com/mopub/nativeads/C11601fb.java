package com.mopub.nativeads;

import com.smaato.soma.C12398ha;
import com.smaato.soma.p239c.p244e.C12205a;
import java.util.ArrayList;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: com.mopub.nativeads.fb */
/* compiled from: SomaMopubNativeCustomEvent */
class C11601fb extends C12398ha<Void> {

    /* renamed from: a */
    private static transient /* synthetic */ boolean[] f36141a;

    /* renamed from: b */
    final /* synthetic */ C12205a f36142b;

    /* renamed from: c */
    final /* synthetic */ C11568a f36143c;

    /* renamed from: a */
    private static /* synthetic */ boolean[] m38421a() {
        boolean[] zArr = f36141a;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8446399258764526704L, "com/mopub/nativeads/SomaMopubNativeCustomEvent$SmaatoForwardingNativeAd$3", 17);
        f36141a = probes;
        return probes;
    }

    C11601fb(C11568a this$0, C12205a aVar) {
        boolean[] a = m38421a();
        this.f36143c = this$0;
        this.f36142b = aVar;
        a[0] = true;
    }

    public Void process() {
        boolean[] a = m38421a();
        this.f36143c.setTitle(this.f36142b.mo39528g());
        a[1] = true;
        this.f36143c.setText(this.f36142b.mo39529h());
        a[2] = true;
        this.f36143c.setMainImageUrl(this.f36142b.mo39527f());
        a[3] = true;
        this.f36143c.setIconImageUrl(this.f36142b.mo39526e());
        a[4] = true;
        this.f36143c.setCallToAction(this.f36142b.mo39521b());
        a[5] = true;
        this.f36143c.setClickDestinationUrl(this.f36142b.mo39524c());
        a[6] = true;
        this.f36143c.setStarRating(Double.valueOf((double) this.f36142b.mo39534m()));
        a[7] = true;
        List<String> imageUrls = new ArrayList<>();
        a[8] = true;
        if (this.f36143c.getMainImageUrl() == null) {
            a[9] = true;
        } else {
            a[10] = true;
            imageUrls.add(this.f36143c.getMainImageUrl());
            a[11] = true;
        }
        if (this.f36143c.getIconImageUrl() == null) {
            a[12] = true;
        } else {
            a[13] = true;
            imageUrls.add(this.f36143c.getIconImageUrl());
            a[14] = true;
        }
        NativeImageHelper.preCacheImages(C11568a.m38381a(this.f36143c), imageUrls, new C11598eb(this));
        a[15] = true;
        return null;
    }
}
