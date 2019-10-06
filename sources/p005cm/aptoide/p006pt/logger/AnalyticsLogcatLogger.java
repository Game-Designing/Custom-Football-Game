package p005cm.aptoide.p006pt.logger;

import p005cm.aptoide.analytics.AnalyticsLogger;

/* renamed from: cm.aptoide.pt.logger.AnalyticsLogcatLogger */
public class AnalyticsLogcatLogger implements AnalyticsLogger {
    public void logDebug(String tag, String msg) {
        Logger.getInstance().mo2136d(tag, msg);
    }

    public void logWarningDebug(String TAG, String msg) {
        Logger.getInstance().mo2148w(TAG, msg);
    }
}
