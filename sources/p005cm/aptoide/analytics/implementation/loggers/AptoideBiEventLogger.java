package p005cm.aptoide.analytics.implementation.loggers;

import java.util.Map;
import p005cm.aptoide.analytics.AnalyticsManager.Action;
import p005cm.aptoide.analytics.EventLogger;
import p005cm.aptoide.analytics.SessionLogger;
import p005cm.aptoide.analytics.implementation.AptoideBiAnalytics;

/* renamed from: cm.aptoide.analytics.implementation.loggers.AptoideBiEventLogger */
public class AptoideBiEventLogger implements EventLogger, SessionLogger {
    private final AptoideBiAnalytics service;
    private final long sessionInterval;

    public AptoideBiEventLogger(AptoideBiAnalytics service2, long sessionInterval2) {
        this.service = service2;
        this.sessionInterval = sessionInterval2;
    }

    public void log(String eventName, Map<String, Object> data, Action action, String context) {
        this.service.log(eventName, data, action, context);
    }

    public void setup() {
        this.service.setup();
    }

    public void startSession() {
        if (System.currentTimeMillis() - this.service.getTimestamp() > this.sessionInterval) {
            this.service.log("SESSION", null, Action.OPEN, "APPLICATION");
        }
        this.service.saveTimestamp(System.currentTimeMillis());
    }

    public void endSession() {
    }
}
