package com.facebook.internal;

import android.os.Bundle;
import com.facebook.internal.C6720k.C6721a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.internal.i */
/* compiled from: BundleJSONConverter */
class C6718i implements C6721a {
    C6718i() {
    }

    /* renamed from: a */
    public void mo19962a(Bundle bundle, String key, Object value) throws JSONException {
        throw new IllegalArgumentException("Unexpected type from JSON");
    }

    /* renamed from: a */
    public void mo19963a(JSONObject json, String key, Object value) throws JSONException {
        JSONArray jsonArray = new JSONArray();
        for (String stringValue : (String[]) value) {
            jsonArray.put(stringValue);
        }
        json.put(key, jsonArray);
    }
}
