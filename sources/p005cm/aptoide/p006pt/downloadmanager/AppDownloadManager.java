package p005cm.aptoide.p006pt.downloadmanager;

import java.util.ArrayList;
import java.util.HashMap;
import p005cm.aptoide.p006pt.downloadmanager.AppDownloadStatus.AppDownloadState;
import p005cm.aptoide.p006pt.logger.Logger;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.C0137ja;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;
import p026rx.p028h.C14963c;

/* renamed from: cm.aptoide.pt.downloadmanager.AppDownloadManager */
public class AppDownloadManager implements AppDownloader {
    private static final String TAG = "AppDownloadManager";
    private final DownloadApp app;
    private AppDownloadStatus appDownloadStatus;
    private DownloadAnalytics downloadAnalytics;
    private C14963c<FileDownloadCallback> fileDownloadSubject = C14963c.m46753p();
    private HashMap<String, RetryFileDownloader> fileDownloaderPersistence;
    private RetryFileDownloaderProvider fileDownloaderProvider;
    private C0137ja subscribe;

    public AppDownloadManager(RetryFileDownloaderProvider fileDownloaderProvider2, DownloadApp app2, HashMap<String, RetryFileDownloader> fileDownloaderPersistence2, DownloadAnalytics downloadAnalytics2) {
        this.fileDownloaderProvider = fileDownloaderProvider2;
        this.app = app2;
        this.fileDownloaderPersistence = fileDownloaderPersistence2;
        this.downloadAnalytics = downloadAnalytics2;
        AppDownloadStatus appDownloadStatus2 = new AppDownloadStatus(app2.getMd5(), new ArrayList(), AppDownloadState.PENDING, app2.getSize());
        this.appDownloadStatus = appDownloadStatus2;
    }

    public void startAppDownload() {
        this.subscribe = C0120S.m629a((Iterable<? extends T>) this.app.getDownloadFiles()).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C3018j<Object,Object>(this)).mo3626a((C0129b<? super T>) C3020k.f6313a, (C0129b<Throwable>) C3005db.f6291a);
    }

    /* renamed from: c */
    static /* synthetic */ void m7608c(FileDownloadCallback __) {
    }

    public C0117M pauseAppDownload() {
        return C0120S.m629a((Iterable<? extends T>) this.app.getDownloadFiles()).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C3009f<Object,Object>(this)).mo3663g((C0132p<? super T, ? extends C0117M>) C3003d.f6288a).mo3673l();
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo13614a(DownloadAppFile downloadAppFile) {
        return getFileDownloader(downloadAppFile.getMainDownloadPath());
    }

    public C0117M removeAppDownload() {
        return C0120S.m629a((Iterable<? extends T>) this.app.getDownloadFiles()).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C2997b<Object,Object>(this)).mo3663g((C0132p<? super T, ? extends C0117M>) C2994a.f6279a).mo3673l();
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo13617b(DownloadAppFile downloadAppFile) {
        return getFileDownloader(downloadAppFile.getMainDownloadPath());
    }

    public C0120S<AppDownloadStatus> observeDownloadProgress() {
        return observeFileDownload().mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C3022l<Object,Object>(this)).mo3621a((C0129b<? super Throwable>) C3016i.f6307a).mo3669j(new C3026n(this));
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo13618b(FileDownloadCallback fileDownloadCallback) {
        setAppDownloadStatus(fileDownloadCallback);
        return C0120S.m652c(this.appDownloadStatus);
    }

    /* renamed from: a */
    public /* synthetic */ AppDownloadStatus mo13613a(AppDownloadStatus __) {
        return this.appDownloadStatus;
    }

    public void stop() {
        C0137ja jaVar = this.subscribe;
        if (jaVar != null && !jaVar.isUnsubscribed()) {
            this.subscribe.unsubscribe();
            this.fileDownloadSubject = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: startFileDownload */
    public C0120S<FileDownloadCallback> mo13620c(DownloadAppFile downloadAppFile) {
        return C0120S.m652c(this.fileDownloaderProvider.createRetryFileDownloader(downloadAppFile.getDownloadMd5(), downloadAppFile.getMainDownloadPath(), downloadAppFile.getFileType(), downloadAppFile.getPackageName(), downloadAppFile.getVersionCode(), downloadAppFile.getFileName(), C14963c.m46753p(), downloadAppFile.getAlternativeDownloadPath())).mo3636b((C0129b<? super T>) new C3028o<Object>(this, downloadAppFile)).mo3636b((C0129b<? super T>) new C3000c<Object>(downloadAppFile)).mo3636b((C0129b<? super T>) C3024m.f6319a).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C3012g<Object,Object>(this)).mo3621a((C0129b<? super Throwable>) C3005db.f6291a);
    }

    /* renamed from: b */
    public /* synthetic */ void mo13619b(DownloadAppFile downloadAppFile, RetryFileDownloader fileDownloader) {
        RetryFileDownloader retryFileDownloader = (RetryFileDownloader) this.fileDownloaderPersistence.put(downloadAppFile.getMainDownloadPath(), fileDownloader);
    }

    /* renamed from: a */
    static /* synthetic */ void m7605a(DownloadAppFile downloadAppFile, RetryFileDownloader __) {
        Logger instance = Logger.getInstance();
        StringBuilder sb = new StringBuilder();
        sb.append("Starting app file download ");
        sb.append(downloadAppFile.getFileName());
        instance.mo2136d(TAG, sb.toString());
    }

    private C0120S<FileDownloadCallback> observeFileDownload() {
        return this.fileDownloadSubject;
    }

    private void setAppDownloadStatus(FileDownloadCallback fileDownloadCallback) {
        this.appDownloadStatus.setFileDownloadCallback(fileDownloadCallback);
    }

    /* access modifiers changed from: private */
    /* renamed from: handleFileDownloadProgress */
    public C0120S<FileDownloadCallback> mo13621d(RetryFileDownloader fileDownloader) {
        return fileDownloader.observeFileDownloadProgress().mo3636b((C0129b<? super T>) new C3014h<Object>(this)).mo3636b((C0129b<? super T>) new C3006e<Object>(this, fileDownloader));
    }

    /* renamed from: a */
    public /* synthetic */ void mo13615a(FileDownloadCallback fileDownloadCallback) {
        this.fileDownloadSubject.onNext(fileDownloadCallback);
    }

    /* renamed from: a */
    public /* synthetic */ void mo13616a(RetryFileDownloader fileDownloader, FileDownloadCallback fileDownloadCallback) {
        if (fileDownloadCallback.getDownloadState() == AppDownloadState.COMPLETED) {
            handleCompletedFileDownload(fileDownloader);
        } else if (fileDownloadCallback.getDownloadState() == AppDownloadState.ERROR_FILE_NOT_FOUND || fileDownloadCallback.getDownloadState() == AppDownloadState.ERROR || fileDownloadCallback.getDownloadState() == AppDownloadState.ERROR_NOT_ENOUGH_SPACE) {
            handleErrorFileDownload();
            if (fileDownloadCallback.hasError()) {
                this.downloadAnalytics.onError(this.app.getPackageName(), this.app.getVersionCode(), fileDownloadCallback.getError());
            }
        }
    }

    private void handleErrorFileDownload() {
        for (RetryFileDownloader retryFileDownloader : this.fileDownloaderPersistence.values()) {
            retryFileDownloader.stopFailedDownload();
        }
    }

    private void handleCompletedFileDownload(RetryFileDownloader fileDownloader) {
        fileDownloader.stop();
    }

    public C0120S<RetryFileDownloader> getFileDownloader(String mainDownloadPath) {
        return C0120S.m652c(this.fileDownloaderPersistence.get(mainDownloadPath));
    }
}
