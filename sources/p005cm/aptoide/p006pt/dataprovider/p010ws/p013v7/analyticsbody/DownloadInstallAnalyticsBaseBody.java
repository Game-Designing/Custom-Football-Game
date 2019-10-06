package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.analyticsbody;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.analyticsbody.DownloadInstallAnalyticsBaseBody */
public class DownloadInstallAnalyticsBaseBody extends AnalyticsBaseBody {
    private final Data data;

    public DownloadInstallAnalyticsBaseBody(String hostPackageName, Data data2) {
        super(hostPackageName);
        this.data = data2;
    }

    public Data getData() {
        return this.data;
    }
}
