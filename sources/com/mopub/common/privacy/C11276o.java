package com.mopub.common.privacy;

/* renamed from: com.mopub.common.privacy.o */
/* compiled from: PersonalInfoManager */
class C11276o implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ConsentStatusChangeListener f34569a;

    /* renamed from: b */
    final /* synthetic */ ConsentStatus f34570b;

    /* renamed from: c */
    final /* synthetic */ ConsentStatus f34571c;

    /* renamed from: d */
    final /* synthetic */ boolean f34572d;

    /* renamed from: e */
    final /* synthetic */ PersonalInfoManager f34573e;

    C11276o(PersonalInfoManager this$0, ConsentStatusChangeListener consentStatusChangeListener, ConsentStatus consentStatus, ConsentStatus consentStatus2, boolean z) {
        this.f34573e = this$0;
        this.f34569a = consentStatusChangeListener;
        this.f34570b = consentStatus;
        this.f34571c = consentStatus2;
        this.f34572d = z;
    }

    public void run() {
        this.f34569a.onConsentStateChange(this.f34570b, this.f34571c, this.f34572d);
    }
}
