package p005cm.aptoide.p006pt.downloadmanager;

import p026rx.p028h.C14963c;

/* renamed from: cm.aptoide.pt.downloadmanager.RetryFileDownloadManagerProvider */
public class RetryFileDownloadManagerProvider implements RetryFileDownloaderProvider {
    private FileDownloaderProvider fileDownloaderProvider;

    public RetryFileDownloadManagerProvider(FileDownloaderProvider fileDownloaderProvider2) {
        this.fileDownloaderProvider = fileDownloaderProvider2;
    }

    public RetryFileDownloader createRetryFileDownloader(String md5, String mainDownloadPath, int fileType, String packageName, int versionCode, String fileName, C14963c<FileDownloadCallback> cVar, String alternativeDownloadPath) {
        RetryFileDownloadManager retryFileDownloadManager = new RetryFileDownloadManager(mainDownloadPath, fileType, packageName, versionCode, fileName, md5, this.fileDownloaderProvider, alternativeDownloadPath);
        return retryFileDownloadManager;
    }
}
