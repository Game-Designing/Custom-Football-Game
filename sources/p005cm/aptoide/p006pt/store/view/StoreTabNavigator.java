package p005cm.aptoide.p006pt.store.view;

import android.support.p000v4.app.Fragment;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.comments.view.CommentListFragment;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Event;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.StoreContext;
import p005cm.aptoide.p006pt.dataprovider.util.CommentType;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;

/* renamed from: cm.aptoide.pt.store.view.StoreTabNavigator */
public class StoreTabNavigator {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final FragmentNavigator fragmentNavigator;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(117454514559471200L, "cm/aptoide/pt/store/view/StoreTabNavigator", 7);
        $jacocoData = probes;
        return probes;
    }

    public StoreTabNavigator(FragmentNavigator fragmentNavigator2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.fragmentNavigator = fragmentNavigator2;
        $jacocoInit[0] = true;
    }

    public void navigateToStoreTabGridRecyclerView(Event event, String title, String storeTheme, String tag, StoreContext storeContext) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentNavigator fragmentNavigator2 = this.fragmentNavigator;
        $jacocoInit[1] = true;
        Fragment newInstance = StoreTabGridRecyclerFragment.newInstance(event, title, storeTheme, tag, storeContext);
        $jacocoInit[2] = true;
        fragmentNavigator2.navigateTo(newInstance, true);
        $jacocoInit[3] = true;
    }

    public void navigateToCommentGridRecyclerView(CommentType commentType, String url, String storeAnalyticsAction, StoreContext storeContext) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentNavigator fragmentNavigator2 = this.fragmentNavigator;
        $jacocoInit[4] = true;
        Fragment newInstanceUrl = CommentListFragment.newInstanceUrl(commentType, url, storeAnalyticsAction, storeContext);
        $jacocoInit[5] = true;
        fragmentNavigator2.navigateTo(newInstanceUrl, true);
        $jacocoInit[6] = true;
    }
}
