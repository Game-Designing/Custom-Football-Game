package p005cm.aptoide.p006pt.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.p006pt.store.view.p079my.MyStoresNavigator;
import p005cm.aptoide.p006pt.store.view.p079my.MyStoresPresenter;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.FragmentModule_ProvidesMyStorePresenterFactory */
public final class FragmentModule_ProvidesMyStorePresenterFactory implements C13181b<MyStoresPresenter> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AptoideAccountManager> aptoideAccountManagerProvider;
    private final FragmentModule module;
    private final Provider<MyStoresNavigator> navigatorProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1482206065619232470L, "cm/aptoide/pt/view/FragmentModule_ProvidesMyStorePresenterFactory", 8);
        $jacocoData = probes;
        return probes;
    }

    public FragmentModule_ProvidesMyStorePresenterFactory(FragmentModule module2, Provider<AptoideAccountManager> aptoideAccountManagerProvider2, Provider<MyStoresNavigator> navigatorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.aptoideAccountManagerProvider = aptoideAccountManagerProvider2;
        this.navigatorProvider = navigatorProvider2;
        $jacocoInit[0] = true;
    }

    public MyStoresPresenter get() {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule fragmentModule = this.module;
        Provider<AptoideAccountManager> provider = this.aptoideAccountManagerProvider;
        $jacocoInit[1] = true;
        AptoideAccountManager aptoideAccountManager = (AptoideAccountManager) provider.get();
        MyStoresNavigator myStoresNavigator = (MyStoresNavigator) this.navigatorProvider.get();
        $jacocoInit[2] = true;
        MyStoresPresenter providesMyStorePresenter = fragmentModule.providesMyStorePresenter(aptoideAccountManager, myStoresNavigator);
        $jacocoInit[3] = true;
        C13182c.m43111a(providesMyStorePresenter, "Cannot return null from a non-@Nullable @Provides method");
        MyStoresPresenter myStoresPresenter = providesMyStorePresenter;
        $jacocoInit[4] = true;
        return myStoresPresenter;
    }

    public static C13181b<MyStoresPresenter> create(FragmentModule module2, Provider<AptoideAccountManager> aptoideAccountManagerProvider2, Provider<MyStoresNavigator> navigatorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule_ProvidesMyStorePresenterFactory fragmentModule_ProvidesMyStorePresenterFactory = new FragmentModule_ProvidesMyStorePresenterFactory(module2, aptoideAccountManagerProvider2, navigatorProvider2);
        $jacocoInit[5] = true;
        return fragmentModule_ProvidesMyStorePresenterFactory;
    }

    public static MyStoresPresenter proxyProvidesMyStorePresenter(FragmentModule instance, AptoideAccountManager aptoideAccountManager, MyStoresNavigator navigator) {
        boolean[] $jacocoInit = $jacocoInit();
        MyStoresPresenter providesMyStorePresenter = instance.providesMyStorePresenter(aptoideAccountManager, navigator);
        $jacocoInit[6] = true;
        return providesMyStorePresenter;
    }
}
