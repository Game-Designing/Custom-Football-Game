package com.facebook;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.facebook.internal.C6697T;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.b */
/* compiled from: AccessTokenCache */
class C6649b {

    /* renamed from: a */
    private final SharedPreferences f12116a;

    /* renamed from: b */
    private final C6650a f12117b;

    /* renamed from: c */
    private C6536B f12118c;

    /* renamed from: com.facebook.b$a */
    /* compiled from: AccessTokenCache */
    static class C6650a {
        C6650a() {
        }

        /* renamed from: a */
        public C6536B mo19860a() {
            return new C6536B(C6787r.m13815e());
        }
    }

    C6649b(SharedPreferences sharedPreferences, C6650a tokenCachingStrategyFactory) {
        this.f12116a = sharedPreferences;
        this.f12117b = tokenCachingStrategyFactory;
    }

    public C6649b() {
        this(C6787r.m13815e().getSharedPreferences("com.facebook.AccessTokenManager.SharedPreferences", 0), new C6650a());
    }

    /* renamed from: b */
    public AccessToken mo19859b() {
        if (m13267f()) {
            return m13264c();
        }
        if (!m13268g()) {
            return null;
        }
        AccessToken accessToken = m13265d();
        if (accessToken == null) {
            return accessToken;
        }
        mo19858a(accessToken);
        m13266e().mo19639a();
        return accessToken;
    }

    /* renamed from: a */
    public void mo19858a(AccessToken accessToken) {
        C6697T.m13461a((Object) accessToken, "accessToken");
        try {
            this.f12116a.edit().putString("com.facebook.AccessTokenManager.CachedAccessToken", accessToken.mo19634o().toString()).apply();
        } catch (JSONException e) {
        }
    }

    /* renamed from: a */
    public void mo19857a() {
        this.f12116a.edit().remove("com.facebook.AccessTokenManager.CachedAccessToken").apply();
        if (m13268g()) {
            m13266e().mo19639a();
        }
    }

    /* renamed from: f */
    private boolean m13267f() {
        return this.f12116a.contains("com.facebook.AccessTokenManager.CachedAccessToken");
    }

    /* renamed from: c */
    private AccessToken m13264c() {
        String jsonString = this.f12116a.getString("com.facebook.AccessTokenManager.CachedAccessToken", null);
        if (jsonString == null) {
            return null;
        }
        try {
            return AccessToken.m12815a(new JSONObject(jsonString));
        } catch (JSONException e) {
            return null;
        }
    }

    /* renamed from: g */
    private boolean m13268g() {
        return C6787r.m13830t();
    }

    /* renamed from: d */
    private AccessToken m13265d() {
        Bundle bundle = m13266e().mo19640b();
        if (bundle == null || !C6536B.m12842d(bundle)) {
            return null;
        }
        return AccessToken.m12813a(bundle);
    }

    /* renamed from: e */
    private C6536B m13266e() {
        if (this.f12118c == null) {
            synchronized (this) {
                if (this.f12118c == null) {
                    this.f12118c = this.f12117b.mo19860a();
                }
            }
        }
        return this.f12118c;
    }
}
