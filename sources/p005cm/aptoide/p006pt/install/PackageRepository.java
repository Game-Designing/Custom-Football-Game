package p005cm.aptoide.p006pt.install;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p026rx.C0120S;
import p026rx.Single;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;
import p026rx.p027b.C14541q;
import p026rx.p401g.C14959b;
import p026rx.schedulers.Schedulers;

/* renamed from: cm.aptoide.pt.install.PackageRepository */
public class PackageRepository {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private List<PackageInfo> memoryCache;
    private final PackageManager packageManager;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8680024905202473944L, "cm/aptoide/pt/install/PackageRepository", 81);
        $jacocoData = probes;
        return probes;
    }

    public PackageRepository(PackageManager packageManager2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.packageManager = packageManager2;
        $jacocoInit[0] = true;
    }

    /* renamed from: b */
    static /* synthetic */ Iterable m367b(List items) {
        $jacocoInit()[80] = true;
        return items;
    }

    public C0120S<String> getLatestInstalledPackages(int count) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S h = getInstalledPackages().mo3666h((C0132p<? super T, ? extends Iterable<? extends R>>) C4025Za.f7524a);
        C4019Wa wa = C4019Wa.f7517a;
        $jacocoInit[1] = true;
        C0120S a = h.mo3625a((C14541q<? super T, ? super T, Integer>) wa);
        C4013Ta ta = C4013Ta.f7507a;
        $jacocoInit[2] = true;
        C0120S h2 = a.mo3666h((C0132p<? super T, ? extends Iterable<? extends R>>) ta);
        $jacocoInit[3] = true;
        C0120S b = h2.mo3629b(count);
        C4035cb cbVar = C4035cb.f7537a;
        $jacocoInit[4] = true;
        C0120S j = b.mo3669j(cbVar);
        $jacocoInit[5] = true;
        C0120S<String> b2 = j.mo3634b(Schedulers.m776io());
        $jacocoInit[6] = true;
        return b2;
    }

    /* renamed from: a */
    static /* synthetic */ Integer m365a(PackageInfo packageInfo, PackageInfo packageInfo2) {
        int i;
        boolean[] $jacocoInit = $jacocoInit();
        long j = packageInfo.lastUpdateTime;
        long j2 = packageInfo2.lastUpdateTime;
        if (j < j2) {
            $jacocoInit[76] = true;
            i = 1;
        } else if (j == j2) {
            i = 0;
            $jacocoInit[77] = true;
        } else {
            i = -1;
            $jacocoInit[78] = true;
        }
        Integer valueOf = Integer.valueOf(i);
        $jacocoInit[79] = true;
        return valueOf;
    }

    /* renamed from: c */
    static /* synthetic */ Iterable m369c(List packageInfos) {
        $jacocoInit()[75] = true;
        return packageInfos;
    }

    /* renamed from: a */
    static /* synthetic */ String m366a(PackageInfo packageInfo) {
        boolean[] $jacocoInit = $jacocoInit();
        String str = packageInfo.packageName;
        $jacocoInit[74] = true;
        return str;
    }

    private C0120S<List<PackageInfo>> getInstalledPackages() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S e = getCachedInstalledPackages().mo3657e(getPackageManagerInstalledPackages());
        $jacocoInit[7] = true;
        C0120S e2 = e.mo3657e(getAdbInstalledPackages().mo3634b(Schedulers.m776io()));
        C4011Sa sa = new C4011Sa(this);
        $jacocoInit[8] = true;
        C0120S<List<PackageInfo>> b = e2.mo3636b((C0129b<? super T>) sa);
        $jacocoInit[9] = true;
        return b;
    }

    /* renamed from: a */
    public /* synthetic */ void mo2116a(List packageInfos) {
        boolean[] $jacocoInit = $jacocoInit();
        setCachedInstalledPackages(packageInfos);
        $jacocoInit[73] = true;
    }

    private C0120S<List<PackageInfo>> getCachedInstalledPackages() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<List<PackageInfo>> a = C0120S.m633a((Callable<? extends T>) new C4015Ua<Object>(this));
        $jacocoInit[10] = true;
        return a;
    }

    /* renamed from: b */
    public /* synthetic */ List mo2117b() throws Exception {
        boolean[] $jacocoInit = $jacocoInit();
        List<PackageInfo> list = this.memoryCache;
        if (list != null) {
            $jacocoInit[71] = true;
            return list;
        }
        IllegalStateException illegalStateException = new IllegalStateException("No cached packages available!");
        $jacocoInit[72] = true;
        throw illegalStateException;
    }

    private void setCachedInstalledPackages(List<PackageInfo> packageInfos) {
        boolean[] $jacocoInit = $jacocoInit();
        this.memoryCache = packageInfos;
        $jacocoInit[11] = true;
    }

    private C0120S<List<PackageInfo>> getPackageManagerInstalledPackages() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<List<PackageInfo>> a = C0120S.m633a((Callable<? extends T>) new C4023Ya<Object>(this));
        $jacocoInit[12] = true;
        return a;
    }

    /* renamed from: c */
    public /* synthetic */ List mo2119c() throws Exception {
        boolean[] $jacocoInit = $jacocoInit();
        List installedPackages = this.packageManager.getInstalledPackages(0);
        $jacocoInit[70] = true;
        return installedPackages;
    }

    private C0120S<List<PackageInfo>> getAdbInstalledPackages() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<List<PackageInfo>> a = C0120S.m633a((Callable<? extends T>) new C4009Ra<Object>(this));
        $jacocoInit[13] = true;
        return a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a7  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ java.util.List mo2113a() throws java.lang.Exception {
        /*
            r10 = this;
            boolean[] r0 = $jacocoInit()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r2 = 50
            r3 = 1
            r4 = 0
            r0[r2] = r3     // Catch:{ NameNotFoundException -> 0x008e, InterruptedException -> 0x008c, IOException -> 0x008a, all -> 0x0085 }
            r2 = r4
            java.lang.Runtime r4 = java.lang.Runtime.getRuntime()     // Catch:{ NameNotFoundException -> 0x0083, InterruptedException -> 0x0081, IOException -> 0x007f }
            java.lang.String r5 = "pm list packages"
            r6 = 51
            r0[r6] = r3     // Catch:{ NameNotFoundException -> 0x0083, InterruptedException -> 0x0081, IOException -> 0x007f }
            java.lang.Process r4 = r4.exec(r5)     // Catch:{ NameNotFoundException -> 0x0083, InterruptedException -> 0x0081, IOException -> 0x007f }
            r5 = 52
            r0[r5] = r3     // Catch:{ NameNotFoundException -> 0x0083, InterruptedException -> 0x0081, IOException -> 0x007f }
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch:{ NameNotFoundException -> 0x0083, InterruptedException -> 0x0081, IOException -> 0x007f }
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch:{ NameNotFoundException -> 0x0083, InterruptedException -> 0x0081, IOException -> 0x007f }
            java.io.InputStream r7 = r4.getInputStream()     // Catch:{ NameNotFoundException -> 0x0083, InterruptedException -> 0x0081, IOException -> 0x007f }
            r6.<init>(r7)     // Catch:{ NameNotFoundException -> 0x0083, InterruptedException -> 0x0081, IOException -> 0x007f }
            r5.<init>(r6)     // Catch:{ NameNotFoundException -> 0x0083, InterruptedException -> 0x0081, IOException -> 0x007f }
            r2 = r5
            r5 = 53
            r0[r5] = r3     // Catch:{ NameNotFoundException -> 0x0083, InterruptedException -> 0x0081, IOException -> 0x007f }
        L_0x0035:
            java.lang.String r5 = r2.readLine()     // Catch:{ NameNotFoundException -> 0x0083, InterruptedException -> 0x0081, IOException -> 0x007f }
            r6 = r5
            if (r5 == 0) goto L_0x0063
            r5 = 54
            r0[r5] = r3     // Catch:{ NameNotFoundException -> 0x0083, InterruptedException -> 0x0081, IOException -> 0x007f }
            r5 = 58
            int r5 = r6.indexOf(r5)     // Catch:{ NameNotFoundException -> 0x0083, InterruptedException -> 0x0081, IOException -> 0x007f }
            int r5 = r5 + r3
            java.lang.String r5 = r6.substring(r5)     // Catch:{ NameNotFoundException -> 0x0083, InterruptedException -> 0x0081, IOException -> 0x007f }
            r7 = 55
            r0[r7] = r3     // Catch:{ NameNotFoundException -> 0x0083, InterruptedException -> 0x0081, IOException -> 0x007f }
            android.content.pm.PackageManager r7 = r10.packageManager     // Catch:{ NameNotFoundException -> 0x0083, InterruptedException -> 0x0081, IOException -> 0x007f }
            r8 = 0
            android.content.pm.PackageInfo r7 = r7.getPackageInfo(r5, r8)     // Catch:{ NameNotFoundException -> 0x0083, InterruptedException -> 0x0081, IOException -> 0x007f }
            r8 = 56
            r0[r8] = r3     // Catch:{ NameNotFoundException -> 0x0083, InterruptedException -> 0x0081, IOException -> 0x007f }
            r1.add(r7)     // Catch:{ NameNotFoundException -> 0x0083, InterruptedException -> 0x0081, IOException -> 0x007f }
            r5 = 57
            r0[r5] = r3     // Catch:{ NameNotFoundException -> 0x0083, InterruptedException -> 0x0081, IOException -> 0x007f }
            goto L_0x0035
        L_0x0063:
            r4.waitFor()     // Catch:{ NameNotFoundException -> 0x0083, InterruptedException -> 0x0081, IOException -> 0x007f }
            r4 = 59
            r0[r4] = r3     // Catch:{ IOException -> 0x0073 }
            r2.close()     // Catch:{ IOException -> 0x0073 }
            r4 = 60
            r0[r4] = r3
            goto L_0x0078
        L_0x0073:
            r4 = move-exception
            r4 = 61
            r0[r4] = r3
        L_0x0078:
            r4 = 69
            r0[r4] = r3
            return r1
        L_0x007d:
            r4 = move-exception
            goto L_0x00a0
        L_0x007f:
            r4 = move-exception
            goto L_0x0092
        L_0x0081:
            r4 = move-exception
            goto L_0x0092
        L_0x0083:
            r4 = move-exception
            goto L_0x0092
        L_0x0085:
            r2 = move-exception
            r9 = r4
            r4 = r2
            r2 = r9
            goto L_0x00a0
        L_0x008a:
            r2 = move-exception
            goto L_0x008f
        L_0x008c:
            r2 = move-exception
            goto L_0x008f
        L_0x008e:
            r2 = move-exception
        L_0x008f:
            r9 = r4
            r4 = r2
            r2 = r9
        L_0x0092:
            r5 = 62
            r0[r5] = r3     // Catch:{ all -> 0x007d }
            java.lang.RuntimeException r5 = new java.lang.RuntimeException     // Catch:{ all -> 0x007d }
            r5.<init>(r4)     // Catch:{ all -> 0x007d }
            r6 = 63
            r0[r6] = r3     // Catch:{ all -> 0x007d }
            throw r5     // Catch:{ all -> 0x007d }
        L_0x00a0:
            if (r2 != 0) goto L_0x00a7
            r5 = 64
            r0[r5] = r3
            goto L_0x00b8
        L_0x00a7:
            r5 = 65
            r0[r5] = r3     // Catch:{ IOException -> 0x00b3 }
            r2.close()     // Catch:{ IOException -> 0x00b3 }
            r5 = 66
            r0[r5] = r3
            goto L_0x00b8
        L_0x00b3:
            r5 = move-exception
            r5 = 67
            r0[r5] = r3
        L_0x00b8:
            r5 = 68
            r0[r5] = r3
            goto L_0x00be
        L_0x00bd:
            throw r4
        L_0x00be:
            goto L_0x00bd
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.install.PackageRepository.mo2113a():java.util.List");
    }

    public Single<Integer> getPackageVersionCode(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        Single<Integer> a = Single.m736a((Callable<Single<T>>) new C4008Qa<Single<T>>(this, packageName));
        $jacocoInit[14] = true;
        return a;
    }

    /* renamed from: b */
    public /* synthetic */ Single mo2118b(String packageName) throws Exception {
        boolean[] $jacocoInit = $jacocoInit();
        try {
            PackageInfo packageInfo = this.packageManager.getPackageInfo(packageName, 0);
            $jacocoInit[46] = true;
            Single a = Single.m734a(Integer.valueOf(packageInfo.versionCode));
            $jacocoInit[47] = true;
            return a;
        } catch (Exception e) {
            $jacocoInit[48] = true;
            Single a2 = Single.m735a((Throwable) e);
            $jacocoInit[49] = true;
            return a2;
        }
    }

    public Single<String> getPackageLabel(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        Single<String> a = Single.m736a((Callable<Single<T>>) new C4021Xa<Single<T>>(this, packageName));
        $jacocoInit[15] = true;
        return a;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo2114a(String packageName) throws Exception {
        boolean[] $jacocoInit = $jacocoInit();
        try {
            ApplicationInfo packageInfo = this.packageManager.getApplicationInfo(packageName, 0);
            $jacocoInit[40] = true;
            CharSequence applicationLabel = this.packageManager.getApplicationLabel(packageInfo);
            $jacocoInit[41] = true;
            String charSequence = applicationLabel.toString();
            $jacocoInit[42] = true;
            Single a = Single.m734a(charSequence);
            $jacocoInit[43] = true;
            return a;
        } catch (Exception e) {
            $jacocoInit[44] = true;
            Single a2 = Single.m735a((Throwable) e);
            $jacocoInit[45] = true;
            return a2;
        }
    }

    public boolean isAppInstalled(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        Single n = getInstalledPackages().mo3678n();
        C4038db dbVar = new C4038db(this, packageName);
        $jacocoInit[16] = true;
        Single a = n.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) dbVar);
        C4032bb bbVar = C4032bb.f7531a;
        $jacocoInit[17] = true;
        Single f = a.mo3700f(bbVar);
        $jacocoInit[18] = true;
        C14959b a2 = f.mo3689a();
        $jacocoInit[19] = true;
        boolean booleanValue = ((Boolean) a2.mo46175a()).booleanValue();
        $jacocoInit[20] = true;
        return booleanValue;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo2115a(String packageName, List packageInfos) {
        boolean[] $jacocoInit = $jacocoInit();
        Single isPackageInstalled = isPackageInstalled(packageName);
        $jacocoInit[39] = true;
        return isPackageInstalled;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m364a(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(false);
        $jacocoInit[38] = true;
        return valueOf;
    }

    private Single<Boolean> isPackageInstalled(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        Single<Boolean> a = Single.m736a((Callable<Single<T>>) new C4017Va<Single<T>>(this, packageName));
        $jacocoInit[21] = true;
        return a;
    }

    /* renamed from: c */
    public /* synthetic */ Single mo2120c(String packageName) throws Exception {
        boolean[] $jacocoInit = $jacocoInit();
        try {
            boolean z = false;
            PackageInfo packageInfo = this.packageManager.getPackageInfo(packageName, 0);
            $jacocoInit[30] = true;
            if (packageInfo != null) {
                $jacocoInit[31] = true;
                z = true;
            } else {
                $jacocoInit[32] = true;
            }
            Single a = Single.m734a(Boolean.valueOf(z));
            $jacocoInit[33] = true;
            return a;
        } catch (NameNotFoundException e) {
            $jacocoInit[34] = true;
            Single a2 = Single.m734a(Boolean.FALSE);
            $jacocoInit[35] = true;
            return a2;
        } catch (Exception e2) {
            $jacocoInit[36] = true;
            Single a3 = Single.m735a((Throwable) e2);
            $jacocoInit[37] = true;
            return a3;
        }
    }

    public C0120S<String> getRandomInstalledPackages(int count) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S j = getInstalledPackages().mo3669j(C4041eb.f7546a);
        C4029ab abVar = C4029ab.f7528a;
        $jacocoInit[22] = true;
        C0120S h = j.mo3666h((C0132p<? super T, ? extends Iterable<? extends R>>) abVar);
        $jacocoInit[23] = true;
        C0120S b = h.mo3629b(count);
        C4026_a _aVar = C4026_a.f7525a;
        $jacocoInit[24] = true;
        C0120S j2 = b.mo3669j(_aVar);
        $jacocoInit[25] = true;
        C0120S<String> b2 = j2.mo3634b(Schedulers.m776io());
        $jacocoInit[26] = true;
        return b2;
    }

    /* renamed from: d */
    static /* synthetic */ List m370d(List packageInfos) {
        boolean[] $jacocoInit = $jacocoInit();
        Collections.shuffle(packageInfos);
        $jacocoInit[29] = true;
        return packageInfos;
    }

    /* renamed from: e */
    static /* synthetic */ Iterable m371e(List packageInfos) {
        $jacocoInit()[28] = true;
        return packageInfos;
    }

    /* renamed from: b */
    static /* synthetic */ String m368b(PackageInfo packageInfo) {
        boolean[] $jacocoInit = $jacocoInit();
        String str = packageInfo.packageName;
        $jacocoInit[27] = true;
        return str;
    }
}
