package p005cm.aptoide.p006pt.reviews;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p318e.C13183b;

/* renamed from: cm.aptoide.pt.reviews.LatestReviewsFragment_MembersInjector */
public final class LatestReviewsFragment_MembersInjector implements C13183b<LatestReviewsFragment> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AnalyticsManager> analyticsManagerProvider;
    private final Provider<NavigationTracker> navigationTrackerProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1116487961925904775L, "cm/aptoide/pt/reviews/LatestReviewsFragment_MembersInjector", 7);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void injectMembers(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        injectMembers((LatestReviewsFragment) obj);
        $jacocoInit[6] = true;
    }

    public LatestReviewsFragment_MembersInjector(Provider<AnalyticsManager> analyticsManagerProvider2, Provider<NavigationTracker> navigationTrackerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.analyticsManagerProvider = analyticsManagerProvider2;
        this.navigationTrackerProvider = navigationTrackerProvider2;
        $jacocoInit[0] = true;
    }

    public static C13183b<LatestReviewsFragment> create(Provider<AnalyticsManager> analyticsManagerProvider2, Provider<NavigationTracker> navigationTrackerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        LatestReviewsFragment_MembersInjector latestReviewsFragment_MembersInjector = new LatestReviewsFragment_MembersInjector(analyticsManagerProvider2, navigationTrackerProvider2);
        $jacocoInit[1] = true;
        return latestReviewsFragment_MembersInjector;
    }

    public void injectMembers(LatestReviewsFragment instance) {
        boolean[] $jacocoInit = $jacocoInit();
        injectAnalyticsManager(instance, (AnalyticsManager) this.analyticsManagerProvider.get());
        $jacocoInit[2] = true;
        injectNavigationTracker(instance, (NavigationTracker) this.navigationTrackerProvider.get());
        $jacocoInit[3] = true;
    }

    public static void injectAnalyticsManager(LatestReviewsFragment instance, AnalyticsManager analyticsManager) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.analyticsManager = analyticsManager;
        $jacocoInit[4] = true;
    }

    public static void injectNavigationTracker(LatestReviewsFragment instance, NavigationTracker navigationTracker) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.navigationTracker = navigationTracker;
        $jacocoInit[5] = true;
    }
}
