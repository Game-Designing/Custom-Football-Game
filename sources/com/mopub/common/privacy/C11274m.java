package com.mopub.common.privacy;

import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.ConsentLogEvent;
import com.mopub.mobileads.MoPubErrorCode;

/* renamed from: com.mopub.common.privacy.m */
/* compiled from: PersonalInfoManager */
class C11274m implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ConsentDialogListener f34565a;

    /* renamed from: b */
    final /* synthetic */ PersonalInfoManager f34566b;

    C11274m(PersonalInfoManager this$0, ConsentDialogListener consentDialogListener) {
        this.f34566b = this$0;
        this.f34565a = consentDialogListener;
    }

    public void run() {
        MoPubLog.log(ConsentLogEvent.LOAD_FAILED, Integer.valueOf(MoPubErrorCode.DO_NOT_TRACK.getIntCode()), MoPubErrorCode.DO_NOT_TRACK);
        this.f34565a.onConsentDialogLoadFailed(MoPubErrorCode.DO_NOT_TRACK);
    }
}
