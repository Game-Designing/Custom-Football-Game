package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleSignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Creator<GoogleSignInAccount> CREATOR = new zab();
    @VisibleForTesting

    /* renamed from: a */
    private static Clock f19410a = DefaultClock.m22087d();

    /* renamed from: b */
    private final int f19411b;

    /* renamed from: c */
    private String f19412c;

    /* renamed from: d */
    private String f19413d;

    /* renamed from: e */
    private String f19414e;

    /* renamed from: f */
    private String f19415f;

    /* renamed from: g */
    private Uri f19416g;

    /* renamed from: h */
    private String f19417h;

    /* renamed from: i */
    private long f19418i;

    /* renamed from: j */
    private String f19419j;

    /* renamed from: k */
    private List<Scope> f19420k;

    /* renamed from: l */
    private String f19421l;

    /* renamed from: m */
    private String f19422m;

    /* renamed from: n */
    private Set<Scope> f19423n = new HashSet();

    /* renamed from: a */
    public static GoogleSignInAccount m20927a(String str) throws JSONException {
        Uri uri;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString("photoUrl", null);
        if (!TextUtils.isEmpty(optString)) {
            uri = Uri.parse(optString);
        } else {
            uri = null;
        }
        long parseLong = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        GoogleSignInAccount a = m20928a(jSONObject.optString("id"), jSONObject.optString("tokenId", null), jSONObject.optString("email", null), jSONObject.optString("displayName", null), jSONObject.optString("givenName", null), jSONObject.optString("familyName", null), uri, Long.valueOf(parseLong), jSONObject.getString("obfuscatedIdentifier"), hashSet);
        a.f19417h = jSONObject.optString("serverAuthCode", null);
        return a;
    }

    /* renamed from: a */
    private static GoogleSignInAccount m20928a(String str, String str2, String str3, String str4, String str5, String str6, Uri uri, Long l, String str7, Set<Scope> set) {
        Long l2;
        if (l == null) {
            l2 = Long.valueOf(f19410a.mo27935b() / 1000);
        } else {
            l2 = l;
        }
        long longValue = l2.longValue();
        Preconditions.m21866b(str7);
        Preconditions.m21857a(set);
        GoogleSignInAccount googleSignInAccount = new GoogleSignInAccount(3, str, str2, str3, str4, uri, null, longValue, str7, new ArrayList(set), str5, str6);
        return googleSignInAccount;
    }

    @Constructor
    GoogleSignInAccount(@Param(id = 1) int i, @Param(id = 2) String str, @Param(id = 3) String str2, @Param(id = 4) String str3, @Param(id = 5) String str4, @Param(id = 6) Uri uri, @Param(id = 7) String str5, @Param(id = 8) long j, @Param(id = 9) String str6, @Param(id = 10) List<Scope> list, @Param(id = 11) String str7, @Param(id = 12) String str8) {
        this.f19411b = i;
        this.f19412c = str;
        this.f19413d = str2;
        this.f19414e = str3;
        this.f19415f = str4;
        this.f19416g = uri;
        this.f19417h = str5;
        this.f19418i = j;
        this.f19419j = str6;
        this.f19420k = list;
        this.f19421l = str7;
        this.f19422m = str8;
    }

    /* renamed from: g */
    public String mo27177g() {
        return this.f19412c;
    }

    /* renamed from: h */
    public String mo27178h() {
        return this.f19413d;
    }

    /* renamed from: d */
    public String mo27173d() {
        return this.f19414e;
    }

    /* renamed from: a */
    public Account mo27171a() {
        String str = this.f19414e;
        if (str == null) {
            return null;
        }
        return new Account(str, "com.google");
    }

    /* renamed from: c */
    public String mo27172c() {
        return this.f19415f;
    }

    /* renamed from: f */
    public String mo27176f() {
        return this.f19421l;
    }

    /* renamed from: e */
    public String mo27174e() {
        return this.f19422m;
    }

    /* renamed from: i */
    public Uri mo27180i() {
        return this.f19416g;
    }

    /* renamed from: v */
    public String mo27182v() {
        return this.f19417h;
    }

    /* renamed from: w */
    public final String mo27183w() {
        return this.f19419j;
    }

    @KeepForSdk
    /* renamed from: j */
    public Set<Scope> mo27181j() {
        HashSet hashSet = new HashSet(this.f19420k);
        hashSet.addAll(this.f19423n);
        return hashSet;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21957a(parcel, 1, this.f19411b);
        SafeParcelWriter.m21965a(parcel, 2, mo27177g(), false);
        SafeParcelWriter.m21965a(parcel, 3, mo27178h(), false);
        SafeParcelWriter.m21965a(parcel, 4, mo27173d(), false);
        SafeParcelWriter.m21965a(parcel, 5, mo27172c(), false);
        SafeParcelWriter.m21962a(parcel, 6, (Parcelable) mo27180i(), i, false);
        SafeParcelWriter.m21965a(parcel, 7, mo27182v(), false);
        SafeParcelWriter.m21958a(parcel, 8, this.f19418i);
        SafeParcelWriter.m21965a(parcel, 9, this.f19419j, false);
        SafeParcelWriter.m21977c(parcel, 10, this.f19420k, false);
        SafeParcelWriter.m21965a(parcel, 11, mo27176f(), false);
        SafeParcelWriter.m21965a(parcel, 12, mo27174e(), false);
        SafeParcelWriter.m21954a(parcel, a);
    }

    public int hashCode() {
        return ((this.f19419j.hashCode() + 527) * 31) + mo27181j().hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
        if (!googleSignInAccount.f19419j.equals(this.f19419j) || !googleSignInAccount.mo27181j().equals(mo27181j())) {
            return false;
        }
        return true;
    }

    /* renamed from: x */
    public final String mo27185x() {
        JSONObject y = m20929y();
        y.remove("serverAuthCode");
        return y.toString();
    }

    /* renamed from: y */
    private final JSONObject m20929y() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (mo27177g() != null) {
                jSONObject.put("id", mo27177g());
            }
            if (mo27178h() != null) {
                jSONObject.put("tokenId", mo27178h());
            }
            if (mo27173d() != null) {
                jSONObject.put("email", mo27173d());
            }
            if (mo27172c() != null) {
                jSONObject.put("displayName", mo27172c());
            }
            if (mo27176f() != null) {
                jSONObject.put("givenName", mo27176f());
            }
            if (mo27174e() != null) {
                jSONObject.put("familyName", mo27174e());
            }
            if (mo27180i() != null) {
                jSONObject.put("photoUrl", mo27180i().toString());
            }
            if (mo27182v() != null) {
                jSONObject.put("serverAuthCode", mo27182v());
            }
            jSONObject.put("expirationTime", this.f19418i);
            jSONObject.put("obfuscatedIdentifier", this.f19419j);
            JSONArray jSONArray = new JSONArray();
            Scope[] scopeArr = (Scope[]) this.f19420k.toArray(new Scope[this.f19420k.size()]);
            Arrays.sort(scopeArr, C8615a.f19462a);
            for (Scope a : scopeArr) {
                jSONArray.put(a.mo27412a());
            }
            jSONObject.put("grantedScopes", jSONArray);
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
