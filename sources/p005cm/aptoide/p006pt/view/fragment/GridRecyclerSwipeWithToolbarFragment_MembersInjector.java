package p005cm.aptoide.p006pt.view.fragment;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.C13183b;

/* renamed from: cm.aptoide.pt.view.fragment.GridRecyclerSwipeWithToolbarFragment_MembersInjector */
public final class GridRecyclerSwipeWithToolbarFragment_MembersInjector implements C13183b<GridRecyclerSwipeWithToolbarFragment> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<String> marketNameProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-1290100226664384360L, "cm/aptoide/pt/view/fragment/GridRecyclerSwipeWithToolbarFragment_MembersInjector", 5);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void injectMembers(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        injectMembers((GridRecyclerSwipeWithToolbarFragment) obj);
        $jacocoInit[4] = true;
    }

    public GridRecyclerSwipeWithToolbarFragment_MembersInjector(Provider<String> marketNameProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.marketNameProvider = marketNameProvider2;
        $jacocoInit[0] = true;
    }

    public static C13183b<GridRecyclerSwipeWithToolbarFragment> create(Provider<String> marketNameProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        GridRecyclerSwipeWithToolbarFragment_MembersInjector gridRecyclerSwipeWithToolbarFragment_MembersInjector = new GridRecyclerSwipeWithToolbarFragment_MembersInjector(marketNameProvider2);
        $jacocoInit[1] = true;
        return gridRecyclerSwipeWithToolbarFragment_MembersInjector;
    }

    public void injectMembers(GridRecyclerSwipeWithToolbarFragment instance) {
        boolean[] $jacocoInit = $jacocoInit();
        injectMarketName(instance, (String) this.marketNameProvider.get());
        $jacocoInit[2] = true;
    }

    public static void injectMarketName(GridRecyclerSwipeWithToolbarFragment instance, String marketName) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.marketName = marketName;
        $jacocoInit[3] = true;
    }
}
