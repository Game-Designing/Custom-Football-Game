package com.facebook.internal;

import android.os.Bundle;
import com.facebook.internal.C6720k.C6721a;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.internal.d */
/* compiled from: BundleJSONConverter */
class C6713d implements C6721a {
    C6713d() {
    }

    /* renamed from: a */
    public void mo19962a(Bundle bundle, String key, Object value) throws JSONException {
        bundle.putBoolean(key, ((Boolean) value).booleanValue());
    }

    /* renamed from: a */
    public void mo19963a(JSONObject json, String key, Object value) throws JSONException {
        json.put(key, value);
    }
}
