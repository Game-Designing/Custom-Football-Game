package p005cm.aptoide.p006pt.home.apps;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.app.AppNavigator;
import p005cm.aptoide.p006pt.app.view.AppViewFragment.OpenType;
import p005cm.aptoide.p006pt.bottomNavigation.BottomNavigationItem;
import p005cm.aptoide.p006pt.bottomNavigation.BottomNavigationMapper;
import p005cm.aptoide.p006pt.home.AptoideBottomNavigator;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p005cm.aptoide.p006pt.view.settings.MyAccountFragment;
import p026rx.C0120S;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.home.apps.AppsNavigator */
public class AppsNavigator {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final AppNavigator appNavigator;
    private final AptoideBottomNavigator aptoideBottomNavigator;
    private final BottomNavigationMapper bottomNavigationMapper;
    private final FragmentNavigator fragmentNavigator;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-9144331917824252823L, "cm/aptoide/pt/home/apps/AppsNavigator", 10);
        $jacocoData = probes;
        return probes;
    }

    public AppsNavigator(FragmentNavigator fragmentNavigator2, AptoideBottomNavigator aptoideBottomNavigator2, BottomNavigationMapper bottomNavigationMapper2, AppNavigator appNavigator2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.fragmentNavigator = fragmentNavigator2;
        this.aptoideBottomNavigator = aptoideBottomNavigator2;
        this.bottomNavigationMapper = bottomNavigationMapper2;
        this.appNavigator = appNavigator2;
        $jacocoInit[0] = true;
    }

    public void navigateToAppView(long appId, String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appNavigator.navigateWithAppId(appId, packageName, OpenType.OPEN_ONLY, "");
        $jacocoInit[1] = true;
    }

    public void navigateToAppView(String md5) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appNavigator.navigateWithMd5(md5);
        $jacocoInit[2] = true;
    }

    public void navigateToMyAccount() {
        boolean[] $jacocoInit = $jacocoInit();
        this.fragmentNavigator.navigateTo(MyAccountFragment.newInstance(), true);
        $jacocoInit[3] = true;
    }

    public C0120S<Integer> bottomNavigation() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S navigationEvent = this.aptoideBottomNavigator.navigationEvent();
        C3512Da da = new C3512Da(this);
        $jacocoInit[4] = true;
        C0120S<Integer> d = navigationEvent.mo3653d((C0132p<? super T, Boolean>) da);
        $jacocoInit[5] = true;
        return d;
    }

    /* renamed from: a */
    public /* synthetic */ Boolean mo14708a(Integer menuPosition) {
        boolean[] $jacocoInit = $jacocoInit();
        BottomNavigationItem mapItemClicked = this.bottomNavigationMapper.mapItemClicked(menuPosition);
        BottomNavigationItem bottomNavigationItem = BottomNavigationItem.APPS;
        $jacocoInit[7] = true;
        boolean equals = mapItemClicked.equals(bottomNavigationItem);
        $jacocoInit[8] = true;
        Boolean valueOf = Boolean.valueOf(equals);
        $jacocoInit[9] = true;
        return valueOf;
    }

    public void navigateToSeeMoreAppc() {
        boolean[] $jacocoInit = $jacocoInit();
        this.fragmentNavigator.navigateTo(SeeMoreAppcFragment.newInstance(), true);
        $jacocoInit[6] = true;
    }
}
