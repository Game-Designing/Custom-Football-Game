package com.facebook;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.facebook.internal.C6694S;
import com.facebook.internal.C6697T;
import com.unity3d.ads.metadata.MediationMetaData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.account.AndroidAccountManagerPersistence;
import p005cm.aptoide.p006pt.timeline.view.follow.TimeLineFollowFragment.BundleKeys;

public final class AccessToken implements Parcelable {
    public static final Creator<AccessToken> CREATOR = new C6559a();

    /* renamed from: a */
    private static final Date f11734a = new Date(Long.MAX_VALUE);

    /* renamed from: b */
    private static final Date f11735b = f11734a;

    /* renamed from: c */
    private static final Date f11736c = new Date();

    /* renamed from: d */
    private static final C6665h f11737d = C6665h.FACEBOOK_APPLICATION_WEB;

    /* renamed from: e */
    private final Date f11738e;

    /* renamed from: f */
    private final Set<String> f11739f;

    /* renamed from: g */
    private final Set<String> f11740g;

    /* renamed from: h */
    private final Set<String> f11741h;

    /* renamed from: i */
    private final String f11742i;

    /* renamed from: j */
    private final C6665h f11743j;

    /* renamed from: k */
    private final Date f11744k;

    /* renamed from: l */
    private final String f11745l;

    /* renamed from: m */
    private final String f11746m;

    /* renamed from: n */
    private final Date f11747n;

    /* renamed from: com.facebook.AccessToken$a */
    public interface C6535a {
        /* renamed from: a */
        void mo19637a(AccessToken accessToken);

        /* renamed from: a */
        void mo19638a(FacebookException facebookException);
    }

    public AccessToken(String accessToken, String applicationId, String userId, Collection<String> permissions, Collection<String> declinedPermissions, Collection<String> expiredPermissions, C6665h accessTokenSource, Date expirationTime, Date lastRefreshTime, Date dataAccessExpirationTime) {
        C6697T.m13462a(accessToken, "accessToken");
        C6697T.m13462a(applicationId, "applicationId");
        C6697T.m13462a(userId, AndroidAccountManagerPersistence.ACCOUNT_ID);
        this.f11738e = expirationTime != null ? expirationTime : f11735b;
        this.f11739f = Collections.unmodifiableSet(permissions != null ? new HashSet(permissions) : new HashSet());
        this.f11740g = Collections.unmodifiableSet(declinedPermissions != null ? new HashSet(declinedPermissions) : new HashSet());
        this.f11741h = Collections.unmodifiableSet(expiredPermissions != null ? new HashSet(expiredPermissions) : new HashSet());
        this.f11742i = accessToken;
        this.f11743j = accessTokenSource != null ? accessTokenSource : f11737d;
        this.f11744k = lastRefreshTime != null ? lastRefreshTime : f11736c;
        this.f11745l = applicationId;
        this.f11746m = userId;
        this.f11747n = (dataAccessExpirationTime == null || dataAccessExpirationTime.getTime() == 0) ? f11735b : dataAccessExpirationTime;
    }

    /* renamed from: c */
    public static AccessToken m12820c() {
        return C6663g.m13290d().mo19871c();
    }

    /* renamed from: m */
    public static boolean m12821m() {
        AccessToken accessToken = C6663g.m13290d().mo19871c();
        return accessToken != null && !accessToken.mo19633n();
    }

    /* renamed from: a */
    static void m12817a() {
        AccessToken accessToken = C6663g.m13290d().mo19871c();
        if (accessToken != null) {
            m12819b(m12814a(accessToken));
        }
    }

    /* renamed from: b */
    public static void m12819b(AccessToken accessToken) {
        C6663g.m13290d().mo19869a(accessToken);
    }

    /* renamed from: k */
    public String mo19631k() {
        return this.f11742i;
    }

    /* renamed from: g */
    public Date mo19626g() {
        return this.f11738e;
    }

    /* renamed from: d */
    public Date mo19621d() {
        return this.f11747n;
    }

    /* renamed from: i */
    public Set<String> mo19629i() {
        return this.f11739f;
    }

    /* renamed from: e */
    public Set<String> mo19623e() {
        return this.f11740g;
    }

    /* renamed from: f */
    public Set<String> mo19625f() {
        return this.f11741h;
    }

    /* renamed from: j */
    public C6665h mo19630j() {
        return this.f11743j;
    }

    /* renamed from: h */
    public Date mo19627h() {
        return this.f11744k;
    }

    /* renamed from: b */
    public String mo19620b() {
        return this.f11745l;
    }

    /* renamed from: l */
    public String mo19632l() {
        return this.f11746m;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{AccessToken");
        builder.append(" token:");
        builder.append(m12822p());
        m12818a(builder);
        builder.append("}");
        return builder.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0072, code lost:
        if (r5.f11747n.equals(r1.f11747n) != false) goto L_0x0076;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            r0 = 1
            if (r5 != r6) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r6 instanceof com.facebook.AccessToken
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            r1 = r6
            com.facebook.AccessToken r1 = (com.facebook.AccessToken) r1
            java.util.Date r3 = r5.f11738e
            java.util.Date r4 = r1.f11738e
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0075
            java.util.Set<java.lang.String> r3 = r5.f11739f
            java.util.Set<java.lang.String> r4 = r1.f11739f
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0075
            java.util.Set<java.lang.String> r3 = r5.f11740g
            java.util.Set<java.lang.String> r4 = r1.f11740g
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0075
            java.util.Set<java.lang.String> r3 = r5.f11741h
            java.util.Set<java.lang.String> r4 = r1.f11741h
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0075
            java.lang.String r3 = r5.f11742i
            java.lang.String r4 = r1.f11742i
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0075
            com.facebook.h r3 = r5.f11743j
            com.facebook.h r4 = r1.f11743j
            if (r3 != r4) goto L_0x0075
            java.util.Date r3 = r5.f11744k
            java.util.Date r4 = r1.f11744k
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0075
            java.lang.String r3 = r5.f11745l
            if (r3 != 0) goto L_0x0058
            java.lang.String r3 = r1.f11745l
            if (r3 != 0) goto L_0x0075
            goto L_0x0060
        L_0x0058:
            java.lang.String r4 = r1.f11745l
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0075
        L_0x0060:
            java.lang.String r3 = r5.f11746m
            java.lang.String r4 = r1.f11746m
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0075
            java.util.Date r3 = r5.f11747n
            java.util.Date r4 = r1.f11747n
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0075
            goto L_0x0076
        L_0x0075:
            r0 = 0
        L_0x0076:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.AccessToken.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int result = ((((((((((((((17 * 31) + this.f11738e.hashCode()) * 31) + this.f11739f.hashCode()) * 31) + this.f11740g.hashCode()) * 31) + this.f11741h.hashCode()) * 31) + this.f11742i.hashCode()) * 31) + this.f11743j.hashCode()) * 31) + this.f11744k.hashCode()) * 31;
        String str = this.f11745l;
        return ((((result + (str == null ? 0 : str.hashCode())) * 31) + this.f11746m.hashCode()) * 31) + this.f11747n.hashCode();
    }

    /* renamed from: a */
    static AccessToken m12814a(AccessToken current) {
        AccessToken accessToken = new AccessToken(current.f11742i, current.f11745l, current.mo19632l(), current.mo19629i(), current.mo19623e(), current.mo19625f(), current.f11743j, new Date(), new Date(), current.f11747n);
        return accessToken;
    }

    /* renamed from: a */
    static AccessToken m12813a(Bundle bundle) {
        String applicationId;
        Bundle bundle2 = bundle;
        List<String> permissions = m12816a(bundle2, "com.facebook.TokenCachingStrategy.Permissions");
        List<String> declinedPermissions = m12816a(bundle2, "com.facebook.TokenCachingStrategy.DeclinedPermissions");
        List<String> expiredPermissions = m12816a(bundle2, "com.facebook.TokenCachingStrategy.ExpiredPermissions");
        String applicationId2 = C6536B.m12837a(bundle);
        if (C6694S.m13436b(applicationId2)) {
            applicationId = C6787r.m13816f();
        } else {
            applicationId = applicationId2;
        }
        String tokenString = C6536B.m12841c(bundle);
        JSONObject userInfo = C6694S.m13414a(tokenString);
        try {
            JSONObject jSONObject = userInfo;
            AccessToken accessToken = new AccessToken(tokenString, applicationId, userInfo.getString("id"), permissions, declinedPermissions, expiredPermissions, C6536B.m12840b(bundle), C6536B.m12838a(bundle2, "com.facebook.TokenCachingStrategy.ExpirationDate"), C6536B.m12838a(bundle2, "com.facebook.TokenCachingStrategy.LastRefreshDate"), null);
            return accessToken;
        } catch (JSONException e) {
            JSONObject jSONObject2 = userInfo;
            return null;
        }
    }

    /* renamed from: a */
    static List<String> m12816a(Bundle bundle, String key) {
        List<String> originalPermissions = bundle.getStringArrayList(key);
        if (originalPermissions == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(new ArrayList(originalPermissions));
    }

    /* renamed from: n */
    public boolean mo19633n() {
        return new Date().after(this.f11738e);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: o */
    public JSONObject mo19634o() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(MediationMetaData.KEY_VERSION, 1);
        jsonObject.put("token", this.f11742i);
        jsonObject.put("expires_at", this.f11738e.getTime());
        jsonObject.put("permissions", new JSONArray(this.f11739f));
        jsonObject.put("declined_permissions", new JSONArray(this.f11740g));
        jsonObject.put("expired_permissions", new JSONArray(this.f11741h));
        jsonObject.put("last_refresh", this.f11744k.getTime());
        jsonObject.put("source", this.f11743j.name());
        jsonObject.put("application_id", this.f11745l);
        jsonObject.put(BundleKeys.USER_ID, this.f11746m);
        jsonObject.put("data_access_expiration_time", this.f11747n.getTime());
        return jsonObject;
    }

    /* renamed from: a */
    static AccessToken m12815a(JSONObject jsonObject) throws JSONException {
        Collection collection;
        JSONObject jSONObject = jsonObject;
        if (jSONObject.getInt(MediationMetaData.KEY_VERSION) <= 1) {
            String token = jSONObject.getString("token");
            Date expiresAt = new Date(jSONObject.getLong("expires_at"));
            JSONArray permissionsArray = jSONObject.getJSONArray("permissions");
            JSONArray declinedPermissionsArray = jSONObject.getJSONArray("declined_permissions");
            JSONArray expiredPermissionsArray = jSONObject.optJSONArray("expired_permissions");
            Date lastRefresh = new Date(jSONObject.getLong("last_refresh"));
            C6665h source = C6665h.valueOf(jSONObject.getString("source"));
            String applicationId = jSONObject.getString("application_id");
            String userId = jSONObject.getString(BundleKeys.USER_ID);
            Date dataAccessExpirationTime = new Date(jSONObject.optLong("data_access_expiration_time", 0));
            List a = C6694S.m13410a(permissionsArray);
            List a2 = C6694S.m13410a(declinedPermissionsArray);
            if (expiredPermissionsArray == null) {
                collection = new ArrayList();
            } else {
                collection = C6694S.m13410a(expiredPermissionsArray);
            }
            AccessToken accessToken = new AccessToken(token, applicationId, userId, a, a2, collection, source, expiresAt, lastRefresh, dataAccessExpirationTime);
            return accessToken;
        }
        throw new FacebookException("Unknown AccessToken serialization format.");
    }

    /* renamed from: p */
    private String m12822p() {
        if (this.f11742i == null) {
            return "null";
        }
        if (C6787r.m13808a(C6537C.INCLUDE_ACCESS_TOKENS)) {
            return this.f11742i;
        }
        return "ACCESS_TOKEN_REMOVED";
    }

    /* renamed from: a */
    private void m12818a(StringBuilder builder) {
        builder.append(" permissions:");
        if (this.f11739f == null) {
            builder.append("null");
            return;
        }
        builder.append("[");
        builder.append(TextUtils.join(", ", this.f11739f));
        builder.append("]");
    }

    AccessToken(Parcel parcel) {
        this.f11738e = new Date(parcel.readLong());
        ArrayList<String> permissionsList = new ArrayList<>();
        parcel.readStringList(permissionsList);
        this.f11739f = Collections.unmodifiableSet(new HashSet(permissionsList));
        permissionsList.clear();
        parcel.readStringList(permissionsList);
        this.f11740g = Collections.unmodifiableSet(new HashSet(permissionsList));
        permissionsList.clear();
        parcel.readStringList(permissionsList);
        this.f11741h = Collections.unmodifiableSet(new HashSet(permissionsList));
        this.f11742i = parcel.readString();
        this.f11743j = C6665h.valueOf(parcel.readString());
        this.f11744k = new Date(parcel.readLong());
        this.f11745l = parcel.readString();
        this.f11746m = parcel.readString();
        this.f11747n = new Date(parcel.readLong());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.f11738e.getTime());
        dest.writeStringList(new ArrayList(this.f11739f));
        dest.writeStringList(new ArrayList(this.f11740g));
        dest.writeStringList(new ArrayList(this.f11741h));
        dest.writeString(this.f11742i);
        dest.writeString(this.f11743j.name());
        dest.writeLong(this.f11744k.getTime());
        dest.writeString(this.f11745l);
        dest.writeString(this.f11746m);
        dest.writeLong(this.f11747n.getTime());
    }
}
