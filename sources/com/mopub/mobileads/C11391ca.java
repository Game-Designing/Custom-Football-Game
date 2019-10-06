package com.mopub.mobileads;

/* renamed from: com.mopub.mobileads.ca */
/* compiled from: MoPubRewardedVideoManager */
class C11391ca implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f35246a;

    C11391ca(String str) {
        this.f35246a = str;
    }

    public void run() {
        if (MoPubRewardedVideoManager.f34859a.f34865g != null) {
            MoPubRewardedVideoManager.f34859a.f34865g.onRewardedVideoLoadSuccess(this.f35246a);
        }
    }
}
