package p005cm.aptoide.p006pt.download;

import io.realm.RealmList;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.database.realm.Download;
import p005cm.aptoide.p006pt.database.realm.FileToDownload;
import p005cm.aptoide.p006pt.database.realm.Update;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Obb;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Obb.ObbItem;
import p005cm.aptoide.p006pt.download.AppValidator.AppValidationResult;
import p024io.realm.C14014U;

/* renamed from: cm.aptoide.pt.download.DownloadFactory */
public class DownloadFactory {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final AppValidator appValidator;
    private final String cachePath;
    private final DownloadApkPathsProvider downloadApkPathsProvider;
    private final String marketName;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(2390296971544992992L, "cm/aptoide/pt/download/DownloadFactory", 83);
        $jacocoData = probes;
        return probes;
    }

    public DownloadFactory(String marketName2, DownloadApkPathsProvider downloadApkPathsProvider2, String cachePath2, AppValidator appValidator2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.marketName = marketName2;
        this.cachePath = cachePath2;
        this.downloadApkPathsProvider = downloadApkPathsProvider2;
        this.appValidator = appValidator2;
        $jacocoInit[0] = true;
    }

    private C14014U<FileToDownload> createFileList(String md5, String packageName, String filePath, String fileMd5, Obb appObb, String altPathToApk, int versionCode, String versionName) {
        boolean[] $jacocoInit = $jacocoInit();
        String mainObbPath = null;
        String mainObbMd5 = null;
        String patchObbPath = null;
        String patchObbMd5 = null;
        String mainObbName = null;
        String patchObbName = null;
        if (appObb == null) {
            $jacocoInit[1] = true;
        } else {
            $jacocoInit[2] = true;
            ObbItem main = appObb.getMain();
            if (main == null) {
                $jacocoInit[3] = true;
            } else {
                $jacocoInit[4] = true;
                mainObbPath = main.getPath();
                $jacocoInit[5] = true;
                mainObbMd5 = main.getMd5sum();
                $jacocoInit[6] = true;
                mainObbName = main.getFilename();
                $jacocoInit[7] = true;
            }
            ObbItem patch = appObb.getPatch();
            if (patch == null) {
                $jacocoInit[8] = true;
            } else {
                $jacocoInit[9] = true;
                patchObbPath = patch.getPath();
                $jacocoInit[10] = true;
                patchObbMd5 = patch.getMd5sum();
                $jacocoInit[11] = true;
                patchObbName = patch.getFilename();
                $jacocoInit[12] = true;
            }
        }
        C14014U<FileToDownload> createFileList = createFileList(md5, packageName, filePath, altPathToApk, fileMd5, mainObbPath, mainObbMd5, patchObbPath, patchObbMd5, versionCode, versionName, mainObbName, patchObbName);
        $jacocoInit[13] = true;
        return createFileList;
    }

    private C14014U<FileToDownload> createFileList(String md5, String packageName, String filePath, String altPathToApk, String fileMd5, String mainObbPath, String mainObbMd5, String patchObbPath, String patchObbMd5, int versionCode, String versionName, String mainObbName, String patchObbName) {
        boolean[] $jacocoInit = $jacocoInit();
        RealmList<FileToDownload> downloads = new C14014U<>();
        $jacocoInit[14] = true;
        downloads.add(FileToDownload.createFileToDownload(filePath, altPathToApk, md5, fileMd5, 0, packageName, versionCode, versionName, this.cachePath));
        if (mainObbPath == null) {
            $jacocoInit[15] = true;
        } else {
            $jacocoInit[16] = true;
            downloads.add(FileToDownload.createFileToDownload(mainObbPath, null, mainObbMd5, mainObbName, 1, packageName, versionCode, versionName, this.cachePath));
            $jacocoInit[17] = true;
        }
        if (patchObbPath == null) {
            $jacocoInit[18] = true;
        } else {
            String str = this.cachePath;
            $jacocoInit[19] = true;
            FileToDownload createFileToDownload = FileToDownload.createFileToDownload(patchObbPath, null, patchObbMd5, patchObbName, 1, packageName, versionCode, versionName, str);
            $jacocoInit[20] = true;
            downloads.add(createFileToDownload);
            $jacocoInit[21] = true;
        }
        $jacocoInit[22] = true;
        return downloads;
    }

    public Download create(Update update, boolean isAppcUpgrade) {
        int i;
        boolean[] $jacocoInit = $jacocoInit();
        AppValidator appValidator2 = this.appValidator;
        $jacocoInit[23] = true;
        String md5 = update.getMd5();
        String packageName = update.getPackageName();
        String label = update.getLabel();
        $jacocoInit[24] = true;
        String apkPath = update.getApkPath();
        String alternativeApkPath = update.getAlternativeApkPath();
        $jacocoInit[25] = true;
        AppValidationResult validationResult = appValidator2.validateApp(md5, null, packageName, label, apkPath, alternativeApkPath);
        if (validationResult == AppValidationResult.VALID_APP) {
            DownloadApkPathsProvider downloadApkPathsProvider2 = this.downloadApkPathsProvider;
            int i2 = 2;
            if (isAppcUpgrade) {
                $jacocoInit[26] = true;
                i = 2;
            } else {
                $jacocoInit[27] = true;
                i = 1;
            }
            $jacocoInit[28] = true;
            String apkPath2 = update.getApkPath();
            $jacocoInit[29] = true;
            String alternativeApkPath2 = update.getAlternativeApkPath();
            $jacocoInit[30] = true;
            ApkPaths downloadPaths = downloadApkPathsProvider2.getDownloadPaths(i, apkPath2, alternativeApkPath2);
            $jacocoInit[31] = true;
            Download download = new Download();
            $jacocoInit[32] = true;
            Download download2 = download;
            download2.setMd5(update.getMd5());
            $jacocoInit[33] = true;
            download2.setIcon(update.getIcon());
            $jacocoInit[34] = true;
            download2.setAppName(update.getLabel());
            $jacocoInit[35] = true;
            if (isAppcUpgrade) {
                $jacocoInit[36] = true;
            } else {
                $jacocoInit[37] = true;
                i2 = 1;
            }
            download2.setAction(i2);
            $jacocoInit[38] = true;
            download2.setPackageName(update.getPackageName());
            $jacocoInit[39] = true;
            download2.setVersionCode(update.getUpdateVersionCode());
            $jacocoInit[40] = true;
            download2.setVersionName(update.getUpdateVersionName());
            $jacocoInit[41] = true;
            download2.setHasAppc(update.hasAppc());
            $jacocoInit[42] = true;
            String md52 = update.getMd5();
            String packageName2 = update.getPackageName();
            String path = downloadPaths.getPath();
            $jacocoInit[43] = true;
            String altPath = downloadPaths.getAltPath();
            String md53 = update.getMd5();
            String mainObbPath = update.getMainObbPath();
            $jacocoInit[44] = true;
            String mainObbMd5 = update.getMainObbMd5();
            String patchObbPath = update.getPatchObbPath();
            String patchObbMd5 = update.getPatchObbMd5();
            $jacocoInit[45] = true;
            int updateVersionCode = update.getUpdateVersionCode();
            String updateVersionName = update.getUpdateVersionName();
            String mainObbName = update.getMainObbName();
            $jacocoInit[46] = true;
            String patchObbName = update.getPatchObbName();
            $jacocoInit[47] = true;
            Download download3 = download2;
            String str = mainObbName;
            AppValidationResult appValidationResult = validationResult;
            C14014U createFileList = createFileList(md52, packageName2, path, altPath, md53, mainObbPath, mainObbMd5, patchObbPath, patchObbMd5, updateVersionCode, updateVersionName, str, patchObbName);
            $jacocoInit[48] = true;
            download3.setFilesToDownload(createFileList);
            $jacocoInit[49] = true;
            download3.setSize(update.getSize());
            $jacocoInit[50] = true;
            return download3;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(validationResult.getMessage());
        $jacocoInit[51] = true;
        throw illegalArgumentException;
    }

    public Download create(String md5, int versionCode, String packageName, String uri, boolean hasAppc) {
        boolean[] $jacocoInit = $jacocoInit();
        DownloadApkPathsProvider downloadApkPathsProvider2 = this.downloadApkPathsProvider;
        $jacocoInit[52] = true;
        ApkPaths downloadPaths = downloadApkPathsProvider2.getDownloadPaths(1, uri, null);
        String versionName = "Auto-Update";
        $jacocoInit[53] = true;
        Download download = new Download();
        $jacocoInit[54] = true;
        Download download2 = download;
        download2.setAppName(this.marketName);
        $jacocoInit[55] = true;
        download2.setMd5(md5);
        $jacocoInit[56] = true;
        int i = versionCode;
        download2.setVersionCode(i);
        $jacocoInit[57] = true;
        download2.setPackageName(packageName);
        $jacocoInit[58] = true;
        download2.setVersionName(versionName);
        $jacocoInit[59] = true;
        download2.setAction(1);
        $jacocoInit[60] = true;
        download2.setHasAppc(hasAppc);
        $jacocoInit[61] = true;
        download2.setSize(0);
        $jacocoInit[62] = true;
        C14014U createFileList = createFileList(md5, packageName, downloadPaths.getPath(), md5, null, null, i, versionName);
        $jacocoInit[63] = true;
        download2.setFilesToDownload(createFileList);
        $jacocoInit[64] = true;
        return download2;
    }

    public Download create(int downloadAction, String appName, String packageName, String md5, String icon, String versionName, int versionCode, String appPath, String appPathAlt, Obb obb, boolean hasAppc, long size) {
        int i = downloadAction;
        boolean[] $jacocoInit = $jacocoInit();
        AppValidator appValidator2 = this.appValidator;
        $jacocoInit[65] = true;
        AppValidationResult validationResult = appValidator2.validateApp(md5, obb, packageName, appName, appPath, appPathAlt);
        if (validationResult == AppValidationResult.VALID_APP) {
            DownloadApkPathsProvider downloadApkPathsProvider2 = this.downloadApkPathsProvider;
            $jacocoInit[66] = true;
            ApkPaths downloadPaths = downloadApkPathsProvider2.getDownloadPaths(i, appPath, appPathAlt);
            $jacocoInit[67] = true;
            Download download = new Download();
            $jacocoInit[68] = true;
            Download download2 = download;
            download2.setMd5(md5);
            $jacocoInit[69] = true;
            download2.setIcon(icon);
            $jacocoInit[70] = true;
            download2.setAppName(appName);
            $jacocoInit[71] = true;
            download2.setAction(i);
            $jacocoInit[72] = true;
            download2.setPackageName(packageName);
            $jacocoInit[73] = true;
            download2.setHasAppc(hasAppc);
            $jacocoInit[74] = true;
            download2.setVersionCode(versionCode);
            $jacocoInit[75] = true;
            download2.setVersionName(versionName);
            $jacocoInit[76] = true;
            AppValidationResult appValidationResult = validationResult;
            download2.setSize(size);
            $jacocoInit[77] = true;
            String path = downloadPaths.getPath();
            $jacocoInit[78] = true;
            String altPath = downloadPaths.getAltPath();
            $jacocoInit[79] = true;
            Download download3 = download2;
            C14014U createFileList = createFileList(md5, packageName, path, md5, obb, altPath, versionCode, versionName);
            $jacocoInit[80] = true;
            download3.setFilesToDownload(createFileList);
            $jacocoInit[81] = true;
            return download3;
        }
        String str = appPath;
        String str2 = appPathAlt;
        long j = size;
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(validationResult.getMessage());
        $jacocoInit[82] = true;
        throw illegalArgumentException;
    }
}
