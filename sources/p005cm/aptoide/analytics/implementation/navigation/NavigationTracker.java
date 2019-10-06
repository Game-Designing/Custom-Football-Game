package p005cm.aptoide.analytics.implementation.navigation;

import java.util.Collections;
import java.util.List;
import p005cm.aptoide.analytics.AnalyticsLogger;
import p005cm.aptoide.analytics.implementation.PageViewsAnalytics;

/* renamed from: cm.aptoide.analytics.implementation.navigation.NavigationTracker */
public class NavigationTracker {
    private static final String TAG = NavigationTracker.class.getSimpleName();
    private List<ScreenTagHistory> historyList;
    private final AnalyticsLogger logger;
    private PageViewsAnalytics pageViewsAnalytics;
    private final ViewNameFilter viewNameFilter;

    public NavigationTracker(List<ScreenTagHistory> historyList2, ViewNameFilter viewNameFilter2, PageViewsAnalytics pageViewsAnalytics2, AnalyticsLogger logger2) {
        this.historyList = historyList2;
        this.viewNameFilter = viewNameFilter2;
        this.pageViewsAnalytics = pageViewsAnalytics2;
        this.logger = logger2;
    }

    public void registerScreen(ScreenTagHistory screenTagHistory) {
        if (screenTagHistory != null && filter(screenTagHistory)) {
            this.historyList.add(screenTagHistory);
            this.pageViewsAnalytics.sendPageViewedEvent(getViewName(true), getViewName(false), screenTagHistory.getStore());
            AnalyticsLogger analyticsLogger = this.logger;
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("NavigationTracker size: ");
            sb.append(this.historyList.size());
            sb.append("   Registering screen: ");
            sb.append(screenTagHistory);
            analyticsLogger.logDebug(str, sb.toString());
        }
    }

    public ScreenTagHistory getCurrentScreen() {
        if (this.historyList.isEmpty()) {
            return new ScreenTagHistory();
        }
        List<ScreenTagHistory> list = this.historyList;
        return (ScreenTagHistory) list.get(list.size() - 1);
    }

    public List<ScreenTagHistory> getHistoryList() {
        return this.historyList;
    }

    public ScreenTagHistory getPreviousScreen() {
        if (this.historyList.size() < 2) {
            return new ScreenTagHistory();
        }
        List<ScreenTagHistory> list = this.historyList;
        return (ScreenTagHistory) list.get(list.size() - 2);
    }

    public String getPreviousViewName() {
        if (this.historyList.size() < 2) {
            return "";
        }
        List<ScreenTagHistory> list = this.historyList;
        return ((ScreenTagHistory) list.get(list.size() - 2)).getFragment();
    }

    public String getCurrentViewName() {
        if (this.historyList.isEmpty()) {
            return "";
        }
        List<ScreenTagHistory> list = this.historyList;
        return ((ScreenTagHistory) list.get(list.size() - 1)).getFragment();
    }

    private boolean filter(ScreenTagHistory screenTagHistory) {
        return this.viewNameFilter.filter(screenTagHistory.getFragment());
    }

    public String getPrettyScreenHistory() {
        StringBuilder sb = new StringBuilder();
        List<ScreenTagHistory> tmp = this.historyList;
        Collections.reverse(tmp);
        for (ScreenTagHistory screen : tmp) {
            sb.append("[");
            sb.append(screen.toString());
            sb.append("]");
        }
        return sb.toString();
    }

    public String getViewName(boolean isCurrent) {
        String viewName = "";
        if (!isCurrent) {
            return getPreviousViewName();
        }
        try {
            return getCurrentViewName();
        } catch (NullPointerException e) {
            return viewName;
        }
    }
}
