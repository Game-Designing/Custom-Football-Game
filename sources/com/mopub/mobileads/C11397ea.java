package com.mopub.mobileads;

/* renamed from: com.mopub.mobileads.ea */
/* compiled from: MoPubRewardedVideoManager */
class C11397ea extends C11334a {
    C11397ea(Class customEventClass, String thirdPartyId) {
        super(customEventClass, thirdPartyId);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo37099a(String moPubId) {
        MoPubRewardedVideoManager.f34859a.m37476d(moPubId);
        MoPubRewardedVideoManager.f34859a.f34870l.mo37166b(moPubId);
        if (MoPubRewardedVideoManager.f34859a.f34865g != null) {
            MoPubRewardedVideoManager.f34859a.f34865g.onRewardedVideoLoadSuccess(moPubId);
        }
    }
}
