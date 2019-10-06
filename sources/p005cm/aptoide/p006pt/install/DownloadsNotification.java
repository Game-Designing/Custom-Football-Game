package p005cm.aptoide.p006pt.install;

import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.install.DownloadsNotification */
public interface DownloadsNotification {
    C0120S<String> handleOpenAppView();

    C0120S<Void> handleOpenDownloadManager();

    void openAppView(String str);

    void openDownloadManager();

    void removeNotificationAndStop();

    void setupNotification(String str, String str2, int i, boolean z);
}
