package com.mopub.mobileads;

import android.content.Context;
import android.content.SharedPreferences;
import com.mopub.common.Constants;
import com.mopub.common.MoPub;
import com.mopub.common.Preconditions;
import com.mopub.common.SharedPreferencesHelper;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.privacy.ConsentData;
import com.mopub.common.privacy.PersonalInfoManager;
import com.mopub.network.TrackingRequest;
import com.mopub.network.TrackingRequest.Listener;

public class MoPubConversionTracker {

    /* renamed from: a */
    private final Context f34832a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final String f34833b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final String f34834c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public SharedPreferences f34835d = SharedPreferencesHelper.getSharedPreferences(this.f34832a);

    public MoPubConversionTracker(Context context) {
        Preconditions.checkNotNull(context);
        this.f34832a = context.getApplicationContext();
        String packageName = this.f34832a.getPackageName();
        StringBuilder sb = new StringBuilder();
        sb.append(packageName);
        sb.append(" wantToTrack");
        this.f34833b = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(packageName);
        sb2.append(" tracked");
        this.f34834c = sb2.toString();
    }

    public void reportAppOpen() {
        reportAppOpen(false);
    }

    public void reportAppOpen(boolean sessionTracker) {
        PersonalInfoManager infoManager = MoPub.getPersonalInformationManager();
        if (infoManager == null) {
            MoPubLog.log(SdkLogEvent.CUSTOM, "Cannot report app open until initialization is done");
        } else if (!sessionTracker && m37424a()) {
            MoPubLog.log(SdkLogEvent.CUSTOM, "Conversion already tracked");
        } else if (sessionTracker || MoPub.canCollectPersonalInformation()) {
            ConsentData consentData = infoManager.getConsentData();
            TrackingRequest.makeTrackingHttpRequest(new C11463w(this.f34832a).withGdprApplies(infoManager.gdprApplies()).withForceGdprApplies(consentData.isForceGdprApplies()).withCurrentConsentStatus(infoManager.getPersonalInfoConsentStatus().getValue()).withConsentedPrivacyPolicyVersion(consentData.getConsentedPrivacyPolicyVersion()).withConsentedVendorListVersion(consentData.getConsentedVendorListVersion()).withSessionTracker(sessionTracker).generateUrlString(Constants.HOST), this.f34832a, (Listener) new C11339P(this));
        } else {
            this.f34835d.edit().putBoolean(this.f34833b, true).apply();
        }
    }

    public boolean shouldTrack() {
        PersonalInfoManager infoManager = MoPub.getPersonalInformationManager();
        boolean z = false;
        if (infoManager == null) {
            return false;
        }
        if (infoManager.canCollectPersonalInformation() && this.f34835d.getBoolean(this.f34833b, false)) {
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    private boolean m37424a() {
        return this.f34835d.getBoolean(this.f34834c, false);
    }
}
