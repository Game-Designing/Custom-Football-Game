package p005cm.aptoide.p006pt.download;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.downloadmanager.FileDownloadCallback;
import p005cm.aptoide.p006pt.downloadmanager.FileDownloader;
import p005cm.aptoide.p006pt.downloadmanager.FileDownloaderProvider;
import p019d.p307j.p308a.C13149w;
import p026rx.p028h.C14963c;

/* renamed from: cm.aptoide.pt.download.FileDownloadManagerProvider */
public class FileDownloadManagerProvider implements FileDownloaderProvider {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private String downloadsPath;
    private C13149w fileDownloader;
    private Md5Comparator md5Comparator;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-9081594810602734947L, "cm/aptoide/pt/download/FileDownloadManagerProvider", 2);
        $jacocoData = probes;
        return probes;
    }

    public FileDownloadManagerProvider(String downloadsPath2, C13149w fileDownloader2, Md5Comparator md5Comparator2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.downloadsPath = downloadsPath2;
        this.fileDownloader = fileDownloader2;
        this.md5Comparator = md5Comparator2;
        $jacocoInit[0] = true;
    }

    public FileDownloader createFileDownloader(String md5, String mainDownloadPath, int fileType, String packageName, int versionCode, String fileName, C14963c<FileDownloadCallback> downloadStatusCallback) {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<FileDownloadCallback> cVar = downloadStatusCallback;
        FileDownloadManager fileDownloadManager = new FileDownloadManager(this.fileDownloader, new FileDownloadTask(cVar, md5, this.md5Comparator, fileName), this.downloadsPath, mainDownloadPath, fileType, packageName, versionCode, fileName);
        $jacocoInit[1] = true;
        return fileDownloadManager;
    }
}
