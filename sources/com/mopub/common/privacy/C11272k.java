package com.mopub.common.privacy;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.mopub.common.ClientMetadata;
import com.mopub.common.Preconditions;
import com.mopub.common.SharedPreferencesHelper;
import com.mopub.common.VisibleForTesting;
import java.util.Locale;

/* renamed from: com.mopub.common.privacy.k */
/* compiled from: PersonalInfoData */
class C11272k implements ConsentData {

    /* renamed from: a */
    private final Context f34542a;

    /* renamed from: b */
    private String f34543b;

    /* renamed from: c */
    private ConsentStatus f34544c = ConsentStatus.UNKNOWN;

    /* renamed from: d */
    private ConsentStatus f34545d;

    /* renamed from: e */
    private String f34546e;

    /* renamed from: f */
    private boolean f34547f;

    /* renamed from: g */
    private String f34548g;

    /* renamed from: h */
    private String f34549h;

    /* renamed from: i */
    private ConsentStatus f34550i;

    /* renamed from: j */
    private boolean f34551j;

    /* renamed from: k */
    private String f34552k;

    /* renamed from: l */
    private String f34553l;

    /* renamed from: m */
    private String f34554m;

    /* renamed from: n */
    private String f34555n;

    /* renamed from: o */
    private String f34556o;

    /* renamed from: p */
    private String f34557p;

    /* renamed from: q */
    private String f34558q;

    /* renamed from: r */
    private String f34559r;

    /* renamed from: s */
    private String f34560s;

    /* renamed from: t */
    private String f34561t;

    /* renamed from: u */
    private boolean f34562u;

    /* renamed from: v */
    private Boolean f34563v;

    C11272k(Context context, String adUnitId) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(adUnitId);
        this.f34542a = context.getApplicationContext();
        m37153m();
        this.f34543b = adUnitId;
    }

    /* renamed from: m */
    private void m37153m() {
        SharedPreferences sharedPreferences = SharedPreferencesHelper.getSharedPreferences(this.f34542a, "com.mopub.privacy");
        this.f34543b = sharedPreferences.getString("info/adunit", "");
        this.f34544c = ConsentStatus.fromString(sharedPreferences.getString("info/consent_status", ConsentStatus.UNKNOWN.name()));
        String lastSuccessfullySyncedConsentStatusString = sharedPreferences.getString("info/last_successfully_synced_consent_status", null);
        if (TextUtils.isEmpty(lastSuccessfullySyncedConsentStatusString)) {
            this.f34545d = null;
        } else {
            this.f34545d = ConsentStatus.fromString(lastSuccessfullySyncedConsentStatusString);
        }
        this.f34551j = sharedPreferences.getBoolean("info/is_whitelisted", false);
        this.f34552k = sharedPreferences.getString("info/current_vendor_list_version", null);
        this.f34553l = sharedPreferences.getString("info/current_vendor_list_link", null);
        this.f34554m = sharedPreferences.getString("info/current_privacy_policy_version", null);
        this.f34555n = sharedPreferences.getString("info/current_privacy_policy_link", null);
        this.f34556o = sharedPreferences.getString("info/current_vendor_list_iab_format", null);
        this.f34557p = sharedPreferences.getString("info/current_vendor_list_iab_hash", null);
        this.f34558q = sharedPreferences.getString("info/consented_vendor_list_version", null);
        this.f34559r = sharedPreferences.getString("info/consented_privacy_policy_version", null);
        this.f34560s = sharedPreferences.getString("info/consented_vendor_list_iab_format", null);
        this.f34561t = sharedPreferences.getString("info/extras", null);
        this.f34546e = sharedPreferences.getString("info/consent_change_reason", null);
        this.f34562u = sharedPreferences.getBoolean("info/reacquire_consent", false);
        String gdprAppliesString = sharedPreferences.getString("info/gdpr_applies", null);
        if (TextUtils.isEmpty(gdprAppliesString)) {
            this.f34563v = null;
        } else {
            this.f34563v = Boolean.valueOf(Boolean.parseBoolean(gdprAppliesString));
        }
        this.f34547f = sharedPreferences.getBoolean("info/force_gdpr_applies", false);
        this.f34548g = sharedPreferences.getString("info/udid", null);
        this.f34549h = sharedPreferences.getString("info/last_changed_ms", null);
        String consentStatusBeforeDnt = sharedPreferences.getString("info/consent_status_before_dnt", null);
        if (TextUtils.isEmpty(consentStatusBeforeDnt)) {
            this.f34550i = null;
        } else {
            this.f34550i = ConsentStatus.fromString(consentStatusBeforeDnt);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: l */
    public void mo36809l() {
        String str;
        String str2;
        Editor editor = SharedPreferencesHelper.getSharedPreferences(this.f34542a, "com.mopub.privacy").edit();
        editor.putString("info/adunit", this.f34543b);
        editor.putString("info/consent_status", this.f34544c.name());
        ConsentStatus consentStatus = this.f34545d;
        String str3 = null;
        if (consentStatus == null) {
            str = null;
        } else {
            str = consentStatus.name();
        }
        editor.putString("info/last_successfully_synced_consent_status", str);
        editor.putBoolean("info/is_whitelisted", this.f34551j);
        editor.putString("info/current_vendor_list_version", this.f34552k);
        editor.putString("info/current_vendor_list_link", this.f34553l);
        editor.putString("info/current_privacy_policy_version", this.f34554m);
        editor.putString("info/current_privacy_policy_link", this.f34555n);
        editor.putString("info/current_vendor_list_iab_format", this.f34556o);
        editor.putString("info/current_vendor_list_iab_hash", this.f34557p);
        editor.putString("info/consented_vendor_list_version", this.f34558q);
        editor.putString("info/consented_privacy_policy_version", this.f34559r);
        editor.putString("info/consented_vendor_list_iab_format", this.f34560s);
        editor.putString("info/extras", this.f34561t);
        editor.putString("info/consent_change_reason", this.f34546e);
        editor.putBoolean("info/reacquire_consent", this.f34562u);
        Boolean bool = this.f34563v;
        if (bool == null) {
            str2 = null;
        } else {
            str2 = bool.toString();
        }
        editor.putString("info/gdpr_applies", str2);
        editor.putBoolean("info/force_gdpr_applies", this.f34547f);
        editor.putString("info/udid", this.f34548g);
        editor.putString("info/last_changed_ms", this.f34549h);
        ConsentStatus consentStatus2 = this.f34550i;
        if (consentStatus2 != null) {
            str3 = consentStatus2.name();
        }
        editor.putString("info/consent_status_before_dnt", str3);
        editor.apply();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo36779a() {
        return this.f34543b;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public ConsentStatus mo36788c() {
        return this.f34544c;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo36780a(ConsentStatus consentStatus) {
        this.f34544c = consentStatus;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public ConsentStatus mo36801h() {
        return this.f34545d;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo36789c(ConsentStatus lastSuccessfullySyncedConsentStatus) {
        this.f34545d = lastSuccessfullySyncedConsentStatus;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public boolean mo36806j() {
        return this.f34551j;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo36791c(boolean whitelisted) {
        this.f34551j = whitelisted;
    }

    public String getCurrentVendorListVersion() {
        return this.f34552k;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public void mo36805j(String currentVendorListVersion) {
        this.f34552k = currentVendorListVersion;
    }

    public String getCurrentVendorListLink() {
        return getCurrentVendorListLink(null);
    }

    public String getCurrentVendorListLink(String language) {
        return m37152a(this.f34553l, this.f34542a, language);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public void mo36804i(String currentVendorListLink) {
        this.f34553l = currentVendorListLink;
    }

    public String getCurrentPrivacyPolicyVersion() {
        return this.f34554m;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public void mo36797f(String currentPrivacyPolicyVersion) {
        this.f34554m = currentPrivacyPolicyVersion;
    }

    public String getCurrentPrivacyPolicyLink() {
        return getCurrentPrivacyPolicyLink(null);
    }

    public String getCurrentPrivacyPolicyLink(String language) {
        return m37152a(this.f34555n, this.f34542a, language);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public void mo36795e(String currentPrivacyPolicyLink) {
        this.f34555n = currentPrivacyPolicyLink;
    }

    public String getCurrentVendorListIabFormat() {
        return this.f34556o;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public void mo36799g(String currentVendorListIabFormat) {
        this.f34556o = currentVendorListIabFormat;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public String mo36794e() {
        return this.f34557p;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public void mo36802h(String currentVendorListIabHash) {
        this.f34557p = currentVendorListIabHash;
    }

    public String getConsentedVendorListVersion() {
        return this.f34558q;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo36793d(String consentedVendorListVersion) {
        this.f34558q = consentedVendorListVersion;
    }

    public String getConsentedPrivacyPolicyVersion() {
        return this.f34559r;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo36786b(String consentedPrivacyPolicyVersion) {
        this.f34559r = consentedPrivacyPolicyVersion;
    }

    public String getConsentedVendorListIabFormat() {
        return this.f34560s;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo36790c(String consentedVendorListIabFormat) {
        this.f34560s = consentedVendorListIabFormat;
    }

    public String getExtras() {
        return this.f34561t;
    }

    public void setExtras(String extras) {
        this.f34561t = extras;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public String mo36784b() {
        return this.f34546e;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo36782a(String consentChangeReason) {
        this.f34546e = consentChangeReason;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: k */
    public boolean mo36808k() {
        return this.f34562u;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo36787b(boolean reacquireConsent) {
        this.f34562u = reacquireConsent;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public Boolean mo36796f() {
        return this.f34563v;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo36781a(Boolean gdprApplies) {
        this.f34563v = gdprApplies;
    }

    public boolean isForceGdprApplies() {
        return this.f34547f;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo36783a(boolean forceGdprApplies) {
        this.f34547f = forceGdprApplies;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public String mo36803i() {
        return this.f34548g;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: l */
    public void mo36810l(String udid) {
        this.f34548g = udid;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public String mo36798g() {
        return this.f34549h;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: k */
    public void mo36807k(String lastChangedMs) {
        this.f34549h = lastChangedMs;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public ConsentStatus mo36792d() {
        return this.f34550i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo36785b(ConsentStatus consentStatusBeforeDnt) {
        this.f34550i = consentStatusBeforeDnt;
    }

    @VisibleForTesting
    /* renamed from: a */
    static String m37152a(String input, Context context, String language) {
        Preconditions.checkNotNull(context);
        if (TextUtils.isEmpty(input)) {
            return "";
        }
        return input.replaceAll("%%LANGUAGE%%", m37151a(context, language));
    }

    /* renamed from: a */
    private static String m37151a(Context context, String language) {
        String[] iSOLanguages;
        Preconditions.checkNotNull(context);
        for (String isoLanguage : Locale.getISOLanguages()) {
            if (isoLanguage != null && isoLanguage.equals(language)) {
                return language;
            }
        }
        return ClientMetadata.getCurrentLanguage(context);
    }
}
