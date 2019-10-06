package p005cm.aptoide.p006pt.home;

import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import java.util.List;
import javax.inject.Inject;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.p006pt.app.AppNavigator;
import p005cm.aptoide.p006pt.repository.request.RewardAppCoinsAppsRepository;
import p005cm.aptoide.p006pt.store.view.StoreTabGridRecyclerFragment;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.home.GetRewardAppCoinsAppsFragment */
public class GetRewardAppCoinsAppsFragment extends StoreTabGridRecyclerFragment {
    private static transient /* synthetic */ boolean[] $jacocoData;
    @Inject
    AnalyticsManager analyticsManager;
    @Inject
    AppNavigator appNavigator;
    @Inject
    RewardAppCoinsAppsRepository rewardAppsRepository;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3897543248663293102L, "cm/aptoide/pt/home/GetRewardAppCoinsAppsFragment", 14);
        $jacocoData = probes;
        return probes;
    }

    public GetRewardAppCoinsAppsFragment() {
        $jacocoInit()[0] = true;
    }

    public static Fragment newInstance() {
        boolean[] $jacocoInit = $jacocoInit();
        GetRewardAppCoinsAppsFragment getRewardAppCoinsAppsFragment = new GetRewardAppCoinsAppsFragment();
        $jacocoInit[1] = true;
        return getRewardAppCoinsAppsFragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[2] = true;
        getFragmentComponent(savedInstanceState).inject(this);
        $jacocoInit[3] = true;
    }

    /* access modifiers changed from: protected */
    public C0120S<List<Displayable>> buildDisplayables(boolean refresh, String url, boolean bypassServerCache) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S appCoinsRewardAppsFromHomeMore = this.rewardAppsRepository.getAppCoinsRewardAppsFromHomeMore(refresh, this.tag);
        C3951w wVar = new C3951w(this);
        $jacocoInit[4] = true;
        C0120S<List<Displayable>> j = appCoinsRewardAppsFromHomeMore.mo3669j(wVar);
        $jacocoInit[5] = true;
        return j;
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<cm.aptoide.pt.home.RewardApp>, for r13v0, types: [java.util.List, java.util.List<cm.aptoide.pt.home.RewardApp>] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ java.util.List mo14271a(java.util.List<p005cm.aptoide.p006pt.home.RewardApp> r13) {
        /*
            r12 = this;
            boolean[] r0 = $jacocoInit()
            java.util.LinkedList r1 = new java.util.LinkedList
            r1.<init>()
            r2 = 1
            r3 = 6
            r0[r3] = r2
            java.util.Iterator r3 = r13.iterator()
            r4 = 7
            r0[r4] = r2
        L_0x0014:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x004c
            java.lang.Object r4 = r3.next()
            cm.aptoide.pt.home.RewardApp r4 = (p005cm.aptoide.p006pt.home.RewardApp) r4
            r5 = 8
            r0[r5] = r2
            cm.aptoide.pt.home.GridAppCoinsRewardAppsDisplayable r11 = new cm.aptoide.pt.home.GridAppCoinsRewardAppsDisplayable
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = r12.tag
            r5.append(r6)
            java.lang.String r6 = "-more"
            r5.append(r6)
            java.lang.String r7 = r5.toString()
            cm.aptoide.analytics.implementation.navigation.NavigationTracker r8 = r12.navigationTracker
            cm.aptoide.pt.app.AppNavigator r9 = r12.appNavigator
            cm.aptoide.analytics.AnalyticsManager r10 = r12.analyticsManager
            r5 = r11
            r6 = r4
            r5.<init>(r6, r7, r8, r9, r10)
            r1.add(r11)
            r4 = 9
            r0[r4] = r2
            goto L_0x0014
        L_0x004c:
            cm.aptoide.pt.view.recycler.displayable.DisplayableGroup r3 = new cm.aptoide.pt.view.recycler.displayable.DisplayableGroup
            r4 = 10
            r0[r4] = r2
            android.content.Context r4 = r12.getContext()
            java.lang.String r5 = "window"
            java.lang.Object r4 = r4.getSystemService(r5)
            android.view.WindowManager r4 = (android.view.WindowManager) r4
            r5 = 11
            r0[r5] = r2
            android.content.Context r5 = r12.getContext()
            android.content.res.Resources r5 = r5.getResources()
            r3.<init>(r1, r4, r5)
            r4 = 12
            r0[r4] = r2
            java.util.List r3 = java.util.Collections.singletonList(r3)
            r4 = 13
            r0[r4] = r2
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.home.GetRewardAppCoinsAppsFragment.mo14271a(java.util.List):java.util.List");
    }
}
