package com.unity3d.services.core.preferences;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.properties.ClientProperties;

public class AndroidPreferences {
    public static boolean hasKey(String name, String key) {
        SharedPreferences settings = ClientProperties.getApplicationContext().getSharedPreferences(name, 0);
        if (settings == null || !settings.contains(key)) {
            return false;
        }
        return true;
    }

    public static String getString(String name, String key) {
        SharedPreferences settings = ClientProperties.getApplicationContext().getSharedPreferences(name, 0);
        if (settings == null || !settings.contains(key)) {
            return null;
        }
        try {
            return settings.getString(key, "");
        } catch (ClassCastException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unity Ads failed to cast ");
            sb.append(key);
            sb.append(": ");
            sb.append(e.getMessage());
            DeviceLog.error(sb.toString());
            return null;
        }
    }

    public static Integer getInteger(String name, String key) {
        SharedPreferences settings = ClientProperties.getApplicationContext().getSharedPreferences(name, 0);
        if (settings == null || !settings.contains(key)) {
            return null;
        }
        try {
            return Integer.valueOf(settings.getInt(key, -1));
        } catch (ClassCastException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unity Ads failed to cast ");
            sb.append(key);
            sb.append(": ");
            sb.append(e.getMessage());
            DeviceLog.error(sb.toString());
            return null;
        }
    }

    public static Long getLong(String name, String key) {
        SharedPreferences settings = ClientProperties.getApplicationContext().getSharedPreferences(name, 0);
        if (settings == null || !settings.contains(key)) {
            return null;
        }
        try {
            return Long.valueOf(settings.getLong(key, -1));
        } catch (ClassCastException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unity Ads failed to cast ");
            sb.append(key);
            sb.append(": ");
            sb.append(e.getMessage());
            DeviceLog.error(sb.toString());
            return null;
        }
    }

    public static Boolean getBoolean(String name, String key) {
        SharedPreferences settings = ClientProperties.getApplicationContext().getSharedPreferences(name, 0);
        if (settings == null || !settings.contains(key)) {
            return null;
        }
        try {
            return Boolean.valueOf(settings.getBoolean(key, false));
        } catch (ClassCastException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unity Ads failed to cast ");
            sb.append(key);
            sb.append(": ");
            sb.append(e.getMessage());
            DeviceLog.error(sb.toString());
            return null;
        }
    }

    public static Float getFloat(String name, String key) {
        SharedPreferences settings = ClientProperties.getApplicationContext().getSharedPreferences(name, 0);
        if (settings == null || !settings.contains(key)) {
            return null;
        }
        try {
            return Float.valueOf(settings.getFloat(key, Float.NaN));
        } catch (ClassCastException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unity Ads failed to cast ");
            sb.append(key);
            sb.append(": ");
            sb.append(e.getMessage());
            DeviceLog.error(sb.toString());
            return null;
        }
    }

    public static void setString(String name, String key, String value) {
        SharedPreferences settings = ClientProperties.getApplicationContext().getSharedPreferences(name, 0);
        if (settings != null) {
            Editor editor = settings.edit();
            editor.putString(key, value);
            editor.commit();
        }
    }

    public static void setInteger(String name, String key, Integer value) {
        SharedPreferences settings = ClientProperties.getApplicationContext().getSharedPreferences(name, 0);
        if (settings != null) {
            Editor editor = settings.edit();
            editor.putInt(key, value.intValue());
            editor.commit();
        }
    }

    public static void setLong(String name, String key, Long value) {
        SharedPreferences settings = ClientProperties.getApplicationContext().getSharedPreferences(name, 0);
        if (settings != null) {
            Editor editor = settings.edit();
            editor.putLong(key, value.longValue());
            editor.commit();
        }
    }

    public static void setBoolean(String name, String key, Boolean value) {
        SharedPreferences settings = ClientProperties.getApplicationContext().getSharedPreferences(name, 0);
        if (settings != null) {
            Editor editor = settings.edit();
            editor.putBoolean(key, value.booleanValue());
            editor.commit();
        }
    }

    public static void setFloat(String name, String key, Double value) {
        SharedPreferences settings = ClientProperties.getApplicationContext().getSharedPreferences(name, 0);
        if (settings != null) {
            Editor editor = settings.edit();
            editor.putFloat(key, value.floatValue());
            editor.commit();
        }
    }

    public static void removeKey(String name, String key) {
        SharedPreferences settings = ClientProperties.getApplicationContext().getSharedPreferences(name, 0);
        if (settings != null) {
            Editor editor = settings.edit();
            editor.remove(key);
            editor.commit();
        }
    }
}
