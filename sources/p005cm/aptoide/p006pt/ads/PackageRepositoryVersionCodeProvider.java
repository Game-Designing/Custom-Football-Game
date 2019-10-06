package p005cm.aptoide.p006pt.ads;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p011v2.aptwords.AdsApplicationVersionCodeProvider;
import p005cm.aptoide.p006pt.install.PackageRepository;
import p026rx.Single;

/* renamed from: cm.aptoide.pt.ads.PackageRepositoryVersionCodeProvider */
public class PackageRepositoryVersionCodeProvider implements AdsApplicationVersionCodeProvider {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final String packageName;
    private final PackageRepository packageRepository;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(2421898308081901642L, "cm/aptoide/pt/ads/PackageRepositoryVersionCodeProvider", 4);
        $jacocoData = probes;
        return probes;
    }

    public PackageRepositoryVersionCodeProvider(PackageRepository packageRepository2, String packageName2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.packageName = packageName2;
        this.packageRepository = packageRepository2;
        $jacocoInit[0] = true;
    }

    public Single<Integer> getApplicationVersionCode() {
        boolean[] $jacocoInit = $jacocoInit();
        Single packageVersionCode = this.packageRepository.getPackageVersionCode(this.packageName);
        C1644A a = C1644A.f4592a;
        $jacocoInit[1] = true;
        Single<Integer> f = packageVersionCode.mo3700f(a);
        $jacocoInit[2] = true;
        return f;
    }

    /* renamed from: a */
    static /* synthetic */ Integer m6406a(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        Integer valueOf = Integer.valueOf(-1);
        $jacocoInit[3] = true;
        return valueOf;
    }
}
