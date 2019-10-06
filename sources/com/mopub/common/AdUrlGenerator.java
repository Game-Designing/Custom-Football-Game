package com.mopub.common;

import android.content.Context;
import android.location.Location;
import android.text.TextUtils;
import com.mopub.common.ClientMetadata.MoPubNetworkType;
import com.mopub.common.privacy.ConsentData;
import com.mopub.common.privacy.PersonalInfoManager;
import com.mopub.common.util.DateAndTime;
import com.mopub.network.RequestRateTracker;
import com.mopub.network.RequestRateTracker.TimeRecord;

public abstract class AdUrlGenerator extends BaseUrlGenerator {

    /* renamed from: c */
    protected Context f34216c;

    /* renamed from: d */
    protected String f34217d;

    /* renamed from: e */
    protected String f34218e;

    /* renamed from: f */
    protected String f34219f;

    /* renamed from: g */
    protected Location f34220g;

    /* renamed from: h */
    private final PersonalInfoManager f34221h = MoPub.getPersonalInformationManager();

    /* renamed from: i */
    private final ConsentData f34222i;

    public AdUrlGenerator(Context context) {
        this.f34216c = context;
        PersonalInfoManager personalInfoManager = this.f34221h;
        if (personalInfoManager == null) {
            this.f34222i = null;
        } else {
            this.f34222i = personalInfoManager.getConsentData();
        }
    }

    public AdUrlGenerator withAdUnitId(String adUnitId) {
        this.f34217d = adUnitId;
        return this;
    }

    public AdUrlGenerator withKeywords(String keywords) {
        this.f34218e = keywords;
        return this;
    }

    public AdUrlGenerator withUserDataKeywords(String userDataKeywords) {
        this.f34219f = userDataKeywords;
        return this;
    }

    public AdUrlGenerator withLocation(Location location) {
        this.f34220g = location;
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo36409d(String adUnitId) {
        mo36451a("id", adUnitId);
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public void mo36421l(String sdkVersion) {
        mo36451a("nv", sdkVersion);
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public void mo36417h(String keywords) {
        mo36451a("q", keywords);
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public void mo36423n(String userDataKeywords) {
        if (MoPub.canCollectPersonalInformation()) {
            mo36451a("user_data_q", userDataKeywords);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo36402a(Location location) {
        if (MoPub.canCollectPersonalInformation()) {
            Location bestLocation = location;
            Location locationFromLocationService = LocationService.getLastKnownLocation(this.f34216c, MoPub.getLocationPrecision(), MoPub.getLocationAwareness());
            if (locationFromLocationService != null && (location == null || locationFromLocationService.getTime() >= location.getTime())) {
                bestLocation = locationFromLocationService;
            }
            if (bestLocation != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(bestLocation.getLatitude());
                sb.append(",");
                sb.append(bestLocation.getLongitude());
                mo36451a("ll", sb.toString());
                mo36451a("lla", String.valueOf((int) bestLocation.getAccuracy()));
                mo36451a("llf", String.valueOf(m36907b(bestLocation)));
                if (bestLocation == locationFromLocationService) {
                    mo36451a("llsdk", "1");
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public void mo36422m(String timeZoneOffsetString) {
        mo36451a("z", timeZoneOffsetString);
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public void mo36420k(String orientation) {
        mo36451a("o", orientation);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo36401a(float density) {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(density);
        mo36451a("sc", sb.toString());
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo36405b(boolean mraid) {
        if (mraid) {
            mo36451a("mr", "1");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public void mo36418i(String networkOperator) {
        String mcc;
        if (networkOperator == null) {
            mcc = "";
        } else {
            mcc = networkOperator.substring(0, m36909o(networkOperator));
        }
        mo36451a("mcc", mcc);
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public void mo36419j(String networkOperator) {
        String mnc;
        if (networkOperator == null) {
            mnc = "";
        } else {
            mnc = networkOperator.substring(m36909o(networkOperator));
        }
        mo36451a("mnc", mnc);
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public void mo36415g(String networkCountryIso) {
        mo36451a("iso", networkCountryIso);
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public void mo36413f(String networkOperatorName) {
        mo36451a("cn", networkOperatorName);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo36403a(MoPubNetworkType networkType) {
        m36906a("ct", networkType);
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo36411e(String bundleId) {
        if (!TextUtils.isEmpty(bundleId)) {
            mo36451a("bundle", bundleId);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo36407c(String vendorKey) {
        Preconditions.checkNotNull(vendorKey);
        mo36451a("vv", vendorKey);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo36406c() {
        mo36451a("abt", MoPub.m550a(this.f34216c));
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public void mo36416h() {
        PersonalInfoManager personalInfoManager = this.f34221h;
        if (personalInfoManager != null) {
            mo36450a("gdpr_applies", personalInfoManager.gdprApplies());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public void mo36414g() {
        ConsentData consentData = this.f34222i;
        if (consentData != null) {
            mo36450a("force_gdpr_applies", Boolean.valueOf(consentData.isForceGdprApplies()));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public void mo36412f() {
        PersonalInfoManager personalInfoManager = this.f34221h;
        if (personalInfoManager != null) {
            mo36451a("current_consent_status", personalInfoManager.getPersonalInfoConsentStatus().getValue());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo36408d() {
        ConsentData consentData = this.f34222i;
        if (consentData != null) {
            mo36451a("consented_privacy_policy_version", consentData.getConsentedPrivacyPolicyVersion());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo36410e() {
        ConsentData consentData = this.f34222i;
        if (consentData != null) {
            mo36451a("consented_vendor_list_version", consentData.getConsentedVendorListVersion());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo36404a(ClientMetadata clientMetadata) {
        mo36409d(this.f34217d);
        mo36421l(clientMetadata.getSdkVersion());
        mo36453a(clientMetadata.getDeviceManufacturer(), clientMetadata.getDeviceModel(), clientMetadata.getDeviceProduct());
        mo36411e(clientMetadata.getAppPackageName());
        mo36417h(this.f34218e);
        if (MoPub.canCollectPersonalInformation()) {
            mo36423n(this.f34219f);
            mo36402a(this.f34220g);
        }
        mo36422m(DateAndTime.getTimeZoneOffsetString());
        mo36420k(clientMetadata.getOrientationString());
        mo36448a(clientMetadata.getDeviceDimensions());
        mo36401a(clientMetadata.getDensity());
        String networkOperator = clientMetadata.getNetworkOperatorForUrl();
        mo36418i(networkOperator);
        mo36419j(networkOperator);
        mo36415g(clientMetadata.getIsoCountryCode());
        mo36413f(clientMetadata.getNetworkOperatorName());
        mo36403a(clientMetadata.getActiveNetworkType());
        mo36455b(clientMetadata.getAppVersion());
        mo36406c();
        mo36447a();
        mo36416h();
        mo36414g();
        mo36412f();
        mo36408d();
        mo36410e();
        m36908i();
    }

    /* renamed from: a */
    private void m36906a(String key, MoPubNetworkType value) {
        mo36451a(key, value.toString());
    }

    /* renamed from: o */
    private int m36909o(String networkOperator) {
        return Math.min(3, networkOperator.length());
    }

    /* renamed from: b */
    private static int m36907b(Location location) {
        Preconditions.checkNotNull(location);
        return (int) (System.currentTimeMillis() - location.getTime());
    }

    /* renamed from: i */
    private void m36908i() {
        TimeRecord record = RequestRateTracker.getInstance().getRecordForAdUnit(this.f34217d);
        if (record != null) {
            int i = record.mBlockIntervalMs;
            if (i >= 1) {
                mo36451a("backoff_ms", String.valueOf(i));
                mo36451a("backoff_reason", record.mReason);
            }
        }
    }

    @Deprecated
    public AdUrlGenerator withFacebookSupported(boolean enabled) {
        return this;
    }
}
