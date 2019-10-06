package com.mopub.common.privacy;

import android.text.TextUtils;
import com.mopub.common.Preconditions;
import com.mopub.common.privacy.MoPubIdentifier.AdvertisingIdChangeListener;

/* renamed from: com.mopub.common.privacy.l */
/* compiled from: PersonalInfoManager */
class C11273l implements AdvertisingIdChangeListener {

    /* renamed from: a */
    final /* synthetic */ PersonalInfoManager f34564a;

    C11273l(PersonalInfoManager this$0) {
        this.f34564a = this$0;
    }

    public void onIdChanged(AdvertisingId oldId, AdvertisingId newId) {
        Preconditions.checkNotNull(oldId);
        Preconditions.checkNotNull(newId);
        if (oldId.isDoNotTrack() && newId.isDoNotTrack()) {
            return;
        }
        if (!oldId.isDoNotTrack() && newId.isDoNotTrack()) {
            this.f34564a.m37122a(ConsentStatus.DNT, ConsentChangeReason.DENIED_BY_DNT_ON);
            this.f34564a.requestSync(true);
        } else if (!oldId.isDoNotTrack() || newId.isDoNotTrack()) {
            if (!TextUtils.isEmpty(newId.f34432b) && !newId.mo36649d().equals(this.f34564a.f34466c.mo36803i()) && ConsentStatus.EXPLICIT_YES.equals(this.f34564a.f34466c.mo36788c())) {
                this.f34564a.f34466c.mo36789c((ConsentStatus) null);
                this.f34564a.f34466c.mo36807k(null);
                this.f34564a.m37122a(ConsentStatus.UNKNOWN, ConsentChangeReason.IFA_CHANGED);
            }
        } else if (ConsentStatus.EXPLICIT_NO.equals(this.f34564a.f34466c.mo36792d())) {
            this.f34564a.m37122a(ConsentStatus.EXPLICIT_NO, ConsentChangeReason.DNT_OFF);
        } else {
            this.f34564a.m37122a(ConsentStatus.UNKNOWN, ConsentChangeReason.DNT_OFF);
        }
    }
}
