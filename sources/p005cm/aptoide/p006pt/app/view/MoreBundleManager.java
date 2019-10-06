package p005cm.aptoide.p006pt.app.view;

import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.home.BundlesRepository;
import p005cm.aptoide.p006pt.home.HomeBundlesModel;
import p026rx.Single;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.app.view.MoreBundleManager */
public class MoreBundleManager {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final BundlesRepository bundlesRepository;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8468949432213533269L, "cm/aptoide/pt/app/view/MoreBundleManager", 21);
        $jacocoData = probes;
        return probes;
    }

    public MoreBundleManager(BundlesRepository bundlesRepository2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.bundlesRepository = bundlesRepository2;
        $jacocoInit[0] = true;
    }

    public Single<HomeBundlesModel> loadBundle(String title, String url) {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadBundles = this.bundlesRepository.loadBundles(title, url);
        C2109ih ihVar = new C2109ih(this, title, url);
        $jacocoInit[1] = true;
        Single<HomeBundlesModel> a = loadBundles.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) ihVar);
        $jacocoInit[2] = true;
        return a;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo10804a(String title, String url, HomeBundlesModel homeBundlesModel) {
        boolean[] $jacocoInit = $jacocoInit();
        Single handleEmptyBundles = handleEmptyBundles(title, url, homeBundlesModel);
        $jacocoInit[20] = true;
        return handleEmptyBundles;
    }

    private Single<HomeBundlesModel> handleEmptyBundles(String title, String url, HomeBundlesModel homeBundlesModel) {
        boolean[] $jacocoInit = $jacocoInit();
        if (isOnlyEmptyBundles(homeBundlesModel)) {
            $jacocoInit[3] = true;
            Single<HomeBundlesModel> loadNextBundles = loadNextBundles(title, url);
            $jacocoInit[4] = true;
            return loadNextBundles;
        }
        Single<HomeBundlesModel> a = Single.m734a(homeBundlesModel);
        $jacocoInit[5] = true;
        return a;
    }

    public Single<HomeBundlesModel> loadFreshBundles(String title, String url) {
        boolean[] $jacocoInit = $jacocoInit();
        Single<HomeBundlesModel> loadFreshBundles = this.bundlesRepository.loadFreshBundles(title, url);
        $jacocoInit[6] = true;
        return loadFreshBundles;
    }

    public Single<HomeBundlesModel> loadNextBundles(String title, String url) {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadNextBundles = this.bundlesRepository.loadNextBundles(title, url);
        C2099hh hhVar = new C2099hh(this, title, url);
        $jacocoInit[7] = true;
        Single<HomeBundlesModel> a = loadNextBundles.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) hhVar);
        $jacocoInit[8] = true;
        return a;
    }

    /* renamed from: b */
    public /* synthetic */ Single mo10805b(String title, String url, HomeBundlesModel homeBundlesModel) {
        boolean[] $jacocoInit = $jacocoInit();
        Single handleEmptyBundles = handleEmptyBundles(title, url, homeBundlesModel);
        $jacocoInit[19] = true;
        return handleEmptyBundles;
    }

    public boolean hasMore(String title) {
        boolean[] $jacocoInit = $jacocoInit();
        boolean hasMore = this.bundlesRepository.hasMore(title);
        $jacocoInit[9] = true;
        return hasMore;
    }

    private boolean isOnlyEmptyBundles(HomeBundlesModel homeBundlesModel) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (homeBundlesModel.hasErrors()) {
            $jacocoInit[10] = true;
        } else {
            $jacocoInit[11] = true;
            if (homeBundlesModel.isLoading()) {
                $jacocoInit[12] = true;
            } else {
                $jacocoInit[13] = true;
                List list = homeBundlesModel.getList();
                $jacocoInit[14] = true;
                if (!list.isEmpty()) {
                    $jacocoInit[15] = true;
                } else {
                    $jacocoInit[16] = true;
                    z = true;
                    $jacocoInit[18] = true;
                    return z;
                }
            }
        }
        z = false;
        $jacocoInit[17] = true;
        $jacocoInit[18] = true;
        return z;
    }
}
