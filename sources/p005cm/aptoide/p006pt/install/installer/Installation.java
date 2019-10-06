package p005cm.aptoide.p006pt.install.installer;

import java.io.File;
import java.util.List;
import p005cm.aptoide.p006pt.database.realm.FileToDownload;

/* renamed from: cm.aptoide.pt.install.installer.Installation */
public interface Installation {
    File getFile();

    List<FileToDownload> getFiles();

    String getId();

    String getPackageName();

    int getStatus();

    int getType();

    int getVersionCode();

    String getVersionName();

    void save();

    void saveFileChanges();

    void setStatus(int i);

    void setType(int i);
}
