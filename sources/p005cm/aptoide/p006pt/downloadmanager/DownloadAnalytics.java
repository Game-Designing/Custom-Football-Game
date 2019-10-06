package p005cm.aptoide.p006pt.downloadmanager;

/* renamed from: cm.aptoide.pt.downloadmanager.DownloadAnalytics */
public interface DownloadAnalytics {
    void onDownloadComplete(String str, String str2, int i);

    void onError(String str, int i, Throwable th);
}
