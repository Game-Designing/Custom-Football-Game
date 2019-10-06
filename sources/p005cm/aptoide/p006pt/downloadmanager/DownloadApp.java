package p005cm.aptoide.p006pt.downloadmanager;

import java.util.List;

/* renamed from: cm.aptoide.pt.downloadmanager.DownloadApp */
public class DownloadApp {
    private List<DownloadAppFile> downloadFiles;
    private String md5;
    private final String packageName;
    private long size;
    private final int versionCode;

    public DownloadApp(String packageName2, int versionCode2, List<DownloadAppFile> downloadFiles2, String md52, long size2) {
        this.packageName = packageName2;
        this.versionCode = versionCode2;
        this.downloadFiles = downloadFiles2;
        this.md5 = md52;
        this.size = size2;
    }

    public List<DownloadAppFile> getDownloadFiles() {
        return this.downloadFiles;
    }

    public String getMd5() {
        return this.md5;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public int getVersionCode() {
        return this.versionCode;
    }

    public long getSize() {
        return this.size;
    }
}
