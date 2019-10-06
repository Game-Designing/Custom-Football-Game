package p005cm.aptoide.p006pt.app;

import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsManager;

/* renamed from: cm.aptoide.pt.app.CampaignAnalytics */
public class CampaignAnalytics {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final AnalyticsManager analyticsManager;
    private final Map<String, CampaignEvent> cache;

    /* renamed from: cm.aptoide.pt.app.CampaignAnalytics$CampaignEvent */
    public static class CampaignEvent {
        private static transient /* synthetic */ boolean[] $jacocoData;
        private String packageName;
        private String url;
        private int vercode;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(-3686597141628920252L, "cm/aptoide/pt/app/CampaignAnalytics$CampaignEvent", 4);
            $jacocoData = probes;
            return probes;
        }

        public CampaignEvent(String url2, String packageName2, int vercode2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.url = url2;
            this.packageName = packageName2;
            this.vercode = vercode2;
            $jacocoInit[0] = true;
        }

        public String getUrl() {
            boolean[] $jacocoInit = $jacocoInit();
            String str = this.url;
            $jacocoInit[1] = true;
            return str;
        }

        public String getPackageName() {
            boolean[] $jacocoInit = $jacocoInit();
            String str = this.packageName;
            $jacocoInit[2] = true;
            return str;
        }

        public int getVercode() {
            boolean[] $jacocoInit = $jacocoInit();
            int i = this.vercode;
            $jacocoInit[3] = true;
            return i;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8644378347338267723L, "cm/aptoide/pt/app/CampaignAnalytics", 10);
        $jacocoData = probes;
        return probes;
    }

    public CampaignAnalytics(Map<String, CampaignEvent> cache2, AnalyticsManager analyticsManager2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.cache = cache2;
        this.analyticsManager = analyticsManager2;
        $jacocoInit[0] = true;
    }

    public void sendCampaignConversionEvent(String url, String packageName, int vercode) {
        boolean[] $jacocoInit = $jacocoInit();
        CampaignEvent event = new CampaignEvent(url, packageName, vercode);
        $jacocoInit[1] = true;
        Map<String, CampaignEvent> map = this.cache;
        StringBuilder sb = new StringBuilder();
        sb.append(packageName);
        sb.append(String.valueOf(vercode));
        map.put(sb.toString(), event);
        $jacocoInit[2] = true;
    }

    public void convertCampaignEvent(String packageName, int vercode) {
        boolean[] $jacocoInit = $jacocoInit();
        StringBuilder sb = new StringBuilder();
        sb.append(packageName);
        sb.append(String.valueOf(vercode));
        String cacheKey = sb.toString();
        $jacocoInit[3] = true;
        if (!this.cache.containsKey(cacheKey)) {
            $jacocoInit[4] = true;
        } else {
            $jacocoInit[5] = true;
            AnalyticsManager analyticsManager2 = this.analyticsManager;
            CampaignEvent campaignEvent = (CampaignEvent) this.cache.get(cacheKey);
            $jacocoInit[6] = true;
            String url = campaignEvent.getUrl();
            $jacocoInit[7] = true;
            analyticsManager2.logEvent(url);
            $jacocoInit[8] = true;
        }
        $jacocoInit[9] = true;
    }
}
