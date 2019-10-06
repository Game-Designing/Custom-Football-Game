package com.mopub.mobileads;

/* renamed from: com.mopub.mobileads.ia */
/* compiled from: MoPubRewardedVideoManager */
class C11409ia extends C11334a {

    /* renamed from: c */
    final /* synthetic */ MoPubErrorCode f35277c;

    C11409ia(Class customEventClass, String thirdPartyId, MoPubErrorCode moPubErrorCode) {
        this.f35277c = moPubErrorCode;
        super(customEventClass, thirdPartyId);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo37099a(String moPubId) {
        MoPubRewardedVideoManager.m37474c(moPubId, this.f35277c);
    }
}
