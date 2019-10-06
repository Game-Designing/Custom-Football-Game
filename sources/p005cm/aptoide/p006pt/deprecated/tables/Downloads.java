package p005cm.aptoide.p006pt.deprecated.tables;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.database.accessors.DownloadAccessor;
import p005cm.aptoide.p006pt.database.realm.Download;
import p005cm.aptoide.p006pt.database.realm.FileToDownload;
import p005cm.aptoide.p006pt.utils.AptoideUtils.AlgorithmU;
import p024io.realm.C14014U;

/* renamed from: cm.aptoide.pt.deprecated.tables.Downloads */
public class Downloads {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final long MAX_SIZE_CACHE = 209715200;
    private static final String PATH_TO_NEW_DOWNLOADS = "/.aptoide/apks";
    private static final String PATH_TO_OLD_DOWNLOADS = "/.aptoide/apks";

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(302048557785831653L, "cm/aptoide/pt/deprecated/tables/Downloads", 45);
        $jacocoData = probes;
        return probes;
    }

    public Downloads() {
        $jacocoInit()[0] = true;
    }

    public void migrate(DownloadAccessor downloadAccessor) throws FileNotFoundException {
        boolean[] $jacocoInit = $jacocoInit();
        String str = "/.aptoide/apks";
        File oldPathToDownloads = new File(str);
        $jacocoInit[1] = true;
        if (oldPathToDownloads.isDirectory()) {
            File file = new File(str);
            $jacocoInit[4] = true;
            File newPathToDownloads = file;
            if (newPathToDownloads.isDirectory()) {
                File[] files = oldPathToDownloads.listFiles();
                $jacocoInit[7] = true;
                Arrays.sort(files, C2928a.f6208a);
                long cacheSum = 0;
                int length = files.length;
                int i = 0;
                $jacocoInit[8] = true;
                while (i < length) {
                    File downloadFile = files[i];
                    $jacocoInit[9] = true;
                    if (!downloadFile.exists()) {
                        $jacocoInit[10] = true;
                    } else if (!downloadFile.isFile()) {
                        $jacocoInit[11] = true;
                    } else {
                        $jacocoInit[12] = true;
                        long fileSize = downloadFile.length();
                        $jacocoInit[13] = true;
                        if (MAX_SIZE_CACHE <= cacheSum + fileSize) {
                            $jacocoInit[14] = true;
                        } else {
                            String name = downloadFile.getName();
                            $jacocoInit[15] = true;
                            if (!name.endsWith(".apk")) {
                                $jacocoInit[16] = true;
                            } else {
                                $jacocoInit[17] = true;
                                File file2 = new File(newPathToDownloads, downloadFile.getName());
                                $jacocoInit[18] = true;
                                if (!downloadFile.renameTo(file2)) {
                                    $jacocoInit[19] = true;
                                } else {
                                    cacheSum += fileSize;
                                    $jacocoInit[20] = true;
                                    saveDbEntry(downloadFile, downloadAccessor);
                                    $jacocoInit[21] = true;
                                    i++;
                                    $jacocoInit[25] = true;
                                }
                            }
                        }
                        if (downloadFile.delete()) {
                            $jacocoInit[22] = true;
                        } else {
                            $jacocoInit[23] = true;
                            downloadFile.deleteOnExit();
                            $jacocoInit[24] = true;
                        }
                    }
                    DownloadAccessor downloadAccessor2 = downloadAccessor;
                    i++;
                    $jacocoInit[25] = true;
                }
                DownloadAccessor downloadAccessor3 = downloadAccessor;
                $jacocoInit[26] = true;
                return;
            }
            DownloadAccessor downloadAccessor4 = downloadAccessor;
            $jacocoInit[5] = true;
            FileNotFoundException fileNotFoundException = new FileNotFoundException("Path to new downloads is invalid");
            $jacocoInit[6] = true;
            throw fileNotFoundException;
        }
        DownloadAccessor downloadAccessor5 = downloadAccessor;
        $jacocoInit[2] = true;
        FileNotFoundException fileNotFoundException2 = new FileNotFoundException("Path to old downloads is invalid");
        $jacocoInit[3] = true;
        throw fileNotFoundException2;
    }

    /* renamed from: a */
    static /* synthetic */ int m7595a(File f1, File f2) {
        boolean[] $jacocoInit = $jacocoInit();
        Long valueOf = Long.valueOf(f1.lastModified());
        $jacocoInit[43] = true;
        int compareTo = valueOf.compareTo(Long.valueOf(f2.lastModified()));
        $jacocoInit[44] = true;
        return compareTo;
    }

    private void saveDbEntry(File downloadFile, DownloadAccessor downloadAccessor) {
        boolean[] $jacocoInit = $jacocoInit();
        String downloadFileMd5 = AlgorithmU.computeMd5(downloadFile);
        $jacocoInit[27] = true;
        FileToDownload fileToDownload = new FileToDownload();
        $jacocoInit[28] = true;
        fileToDownload.setFileName(downloadFile.getName());
        $jacocoInit[29] = true;
        fileToDownload.setFileType(0);
        $jacocoInit[30] = true;
        fileToDownload.setPath(downloadFile.getPath());
        $jacocoInit[31] = true;
        fileToDownload.setMd5(downloadFileMd5);
        $jacocoInit[32] = true;
        Download downloadEntry = new Download();
        $jacocoInit[33] = true;
        downloadEntry.setMd5(downloadFileMd5);
        $jacocoInit[34] = true;
        downloadEntry.setAppName(downloadFile.getName());
        $jacocoInit[35] = true;
        downloadEntry.setTimeStamp(downloadFile.lastModified());
        $jacocoInit[36] = true;
        downloadEntry.setFilesToDownload(new C14014U(fileToDownload));
        $jacocoInit[37] = true;
        downloadEntry.setDownloadSpeed(0);
        $jacocoInit[38] = true;
        downloadEntry.setIcon(null);
        $jacocoInit[39] = true;
        downloadEntry.setOverallDownloadStatus(1);
        $jacocoInit[40] = true;
        downloadEntry.setOverallProgress(100);
        $jacocoInit[41] = true;
        downloadAccessor.insert(downloadEntry);
        $jacocoInit[42] = true;
    }
}
