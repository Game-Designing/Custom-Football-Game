package com.mopub.common.privacy;

import com.mopub.common.Preconditions;
import p005cm.aptoide.p006pt.BuildConfig;

public class SyncResponse {

    /* renamed from: a */
    private final boolean f34484a;

    /* renamed from: b */
    private final boolean f34485b;

    /* renamed from: c */
    private final boolean f34486c;

    /* renamed from: d */
    private final boolean f34487d;

    /* renamed from: e */
    private final boolean f34488e;

    /* renamed from: f */
    private final boolean f34489f;

    /* renamed from: g */
    private final String f34490g;

    /* renamed from: h */
    private final String f34491h;

    /* renamed from: i */
    private final String f34492i;

    /* renamed from: j */
    private final String f34493j;

    /* renamed from: k */
    private final String f34494k;

    /* renamed from: l */
    private final String f34495l;

    /* renamed from: m */
    private final String f34496m;

    /* renamed from: n */
    private final String f34497n;

    /* renamed from: o */
    private final String f34498o;

    public static class Builder {

        /* renamed from: a */
        private String f34499a;

        /* renamed from: b */
        private String f34500b;

        /* renamed from: c */
        private String f34501c;

        /* renamed from: d */
        private String f34502d;

        /* renamed from: e */
        private String f34503e;

        /* renamed from: f */
        private String f34504f;

        /* renamed from: g */
        private String f34505g;

        /* renamed from: h */
        private String f34506h;

        /* renamed from: i */
        private String f34507i;

        /* renamed from: j */
        private String f34508j;

        /* renamed from: k */
        private String f34509k;

        /* renamed from: l */
        private String f34510l;

        /* renamed from: m */
        private String f34511m;

        /* renamed from: n */
        private String f34512n;

        /* renamed from: o */
        private String f34513o;

        public Builder setIsGdprRegion(String isGdprRegion) {
            this.f34499a = isGdprRegion;
            return this;
        }

        public Builder setForceExplicitNo(String forceExplicitNo) {
            this.f34500b = forceExplicitNo;
            return this;
        }

        public Builder setInvalidateConsent(String invalidateConsent) {
            this.f34501c = invalidateConsent;
            return this;
        }

        public Builder setReacquireConsent(String reacquireConsent) {
            this.f34502d = reacquireConsent;
            return this;
        }

        public Builder setIsWhitelisted(String isWhitelisted) {
            this.f34503e = isWhitelisted;
            return this;
        }

        public Builder setForceGdprApplies(String forceGdprApplies) {
            this.f34504f = forceGdprApplies;
            return this;
        }

        public Builder setCurrentVendorListVersion(String currentVendorListVersion) {
            this.f34505g = currentVendorListVersion;
            return this;
        }

        public Builder setCurrentVendorListLink(String currentVendorListLink) {
            this.f34506h = currentVendorListLink;
            return this;
        }

        public Builder setCurrentPrivacyPolicyVersion(String currentPrivacyPolicyVersion) {
            this.f34507i = currentPrivacyPolicyVersion;
            return this;
        }

        public Builder setCurrentPrivacyPolicyLink(String currentPrivacyPolicyLink) {
            this.f34508j = currentPrivacyPolicyLink;
            return this;
        }

        public Builder setCurrentVendorListIabFormat(String currentVendorListIabFormat) {
            this.f34509k = currentVendorListIabFormat;
            return this;
        }

        public Builder setCurrentVendorListIabHash(String currentVendorListIabHash) {
            this.f34510l = currentVendorListIabHash;
            return this;
        }

        public Builder setCallAgainAfterSecs(String callAgainAfterSecs) {
            this.f34511m = callAgainAfterSecs;
            return this;
        }

        public Builder setExtras(String extras) {
            this.f34512n = extras;
            return this;
        }

        public Builder setConsentChangeReason(String consentChangeReason) {
            this.f34513o = consentChangeReason;
            return this;
        }

        public SyncResponse build() {
            SyncResponse syncResponse = new SyncResponse(this.f34499a, this.f34500b, this.f34501c, this.f34502d, this.f34503e, this.f34504f, this.f34505g, this.f34506h, this.f34507i, this.f34508j, this.f34509k, this.f34510l, this.f34511m, this.f34512n, this.f34513o);
            return syncResponse;
        }
    }

    public boolean isGdprRegion() {
        return this.f34484a;
    }

    public boolean isForceExplicitNo() {
        return this.f34485b;
    }

    public boolean isInvalidateConsent() {
        return this.f34486c;
    }

    public boolean isReacquireConsent() {
        return this.f34487d;
    }

    public boolean isWhitelisted() {
        return this.f34488e;
    }

    public boolean isForceGdprApplies() {
        return this.f34489f;
    }

    public String getCurrentVendorListVersion() {
        return this.f34490g;
    }

    public String getCurrentVendorListLink() {
        return this.f34491h;
    }

    public String getCurrentPrivacyPolicyVersion() {
        return this.f34492i;
    }

    public String getCurrentPrivacyPolicyLink() {
        return this.f34493j;
    }

    public String getCurrentVendorListIabFormat() {
        return this.f34494k;
    }

    public String getCurrentVendorListIabHash() {
        return this.f34495l;
    }

    public String getCallAgainAfterSecs() {
        return this.f34496m;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo36724a() {
        return this.f34497n;
    }

    public String getConsentChangeReason() {
        return this.f34498o;
    }

    private SyncResponse(String isGdprRegion, String forceExplicitNo, String invalidateConsent, String reacquireConsent, String isWhitelisted, String forceGdprApplies, String currentVendorListVersion, String currentVendorListLink, String currentPrivacyPolicyVersion, String currentPrivacyPolicyLink, String currentVendorListIabFormat, String currentVendorListIabHash, String callAgainAfterSecs, String extras, String consentChangeReason) {
        Preconditions.checkNotNull(isGdprRegion);
        Preconditions.checkNotNull(isWhitelisted);
        Preconditions.checkNotNull(currentVendorListVersion);
        Preconditions.checkNotNull(currentVendorListLink);
        Preconditions.checkNotNull(currentPrivacyPolicyVersion);
        Preconditions.checkNotNull(currentPrivacyPolicyLink);
        Preconditions.checkNotNull(currentVendorListIabHash);
        this.f34484a = !BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID.equals(isGdprRegion);
        String str = "1";
        this.f34485b = str.equals(forceExplicitNo);
        this.f34486c = str.equals(invalidateConsent);
        this.f34487d = str.equals(reacquireConsent);
        this.f34488e = str.equals(isWhitelisted);
        this.f34489f = str.equals(forceGdprApplies);
        this.f34490g = currentVendorListVersion;
        this.f34491h = currentVendorListLink;
        this.f34492i = currentPrivacyPolicyVersion;
        this.f34493j = currentPrivacyPolicyLink;
        this.f34494k = currentVendorListIabFormat;
        this.f34495l = currentVendorListIabHash;
        this.f34496m = callAgainAfterSecs;
        this.f34497n = extras;
        this.f34498o = consentChangeReason;
    }
}
