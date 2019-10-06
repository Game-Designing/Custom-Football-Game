package p005cm.aptoide.p006pt.downloadmanager;

import p026rx.C0117M;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.downloadmanager.FileDownloader */
public interface FileDownloader {
    C0120S<FileDownloadCallback> observeFileDownloadProgress();

    C0117M pauseDownload();

    C0117M removeDownloadFile();

    C0117M startFileDownload();

    void stopFailedDownload();
}
