package p005cm.aptoide.p006pt.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.editorial.EditorialAnalytics;
import p005cm.aptoide.p006pt.editorial.EditorialManager;
import p005cm.aptoide.p006pt.editorial.EditorialNavigator;
import p005cm.aptoide.p006pt.editorial.EditorialPresenter;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.FragmentModule_ProvidesEditorialPresenterFactory */
public final class FragmentModule_ProvidesEditorialPresenterFactory implements C13181b<EditorialPresenter> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<CrashReport> crashReportProvider;
    private final Provider<EditorialAnalytics> editorialAnalyticsProvider;
    private final Provider<EditorialManager> editorialManagerProvider;
    private final Provider<EditorialNavigator> editorialNavigatorProvider;
    private final FragmentModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(2140478820575648493L, "cm/aptoide/pt/view/FragmentModule_ProvidesEditorialPresenterFactory", 11);
        $jacocoData = probes;
        return probes;
    }

    public FragmentModule_ProvidesEditorialPresenterFactory(FragmentModule module2, Provider<EditorialManager> editorialManagerProvider2, Provider<CrashReport> crashReportProvider2, Provider<EditorialAnalytics> editorialAnalyticsProvider2, Provider<EditorialNavigator> editorialNavigatorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.editorialManagerProvider = editorialManagerProvider2;
        this.crashReportProvider = crashReportProvider2;
        this.editorialAnalyticsProvider = editorialAnalyticsProvider2;
        this.editorialNavigatorProvider = editorialNavigatorProvider2;
        $jacocoInit[0] = true;
    }

    public EditorialPresenter get() {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule fragmentModule = this.module;
        Provider<EditorialManager> provider = this.editorialManagerProvider;
        $jacocoInit[1] = true;
        EditorialManager editorialManager = (EditorialManager) provider.get();
        Provider<CrashReport> provider2 = this.crashReportProvider;
        $jacocoInit[2] = true;
        CrashReport crashReport = (CrashReport) provider2.get();
        Provider<EditorialAnalytics> provider3 = this.editorialAnalyticsProvider;
        $jacocoInit[3] = true;
        EditorialAnalytics editorialAnalytics = (EditorialAnalytics) provider3.get();
        Provider<EditorialNavigator> provider4 = this.editorialNavigatorProvider;
        $jacocoInit[4] = true;
        EditorialNavigator editorialNavigator = (EditorialNavigator) provider4.get();
        $jacocoInit[5] = true;
        EditorialPresenter providesEditorialPresenter = fragmentModule.providesEditorialPresenter(editorialManager, crashReport, editorialAnalytics, editorialNavigator);
        $jacocoInit[6] = true;
        C13182c.m43111a(providesEditorialPresenter, "Cannot return null from a non-@Nullable @Provides method");
        EditorialPresenter editorialPresenter = providesEditorialPresenter;
        $jacocoInit[7] = true;
        return editorialPresenter;
    }

    public static C13181b<EditorialPresenter> create(FragmentModule module2, Provider<EditorialManager> editorialManagerProvider2, Provider<CrashReport> crashReportProvider2, Provider<EditorialAnalytics> editorialAnalyticsProvider2, Provider<EditorialNavigator> editorialNavigatorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule_ProvidesEditorialPresenterFactory fragmentModule_ProvidesEditorialPresenterFactory = new FragmentModule_ProvidesEditorialPresenterFactory(module2, editorialManagerProvider2, crashReportProvider2, editorialAnalyticsProvider2, editorialNavigatorProvider2);
        $jacocoInit[8] = true;
        return fragmentModule_ProvidesEditorialPresenterFactory;
    }

    public static EditorialPresenter proxyProvidesEditorialPresenter(FragmentModule instance, EditorialManager editorialManager, CrashReport crashReport, EditorialAnalytics editorialAnalytics, EditorialNavigator editorialNavigator) {
        boolean[] $jacocoInit = $jacocoInit();
        EditorialPresenter providesEditorialPresenter = instance.providesEditorialPresenter(editorialManager, crashReport, editorialAnalytics, editorialNavigator);
        $jacocoInit[9] = true;
        return providesEditorialPresenter;
    }
}
