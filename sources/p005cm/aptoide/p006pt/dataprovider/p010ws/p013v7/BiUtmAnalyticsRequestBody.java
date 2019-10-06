package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.BiUtmAnalyticsRequestBody */
public class BiUtmAnalyticsRequestBody extends BaseBody {
    private final Data data;

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.BiUtmAnalyticsRequestBody$App */
    public static class App {
        private String packageName;
        private String url;

        public String getUrl() {
            return this.url;
        }

        public void setUrl(String url2) {
            this.url = url2;
        }

        public String getPackageName() {
            return this.packageName;
        }

        public void setPackageName(String packageName2) {
            this.packageName = packageName2;
        }

        /* access modifiers changed from: protected */
        public boolean canEqual(Object other) {
            return other instanceof App;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof App)) {
                return false;
            }
            App other = (App) o;
            if (!other.canEqual(this)) {
                return false;
            }
            String url2 = getUrl();
            Object other$url = other.getUrl();
            if (url2 != null ? !url2.equals(other$url) : other$url != null) {
                return false;
            }
            String packageName2 = getPackageName();
            Object other$packageName = other.getPackageName();
            if (packageName2 != null ? packageName2.equals(other$packageName) : other$packageName == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            String url2 = getUrl();
            int i = 43;
            int result = (1 * 59) + (url2 == null ? 43 : url2.hashCode());
            String packageName2 = getPackageName();
            int i2 = result * 59;
            if (packageName2 != null) {
                i = packageName2.hashCode();
            }
            return i2 + i;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("BiUtmAnalyticsRequestBody.App(url=");
            sb.append(getUrl());
            sb.append(", packageName=");
            sb.append(getPackageName());
            sb.append(")");
            return sb.toString();
        }
    }

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.BiUtmAnalyticsRequestBody$Data */
    public static class Data {
        private App app;
        private String entryPoint;
        private String siteVersion;
        private String userAgent;
        private UTM utm;

        public String getEntryPoint() {
            return this.entryPoint;
        }

        public void setEntryPoint(String entryPoint2) {
            this.entryPoint = entryPoint2;
        }

        public String getSiteVersion() {
            return this.siteVersion;
        }

        public void setSiteVersion(String siteVersion2) {
            this.siteVersion = siteVersion2;
        }

        public App getApp() {
            return this.app;
        }

        public void setApp(App app2) {
            this.app = app2;
        }

        public UTM getUtm() {
            return this.utm;
        }

        public void setUtm(UTM utm2) {
            this.utm = utm2;
        }

        public String getUserAgent() {
            return this.userAgent;
        }

        public void setUserAgent(String userAgent2) {
            this.userAgent = userAgent2;
        }

        /* access modifiers changed from: protected */
        public boolean canEqual(Object other) {
            return other instanceof Data;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Data)) {
                return false;
            }
            Data other = (Data) o;
            if (!other.canEqual(this)) {
                return false;
            }
            String entryPoint2 = getEntryPoint();
            Object other$entryPoint = other.getEntryPoint();
            if (entryPoint2 != null ? !entryPoint2.equals(other$entryPoint) : other$entryPoint != null) {
                return false;
            }
            String siteVersion2 = getSiteVersion();
            Object other$siteVersion = other.getSiteVersion();
            if (siteVersion2 != null ? !siteVersion2.equals(other$siteVersion) : other$siteVersion != null) {
                return false;
            }
            App app2 = getApp();
            Object other$app = other.getApp();
            if (app2 != null ? !app2.equals(other$app) : other$app != null) {
                return false;
            }
            UTM utm2 = getUtm();
            Object other$utm = other.getUtm();
            if (utm2 != null ? !utm2.equals(other$utm) : other$utm != null) {
                return false;
            }
            String userAgent2 = getUserAgent();
            Object other$userAgent = other.getUserAgent();
            if (userAgent2 != null ? userAgent2.equals(other$userAgent) : other$userAgent == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            String entryPoint2 = getEntryPoint();
            int i = 43;
            int result = (1 * 59) + (entryPoint2 == null ? 43 : entryPoint2.hashCode());
            String siteVersion2 = getSiteVersion();
            int result2 = (result * 59) + (siteVersion2 == null ? 43 : siteVersion2.hashCode());
            App app2 = getApp();
            int result3 = (result2 * 59) + (app2 == null ? 43 : app2.hashCode());
            UTM utm2 = getUtm();
            int result4 = (result3 * 59) + (utm2 == null ? 43 : utm2.hashCode());
            String userAgent2 = getUserAgent();
            int i2 = result4 * 59;
            if (userAgent2 != null) {
                i = userAgent2.hashCode();
            }
            return i2 + i;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("BiUtmAnalyticsRequestBody.Data(entryPoint=");
            sb.append(getEntryPoint());
            sb.append(", siteVersion=");
            sb.append(getSiteVersion());
            sb.append(", app=");
            sb.append(getApp());
            sb.append(", utm=");
            sb.append(getUtm());
            sb.append(", userAgent=");
            sb.append(getUserAgent());
            sb.append(")");
            return sb.toString();
        }
    }

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.BiUtmAnalyticsRequestBody$UTM */
    public static class UTM {
        private String campaign;
        private String content;
        private String medium;
        private String source;

        public String getSource() {
            return this.source;
        }

        public void setSource(String source2) {
            this.source = source2;
        }

        public String getMedium() {
            return this.medium;
        }

        public void setMedium(String medium2) {
            this.medium = medium2;
        }

        public String getCampaign() {
            return this.campaign;
        }

        public void setCampaign(String campaign2) {
            this.campaign = campaign2;
        }

        public String getContent() {
            return this.content;
        }

        public void setContent(String content2) {
            this.content = content2;
        }

        /* access modifiers changed from: protected */
        public boolean canEqual(Object other) {
            return other instanceof UTM;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof UTM)) {
                return false;
            }
            UTM other = (UTM) o;
            if (!other.canEqual(this)) {
                return false;
            }
            String source2 = getSource();
            Object other$source = other.getSource();
            if (source2 != null ? !source2.equals(other$source) : other$source != null) {
                return false;
            }
            String medium2 = getMedium();
            Object other$medium = other.getMedium();
            if (medium2 != null ? !medium2.equals(other$medium) : other$medium != null) {
                return false;
            }
            String campaign2 = getCampaign();
            Object other$campaign = other.getCampaign();
            if (campaign2 != null ? !campaign2.equals(other$campaign) : other$campaign != null) {
                return false;
            }
            String content2 = getContent();
            Object other$content = other.getContent();
            if (content2 != null ? content2.equals(other$content) : other$content == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            String source2 = getSource();
            int i = 43;
            int result = (1 * 59) + (source2 == null ? 43 : source2.hashCode());
            String medium2 = getMedium();
            int result2 = (result * 59) + (medium2 == null ? 43 : medium2.hashCode());
            String campaign2 = getCampaign();
            int result3 = (result2 * 59) + (campaign2 == null ? 43 : campaign2.hashCode());
            String content2 = getContent();
            int i2 = result3 * 59;
            if (content2 != null) {
                i = content2.hashCode();
            }
            return i2 + i;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("BiUtmAnalyticsRequestBody.UTM(source=");
            sb.append(getSource());
            sb.append(", medium=");
            sb.append(getMedium());
            sb.append(", campaign=");
            sb.append(getCampaign());
            sb.append(", content=");
            sb.append(getContent());
            sb.append(")");
            return sb.toString();
        }
    }

    public BiUtmAnalyticsRequestBody(Data data2) {
        this.data = data2;
    }

    public Data getData() {
        return this.data;
    }

    public int hashCode() {
        Data data2 = getData();
        return (1 * 59) + (data2 == null ? 43 : data2.hashCode());
    }

    /* access modifiers changed from: protected */
    public boolean canEqual(Object other) {
        return other instanceof BiUtmAnalyticsRequestBody;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof BiUtmAnalyticsRequestBody)) {
            return false;
        }
        BiUtmAnalyticsRequestBody other = (BiUtmAnalyticsRequestBody) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Data data2 = getData();
        Object other$data = other.getData();
        if (data2 != null ? data2.equals(other$data) : other$data == null) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BiUtmAnalyticsRequestBody(data=");
        sb.append(getData());
        sb.append(")");
        return sb.toString();
    }
}
