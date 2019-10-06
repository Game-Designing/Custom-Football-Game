package com.facebook;

import android.content.SharedPreferences;
import com.facebook.internal.C6697T;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.F */
/* compiled from: ProfileCache */
final class C6540F {

    /* renamed from: a */
    private final SharedPreferences f11769a = C6787r.m13815e().getSharedPreferences("com.facebook.AccessTokenManager.SharedPreferences", 0);

    C6540F() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public Profile mo19655b() {
        String jsonString = this.f11769a.getString("com.facebook.ProfileManager.CachedProfile", null);
        if (jsonString != null) {
            try {
                return new Profile(new JSONObject(jsonString));
            } catch (JSONException e) {
            }
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo19654a(Profile profile) {
        C6697T.m13461a((Object) profile, "profile");
        JSONObject jsonObject = profile.mo19731d();
        if (jsonObject != null) {
            this.f11769a.edit().putString("com.facebook.ProfileManager.CachedProfile", jsonObject.toString()).apply();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo19653a() {
        this.f11769a.edit().remove("com.facebook.ProfileManager.CachedProfile").apply();
    }
}
