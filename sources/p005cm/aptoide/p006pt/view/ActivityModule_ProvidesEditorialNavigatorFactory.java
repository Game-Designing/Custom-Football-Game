package p005cm.aptoide.p006pt.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.account.view.AccountNavigator;
import p005cm.aptoide.p006pt.app.AppNavigator;
import p005cm.aptoide.p006pt.editorial.EditorialNavigator;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.ActivityModule_ProvidesEditorialNavigatorFactory */
public final class ActivityModule_ProvidesEditorialNavigatorFactory implements C13181b<EditorialNavigator> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AccountNavigator> accountNavigatorProvider;
    private final Provider<AppNavigator> appNavigatorProvider;
    private final ActivityModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3354049255141521874L, "cm/aptoide/pt/view/ActivityModule_ProvidesEditorialNavigatorFactory", 8);
        $jacocoData = probes;
        return probes;
    }

    public ActivityModule_ProvidesEditorialNavigatorFactory(ActivityModule module2, Provider<AppNavigator> appNavigatorProvider2, Provider<AccountNavigator> accountNavigatorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.appNavigatorProvider = appNavigatorProvider2;
        this.accountNavigatorProvider = accountNavigatorProvider2;
        $jacocoInit[0] = true;
    }

    public EditorialNavigator get() {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule activityModule = this.module;
        Provider<AppNavigator> provider = this.appNavigatorProvider;
        $jacocoInit[1] = true;
        AppNavigator appNavigator = (AppNavigator) provider.get();
        AccountNavigator accountNavigator = (AccountNavigator) this.accountNavigatorProvider.get();
        $jacocoInit[2] = true;
        EditorialNavigator providesEditorialNavigator = activityModule.providesEditorialNavigator(appNavigator, accountNavigator);
        $jacocoInit[3] = true;
        C13182c.m43111a(providesEditorialNavigator, "Cannot return null from a non-@Nullable @Provides method");
        EditorialNavigator editorialNavigator = providesEditorialNavigator;
        $jacocoInit[4] = true;
        return editorialNavigator;
    }

    public static C13181b<EditorialNavigator> create(ActivityModule module2, Provider<AppNavigator> appNavigatorProvider2, Provider<AccountNavigator> accountNavigatorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule_ProvidesEditorialNavigatorFactory activityModule_ProvidesEditorialNavigatorFactory = new ActivityModule_ProvidesEditorialNavigatorFactory(module2, appNavigatorProvider2, accountNavigatorProvider2);
        $jacocoInit[5] = true;
        return activityModule_ProvidesEditorialNavigatorFactory;
    }

    public static EditorialNavigator proxyProvidesEditorialNavigator(ActivityModule instance, AppNavigator appNavigator, AccountNavigator accountNavigator) {
        boolean[] $jacocoInit = $jacocoInit();
        EditorialNavigator providesEditorialNavigator = instance.providesEditorialNavigator(appNavigator, accountNavigator);
        $jacocoInit[6] = true;
        return providesEditorialNavigator;
    }
}
