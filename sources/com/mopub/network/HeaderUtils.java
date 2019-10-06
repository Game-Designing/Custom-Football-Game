package com.mopub.network;

import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.ResponseHeader;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HeaderUtils {
    public static String extractHeader(JSONObject headers, ResponseHeader responseHeader) {
        Preconditions.checkNotNull(responseHeader);
        if (headers == null) {
            return "";
        }
        return headers.optString(responseHeader.getKey());
    }

    public static JSONObject extractJsonObjectHeader(JSONObject headers, ResponseHeader responseHeader) {
        Preconditions.checkNotNull(responseHeader);
        if (headers == null) {
            return null;
        }
        return headers.optJSONObject(responseHeader.getKey());
    }

    public static Integer extractIntegerHeader(JSONObject headers, ResponseHeader responseHeader) {
        return m38529a(extractHeader(headers, responseHeader));
    }

    public static boolean extractBooleanHeader(JSONObject headers, ResponseHeader responseHeader, boolean defaultValue) {
        return m38531a(extractHeader(headers, responseHeader), defaultValue);
    }

    public static Integer extractPercentHeader(JSONObject headers, ResponseHeader responseHeader) {
        return m38532b(extractHeader(headers, responseHeader));
    }

    /* renamed from: b */
    static List<String> m38533b(JSONObject headers, ResponseHeader responseHeader) {
        Preconditions.checkNotNull(headers);
        Preconditions.checkNotNull(responseHeader);
        List<String> stringArray = new ArrayList<>();
        JSONArray jsonArray = headers.optJSONArray(responseHeader.getKey());
        if (jsonArray == null) {
            return stringArray;
        }
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                stringArray.add(jsonArray.getString(i));
            } catch (JSONException e) {
                SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to parse item ");
                sb.append(i);
                sb.append(" from ");
                sb.append(responseHeader.getKey());
                MoPubLog.log(sdkLogEvent, sb.toString());
            }
        }
        return stringArray;
    }

    /* renamed from: a */
    static String m38530a(JSONObject headers, ResponseHeader responseHeader) {
        Integer percentHeaderValue = extractPercentHeader(headers, responseHeader);
        if (percentHeaderValue != null) {
            return percentHeaderValue.toString();
        }
        return null;
    }

    /* renamed from: a */
    private static boolean m38531a(String headerValue, boolean defaultValue) {
        if (headerValue == null) {
            return defaultValue;
        }
        return headerValue.equals("1");
    }

    /* renamed from: a */
    private static Integer m38529a(String headerValue) {
        try {
            return Integer.valueOf(Integer.parseInt(headerValue));
        } catch (Exception e) {
            NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);
            numberFormat.setParseIntegerOnly(true);
            try {
                return Integer.valueOf(numberFormat.parse(headerValue.trim()).intValue());
            } catch (Exception e2) {
                return null;
            }
        }
    }

    /* renamed from: b */
    private static Integer m38532b(String headerValue) {
        if (headerValue == null) {
            return null;
        }
        Integer percentValue = m38529a(headerValue.replace("%", ""));
        if (percentValue == null || percentValue.intValue() < 0 || percentValue.intValue() > 100) {
            return null;
        }
        return percentValue;
    }
}
