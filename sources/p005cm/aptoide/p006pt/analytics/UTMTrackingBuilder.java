package p005cm.aptoide.p006pt.analytics;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.implementation.tracking.Tracking;
import p005cm.aptoide.analytics.implementation.tracking.UTM;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BiUtmAnalyticsRequestBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BiUtmAnalyticsRequestBody.App;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BiUtmAnalyticsRequestBody.Data;

/* renamed from: cm.aptoide.pt.analytics.UTMTrackingBuilder */
public class UTMTrackingBuilder {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Tracking tracking;
    private final UTM utm;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6300269053841491416L, "cm/aptoide/pt/analytics/UTMTrackingBuilder", 15);
        $jacocoData = probes;
        return probes;
    }

    public UTMTrackingBuilder(Tracking tracking2, UTM utm2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.tracking = tracking2;
        this.utm = utm2;
        $jacocoInit[0] = true;
    }

    public Data getUTMTrackingData() {
        boolean[] $jacocoInit = $jacocoInit();
        Data data = new Data();
        $jacocoInit[1] = true;
        data.setEntryPoint(this.utm.getEntryPoint());
        $jacocoInit[2] = true;
        data.setSiteVersion(this.tracking.getSiteVersion());
        $jacocoInit[3] = true;
        data.setUserAgent(this.tracking.getUserAgent());
        $jacocoInit[4] = true;
        App app = new App();
        $jacocoInit[5] = true;
        app.setPackageName(this.tracking.getPackageName());
        $jacocoInit[6] = true;
        app.setUrl(this.tracking.getUrl());
        $jacocoInit[7] = true;
        data.setApp(app);
        $jacocoInit[8] = true;
        BiUtmAnalyticsRequestBody.UTM utm2 = new BiUtmAnalyticsRequestBody.UTM();
        $jacocoInit[9] = true;
        utm2.setCampaign(this.utm.getUtmCampaign());
        $jacocoInit[10] = true;
        utm2.setContent(this.utm.getUtmContent());
        $jacocoInit[11] = true;
        utm2.setMedium(this.utm.getUtmMedium());
        $jacocoInit[12] = true;
        utm2.setSource(this.utm.getUtmSource());
        $jacocoInit[13] = true;
        data.setUtm(utm2);
        $jacocoInit[14] = true;
        return data;
    }
}
