package com.mopub.common.privacy;

import android.content.Context;
import com.mopub.common.privacy.SyncResponse.Builder;
import com.mopub.network.MoPubNetworkError;
import com.mopub.network.MoPubNetworkError.Reason;
import com.mopub.network.MoPubRequest;
import com.mopub.volley.DefaultRetryPolicy;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.Response;
import com.mopub.volley.Response.ErrorListener;
import com.mopub.volley.toolbox.HttpHeaderParser;
import org.json.JSONException;
import org.json.JSONObject;

public class SyncRequest extends MoPubRequest<SyncResponse> {

    /* renamed from: s */
    private Listener f34483s;

    public interface Listener extends ErrorListener {
        void onSuccess(SyncResponse syncResponse);
    }

    public SyncRequest(Context context, String url, Listener listener) {
        super(context, url, listener);
        this.f34483s = listener;
        setRetryPolicy(new DefaultRetryPolicy(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS, 0, 1.0f));
        setShouldCache(false);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Response<SyncResponse> mo36680a(NetworkResponse networkResponse) {
        Builder builder = new Builder();
        try {
            JSONObject jsonBody = new JSONObject(mo38295b(networkResponse));
            builder.setIsGdprRegion(jsonBody.getString(PrivacyKey.IS_GDPR_REGION.getKey())).setForceExplicitNo(jsonBody.optString(PrivacyKey.FORCE_EXPLICIT_NO.getKey())).setInvalidateConsent(jsonBody.optString(PrivacyKey.INVALIDATE_CONSENT.getKey())).setReacquireConsent(jsonBody.optString(PrivacyKey.REACQUIRE_CONSENT.getKey())).setIsWhitelisted(jsonBody.getString(PrivacyKey.IS_WHITELISTED.getKey())).setForceGdprApplies(jsonBody.optString(PrivacyKey.FORCE_GDPR_APPLIES.getKey())).setCurrentVendorListVersion(jsonBody.getString(PrivacyKey.CURRENT_VENDOR_LIST_VERSION.getKey())).setCurrentVendorListLink(jsonBody.getString(PrivacyKey.CURRENT_VENDOR_LIST_LINK.getKey())).setCurrentPrivacyPolicyLink(jsonBody.getString(PrivacyKey.CURRENT_PRIVACY_POLICY_LINK.getKey())).setCurrentPrivacyPolicyVersion(jsonBody.getString(PrivacyKey.CURRENT_PRIVACY_POLICY_VERSION.getKey())).setCurrentVendorListIabFormat(jsonBody.optString(PrivacyKey.CURRENT_VENDOR_LIST_IAB_FORMAT.getKey())).setCurrentVendorListIabHash(jsonBody.getString(PrivacyKey.CURRENT_VENDOR_LIST_IAB_HASH.getKey())).setCallAgainAfterSecs(jsonBody.optString(PrivacyKey.CALL_AGAIN_AFTER_SECS.getKey())).setExtras(jsonBody.optString(PrivacyKey.EXTRAS.getKey())).setConsentChangeReason(jsonBody.optString(PrivacyKey.CONSENT_CHANGE_REASON.getKey()));
            return Response.success(builder.build(), HttpHeaderParser.parseCacheHeaders(networkResponse));
        } catch (JSONException e) {
            return Response.error(new MoPubNetworkError("Unable to parse sync request network response.", Reason.BAD_BODY, (Integer) null));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void deliverResponse(SyncResponse syncResponse) {
        Listener listener = this.f34483s;
        if (listener != null) {
            listener.onSuccess(syncResponse);
        }
    }
}
