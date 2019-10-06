package com.facebook.internal;

import android.os.Bundle;
import com.facebook.internal.C6720k.C6721a;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.internal.h */
/* compiled from: BundleJSONConverter */
class C6717h implements C6721a {
    C6717h() {
    }

    /* renamed from: a */
    public void mo19962a(Bundle bundle, String key, Object value) throws JSONException {
        bundle.putString(key, (String) value);
    }

    /* renamed from: a */
    public void mo19963a(JSONObject json, String key, Object value) throws JSONException {
        json.put(key, value);
    }
}
