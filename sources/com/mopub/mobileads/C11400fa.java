package com.mopub.mobileads;

/* renamed from: com.mopub.mobileads.fa */
/* compiled from: MoPubRewardedVideoManager */
class C11400fa extends C11334a {

    /* renamed from: c */
    final /* synthetic */ MoPubErrorCode f35257c;

    C11400fa(Class customEventClass, String thirdPartyId, MoPubErrorCode moPubErrorCode) {
        this.f35257c = moPubErrorCode;
        super(customEventClass, thirdPartyId);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo37099a(String moPubId) {
        MoPubRewardedVideoManager.f34859a.m37476d(moPubId);
        MoPubRewardedVideoManager.f34859a.m37470b(moPubId, this.f35257c);
    }
}
