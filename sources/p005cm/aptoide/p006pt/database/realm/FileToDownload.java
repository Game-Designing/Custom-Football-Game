package p005cm.aptoide.p006pt.database.realm;

import android.text.TextUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import p005cm.aptoide.p006pt.utils.IdUtils;
import p024io.realm.C0106Z;
import p024io.realm.C14079o;
import p024io.realm.internal.C7344p;

/* renamed from: cm.aptoide.pt.database.realm.FileToDownload */
public class FileToDownload extends C0106Z implements C14079o {
    public static final int APK = 0;
    public static final int GENERIC = 2;
    public static final int OBB = 1;
    private String altLink;
    private int downloadId;
    private String fileName;
    private int fileType;
    private String link;
    private String md5;
    private String packageName;
    private String path;
    private int progress;
    private int status;
    private int versionCode;
    private String versionName;

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: cm.aptoide.pt.database.realm.FileToDownload$FileType */
    public @interface FileType {
    }

    public String realmGet$altLink() {
        return this.altLink;
    }

    public int realmGet$downloadId() {
        return this.downloadId;
    }

    public String realmGet$fileName() {
        return this.fileName;
    }

    public int realmGet$fileType() {
        return this.fileType;
    }

    public String realmGet$link() {
        return this.link;
    }

    public String realmGet$md5() {
        return this.md5;
    }

    public String realmGet$packageName() {
        return this.packageName;
    }

    public String realmGet$path() {
        return this.path;
    }

    public int realmGet$progress() {
        return this.progress;
    }

    public int realmGet$status() {
        return this.status;
    }

    public int realmGet$versionCode() {
        return this.versionCode;
    }

    public String realmGet$versionName() {
        return this.versionName;
    }

    public void realmSet$altLink(String str) {
        this.altLink = str;
    }

    public void realmSet$downloadId(int i) {
        this.downloadId = i;
    }

    public void realmSet$fileName(String str) {
        this.fileName = str;
    }

    public void realmSet$fileType(int i) {
        this.fileType = i;
    }

    public void realmSet$link(String str) {
        this.link = str;
    }

    public void realmSet$md5(String str) {
        this.md5 = str;
    }

    public void realmSet$packageName(String str) {
        this.packageName = str;
    }

    public void realmSet$path(String str) {
        this.path = str;
    }

    public void realmSet$progress(int i) {
        this.progress = i;
    }

    public void realmSet$status(int i) {
        this.status = i;
    }

    public void realmSet$versionCode(int i) {
        this.versionCode = i;
    }

    public void realmSet$versionName(String str) {
        this.versionName = str;
    }

    public FileToDownload() {
        if (this instanceof C7344p) {
            ((C7344p) this).mo23792b();
        }
        realmSet$fileType(2);
    }

    public static FileToDownload createFileToDownload(String link2, String altLink2, String md52, String fileName2, int fileType2, String packageName2, int versionCode2, String versionName2, String cachePath) {
        FileToDownload fileToDownload = new FileToDownload();
        fileToDownload.setLink(link2);
        fileToDownload.setMd5(md52);
        fileToDownload.setAltLink(altLink2);
        fileToDownload.realmSet$versionCode(versionCode2);
        fileToDownload.realmSet$versionName(versionName2);
        fileToDownload.setFileType(fileType2);
        fileToDownload.setPath(cachePath);
        if (!TextUtils.isEmpty(fileName2)) {
            if (fileType2 == 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(fileName2);
                sb.append(".apk");
                fileToDownload.setFileName(sb.toString());
            } else {
                fileToDownload.setFileName(fileName2);
            }
        }
        fileToDownload.setPackageName(packageName2);
        return fileToDownload;
    }

    public int getVersionCode() {
        return realmGet$versionCode();
    }

    public String getVersionName() {
        return realmGet$versionName();
    }

    public int hashCode() {
        int i = 0;
        int result = ((((((((((((((((((((getMd5().hashCode() * 31) + getDownloadId()) * 31) + (getAltLink() != null ? getAltLink().hashCode() : 0)) * 31) + (getLink() != null ? getLink().hashCode() : 0)) * 31) + (getPackageName() != null ? getPackageName().hashCode() : 0)) * 31) + (getPath() != null ? getPath().hashCode() : 0)) * 31) + getFileType()) * 31) + getProgress()) * 31) + getStatus()) * 31) + (getFileName() != null ? getFileName().hashCode() : 0)) * 31) + getVersionCode()) * 31;
        if (getVersionName() != null) {
            i = getVersionName().hashCode();
        }
        return result + i;
    }

    public boolean equals(Object o) {
        boolean z = true;
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FileToDownload that = (FileToDownload) o;
        if (getDownloadId() != that.getDownloadId() || getFileType() != that.getFileType() || getProgress() != that.getProgress() || getStatus() != that.getStatus() || getVersionCode() != that.getVersionCode() || !getMd5().equals(that.getMd5())) {
            return false;
        }
        if (getAltLink() == null ? that.getAltLink() != null : !getAltLink().equals(that.getAltLink())) {
            return false;
        }
        if (getLink() == null ? that.getLink() != null : !getLink().equals(that.getLink())) {
            return false;
        }
        if (getPackageName() == null ? that.getPackageName() != null : !getPackageName().equals(that.getPackageName())) {
            return false;
        }
        if (getPath() == null ? that.getPath() != null : !getPath().equals(that.getPath())) {
            return false;
        }
        if (getFileName() == null ? that.getFileName() != null : !getFileName().equals(that.getFileName())) {
            return false;
        }
        if (getVersionName() != null) {
            z = getVersionName().equals(that.getVersionName());
        } else if (that.getVersionName() != null) {
            z = false;
        }
        return z;
    }

    public String getAltLink() {
        return realmGet$altLink();
    }

    public void setAltLink(String altLink2) {
        realmSet$altLink(altLink2);
    }

    public int getStatus() {
        return realmGet$status();
    }

    public void setStatus(int status2) {
        realmSet$status(status2);
    }

    public String getLink() {
        return realmGet$link();
    }

    public void setLink(String link2) {
        realmSet$link(link2);
    }

    public String getPackageName() {
        return realmGet$packageName();
    }

    public void setPackageName(String packageName2) {
        realmSet$packageName(packageName2);
    }

    public int getDownloadId() {
        return realmGet$downloadId();
    }

    public void setDownloadId(int downloadId2) {
        realmSet$downloadId(downloadId2);
    }

    public int getFileType() {
        return realmGet$fileType();
    }

    public void setFileType(int fileType2) {
        realmSet$fileType(fileType2);
    }

    public int getProgress() {
        return realmGet$progress();
    }

    public void setProgress(int progress2) {
        realmSet$progress(progress2);
    }

    public String getFilePath() {
        StringBuilder sb = new StringBuilder();
        sb.append(getPath());
        sb.append(getFileName());
        return sb.toString();
    }

    public String getPath() {
        return realmGet$path();
    }

    public void setPath(String path2) {
        realmSet$path(path2);
    }

    public String getFileName() {
        if (!TextUtils.isEmpty(realmGet$fileName())) {
            return realmGet$fileName();
        }
        return TextUtils.isEmpty(getMd5()) ? IdUtils.randomString() : getMd5();
    }

    public void setFileName(String fileName2) {
        realmSet$fileName(fileName2);
    }

    public String getMd5() {
        return realmGet$md5();
    }

    public void setMd5(String md52) {
        realmSet$md5(md52);
    }
}
