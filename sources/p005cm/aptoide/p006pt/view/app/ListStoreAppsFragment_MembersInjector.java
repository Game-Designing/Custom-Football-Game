package p005cm.aptoide.p006pt.view.app;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.C13183b;

/* renamed from: cm.aptoide.pt.view.app.ListStoreAppsFragment_MembersInjector */
public final class ListStoreAppsFragment_MembersInjector implements C13183b<ListStoreAppsFragment> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AppCenter> appCenterProvider;
    private final Provider<ListStoreAppsNavigator> listStoreAppsNavigatorProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2012718480386290964L, "cm/aptoide/pt/view/app/ListStoreAppsFragment_MembersInjector", 7);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void injectMembers(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        injectMembers((ListStoreAppsFragment) obj);
        $jacocoInit[6] = true;
    }

    public ListStoreAppsFragment_MembersInjector(Provider<ListStoreAppsNavigator> listStoreAppsNavigatorProvider2, Provider<AppCenter> appCenterProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.listStoreAppsNavigatorProvider = listStoreAppsNavigatorProvider2;
        this.appCenterProvider = appCenterProvider2;
        $jacocoInit[0] = true;
    }

    public static C13183b<ListStoreAppsFragment> create(Provider<ListStoreAppsNavigator> listStoreAppsNavigatorProvider2, Provider<AppCenter> appCenterProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ListStoreAppsFragment_MembersInjector listStoreAppsFragment_MembersInjector = new ListStoreAppsFragment_MembersInjector(listStoreAppsNavigatorProvider2, appCenterProvider2);
        $jacocoInit[1] = true;
        return listStoreAppsFragment_MembersInjector;
    }

    public void injectMembers(ListStoreAppsFragment instance) {
        boolean[] $jacocoInit = $jacocoInit();
        injectListStoreAppsNavigator(instance, (ListStoreAppsNavigator) this.listStoreAppsNavigatorProvider.get());
        $jacocoInit[2] = true;
        injectAppCenter(instance, (AppCenter) this.appCenterProvider.get());
        $jacocoInit[3] = true;
    }

    public static void injectListStoreAppsNavigator(ListStoreAppsFragment instance, ListStoreAppsNavigator listStoreAppsNavigator) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.listStoreAppsNavigator = listStoreAppsNavigator;
        $jacocoInit[4] = true;
    }

    public static void injectAppCenter(ListStoreAppsFragment instance, AppCenter appCenter) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.appCenter = appCenter;
        $jacocoInit[5] = true;
    }
}
