package p005cm.aptoide.p006pt.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.account.view.AccountNavigator;
import p005cm.aptoide.p006pt.editorialList.EditorialListNavigator;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.FragmentModule_ProvidesEditorialListNavigatorFactory */
public final class FragmentModule_ProvidesEditorialListNavigatorFactory implements C13181b<EditorialListNavigator> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AccountNavigator> accountNavigatorProvider;
    private final Provider<FragmentNavigator> fragmentNavigatorProvider;
    private final FragmentModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(5063037463400055326L, "cm/aptoide/pt/view/FragmentModule_ProvidesEditorialListNavigatorFactory", 8);
        $jacocoData = probes;
        return probes;
    }

    public FragmentModule_ProvidesEditorialListNavigatorFactory(FragmentModule module2, Provider<FragmentNavigator> fragmentNavigatorProvider2, Provider<AccountNavigator> accountNavigatorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.fragmentNavigatorProvider = fragmentNavigatorProvider2;
        this.accountNavigatorProvider = accountNavigatorProvider2;
        $jacocoInit[0] = true;
    }

    public EditorialListNavigator get() {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule fragmentModule = this.module;
        Provider<FragmentNavigator> provider = this.fragmentNavigatorProvider;
        $jacocoInit[1] = true;
        FragmentNavigator fragmentNavigator = (FragmentNavigator) provider.get();
        AccountNavigator accountNavigator = (AccountNavigator) this.accountNavigatorProvider.get();
        $jacocoInit[2] = true;
        EditorialListNavigator providesEditorialListNavigator = fragmentModule.providesEditorialListNavigator(fragmentNavigator, accountNavigator);
        $jacocoInit[3] = true;
        C13182c.m43111a(providesEditorialListNavigator, "Cannot return null from a non-@Nullable @Provides method");
        EditorialListNavigator editorialListNavigator = providesEditorialListNavigator;
        $jacocoInit[4] = true;
        return editorialListNavigator;
    }

    public static C13181b<EditorialListNavigator> create(FragmentModule module2, Provider<FragmentNavigator> fragmentNavigatorProvider2, Provider<AccountNavigator> accountNavigatorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule_ProvidesEditorialListNavigatorFactory fragmentModule_ProvidesEditorialListNavigatorFactory = new FragmentModule_ProvidesEditorialListNavigatorFactory(module2, fragmentNavigatorProvider2, accountNavigatorProvider2);
        $jacocoInit[5] = true;
        return fragmentModule_ProvidesEditorialListNavigatorFactory;
    }

    public static EditorialListNavigator proxyProvidesEditorialListNavigator(FragmentModule instance, FragmentNavigator fragmentNavigator, AccountNavigator accountNavigator) {
        boolean[] $jacocoInit = $jacocoInit();
        EditorialListNavigator providesEditorialListNavigator = instance.providesEditorialListNavigator(fragmentNavigator, accountNavigator);
        $jacocoInit[6] = true;
        return providesEditorialListNavigator;
    }
}
