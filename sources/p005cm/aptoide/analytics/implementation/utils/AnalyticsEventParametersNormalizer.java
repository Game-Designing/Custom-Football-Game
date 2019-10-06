package p005cm.aptoide.analytics.implementation.utils;

import java.util.Map;
import java.util.Map.Entry;
import p005cm.aptoide.analytics.KeyValueNormalizer;

/* renamed from: cm.aptoide.analytics.implementation.utils.AnalyticsEventParametersNormalizer */
public class AnalyticsEventParametersNormalizer implements KeyValueNormalizer {
    public Map<String, Object> normalize(Map<String, Object> data) {
        if (data == null) {
            return null;
        }
        for (Entry<String, Object> entry : data.entrySet()) {
            if (entry.getValue() == null) {
                entry.setValue("");
            }
        }
        return data;
    }
}
