package p005cm.aptoide.p006pt.file;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.cache.L2Cache;
import p005cm.aptoide.p006pt.downloadmanager.AptoideDownloadManager;
import p005cm.aptoide.p006pt.utils.FileUtils;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.Single;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.file.FileManager */
public class FileManager {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final String[] cacheFolders;
    private final CacheHelper cacheHelper;
    private final AptoideDownloadManager downloadManager;
    private final FileUtils fileUtils;
    private final L2Cache httpClientCache;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5296975682567805562L, "cm/aptoide/pt/file/FileManager", 14);
        $jacocoData = probes;
        return probes;
    }

    public FileManager(CacheHelper cacheHelper2, FileUtils fileUtils2, String[] cacheFolders2, AptoideDownloadManager downloadManager2, L2Cache httpClientCache2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.cacheHelper = cacheHelper2;
        this.fileUtils = fileUtils2;
        this.cacheFolders = cacheFolders2;
        this.downloadManager = downloadManager2;
        this.httpClientCache = httpClientCache2;
        $jacocoInit[0] = true;
    }

    public Single<Long> purgeCache() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S cleanCache = this.cacheHelper.cleanCache();
        $jacocoInit[1] = true;
        Single n = cleanCache.mo3678n();
        C3334g gVar = new C3334g(this);
        $jacocoInit[2] = true;
        Single<Long> a = n.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) gVar);
        $jacocoInit[3] = true;
        return a;
    }

    /* renamed from: c */
    public /* synthetic */ Single mo2063c(Long cleaned) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M invalidateDatabase = this.downloadManager.invalidateDatabase();
        $jacocoInit[12] = true;
        Single a = invalidateDatabase.mo3587a(Single.m734a(cleaned));
        $jacocoInit[13] = true;
        return a;
    }

    public C0120S<Long> deleteCache() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S deleteFolder = this.fileUtils.deleteFolder(this.cacheFolders);
        C3333f fVar = new C3333f(this);
        $jacocoInit[4] = true;
        C0120S f = deleteFolder.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) fVar);
        C3335h hVar = new C3335h(this);
        $jacocoInit[5] = true;
        C0120S<Long> b = f.mo3636b((C0129b<? super T>) hVar);
        $jacocoInit[6] = true;
        return b;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo2061a(Long deletedSize) {
        boolean[] $jacocoInit = $jacocoInit();
        if (deletedSize.longValue() > 0) {
            $jacocoInit[8] = true;
            C0117M invalidateDatabase = this.downloadManager.invalidateDatabase();
            $jacocoInit[9] = true;
            C0120S a = invalidateDatabase.mo3586a(C0120S.m652c(deletedSize));
            $jacocoInit[10] = true;
            return a;
        }
        C0120S c = C0120S.m652c(deletedSize);
        $jacocoInit[11] = true;
        return c;
    }

    /* renamed from: b */
    public /* synthetic */ void mo2062b(Long aVoid) {
        boolean[] $jacocoInit = $jacocoInit();
        this.httpClientCache.clean();
        $jacocoInit[7] = true;
    }
}
