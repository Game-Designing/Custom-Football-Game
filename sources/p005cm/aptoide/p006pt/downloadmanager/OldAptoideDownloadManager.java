package p005cm.aptoide.p006pt.downloadmanager;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import p005cm.aptoide.p006pt.database.accessors.DownloadAccessor;
import p005cm.aptoide.p006pt.database.realm.Download;
import p005cm.aptoide.p006pt.database.realm.FileToDownload;
import p005cm.aptoide.p006pt.logger.Logger;
import p005cm.aptoide.p006pt.utils.AptoideUtils.StringU;
import p005cm.aptoide.p006pt.utils.FileUtils;
import p019d.p307j.p308a.C13149w;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;
import p026rx.schedulers.Schedulers;

/* renamed from: cm.aptoide.pt.downloadmanager.OldAptoideDownloadManager */
public class OldAptoideDownloadManager {
    public static final String FILE_MD5_EXTRA = "APTOIDE_APPID_EXTRA";
    public static final int PROGRESS_MAX_VALUE = 100;
    private static final String TAG = OldAptoideDownloadManager.class.getSimpleName();
    private Analytics analytics;
    private final String apkPath;
    private CacheManager cacheHelper;
    private DownloadAccessor downloadAccessor;
    private final String downloadsStoragePath;
    private C13149w fileDownloader;
    private FileUtils fileUtils;
    private boolean isDownloading = false;
    private boolean isPausing = false;
    private final String obbPath;

    public OldAptoideDownloadManager(DownloadAccessor downloadAccessor2, CacheManager cacheHelper2, FileUtils fileUtils2, Analytics analytics2, C13149w fileDownloader2, String downloadsStoragePath2, String apkPath2, String obbPath2) {
        this.fileDownloader = fileDownloader2;
        this.analytics = analytics2;
        this.cacheHelper = cacheHelper2;
        this.fileUtils = fileUtils2;
        this.downloadsStoragePath = downloadsStoragePath2;
        this.apkPath = apkPath2;
        this.obbPath = obbPath2;
        this.downloadAccessor = downloadAccessor2;
    }

    public C0120S<Download> startDownload(Download download) throws IllegalArgumentException {
        return getDownloadStatus(download.getMd5()).mo3647d().mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C3049ya<Object,Object>(this, download));
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo13683a(Download download, Integer status) {
        if (status.intValue() == 1) {
            return C0120S.m652c(download);
        }
        C0120S.m633a((Callable<? extends T>) new C2944Ca<Object>(this, download)).mo3634b(Schedulers.computation()).mo3626a((C0129b<? super T>) C2963La.f6246a, (C0129b<Throwable>) C2965Ma.f6248a);
        return getDownload(download.getMd5());
    }

    /* renamed from: h */
    public /* synthetic */ Object mo13700h(Download download) throws Exception {
        startNewDownload(download);
        return null;
    }

    /* renamed from: a */
    static /* synthetic */ void m7638a(Object o) {
    }

    private void startNewDownload(Download download) {
        download.setOverallDownloadStatus(13);
        download.setTimeStamp(System.currentTimeMillis());
        this.downloadAccessor.save(download);
        startNextDownload();
    }

    public C0120S<Download> getDownload(String md5) {
        return this.downloadAccessor.get(md5).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C2988Xa<Object,Object>(this)).mo3680p(C2946Da.f6229a);
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo13686b(Download download) {
        if (download == null || (download.getOverallDownloadStatus() == 1 && getStateIfFileExists(download) == 10)) {
            return C0120S.m631a((Throwable) new DownloadNotFoundException());
        }
        return C0120S.m652c(download);
    }

    /* renamed from: c */
    static /* synthetic */ Boolean m7645c(Download storedDownload) {
        boolean z = true;
        if (storedDownload.getOverallDownloadStatus() != 1) {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    public C0120S<Download> getAsListDownload(String md5) {
        return this.downloadAccessor.getAsList(md5).mo3669j(new C2971Pa(this)).mo3628b();
    }

    /* renamed from: a */
    public /* synthetic */ Download mo13681a(List downloads) {
        int i = 0;
        while (i < downloads.size()) {
            Download download = (Download) downloads.get(i);
            if (download == null || (download.getOverallDownloadStatus() == 1 && getStateIfFileExists(download) == 10)) {
                downloads.remove(i);
                i--;
            }
            i++;
        }
        if (downloads.isEmpty() != 0) {
            return null;
        }
        return (Download) downloads.get(0);
    }

    private int getStateIfFileExists(Download downloadToCheck) {
        if (downloadToCheck.getOverallDownloadStatus() == 5) {
            return 5;
        }
        Iterator it = downloadToCheck.getFilesToDownload().iterator();
        while (it.hasNext()) {
            if (!FileUtils.fileExists(((FileToDownload) it.next()).getFilePath())) {
                return 10;
            }
        }
        return 1;
    }

    /* renamed from: b */
    static /* synthetic */ Iterable m7642b(List downloads) {
        return downloads;
    }

    public C0120S<Download> getCurrentDownload() {
        return getDownloads().mo3666h((C0132p<? super T, ? extends Iterable<? extends R>>) C2967Na.f6250a).mo3653d((C0132p<? super T, Boolean>) C3051za.f6350a);
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m7636a(Download downloads) {
        return Boolean.valueOf(downloads.getOverallDownloadStatus() == 5);
    }

    public C0120S<List<Download>> getDownloads() {
        return this.downloadAccessor.getAll();
    }

    public C0120S<List<Download>> getCurrentDownloads() {
        return this.downloadAccessor.getRunningDownloads();
    }

    public void pauseAllDownloads() {
        this.fileDownloader.mo42167f();
        this.isPausing = true;
        this.downloadAccessor.getRunningDownloads().mo3647d().mo3652d((C0128a) new C2957Ia(this)).mo3626a((C0129b<? super T>) new C3045wa<Object>(this), (C0129b<Throwable>) C2982Ua.f6267a);
    }

    /* renamed from: a */
    public /* synthetic */ void mo13685a() {
        this.isPausing = false;
    }

    /* renamed from: f */
    public /* synthetic */ void mo13692f(List downloads) {
        for (int i = 0; i < downloads.size(); i++) {
            ((Download) downloads.get(i)).setOverallDownloadStatus(6);
        }
        this.downloadAccessor.save(downloads);
        Logger.getInstance().mo2136d(TAG, "Downloads paused");
    }

    private C0120S<Integer> getDownloadStatus(String md5) {
        return getDownload(md5).mo3669j(new C2959Ja(this));
    }

    /* renamed from: d */
    public /* synthetic */ Integer mo13688d(Download download) {
        if (download == null) {
            return Integer.valueOf(12);
        }
        if (download.getOverallDownloadStatus() == 1) {
            return Integer.valueOf(getStateIfFileExists(download));
        }
        return Integer.valueOf(download.getOverallDownloadStatus());
    }

    /* access modifiers changed from: 0000 */
    public void currentDownloadFinished() {
        startNextDownload();
    }

    /* access modifiers changed from: 0000 */
    public synchronized void startNextDownload() {
        if (!this.isDownloading && !this.isPausing) {
            this.isDownloading = true;
            getNextDownload().mo3647d().mo3626a((C0129b<? super T>) new C2986Wa<Object>(this), (C0129b<Throwable>) C2976Ra.f6261a);
        }
    }

    /* renamed from: k */
    public /* synthetic */ void mo13704k(Download download) {
        if (download != null) {
            DownloadTask downloadTask = new DownloadTask(this.downloadAccessor, download, this.fileUtils, this.analytics, this, this.apkPath, this.obbPath, this.downloadsStoragePath, this.fileDownloader);
            downloadTask.startDownload();
            Logger instance = Logger.getInstance();
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("Download with md5 ");
            sb.append(download.getMd5());
            sb.append(" started");
            instance.mo2136d(str, sb.toString());
            return;
        }
        this.isDownloading = false;
        this.cacheHelper.cleanCache().mo3626a((C0129b<? super T>) C2949Ea.f6232a, (C0129b<Throwable>) C3047xa.f6345a);
    }

    /* renamed from: a */
    static /* synthetic */ void m7637a(Long cleanedSize) {
        Logger instance = Logger.getInstance();
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("cleaned size: ");
        sb.append(StringU.formatBytes(cleanedSize.longValue(), false));
        instance.mo2136d(str, sb.toString());
    }

    public C0120S<Download> getNextDownload() {
        return this.downloadAccessor.getInQueueSortedDownloads().mo3669j(C2953Ga.f6236a);
    }

    /* renamed from: c */
    static /* synthetic */ Download m7644c(List downloads) {
        if (downloads == null || downloads.size() <= 0) {
            return null;
        }
        return (Download) downloads.get(0);
    }

    public boolean isDownloading() {
        return this.isDownloading;
    }

    public void setDownloading(boolean downloading) {
        this.isDownloading = downloading;
    }

    public void removeDownload(String md5) {
        C0120S.m633a((Callable<? extends T>) new C2940Aa<Object>(this, md5)).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C2973Qa<Object,Object>(this, md5)).mo3658e((C0132p<? super T, Boolean>) C2990Ya.f6275a).mo3626a((C0129b<? super T>) new C2955Ha<Object>(this), (C0129b<Throwable>) C2980Ta.f6265a);
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo13684a(String md5, Void paused) {
        return this.downloadAccessor.get(md5);
    }

    /* renamed from: i */
    static /* synthetic */ Boolean m7651i(Download download) {
        return Boolean.valueOf(download.getOverallDownloadStatus() == 6);
    }

    /* renamed from: j */
    public /* synthetic */ void mo13703j(Download download) {
        deleteDownloadlFiles(download);
        deleteDownloadFromDb(download.getMd5());
    }

    /* renamed from: d */
    static /* synthetic */ void m7648d(Throwable throwable) {
        if (throwable instanceof NullPointerException) {
            Logger.getInstance().mo2136d(TAG, "Download item was null, are you pressing on remove button too fast?");
        } else {
            throwable.printStackTrace();
        }
    }

    public void deleteDownloadlFiles(Download download) {
        Iterator it = download.getFilesToDownload().iterator();
        while (it.hasNext()) {
            FileToDownload fileToDownload = (FileToDownload) it.next();
            this.fileDownloader.mo42161a(fileToDownload.getDownloadId(), fileToDownload.getFilePath());
            FileUtils.removeFile(fileToDownload.getFilePath());
            StringBuilder sb = new StringBuilder();
            sb.append(this.downloadsStoragePath);
            sb.append(fileToDownload.getFileName());
            sb.append(".temp");
            FileUtils.removeFile(sb.toString());
        }
    }

    public C0117M pauseDownloadSync(String md5) {
        return internalPause(md5).mo3673l();
    }

    private C0120S<Download> internalPause(String md5) {
        return this.downloadAccessor.get(md5).mo3647d().mo3669j(new C2992Za(this));
    }

    /* renamed from: e */
    public /* synthetic */ Download mo13690e(Download download) {
        download.setOverallDownloadStatus(6);
        this.downloadAccessor.save(download);
        for (int i = download.getFilesToDownload().size() - 1; i >= 0; i--) {
            this.fileDownloader.mo42155a(((FileToDownload) download.getFilesToDownload().get(i)).getDownloadId());
        }
        return download;
    }

    /* renamed from: pauseDownload */
    public Void mo13682a(String md5) {
        internalPause(md5).mo3626a((C0129b<? super T>) new C2978Sa<Object>(md5), (C0129b<Throwable>) new C2984Va<Throwable>(md5));
        return null;
    }

    /* renamed from: a */
    static /* synthetic */ void m7639a(String md5, Download download) {
        Logger instance = Logger.getInstance();
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("Download with ");
        sb.append(md5);
        sb.append(" paused");
        instance.mo2136d(str, sb.toString());
    }

    /* renamed from: a */
    static /* synthetic */ void m7640a(String md5, Throwable throwable) {
        if (throwable instanceof DownloadNotFoundException) {
            Logger instance = Logger.getInstance();
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("there are no download to pause with the md5: ");
            sb.append(md5);
            instance.mo2136d(str, sb.toString());
            return;
        }
        throwable.printStackTrace();
    }

    private void deleteDownloadFromDb(String md5) {
        this.downloadAccessor.delete(md5);
    }

    public C0120S<Void> invalidateDatabase() {
        return getDownloads().mo3647d().mo3666h((C0132p<? super T, ? extends Iterable<? extends R>>) C2961Ka.f6244a).mo3653d((C0132p<? super T, Boolean>) new C2969Oa<Object,Boolean>(this)).mo3669j(new C2942Ba(this)).mo3675m().mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) C2951Fa.f6234a);
    }

    /* renamed from: d */
    static /* synthetic */ Iterable m7647d(List downloads) {
        return downloads;
    }

    /* renamed from: f */
    public /* synthetic */ Boolean mo13691f(Download download) {
        return Boolean.valueOf(getStateIfFileExists(download) == 10);
    }

    /* renamed from: g */
    public /* synthetic */ Object mo13693g(Download download) {
        this.downloadAccessor.delete(download.getMd5());
        return null;
    }
}
