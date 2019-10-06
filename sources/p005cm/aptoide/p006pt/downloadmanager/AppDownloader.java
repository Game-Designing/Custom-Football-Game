package p005cm.aptoide.p006pt.downloadmanager;

import p026rx.C0117M;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.downloadmanager.AppDownloader */
public interface AppDownloader {
    C0120S<AppDownloadStatus> observeDownloadProgress();

    C0117M pauseAppDownload();

    C0117M removeAppDownload();

    void startAppDownload();

    void stop();
}
