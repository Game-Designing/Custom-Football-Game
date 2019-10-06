package p005cm.aptoide.analytics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: cm.aptoide.analytics.AnalyticsManager */
public class AnalyticsManager {
    private static final String TAG = AnalyticsManager.class.getSimpleName();
    private final AnalyticsLogger analyticsLogger;
    private final KeyValueNormalizer analyticsNormalizer;
    private Map<EventLogger, Collection<String>> eventLoggers;
    private final KnockEventLogger knockEventLogger;
    private List<SessionLogger> sessionLoggers;

    /* renamed from: cm.aptoide.analytics.AnalyticsManager$Action */
    public enum Action {
        CLICK,
        SCROLL,
        INPUT,
        AUTO,
        ROOT,
        VIEW,
        INSTALL,
        OPEN,
        IMPRESSION,
        PULL_REFRESH,
        DISMISS,
        ENDLESS_SCROLL
    }

    /* renamed from: cm.aptoide.analytics.AnalyticsManager$Builder */
    public static class Builder {
        private AnalyticsLogger analyticsLogger;
        private KeyValueNormalizer analyticsNormalizer;
        private final Map<EventLogger, Collection<String>> eventLoggers = new HashMap();
        private KnockEventLogger knockEventLogger;
        private List<SessionLogger> sessionLoggers = new ArrayList();

        public Builder addLogger(EventLogger eventLogger, Collection<String> supportedEvents) {
            this.eventLoggers.put(eventLogger, supportedEvents);
            return this;
        }

        public Builder addSessionLogger(SessionLogger sessionLogger) {
            this.sessionLoggers.add(sessionLogger);
            return this;
        }

        public Builder setDebugLogger(AnalyticsLogger logger) {
            this.analyticsLogger = logger;
            return this;
        }

        public Builder setKnockLogger(KnockEventLogger knockEventLogger2) {
            this.knockEventLogger = knockEventLogger2;
            return this;
        }

        public Builder setAnalyticsNormalizer(KeyValueNormalizer analyticsNormalizer2) {
            this.analyticsNormalizer = analyticsNormalizer2;
            return this;
        }

        public AnalyticsManager build() {
            if (this.knockEventLogger == null) {
                throw new IllegalArgumentException("Analytics manager need an okhttp client");
            } else if (this.eventLoggers.size() >= 1) {
                AnalyticsLogger analyticsLogger2 = this.analyticsLogger;
                if (analyticsLogger2 != null) {
                    AnalyticsManager analyticsManager = new AnalyticsManager(this.knockEventLogger, this.eventLoggers, this.sessionLoggers, this.analyticsNormalizer, analyticsLogger2);
                    return analyticsManager;
                }
                throw new IllegalArgumentException("Analytics manager need a Debug Logger");
            } else {
                throw new IllegalArgumentException("Analytics manager need at least one logger");
            }
        }
    }

    private AnalyticsManager(KnockEventLogger knockLogger, Map<EventLogger, Collection<String>> eventLoggers2, List<SessionLogger> sessionLoggers2, KeyValueNormalizer analyticsNormalizer2, AnalyticsLogger analyticsLogger2) {
        this.knockEventLogger = knockLogger;
        this.eventLoggers = eventLoggers2;
        this.sessionLoggers = sessionLoggers2;
        this.analyticsNormalizer = analyticsNormalizer2;
        this.analyticsLogger = analyticsLogger2;
    }

    public void logEvent(Map<String, Object> data, String eventName, Action action, String context) {
        AnalyticsLogger analyticsLogger2 = this.analyticsLogger;
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("logEvent() called with: eventName = [");
        sb.append(eventName);
        sb.append("], data = [");
        sb.append(data);
        sb.append("],  action = [");
        sb.append(action);
        sb.append("], context = [");
        sb.append(context);
        sb.append("]");
        analyticsLogger2.logDebug(str, sb.toString());
        int eventsSent = 0;
        Map<String, Object> data2 = this.analyticsNormalizer.normalize(data);
        for (Entry<EventLogger, Collection<String>> loggerEntry : this.eventLoggers.entrySet()) {
            if (((Collection) loggerEntry.getValue()).contains(eventName)) {
                ((EventLogger) loggerEntry.getKey()).log(eventName, data2, action, context);
                eventsSent++;
            }
        }
        if (eventsSent <= 0) {
            AnalyticsLogger analyticsLogger3 = this.analyticsLogger;
            String str2 = TAG;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(eventName);
            sb2.append(" event not sent ");
            analyticsLogger3.logWarningDebug(str2, sb2.toString());
        }
    }

    public void logEvent(String url) {
        this.knockEventLogger.log(url);
    }

    public void setup() {
        for (Entry<EventLogger, Collection<String>> loggerEntry : this.eventLoggers.entrySet()) {
            ((EventLogger) loggerEntry.getKey()).setup();
        }
    }

    public void startSession() {
        for (SessionLogger sessionLogger : this.sessionLoggers) {
            sessionLogger.startSession();
        }
    }

    public void endSession() {
        for (SessionLogger sessionLogger : this.sessionLoggers) {
            sessionLogger.endSession();
        }
    }
}
