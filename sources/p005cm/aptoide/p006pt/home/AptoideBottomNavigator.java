package p005cm.aptoide.p006pt.home;

import p005cm.aptoide.p006pt.bottomNavigation.BottomNavigationItem;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.home.AptoideBottomNavigator */
public interface AptoideBottomNavigator {
    void hideBottomNavigation();

    C0120S<Integer> navigationEvent();

    void requestFocus(BottomNavigationItem bottomNavigationItem);

    void showFragment(Integer num);

    void toggleBottomNavigation();
}
