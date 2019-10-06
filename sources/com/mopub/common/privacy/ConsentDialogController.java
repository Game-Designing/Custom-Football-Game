package com.mopub.common.privacy;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.ConsentLogEvent;
import com.mopub.common.privacy.ConsentDialogRequest.Listener;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.network.MoPubNetworkError;
import com.mopub.volley.VolleyError;

public class ConsentDialogController implements Listener {

    /* renamed from: a */
    private final Context f34441a;

    /* renamed from: b */
    private String f34442b;

    /* renamed from: c */
    private ConsentDialogListener f34443c;

    /* renamed from: d */
    volatile boolean f34444d;

    /* renamed from: e */
    volatile boolean f34445e;

    /* renamed from: f */
    private final Handler f34446f = new Handler();

    ConsentDialogController(Context appContext) {
        Preconditions.checkNotNull(appContext);
        this.f34441a = appContext.getApplicationContext();
    }

    public void onSuccess(C11270i response) {
        this.f34445e = false;
        this.f34442b = response.getHtml();
        if (TextUtils.isEmpty(this.f34442b)) {
            this.f34444d = false;
            if (this.f34443c != null) {
                MoPubLog.log(ConsentLogEvent.LOAD_FAILED, Integer.valueOf(MoPubErrorCode.INTERNAL_ERROR.getIntCode()), MoPubErrorCode.INTERNAL_ERROR);
                this.f34443c.onConsentDialogLoadFailed(MoPubErrorCode.INTERNAL_ERROR);
            }
            return;
        }
        MoPubLog.log(ConsentLogEvent.LOAD_SUCCESS, new Object[0]);
        this.f34444d = true;
        ConsentDialogListener consentDialogListener = this.f34443c;
        if (consentDialogListener != null) {
            consentDialogListener.onConsentDialogLoaded();
        }
    }

    public void onErrorResponse(VolleyError volleyError) {
        ConsentDialogListener loadListener = this.f34443c;
        m37100c();
        if (loadListener != null) {
            if (volleyError instanceof MoPubNetworkError) {
                if (C11264e.f34533a[((MoPubNetworkError) volleyError).getReason().ordinal()] != 1) {
                    MoPubLog.log(ConsentLogEvent.LOAD_FAILED, Integer.valueOf(MoPubErrorCode.UNSPECIFIED.getIntCode()), MoPubErrorCode.UNSPECIFIED);
                } else {
                    MoPubLog.log(ConsentLogEvent.LOAD_FAILED, Integer.valueOf(MoPubErrorCode.INTERNAL_ERROR.getIntCode()), MoPubErrorCode.INTERNAL_ERROR);
                    loadListener.onConsentDialogLoadFailed(MoPubErrorCode.INTERNAL_ERROR);
                    return;
                }
            }
            loadListener.onConsentDialogLoadFailed(MoPubErrorCode.UNSPECIFIED);
        }
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0015, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo36675a(com.mopub.common.privacy.ConsentDialogListener r7, java.lang.Boolean r8, com.mopub.common.privacy.C11272k r9) {
        /*
            r6 = this;
            monitor-enter(r6)
            com.mopub.common.Preconditions.checkNotNull(r9)     // Catch:{ all -> 0x0074 }
            boolean r0 = r6.f34444d     // Catch:{ all -> 0x0074 }
            if (r0 == 0) goto L_0x0016
            if (r7 == 0) goto L_0x0014
            android.os.Handler r0 = r6.f34446f     // Catch:{ all -> 0x0074 }
            com.mopub.common.privacy.d r1 = new com.mopub.common.privacy.d     // Catch:{ all -> 0x0074 }
            r1.<init>(r6, r7)     // Catch:{ all -> 0x0074 }
            r0.post(r1)     // Catch:{ all -> 0x0074 }
        L_0x0014:
            monitor-exit(r6)
            return
        L_0x0016:
            boolean r0 = r6.f34445e     // Catch:{ all -> 0x0074 }
            r1 = 1
            if (r0 == 0) goto L_0x0029
            com.mopub.common.logging.MoPubLog$SdkLogEvent r0 = com.mopub.common.logging.MoPubLog.SdkLogEvent.CUSTOM     // Catch:{ all -> 0x0074 }
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x0074 }
            r2 = 0
            java.lang.String r3 = "Already making a consent dialog load request."
            r1[r2] = r3     // Catch:{ all -> 0x0074 }
            com.mopub.common.logging.MoPubLog.log(r0, r1)     // Catch:{ all -> 0x0074 }
            monitor-exit(r6)
            return
        L_0x0029:
            r6.f34443c = r7     // Catch:{ all -> 0x0074 }
            r6.f34445e = r1     // Catch:{ all -> 0x0074 }
            com.mopub.common.privacy.ConsentDialogRequest r0 = new com.mopub.common.privacy.ConsentDialogRequest     // Catch:{ all -> 0x0074 }
            android.content.Context r1 = r6.f34441a     // Catch:{ all -> 0x0074 }
            com.mopub.common.privacy.ConsentDialogUrlGenerator r2 = new com.mopub.common.privacy.ConsentDialogUrlGenerator     // Catch:{ all -> 0x0074 }
            android.content.Context r3 = r6.f34441a     // Catch:{ all -> 0x0074 }
            java.lang.String r4 = r9.mo36779a()     // Catch:{ all -> 0x0074 }
            com.mopub.common.privacy.ConsentStatus r5 = r9.mo36788c()     // Catch:{ all -> 0x0074 }
            java.lang.String r5 = r5.getValue()     // Catch:{ all -> 0x0074 }
            r2.<init>(r3, r4, r5)     // Catch:{ all -> 0x0074 }
            com.mopub.common.privacy.ConsentDialogUrlGenerator r2 = r2.withGdprApplies(r8)     // Catch:{ all -> 0x0074 }
            java.lang.String r3 = r9.getConsentedPrivacyPolicyVersion()     // Catch:{ all -> 0x0074 }
            com.mopub.common.privacy.ConsentDialogUrlGenerator r2 = r2.withConsentedPrivacyPolicyVersion(r3)     // Catch:{ all -> 0x0074 }
            java.lang.String r3 = r9.getConsentedVendorListVersion()     // Catch:{ all -> 0x0074 }
            com.mopub.common.privacy.ConsentDialogUrlGenerator r2 = r2.withConsentedVendorListVersion(r3)     // Catch:{ all -> 0x0074 }
            boolean r3 = r9.isForceGdprApplies()     // Catch:{ all -> 0x0074 }
            com.mopub.common.privacy.ConsentDialogUrlGenerator r2 = r2.withForceGdprApplies(r3)     // Catch:{ all -> 0x0074 }
            java.lang.String r3 = com.mopub.common.Constants.HOST     // Catch:{ all -> 0x0074 }
            java.lang.String r2 = r2.generateUrlString(r3)     // Catch:{ all -> 0x0074 }
            r0.<init>(r1, r2, r6)     // Catch:{ all -> 0x0074 }
            android.content.Context r1 = r6.f34441a     // Catch:{ all -> 0x0074 }
            com.mopub.network.MoPubRequestQueue r1 = com.mopub.network.Networking.getRequestQueue(r1)     // Catch:{ all -> 0x0074 }
            r1.add(r0)     // Catch:{ all -> 0x0074 }
            monitor-exit(r6)
            return
        L_0x0074:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mopub.common.privacy.ConsentDialogController.mo36675a(com.mopub.common.privacy.ConsentDialogListener, java.lang.Boolean, com.mopub.common.privacy.k):void");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo36677b() {
        MoPubLog.log(ConsentLogEvent.SHOW_ATTEMPTED, new Object[0]);
        if (!this.f34444d || TextUtils.isEmpty(this.f34442b)) {
            MoPubLog.log(ConsentLogEvent.SHOW_FAILED, Integer.valueOf(MoPubErrorCode.INTERNAL_ERROR.getIntCode()), MoPubErrorCode.INTERNAL_ERROR);
            return false;
        }
        this.f34444d = false;
        ConsentDialogActivity.m37098b(this.f34441a, this.f34442b);
        m37100c();
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo36676a() {
        return this.f34444d;
    }

    /* renamed from: c */
    private void m37100c() {
        this.f34445e = false;
        this.f34444d = false;
        this.f34443c = null;
        this.f34442b = null;
    }
}
