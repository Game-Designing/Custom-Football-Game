package com.integralads.avid.library.inmobi.utils;

import android.content.Context;
import android.content.res.Resources;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AvidJSONUtil {
    private static String[] KEYS = {"x", "y", "width", "height"};
    public static final String KEY_CHILD_VIEWS = "childViews";
    public static final String KEY_HEIGHT = "height";
    public static final String KEY_ID = "id";
    public static final String KEY_IS_FRIENDLY_OBSTRUCTION_FOR = "isFriendlyObstructionFor";
    public static final String KEY_ROOT_VIEW = "rootView";
    public static final String KEY_TIMESTAMP = "timestamp";
    public static final String KEY_WIDTH = "width";
    public static final String KEY_X = "x";
    public static final String KEY_Y = "y";
    static float density = Resources.getSystem().getDisplayMetrics().density;

    public static void init(Context context) {
        if (context != null) {
            density = context.getResources().getDisplayMetrics().density;
        }
    }

    public static JSONObject getEmptyTreeJSONObject() {
        return getTreeJSONObject(getViewState(0, 0, 0, 0), AvidTimestamp.getCurrentTime());
    }

    public static JSONObject getTreeJSONObject(JSONObject jSONObject, double d) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("timestamp", d);
            jSONObject2.put("rootView", jSONObject);
        } catch (JSONException e) {
            AvidLogs.m35374e("Error with creating treeJSONObject", e);
        }
        return jSONObject2;
    }

    public static JSONObject getViewState(int i, int i2, int i3, int i4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", (double) pxToDp(i));
            jSONObject.put("y", (double) pxToDp(i2));
            jSONObject.put("width", (double) pxToDp(i3));
            jSONObject.put("height", (double) pxToDp(i4));
        } catch (JSONException e) {
            AvidLogs.m35374e("Error with creating viewStateObject", e);
        }
        return jSONObject;
    }

    static float pxToDp(int i) {
        return ((float) i) / density;
    }

    public static void addAvidId(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("id", str);
        } catch (JSONException e) {
            AvidLogs.m35374e("Error with setting avid id", e);
        }
    }

    public static void addFriendlyObstruction(JSONObject jSONObject, List<String> list) {
        JSONArray jSONArray = new JSONArray();
        for (String put : list) {
            jSONArray.put(put);
        }
        try {
            jSONObject.put("isFriendlyObstructionFor", jSONArray);
        } catch (JSONException e) {
            AvidLogs.m35374e("Error with setting friendly obstruction", e);
        }
    }

    public static void addChildState(JSONObject jSONObject, JSONObject jSONObject2) {
        String str = "childViews";
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray(str);
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
                jSONObject.put(str, optJSONArray);
            }
            optJSONArray.put(jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void fixStateFrame(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("childViews");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                String str = "height";
                String str2 = "width";
                if (i < length) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        int optInt = optJSONObject.optInt("x");
                        int optInt2 = optJSONObject.optInt("y");
                        int optInt3 = optJSONObject.optInt(str2);
                        int optInt4 = optJSONObject.optInt(str);
                        i2 = Math.max(i2, optInt + optInt3);
                        i3 = Math.max(i3, optInt2 + optInt4);
                    }
                    i++;
                } else {
                    try {
                        jSONObject.put(str2, i2);
                        jSONObject.put(str, i3);
                        return;
                    } catch (JSONException e) {
                        e.printStackTrace();
                        return;
                    }
                }
            }
        }
    }

    public static boolean equalStates(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject2 != null && compareRequiredValues(jSONObject, jSONObject2) && compareSessionId(jSONObject, jSONObject2) && compareFriendlySessionIds(jSONObject, jSONObject2) && compareChildren(jSONObject, jSONObject2)) {
            return true;
        }
        return false;
    }

    private static boolean compareRequiredValues(JSONObject jSONObject, JSONObject jSONObject2) {
        String[] strArr;
        for (String str : KEYS) {
            if (jSONObject.optDouble(str) != jSONObject2.optDouble(str)) {
                return false;
            }
        }
        return true;
    }

    private static boolean compareSessionId(JSONObject jSONObject, JSONObject jSONObject2) {
        String str = "";
        String str2 = "id";
        return jSONObject.optString(str2, str).equals(jSONObject2.optString(str2, str));
    }

    private static boolean compareFriendlySessionIds(JSONObject jSONObject, JSONObject jSONObject2) {
        String str = "isFriendlyObstructionFor";
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        JSONArray optJSONArray2 = jSONObject2.optJSONArray(str);
        if (!compareJSONArrays(optJSONArray, optJSONArray2)) {
            return false;
        }
        if (optJSONArray == null) {
            return true;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            String str2 = "";
            if (!optJSONArray.optString(i, str2).equals(optJSONArray2.optString(i, str2))) {
                return false;
            }
        }
        return true;
    }

    private static boolean compareChildren(JSONObject jSONObject, JSONObject jSONObject2) {
        String str = "childViews";
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        JSONArray optJSONArray2 = jSONObject2.optJSONArray(str);
        if (!compareJSONArrays(optJSONArray, optJSONArray2)) {
            return false;
        }
        if (optJSONArray == null) {
            return true;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            if (!equalStates(optJSONArray.optJSONObject(i), optJSONArray2.optJSONObject(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean compareJSONArrays(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null && jSONArray2 == null) {
            return true;
        }
        if ((jSONArray != null || jSONArray2 == null) && ((jSONArray == null || jSONArray2 != null) && jSONArray.length() == jSONArray2.length())) {
            return true;
        }
        return false;
    }
}
