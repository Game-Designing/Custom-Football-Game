package p005cm.aptoide.analytics.implementation.loggers;

import com.crashlytics.android.p124a.C6378b;
import com.crashlytics.android.p124a.C6397t;
import java.util.Map;
import java.util.Map.Entry;
import p005cm.aptoide.analytics.AnalyticsLogger;
import p005cm.aptoide.analytics.AnalyticsManager.Action;
import p005cm.aptoide.analytics.EventLogger;

/* renamed from: cm.aptoide.analytics.implementation.loggers.FabricEventLogger */
public class FabricEventLogger implements EventLogger {
    private static final String TAG = FabricEventLogger.class.getSimpleName();
    private final C6378b fabric;
    private final AnalyticsLogger logger;

    public FabricEventLogger(C6378b fabric2, AnalyticsLogger logger2) {
        this.fabric = fabric2;
        this.logger = logger2;
    }

    public void log(String eventName, Map<String, Object> data, Action action, String context) {
        C6397t customEvent = new C6397t(eventName);
        if (data != null && !data.isEmpty()) {
            for (Entry<String, Object> attribute : data.entrySet()) {
                customEvent.mo19383a((String) attribute.getKey(), attribute.getValue().toString());
            }
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
        this.fabric.mo19377a(customEvent);
    }

    public void setup() {
    }
}
