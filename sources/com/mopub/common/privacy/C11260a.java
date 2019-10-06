package com.mopub.common.privacy;

/* renamed from: com.mopub.common.privacy.a */
/* compiled from: ConsentDialogActivity */
class C11260a implements C11268a {

    /* renamed from: a */
    final /* synthetic */ ConsentDialogActivity f34528a;

    C11260a(ConsentDialogActivity this$0) {
        this.f34528a = this$0;
    }

    public void onConsentClick(ConsentStatus status) {
        this.f34528a.m37097a(status);
        this.f34528a.mo36669a(false);
    }

    public void onCloseClick() {
        this.f34528a.finish();
    }
}
