package p005cm.aptoide.analytics.implementation.loggers;

import android.os.Bundle;
import com.facebook.p127a.C6638q;
import java.util.Map;
import java.util.Map.Entry;
import p005cm.aptoide.analytics.AnalyticsLogger;
import p005cm.aptoide.analytics.AnalyticsManager.Action;
import p005cm.aptoide.analytics.EventLogger;

/* renamed from: cm.aptoide.analytics.implementation.loggers.FacebookEventLogger */
public class FacebookEventLogger implements EventLogger {
    private static final String TAG = FacebookEventLogger.class.getSimpleName();
    private final C6638q facebook;
    private final AnalyticsLogger logger;

    public FacebookEventLogger(C6638q facebook2, AnalyticsLogger logger2) {
        this.facebook = facebook2;
        this.logger = logger2;
    }

    public void log(String eventName, Map<String, Object> data, Action action, String context) {
        if (data != null) {
            this.facebook.mo19836a(eventName, mapToBundle(data));
        } else {
            this.facebook.mo19835a(eventName);
        }
        AnalyticsLogger analyticsLogger = this.logger;
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("log() called with: eventName = [");
        sb.append(eventName);
        sb.append("], data = [");
        sb.append(data);
        sb.append("], action = [");
        sb.append(action);
        sb.append("], context = [");
        sb.append(context);
        sb.append("]");
        analyticsLogger.logDebug(str, sb.toString());
    }

    public void setup() {
    }

    private Bundle mapToBundle(Map<String, Object> data) {
        Bundle bundle = new Bundle();
        for (Entry<String, Object> entry : data.entrySet()) {
            bundle.putString((String) entry.getKey(), entry.getValue().toString());
        }
        return bundle;
    }
}
