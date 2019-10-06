package p005cm.aptoide.p006pt.view.swipe;

import android.support.p000v4.widget.SwipeRefreshLayout;
import android.view.View;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.view.LoadInterface;
import p005cm.aptoide.p006pt.view.ReloadInterface;
import p005cm.aptoide.p006pt.view.fragment.GridRecyclerSwipeFragment;

/* renamed from: cm.aptoide.pt.view.swipe.SwipeLoaderLayoutHandler */
public class SwipeLoaderLayoutHandler extends LoaderLayoutHandler {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private SwipeRefreshLayout swipeContainer;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-115486667750496615L, "cm/aptoide/pt/view/swipe/SwipeLoaderLayoutHandler", 17);
        $jacocoData = probes;
        return probes;
    }

    public SwipeLoaderLayoutHandler(int baseViewId, ReloadInterface reloadInterface) {
        boolean[] $jacocoInit = $jacocoInit();
        super((LoadInterface) reloadInterface, baseViewId);
        $jacocoInit[0] = true;
    }

    public SwipeLoaderLayoutHandler(int[] viewsToShowAfterLoadingId, GridRecyclerSwipeFragment reloadInterface) {
        boolean[] $jacocoInit = $jacocoInit();
        super((LoadInterface) reloadInterface, viewsToShowAfterLoadingId);
        $jacocoInit[1] = true;
    }

    public void bindViews(View view) {
        boolean[] $jacocoInit = $jacocoInit();
        super.bindViews(view);
        $jacocoInit[2] = true;
        this.swipeContainer = (SwipeRefreshLayout) view.findViewById(C1375R.C1376id.swipe_container);
        $jacocoInit[3] = true;
        this.swipeContainer.setColorSchemeResources(C1375R.color.default_progress_bar_color, C1375R.color.default_color, C1375R.color.default_progress_bar_color, C1375R.color.default_color);
        $jacocoInit[4] = true;
        this.swipeContainer.setOnRefreshListener(new C5546g(this));
        $jacocoInit[5] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo17561b() {
        boolean[] $jacocoInit = $jacocoInit();
        ((ReloadInterface) this.loadInterface).reload();
        $jacocoInit[16] = true;
    }

    public void onFinishLoading(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onFinishLoading(throwable);
        $jacocoInit[6] = true;
        this.swipeContainer.setRefreshing(false);
        $jacocoInit[7] = true;
        this.swipeContainer.setEnabled(false);
        $jacocoInit[8] = true;
    }

    public void restoreState() {
        boolean[] $jacocoInit = $jacocoInit();
        super.restoreState();
        $jacocoInit[9] = true;
        this.swipeContainer.setEnabled(true);
        $jacocoInit[10] = true;
    }

    /* access modifiers changed from: protected */
    public void onFinishLoading() {
        boolean[] $jacocoInit = $jacocoInit();
        super.onFinishLoading();
        $jacocoInit[11] = true;
        this.swipeContainer.setRefreshing(false);
        $jacocoInit[12] = true;
        this.swipeContainer.setEnabled(true);
        $jacocoInit[13] = true;
    }

    public void unbindViews() {
        boolean[] $jacocoInit = $jacocoInit();
        this.swipeContainer.setOnRefreshListener(null);
        $jacocoInit[14] = true;
        super.unbindViews();
        $jacocoInit[15] = true;
    }
}
