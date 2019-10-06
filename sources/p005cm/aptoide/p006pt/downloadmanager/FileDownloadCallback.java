package p005cm.aptoide.p006pt.downloadmanager;

import p005cm.aptoide.p006pt.downloadmanager.AppDownloadStatus.AppDownloadState;

/* renamed from: cm.aptoide.pt.downloadmanager.FileDownloadCallback */
public interface FileDownloadCallback {
    FileDownloadProgressResult getDownloadProgress();

    AppDownloadState getDownloadState();

    Throwable getError();

    String getMd5();

    boolean hasError();
}
