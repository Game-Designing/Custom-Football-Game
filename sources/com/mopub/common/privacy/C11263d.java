package com.mopub.common.privacy;

import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.ConsentLogEvent;

/* renamed from: com.mopub.common.privacy.d */
/* compiled from: ConsentDialogController */
class C11263d implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ConsentDialogListener f34531a;

    /* renamed from: b */
    final /* synthetic */ ConsentDialogController f34532b;

    C11263d(ConsentDialogController this$0, ConsentDialogListener consentDialogListener) {
        this.f34532b = this$0;
        this.f34531a = consentDialogListener;
    }

    public void run() {
        MoPubLog.log(ConsentLogEvent.LOAD_SUCCESS, new Object[0]);
        this.f34531a.onConsentDialogLoaded();
    }
}
