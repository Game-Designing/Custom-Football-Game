package com.facebook.internal;

import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* renamed from: com.facebook.internal.M */
/* compiled from: ProfileInformationCache */
class C6689M {

    /* renamed from: a */
    private static final ConcurrentHashMap<String, JSONObject> f12210a = new ConcurrentHashMap<>();

    /* renamed from: a */
    public static JSONObject m13385a(String accessToken) {
        return (JSONObject) f12210a.get(accessToken);
    }

    /* renamed from: a */
    public static void m13386a(String key, JSONObject value) {
        f12210a.put(key, value);
    }
}
