package p005cm.aptoide.p006pt.downloadmanager;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import p005cm.aptoide.p006pt.database.realm.Download;
import p005cm.aptoide.p006pt.database.realm.FileToDownload;
import p005cm.aptoide.p006pt.logger.Logger;
import p005cm.aptoide.p006pt.utils.FileUtils;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.C0137ja;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.downloadmanager.AptoideDownloadManager */
public class AptoideDownloadManager implements DownloadManager {
    private static final String TAG = "AptoideDownloadManager";
    private HashMap<String, AppDownloader> appDownloaderMap = new HashMap<>();
    private AppDownloaderProvider appDownloaderProvider;
    private final String cachePath;
    private C0137ja dispatchDownloadsSubscription;
    private DownloadAnalytics downloadAnalytics;
    private final DownloadAppMapper downloadAppMapper;
    private DownloadStatusMapper downloadStatusMapper;
    private DownloadsRepository downloadsRepository;

    public AptoideDownloadManager(DownloadsRepository downloadsRepository2, DownloadStatusMapper downloadStatusMapper2, String cachePath2, DownloadAppMapper downloadAppMapper2, AppDownloaderProvider appDownloaderProvider2, DownloadAnalytics downloadAnalytics2) {
        this.downloadsRepository = downloadsRepository2;
        this.downloadStatusMapper = downloadStatusMapper2;
        this.cachePath = cachePath2;
        this.downloadAppMapper = downloadAppMapper2;
        this.appDownloaderProvider = appDownloaderProvider2;
        this.downloadAnalytics = downloadAnalytics2;
    }

    public synchronized void start() {
        this.dispatchDownloadsSubscription = this.downloadsRepository.getInProgressDownloadsList().mo3621a((C0129b<? super Throwable>) C2939A.f6219a).mo3662g().mo3636b((C0129b<? super T>) C2977S.f6262a).mo3653d((C0132p<? super T, Boolean>) C3008eb.f6295a).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C2989Y<Object,Object>(this)).mo3628b().mo3621a((C0129b<? super Throwable>) C3050z.f6349a).mo3662g().mo3636b((C0129b<? super T>) C2956I.f6239a).mo3653d((C0132p<? super T, Boolean>) C2991Z.f6276a).mo3669j(C2981U.f6266a).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C2962L<Object,Object>(this)).mo3621a((C0129b<? super Throwable>) C3048y.f6346a).mo3662g().mo3626a((C0129b<? super T>) C3036s.f6333a, (C0129b<Throwable>) C3005db.f6291a);
    }

    /* renamed from: g */
    static /* synthetic */ void m281g(List downloads) {
        Logger instance = Logger.getInstance();
        StringBuilder sb = new StringBuilder();
        sb.append("Downloads in Progress ");
        sb.append(downloads.size());
        instance.mo2136d(TAG, sb.toString());
    }

    /* renamed from: h */
    public /* synthetic */ C0120S mo2033h(List __) {
        return this.downloadsRepository.getInQueueDownloads().mo3647d();
    }

    /* renamed from: i */
    static /* synthetic */ void m283i(List downloads) {
        Logger instance = Logger.getInstance();
        StringBuilder sb = new StringBuilder();
        sb.append("Queued downloads ");
        sb.append(downloads.size());
        instance.mo2136d(TAG, sb.toString());
    }

    /* renamed from: k */
    static /* synthetic */ Download m285k(List downloads) {
        return (Download) downloads.get(0);
    }

    /* renamed from: q */
    public /* synthetic */ C0120S mo2045q(Download download) {
        return getAppDownloader(download.getMd5()).mo3636b((C0129b<? super T>) C3011fb.f6301a).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C3042v<Object,Object>(this));
    }

    /* renamed from: r */
    static /* synthetic */ void m286r(Download __) {
    }

    public void stop() {
        if (!this.dispatchDownloadsSubscription.isUnsubscribed()) {
            this.dispatchDownloadsSubscription.unsubscribe();
        }
    }

    public C0117M startDownload(Download download) {
        return C0117M.m597c((C0128a) new C2941B(this, download));
    }

    /* renamed from: s */
    public /* synthetic */ void mo2047s(Download download) {
        download.setOverallDownloadStatus(13);
        download.setTimeStamp(System.currentTimeMillis());
        this.downloadsRepository.save(download);
        this.appDownloaderMap.put(download.getMd5(), createAppDownloadManager(download));
    }

    public C0120S<Download> getDownload(String md5) {
        return this.downloadsRepository.getDownload(md5).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C2954H<Object,Object>(this)).mo3680p(C2943C.f6225a);
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo2023b(Download download) {
        if (download == null || isFileMissingFromCompletedDownload(download)) {
            return C0120S.m631a((Throwable) new DownloadNotFoundException());
        }
        return C0120S.m652c(download);
    }

    /* renamed from: c */
    static /* synthetic */ Boolean m274c(Download storedDownload) {
        boolean z = true;
        if (storedDownload.getOverallDownloadStatus() != 1) {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    public C0120S<Download> getDownloadsByMd5(String md5) {
        return this.downloadsRepository.getDownloadListByMd5(md5).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C2987X<Object,Object>(this)).mo3669j(C2998ba.f6283a).mo3628b().mo3636b((C0129b<? super T>) C3044w.f6342a);
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo2024b(List downloads) {
        return C0120S.m629a((Iterable<? extends T>) downloads).mo3653d((C0132p<? super T, Boolean>) new C3034r<Object,Boolean>(this)).mo3675m();
    }

    /* renamed from: l */
    public /* synthetic */ Boolean mo2038l(Download download) {
        return Boolean.valueOf(download != null && !isFileMissingFromCompletedDownload(download));
    }

    /* renamed from: c */
    static /* synthetic */ Download m273c(List downloads) {
        if (downloads.isEmpty()) {
            return null;
        }
        return (Download) downloads.get(0);
    }

    public C0120S<List<Download>> getDownloadsList() {
        return this.downloadsRepository.getAllDownloads();
    }

    /* renamed from: a */
    static /* synthetic */ Iterable m267a(List downloads) {
        return downloads;
    }

    public C0120S<Download> getCurrentInProgressDownload() {
        return getDownloadsList().mo3666h((C0132p<? super T, ? extends Iterable<? extends R>>) C2983V.f6268a).mo3653d((C0132p<? super T, Boolean>) C2966N.f6249a);
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m266a(Download download) {
        return Boolean.valueOf(download.getOverallDownloadStatus() == 5);
    }

    public C0120S<List<Download>> getCurrentActiveDownloads() {
        return this.downloadsRepository.getCurrentActiveDownloads();
    }

    public C0117M pauseAllDownloads() {
        return this.downloadsRepository.getDownloadsInProgress().mo3653d((C0132p<? super T, Boolean>) C2960K.f6243a).mo3666h((C0132p<? super T, ? extends Iterable<? extends R>>) C3001ca.f6286a).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C2985W<Object,Object>(this)).mo3673l();
    }

    /* renamed from: f */
    static /* synthetic */ Iterable m280f(List downloads) {
        return downloads;
    }

    /* renamed from: m */
    public /* synthetic */ C0120S mo2039m(Download download) {
        return getAppDownloader(download.getMd5()).mo3663g((C0132p<? super T, ? extends C0117M>) C2972Q.f6257a).mo3669j(new C2958J(download));
    }

    /* renamed from: a */
    static /* synthetic */ Download m265a(Download download, AppDownloader appDownloader) {
        return download;
    }

    public C0117M pauseDownload(String md5) {
        return this.downloadsRepository.getDownload(md5).mo3647d().mo3669j(new C2968O(this)).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C3040u<Object,Object>(this)).mo3663g((C0132p<? super T, ? extends C0117M>) C3038t.f6335a).mo3673l();
    }

    /* renamed from: n */
    public /* synthetic */ Download mo2040n(Download download) {
        download.setOverallDownloadStatus(6);
        this.downloadsRepository.save(download);
        return download;
    }

    /* renamed from: o */
    public /* synthetic */ C0120S mo2041o(Download download) {
        return getAppDownloader(download.getMd5());
    }

    public C0120S<Integer> getDownloadStatus(String md5) {
        return getDownload(md5).mo3669j(new C2979T(this));
    }

    /* renamed from: d */
    public /* synthetic */ Integer mo2025d(Download download) {
        if (download == null) {
            return Integer.valueOf(12);
        }
        if (download.getOverallDownloadStatus() == 1) {
            return Integer.valueOf(getStateIfFileExists(download));
        }
        return Integer.valueOf(download.getOverallDownloadStatus());
    }

    public C0117M removeDownload(String md5) {
        return this.downloadsRepository.getDownload(md5).mo3647d().mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C3030p<Object,Object>(this, md5)).mo3636b((C0129b<? super T>) new C2995aa<Object>(this)).mo3673l();
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo2021a(String md5, Download download) {
        return getAppDownloader(download.getMd5()).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C2970P<Object,Object>(this, md5, download));
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo2022a(String md5, Download download, AppDownloader appDownloader) {
        return appDownloader.removeAppDownload().mo3580a(this.downloadsRepository.remove(md5)).mo3586a(C0120S.m652c(download));
    }

    public C0117M invalidateDatabase() {
        return getDownloadsList().mo3647d().mo3666h((C0132p<? super T, ? extends Iterable<? extends R>>) C2948E.f6231a).mo3653d((C0132p<? super T, Boolean>) new C2945D<Object,Boolean>(this)).mo3663g((C0132p<? super T, ? extends C0117M>) new C2964M<Object,Object>(this)).mo3675m().mo3673l();
    }

    /* renamed from: d */
    static /* synthetic */ Iterable m276d(List downloads) {
        return downloads;
    }

    /* renamed from: j */
    public /* synthetic */ Boolean mo2036j(Download download) {
        return Boolean.valueOf(getStateIfFileExists(download) == 10);
    }

    /* renamed from: k */
    public /* synthetic */ C0117M mo2037k(Download download) {
        return this.downloadsRepository.remove(download.getMd5());
    }

    /* access modifiers changed from: private */
    /* renamed from: removeDownloadFiles */
    public void mo2042p(Download download) {
        Iterator it = download.getFilesToDownload().iterator();
        while (it.hasNext()) {
            FileToDownload fileToDownload = (FileToDownload) it.next();
            FileUtils.removeFile(fileToDownload.getFilePath());
            StringBuilder sb = new StringBuilder();
            sb.append(this.cachePath);
            sb.append(fileToDownload.getFileName());
            sb.append(".temp");
            FileUtils.removeFile(sb.toString());
        }
    }

    private AppDownloader createAppDownloadManager(Download download) {
        return this.appDownloaderProvider.getAppDownloader(this.downloadAppMapper.mapDownload(download));
    }

    private boolean isFileMissingFromCompletedDownload(Download download) {
        if (download.getOverallDownloadStatus() == 1 && getStateIfFileExists(download) == 10) {
            return true;
        }
        return false;
    }

    private int getStateIfFileExists(Download download) {
        if (download.getOverallDownloadStatus() == 5) {
            return 5;
        }
        Iterator it = download.getFilesToDownload().iterator();
        while (it.hasNext()) {
            FileToDownload fileToDownload = (FileToDownload) it.next();
            if (!FileUtils.fileExists(fileToDownload.getFilePath())) {
                Logger instance = Logger.getInstance();
                StringBuilder sb = new StringBuilder();
                sb.append("File is missing: ");
                sb.append(fileToDownload.getFileName());
                sb.append(" file path: ");
                sb.append(fileToDownload.getFilePath());
                instance.mo2136d(TAG, sb.toString());
                return 10;
            }
        }
        return 1;
    }

    /* access modifiers changed from: private */
    public C0120S<Download> handleDownloadProgress(AppDownloader appDownloader) {
        return appDownloader.observeDownloadProgress().mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C3032q<Object,Object>(this)).mo3653d((C0132p<? super T, Boolean>) C2952G.f6235a).mo3636b((C0129b<? super T>) new C3007ea<Object>(this)).mo3636b((C0129b<? super T>) new C3046x<Object>(this)).mo3680p(C2950F.f6233a);
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo2019a(AppDownloadStatus appDownloadStatus) {
        return this.downloadsRepository.getDownload(appDownloadStatus.getMd5()).mo3647d().mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C3004da<Object,Object>(this, appDownloadStatus));
    }

    /* renamed from: f */
    static /* synthetic */ Boolean m279f(Download download) {
        boolean z = true;
        if (download.getOverallDownloadStatus() != 1) {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    /* renamed from: g */
    public /* synthetic */ void mo2026g(Download download) {
        removeAppDownloader(download.getMd5());
    }

    /* renamed from: h */
    public /* synthetic */ void mo2034h(Download download) {
        this.downloadAnalytics.onDownloadComplete(download.getMd5(), download.getPackageName(), download.getVersionCode());
    }

    /* renamed from: i */
    static /* synthetic */ Boolean m282i(Download download) {
        boolean z = true;
        if (download.getOverallDownloadStatus() != 1) {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    private void removeAppDownloader(String md5) {
        AppDownloader appDownloader = (AppDownloader) this.appDownloaderMap.get(md5);
        Logger instance = Logger.getInstance();
        String str = TAG;
        instance.mo2136d(str, "removing download manager");
        if (appDownloader != null) {
            appDownloader.stop();
            Logger.getInstance().mo2136d(str, "removed download manager ");
            this.appDownloaderMap.remove(md5);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: updateDownload */
    public C0120S<Download> mo2020a(Download download, AppDownloadStatus appDownloadStatus) {
        download.setOverallProgress(appDownloadStatus.getOverallProgress());
        download.setOverallDownloadStatus(this.downloadStatusMapper.mapAppDownloadStatus(appDownloadStatus.getDownloadStatus()));
        download.setDownloadError(this.downloadStatusMapper.mapDownloadError(appDownloadStatus.getDownloadStatus()));
        Iterator it = download.getFilesToDownload().iterator();
        while (it.hasNext()) {
            FileToDownload fileToDownload = (FileToDownload) it.next();
            fileToDownload.setStatus(this.downloadStatusMapper.mapAppDownloadStatus(appDownloadStatus.getFileDownloadStatus(fileToDownload.getMd5())));
            fileToDownload.setProgress(appDownloadStatus.getFileDownloadProgress(fileToDownload.getMd5()));
        }
        this.downloadsRepository.save(download);
        return C0120S.m652c(download);
    }

    private C0120S<AppDownloader> getAppDownloader(String md5) {
        return C0120S.m652c(this.appDownloaderMap.get(md5));
    }
}
