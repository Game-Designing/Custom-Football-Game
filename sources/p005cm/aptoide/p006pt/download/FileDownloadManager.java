package p005cm.aptoide.p006pt.download;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.downloadmanager.Constants;
import p005cm.aptoide.p006pt.downloadmanager.FileDownloadCallback;
import p005cm.aptoide.p006pt.downloadmanager.FileDownloader;
import p019d.p307j.p308a.C13079a;
import p019d.p307j.p308a.C13079a.C13082c;
import p019d.p307j.p308a.C13130l;
import p019d.p307j.p308a.C13149w;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.p027b.C0128a;

/* renamed from: cm.aptoide.pt.download.FileDownloadManager */
public class FileDownloadManager implements FileDownloader {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final int APTOIDE_DOWNLOAD_TASK_TAG_KEY = 888;
    public static final int PROGRESS_MAX_VALUE = 100;
    public static final int RETRY_TIMES = 3;
    private int downloadId;
    private String downloadsPath;
    private FileDownloadTask fileDownloadTask;
    private C13149w fileDownloader;
    private final String fileName;
    private final int fileType;
    private final String mainDownloadPath;
    private final String packageName;
    private final int versionCode;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6058109888930923290L, "cm/aptoide/pt/download/FileDownloadManager", 27);
        $jacocoData = probes;
        return probes;
    }

    public FileDownloadManager(C13149w fileDownloader2, FileDownloadTask fileDownloadTask2, String downloadsPath2, String mainDownloadPath2, int fileType2, String packageName2, int versionCode2, String fileName2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.fileDownloader = fileDownloader2;
        this.fileDownloadTask = fileDownloadTask2;
        this.downloadsPath = downloadsPath2;
        this.mainDownloadPath = mainDownloadPath2;
        this.fileType = fileType2;
        this.packageName = packageName2;
        this.versionCode = versionCode2;
        this.fileName = fileName2;
        $jacocoInit[0] = true;
    }

    public C0117M startFileDownload() {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M c = C0117M.m597c((C0128a) new C2937h(this));
        $jacocoInit[1] = true;
        return c;
    }

    /* renamed from: c */
    public /* synthetic */ void mo13590c() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.mainDownloadPath;
        if (str == null) {
            $jacocoInit[22] = true;
        } else if (!str.isEmpty()) {
            createBaseDownloadTask(this.mainDownloadPath, this.versionCode, this.packageName, this.fileType, this.fileName);
            $jacocoInit[25] = true;
            this.fileDownloader.mo42162a((C13130l) this.fileDownloadTask, true);
            $jacocoInit[26] = true;
            return;
        } else {
            $jacocoInit[23] = true;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("The url for the download can not be empty");
        $jacocoInit[24] = true;
        throw illegalArgumentException;
    }

    /* renamed from: a */
    public /* synthetic */ void mo13588a() {
        boolean[] $jacocoInit = $jacocoInit();
        this.fileDownloader.mo42160a((C13130l) this.fileDownloadTask);
        $jacocoInit[21] = true;
    }

    public C0117M pauseDownload() {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M c = C0117M.m597c((C0128a) new C2936g(this));
        $jacocoInit[2] = true;
        return c;
    }

    /* renamed from: b */
    public /* synthetic */ void mo13589b() {
        boolean[] $jacocoInit = $jacocoInit();
        this.fileDownloader.mo42161a(this.downloadId, this.mainDownloadPath);
        $jacocoInit[20] = true;
    }

    public C0117M removeDownloadFile() {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M c = C0117M.m597c((C0128a) new C2935f(this));
        $jacocoInit[3] = true;
        return c;
    }

    public C0120S<FileDownloadCallback> observeFileDownloadProgress() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<FileDownloadCallback> onDownloadStateChanged = this.fileDownloadTask.onDownloadStateChanged();
        $jacocoInit[4] = true;
        return onDownloadStateChanged;
    }

    public void stopFailedDownload() {
        boolean[] $jacocoInit = $jacocoInit();
        int taskId = this.fileDownloader.mo42156a(this.downloadId, (C13130l) null);
        if (taskId == 0) {
            $jacocoInit[5] = true;
        } else {
            $jacocoInit[6] = true;
            this.fileDownloader.mo42155a(taskId);
            $jacocoInit[7] = true;
        }
        $jacocoInit[8] = true;
    }

    private void createBaseDownloadTask(String mainDownloadPath2, int versionCode2, String packageName2, int fileType2, String fileName2) {
        boolean[] $jacocoInit = $jacocoInit();
        C13079a baseDownloadTask = this.fileDownloader.mo42157a(mainDownloadPath2);
        $jacocoInit[9] = true;
        baseDownloadTask.mo42015c(3);
        $jacocoInit[10] = true;
        baseDownloadTask.addHeader(Constants.VERSION_CODE, String.valueOf(versionCode2));
        $jacocoInit[11] = true;
        baseDownloadTask.addHeader(Constants.PACKAGE, packageName2);
        $jacocoInit[12] = true;
        baseDownloadTask.addHeader(Constants.FILE_TYPE, String.valueOf(fileType2));
        $jacocoInit[13] = true;
        baseDownloadTask.mo42010a(APTOIDE_DOWNLOAD_TASK_TAG_KEY, this.fileDownloadTask);
        $jacocoInit[14] = true;
        baseDownloadTask.mo42011a((C13130l) this.fileDownloadTask);
        $jacocoInit[15] = true;
        baseDownloadTask.mo42016d(100);
        $jacocoInit[16] = true;
        StringBuilder sb = new StringBuilder();
        sb.append(this.downloadsPath);
        sb.append(fileName2);
        baseDownloadTask.setPath(sb.toString());
        $jacocoInit[17] = true;
        C13082c j = baseDownloadTask.mo42027j();
        $jacocoInit[18] = true;
        this.downloadId = j.mo42054a();
        $jacocoInit[19] = true;
    }
}
