package com.mopub.common.privacy;

import android.content.Context;
import com.mopub.common.BaseUrlGenerator;
import com.mopub.common.ClientMetadata;
import com.mopub.common.Constants;
import com.mopub.common.Preconditions;
import com.mopub.network.PlayServicesUrlRewriter;

public class SyncUrlGenerator extends BaseUrlGenerator {

    /* renamed from: c */
    private final Context f34514c;

    /* renamed from: d */
    private String f34515d;

    /* renamed from: e */
    private String f34516e;

    /* renamed from: f */
    private String f34517f;

    /* renamed from: g */
    private String f34518g;

    /* renamed from: h */
    private final String f34519h;

    /* renamed from: i */
    private String f34520i;

    /* renamed from: j */
    private String f34521j;

    /* renamed from: k */
    private String f34522k;

    /* renamed from: l */
    private String f34523l;

    /* renamed from: m */
    private String f34524m;

    /* renamed from: n */
    private Boolean f34525n;

    /* renamed from: o */
    private boolean f34526o;

    /* renamed from: p */
    private Boolean f34527p;

    public SyncUrlGenerator(Context context, String currentConsentStatus) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(currentConsentStatus);
        this.f34514c = context.getApplicationContext();
        this.f34519h = currentConsentStatus;
    }

    public SyncUrlGenerator withAdUnitId(String adUnitId) {
        this.f34515d = adUnitId;
        return this;
    }

    public SyncUrlGenerator withUdid(String udid) {
        this.f34516e = udid;
        return this;
    }

    public SyncUrlGenerator withGdprApplies(Boolean gdprApplies) {
        this.f34525n = gdprApplies;
        return this;
    }

    public SyncUrlGenerator withForceGdprApplies(boolean forceGdprApplies) {
        this.f34526o = forceGdprApplies;
        return this;
    }

    public SyncUrlGenerator withForceGdprAppliesChanged(Boolean forceGdprAppliesChanged) {
        this.f34527p = forceGdprAppliesChanged;
        return this;
    }

    public SyncUrlGenerator withLastChangedMs(String lastChangedMs) {
        this.f34517f = lastChangedMs;
        return this;
    }

    public SyncUrlGenerator withLastConsentStatus(ConsentStatus lastConsentStatus) {
        this.f34518g = lastConsentStatus == null ? null : lastConsentStatus.getValue();
        return this;
    }

    public SyncUrlGenerator withConsentChangeReason(String consentChangeReason) {
        this.f34520i = consentChangeReason;
        return this;
    }

    public SyncUrlGenerator withConsentedVendorListVersion(String consentedVendorListVersion) {
        this.f34521j = consentedVendorListVersion;
        return this;
    }

    public SyncUrlGenerator withConsentedPrivacyPolicyVersion(String consentedPrivacyPolicyVersion) {
        this.f34522k = consentedPrivacyPolicyVersion;
        return this;
    }

    public SyncUrlGenerator withCachedVendorListIabHash(String cachedVendorListIabHash) {
        this.f34523l = cachedVendorListIabHash;
        return this;
    }

    public SyncUrlGenerator withExtras(String extras) {
        this.f34524m = extras;
        return this;
    }

    public String generateUrlString(String serverHostname) {
        mo36456b(serverHostname, Constants.GDPR_SYNC_HANDLER);
        mo36451a("id", this.f34515d);
        mo36451a("nv", "5.7.1");
        mo36451a("last_changed_ms", this.f34517f);
        mo36451a("last_consent_status", this.f34518g);
        mo36451a("current_consent_status", this.f34519h);
        mo36451a("consent_change_reason", this.f34520i);
        mo36451a("consented_vendor_list_version", this.f34521j);
        mo36451a("consented_privacy_policy_version", this.f34522k);
        mo36451a("cached_vendor_list_iab_hash", this.f34523l);
        mo36451a("extras", this.f34524m);
        mo36451a("udid", this.f34516e);
        mo36450a("gdpr_applies", this.f34525n);
        mo36450a("force_gdpr_applies", Boolean.valueOf(this.f34526o));
        mo36450a("forced_gdpr_applies_changed", this.f34527p);
        mo36451a("bundle", ClientMetadata.getInstance(this.f34514c).getAppPackageName());
        mo36451a("dnt", PlayServicesUrlRewriter.DO_NOT_TRACK_TEMPLATE);
        return mo36454b();
    }
}
