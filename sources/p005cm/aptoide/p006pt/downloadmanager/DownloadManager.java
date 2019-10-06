package p005cm.aptoide.p006pt.downloadmanager;

import java.util.List;
import p005cm.aptoide.p006pt.database.realm.Download;
import p026rx.C0117M;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.downloadmanager.DownloadManager */
public interface DownloadManager {
    C0120S<List<Download>> getCurrentActiveDownloads();

    C0120S<Download> getCurrentInProgressDownload();

    C0120S<Download> getDownload(String str);

    C0120S<Integer> getDownloadStatus(String str);

    C0120S<Download> getDownloadsByMd5(String str);

    C0120S<List<Download>> getDownloadsList();

    C0117M invalidateDatabase();

    C0117M pauseAllDownloads();

    C0117M pauseDownload(String str);

    C0117M removeDownload(String str);

    void start();

    C0117M startDownload(Download download);

    void stop();
}
