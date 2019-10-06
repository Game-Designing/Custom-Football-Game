package com.mopub.nativeads;

/* renamed from: com.mopub.nativeads.ca */
/* compiled from: MoPubRecyclerAdapter */
class C11591ca implements MoPubNativeAdLoadedListener {

    /* renamed from: a */
    final /* synthetic */ MoPubRecyclerAdapter f36126a;

    C11591ca(MoPubRecyclerAdapter this$0) {
        this.f36126a = this$0;
    }

    public void onAdLoaded(int position) {
        this.f36126a.mo37946a(position);
    }

    public void onAdRemoved(int position) {
        this.f36126a.mo37947b(position);
    }
}
