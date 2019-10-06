package p005cm.aptoide.analytics.implementation.tracking;

/* renamed from: cm.aptoide.analytics.implementation.tracking.Tracking */
public class Tracking {
    private final String browser;
    private final String country;
    private final String packageName;
    private final String siteVersion;
    private final String url;
    private final String userAgent;

    public Tracking(String url2, String packageName2, String country2, String browser2, String siteVersion2, String userAgent2) {
        this.url = url2;
        this.packageName = packageName2;
        this.country = country2;
        this.browser = browser2;
        this.siteVersion = siteVersion2;
        this.userAgent = userAgent2;
    }

    public String getUrl() {
        return this.url;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getCountry() {
        return this.country;
    }

    public String getBrowser() {
        return this.browser;
    }

    public String getSiteVersion() {
        return this.siteVersion;
    }

    public String getUserAgent() {
        return this.userAgent;
    }
}
