package p005cm.aptoide.p006pt.downloadmanager;

import p005cm.aptoide.p006pt.database.realm.Download;

/* renamed from: cm.aptoide.pt.downloadmanager.DownloadAppMapper */
public class DownloadAppMapper {
    private DownloadAppFileMapper downloadAppFileMapper;

    public DownloadAppMapper(DownloadAppFileMapper downloadAppFileMapper2) {
        this.downloadAppFileMapper = downloadAppFileMapper2;
    }

    public DownloadApp mapDownload(Download download) {
        DownloadApp downloadApp = new DownloadApp(download.getPackageName(), download.getVersionCode(), this.downloadAppFileMapper.mapFileToDownloadList(download.getFilesToDownload()), download.getMd5(), download.getSize());
        return downloadApp;
    }
}
