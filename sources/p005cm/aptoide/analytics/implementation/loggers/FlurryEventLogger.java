package p005cm.aptoide.analytics.implementation.loggers;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import p005cm.aptoide.analytics.AnalyticsLogger;
import p005cm.aptoide.analytics.AnalyticsManager.Action;
import p005cm.aptoide.analytics.EventLogger;
import p005cm.aptoide.analytics.SessionLogger;
import p019d.p020e.p021a.C7294e;

/* renamed from: cm.aptoide.analytics.implementation.loggers.FlurryEventLogger */
public class FlurryEventLogger implements EventLogger, SessionLogger {
    private static final String TAG = FlurryEventLogger.class.getSimpleName();
    private Context context;
    private final AnalyticsLogger logger;

    public FlurryEventLogger(Context context2, AnalyticsLogger logger2) {
        this.context = context2;
        this.logger = logger2;
    }

    public void log(String eventName, Map<String, Object> data, Action action, String context2) {
        if (data != null) {
            C7294e.m15859a(eventName, map(data));
        } else {
            C7294e.m15858a(eventName);
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
        sb.append(context2);
        sb.append("]");
        analyticsLogger.logDebug(str, sb.toString());
    }

    public void setup() {
    }

    private Map<String, String> map(Map<String, Object> data) {
        Map<String, String> map = new HashMap<>();
        for (Entry<String, Object> entry : data.entrySet()) {
            if (entry.getValue() != null) {
                map.put(entry.getKey(), entry.getValue().toString());
            }
        }
        return map;
    }

    public void startSession() {
        C7294e.m15868b(this.context);
    }

    public void endSession() {
        C7294e.m15862a(this.context);
    }
}
