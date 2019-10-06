package p005cm.aptoide.p006pt.store.view;

import android.os.Bundle;
import android.support.p001v7.widget.RecyclerView.C0988n;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.interfaces.ErrorRequestListener;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7EndlessResponse;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.Endless;
import p005cm.aptoide.p006pt.view.recycler.BaseAdapter;
import p005cm.aptoide.p006pt.view.recycler.EndlessRecyclerOnScrollListener;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p026rx.C0120S;
import p026rx.p027b.C0129b;

/* renamed from: cm.aptoide.pt.store.view.GetStoreEndlessFragment */
public abstract class GetStoreEndlessFragment<T extends BaseV7EndlessResponse> extends StoreTabWidgetsGridRecyclerFragment {
    private static transient /* synthetic */ boolean[] $jacocoData;
    protected EndlessRecyclerOnScrollListener endlessRecyclerOnScrollListener;
    private C0044V7<T, ? extends Endless> v7request;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6289309549658309167L, "cm/aptoide/pt/store/view/GetStoreEndlessFragment", 20);
        $jacocoData = probes;
        return probes;
    }

    /* access modifiers changed from: protected */
    public abstract C0129b<T> buildAction();

    /* access modifiers changed from: protected */
    public abstract C0044V7<T, ? extends Endless> buildRequest(boolean z, String str);

    public GetStoreEndlessFragment() {
        $jacocoInit()[0] = true;
    }

    public void onDestroyView() {
        boolean[] $jacocoInit = $jacocoInit();
        EndlessRecyclerOnScrollListener endlessRecyclerOnScrollListener2 = this.endlessRecyclerOnScrollListener;
        if (endlessRecyclerOnScrollListener2 == null) {
            $jacocoInit[1] = true;
        } else {
            $jacocoInit[2] = true;
            endlessRecyclerOnScrollListener2.stopLoading();
            this.endlessRecyclerOnScrollListener = null;
            $jacocoInit[3] = true;
        }
        super.onDestroyView();
        $jacocoInit[4] = true;
    }

    public void load(boolean create, boolean refresh, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.load(create, refresh, savedInstanceState);
        if (create) {
            $jacocoInit[5] = true;
        } else {
            $jacocoInit[6] = true;
            setupEndless(this.v7request, buildAction(), refresh);
            $jacocoInit[7] = true;
        }
        $jacocoInit[8] = true;
    }

    /* access modifiers changed from: protected */
    public C0120S<List<Displayable>> buildDisplayables(boolean refresh, String url, boolean bypassServerCache) {
        boolean[] $jacocoInit = $jacocoInit();
        this.v7request = buildRequest(refresh, url);
        $jacocoInit[9] = true;
        setupEndless(this.v7request, buildAction(), refresh);
        $jacocoInit[10] = true;
        return null;
    }

    private void setupEndless(C0044V7<T, ? extends Endless> v7request2, C0129b<T> action, boolean refresh) {
        boolean[] $jacocoInit = $jacocoInit();
        getRecyclerView().mo7557c();
        EndlessRecyclerOnScrollListener endlessRecyclerOnScrollListener2 = this.endlessRecyclerOnScrollListener;
        if (endlessRecyclerOnScrollListener2 == null) {
            $jacocoInit[11] = true;
        } else {
            $jacocoInit[12] = true;
            endlessRecyclerOnScrollListener2.stopLoading();
            $jacocoInit[13] = true;
        }
        $jacocoInit[14] = true;
        BaseAdapter adapter = getAdapter();
        $jacocoInit[15] = true;
        this.endlessRecyclerOnScrollListener = new EndlessRecyclerOnScrollListener(adapter, v7request2, action, getErrorRequestListener());
        $jacocoInit[16] = true;
        getRecyclerView().mo7530a((C0988n) this.endlessRecyclerOnScrollListener);
        $jacocoInit[17] = true;
        this.endlessRecyclerOnScrollListener.onLoadMore(refresh, refresh);
        $jacocoInit[18] = true;
    }

    /* access modifiers changed from: protected */
    public ErrorRequestListener getErrorRequestListener() {
        boolean[] $jacocoInit = $jacocoInit();
        C4953H h = new C4953H(this);
        $jacocoInit[19] = true;
        return h;
    }
}
