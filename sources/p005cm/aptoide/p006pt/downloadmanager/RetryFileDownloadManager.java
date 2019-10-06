package p005cm.aptoide.p006pt.downloadmanager;

import p005cm.aptoide.p006pt.downloadmanager.AppDownloadStatus.AppDownloadState;
import p005cm.aptoide.p006pt.logger.Logger;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.C0137ja;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;
import p026rx.p028h.C14963c;

/* renamed from: cm.aptoide.pt.downloadmanager.RetryFileDownloadManager */
public class RetryFileDownloadManager implements RetryFileDownloader {
    private static final String TAG = "RetryFileDownloadManage";
    private String alternativeDownloadPath;
    private FileDownloader fileDownloader;
    private FileDownloaderProvider fileDownloaderProvider;
    private final String fileName;
    private final int fileType;
    private final String mainDownloadPath;
    private String md5;
    private final String packageName;
    private C14963c<FileDownloadCallback> retryFileDownloadSubject = C14963c.m46753p();
    private C0137ja startDownloadSubscription;
    private final int versionCode;

    public RetryFileDownloadManager(String mainDownloadPath2, int fileType2, String packageName2, int versionCode2, String fileName2, String md52, FileDownloaderProvider fileDownloaderProvider2, String alternativeDownloadPath2) {
        this.mainDownloadPath = mainDownloadPath2;
        this.fileType = fileType2;
        this.packageName = packageName2;
        this.versionCode = versionCode2;
        this.fileName = fileName2;
        this.md5 = md52;
        this.fileDownloaderProvider = fileDownloaderProvider2;
        this.alternativeDownloadPath = alternativeDownloadPath2;
    }

    public void startFileDownload() {
        this.startDownloadSubscription = C0120S.m652c(setupFileDownloader()).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C2993_a<Object,Object>(this)).mo3670j();
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo13712a(FileDownloader fileDownloader2) {
        return fileDownloader2.startFileDownload().mo3586a(handleFileDownloadProgress(fileDownloader2));
    }

    public C0117M pauseDownload() {
        return this.fileDownloader.pauseDownload();
    }

    public C0117M removeDownloadFile() {
        return this.fileDownloader.removeDownloadFile();
    }

    public C0120S<FileDownloadCallback> observeFileDownloadProgress() {
        return this.retryFileDownloadSubject;
    }

    public void stop() {
        C0137ja jaVar = this.startDownloadSubscription;
        if (jaVar != null && !jaVar.isUnsubscribed()) {
            this.startDownloadSubscription.unsubscribe();
        }
    }

    public void stopFailedDownload() {
        this.fileDownloader.stopFailedDownload();
    }

    private C0120S<FileDownloadCallback> handleFileDownloadProgress(FileDownloader fileDownloader2) {
        return fileDownloader2.observeFileDownloadProgress().mo3680p(C2999bb.f6284a).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C2996ab<Object,Object>(this)).mo3636b((C0129b<? super T>) new C3002cb<Object>(this));
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m7666a(FileDownloadCallback fileDownloadCallback) {
        return Boolean.valueOf(fileDownloadCallback.getDownloadState() == AppDownloadState.ERROR_FILE_NOT_FOUND);
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo13713b(FileDownloadCallback fileDownloadCallback) {
        if (fileDownloadCallback.getDownloadState() != AppDownloadState.ERROR_FILE_NOT_FOUND) {
            return C0120S.m652c(fileDownloadCallback);
        }
        Logger.getInstance().mo2136d(TAG, "File not found error, restarting the download with the alternative link");
        FileDownloader retryFileDownloader = this.fileDownloaderProvider.createFileDownloader(this.md5, this.alternativeDownloadPath, this.fileType, this.packageName, this.versionCode, this.fileName, C14963c.m46753p());
        this.fileDownloader = retryFileDownloader;
        return retryFileDownloader.startFileDownload().mo3586a(handleFileDownloadProgress(retryFileDownloader));
    }

    /* renamed from: c */
    public /* synthetic */ void mo13714c(FileDownloadCallback fileDownloadCallback) {
        this.retryFileDownloadSubject.onNext(fileDownloadCallback);
    }

    private FileDownloader setupFileDownloader() {
        this.fileDownloader = this.fileDownloaderProvider.createFileDownloader(this.md5, this.mainDownloadPath, this.fileType, this.packageName, this.versionCode, this.fileName, C14963c.m46753p());
        return this.fileDownloader;
    }
}
