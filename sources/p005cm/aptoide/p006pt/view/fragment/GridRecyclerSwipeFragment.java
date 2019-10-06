package p005cm.aptoide.p006pt.view.fragment;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.view.ReloadInterface;
import p005cm.aptoide.p006pt.view.recycler.BaseAdapter;
import p005cm.aptoide.p006pt.view.swipe.LoaderLayoutHandler;
import p005cm.aptoide.p006pt.view.swipe.SwipeLoaderLayoutHandler;

/* renamed from: cm.aptoide.pt.view.fragment.GridRecyclerSwipeFragment */
public abstract class GridRecyclerSwipeFragment<T extends BaseAdapter> extends GridRecyclerFragmentWithDecorator<T> implements ReloadInterface {
    private static transient /* synthetic */ boolean[] $jacocoData;
    protected String storeTheme;

    /* renamed from: cm.aptoide.pt.view.fragment.GridRecyclerSwipeFragment$BundleCons */
    protected static class BundleCons {
        private static transient /* synthetic */ boolean[] $jacocoData = null;
        public static final String STORE_THEME = "storeTheme";

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(4848401295948040689L, "cm/aptoide/pt/view/fragment/GridRecyclerSwipeFragment$BundleCons", 1);
            $jacocoData = probes;
            return probes;
        }

        protected BundleCons() {
            $jacocoInit()[0] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8916465256321531962L, "cm/aptoide/pt/view/fragment/GridRecyclerSwipeFragment", 6);
        $jacocoData = probes;
        return probes;
    }

    public GridRecyclerSwipeFragment() {
        $jacocoInit()[0] = true;
    }

    /* access modifiers changed from: protected */
    public LoaderLayoutHandler createLoaderLayoutHandler() {
        boolean[] $jacocoInit = $jacocoInit();
        if (getViewsToShowAfterLoadingId().length > 0) {
            $jacocoInit[1] = true;
            SwipeLoaderLayoutHandler swipeLoaderLayoutHandler = new SwipeLoaderLayoutHandler(getViewsToShowAfterLoadingId(), this);
            $jacocoInit[2] = true;
            return swipeLoaderLayoutHandler;
        }
        SwipeLoaderLayoutHandler swipeLoaderLayoutHandler2 = new SwipeLoaderLayoutHandler(getViewToShowAfterLoadingId(), (ReloadInterface) this);
        $jacocoInit[3] = true;
        return swipeLoaderLayoutHandler2;
    }

    public void reload() {
        boolean[] $jacocoInit = $jacocoInit();
        load(false, true, null);
        $jacocoInit[4] = true;
    }

    public int getContentViewId() {
        $jacocoInit()[5] = true;
        return C1375R.layout.recycler_swipe_fragment;
    }
}
