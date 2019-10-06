package com.facebook.internal;

import android.os.Bundle;
import com.facebook.internal.C6720k.C6721a;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.internal.g */
/* compiled from: BundleJSONConverter */
class C6716g implements C6721a {
    C6716g() {
    }

    /* renamed from: a */
    public void mo19962a(Bundle bundle, String key, Object value) throws JSONException {
        bundle.putDouble(key, ((Double) value).doubleValue());
    }

    /* renamed from: a */
    public void mo19963a(JSONObject json, String key, Object value) throws JSONException {
        json.put(key, value);
    }
}
