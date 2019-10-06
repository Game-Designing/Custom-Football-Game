package p005cm.aptoide.analytics.implementation.tracking;

/* renamed from: cm.aptoide.analytics.implementation.tracking.UTM */
public class UTM {
    private final String entryPoint;
    private final String utmCampaign;
    private final String utmContent;
    private final String utmMedium;
    private final String utmSource;

    public UTM(String utmSource2, String utmMedium2, String utmCampaign2, String utmContent2, String entryPoint2) {
        this.utmSource = utmSource2;
        this.utmMedium = utmMedium2;
        this.utmCampaign = utmCampaign2;
        this.utmContent = utmContent2;
        this.entryPoint = entryPoint2;
    }

    public String getUtmSource() {
        return this.utmSource;
    }

    public String getUtmMedium() {
        return this.utmMedium;
    }

    public String getUtmCampaign() {
        return this.utmCampaign;
    }

    public String getUtmContent() {
        return this.utmContent;
    }

    public String getEntryPoint() {
        return this.entryPoint;
    }
}
