package p005cm.aptoide.p006pt.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.p006pt.editorialList.EditorialListAnalytics;
import p005cm.aptoide.p006pt.editorialList.EditorialListManager;
import p005cm.aptoide.p006pt.editorialList.EditorialListNavigator;
import p005cm.aptoide.p006pt.editorialList.EditorialListPresenter;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.FragmentModule_ProvidesEditorialListPresenterFactory */
public final class FragmentModule_ProvidesEditorialListPresenterFactory implements C13181b<EditorialListPresenter> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AptoideAccountManager> aptoideAccountManagerProvider;
    private final Provider<EditorialListAnalytics> editorialListAnalyticsProvider;
    private final Provider<EditorialListManager> editorialListManagerProvider;
    private final Provider<EditorialListNavigator> editorialListNavigatorProvider;
    private final FragmentModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6115338224673691624L, "cm/aptoide/pt/view/FragmentModule_ProvidesEditorialListPresenterFactory", 11);
        $jacocoData = probes;
        return probes;
    }

    public FragmentModule_ProvidesEditorialListPresenterFactory(FragmentModule module2, Provider<EditorialListManager> editorialListManagerProvider2, Provider<AptoideAccountManager> aptoideAccountManagerProvider2, Provider<EditorialListNavigator> editorialListNavigatorProvider2, Provider<EditorialListAnalytics> editorialListAnalyticsProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.editorialListManagerProvider = editorialListManagerProvider2;
        this.aptoideAccountManagerProvider = aptoideAccountManagerProvider2;
        this.editorialListNavigatorProvider = editorialListNavigatorProvider2;
        this.editorialListAnalyticsProvider = editorialListAnalyticsProvider2;
        $jacocoInit[0] = true;
    }

    public EditorialListPresenter get() {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule fragmentModule = this.module;
        Provider<EditorialListManager> provider = this.editorialListManagerProvider;
        $jacocoInit[1] = true;
        EditorialListManager editorialListManager = (EditorialListManager) provider.get();
        Provider<AptoideAccountManager> provider2 = this.aptoideAccountManagerProvider;
        $jacocoInit[2] = true;
        AptoideAccountManager aptoideAccountManager = (AptoideAccountManager) provider2.get();
        Provider<EditorialListNavigator> provider3 = this.editorialListNavigatorProvider;
        $jacocoInit[3] = true;
        EditorialListNavigator editorialListNavigator = (EditorialListNavigator) provider3.get();
        Provider<EditorialListAnalytics> provider4 = this.editorialListAnalyticsProvider;
        $jacocoInit[4] = true;
        EditorialListAnalytics editorialListAnalytics = (EditorialListAnalytics) provider4.get();
        $jacocoInit[5] = true;
        EditorialListPresenter providesEditorialListPresenter = fragmentModule.providesEditorialListPresenter(editorialListManager, aptoideAccountManager, editorialListNavigator, editorialListAnalytics);
        $jacocoInit[6] = true;
        C13182c.m43111a(providesEditorialListPresenter, "Cannot return null from a non-@Nullable @Provides method");
        EditorialListPresenter editorialListPresenter = providesEditorialListPresenter;
        $jacocoInit[7] = true;
        return editorialListPresenter;
    }

    public static C13181b<EditorialListPresenter> create(FragmentModule module2, Provider<EditorialListManager> editorialListManagerProvider2, Provider<AptoideAccountManager> aptoideAccountManagerProvider2, Provider<EditorialListNavigator> editorialListNavigatorProvider2, Provider<EditorialListAnalytics> editorialListAnalyticsProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule_ProvidesEditorialListPresenterFactory fragmentModule_ProvidesEditorialListPresenterFactory = new FragmentModule_ProvidesEditorialListPresenterFactory(module2, editorialListManagerProvider2, aptoideAccountManagerProvider2, editorialListNavigatorProvider2, editorialListAnalyticsProvider2);
        $jacocoInit[8] = true;
        return fragmentModule_ProvidesEditorialListPresenterFactory;
    }

    public static EditorialListPresenter proxyProvidesEditorialListPresenter(FragmentModule instance, EditorialListManager editorialListManager, AptoideAccountManager aptoideAccountManager, EditorialListNavigator editorialListNavigator, EditorialListAnalytics editorialListAnalytics) {
        boolean[] $jacocoInit = $jacocoInit();
        EditorialListPresenter providesEditorialListPresenter = instance.providesEditorialListPresenter(editorialListManager, aptoideAccountManager, editorialListNavigator, editorialListAnalytics);
        $jacocoInit[9] = true;
        return providesEditorialListPresenter;
    }
}
