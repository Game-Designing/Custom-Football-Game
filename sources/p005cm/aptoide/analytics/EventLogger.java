package p005cm.aptoide.analytics;

import java.util.Map;
import p005cm.aptoide.analytics.AnalyticsManager.Action;

/* renamed from: cm.aptoide.analytics.EventLogger */
public interface EventLogger {
    void log(String str, Map<String, Object> map, Action action, String str2);

    void setup();
}
