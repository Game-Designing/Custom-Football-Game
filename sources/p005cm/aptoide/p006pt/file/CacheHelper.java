package p005cm.aptoide.p006pt.file;

import java.io.File;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.downloadmanager.CacheManager;
import p005cm.aptoide.p006pt.logger.Logger;
import p005cm.aptoide.p006pt.utils.AptoideUtils.StringU;
import p005cm.aptoide.p006pt.utils.FileUtils;
import p026rx.C0120S;
import p026rx.p027b.C0132p;
import p026rx.schedulers.Schedulers;

/* renamed from: cm.aptoide.pt.file.CacheHelper */
public class CacheHelper implements CacheManager {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static String TAG = CacheHelper.class.getSimpleName();
    public static final int VALUE_TO_CONVERT_MB_TO_BYTES = 1048576;
    private final FileUtils fileUtils;
    private final List<FolderToManage> foldersToCleanPath;
    private long maxCacheSize;

    /* renamed from: cm.aptoide.pt.file.CacheHelper$FolderToManage */
    public static class FolderToManage {
        private static transient /* synthetic */ boolean[] $jacocoData;
        final long cacheTime;
        final File folder;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(-3323734622730442644L, "cm/aptoide/pt/file/CacheHelper$FolderToManage", 26);
            $jacocoData = probes;
            return probes;
        }

        public FolderToManage(File folder2, long cacheTime2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.folder = folder2;
            this.cacheTime = cacheTime2;
            $jacocoInit[0] = true;
        }

        public File getFolder() {
            boolean[] $jacocoInit = $jacocoInit();
            File file = this.folder;
            $jacocoInit[1] = true;
            return file;
        }

        public long getCacheTime() {
            boolean[] $jacocoInit = $jacocoInit();
            long j = this.cacheTime;
            $jacocoInit[2] = true;
            return j;
        }

        public int hashCode() {
            int i;
            boolean[] $jacocoInit = $jacocoInit();
            $jacocoInit[3] = true;
            File folder2 = getFolder();
            $jacocoInit[4] = true;
            int i2 = 1 * 59;
            if (folder2 == null) {
                i = 43;
                $jacocoInit[5] = true;
            } else {
                i = folder2.hashCode();
                $jacocoInit[6] = true;
            }
            int result = i2 + i;
            $jacocoInit[7] = true;
            long $cacheTime = getCacheTime();
            int result2 = (result * 59) + ((int) (($cacheTime >>> 32) ^ $cacheTime));
            $jacocoInit[8] = true;
            return result2;
        }

        public boolean equals(Object o) {
            boolean[] $jacocoInit = $jacocoInit();
            if (o == this) {
                $jacocoInit[9] = true;
                return true;
            } else if (!(o instanceof FolderToManage)) {
                $jacocoInit[10] = true;
                return false;
            } else {
                FolderToManage other = (FolderToManage) o;
                $jacocoInit[11] = true;
                if (!other.canEqual(this)) {
                    $jacocoInit[12] = true;
                    return false;
                }
                File folder2 = getFolder();
                $jacocoInit[13] = true;
                Object other$folder = other.getFolder();
                $jacocoInit[14] = true;
                if (folder2 == null) {
                    if (other$folder == null) {
                        $jacocoInit[15] = true;
                    } else {
                        $jacocoInit[16] = true;
                        $jacocoInit[19] = true;
                        return false;
                    }
                } else if (folder2.equals(other$folder)) {
                    $jacocoInit[17] = true;
                } else {
                    $jacocoInit[18] = true;
                    $jacocoInit[19] = true;
                    return false;
                }
                if (getCacheTime() != other.getCacheTime()) {
                    $jacocoInit[20] = true;
                    return false;
                }
                $jacocoInit[21] = true;
                return true;
            }
        }

        public String toString() {
            boolean[] $jacocoInit = $jacocoInit();
            StringBuilder sb = new StringBuilder();
            sb.append("CacheHelper.FolderToManage(folder=");
            $jacocoInit[22] = true;
            sb.append(getFolder());
            sb.append(", cacheTime=");
            $jacocoInit[23] = true;
            sb.append(getCacheTime());
            sb.append(")");
            String sb2 = sb.toString();
            $jacocoInit[24] = true;
            return sb2;
        }

        /* access modifiers changed from: protected */
        public boolean canEqual(Object other) {
            boolean z = other instanceof FolderToManage;
            $jacocoInit()[25] = true;
            return z;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1885154018878055146L, "cm/aptoide/pt/file/CacheHelper", 67);
        $jacocoData = probes;
        return probes;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[66] = true;
    }

    public CacheHelper(long maxCacheSize2, List<FolderToManage> foldersToCleanPath2, FileUtils fileUtils2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.foldersToCleanPath = foldersToCleanPath2;
        this.maxCacheSize = 1048576 * maxCacheSize2;
        this.fileUtils = fileUtils2;
        $jacocoInit[0] = true;
    }

    public C0120S<Long> cleanCache() {
        boolean[] $jacocoInit = $jacocoInit();
        long now = System.currentTimeMillis();
        $jacocoInit[1] = true;
        C0120S c = C0120S.m652c(this.foldersToCleanPath);
        C3328a aVar = new C3328a(this);
        $jacocoInit[2] = true;
        C0120S d = c.mo3653d((C0132p<? super T, Boolean>) aVar);
        C3332e eVar = C3332e.f6716a;
        $jacocoInit[3] = true;
        C0120S h = d.mo3666h((C0132p<? super T, ? extends Iterable<? extends R>>) eVar);
        C3329b bVar = C3329b.f6712a;
        $jacocoInit[4] = true;
        C0120S d2 = h.mo3653d((C0132p<? super T, Boolean>) bVar);
        C3331d dVar = new C3331d(this, now);
        $jacocoInit[5] = true;
        C0120S j = d2.mo3669j(dVar);
        $jacocoInit[6] = true;
        C0120S m = j.mo3675m();
        C3330c cVar = C3330c.f6713a;
        $jacocoInit[7] = true;
        C0120S j2 = m.mo3669j(cVar);
        $jacocoInit[8] = true;
        C0120S<Long> b = j2.mo3634b(Schedulers.m776io());
        $jacocoInit[9] = true;
        return b;
    }

    /* renamed from: a */
    public /* synthetic */ Boolean mo2053a(List folderToManages) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(shouldClean(folderToManages, this.maxCacheSize));
        $jacocoInit[65] = true;
        return valueOf;
    }

    /* renamed from: b */
    static /* synthetic */ Iterable m307b(List folders) {
        $jacocoInit()[64] = true;
        return folders;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m306a(FolderToManage folder) {
        boolean[] $jacocoInit = $jacocoInit();
        File folder2 = folder.getFolder();
        $jacocoInit[61] = true;
        boolean exists = folder2.exists();
        $jacocoInit[62] = true;
        Boolean valueOf = Boolean.valueOf(exists);
        $jacocoInit[63] = true;
        return valueOf;
    }

    /* renamed from: a */
    public /* synthetic */ Long mo2054a(long now, FolderToManage folder) {
        boolean[] $jacocoInit = $jacocoInit();
        Long valueOf = Long.valueOf(removeOldFiles(folder.getFolder(), folder.getCacheTime(), now));
        $jacocoInit[60] = true;
        return valueOf;
    }

    /* renamed from: c */
    static /* synthetic */ Long m308c(List sizes) {
        boolean[] $jacocoInit = $jacocoInit();
        long size = 0;
        $jacocoInit[53] = true;
        int i = 0;
        $jacocoInit[54] = true;
        while (i < sizes.size()) {
            $jacocoInit[55] = true;
            size += ((Long) sizes.get(i)).longValue();
            i++;
            $jacocoInit[56] = true;
        }
        Logger instance = Logger.getInstance();
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("Cache cleaned: ");
        $jacocoInit[57] = true;
        sb.append(StringU.formatBytes(size, false));
        instance.mo2136d(str, sb.toString());
        $jacocoInit[58] = true;
        Long valueOf = Long.valueOf(size);
        $jacocoInit[59] = true;
        return valueOf;
    }

    private boolean shouldClean(List<FolderToManage> foldersToCleanPath2, long maxCacheSize2) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        long cacheSize = 0;
        $jacocoInit[10] = true;
        int i = 0;
        $jacocoInit[11] = true;
        while (i < foldersToCleanPath2.size()) {
            $jacocoInit[12] = true;
            FileUtils fileUtils2 = this.fileUtils;
            FolderToManage folderToManage = (FolderToManage) this.foldersToCleanPath.get(i);
            $jacocoInit[13] = true;
            File folder = folderToManage.getFolder();
            $jacocoInit[14] = true;
            cacheSize += fileUtils2.dirSize(folder);
            i++;
            $jacocoInit[15] = true;
        }
        if (cacheSize > maxCacheSize2) {
            $jacocoInit[16] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[17] = true;
        }
        $jacocoInit[18] = true;
        return z;
    }

    private long removeOldFiles(File folder, long timeToCache, long now) {
        boolean[] $jacocoInit = $jacocoInit();
        File[] list = folder.listFiles();
        if (list == null) {
            $jacocoInit[19] = true;
            return 0;
        }
        int length = list.length;
        $jacocoInit[20] = true;
        long deletedSize = 0;
        int i = 0;
        while (i < length) {
            File file = list[i];
            $jacocoInit[21] = true;
            if (checkIfInFoldersToClean(this.foldersToCleanPath, file)) {
                $jacocoInit[22] = true;
            } else {
                $jacocoInit[23] = true;
                if (file.isDirectory()) {
                    $jacocoInit[24] = true;
                    File file2 = file;
                    deletedSize += removeFilesFromDir(timeToCache, now, deletedSize, file);
                    $jacocoInit[25] = true;
                } else {
                    deletedSize += removeFile(timeToCache, now, file);
                    $jacocoInit[26] = true;
                }
            }
            i++;
            $jacocoInit[27] = true;
        }
        $jacocoInit[28] = true;
        return deletedSize;
    }

    private long removeFilesFromDir(long timeToCache, long now, long deletedSize, File directory) {
        boolean[] $jacocoInit = $jacocoInit();
        long dirSize = removeOldFiles(directory, timeToCache, now);
        $jacocoInit[29] = true;
        File[] dirFiles = directory.listFiles();
        $jacocoInit[30] = true;
        if (dirFiles == null) {
            $jacocoInit[31] = true;
        } else if (dirFiles.length > 0) {
            $jacocoInit[32] = true;
            $jacocoInit[36] = true;
            return deletedSize;
        } else {
            $jacocoInit[33] = true;
        }
        if (!directory.delete()) {
            $jacocoInit[34] = true;
        } else {
            deletedSize += dirSize;
            $jacocoInit[35] = true;
        }
        $jacocoInit[36] = true;
        return deletedSize;
    }

    private long removeFile(long timeToCache, long now, File file) {
        boolean[] $jacocoInit = $jacocoInit();
        long deletedSize = 0;
        $jacocoInit[37] = true;
        if (now - file.lastModified() <= timeToCache) {
            $jacocoInit[38] = true;
        } else {
            $jacocoInit[39] = true;
            long fileSize = file.length();
            $jacocoInit[40] = true;
            Logger instance = Logger.getInstance();
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("removeFile: ");
            $jacocoInit[41] = true;
            sb.append(file.getAbsolutePath());
            instance.mo2136d(str, sb.toString());
            $jacocoInit[42] = true;
            if (!file.delete()) {
                $jacocoInit[43] = true;
            } else {
                deletedSize = fileSize;
                $jacocoInit[44] = true;
            }
        }
        $jacocoInit[45] = true;
        return deletedSize;
    }

    private boolean checkIfInFoldersToClean(List<FolderToManage> foldersToCleanPath2, File folder) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[46] = true;
        for (FolderToManage folderToManage : foldersToCleanPath2) {
            $jacocoInit[47] = true;
            File folder2 = folderToManage.getFolder();
            $jacocoInit[48] = true;
            String absolutePath = folder2.getAbsolutePath();
            $jacocoInit[49] = true;
            if (absolutePath.equals(folder.getAbsolutePath())) {
                $jacocoInit[50] = true;
                return true;
            }
            $jacocoInit[51] = true;
        }
        $jacocoInit[52] = true;
        return false;
    }
}
