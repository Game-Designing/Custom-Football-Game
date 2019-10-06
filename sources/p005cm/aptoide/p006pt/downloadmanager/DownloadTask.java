package p005cm.aptoide.p006pt.downloadmanager;

import android.text.TextUtils;
import com.liulishuo.filedownloader.exception.FileDownloadHttpException;
import com.liulishuo.filedownloader.exception.FileDownloadOutOfSpaceException;
import io.realm.RealmList;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p005cm.aptoide.p006pt.database.accessors.DownloadAccessor;
import p005cm.aptoide.p006pt.database.realm.Download;
import p005cm.aptoide.p006pt.database.realm.FileToDownload;
import p005cm.aptoide.p006pt.logger.Logger;
import p005cm.aptoide.p006pt.utils.AptoideUtils.AlgorithmU;
import p005cm.aptoide.p006pt.utils.FileUtils;
import p019d.p307j.p308a.C13079a;
import p019d.p307j.p308a.C13126i;
import p019d.p307j.p308a.C13130l;
import p019d.p307j.p308a.C13149w;
import p026rx.C0120S;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;
import p026rx.p398d.C14908d;
import p026rx.schedulers.Schedulers;

/* renamed from: cm.aptoide.pt.downloadmanager.DownloadTask */
class DownloadTask extends C13126i {
    private static final int APTOIDE_DOWNLOAD_TASK_TAG_KEY = 888;
    private static final int FILE_NOTFOUND_HTTP_ERROR = 404;
    private static final int INTERVAL = 1000;
    public static final int RETRY_TIMES = 3;
    private static final String TAG = DownloadTask.class.getSimpleName();
    private Analytics analytics;
    private String apkPath;
    private final Download download;
    private final DownloadAccessor downloadAccessor;
    private final OldAptoideDownloadManager downloadManager;
    private C13149w fileDownloader;
    private final FileUtils fileUtils;
    private String genericPath;
    boolean isSerial = true;
    private final String md5;
    private String obbPath;
    private C14908d<Download> observable;

    DownloadTask(DownloadAccessor downloadAccessor2, Download download2, FileUtils fileUtils2, Analytics analytics2, OldAptoideDownloadManager downloadManager2, String apkPath2, String obbPath2, String genericPath2, C13149w fileDownloader2) {
        this.analytics = analytics2;
        this.download = download2;
        this.md5 = download2.getMd5();
        this.downloadAccessor = downloadAccessor2;
        this.fileUtils = fileUtils2;
        this.downloadManager = downloadManager2;
        this.apkPath = apkPath2;
        this.obbPath = obbPath2;
        this.genericPath = genericPath2;
        this.fileDownloader = fileDownloader2;
        this.observable = C0120S.m627a(250, 1000, TimeUnit.MILLISECONDS).mo3634b(Schedulers.m776io()).mo3680p(new C3033qa(download2)).mo3653d((C0132p<? super T, Boolean>) new C3029oa<Object,Boolean>(download2)).mo3669j(new C3017ia(this)).mo3653d((C0132p<? super T, Boolean>) new C3010fa<Object,Boolean>(this, download2, analytics2, downloadManager2)).mo3661f();
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m7619a(Download download2, Long integer1) {
        return Boolean.valueOf((download2.getOverallDownloadStatus() == 5 || download2.getOverallDownloadStatus() == 13 || download2.getOverallDownloadStatus() == 4) ? false : true);
    }

    /* renamed from: b */
    static /* synthetic */ Boolean m7622b(Download download2, Long aLong1) {
        boolean z = true;
        if (!(download2.getOverallDownloadStatus() == 5 || download2.getOverallDownloadStatus() == 1)) {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    /* renamed from: a */
    public /* synthetic */ Download mo13654a(Long aLong) {
        return updateProgress();
    }

    /* renamed from: a */
    public /* synthetic */ Boolean mo13656a(Download download2, Analytics analytics2, OldAptoideDownloadManager downloadManager2, Download updatedDownload) {
        if (updatedDownload.getOverallProgress() > 100 || download2.getOverallDownloadStatus() != 5) {
            return Boolean.valueOf(false);
        }
        if (updatedDownload.getOverallProgress() == 100 && download2.getOverallDownloadStatus() != 1) {
            setDownloadStatus(1, download2);
            analytics2.onDownloadComplete(download2);
            downloadManager2.currentDownloadFinished();
        }
        return Boolean.valueOf(true);
    }

    private Download updateProgress() {
        if (this.download.getOverallProgress() >= 100 || this.download.getOverallDownloadStatus() != 5) {
            return this.download;
        }
        int progress = 0;
        Iterator it = this.download.getFilesToDownload().iterator();
        while (it.hasNext()) {
            progress += ((FileToDownload) it.next()).getProgress();
        }
        Download download2 = this.download;
        download2.setOverallProgress((int) Math.floor((double) (((float) progress) / ((float) download2.getFilesToDownload().size()))));
        saveDownloadInDb(this.download);
        Logger instance = Logger.getInstance();
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("Download: ");
        sb.append(this.download.getMd5());
        sb.append(" Progress: ");
        sb.append(this.download.getOverallProgress());
        instance.mo2136d(str, sb.toString());
        return this.download;
    }

    private void setDownloadStatus(int status, Download download2) {
        setDownloadStatus(status, download2, null);
    }

    private synchronized void saveDownloadInDb(Download download2) {
        C0120S.m633a((Callable<? extends T>) new C3021ka<Object>(this, download2)).mo3634b(Schedulers.m776io()).mo3626a((C0129b<? super T>) C3027na.f6322a, (C0129b<Throwable>) C3031pa.f6328a);
    }

    /* renamed from: b */
    public /* synthetic */ Object mo13661b(Download download2) throws Exception {
        this.downloadAccessor.save(download2);
        return null;
    }

    /* renamed from: a */
    static /* synthetic */ void m7621a(Object __) {
    }

    private void setDownloadStatus(int status, Download download2, C13079a task) {
        if (task != null) {
            Iterator it = download2.getFilesToDownload().iterator();
            while (it.hasNext()) {
                FileToDownload fileToDownload = (FileToDownload) it.next();
                if (fileToDownload.getDownloadId() == task.getId()) {
                    fileToDownload.setStatus(status);
                }
            }
        }
        this.download.setOverallDownloadStatus(status);
        saveDownloadInDb(download2);
        if (status == 5 || status == 4) {
            this.downloadManager.setDownloading(true);
        } else {
            this.downloadManager.setDownloading(false);
        }
    }

    /* access modifiers changed from: protected */
    public void pending(C13079a task, long soFarBytes, long totalBytes) {
        setDownloadStatus(4, this.download, task);
    }

    /* access modifiers changed from: protected */
    public void pending(C13079a task, int soFarBytes, int totalBytes) {
        pending(task, (long) soFarBytes, (long) totalBytes);
        setDownloadStatus(4, this.download, task);
    }

    /* access modifiers changed from: protected */
    public void progress(C13079a task, long soFarBytes, long totalBytes) {
        Iterator it = this.download.getFilesToDownload().iterator();
        while (it.hasNext()) {
            FileToDownload fileToDownload = (FileToDownload) it.next();
            if (fileToDownload.getDownloadId() == task.getId()) {
                if (totalBytes > 0) {
                    fileToDownload.setProgress((int) Math.floor((double) ((((float) soFarBytes) / ((float) totalBytes)) * 100.0f)));
                } else {
                    fileToDownload.setProgress(0);
                }
            }
        }
        this.download.setDownloadSpeed(task.mo42025h() * Opcodes.ACC_ABSTRACT);
        if (this.download.getOverallDownloadStatus() != 5) {
            setDownloadStatus(5, this.download, task);
        }
    }

    /* access modifiers changed from: protected */
    public void progress(C13079a task, int soFarBytes, int totalBytes) {
        progress(task, (long) soFarBytes, (long) totalBytes);
    }

    /* access modifiers changed from: protected */
    public void paused(C13079a task, long soFarBytes, long totalBytes) {
        setDownloadStatus(6, this.download, task);
        this.downloadManager.currentDownloadFinished();
    }

    /* access modifiers changed from: protected */
    public void paused(C13079a task, int soFarBytes, int totalBytes) {
        paused(task, (long) soFarBytes, (long) totalBytes);
    }

    /* access modifiers changed from: protected */
    public void blockComplete(C13079a task) {
    }

    /* access modifiers changed from: protected */
    public void completed(C13079a task) {
        C0120S.m629a((Iterable<? extends T>) this.download.getFilesToDownload()).mo3653d((C0132p<? super T, Boolean>) new C3025ma<Object,Boolean>(task)).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C3013ga<Object,Object>(this, task)).mo3652d((C0128a) new C3037sa(this)).mo3634b(Schedulers.m776io()).mo3626a((C0129b<? super T>) new C3035ra<Object>(this), (C0129b<Throwable>) new C3015ha<Throwable>(this));
        this.download.setDownloadSpeed(task.mo42025h() * Opcodes.ACC_ABSTRACT);
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m7620a(C13079a task, FileToDownload file) {
        return Boolean.valueOf(file.getDownloadId() == task.getId());
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo13662b(C13079a task, FileToDownload file) {
        file.setStatus(1);
        Iterator it = this.download.getFilesToDownload().iterator();
        while (it.hasNext()) {
            if (((FileToDownload) it.next()).getStatus() != 1) {
                file.setProgress(100);
                return C0120S.m652c(null);
            }
        }
        return checkMd5AndMoveFileToRightPlace(this.download).mo3636b((C0129b<? super T>) new C3019ja<Object>(this, file, task));
    }

    /* renamed from: a */
    public /* synthetic */ void mo13658a(FileToDownload file, C13079a task, Boolean fileMoved) {
        if (fileMoved.booleanValue()) {
            Logger.getInstance().mo2136d(TAG, "Download md5 match");
            file.setProgress(100);
            return;
        }
        Logger.getInstance().mo2140e(TAG, "Download md5 is not correct");
        this.downloadManager.deleteDownloadlFiles(this.download);
        this.download.setDownloadError(1);
        setDownloadStatus(9, this.download, task);
    }

    /* renamed from: a */
    public /* synthetic */ void mo13657a() {
        this.downloadManager.setDownloading(false);
    }

    /* renamed from: a */
    public /* synthetic */ void mo13659a(Boolean success) {
        saveDownloadInDb(this.download);
    }

    /* renamed from: a */
    public /* synthetic */ void mo13660a(Throwable throwable) {
        setDownloadStatus(9, this.download);
    }

    /* access modifiers changed from: protected */
    public void error(C13079a task, Throwable e) {
        stopDownloadQueue(this.download);
        if (!(e instanceof FileDownloadHttpException) || ((FileDownloadHttpException) e).mo35685a() != FILE_NOTFOUND_HTTP_ERROR) {
            Logger instance = Logger.getInstance();
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("Error on download: ");
            sb.append(this.download.getMd5());
            instance.mo2136d(str, sb.toString());
            if (e != null) {
                e.printStackTrace();
            }
            Analytics analytics2 = this.analytics;
            if (analytics2 != null) {
                analytics2.onError(this.download, e);
            }
        } else {
            Logger instance2 = Logger.getInstance();
            String str2 = TAG;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("File not found on link: ");
            sb2.append(task.getUrl());
            instance2.mo2136d(str2, sb2.toString());
            Iterator it = this.download.getFilesToDownload().iterator();
            while (it.hasNext()) {
                FileToDownload fileToDownload = (FileToDownload) it.next();
                if (TextUtils.equals(fileToDownload.getLink(), task.getUrl()) && !TextUtils.isEmpty(fileToDownload.getAltLink())) {
                    fileToDownload.setLink(fileToDownload.getAltLink());
                    fileToDownload.setAltLink(null);
                    this.downloadAccessor.save(this.download);
                    startDownload();
                    return;
                }
            }
        }
        if (e instanceof FileDownloadOutOfSpaceException) {
            this.download.setDownloadError(2);
        } else {
            this.download.setDownloadError(1);
        }
        setDownloadStatus(9, this.download, task);
        this.downloadManager.currentDownloadFinished();
    }

    /* access modifiers changed from: protected */
    public void warn(C13079a task) {
        setDownloadStatus(7, this.download, task);
    }

    private void stopDownloadQueue(Download download2) {
        try {
            for (int i = download2.getFilesToDownload().size() - 1; i >= 0; i--) {
                FileToDownload fileToDownload = (FileToDownload) download2.getFilesToDownload().get(i);
                this.fileDownloader.mo42163b(fileToDownload.getDownloadId(), fileToDownload.getPath());
                int taskId = this.fileDownloader.mo42156a(fileToDownload.getDownloadId(), (C13130l) null);
                if (taskId != 0) {
                    this.fileDownloader.mo42155a(taskId);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startDownload() throws IllegalArgumentException {
        this.observable.mo46116p();
        if (this.download.getFilesToDownload() != null) {
            RealmList<FileToDownload> filesToDownload = this.download.getFilesToDownload();
            int i = 0;
            while (i < filesToDownload.size()) {
                FileToDownload fileToDownload = (FileToDownload) filesToDownload.get(i);
                if (!TextUtils.isEmpty(fileToDownload.getLink())) {
                    C13079a baseDownloadTask = this.fileDownloader.mo42157a(fileToDownload.getLink()).mo42015c(3);
                    baseDownloadTask.addHeader(Constants.VERSION_CODE, String.valueOf(this.download.getVersionCode()));
                    baseDownloadTask.addHeader(Constants.PACKAGE, this.download.getPackageName());
                    baseDownloadTask.addHeader(Constants.FILE_TYPE, String.valueOf(i));
                    baseDownloadTask.mo42010a(APTOIDE_DOWNLOAD_TASK_TAG_KEY, this);
                    String str = ".temp";
                    if (fileToDownload.getFileName().endsWith(str)) {
                        fileToDownload.setFileName(fileToDownload.getFileName().replace(str, ""));
                    }
                    baseDownloadTask.mo42011a((C13130l) this);
                    baseDownloadTask.mo42016d(100);
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.genericPath);
                    sb.append(fileToDownload.getFileName());
                    baseDownloadTask.setPath(sb.toString());
                    fileToDownload.setDownloadId(baseDownloadTask.mo42027j().mo42054a());
                    fileToDownload.setPath(this.genericPath);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(fileToDownload.getFileName());
                    sb2.append(str);
                    fileToDownload.setFileName(sb2.toString());
                    i++;
                } else {
                    throw new IllegalArgumentException("A link to download must be provided");
                }
            }
            if (this.isSerial != 0) {
                this.fileDownloader.mo42162a((C13130l) this, true);
            } else {
                this.fileDownloader.mo42162a((C13130l) this, false);
            }
        }
        saveDownloadInDb(this.download);
    }

    private C0120S<Boolean> checkMd5AndMoveFileToRightPlace(Download download2) {
        return C0120S.m633a((Callable<? extends T>) new C3023la<Object>(this, download2));
    }

    /* renamed from: a */
    public /* synthetic */ Boolean mo13655a(Download download2) throws Exception {
        Iterator it = download2.getFilesToDownload().iterator();
        while (it.hasNext()) {
            FileToDownload fileToDownload = (FileToDownload) it.next();
            fileToDownload.setFileName(fileToDownload.getFileName().replace(".temp", ""));
            if (!TextUtils.isEmpty(fileToDownload.getMd5())) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.genericPath);
                sb.append(fileToDownload.getFileName());
                if (!TextUtils.equals(AlgorithmU.computeMd5(new File(sb.toString())), fileToDownload.getMd5())) {
                    return Boolean.valueOf(false);
                }
            }
            String newFilePath = getFilePathFromFileType(fileToDownload);
            this.fileUtils.copyFile(this.genericPath, newFilePath, fileToDownload.getFileName());
            fileToDownload.setPath(newFilePath);
        }
        return Boolean.valueOf(true);
    }

    private String getFilePathFromFileType(FileToDownload fileToDownload) {
        int fileType = fileToDownload.getFileType();
        if (fileType == 0) {
            return this.apkPath;
        }
        if (fileType != 1) {
            return this.genericPath;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.obbPath);
        sb.append(fileToDownload.getPackageName());
        sb.append("/");
        return sb.toString();
    }

    public void setSerial(boolean isSerial2) {
        this.isSerial = isSerial2;
    }
}
