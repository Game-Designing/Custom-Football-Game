package p005cm.aptoide.p006pt.store.view;

import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import java.util.LinkedList;
import java.util.List;
import javax.inject.Inject;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.DataList;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.ListStores;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.Endless;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.ListStoresRequest;
import p005cm.aptoide.p006pt.store.StoreAnalytics;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p026rx.p027b.C0129b;

/* renamed from: cm.aptoide.pt.store.view.ListStoresFragment */
public class ListStoresFragment extends GetStoreEndlessFragment<ListStores> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    @Inject
    AnalyticsManager analyticsManager;
    @Inject
    NavigationTracker navigationTracker;
    private StoreAnalytics storeAnalytics;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8885943676563559221L, "cm/aptoide/pt/store/view/ListStoresFragment", 16);
        $jacocoData = probes;
        return probes;
    }

    public ListStoresFragment() {
        $jacocoInit()[0] = true;
    }

    public static Fragment newInstance() {
        boolean[] $jacocoInit = $jacocoInit();
        ListStoresFragment listStoresFragment = new ListStoresFragment();
        $jacocoInit[1] = true;
        return listStoresFragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[2] = true;
        getFragmentComponent(savedInstanceState).inject(this);
        $jacocoInit[3] = true;
        this.storeAnalytics = new StoreAnalytics(this.analyticsManager, this.navigationTracker);
        $jacocoInit[4] = true;
    }

    /* access modifiers changed from: protected */
    public C0044V7<ListStores, ? extends Endless> buildRequest(boolean refresh, String url) {
        boolean[] $jacocoInit = $jacocoInit();
        ListStoresRequest newListStoresRequest = this.requestFactoryCdnPool.newListStoresRequest(url);
        $jacocoInit[5] = true;
        return newListStoresRequest;
    }

    /* access modifiers changed from: protected */
    public C0129b<ListStores> buildAction() {
        boolean[] $jacocoInit = $jacocoInit();
        C4991fa faVar = new C4991fa(this);
        $jacocoInit[6] = true;
        return faVar;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16562a(ListStores listStores) {
        boolean[] $jacocoInit = $jacocoInit();
        DataList dataList = listStores.getDataList();
        $jacocoInit[7] = true;
        List<Store> list = dataList.getList();
        $jacocoInit[8] = true;
        List<Displayable> displayables = new LinkedList<>();
        $jacocoInit[9] = true;
        $jacocoInit[10] = true;
        for (Store store : list) {
            $jacocoInit[11] = true;
            StringBuilder sb = new StringBuilder();
            sb.append("Home ");
            CharSequence title = getToolbar().getTitle();
            $jacocoInit[12] = true;
            sb.append(title.toString());
            GridStoreDisplayable gridStoreDisplayable = new GridStoreDisplayable(store, sb.toString(), this.storeAnalytics);
            $jacocoInit[13] = true;
            displayables.add(gridStoreDisplayable);
            $jacocoInit[14] = true;
        }
        addDisplayables(displayables);
        $jacocoInit[15] = true;
    }
}
