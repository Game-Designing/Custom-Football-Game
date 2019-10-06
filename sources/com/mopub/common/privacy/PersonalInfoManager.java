package com.mopub.common.privacy;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.mopub.common.ClientMetadata;
import com.mopub.common.Constants;
import com.mopub.common.MoPub;
import com.mopub.common.Preconditions;
import com.mopub.common.SdkInitializationListener;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.ConsentLogEvent;
import com.mopub.common.privacy.MoPubIdentifier.AdvertisingIdChangeListener;
import com.mopub.common.privacy.SyncRequest.Listener;
import com.mopub.common.util.ManifestUtils;
import com.mopub.mobileads.MoPubConversionTracker;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.network.MoPubNetworkError;
import com.mopub.network.MultiAdResponse;
import com.mopub.network.MultiAdResponse.ServerOverrideListener;
import com.mopub.network.Networking;
import com.mopub.volley.VolleyError;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class PersonalInfoManager {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Context f34464a;

    /* renamed from: b */
    private final Set<ConsentStatusChangeListener> f34465b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final C11272k f34466c;

    /* renamed from: d */
    private final ConsentDialogController f34467d;

    /* renamed from: e */
    private final MoPubConversionTracker f34468e;

    /* renamed from: f */
    private final Listener f34469f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public ServerOverrideListener f34470g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public SdkInitializationListener f34471h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public long f34472i = 300000;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public Long f34473j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public ConsentStatus f34474k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f34475l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public boolean f34476m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f34477n;

    /* renamed from: o */
    private boolean f34478o;

    /* renamed from: com.mopub.common.privacy.PersonalInfoManager$a */
    private class C11258a implements ServerOverrideListener {
        private C11258a() {
        }

        /* synthetic */ C11258a(PersonalInfoManager x0, C11273l x1) {
            this();
        }

        public void onForceExplicitNo(String consentChangeReason) {
            if (TextUtils.isEmpty(consentChangeReason)) {
                PersonalInfoManager.this.m37122a(ConsentStatus.EXPLICIT_NO, ConsentChangeReason.REVOKED_BY_SERVER);
            } else {
                PersonalInfoManager.this.mo36700a(ConsentStatus.EXPLICIT_NO, consentChangeReason);
            }
        }

        public void onInvalidateConsent(String consentChangeReason) {
            if (TextUtils.isEmpty(consentChangeReason)) {
                PersonalInfoManager.this.m37122a(ConsentStatus.UNKNOWN, ConsentChangeReason.REACQUIRE_BY_SERVER);
            } else {
                PersonalInfoManager.this.mo36700a(ConsentStatus.UNKNOWN, consentChangeReason);
            }
        }

        public void onReacquireConsent(String consentChangeReason) {
            if (!TextUtils.isEmpty(consentChangeReason)) {
                PersonalInfoManager.this.f34466c.mo36782a(consentChangeReason);
            }
            PersonalInfoManager.this.f34466c.mo36787b(true);
            PersonalInfoManager.this.f34466c.mo36809l();
        }

        public void onForceGdprApplies() {
            PersonalInfoManager.this.forceGdprApplies();
        }
    }

    /* renamed from: com.mopub.common.privacy.PersonalInfoManager$b */
    private class C11259b implements Listener {
        private C11259b() {
        }

        /* synthetic */ C11259b(PersonalInfoManager x0, C11273l x1) {
            this();
        }

        public void onSuccess(SyncResponse response) {
            MoPubLog.log(ConsentLogEvent.SYNC_COMPLETED, new Object[0]);
            boolean oldCanCollectPersonalInformation = PersonalInfoManager.this.canCollectPersonalInformation();
            if (PersonalInfoManager.this.f34466c.mo36796f() == null) {
                PersonalInfoManager.this.f34466c.mo36781a(Boolean.valueOf(response.isGdprRegion()));
            }
            if (response.isForceGdprApplies()) {
                PersonalInfoManager.this.f34476m = true;
                PersonalInfoManager.this.f34466c.mo36783a(true);
                boolean newCanCollectPersonalInformation = PersonalInfoManager.this.canCollectPersonalInformation();
                if (oldCanCollectPersonalInformation != newCanCollectPersonalInformation) {
                    PersonalInfoManager personalInfoManager = PersonalInfoManager.this;
                    personalInfoManager.m37123a(personalInfoManager.f34466c.mo36788c(), PersonalInfoManager.this.f34466c.mo36788c(), newCanCollectPersonalInformation);
                }
            }
            PersonalInfoManager.this.f34466c.mo36789c(PersonalInfoManager.this.f34474k);
            PersonalInfoManager.this.f34466c.mo36791c(response.isWhitelisted());
            PersonalInfoManager.this.f34466c.mo36805j(response.getCurrentVendorListVersion());
            PersonalInfoManager.this.f34466c.mo36804i(response.getCurrentVendorListLink());
            PersonalInfoManager.this.f34466c.mo36797f(response.getCurrentPrivacyPolicyVersion());
            PersonalInfoManager.this.f34466c.mo36795e(response.getCurrentPrivacyPolicyLink());
            String iabHash = response.getCurrentVendorListIabHash();
            String iabFormat = response.getCurrentVendorListIabFormat();
            if (!TextUtils.isEmpty(iabHash) && !iabHash.equals(PersonalInfoManager.this.f34466c.mo36794e()) && !TextUtils.isEmpty(iabFormat)) {
                PersonalInfoManager.this.f34466c.mo36799g(iabFormat);
                PersonalInfoManager.this.f34466c.mo36802h(iabHash);
            }
            String extras = response.mo36724a();
            if (!TextUtils.isEmpty(extras)) {
                PersonalInfoManager.this.f34466c.setExtras(extras);
            }
            String consentChangeReason = response.getConsentChangeReason();
            if (response.isForceExplicitNo()) {
                PersonalInfoManager.this.f34470g.onForceExplicitNo(consentChangeReason);
            } else if (response.isInvalidateConsent()) {
                PersonalInfoManager.this.f34470g.onInvalidateConsent(consentChangeReason);
            } else if (response.isReacquireConsent()) {
                PersonalInfoManager.this.f34470g.onReacquireConsent(consentChangeReason);
            }
            String callAgainAfterSecs = response.getCallAgainAfterSecs();
            if (!TextUtils.isEmpty(callAgainAfterSecs)) {
                try {
                    long callAgainAfterSecsLong = Long.parseLong(callAgainAfterSecs);
                    if (callAgainAfterSecsLong > 0) {
                        PersonalInfoManager.this.f34472i = 1000 * callAgainAfterSecsLong;
                    } else {
                        ConsentLogEvent consentLogEvent = ConsentLogEvent.CUSTOM;
                        StringBuilder sb = new StringBuilder();
                        sb.append("callAgainAfterSecs is not positive: ");
                        sb.append(callAgainAfterSecs);
                        MoPubLog.log(consentLogEvent, sb.toString());
                    }
                } catch (NumberFormatException e) {
                    MoPubLog.log(ConsentLogEvent.CUSTOM, "Unable to parse callAgainAfterSecs. Ignoring value");
                }
            }
            if (!ConsentStatus.EXPLICIT_YES.equals(PersonalInfoManager.this.f34474k)) {
                PersonalInfoManager.this.f34466c.mo36810l(null);
            }
            if (PersonalInfoManager.this.f34477n) {
                PersonalInfoManager.this.f34476m = false;
                PersonalInfoManager.this.f34477n = false;
            }
            PersonalInfoManager.this.f34466c.mo36809l();
            PersonalInfoManager.this.f34475l = false;
            if (ConsentStatus.POTENTIAL_WHITELIST.equals(PersonalInfoManager.this.f34474k) && PersonalInfoManager.this.f34466c.mo36806j()) {
                PersonalInfoManager.this.m37122a(ConsentStatus.EXPLICIT_YES, ConsentChangeReason.GRANTED_BY_WHITELISTED_PUB);
                PersonalInfoManager.this.requestSync(true);
            }
            if (PersonalInfoManager.this.f34471h != null) {
                PersonalInfoManager.this.f34471h.onInitializationFinished();
                PersonalInfoManager.this.f34471h = null;
            }
        }

        public void onErrorResponse(VolleyError volleyError) {
            int reason;
            String message;
            if (volleyError instanceof MoPubNetworkError) {
                reason = ((MoPubNetworkError) volleyError).getReason().ordinal();
            } else {
                reason = MoPubErrorCode.UNSPECIFIED.getIntCode();
            }
            if (volleyError instanceof MoPubNetworkError) {
                message = volleyError.getMessage();
            } else {
                message = MoPubErrorCode.UNSPECIFIED.toString();
            }
            MoPubLog.log(ConsentLogEvent.SYNC_FAILED, Integer.valueOf(reason), message);
            PersonalInfoManager.this.f34475l = false;
            if (PersonalInfoManager.this.f34471h != null) {
                MoPubLog.log(ConsentLogEvent.CUSTOM, "Personal Info Manager initialization finished but ran into errors.");
                PersonalInfoManager.this.f34471h.onInitializationFinished();
                PersonalInfoManager.this.f34471h = null;
            }
        }
    }

    public PersonalInfoManager(Context context, String adUnitId, SdkInitializationListener sdkInitializationListener) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(adUnitId);
        this.f34464a = context.getApplicationContext();
        this.f34465b = Collections.synchronizedSet(new HashSet());
        this.f34469f = new C11259b(this, null);
        this.f34470g = new C11258a(this, null);
        MultiAdResponse.setServerOverrideListener(this.f34470g);
        this.f34467d = new ConsentDialogController(this.f34464a);
        this.f34466c = new C11272k(this.f34464a, adUnitId);
        this.f34468e = new MoPubConversionTracker(this.f34464a);
        AdvertisingIdChangeListener advertisingIdChangeListener = new C11273l(this);
        this.f34471h = sdkInitializationListener;
        MoPubIdentifier moPubIdentifier = ClientMetadata.getInstance(this.f34464a).getMoPubIdentifier();
        moPubIdentifier.setIdChangeListener(advertisingIdChangeListener);
        moPubIdentifier.mo36690a(m37128b());
    }

    public boolean shouldShowConsentDialog() {
        if (gdprApplies() == null || !gdprApplies().booleanValue() || ClientMetadata.getInstance(this.f34464a).getMoPubIdentifier().getAdvertisingInfo().isDoNotTrack()) {
            return false;
        }
        if (!this.f34466c.mo36808k() || !this.f34466c.mo36788c().equals(ConsentStatus.EXPLICIT_YES)) {
            return this.f34466c.mo36788c().equals(ConsentStatus.UNKNOWN);
        }
        return true;
    }

    public boolean isConsentDialogReady() {
        return this.f34467d.mo36676a();
    }

    public void loadConsentDialog(ConsentDialogListener consentDialogListener) {
        MoPubLog.log(ConsentLogEvent.LOAD_ATTEMPTED, new Object[0]);
        ManifestUtils.checkGdprActivitiesDeclared(this.f34464a);
        if (ClientMetadata.getInstance(this.f34464a).getMoPubIdentifier().getAdvertisingInfo().isDoNotTrack()) {
            if (consentDialogListener != null) {
                new Handler().post(new C11274m(this, consentDialogListener));
            }
            return;
        }
        Boolean gdprApplies = gdprApplies();
        if (gdprApplies == null || gdprApplies.booleanValue()) {
            this.f34467d.mo36675a(consentDialogListener, gdprApplies, this.f34466c);
            return;
        }
        if (consentDialogListener != null) {
            new Handler().post(new C11275n(this, consentDialogListener));
        }
    }

    public boolean showConsentDialog() {
        return this.f34467d.mo36677b();
    }

    public boolean canCollectPersonalInformation() {
        Boolean gdprApplies = gdprApplies();
        boolean z = false;
        if (gdprApplies == null) {
            return false;
        }
        if (!gdprApplies.booleanValue()) {
            return true;
        }
        if (getPersonalInfoConsentStatus().equals(ConsentStatus.EXPLICIT_YES) && !ClientMetadata.getInstance(this.f34464a).getMoPubIdentifier().getAdvertisingInfo().isDoNotTrack()) {
            z = true;
        }
        return z;
    }

    public void setAllowLegitimateInterest(boolean allowed) {
        this.f34478o = allowed;
    }

    public boolean shouldAllowLegitimateInterest() {
        return this.f34478o;
    }

    public Boolean gdprApplies() {
        if (this.f34466c.isForceGdprApplies()) {
            return Boolean.valueOf(true);
        }
        return this.f34466c.mo36796f();
    }

    public void forceGdprApplies() {
        if (!this.f34466c.isForceGdprApplies()) {
            boolean oldCanCollectPersonalInformation = canCollectPersonalInformation();
            this.f34466c.mo36783a(true);
            this.f34476m = true;
            this.f34466c.mo36809l();
            boolean newCanCollectPersonalInformation = canCollectPersonalInformation();
            if (oldCanCollectPersonalInformation != newCanCollectPersonalInformation) {
                m37123a(this.f34466c.mo36788c(), this.f34466c.mo36788c(), newCanCollectPersonalInformation);
            }
            requestSync(true);
        }
    }

    public ConsentStatus getPersonalInfoConsentStatus() {
        return this.f34466c.mo36788c();
    }

    public void grantConsent() {
        if (ClientMetadata.getInstance(this.f34464a).getMoPubIdentifier().getAdvertisingInfo().isDoNotTrack()) {
            MoPubLog.log(ConsentLogEvent.CUSTOM, "Cannot grant consent because Do Not Track is on.");
            return;
        }
        if (this.f34466c.mo36806j()) {
            m37122a(ConsentStatus.EXPLICIT_YES, ConsentChangeReason.GRANTED_BY_WHITELISTED_PUB);
        } else {
            MoPubLog.log(ConsentLogEvent.CUSTOM, "You do not have approval to use the grantConsent API. Please reach out to your account teams or support@mopub.com for more information.");
            m37122a(ConsentStatus.POTENTIAL_WHITELIST, ConsentChangeReason.GRANTED_BY_NOT_WHITELISTED_PUB);
        }
        requestSync(true);
    }

    public void revokeConsent() {
        if (ClientMetadata.getInstance(this.f34464a).getMoPubIdentifier().getAdvertisingInfo().isDoNotTrack()) {
            MoPubLog.log(ConsentLogEvent.CUSTOM, "Cannot revoke consent because Do Not Track is on.");
            return;
        }
        m37122a(ConsentStatus.EXPLICIT_NO, ConsentChangeReason.DENIED_BY_PUB);
        requestSync(true);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo36699a(ConsentStatus consentStatus) {
        Preconditions.checkNotNull(consentStatus);
        int i = C11278q.f34575a[consentStatus.ordinal()];
        if (i == 1) {
            m37122a(consentStatus, ConsentChangeReason.GRANTED_BY_USER);
            requestSync(true);
        } else if (i != 2) {
            ConsentLogEvent consentLogEvent = ConsentLogEvent.CUSTOM;
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid consent status: ");
            sb.append(consentStatus);
            sb.append(". This is a bug with the use of changeConsentStateFromDialog.");
            MoPubLog.log(consentLogEvent, sb.toString());
        } else {
            m37122a(consentStatus, ConsentChangeReason.DENIED_BY_USER);
            requestSync(true);
        }
    }

    public void subscribeConsentStatusChangeListener(ConsentStatusChangeListener consentStatusChangeListener) {
        if (consentStatusChangeListener != null) {
            this.f34465b.add(consentStatusChangeListener);
        }
    }

    public void unsubscribeConsentStatusChangeListener(ConsentStatusChangeListener consentStatusChangeListener) {
        this.f34465b.remove(consentStatusChangeListener);
    }

    @VisibleForTesting
    /* renamed from: a */
    static boolean m37127a(boolean syncRequestInFlight, Boolean gdprApplies, boolean force, Long lastSyncRequestTimeMs, long syncDelay, String udid, boolean dnt) {
        boolean z = false;
        if (syncRequestInFlight) {
            return false;
        }
        if (gdprApplies == null) {
            return true;
        }
        if (!gdprApplies.booleanValue()) {
            return false;
        }
        if (force) {
            return true;
        }
        if (dnt && TextUtils.isEmpty(udid)) {
            return false;
        }
        if (lastSyncRequestTimeMs == null) {
            return true;
        }
        if (SystemClock.uptimeMillis() - lastSyncRequestTimeMs.longValue() > syncDelay) {
            z = true;
        }
        return z;
    }

    public void requestSync(boolean force) {
        if (MoPub.isSdkInitialized()) {
            if (m37127a(this.f34475l, gdprApplies(), force, this.f34473j, this.f34472i, this.f34466c.mo36803i(), ClientMetadata.getInstance(this.f34464a).getMoPubIdentifier().getAdvertisingInfo().isDoNotTrack())) {
                mo36698a();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: a */
    public void mo36698a() {
        MoPubLog.log(ConsentLogEvent.SYNC_ATTEMPTED, new Object[0]);
        this.f34474k = this.f34466c.mo36788c();
        this.f34475l = true;
        this.f34473j = Long.valueOf(SystemClock.uptimeMillis());
        SyncUrlGenerator syncUrlGenerator = new SyncUrlGenerator(this.f34464a, this.f34474k.getValue());
        syncUrlGenerator.withAdUnitId(this.f34466c.mo36779a()).withUdid(this.f34466c.mo36803i()).withLastChangedMs(this.f34466c.mo36798g()).withLastConsentStatus(this.f34466c.mo36801h()).withConsentChangeReason(this.f34466c.mo36784b()).withConsentedVendorListVersion(this.f34466c.getConsentedVendorListVersion()).withConsentedPrivacyPolicyVersion(this.f34466c.getConsentedPrivacyPolicyVersion()).withCachedVendorListIabHash(this.f34466c.mo36794e()).withExtras(this.f34466c.getExtras()).withGdprApplies(gdprApplies()).withForceGdprApplies(this.f34466c.isForceGdprApplies());
        if (this.f34476m) {
            this.f34477n = true;
            syncUrlGenerator.withForceGdprAppliesChanged(Boolean.valueOf(true));
        }
        Networking.getRequestQueue(this.f34464a).add(new SyncRequest(this.f34464a, syncUrlGenerator.generateUrlString(Constants.HOST), this.f34469f));
    }

    public ConsentData getConsentData() {
        return new C11272k(this.f34464a, this.f34466c.mo36779a());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m37122a(ConsentStatus newConsentStatus, ConsentChangeReason consentChangeReason) {
        mo36700a(newConsentStatus, consentChangeReason.getReason());
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: a */
    public void mo36700a(ConsentStatus newConsentStatus, String consentChangeReason) {
        Preconditions.checkNotNull(newConsentStatus);
        Preconditions.checkNotNull(consentChangeReason);
        ConsentStatus oldConsentStatus = this.f34466c.mo36788c();
        if (oldConsentStatus.equals(newConsentStatus)) {
            ConsentLogEvent consentLogEvent = ConsentLogEvent.CUSTOM;
            StringBuilder sb = new StringBuilder();
            sb.append("Consent status is already ");
            sb.append(oldConsentStatus);
            sb.append(". Not doing a state transition.");
            MoPubLog.log(consentLogEvent, sb.toString());
            return;
        }
        C11272k kVar = this.f34466c;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("");
        sb2.append(Calendar.getInstance().getTimeInMillis());
        kVar.mo36807k(sb2.toString());
        this.f34466c.mo36782a(consentChangeReason);
        this.f34466c.mo36780a(newConsentStatus);
        if (ConsentStatus.POTENTIAL_WHITELIST.equals(newConsentStatus) || (!ConsentStatus.POTENTIAL_WHITELIST.equals(oldConsentStatus) && ConsentStatus.EXPLICIT_YES.equals(newConsentStatus))) {
            C11272k kVar2 = this.f34466c;
            kVar2.mo36786b(kVar2.getCurrentPrivacyPolicyVersion());
            C11272k kVar3 = this.f34466c;
            kVar3.mo36793d(kVar3.getCurrentVendorListVersion());
            C11272k kVar4 = this.f34466c;
            kVar4.mo36790c(kVar4.getCurrentVendorListIabFormat());
        }
        if (ConsentStatus.DNT.equals(newConsentStatus) || ConsentStatus.EXPLICIT_NO.equals(newConsentStatus) || ConsentStatus.UNKNOWN.equals(newConsentStatus)) {
            this.f34466c.mo36786b((String) null);
            this.f34466c.mo36793d(null);
            this.f34466c.mo36790c((String) null);
        }
        if (ConsentStatus.EXPLICIT_YES.equals(newConsentStatus)) {
            this.f34466c.mo36810l(ClientMetadata.getInstance(this.f34464a).getMoPubIdentifier().getAdvertisingInfo().mo36649d());
        }
        if (ConsentStatus.DNT.equals(newConsentStatus)) {
            this.f34466c.mo36785b(oldConsentStatus);
        }
        this.f34466c.mo36787b(false);
        this.f34466c.mo36809l();
        boolean canCollectPersonalInformation = canCollectPersonalInformation();
        if (canCollectPersonalInformation) {
            ClientMetadata.getInstance(this.f34464a).repopulateCountryData();
            if (this.f34468e.shouldTrack()) {
                this.f34468e.reportAppOpen(false);
            }
        }
        MoPubLog.log(ConsentLogEvent.UPDATED, oldConsentStatus, newConsentStatus, Boolean.valueOf(canCollectPersonalInformation()), consentChangeReason);
        m37123a(oldConsentStatus, newConsentStatus, canCollectPersonalInformation);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m37123a(ConsentStatus oldConsentStatus, ConsentStatus newConsentStatus, boolean canCollectPersonalInformation) {
        synchronized (this.f34465b) {
            for (ConsentStatusChangeListener stateChangeListener : this.f34465b) {
                Handler handler = new Handler(Looper.getMainLooper());
                C11276o oVar = new C11276o(this, stateChangeListener, oldConsentStatus, newConsentStatus, canCollectPersonalInformation);
                handler.post(oVar);
            }
        }
    }

    /* renamed from: b */
    private SdkInitializationListener m37128b() {
        return new C11277p(this);
    }
}
