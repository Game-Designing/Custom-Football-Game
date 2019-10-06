package p024io.realm;

import p005cm.aptoide.p006pt.database.realm.FileToDownload;

/* renamed from: io.realm.g */
/* compiled from: DownloadRealmProxyInterface */
public interface C14059g {
    String realmGet$Icon();

    int realmGet$action();

    String realmGet$appName();

    int realmGet$downloadError();

    int realmGet$downloadSpeed();

    C14014U<FileToDownload> realmGet$filesToDownload();

    boolean realmGet$hasAppc();

    String realmGet$md5();

    int realmGet$overallDownloadStatus();

    int realmGet$overallProgress();

    String realmGet$packageName();

    long realmGet$size();

    long realmGet$timeStamp();

    int realmGet$versionCode();

    String realmGet$versionName();

    void realmSet$Icon(String str);

    void realmSet$action(int i);

    void realmSet$appName(String str);

    void realmSet$downloadError(int i);

    void realmSet$downloadSpeed(int i);

    void realmSet$filesToDownload(C14014U<FileToDownload> u);

    void realmSet$hasAppc(boolean z);

    void realmSet$md5(String str);

    void realmSet$overallDownloadStatus(int i);

    void realmSet$overallProgress(int i);

    void realmSet$packageName(String str);

    void realmSet$size(long j);

    void realmSet$timeStamp(long j);

    void realmSet$versionCode(int i);

    void realmSet$versionName(String str);
}
