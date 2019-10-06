package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.PublisherAdView;

/* renamed from: com.google.android.gms.internal.ads.x */
final class C9806x implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ PublisherAdView f23431a;

    /* renamed from: b */
    private final /* synthetic */ zzzk f23432b;

    /* renamed from: c */
    private final /* synthetic */ zzagq f23433c;

    C9806x(zzagq zzagq, PublisherAdView publisherAdView, zzzk zzzk) {
        this.f23433c = zzagq;
        this.f23431a = publisherAdView;
        this.f23432b = zzzk;
    }

    public final void run() {
        if (this.f23431a.zza(this.f23432b)) {
            this.f23433c.f24316b.onPublisherAdViewLoaded(this.f23431a);
        } else {
            zzbad.m26359d("Could not bind.");
        }
    }
}
