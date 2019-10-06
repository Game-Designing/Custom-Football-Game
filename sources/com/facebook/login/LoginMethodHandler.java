package com.facebook.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.C6665h;
import com.facebook.FacebookException;
import com.facebook.internal.C6694S;
import com.facebook.login.LoginClient.Request;
import com.facebook.p127a.C6647y;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.reviews.RateAndReviewsFragment.BundleCons;
import p005cm.aptoide.p006pt.timeline.view.follow.TimeLineFollowFragment.BundleKeys;

abstract class LoginMethodHandler implements Parcelable {

    /* renamed from: a */
    Map<String, String> f12405a;

    /* renamed from: b */
    protected LoginClient f12406b;

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public abstract boolean mo19999a(Request request);

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public abstract String mo20000b();

    LoginMethodHandler(LoginClient loginClient) {
        this.f12406b = loginClient;
    }

    LoginMethodHandler(Parcel source) {
        this.f12405a = C6694S.m13413a(source);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo20082a(LoginClient loginClient) {
        if (this.f12406b == null) {
            this.f12406b = loginClient;
            return;
        }
        throw new FacebookException("Can't set LoginClient if it is already set.");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo19998a(int requestCode, int resultCode, Intent data) {
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public boolean mo20085c() {
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo20031a() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo19997a(JSONObject param) throws JSONException {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo20081a(String authId) {
        JSONObject param = new JSONObject();
        try {
            param.put("0_auth_logger_id", authId);
            param.put("3_method", mo20000b());
            mo19997a(param);
        } catch (JSONException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Error creating client state json: ");
            sb.append(e.getMessage());
            Log.w("LoginMethodHandler", sb.toString());
        }
        return param.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo20083a(String key, Object value) {
        if (this.f12405a == null) {
            this.f12405a = new HashMap();
        }
        this.f12405a.put(key, value == null ? null : value.toString());
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo20084c(String e2e) {
        String applicationId = this.f12406b.mo20055i().mo20061a();
        C6647y logger = new C6647y(this.f12406b.mo20048c(), applicationId);
        Bundle parameters = new Bundle();
        parameters.putString("fb_web_login_e2e", e2e);
        parameters.putLong("fb_web_login_switchback_time", System.currentTimeMillis());
        parameters.putString(BundleCons.APP_ID, applicationId);
        logger.mo19853a("fb_dialogs_web_login_dialog_complete", (Double) null, parameters);
    }

    /* renamed from: a */
    static AccessToken m13733a(Bundle bundle, C6665h source, String applicationId) {
        Bundle bundle2 = bundle;
        Date expires = C6694S.m13409a(bundle2, "com.facebook.platform.extra.EXPIRES_SECONDS_SINCE_EPOCH", new Date(0));
        ArrayList<String> permissions = bundle2.getStringArrayList("com.facebook.platform.extra.PERMISSIONS");
        String token = bundle2.getString("com.facebook.platform.extra.ACCESS_TOKEN");
        Date dataAccessExpirationTime = C6694S.m13409a(bundle2, "com.facebook.platform.extra.EXTRA_DATA_ACCESS_EXPIRATION_TIME", new Date(0));
        if (C6694S.m13436b(token)) {
            return null;
        }
        AccessToken accessToken = new AccessToken(token, applicationId, bundle2.getString("com.facebook.platform.extra.USER_ID"), permissions, null, null, source, expires, new Date(), dataAccessExpirationTime);
        return accessToken;
    }

    /* renamed from: a */
    public static AccessToken m13734a(Collection<String> requestedPermissions, Bundle bundle, C6665h source, String applicationId) throws FacebookException {
        Collection<String> requestedPermissions2;
        Collection collection;
        Collection collection2;
        Bundle bundle2 = bundle;
        Date expires = C6694S.m13409a(bundle2, "expires_in", new Date());
        String token = bundle2.getString("access_token");
        Date dataAccessExpirationTime = C6694S.m13409a(bundle2, "data_access_expiration_time", new Date(0));
        String grantedPermissions = bundle2.getString("granted_scopes");
        String str = ",";
        if (!C6694S.m13436b(grantedPermissions)) {
            requestedPermissions2 = new ArrayList<>(Arrays.asList(grantedPermissions.split(str)));
        } else {
            requestedPermissions2 = requestedPermissions;
        }
        String deniedPermissions = bundle2.getString("denied_scopes");
        if (!C6694S.m13436b(deniedPermissions)) {
            collection = new ArrayList(Arrays.asList(deniedPermissions.split(str)));
        } else {
            collection = null;
        }
        String expiredScopes = bundle2.getString("expired_scopes");
        if (!C6694S.m13436b(expiredScopes)) {
            collection2 = new ArrayList(Arrays.asList(expiredScopes.split(str)));
        } else {
            collection2 = null;
        }
        if (C6694S.m13436b(token)) {
            return null;
        }
        String userId = m13735b(bundle2.getString("signed_request"));
        String str2 = expiredScopes;
        Date date = new Date();
        String str3 = deniedPermissions;
        AccessToken accessToken = new AccessToken(token, applicationId, userId, requestedPermissions2, collection, collection2, source, expires, date, dataAccessExpirationTime);
        return accessToken;
    }

    /* renamed from: b */
    static String m13735b(String signedRequest) throws FacebookException {
        if (signedRequest == null || signedRequest.isEmpty()) {
            throw new FacebookException("Authorization response does not contain the signed_request");
        }
        try {
            String[] signatureAndPayload = signedRequest.split("\\.");
            if (signatureAndPayload.length == 2) {
                return new JSONObject(new String(Base64.decode(signatureAndPayload[1], 0), "UTF-8")).getString(BundleKeys.USER_ID);
            }
        } catch (UnsupportedEncodingException | JSONException e) {
        }
        throw new FacebookException("Failed to retrieve user_id from signed_request");
    }

    public void writeToParcel(Parcel dest, int flags) {
        C6694S.m13419a(dest, this.f12405a);
    }
}
