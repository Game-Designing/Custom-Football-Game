package p005cm.aptoide.p006pt.home;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p026rx.Single;

/* renamed from: cm.aptoide.pt.home.BannerRepository */
public class BannerRepository {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7544218396924984703L, "cm/aptoide/pt/home/BannerRepository", 2);
        $jacocoData = probes;
        return probes;
    }

    public BannerRepository() {
        $jacocoInit()[0] = true;
    }

    public Single<HomeBundle> getBannerBundle() {
        boolean[] $jacocoInit = $jacocoInit();
        Single<HomeBundle> a = Single.m734a(new BannerBundle());
        $jacocoInit[1] = true;
        return a;
    }
}
