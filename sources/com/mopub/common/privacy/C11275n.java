package com.mopub.common.privacy;

import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.ConsentLogEvent;
import com.mopub.mobileads.MoPubErrorCode;

/* renamed from: com.mopub.common.privacy.n */
/* compiled from: PersonalInfoManager */
class C11275n implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ConsentDialogListener f34567a;

    /* renamed from: b */
    final /* synthetic */ PersonalInfoManager f34568b;

    C11275n(PersonalInfoManager this$0, ConsentDialogListener consentDialogListener) {
        this.f34568b = this$0;
        this.f34567a = consentDialogListener;
    }

    public void run() {
        MoPubLog.log(ConsentLogEvent.LOAD_FAILED, Integer.valueOf(MoPubErrorCode.GDPR_DOES_NOT_APPLY.getIntCode()), MoPubErrorCode.GDPR_DOES_NOT_APPLY);
        this.f34567a.onConsentDialogLoadFailed(MoPubErrorCode.GDPR_DOES_NOT_APPLY);
    }
}
