package com.mopub.common.util;

import android.text.TextUtils;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import p005cm.aptoide.p006pt.database.realm.Notification;

public class Json {
    public static Map<String, String> jsonStringToMap(String jsonParams) throws JSONException {
        Map<String, String> jsonMap = new HashMap<>();
        if (TextUtils.isEmpty(jsonParams)) {
            return jsonMap;
        }
        JSONObject jsonObject = (JSONObject) new JSONTokener(jsonParams).nextValue();
        Iterator<?> keys = jsonObject.keys();
        while (keys.hasNext()) {
            String key = (String) keys.next();
            jsonMap.put(key, jsonObject.getString(key));
        }
        return jsonMap;
    }

    public static String mapToJsonString(Map<String, String> map) {
        if (map == null) {
            return "{}";
        }
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        boolean first = true;
        for (Entry<String, String> entry : map.entrySet()) {
            if (!first) {
                builder.append(",");
            }
            String str = "\"";
            builder.append(str);
            builder.append((String) entry.getKey());
            builder.append("\":\"");
            builder.append((String) entry.getValue());
            builder.append(str);
            first = false;
        }
        builder.append("}");
        return builder.toString();
    }

    public static String[] jsonArrayToStringArray(String jsonString) {
        StringBuilder sb = new StringBuilder();
        sb.append("{key:");
        sb.append(jsonString);
        sb.append("}");
        try {
            JSONArray jsonArray = ((JSONObject) new JSONTokener(sb.toString()).nextValue()).getJSONArray(Notification.KEY);
            String[] result = new String[jsonArray.length()];
            for (int i = 0; i < result.length; i++) {
                result[i] = jsonArray.getString(i);
            }
            return result;
        } catch (JSONException e) {
            return new String[0];
        }
    }

    public static <T> T getJsonValue(JSONObject jsonObject, String key, Class<T> valueClass) {
        if (jsonObject == null || key == null || valueClass == null) {
            throw new IllegalArgumentException("Cannot pass any null argument to getJsonValue");
        }
        Object object = jsonObject.opt(key);
        String str = "Tried to get Json value with key: ";
        if (object == null) {
            SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(key);
            sb.append(", but it was null");
            MoPubLog.log(sdkLogEvent, sb.toString());
            return null;
        } else if (valueClass.isInstance(object)) {
            return valueClass.cast(object);
        } else {
            SdkLogEvent sdkLogEvent2 = SdkLogEvent.CUSTOM;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(key);
            sb2.append(", of type: ");
            sb2.append(valueClass.toString());
            sb2.append(", its type did not match");
            MoPubLog.log(sdkLogEvent2, sb2.toString());
            return null;
        }
    }
}
