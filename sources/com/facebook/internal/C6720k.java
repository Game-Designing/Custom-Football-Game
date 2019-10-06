package com.facebook.internal;

import android.os.Bundle;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.internal.k */
/* compiled from: BundleJSONConverter */
public class C6720k {

    /* renamed from: a */
    private static final Map<Class<?>, C6721a> f12279a = new HashMap();

    /* renamed from: com.facebook.internal.k$a */
    /* compiled from: BundleJSONConverter */
    public interface C6721a {
        /* renamed from: a */
        void mo19962a(Bundle bundle, String str, Object obj) throws JSONException;

        /* renamed from: a */
        void mo19963a(JSONObject jSONObject, String str, Object obj) throws JSONException;
    }

    static {
        f12279a.put(Boolean.class, new C6713d());
        f12279a.put(Integer.class, new C6714e());
        f12279a.put(Long.class, new C6715f());
        f12279a.put(Double.class, new C6716g());
        f12279a.put(String.class, new C6717h());
        f12279a.put(String[].class, new C6718i());
        f12279a.put(JSONArray.class, new C6719j());
    }

    /* renamed from: a */
    public static JSONObject m13540a(Bundle bundle) throws JSONException {
        JSONObject json = new JSONObject();
        for (String key : bundle.keySet()) {
            Object value = bundle.get(key);
            if (value != null) {
                if (value instanceof List) {
                    JSONArray jsonArray = new JSONArray();
                    for (String stringValue : (List) value) {
                        jsonArray.put(stringValue);
                    }
                    json.put(key, jsonArray);
                } else if (value instanceof Bundle) {
                    json.put(key, m13540a((Bundle) value));
                } else {
                    C6721a setter = (C6721a) f12279a.get(value.getClass());
                    if (setter != null) {
                        setter.mo19963a(json, key, value);
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Unsupported type: ");
                        sb.append(value.getClass());
                        throw new IllegalArgumentException(sb.toString());
                    }
                }
            }
        }
        return json;
    }

    /* renamed from: a */
    public static Bundle m13539a(JSONObject jsonObject) throws JSONException {
        Bundle bundle = new Bundle();
        Iterator<String> jsonIterator = jsonObject.keys();
        while (jsonIterator.hasNext()) {
            String key = (String) jsonIterator.next();
            Object value = jsonObject.get(key);
            if (!(value == null || value == JSONObject.NULL)) {
                if (value instanceof JSONObject) {
                    bundle.putBundle(key, m13539a((JSONObject) value));
                } else {
                    C6721a setter = (C6721a) f12279a.get(value.getClass());
                    if (setter != null) {
                        setter.mo19962a(bundle, key, value);
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Unsupported type: ");
                        sb.append(value.getClass());
                        throw new IllegalArgumentException(sb.toString());
                    }
                }
            }
        }
        return bundle;
    }
}
