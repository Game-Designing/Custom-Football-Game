package com.facebook.internal;

import android.os.Bundle;
import com.facebook.internal.C6720k.C6721a;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.internal.j */
/* compiled from: BundleJSONConverter */
class C6719j implements C6721a {
    C6719j() {
    }

    /* renamed from: a */
    public void mo19962a(Bundle bundle, String key, Object value) throws JSONException {
        JSONArray jsonArray = (JSONArray) value;
        ArrayList<String> stringArrayList = new ArrayList<>();
        if (jsonArray.length() == 0) {
            bundle.putStringArrayList(key, stringArrayList);
            return;
        }
        int i = 0;
        while (i < jsonArray.length()) {
            Object current = jsonArray.get(i);
            if (current instanceof String) {
                stringArrayList.add((String) current);
                i++;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Unexpected type in an array: ");
                sb.append(current.getClass());
                throw new IllegalArgumentException(sb.toString());
            }
        }
        bundle.putStringArrayList(key, stringArrayList);
    }

    /* renamed from: a */
    public void mo19963a(JSONObject json, String key, Object value) throws JSONException {
        throw new IllegalArgumentException("JSONArray's are not supported in bundles.");
    }
}
