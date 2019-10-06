package com.vungle.warren.model;

import com.google.gson.C10188s;
import com.google.gson.C10191u;

public class JsonUtil {
    public static boolean hasNonNull(C10188s jsonElement, String key) {
        boolean z = false;
        if (jsonElement == null || jsonElement.mo33448j() || !jsonElement.mo33449k()) {
            return false;
        }
        C10191u object = jsonElement.mo33445e();
        if (object.mo33473d(key) && object.mo33466a(key) != null && !object.mo33466a(key).mo33448j()) {
            z = true;
        }
        return z;
    }
}
