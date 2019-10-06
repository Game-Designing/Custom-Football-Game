package com.mopub.common.privacy;

import com.mopub.common.ClientMetadata;
import com.mopub.common.SdkInitializationListener;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.ConsentLogEvent;
import com.mopub.mobileads.MoPubConversionTracker;

/* renamed from: com.mopub.common.privacy.p */
/* compiled from: PersonalInfoManager */
class C11277p implements SdkInitializationListener {

    /* renamed from: a */
    final /* synthetic */ PersonalInfoManager f34574a;

    C11277p(PersonalInfoManager this$0) {
        this.f34574a = this$0;
    }

    public void onInitializationFinished() {
        MoPubLog.log(ConsentLogEvent.CUSTOM, "MoPubIdentifier initialized.");
        if (PersonalInfoManager.m37127a(this.f34574a.f34475l, this.f34574a.gdprApplies(), false, this.f34574a.f34473j, this.f34574a.f34472i, this.f34574a.f34466c.mo36803i(), ClientMetadata.getInstance(this.f34574a.f34464a).getMoPubIdentifier().getAdvertisingInfo().isDoNotTrack())) {
            this.f34574a.mo36698a();
        } else if (this.f34574a.f34471h != null) {
            this.f34574a.f34471h.onInitializationFinished();
            this.f34574a.f34471h = null;
        }
        new MoPubConversionTracker(this.f34574a.f34464a).reportAppOpen(true);
    }
}
