package p005cm.aptoide.p006pt.store.view.p079my;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.p006pt.store.view.StoreTabGridRecyclerFragment_MembersInjector;
import p005cm.aptoide.p006pt.store.view.StoreTabWidgetsGridRecyclerFragment_MembersInjector;
import p318e.C13183b;

/* renamed from: cm.aptoide.pt.store.view.my.MyStoresFragment_MembersInjector */
public final class MyStoresFragment_MembersInjector implements C13183b<MyStoresFragment> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AnalyticsManager> analyticsManagerProvider;
    private final Provider<String> marketNameProvider;
    private final Provider<MyStoresPresenter> myStoresPresenterProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-280591259349704081L, "cm/aptoide/pt/store/view/my/MyStoresFragment_MembersInjector", 12);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void injectMembers(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        injectMembers((MyStoresFragment) obj);
        $jacocoInit[11] = true;
    }

    public MyStoresFragment_MembersInjector(Provider<String> marketNameProvider2, Provider<AnalyticsManager> analyticsManagerProvider2, Provider<MyStoresPresenter> myStoresPresenterProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.marketNameProvider = marketNameProvider2;
        this.analyticsManagerProvider = analyticsManagerProvider2;
        this.myStoresPresenterProvider = myStoresPresenterProvider2;
        $jacocoInit[0] = true;
    }

    public static C13183b<MyStoresFragment> create(Provider<String> marketNameProvider2, Provider<AnalyticsManager> analyticsManagerProvider2, Provider<MyStoresPresenter> myStoresPresenterProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        MyStoresFragment_MembersInjector myStoresFragment_MembersInjector = new MyStoresFragment_MembersInjector(marketNameProvider2, analyticsManagerProvider2, myStoresPresenterProvider2);
        $jacocoInit[1] = true;
        return myStoresFragment_MembersInjector;
    }

    public void injectMembers(MyStoresFragment instance) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<String> provider = this.marketNameProvider;
        $jacocoInit[2] = true;
        String str = (String) provider.get();
        $jacocoInit[3] = true;
        StoreTabGridRecyclerFragment_MembersInjector.injectMarketName(instance, str);
        Provider<AnalyticsManager> provider2 = this.analyticsManagerProvider;
        $jacocoInit[4] = true;
        AnalyticsManager analyticsManager = (AnalyticsManager) provider2.get();
        $jacocoInit[5] = true;
        StoreTabWidgetsGridRecyclerFragment_MembersInjector.injectAnalyticsManager(instance, analyticsManager);
        Provider<String> provider3 = this.marketNameProvider;
        $jacocoInit[6] = true;
        String str2 = (String) provider3.get();
        $jacocoInit[7] = true;
        StoreTabWidgetsGridRecyclerFragment_MembersInjector.injectMarketName(instance, str2);
        $jacocoInit[8] = true;
        injectMyStoresPresenter(instance, (MyStoresPresenter) this.myStoresPresenterProvider.get());
        $jacocoInit[9] = true;
    }

    public static void injectMyStoresPresenter(MyStoresFragment instance, MyStoresPresenter myStoresPresenter) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.myStoresPresenter = myStoresPresenter;
        $jacocoInit[10] = true;
    }
}
