package com.mopub.mobileads;

import android.content.Context;
import com.mopub.common.BaseUrlGenerator;
import com.mopub.common.ClientMetadata;
import com.mopub.common.Constants;

/* renamed from: com.mopub.mobileads.w */
/* compiled from: ConversionUrlGenerator */
class C11463w extends BaseUrlGenerator {

    /* renamed from: c */
    private Context f35441c;

    /* renamed from: d */
    private String f35442d;

    /* renamed from: e */
    private String f35443e;

    /* renamed from: f */
    private String f35444f;

    /* renamed from: g */
    private Boolean f35445g;

    /* renamed from: h */
    private boolean f35446h;

    /* renamed from: i */
    private boolean f35447i;

    C11463w(Context context) {
        this.f35441c = context;
    }

    public C11463w withCurrentConsentStatus(String currentConsentStatus) {
        this.f35442d = currentConsentStatus;
        return this;
    }

    public C11463w withGdprApplies(Boolean gdprApplies) {
        this.f35445g = gdprApplies;
        return this;
    }

    public C11463w withForceGdprApplies(boolean forceGdprApplies) {
        this.f35446h = forceGdprApplies;
        return this;
    }

    public C11463w withConsentedVendorListVersion(String consentedVendorListVersion) {
        this.f35443e = consentedVendorListVersion;
        return this;
    }

    public C11463w withConsentedPrivacyPolicyVersion(String consentedPrivacyPolicyVersion) {
        this.f35444f = consentedPrivacyPolicyVersion;
        return this;
    }

    public C11463w withSessionTracker(boolean st) {
        this.f35447i = st;
        return this;
    }

    public String generateUrlString(String serverHostname) {
        ClientMetadata clientMetadata = ClientMetadata.getInstance(this.f35441c);
        mo36456b(serverHostname, Constants.CONVERSION_TRACKING_HANDLER);
        mo36449a("6");
        mo36455b(clientMetadata.getAppVersion());
        mo36447a();
        mo36451a("id", this.f35441c.getPackageName());
        if (this.f35447i) {
            mo36450a("st", Boolean.valueOf(true));
        }
        mo36451a("nv", "5.7.1");
        mo36451a("current_consent_status", this.f35442d);
        mo36451a("consented_vendor_list_version", this.f35443e);
        mo36451a("consented_privacy_policy_version", this.f35444f);
        mo36450a("gdpr_applies", this.f35445g);
        mo36450a("force_gdpr_applies", Boolean.valueOf(this.f35446h));
        return mo36454b();
    }
}
