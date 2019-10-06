package p005cm.aptoide.p006pt.downloadmanager;

import java.util.List;
import p005cm.aptoide.p006pt.database.accessors.DownloadAccessor;
import p005cm.aptoide.p006pt.database.realm.Download;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.downloadmanager.DownloadsRepository */
public class DownloadsRepository {
    private DownloadAccessor downloadAccessor;

    public DownloadsRepository(DownloadAccessor downloadAccessor2) {
        this.downloadAccessor = downloadAccessor2;
    }

    public void save(Download download) {
        this.downloadAccessor.save(download);
    }

    public C0120S<Download> getDownload(String md5) {
        return this.downloadAccessor.get(md5);
    }

    public C0120S<List<Download>> getDownloadsInProgress() {
        return this.downloadAccessor.getRunningDownloads();
    }

    public C0120S<List<Download>> getInQueueDownloads() {
        return this.downloadAccessor.getInQueueSortedDownloads();
    }

    public C0120S<List<Download>> getAllDownloads() {
        return this.downloadAccessor.getAll();
    }

    /* renamed from: a */
    public /* synthetic */ void mo13669a(String md5) {
        this.downloadAccessor.delete(md5);
    }

    public C0117M remove(String md5) {
        return C0117M.m597c((C0128a) new C3041ua(this, md5));
    }

    public C0120S<List<Download>> getDownloadListByMd5(String md5) {
        return this.downloadAccessor.getAsList(md5);
    }

    public C0120S<List<Download>> getCurrentActiveDownloads() {
        return this.downloadAccessor.getRunningDownloads();
    }

    public C0120S<List<Download>> getInProgressDownloadsList() {
        return this.downloadAccessor.getRunningDownloads().mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) C3043va.f6341a);
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m7633a(Download download) {
        return Boolean.valueOf(download.getOverallDownloadStatus() == 5 || download.getOverallDownloadStatus() == 4);
    }
}
