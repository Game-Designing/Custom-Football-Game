package p005cm.aptoide.analytics.implementation.persistence;

import android.content.SharedPreferences;
import p005cm.aptoide.analytics.implementation.SessionPersistence;

/* renamed from: cm.aptoide.analytics.implementation.persistence.SharedPreferencesSessionPersistence */
public class SharedPreferencesSessionPersistence implements SessionPersistence {
    private final SharedPreferences sharedPreferences;

    public SharedPreferencesSessionPersistence(SharedPreferences sharedPreferences2) {
        this.sharedPreferences = sharedPreferences2;
    }

    public void saveSessionTimestamp(long timestamp) {
        this.sharedPreferences.edit().putLong("session_timestamp", timestamp).apply();
    }

    public long getTimestamp() {
        return this.sharedPreferences.getLong("session_timestamp", 0);
    }
}
