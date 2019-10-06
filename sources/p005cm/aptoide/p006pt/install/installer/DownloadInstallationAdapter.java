package p005cm.aptoide.p006pt.install.installer;

import java.io.File;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.database.accessors.DownloadAccessor;
import p005cm.aptoide.p006pt.database.realm.Download;
import p005cm.aptoide.p006pt.database.realm.FileToDownload;
import p005cm.aptoide.p006pt.database.realm.Installed;
import p005cm.aptoide.p006pt.install.InstalledRepository;
import p024io.realm.C14014U;

/* renamed from: cm.aptoide.pt.install.installer.DownloadInstallationAdapter */
public class DownloadInstallationAdapter implements Installation {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Download download;
    private DownloadAccessor downloadAccessor;
    private Installed installed;
    private InstalledRepository ongoingInstallProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6138763304153942341L, "cm/aptoide/pt/install/installer/DownloadInstallationAdapter", 19);
        $jacocoData = probes;
        return probes;
    }

    public DownloadInstallationAdapter(Download download2, DownloadAccessor downloadAccessor2, InstalledRepository installedRepository, Installed installed2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.download = download2;
        this.downloadAccessor = downloadAccessor2;
        this.ongoingInstallProvider = installedRepository;
        this.installed = installed2;
        $jacocoInit[0] = true;
    }

    public String getId() {
        boolean[] $jacocoInit = $jacocoInit();
        String md5 = this.download.getMd5();
        $jacocoInit[1] = true;
        return md5;
    }

    public String getPackageName() {
        boolean[] $jacocoInit = $jacocoInit();
        C14014U filesToDownload = this.download.getFilesToDownload();
        $jacocoInit[2] = true;
        FileToDownload fileToDownload = (FileToDownload) filesToDownload.get(0);
        $jacocoInit[3] = true;
        String packageName = fileToDownload.getPackageName();
        $jacocoInit[4] = true;
        return packageName;
    }

    public int getVersionCode() {
        boolean[] $jacocoInit = $jacocoInit();
        C14014U filesToDownload = this.download.getFilesToDownload();
        $jacocoInit[5] = true;
        FileToDownload fileToDownload = (FileToDownload) filesToDownload.get(0);
        $jacocoInit[6] = true;
        int versionCode = fileToDownload.getVersionCode();
        $jacocoInit[7] = true;
        return versionCode;
    }

    public String getVersionName() {
        boolean[] $jacocoInit = $jacocoInit();
        String versionName = this.download.getVersionName();
        $jacocoInit[8] = true;
        return versionName;
    }

    public File getFile() {
        boolean[] $jacocoInit = $jacocoInit();
        C14014U filesToDownload = this.download.getFilesToDownload();
        $jacocoInit[9] = true;
        FileToDownload fileToDownload = (FileToDownload) filesToDownload.get(0);
        $jacocoInit[10] = true;
        File file = new File(fileToDownload.getFilePath());
        $jacocoInit[11] = true;
        return file;
    }

    public void save() {
        boolean[] $jacocoInit = $jacocoInit();
        this.ongoingInstallProvider.save(this.installed);
        $jacocoInit[12] = true;
    }

    public int getStatus() {
        boolean[] $jacocoInit = $jacocoInit();
        int status = this.installed.getStatus();
        $jacocoInit[13] = true;
        return status;
    }

    public void setStatus(int status) {
        boolean[] $jacocoInit = $jacocoInit();
        this.installed.setStatus(status);
        $jacocoInit[14] = true;
    }

    public int getType() {
        boolean[] $jacocoInit = $jacocoInit();
        int type = this.installed.getType();
        $jacocoInit[15] = true;
        return type;
    }

    public void setType(int type) {
        boolean[] $jacocoInit = $jacocoInit();
        this.installed.setType(type);
        $jacocoInit[16] = true;
    }

    public List<FileToDownload> getFiles() {
        boolean[] $jacocoInit = $jacocoInit();
        C14014U filesToDownload = this.download.getFilesToDownload();
        $jacocoInit[17] = true;
        return filesToDownload;
    }

    public void saveFileChanges() {
        boolean[] $jacocoInit = $jacocoInit();
        this.downloadAccessor.save(this.download);
        $jacocoInit[18] = true;
    }
}
