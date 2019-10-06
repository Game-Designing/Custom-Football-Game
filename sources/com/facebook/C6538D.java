package com.facebook;

import android.net.Uri;
import android.util.Log;
import com.facebook.internal.C6694S.C6695a;
import org.json.JSONObject;

/* renamed from: com.facebook.D */
/* compiled from: Profile */
class C6538D implements C6695a {
    C6538D() {
    }

    /* renamed from: a */
    public void mo19650a(JSONObject userInfo) {
        String id = userInfo.optString("id");
        if (id != null) {
            String link = userInfo.optString("link");
            Profile profile = new Profile(id, userInfo.optString("first_name"), userInfo.optString("middle_name"), userInfo.optString("last_name"), userInfo.optString("name"), link != null ? Uri.parse(link) : null);
            Profile.m12983a(profile);
        }
    }

    /* renamed from: a */
    public void mo19649a(FacebookException error) {
        String a = Profile.f11865a;
        StringBuilder sb = new StringBuilder();
        sb.append("Got unexpected exception: ");
        sb.append(error);
        Log.e(a, sb.toString());
    }
}
