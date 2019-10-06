package p005cm.aptoide.analytics.implementation.network;

import java.util.Map;

/* renamed from: cm.aptoide.analytics.implementation.network.AnalyticsEventRequestBody */
public class AnalyticsEventRequestBody extends AnalyticsBaseBody {
    private final Map<String, Object> data;
    private final String timestamp;

    public AnalyticsEventRequestBody(Map<String, Object> data2, String timestamp2) {
        this.data = data2;
        this.timestamp = timestamp2;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public Map<String, Object> getData() {
        return this.data;
    }
}
