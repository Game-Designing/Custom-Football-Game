package p005cm.aptoide.p006pt.download;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.ads.MinimalAdMapper;
import p005cm.aptoide.p006pt.database.accessors.DownloadAccessor;
import p005cm.aptoide.p006pt.database.accessors.StoredMinimalAdAccessor;
import p005cm.aptoide.p006pt.database.realm.Download;
import p005cm.aptoide.p006pt.database.realm.Installed;
import p005cm.aptoide.p006pt.database.realm.StoredMinimalAd;
import p005cm.aptoide.p006pt.dataprovider.ads.AdNetworkUtils;
import p005cm.aptoide.p006pt.downloadmanager.AptoideDownloadManager;
import p005cm.aptoide.p006pt.install.InstalledRepository;
import p005cm.aptoide.p006pt.install.exception.InstallationException;
import p005cm.aptoide.p006pt.install.installer.DownloadInstallationAdapter;
import p005cm.aptoide.p006pt.install.installer.Installation;
import p005cm.aptoide.p006pt.install.installer.InstallationProvider;
import p005cm.aptoide.p006pt.logger.Logger;
import p026rx.C0120S;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;
import p026rx.schedulers.Schedulers;

/* renamed from: cm.aptoide.pt.download.DownloadInstallationProvider */
public class DownloadInstallationProvider implements InstallationProvider {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final String TAG = "DownloadInstallationPro";
    private final MinimalAdMapper adMapper;
    private final DownloadAccessor downloadAccessor;
    private final AptoideDownloadManager downloadManager;
    private final InstalledRepository installedRepository;
    private final StoredMinimalAdAccessor storedMinimalAdAccessor;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(2474345625477221278L, "cm/aptoide/pt/download/DownloadInstallationProvider", 35);
        $jacocoData = probes;
        return probes;
    }

    public DownloadInstallationProvider(AptoideDownloadManager downloadManager2, DownloadAccessor downloadAccessor2, InstalledRepository installedRepository2, MinimalAdMapper adMapper2, StoredMinimalAdAccessor storeMinimalAdAccessor) {
        boolean[] $jacocoInit = $jacocoInit();
        this.downloadManager = downloadManager2;
        this.downloadAccessor = downloadAccessor2;
        this.adMapper = adMapper2;
        this.storedMinimalAdAccessor = storeMinimalAdAccessor;
        this.installedRepository = installedRepository2;
        $jacocoInit[0] = true;
    }

    public C0120S<Installation> getInstallation(String md5) {
        boolean[] $jacocoInit = $jacocoInit();
        Logger instance = Logger.getInstance();
        StringBuilder sb = new StringBuilder();
        sb.append("Getting the installation ");
        sb.append(md5);
        String sb2 = sb.toString();
        $jacocoInit[1] = true;
        instance.mo2136d(TAG, sb2);
        $jacocoInit[2] = true;
        C0120S download = this.downloadManager.getDownload(md5);
        $jacocoInit[3] = true;
        C0120S d = download.mo3647d();
        C2934e eVar = new C2934e(this);
        $jacocoInit[4] = true;
        C0120S<Installation> f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) eVar);
        $jacocoInit[5] = true;
        return f;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo13584a(Download download) {
        boolean[] $jacocoInit = $jacocoInit();
        if (download.getOverallDownloadStatus() == 1) {
            $jacocoInit[21] = true;
            C0120S s = this.installedRepository.get(download.getPackageName(), download.getVersionCode());
            C2932c cVar = new C2932c(this, download);
            $jacocoInit[22] = true;
            C0120S j = s.mo3669j(cVar);
            C2931b bVar = new C2931b(this);
            $jacocoInit[23] = true;
            C0120S b = j.mo3636b((C0129b<? super T>) bVar);
            $jacocoInit[24] = true;
            return b;
        }
        C0120S a = C0120S.m631a((Throwable) new InstallationException("Installation file not available."));
        $jacocoInit[25] = true;
        return a;
    }

    /* renamed from: a */
    public /* synthetic */ DownloadInstallationAdapter mo13583a(Download download, Installed installed) {
        boolean[] $jacocoInit = $jacocoInit();
        if (installed != null) {
            $jacocoInit[31] = true;
        } else {
            $jacocoInit[32] = true;
            installed = convertDownloadToInstalled(download);
            $jacocoInit[33] = true;
        }
        DownloadInstallationAdapter downloadInstallationAdapter = new DownloadInstallationAdapter(download, this.downloadAccessor, this.installedRepository, installed);
        $jacocoInit[34] = true;
        return downloadInstallationAdapter;
    }

    /* renamed from: a */
    public /* synthetic */ void mo13586a(DownloadInstallationAdapter downloadInstallationAdapter) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S s = this.storedMinimalAdAccessor.get(downloadInstallationAdapter.getPackageName());
        $jacocoInit[26] = true;
        C0120S b = s.mo3636b(handleCpd());
        $jacocoInit[27] = true;
        C0120S b2 = b.mo3634b(Schedulers.m776io());
        C2930a aVar = C2930a.f6209a;
        C2938i iVar = C2938i.f6218a;
        $jacocoInit[28] = true;
        b2.mo3626a((C0129b<? super T>) aVar, (C0129b<Throwable>) iVar);
        $jacocoInit[29] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m7596b(StoredMinimalAd storedMinimalAd) {
        $jacocoInit()[30] = true;
    }

    private Installed convertDownloadToInstalled(Download download) {
        boolean[] $jacocoInit = $jacocoInit();
        Installed installed = new Installed();
        $jacocoInit[6] = true;
        StringBuilder sb = new StringBuilder();
        sb.append(download.getPackageName());
        sb.append(download.getVersionCode());
        installed.setPackageAndVersionCode(sb.toString());
        $jacocoInit[7] = true;
        installed.setVersionCode(download.getVersionCode());
        $jacocoInit[8] = true;
        installed.setVersionName(download.getVersionName());
        $jacocoInit[9] = true;
        installed.setStatus(1);
        $jacocoInit[10] = true;
        installed.setType(-1);
        $jacocoInit[11] = true;
        installed.setPackageName(download.getPackageName());
        $jacocoInit[12] = true;
        return installed;
    }

    private C0129b<StoredMinimalAd> handleCpd() {
        boolean[] $jacocoInit = $jacocoInit();
        C2933d dVar = new C2933d(this);
        $jacocoInit[13] = true;
        return dVar;
    }

    /* renamed from: a */
    public /* synthetic */ void mo13585a(StoredMinimalAd storedMinimalAd) {
        boolean[] $jacocoInit = $jacocoInit();
        if (storedMinimalAd == null) {
            $jacocoInit[14] = true;
        } else if (storedMinimalAd.getCpdUrl() == null) {
            $jacocoInit[15] = true;
        } else {
            $jacocoInit[16] = true;
            AdNetworkUtils.knockCpd(this.adMapper.map(storedMinimalAd));
            $jacocoInit[17] = true;
            storedMinimalAd.setCpdUrl(null);
            $jacocoInit[18] = true;
            this.storedMinimalAdAccessor.insert(storedMinimalAd);
            $jacocoInit[19] = true;
        }
        $jacocoInit[20] = true;
    }
}
