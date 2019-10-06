package p005cm.aptoide.p006pt.downloadmanager;

import p026rx.C0117M;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.downloadmanager.RetryFileDownloader */
public interface RetryFileDownloader {
    C0120S<FileDownloadCallback> observeFileDownloadProgress();

    C0117M pauseDownload();

    C0117M removeDownloadFile();

    void startFileDownload();

    void stop();

    void stopFailedDownload();
}
