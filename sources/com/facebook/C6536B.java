package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.facebook.internal.C6676H;
import com.facebook.internal.C6694S;
import com.facebook.internal.C6697T;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.app.view.donations.DonationsAnalytics;

/* renamed from: com.facebook.B */
/* compiled from: LegacyTokenHelper */
final class C6536B {

    /* renamed from: a */
    private static final String f11748a = C6536B.class.getSimpleName();

    /* renamed from: b */
    private String f11749b;

    /* renamed from: c */
    private SharedPreferences f11750c;

    public C6536B(Context context) {
        this(context, null);
    }

    public C6536B(Context context, String cacheKey) {
        C6697T.m13461a((Object) context, "context");
        this.f11749b = C6694S.m13436b(cacheKey) ? "com.facebook.SharedPreferencesTokenCachingStrategy.DEFAULT_KEY" : cacheKey;
        Context applicationContext = context.getApplicationContext();
        this.f11750c = (applicationContext != null ? applicationContext : context).getSharedPreferences(this.f11749b, 0);
    }

    /* renamed from: b */
    public Bundle mo19640b() {
        Bundle settings = new Bundle();
        for (String key : this.f11750c.getAll().keySet()) {
            try {
                m12839a(key, settings);
            } catch (JSONException e) {
                C6537C c = C6537C.CACHE;
                String str = f11748a;
                StringBuilder sb = new StringBuilder();
                sb.append("Error reading cached value for key: '");
                sb.append(key);
                sb.append("' -- ");
                sb.append(e);
                C6676H.m13320a(c, 5, str, sb.toString());
                return null;
            }
        }
        return settings;
    }

    /* renamed from: a */
    public void mo19639a() {
        this.f11750c.edit().clear().apply();
    }

    /* renamed from: d */
    public static boolean m12842d(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        String token = bundle.getString("com.facebook.TokenCachingStrategy.Token");
        if (token == null || token.length() == 0 || bundle.getLong("com.facebook.TokenCachingStrategy.ExpirationDate", 0) == 0) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    public static String m12841c(Bundle bundle) {
        C6697T.m13461a((Object) bundle, "bundle");
        return bundle.getString("com.facebook.TokenCachingStrategy.Token");
    }

    /* renamed from: b */
    public static C6665h m12840b(Bundle bundle) {
        C6697T.m13461a((Object) bundle, "bundle");
        String str = "com.facebook.TokenCachingStrategy.AccessTokenSource";
        if (bundle.containsKey(str)) {
            return (C6665h) bundle.getSerializable(str);
        }
        return bundle.getBoolean("com.facebook.TokenCachingStrategy.IsSSO") ? C6665h.FACEBOOK_APPLICATION_WEB : C6665h.WEB_VIEW;
    }

    /* renamed from: a */
    public static String m12837a(Bundle bundle) {
        C6697T.m13461a((Object) bundle, "bundle");
        return bundle.getString("com.facebook.TokenCachingStrategy.ApplicationId");
    }

    /* renamed from: a */
    static Date m12838a(Bundle bundle, String key) {
        if (bundle == null) {
            return null;
        }
        long n = bundle.getLong(key, Long.MIN_VALUE);
        if (n == Long.MIN_VALUE) {
            return null;
        }
        return new Date(n);
    }

    /* renamed from: a */
    private void m12839a(String key, Bundle bundle) throws JSONException {
        JSONObject json = new JSONObject(this.f11750c.getString(key, "{}"));
        String valueType = json.getString("valueType");
        boolean equals = valueType.equals("bool");
        String str = DonationsAnalytics.VALUE;
        if (equals) {
            bundle.putBoolean(key, json.getBoolean(str));
        } else if (valueType.equals("bool[]")) {
            JSONArray jsonArray = json.getJSONArray(str);
            boolean[] array = new boolean[jsonArray.length()];
            for (int i = 0; i < array.length; i++) {
                array[i] = jsonArray.getBoolean(i);
            }
            bundle.putBooleanArray(key, array);
        } else if (valueType.equals("byte")) {
            bundle.putByte(key, (byte) json.getInt(str));
        } else if (valueType.equals("byte[]")) {
            JSONArray jsonArray2 = json.getJSONArray(str);
            byte[] array2 = new byte[jsonArray2.length()];
            for (int i2 = 0; i2 < array2.length; i2++) {
                array2[i2] = (byte) jsonArray2.getInt(i2);
            }
            bundle.putByteArray(key, array2);
        } else if (valueType.equals("short")) {
            bundle.putShort(key, (short) json.getInt(str));
        } else if (valueType.equals("short[]")) {
            JSONArray jsonArray3 = json.getJSONArray(str);
            short[] array3 = new short[jsonArray3.length()];
            for (int i3 = 0; i3 < array3.length; i3++) {
                array3[i3] = (short) jsonArray3.getInt(i3);
            }
            bundle.putShortArray(key, array3);
        } else if (valueType.equals("int")) {
            bundle.putInt(key, json.getInt(str));
        } else if (valueType.equals("int[]")) {
            JSONArray jsonArray4 = json.getJSONArray(str);
            int[] array4 = new int[jsonArray4.length()];
            for (int i4 = 0; i4 < array4.length; i4++) {
                array4[i4] = jsonArray4.getInt(i4);
            }
            bundle.putIntArray(key, array4);
        } else if (valueType.equals("long")) {
            bundle.putLong(key, json.getLong(str));
        } else if (valueType.equals("long[]")) {
            JSONArray jsonArray5 = json.getJSONArray(str);
            long[] array5 = new long[jsonArray5.length()];
            for (int i5 = 0; i5 < array5.length; i5++) {
                array5[i5] = jsonArray5.getLong(i5);
            }
            bundle.putLongArray(key, array5);
        } else if (valueType.equals("float")) {
            bundle.putFloat(key, (float) json.getDouble(str));
        } else if (valueType.equals("float[]")) {
            JSONArray jsonArray6 = json.getJSONArray(str);
            float[] array6 = new float[jsonArray6.length()];
            for (int i6 = 0; i6 < array6.length; i6++) {
                array6[i6] = (float) jsonArray6.getDouble(i6);
            }
            bundle.putFloatArray(key, array6);
        } else if (valueType.equals("double")) {
            bundle.putDouble(key, json.getDouble(str));
        } else if (valueType.equals("double[]")) {
            JSONArray jsonArray7 = json.getJSONArray(str);
            double[] array7 = new double[jsonArray7.length()];
            for (int i7 = 0; i7 < array7.length; i7++) {
                array7[i7] = jsonArray7.getDouble(i7);
            }
            bundle.putDoubleArray(key, array7);
        } else if (valueType.equals("char")) {
            String charString = json.getString(str);
            if (charString != null && charString.length() == 1) {
                bundle.putChar(key, charString.charAt(0));
            }
        } else if (valueType.equals("char[]")) {
            JSONArray jsonArray8 = json.getJSONArray(str);
            char[] array8 = new char[jsonArray8.length()];
            for (int i8 = 0; i8 < array8.length; i8++) {
                String charString2 = jsonArray8.getString(i8);
                if (charString2 != null && charString2.length() == 1) {
                    array8[i8] = charString2.charAt(0);
                }
            }
            bundle.putCharArray(key, array8);
        } else if (valueType.equals("string")) {
            bundle.putString(key, json.getString(str));
        } else if (valueType.equals("stringList")) {
            JSONArray jsonArray9 = json.getJSONArray(str);
            int numStrings = jsonArray9.length();
            ArrayList<String> stringList = new ArrayList<>(numStrings);
            for (int i9 = 0; i9 < numStrings; i9++) {
                Object jsonStringValue = jsonArray9.get(i9);
                stringList.add(i9, jsonStringValue == JSONObject.NULL ? null : (String) jsonStringValue);
            }
            bundle.putStringArrayList(key, stringList);
        } else if (valueType.equals("enum")) {
            try {
                bundle.putSerializable(key, Enum.valueOf(Class.forName(json.getString("enumType")), json.getString(str)));
            } catch (ClassNotFoundException | IllegalArgumentException e) {
            }
        }
    }
}
