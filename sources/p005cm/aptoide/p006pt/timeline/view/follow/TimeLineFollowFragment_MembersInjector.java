package p005cm.aptoide.p006pt.timeline.view.follow;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.view.fragment.GridRecyclerSwipeWithToolbarFragment_MembersInjector;
import p318e.C13183b;

/* renamed from: cm.aptoide.pt.timeline.view.follow.TimeLineFollowFragment_MembersInjector */
public final class TimeLineFollowFragment_MembersInjector implements C13183b<TimeLineFollowFragment> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<String> marketNameProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-1621112164732164581L, "cm/aptoide/pt/timeline/view/follow/TimeLineFollowFragment_MembersInjector", 6);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void injectMembers(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        injectMembers((TimeLineFollowFragment) obj);
        $jacocoInit[5] = true;
    }

    public TimeLineFollowFragment_MembersInjector(Provider<String> marketNameProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.marketNameProvider = marketNameProvider2;
        $jacocoInit[0] = true;
    }

    public static C13183b<TimeLineFollowFragment> create(Provider<String> marketNameProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        TimeLineFollowFragment_MembersInjector timeLineFollowFragment_MembersInjector = new TimeLineFollowFragment_MembersInjector(marketNameProvider2);
        $jacocoInit[1] = true;
        return timeLineFollowFragment_MembersInjector;
    }

    public void injectMembers(TimeLineFollowFragment instance) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<String> provider = this.marketNameProvider;
        $jacocoInit[2] = true;
        String str = (String) provider.get();
        $jacocoInit[3] = true;
        GridRecyclerSwipeWithToolbarFragment_MembersInjector.injectMarketName(instance, str);
        $jacocoInit[4] = true;
    }
}
