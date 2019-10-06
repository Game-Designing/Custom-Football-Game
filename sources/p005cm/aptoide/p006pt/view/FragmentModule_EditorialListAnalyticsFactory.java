package p005cm.aptoide.p006pt.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p005cm.aptoide.p006pt.editorialList.EditorialListAnalytics;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.FragmentModule_EditorialListAnalyticsFactory */
public final class FragmentModule_EditorialListAnalyticsFactory implements C13181b<EditorialListAnalytics> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AnalyticsManager> analyticsManagerProvider;
    private final FragmentModule module;
    private final Provider<NavigationTracker> navigationTrackerProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8604443448760084664L, "cm/aptoide/pt/view/FragmentModule_EditorialListAnalyticsFactory", 8);
        $jacocoData = probes;
        return probes;
    }

    public FragmentModule_EditorialListAnalyticsFactory(FragmentModule module2, Provider<NavigationTracker> navigationTrackerProvider2, Provider<AnalyticsManager> analyticsManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.navigationTrackerProvider = navigationTrackerProvider2;
        this.analyticsManagerProvider = analyticsManagerProvider2;
        $jacocoInit[0] = true;
    }

    public EditorialListAnalytics get() {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule fragmentModule = this.module;
        Provider<NavigationTracker> provider = this.navigationTrackerProvider;
        $jacocoInit[1] = true;
        NavigationTracker navigationTracker = (NavigationTracker) provider.get();
        AnalyticsManager analyticsManager = (AnalyticsManager) this.analyticsManagerProvider.get();
        $jacocoInit[2] = true;
        EditorialListAnalytics editorialListAnalytics = fragmentModule.editorialListAnalytics(navigationTracker, analyticsManager);
        $jacocoInit[3] = true;
        C13182c.m43111a(editorialListAnalytics, "Cannot return null from a non-@Nullable @Provides method");
        EditorialListAnalytics editorialListAnalytics2 = editorialListAnalytics;
        $jacocoInit[4] = true;
        return editorialListAnalytics2;
    }

    public static C13181b<EditorialListAnalytics> create(FragmentModule module2, Provider<NavigationTracker> navigationTrackerProvider2, Provider<AnalyticsManager> analyticsManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule_EditorialListAnalyticsFactory fragmentModule_EditorialListAnalyticsFactory = new FragmentModule_EditorialListAnalyticsFactory(module2, navigationTrackerProvider2, analyticsManagerProvider2);
        $jacocoInit[5] = true;
        return fragmentModule_EditorialListAnalyticsFactory;
    }

    public static EditorialListAnalytics proxyEditorialListAnalytics(FragmentModule instance, NavigationTracker navigationTracker, AnalyticsManager analyticsManager) {
        boolean[] $jacocoInit = $jacocoInit();
        EditorialListAnalytics editorialListAnalytics = instance.editorialListAnalytics(navigationTracker, analyticsManager);
        $jacocoInit[6] = true;
        return editorialListAnalytics;
    }
}
