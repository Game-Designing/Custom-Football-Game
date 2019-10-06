package p005cm.aptoide.p006pt.timeline.view.follow;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.view.fragment.GridRecyclerSwipeWithToolbarFragment_MembersInjector;
import p318e.C13183b;

/* renamed from: cm.aptoide.pt.timeline.view.follow.TimeLineFollowingFragment_MembersInjector */
public final class TimeLineFollowingFragment_MembersInjector implements C13183b<TimeLineFollowingFragment> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<String> marketNameProvider;
    private final Provider<String> themeProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4191032917469518866L, "cm/aptoide/pt/timeline/view/follow/TimeLineFollowingFragment_MembersInjector", 8);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void injectMembers(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        injectMembers((TimeLineFollowingFragment) obj);
        $jacocoInit[7] = true;
    }

    public TimeLineFollowingFragment_MembersInjector(Provider<String> marketNameProvider2, Provider<String> themeProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.marketNameProvider = marketNameProvider2;
        this.themeProvider = themeProvider2;
        $jacocoInit[0] = true;
    }

    public static C13183b<TimeLineFollowingFragment> create(Provider<String> marketNameProvider2, Provider<String> themeProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        TimeLineFollowingFragment_MembersInjector timeLineFollowingFragment_MembersInjector = new TimeLineFollowingFragment_MembersInjector(marketNameProvider2, themeProvider2);
        $jacocoInit[1] = true;
        return timeLineFollowingFragment_MembersInjector;
    }

    public void injectMembers(TimeLineFollowingFragment instance) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<String> provider = this.marketNameProvider;
        $jacocoInit[2] = true;
        String str = (String) provider.get();
        $jacocoInit[3] = true;
        GridRecyclerSwipeWithToolbarFragment_MembersInjector.injectMarketName(instance, str);
        $jacocoInit[4] = true;
        injectTheme(instance, (String) this.themeProvider.get());
        $jacocoInit[5] = true;
    }

    public static void injectTheme(TimeLineFollowingFragment instance, String theme) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.theme = theme;
        $jacocoInit[6] = true;
    }
}
