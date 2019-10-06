package p005cm.aptoide.p006pt.downloadmanager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p005cm.aptoide.p006pt.database.realm.FileToDownload;
import p005cm.aptoide.p006pt.downloadmanager.DownloadAppFile.FileType;
import p024io.realm.C14014U;

/* renamed from: cm.aptoide.pt.downloadmanager.DownloadAppFileMapper */
public class DownloadAppFileMapper {
    public List<DownloadAppFile> mapFileToDownloadList(C14014U<FileToDownload> filesToDownload) {
        List<DownloadAppFile> downloadAppFileList = new ArrayList<>();
        Iterator it = filesToDownload.iterator();
        while (it.hasNext()) {
            FileToDownload fileToDownload = (FileToDownload) it.next();
            DownloadAppFile downloadAppFile = new DownloadAppFile(fileToDownload.getLink(), fileToDownload.getAltLink(), fileToDownload.getMd5(), fileToDownload.getVersionCode(), fileToDownload.getPackageName(), fileToDownload.getFileName(), mapFileType(fileToDownload.getFileType()));
            downloadAppFileList.add(downloadAppFile);
        }
        return downloadAppFileList;
    }

    private FileType mapFileType(int fileType) {
        if (fileType == 0) {
            return FileType.APK;
        }
        if (fileType == 1) {
            return FileType.OBB;
        }
        if (fileType == 2) {
            return FileType.GENERIC;
        }
        throw new IllegalStateException("Invalid file type");
    }
}
