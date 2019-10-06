package p005cm.aptoide.p006pt.downloadmanager;

/* renamed from: cm.aptoide.pt.downloadmanager.FileDownloadProgressResult */
public class FileDownloadProgressResult {
    private long downloadedBytes;
    private long totalFileBytes;

    public FileDownloadProgressResult(long downloadedBytes2, long totalFileBytes2) {
        this.downloadedBytes = downloadedBytes2;
        this.totalFileBytes = totalFileBytes2;
    }

    public long getDownloadedBytes() {
        return this.downloadedBytes;
    }

    public long getTotalFileBytes() {
        return this.totalFileBytes;
    }
}
