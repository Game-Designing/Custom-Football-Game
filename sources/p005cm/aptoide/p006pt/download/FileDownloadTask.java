package p005cm.aptoide.p006pt.download;

import com.liulishuo.filedownloader.exception.FileDownloadHttpException;
import com.liulishuo.filedownloader.exception.FileDownloadOutOfSpaceException;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.downloadmanager.AppDownloadStatus.AppDownloadState;
import p005cm.aptoide.p006pt.downloadmanager.FileDownloadCallback;
import p005cm.aptoide.p006pt.downloadmanager.FileDownloadProgressResult;
import p005cm.aptoide.p006pt.logger.Logger;
import p019d.p307j.p308a.C13079a;
import p019d.p307j.p308a.C13126i;
import p026rx.C0120S;
import p026rx.p028h.C14963c;

/* renamed from: cm.aptoide.pt.download.FileDownloadTask */
public class FileDownloadTask extends C13126i {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final int FILE_NOT_FOUND_HTTP_ERROR = 404;
    private final String TAG = "FileDownloader";
    private C14963c<FileDownloadCallback> downloadStatus;
    private String fileName;
    private final String md5;
    private Md5Comparator md5Comparator;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7706316508132034521L, "cm/aptoide/pt/download/FileDownloadTask", 34);
        $jacocoData = probes;
        return probes;
    }

    public FileDownloadTask(C14963c<FileDownloadCallback> downloadStatus2, String md52, Md5Comparator md5Comparator2, String fileName2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.downloadStatus = downloadStatus2;
        this.md5 = md52;
        this.md5Comparator = md5Comparator2;
        this.fileName = fileName2;
        $jacocoInit[0] = true;
    }

    /* access modifiers changed from: protected */
    public void pending(C13079a baseDownloadTask, long soFarBytes, long totalBytes) {
        boolean[] $jacocoInit = $jacocoInit();
        this.downloadStatus.onNext(new FileDownloadTaskStatus(AppDownloadState.PENDING, new FileDownloadProgressResult(soFarBytes, totalBytes), this.md5));
        $jacocoInit[1] = true;
    }

    /* access modifiers changed from: protected */
    public void progress(C13079a baseDownloadTask, long soFarBytes, long totalBytes) {
        boolean[] $jacocoInit = $jacocoInit();
        this.downloadStatus.onNext(new FileDownloadTaskStatus(AppDownloadState.PROGRESS, new FileDownloadProgressResult(soFarBytes, totalBytes), this.md5));
        $jacocoInit[2] = true;
    }

    /* access modifiers changed from: protected */
    public void paused(C13079a baseDownloadTask, long soFarBytes, long totalBytes) {
        boolean[] $jacocoInit = $jacocoInit();
        this.downloadStatus.onNext(new FileDownloadTaskStatus(AppDownloadState.PAUSED, new FileDownloadProgressResult(soFarBytes, totalBytes), this.md5));
        $jacocoInit[3] = true;
    }

    /* access modifiers changed from: protected */
    public void completed(C13079a baseDownloadTask) {
        FileDownloadTaskStatus fileDownloadTaskStatus;
        boolean[] $jacocoInit = $jacocoInit();
        String str = "FileDownloader";
        if (this.md5Comparator.compareMd5(this.md5, this.fileName)) {
            AppDownloadState appDownloadState = AppDownloadState.COMPLETED;
            $jacocoInit[4] = true;
            long y = baseDownloadTask.mo42039y();
            $jacocoInit[5] = true;
            fileDownloadTaskStatus = new FileDownloadTaskStatus(appDownloadState, new FileDownloadProgressResult(y, baseDownloadTask.mo42039y()), this.md5);
            $jacocoInit[6] = true;
            Logger instance = Logger.getInstance();
            $jacocoInit[7] = true;
            instance.mo2136d(str, " Download completed");
            $jacocoInit[8] = true;
        } else {
            Logger instance2 = Logger.getInstance();
            $jacocoInit[9] = true;
            instance2.mo2136d(str, " Download error in md5");
            $jacocoInit[10] = true;
            fileDownloadTaskStatus = new FileDownloadTaskStatus(AppDownloadState.ERROR, this.md5, (Throwable) new Md5DownloadComparisonException("md5 does not match"));
            $jacocoInit[11] = true;
        }
        this.downloadStatus.onNext(fileDownloadTaskStatus);
        $jacocoInit[12] = true;
    }

    /* access modifiers changed from: protected */
    public void error(C13079a baseDownloadTask, Throwable error) {
        FileDownloadTaskStatus fileDownloadTaskStatus;
        boolean[] $jacocoInit = $jacocoInit();
        String str = "FileDownloader";
        if (error != null) {
            $jacocoInit[13] = true;
            error.printStackTrace();
            if (!(error instanceof FileDownloadHttpException)) {
                $jacocoInit[14] = true;
            } else {
                FileDownloadHttpException fileDownloadHttpException = (FileDownloadHttpException) error;
                $jacocoInit[15] = true;
                if (fileDownloadHttpException.mo35685a() != FILE_NOT_FOUND_HTTP_ERROR) {
                    $jacocoInit[16] = true;
                } else {
                    $jacocoInit[17] = true;
                    Logger instance = Logger.getInstance();
                    StringBuilder sb = new StringBuilder();
                    sb.append("File not found error on app: ");
                    sb.append(this.md5);
                    String sb2 = sb.toString();
                    $jacocoInit[18] = true;
                    instance.mo2136d(str, sb2);
                    $jacocoInit[19] = true;
                    fileDownloadTaskStatus = new FileDownloadTaskStatus(AppDownloadState.ERROR_FILE_NOT_FOUND, this.md5, error);
                    $jacocoInit[20] = true;
                }
            }
            if (error instanceof FileDownloadOutOfSpaceException) {
                $jacocoInit[21] = true;
                Logger instance2 = Logger.getInstance();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Out of space error for the app: ");
                sb3.append(this.md5);
                String sb4 = sb3.toString();
                $jacocoInit[22] = true;
                instance2.mo2136d(str, sb4);
                $jacocoInit[23] = true;
                fileDownloadTaskStatus = new FileDownloadTaskStatus(AppDownloadState.ERROR_NOT_ENOUGH_SPACE, this.md5, error);
                $jacocoInit[24] = true;
            } else {
                Logger instance3 = Logger.getInstance();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("Generic error on app: ");
                sb5.append(this.md5);
                String sb6 = sb5.toString();
                $jacocoInit[25] = true;
                instance3.mo2136d(str, sb6);
                $jacocoInit[26] = true;
                fileDownloadTaskStatus = new FileDownloadTaskStatus(AppDownloadState.ERROR, this.md5, error);
                $jacocoInit[27] = true;
            }
        } else {
            Logger instance4 = Logger.getInstance();
            StringBuilder sb7 = new StringBuilder();
            sb7.append("Unknown error on app: ");
            sb7.append(this.md5);
            String sb8 = sb7.toString();
            $jacocoInit[28] = true;
            instance4.mo2136d(str, sb8);
            $jacocoInit[29] = true;
            fileDownloadTaskStatus = new FileDownloadTaskStatus(AppDownloadState.ERROR, this.md5, (Throwable) new GeneralDownloadErrorException("Empty download error"));
            $jacocoInit[30] = true;
        }
        this.downloadStatus.onNext(fileDownloadTaskStatus);
        $jacocoInit[31] = true;
    }

    /* access modifiers changed from: protected */
    public void warn(C13079a baseDownloadTask) {
        boolean[] $jacocoInit = $jacocoInit();
        this.downloadStatus.onNext(new FileDownloadTaskStatus(AppDownloadState.WARN, this.md5, (Throwable) null));
        $jacocoInit[32] = true;
    }

    public C0120S<FileDownloadCallback> onDownloadStateChanged() {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<FileDownloadCallback> cVar = this.downloadStatus;
        $jacocoInit[33] = true;
        return cVar;
    }
}
