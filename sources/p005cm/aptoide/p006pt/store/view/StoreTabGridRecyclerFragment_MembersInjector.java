package p005cm.aptoide.p006pt.store.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.C13183b;

/* renamed from: cm.aptoide.pt.store.view.StoreTabGridRecyclerFragment_MembersInjector */
public final class StoreTabGridRecyclerFragment_MembersInjector implements C13183b<StoreTabGridRecyclerFragment> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<String> marketNameProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2087987115892088680L, "cm/aptoide/pt/store/view/StoreTabGridRecyclerFragment_MembersInjector", 5);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void injectMembers(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        injectMembers((StoreTabGridRecyclerFragment) obj);
        $jacocoInit[4] = true;
    }

    public StoreTabGridRecyclerFragment_MembersInjector(Provider<String> marketNameProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.marketNameProvider = marketNameProvider2;
        $jacocoInit[0] = true;
    }

    public static C13183b<StoreTabGridRecyclerFragment> create(Provider<String> marketNameProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        StoreTabGridRecyclerFragment_MembersInjector storeTabGridRecyclerFragment_MembersInjector = new StoreTabGridRecyclerFragment_MembersInjector(marketNameProvider2);
        $jacocoInit[1] = true;
        return storeTabGridRecyclerFragment_MembersInjector;
    }

    public void injectMembers(StoreTabGridRecyclerFragment instance) {
        boolean[] $jacocoInit = $jacocoInit();
        injectMarketName(instance, (String) this.marketNameProvider.get());
        $jacocoInit[2] = true;
    }

    public static void injectMarketName(StoreTabGridRecyclerFragment instance, String marketName) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.marketName = marketName;
        $jacocoInit[3] = true;
    }
}
