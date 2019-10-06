package p005cm.aptoide.analytics.implementation;

import java.util.HashMap;
import java.util.Map;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.analytics.AnalyticsManager.Action;

/* renamed from: cm.aptoide.analytics.implementation.PageViewsAnalytics */
public class PageViewsAnalytics {
    public static final String PAGE_VIEW_EVENT = "Page_View";
    private final AnalyticsManager analyticsManager;

    public PageViewsAnalytics(AnalyticsManager analyticsManager2) {
        this.analyticsManager = analyticsManager2;
    }

    public void sendPageViewedEvent(String currentViewName, String previousViewName, String store) {
        this.analyticsManager.logEvent(createEventMap(currentViewName, store), PAGE_VIEW_EVENT, Action.CLICK, previousViewName);
    }

    private Map<String, Object> createEventMap(String currentViewName, String store) {
        Map<String, Object> map = new HashMap<>();
        map.put("fragment", currentViewName);
        map.put("store", store);
        return map;
    }
}
