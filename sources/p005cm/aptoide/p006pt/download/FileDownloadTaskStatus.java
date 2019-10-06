package p005cm.aptoide.p006pt.download;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.downloadmanager.AppDownloadStatus.AppDownloadState;
import p005cm.aptoide.p006pt.downloadmanager.FileDownloadCallback;
import p005cm.aptoide.p006pt.downloadmanager.FileDownloadProgressResult;

/* renamed from: cm.aptoide.pt.download.FileDownloadTaskStatus */
public class FileDownloadTaskStatus implements FileDownloadCallback {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private AppDownloadState appDownloadState;
    private FileDownloadProgressResult downloadProgress;
    private Throwable error;
    private String md5;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(954926938156904493L, "cm/aptoide/pt/download/FileDownloadTaskStatus", 16);
        $jacocoData = probes;
        return probes;
    }

    public FileDownloadTaskStatus(AppDownloadState appDownloadState2, FileDownloadProgressResult downloadProgress2, String md52) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appDownloadState = appDownloadState2;
        this.downloadProgress = downloadProgress2;
        this.md5 = md52;
        this.error = null;
        $jacocoInit[0] = true;
    }

    public FileDownloadTaskStatus(AppDownloadState appDownloadState2, String md52, Throwable error2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appDownloadState = appDownloadState2;
        this.md5 = md52;
        this.error = error2;
        $jacocoInit[1] = true;
        this.downloadProgress = new FileDownloadProgressResult(0, 0);
        $jacocoInit[2] = true;
    }

    public FileDownloadProgressResult getDownloadProgress() {
        boolean[] $jacocoInit = $jacocoInit();
        FileDownloadProgressResult fileDownloadProgressResult = this.downloadProgress;
        $jacocoInit[3] = true;
        return fileDownloadProgressResult;
    }

    public AppDownloadState getDownloadState() {
        boolean[] $jacocoInit = $jacocoInit();
        AppDownloadState appDownloadState2 = this.appDownloadState;
        $jacocoInit[4] = true;
        return appDownloadState2;
    }

    public String getMd5() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.md5;
        $jacocoInit[5] = true;
        return str;
    }

    public boolean hasError() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (this.error != null) {
            $jacocoInit[6] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[7] = true;
        }
        $jacocoInit[8] = true;
        return z;
    }

    public Throwable getError() {
        boolean[] $jacocoInit = $jacocoInit();
        Throwable th = this.error;
        $jacocoInit[9] = true;
        return th;
    }

    public boolean equals(Object o) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this == o) {
            $jacocoInit[10] = true;
            return true;
        }
        if (o == null) {
            $jacocoInit[11] = true;
        } else if (getClass() != o.getClass()) {
            $jacocoInit[12] = true;
        } else {
            FileDownloadTaskStatus that = (FileDownloadTaskStatus) o;
            $jacocoInit[14] = true;
            boolean equals = this.md5.equals(that.getMd5());
            $jacocoInit[15] = true;
            return equals;
        }
        $jacocoInit[13] = true;
        return false;
    }
}
