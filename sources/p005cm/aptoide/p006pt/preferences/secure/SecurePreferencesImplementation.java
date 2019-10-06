package p005cm.aptoide.p006pt.preferences.secure;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Build.VERSION;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import p005cm.aptoide.p006pt.preferences.secure.SecureCoderDecoder.Builder;

/* renamed from: cm.aptoide.pt.preferences.secure.SecurePreferencesImplementation */
public class SecurePreferencesImplementation implements SharedPreferences {
    private static final String TAG = SecurePreferencesImplementation.class.getName();
    private static SharedPreferences instance;
    /* access modifiers changed from: private */
    public static SharedPreferences sFile;
    /* access modifiers changed from: private */
    public static SecureCoderDecoder secureCoderDecoder;

    /* renamed from: cm.aptoide.pt.preferences.secure.SecurePreferencesImplementation$Editor */
    public static class Editor implements android.content.SharedPreferences.Editor {
        private android.content.SharedPreferences.Editor mEditor;

        @SuppressLint({"CommitPrefEdits"})
        private Editor() {
            this.mEditor = SecurePreferencesImplementation.sFile.edit();
        }

        public android.content.SharedPreferences.Editor putString(String key, String value) {
            this.mEditor.putString(SecurePreferencesImplementation.secureCoderDecoder.encrypt(key), SecurePreferencesImplementation.secureCoderDecoder.encrypt(value));
            return this;
        }

        @TargetApi(11)
        public android.content.SharedPreferences.Editor putStringSet(String key, Set<String> values) {
            Set<String> encryptedValues = new HashSet<>(values.size());
            for (String value : values) {
                encryptedValues.add(SecurePreferencesImplementation.secureCoderDecoder.encrypt(value));
            }
            this.mEditor.putStringSet(SecurePreferencesImplementation.secureCoderDecoder.encrypt(key), encryptedValues);
            return this;
        }

        public android.content.SharedPreferences.Editor putInt(String key, int value) {
            this.mEditor.putString(SecurePreferencesImplementation.secureCoderDecoder.encrypt(key), SecurePreferencesImplementation.secureCoderDecoder.encrypt(Integer.toString(value)));
            return this;
        }

        public android.content.SharedPreferences.Editor putLong(String key, long value) {
            this.mEditor.putString(SecurePreferencesImplementation.secureCoderDecoder.encrypt(key), SecurePreferencesImplementation.secureCoderDecoder.encrypt(Long.toString(value)));
            return this;
        }

        public android.content.SharedPreferences.Editor putFloat(String key, float value) {
            this.mEditor.putString(SecurePreferencesImplementation.secureCoderDecoder.encrypt(key), SecurePreferencesImplementation.secureCoderDecoder.encrypt(Float.toString(value)));
            return this;
        }

        public android.content.SharedPreferences.Editor putBoolean(String key, boolean value) {
            this.mEditor.putString(SecurePreferencesImplementation.secureCoderDecoder.encrypt(key), SecurePreferencesImplementation.secureCoderDecoder.encrypt(Boolean.toString(value)));
            return this;
        }

        public android.content.SharedPreferences.Editor remove(String key) {
            this.mEditor.remove(SecurePreferencesImplementation.secureCoderDecoder.encrypt(key));
            return this;
        }

        public android.content.SharedPreferences.Editor clear() {
            this.mEditor.clear();
            return this;
        }

        public boolean commit() {
            return this.mEditor.commit();
        }

        @TargetApi(9)
        public void apply() {
            if (VERSION.SDK_INT >= 9) {
                this.mEditor.apply();
            } else {
                commit();
            }
        }

        public android.content.SharedPreferences.Editor putStringNoEncrypted(String key, String value) {
            this.mEditor.putString(SecurePreferencesImplementation.secureCoderDecoder.encrypt(key), value);
            return this;
        }
    }

    public SecurePreferencesImplementation(Context context, SharedPreferences sharedPreferences) {
        if (sFile == null) {
            sFile = sharedPreferences;
        }
        if (secureCoderDecoder == null) {
            secureCoderDecoder = new Builder(context, sFile).create();
        }
    }

    public static SharedPreferences getInstance(Context context, SharedPreferences sharedPreferences) {
        if (instance == null) {
            synchronized (SecurePreferencesImplementation.class) {
                if (instance == null) {
                    instance = new SecurePreferencesImplementation(context, sharedPreferences);
                }
            }
        }
        return instance;
    }

    public Map<String, String> getAll() {
        Map<String, ?> encryptedMap = sFile.getAll();
        Map<String, String> decryptedMap = new HashMap<>(encryptedMap.size());
        for (Entry<String, ?> entry : encryptedMap.entrySet()) {
            try {
                decryptedMap.put(secureCoderDecoder.decrypt((String) entry.getKey()), secureCoderDecoder.decrypt(entry.getValue().toString()));
            } catch (Exception e) {
            }
        }
        return decryptedMap;
    }

    public String getString(String key, String defaultValue) {
        String encryptedValue = sFile.getString(secureCoderDecoder.encrypt(key), null);
        return encryptedValue != null ? secureCoderDecoder.decrypt(encryptedValue) : defaultValue;
    }

    @TargetApi(11)
    public Set<String> getStringSet(String key, Set<String> defaultValues) {
        Set<String> encryptedSet = sFile.getStringSet(secureCoderDecoder.encrypt(key), null);
        if (encryptedSet == null) {
            return defaultValues;
        }
        Set<String> decryptedSet = new HashSet<>(encryptedSet.size());
        for (String encryptedValue : encryptedSet) {
            decryptedSet.add(secureCoderDecoder.decrypt(encryptedValue));
        }
        return decryptedSet;
    }

    public int getInt(String key, int defaultValue) {
        String encryptedValue = sFile.getString(secureCoderDecoder.encrypt(key), null);
        if (encryptedValue == null) {
            return defaultValue;
        }
        try {
            return Integer.parseInt(secureCoderDecoder.decrypt(encryptedValue));
        } catch (NumberFormatException e) {
            throw new ClassCastException(e.getMessage());
        }
    }

    public long getLong(String key, long defaultValue) {
        String encryptedValue = sFile.getString(secureCoderDecoder.encrypt(key), null);
        if (encryptedValue == null) {
            return defaultValue;
        }
        try {
            return Long.parseLong(secureCoderDecoder.decrypt(encryptedValue));
        } catch (NumberFormatException e) {
            throw new ClassCastException(e.getMessage());
        }
    }

    public float getFloat(String key, float defaultValue) {
        String encryptedValue = sFile.getString(secureCoderDecoder.encrypt(key), null);
        if (encryptedValue == null) {
            return defaultValue;
        }
        try {
            return Float.parseFloat(secureCoderDecoder.decrypt(encryptedValue));
        } catch (NumberFormatException e) {
            throw new ClassCastException(e.getMessage());
        }
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        String encryptedValue = sFile.getString(secureCoderDecoder.encrypt(key), null);
        if (encryptedValue == null) {
            return defaultValue;
        }
        try {
            return Boolean.parseBoolean(secureCoderDecoder.decrypt(encryptedValue));
        } catch (NumberFormatException e) {
            throw new ClassCastException(e.getMessage());
        }
    }

    public boolean contains(String key) {
        return sFile.contains(secureCoderDecoder.encrypt(key));
    }

    public Editor edit() {
        return new Editor();
    }

    public void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener listener) {
        sFile.registerOnSharedPreferenceChangeListener(listener);
    }

    public void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener listener) {
        sFile.unregisterOnSharedPreferenceChangeListener(listener);
    }
}
