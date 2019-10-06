package p005cm.aptoide.p006pt.downloadmanager;

import p005cm.aptoide.p006pt.database.realm.Download;

/* renamed from: cm.aptoide.pt.downloadmanager.Analytics */
public interface Analytics {
    void onDownloadComplete(Download download);

    void onError(Download download, Throwable th);
}
