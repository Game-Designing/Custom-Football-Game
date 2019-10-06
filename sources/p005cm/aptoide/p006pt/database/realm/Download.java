package p005cm.aptoide.p006pt.database.realm;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import p024io.realm.C0106Z;
import p024io.realm.C14014U;
import p024io.realm.C14059g;
import p024io.realm.internal.C7344p;

/* renamed from: cm.aptoide.pt.database.realm.Download */
public class Download extends C0106Z implements C14059g {
    public static final int ACTION_DOWNGRADE = 2;
    public static final int ACTION_INSTALL = 0;
    public static final int ACTION_UPDATE = 1;
    public static final int BLOCK_COMPLETE = 2;
    public static final int COMPLETED = 1;
    public static final int CONNECTED = 3;
    public static final String DOWNLOAD_ID = "appId";
    public static final int ERROR = 9;
    public static final int FILE_MISSING = 10;
    public static final int GENERIC_ERROR = 1;
    public static final int INVALID_STATUS = 0;
    public static final int IN_QUEUE = 13;
    public static final String MD5 = "md5";
    public static final int NOT_DOWNLOADED = 12;
    public static final int NOT_ENOUGH_SPACE_ERROR = 2;
    public static final int NO_ERROR = 0;
    public static final int PAUSED = 6;
    public static final int PENDING = 4;
    public static final int PROGRESS = 5;
    public static final int RETRY = 11;
    public static final int STARTED = 8;
    public static String TAG = Download.class.getSimpleName();
    public static final int WARN = 7;
    private String Icon;
    private int action;
    private String appName;
    private int downloadError;
    private int downloadSpeed;
    C14014U<FileToDownload> filesToDownload;
    private boolean hasAppc;
    private String md5;
    int overallDownloadStatus;
    int overallProgress;
    private String packageName;
    private long size;
    private long timeStamp;
    private int versionCode;
    private String versionName;

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: cm.aptoide.pt.database.realm.Download$DownloadError */
    public @interface DownloadError {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: cm.aptoide.pt.database.realm.Download$DownloadState */
    public @interface DownloadState {
    }

    public String realmGet$Icon() {
        return this.Icon;
    }

    public int realmGet$action() {
        return this.action;
    }

    public String realmGet$appName() {
        return this.appName;
    }

    public int realmGet$downloadError() {
        return this.downloadError;
    }

    public int realmGet$downloadSpeed() {
        return this.downloadSpeed;
    }

    public C14014U realmGet$filesToDownload() {
        return this.filesToDownload;
    }

    public boolean realmGet$hasAppc() {
        return this.hasAppc;
    }

    public String realmGet$md5() {
        return this.md5;
    }

    public int realmGet$overallDownloadStatus() {
        return this.overallDownloadStatus;
    }

    public int realmGet$overallProgress() {
        return this.overallProgress;
    }

    public String realmGet$packageName() {
        return this.packageName;
    }

    public long realmGet$size() {
        return this.size;
    }

    public long realmGet$timeStamp() {
        return this.timeStamp;
    }

    public int realmGet$versionCode() {
        return this.versionCode;
    }

    public String realmGet$versionName() {
        return this.versionName;
    }

    public void realmSet$Icon(String str) {
        this.Icon = str;
    }

    public void realmSet$action(int i) {
        this.action = i;
    }

    public void realmSet$appName(String str) {
        this.appName = str;
    }

    public void realmSet$downloadError(int i) {
        this.downloadError = i;
    }

    public void realmSet$downloadSpeed(int i) {
        this.downloadSpeed = i;
    }

    public void realmSet$filesToDownload(C14014U u) {
        this.filesToDownload = u;
    }

    public void realmSet$hasAppc(boolean z) {
        this.hasAppc = z;
    }

    public void realmSet$md5(String str) {
        this.md5 = str;
    }

    public void realmSet$overallDownloadStatus(int i) {
        this.overallDownloadStatus = i;
    }

    public void realmSet$overallProgress(int i) {
        this.overallProgress = i;
    }

    public void realmSet$packageName(String str) {
        this.packageName = str;
    }

    public void realmSet$size(long j) {
        this.size = j;
    }

    public void realmSet$timeStamp(long j) {
        this.timeStamp = j;
    }

    public void realmSet$versionCode(int i) {
        this.versionCode = i;
    }

    public void realmSet$versionName(String str) {
        this.versionName = str;
    }

    public Download() {
        if (this instanceof C7344p) {
            ((C7344p) this).mo23792b();
        }
        realmSet$overallDownloadStatus(0);
        realmSet$overallProgress(0);
    }

    public int getDownloadError() {
        return realmGet$downloadError();
    }

    public void setDownloadError(int downloadError2) {
        realmSet$downloadError(downloadError2);
    }

    public long getTimeStamp() {
        return realmGet$timeStamp();
    }

    public void setTimeStamp(long timeStamp2) {
        realmSet$timeStamp(timeStamp2);
    }

    public String getAppName() {
        return realmGet$appName();
    }

    public void setAppName(String appName2) {
        realmSet$appName(appName2);
    }

    public C14014U<FileToDownload> getFilesToDownload() {
        return realmGet$filesToDownload();
    }

    public void setFilesToDownload(C14014U<FileToDownload> filesToDownload2) {
        realmSet$filesToDownload(filesToDownload2);
    }

    public int getOverallDownloadStatus() {
        return realmGet$overallDownloadStatus();
    }

    public void setOverallDownloadStatus(int overallDownloadStatus2) {
        realmSet$overallDownloadStatus(overallDownloadStatus2);
    }

    public int getOverallProgress() {
        return realmGet$overallProgress();
    }

    public void setOverallProgress(int overallProgress2) {
        realmSet$overallProgress(overallProgress2);
    }

    public String getIcon() {
        return realmGet$Icon();
    }

    public void setIcon(String icon) {
        realmSet$Icon(icon);
    }

    public int getDownloadSpeed() {
        return realmGet$downloadSpeed();
    }

    public void setDownloadSpeed(int speed) {
        realmSet$downloadSpeed(speed);
    }

    public int getVersionCode() {
        return realmGet$versionCode();
    }

    public void setVersionCode(int versionCode2) {
        realmSet$versionCode(versionCode2);
    }

    public String getPackageName() {
        return realmGet$packageName();
    }

    public void setPackageName(String packageName2) {
        realmSet$packageName(packageName2);
    }

    public int getAction() {
        return realmGet$action();
    }

    public void setAction(int action2) {
        realmSet$action(action2);
    }

    public String getMd5() {
        return realmGet$md5();
    }

    public void setMd5(String md52) {
        realmSet$md5(md52);
    }

    public String getVersionName() {
        return realmGet$versionName();
    }

    public void setVersionName(String versionName2) {
        realmSet$versionName(versionName2);
    }

    public boolean hasAppc() {
        return realmGet$hasAppc();
    }

    public void setHasAppc(boolean hasAppc2) {
        realmSet$hasAppc(hasAppc2);
    }

    public int hashCode() {
        int i = 0;
        int result = ((((((((((((((((((getOverallDownloadStatus() * 31) + getOverallProgress()) * 31) + getMd5().hashCode()) * 31) + (getAppName() != null ? getAppName().hashCode() : 0)) * 31) + (getIcon() != null ? getIcon().hashCode() : 0)) * 31) + ((int) (getTimeStamp() ^ (getTimeStamp() >>> 32)))) * 31) + getDownloadSpeed()) * 31) + (getPackageName() != null ? getPackageName().hashCode() : 0)) * 31) + getVersionCode()) * 31) + getAction()) * 31;
        if (getVersionName() != null) {
            i = getVersionName().hashCode();
        }
        return ((result + i) * 31) + getDownloadError();
    }

    public boolean equals(Object o) {
        boolean z = true;
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Download download = (Download) o;
        if (getOverallDownloadStatus() != download.getOverallDownloadStatus() || getOverallProgress() != download.getOverallProgress() || getTimeStamp() != download.getTimeStamp() || getDownloadSpeed() != download.getDownloadSpeed() || getVersionCode() != download.getVersionCode() || getAction() != download.getAction() || getDownloadError() != download.getDownloadError() || !getMd5().equals(download.getMd5())) {
            return false;
        }
        if (getAppName() == null ? download.getAppName() != null : !getAppName().equals(download.getAppName())) {
            return false;
        }
        if (getIcon() == null ? download.getIcon() != null : !getIcon().equals(download.getIcon())) {
            return false;
        }
        if (getPackageName() == null ? download.getPackageName() != null : !getPackageName().equals(download.getPackageName())) {
            return false;
        }
        if (getVersionName() != null) {
            z = getVersionName().equals(download.getVersionName());
        } else if (download.getVersionName() != null) {
            z = false;
        }
        return z;
    }

    public long getSize() {
        return realmGet$size();
    }

    public void setSize(long size2) {
        realmSet$size(size2);
    }
}
