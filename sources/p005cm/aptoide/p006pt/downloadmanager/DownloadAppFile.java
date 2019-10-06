package p005cm.aptoide.p006pt.downloadmanager;

/* renamed from: cm.aptoide.pt.downloadmanager.DownloadAppFile */
public class DownloadAppFile {
    private String alternativeDownloadPath;
    private String downloadMd5;
    private String fileName;
    private FileType fileType;
    private String mainDownloadPath;
    private String packageName;
    private int versionCode;

    /* renamed from: cm.aptoide.pt.downloadmanager.DownloadAppFile$FileType */
    public enum FileType {
        APK(0),
        OBB(1),
        GENERIC(2);
        
        private final int type;

        private FileType(int type2) {
            this.type = type2;
        }

        public int getType() {
            return this.type;
        }
    }

    public DownloadAppFile(String mainDownloadPath2, String alternativeDownloadPath2, String downloadMd52, int versionCode2, String packageName2, String fileName2, FileType fileType2) {
        this.mainDownloadPath = mainDownloadPath2;
        this.alternativeDownloadPath = alternativeDownloadPath2;
        this.downloadMd5 = downloadMd52;
        this.versionCode = versionCode2;
        this.packageName = packageName2;
        this.fileName = fileName2;
        this.fileType = fileType2;
    }

    public String getMainDownloadPath() {
        return this.mainDownloadPath;
    }

    public String getAlternativeDownloadPath() {
        return this.alternativeDownloadPath;
    }

    public String getDownloadMd5() {
        return this.downloadMd5;
    }

    public int getVersionCode() {
        return this.versionCode;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public int getFileType() {
        return this.fileType.getType();
    }

    public String getFileName() {
        return this.fileName;
    }
}
