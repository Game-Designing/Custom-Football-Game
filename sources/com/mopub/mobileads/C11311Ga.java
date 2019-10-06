package com.mopub.mobileads;

import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;

/* renamed from: com.mopub.mobileads.Ga */
/* compiled from: VastManager */
class C11311Ga implements C11361a {

    /* renamed from: a */
    final /* synthetic */ VastVideoConfig f34753a;

    /* renamed from: b */
    final /* synthetic */ VastManager f34754b;

    C11311Ga(VastManager this$0, VastVideoConfig vastVideoConfig) {
        this.f34754b = this$0;
        this.f34753a = vastVideoConfig;
    }

    public void onComplete(boolean success) {
        if (!success || !this.f34754b.m37575a(this.f34753a)) {
            MoPubLog.log(SdkLogEvent.CUSTOM, "Failed to download VAST video.");
            this.f34754b.f34992a.onVastVideoConfigurationPrepared(null);
            return;
        }
        this.f34754b.f34992a.onVastVideoConfigurationPrepared(this.f34753a);
    }
}
