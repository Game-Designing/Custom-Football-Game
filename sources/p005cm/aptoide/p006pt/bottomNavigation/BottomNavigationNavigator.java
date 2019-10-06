package p005cm.aptoide.p006pt.bottomNavigation;

import android.support.p000v4.app.Fragment;
import java.util.ArrayList;
import java.util.Collections;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Event;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Event.Name;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Event.Type;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.StoreContext;
import p005cm.aptoide.p006pt.editorialList.EditorialListFragment;
import p005cm.aptoide.p006pt.home.HomeContainerFragment;
import p005cm.aptoide.p006pt.home.apps.AppsFragment;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p005cm.aptoide.p006pt.search.analytics.SearchAnalytics;
import p005cm.aptoide.p006pt.search.analytics.SearchSource;
import p005cm.aptoide.p006pt.search.view.SearchResultFragment;
import p005cm.aptoide.p006pt.store.view.p079my.MyStoresFragment;

/* renamed from: cm.aptoide.pt.bottomNavigation.BottomNavigationNavigator */
public class BottomNavigationNavigator {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final String EVENT_ACTION = "https://ws75.aptoide.com/api/7/getStoreWidgets/store_id=15/context=stores";
    private final BottomNavigationAnalytics bottomNavigationAnalytics;
    private ArrayList<Integer> bottomNavigationItems = new ArrayList<>();
    private final FragmentNavigator fragmentNavigator;
    private final SearchAnalytics searchAnalytics;
    private final String theme;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5050333760568725844L, "cm/aptoide/pt/bottomNavigation/BottomNavigationNavigator", 61);
        $jacocoData = probes;
        return probes;
    }

    public BottomNavigationNavigator(FragmentNavigator fragmentNavigator2, BottomNavigationAnalytics bottomNavigationAnalytics2, SearchAnalytics searchAnalytics2, String theme2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.bottomNavigationAnalytics = bottomNavigationAnalytics2;
        this.searchAnalytics = searchAnalytics2;
        this.theme = theme2;
        $jacocoInit[0] = true;
        this.fragmentNavigator = fragmentNavigator2;
        $jacocoInit[1] = true;
    }

    public void navigateToBottomNavigationItem(int bottomNavigationPosition) {
        boolean[] $jacocoInit = $jacocoInit();
        if (bottomNavigationPosition == 0) {
            this.bottomNavigationAnalytics.sendNavigateToHomeClickEvent();
            $jacocoInit[3] = true;
            navigateToHome();
            $jacocoInit[4] = true;
        } else if (bottomNavigationPosition == 1) {
            this.bottomNavigationAnalytics.sendNavigateToCurationClickEvent();
            $jacocoInit[13] = true;
            navigateToCuration();
            $jacocoInit[14] = true;
        } else if (bottomNavigationPosition == 2) {
            this.bottomNavigationAnalytics.sendNavigateToSearchClickEvent();
            $jacocoInit[5] = true;
            this.searchAnalytics.searchStart(SearchSource.BOTTOM_NAVIGATION, true);
            $jacocoInit[6] = true;
            SearchResultFragment searchResultFragment = SearchResultFragment.newInstance(true);
            $jacocoInit[7] = true;
            navigateToSearch(searchResultFragment);
            $jacocoInit[8] = true;
        } else if (bottomNavigationPosition == 3) {
            this.bottomNavigationAnalytics.sendNavigateToStoresClickEvent();
            $jacocoInit[9] = true;
            navigateToStore();
            $jacocoInit[10] = true;
        } else if (bottomNavigationPosition != 4) {
            $jacocoInit[2] = true;
        } else {
            this.bottomNavigationAnalytics.sendNavigateToAppsClickEvent();
            $jacocoInit[11] = true;
            navigateToApps();
            $jacocoInit[12] = true;
        }
        $jacocoInit[15] = true;
    }

    public void navigateToHome() {
        boolean[] $jacocoInit = $jacocoInit();
        HomeContainerFragment homeFragment = new HomeContainerFragment();
        $jacocoInit[16] = true;
        navigateToSelectedFragment(0, homeFragment);
        $jacocoInit[17] = true;
    }

    public void navigateToSearch(SearchResultFragment searchResultFragment) {
        boolean[] $jacocoInit = $jacocoInit();
        navigateToSelectedFragment(2, searchResultFragment);
        $jacocoInit[18] = true;
    }

    public void navigateToStore() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[19] = true;
        MyStoresFragment myStoresFragment = MyStoresFragment.newInstance(getStoreEvent(), this.theme, "stores", StoreContext.home);
        $jacocoInit[20] = true;
        navigateToSelectedFragment(3, myStoresFragment);
        $jacocoInit[21] = true;
    }

    public void navigateToApps() {
        boolean[] $jacocoInit = $jacocoInit();
        AppsFragment appsFragment = new AppsFragment();
        $jacocoInit[22] = true;
        navigateToSelectedFragment(4, appsFragment);
        $jacocoInit[23] = true;
    }

    public void navigateToCuration() {
        boolean[] $jacocoInit = $jacocoInit();
        EditorialListFragment curationListFragment = new EditorialListFragment();
        $jacocoInit[24] = true;
        navigateToSelectedFragment(1, curationListFragment);
        $jacocoInit[25] = true;
    }

    public void navigateBack() {
        boolean[] $jacocoInit = $jacocoInit();
        int bottomNavigationPosition = ((Integer) this.bottomNavigationItems.get(1)).intValue();
        $jacocoInit[26] = true;
        this.bottomNavigationItems.remove(0);
        $jacocoInit[27] = true;
        navigateBackToBottomNavigationItem(bottomNavigationPosition);
        $jacocoInit[28] = true;
    }

    public boolean canNavigateBack() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (this.bottomNavigationItems.size() > 1) {
            $jacocoInit[29] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[30] = true;
        }
        $jacocoInit[31] = true;
        return z;
    }

    private void updateBottomNavigationItemsList(int newItem) {
        boolean[] $jacocoInit = $jacocoInit();
        int newItemPosition = this.bottomNavigationItems.indexOf(Integer.valueOf(newItem));
        if (newItemPosition == -1) {
            $jacocoInit[32] = true;
        } else {
            $jacocoInit[33] = true;
            this.bottomNavigationItems.remove(newItemPosition);
            $jacocoInit[34] = true;
        }
        this.bottomNavigationItems.add(Integer.valueOf(newItem));
        $jacocoInit[35] = true;
    }

    private void navigateToSelectedFragment(int newItem, Fragment fragment) {
        boolean[] $jacocoInit = $jacocoInit();
        Fragment currentFragment = this.fragmentNavigator.getFragment();
        $jacocoInit[36] = true;
        if (currentFragment == null) {
            $jacocoInit[37] = true;
        } else if (currentFragment.getClass() == fragment.getClass()) {
            $jacocoInit[38] = true;
            $jacocoInit[43] = true;
        } else {
            $jacocoInit[39] = true;
        }
        updateBottomNavigationItemsList(newItem);
        $jacocoInit[40] = true;
        Collections.rotate(this.bottomNavigationItems, 1);
        $jacocoInit[41] = true;
        this.fragmentNavigator.navigateToCleaningBackStack(fragment, true);
        $jacocoInit[42] = true;
        $jacocoInit[43] = true;
    }

    private void navigateBackToBottomNavigationItem(int bottomNavigationPosition) {
        boolean[] $jacocoInit = $jacocoInit();
        Fragment fragment = null;
        if (bottomNavigationPosition == 0) {
            fragment = new HomeContainerFragment();
            $jacocoInit[45] = true;
        } else if (bottomNavigationPosition == 1) {
            fragment = new EditorialListFragment();
            $jacocoInit[49] = true;
        } else if (bottomNavigationPosition == 2) {
            fragment = SearchResultFragment.newInstance(true);
            $jacocoInit[46] = true;
        } else if (bottomNavigationPosition == 3) {
            fragment = MyStoresFragment.newInstance(getStoreEvent(), "", "stores", StoreContext.home);
            $jacocoInit[47] = true;
        } else if (bottomNavigationPosition != 4) {
            $jacocoInit[44] = true;
        } else {
            fragment = new AppsFragment();
            $jacocoInit[48] = true;
        }
        if (fragment == null) {
            $jacocoInit[50] = true;
        } else {
            $jacocoInit[51] = true;
            this.fragmentNavigator.navigateToCleaningBackStack(fragment, true);
            $jacocoInit[52] = true;
        }
        $jacocoInit[53] = true;
    }

    private Event getStoreEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        Event event = new Event();
        $jacocoInit[54] = true;
        event.setAction(EVENT_ACTION);
        $jacocoInit[55] = true;
        event.setData(null);
        $jacocoInit[56] = true;
        event.setName(Name.myStores);
        $jacocoInit[57] = true;
        event.setType(Type.CLIENT);
        $jacocoInit[58] = true;
        return event;
    }

    public ArrayList<Integer> getBottomNavigationItems() {
        boolean[] $jacocoInit = $jacocoInit();
        ArrayList<Integer> arrayList = this.bottomNavigationItems;
        $jacocoInit[59] = true;
        return arrayList;
    }

    public void setBottomNavigationItems(ArrayList<Integer> savedBottomNavigationItems) {
        boolean[] $jacocoInit = $jacocoInit();
        this.bottomNavigationItems = savedBottomNavigationItems;
        $jacocoInit[60] = true;
    }
}
