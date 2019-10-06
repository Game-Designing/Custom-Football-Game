package com.mopub.common.privacy;

import android.content.Context;
import com.mopub.common.BaseUrlGenerator;
import com.mopub.common.ClientMetadata;
import com.mopub.common.Constants;
import com.mopub.common.Preconditions;

public class ConsentDialogUrlGenerator extends BaseUrlGenerator {

    /* renamed from: c */
    private final Context f34448c;

    /* renamed from: d */
    private final String f34449d;

    /* renamed from: e */
    private final String f34450e;

    /* renamed from: f */
    private Boolean f34451f;

    /* renamed from: g */
    private boolean f34452g;

    /* renamed from: h */
    private String f34453h;

    /* renamed from: i */
    private String f34454i;

    ConsentDialogUrlGenerator(Context context, String adUnitId, String currentConsentStatus) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(adUnitId);
        Preconditions.checkNotNull(currentConsentStatus);
        this.f34448c = context.getApplicationContext();
        this.f34449d = adUnitId;
        this.f34450e = currentConsentStatus;
    }

    /* access modifiers changed from: protected */
    public ConsentDialogUrlGenerator withGdprApplies(Boolean gdprApplies) {
        this.f34451f = gdprApplies;
        return this;
    }

    /* access modifiers changed from: protected */
    public ConsentDialogUrlGenerator withForceGdprApplies(boolean forceGdprApplies) {
        this.f34452g = forceGdprApplies;
        return this;
    }

    /* access modifiers changed from: protected */
    public ConsentDialogUrlGenerator withConsentedVendorListVersion(String consentedVendorListVersion) {
        this.f34453h = consentedVendorListVersion;
        return this;
    }

    /* access modifiers changed from: protected */
    public ConsentDialogUrlGenerator withConsentedPrivacyPolicyVersion(String consentedPrivacyPolicyVersion) {
        this.f34454i = consentedPrivacyPolicyVersion;
        return this;
    }

    public String generateUrlString(String serverHostname) {
        mo36456b(serverHostname, Constants.GDPR_CONSENT_HANDLER);
        mo36451a("id", this.f34449d);
        mo36451a("current_consent_status", this.f34450e);
        mo36451a("nv", "5.7.1");
        mo36451a("language", ClientMetadata.getCurrentLanguage(this.f34448c));
        mo36450a("gdpr_applies", this.f34451f);
        mo36450a("force_gdpr_applies", Boolean.valueOf(this.f34452g));
        mo36451a("consented_vendor_list_version", this.f34453h);
        mo36451a("consented_privacy_policy_version", this.f34454i);
        mo36451a("bundle", ClientMetadata.getInstance(this.f34448c).getAppPackageName());
        return mo36454b();
    }
}
