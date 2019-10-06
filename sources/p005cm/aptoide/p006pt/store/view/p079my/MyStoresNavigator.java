package p005cm.aptoide.p006pt.store.view.p079my;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.bottomNavigation.BottomNavigationItem;
import p005cm.aptoide.p006pt.bottomNavigation.BottomNavigationMapper;
import p005cm.aptoide.p006pt.home.AptoideBottomNavigator;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p005cm.aptoide.p006pt.view.settings.MyAccountFragment;
import p026rx.C0120S;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.store.view.my.MyStoresNavigator */
public class MyStoresNavigator {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final AptoideBottomNavigator aptoideBottomNavigator;
    private final BottomNavigationMapper bottomNavigationMapper;
    private final FragmentNavigator fragmentNavigator;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(2916098193812778840L, "cm/aptoide/pt/store/view/my/MyStoresNavigator", 7);
        $jacocoData = probes;
        return probes;
    }

    public MyStoresNavigator(FragmentNavigator fragmentNavigator2, AptoideBottomNavigator aptoideBottomNavigator2, BottomNavigationMapper bottomNavigationMapper2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.fragmentNavigator = fragmentNavigator2;
        this.aptoideBottomNavigator = aptoideBottomNavigator2;
        this.bottomNavigationMapper = bottomNavigationMapper2;
        $jacocoInit[0] = true;
    }

    public C0120S<Integer> bottomNavigationEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S navigationEvent = this.aptoideBottomNavigator.navigationEvent();
        C5041f fVar = new C5041f(this);
        $jacocoInit[1] = true;
        C0120S<Integer> d = navigationEvent.mo3653d((C0132p<? super T, Boolean>) fVar);
        $jacocoInit[2] = true;
        return d;
    }

    /* renamed from: a */
    public /* synthetic */ Boolean mo16673a(Integer navigationEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        BottomNavigationItem mapItemClicked = this.bottomNavigationMapper.mapItemClicked(navigationEvent);
        BottomNavigationItem bottomNavigationItem = BottomNavigationItem.STORES;
        $jacocoInit[4] = true;
        boolean equals = mapItemClicked.equals(bottomNavigationItem);
        $jacocoInit[5] = true;
        Boolean valueOf = Boolean.valueOf(equals);
        $jacocoInit[6] = true;
        return valueOf;
    }

    public void navigateToMyAccount() {
        boolean[] $jacocoInit = $jacocoInit();
        this.fragmentNavigator.navigateTo(MyAccountFragment.newInstance(), true);
        $jacocoInit[3] = true;
    }
}
