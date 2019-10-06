package p005cm.aptoide.p006pt.store.view;

import android.support.p000v4.app.Fragment;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Event.Name;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetStoreWidgets;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.GetStore;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.StoreUserAbstraction.Nodes;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.GetStoreRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.GetUserRequest;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p026rx.C0120S;
import p026rx.p027b.C0132p;
import p026rx.schedulers.Schedulers;

/* renamed from: cm.aptoide.pt.store.view.GetStoreFragment */
public class GetStoreFragment extends StoreTabWidgetsGridRecyclerFragment {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1655106634236247008L, "cm/aptoide/pt/store/view/GetStoreFragment", 12);
        $jacocoData = probes;
        return probes;
    }

    public GetStoreFragment() {
        $jacocoInit()[0] = true;
    }

    public static Fragment newInstance() {
        boolean[] $jacocoInit = $jacocoInit();
        GetStoreFragment getStoreFragment = new GetStoreFragment();
        $jacocoInit[1] = true;
        return getStoreFragment;
    }

    /* access modifiers changed from: protected */
    public C0120S<List<Displayable>> buildDisplayables(boolean refresh, String url, boolean bypassServerCache) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = getStoreObservable(refresh, url, bypassServerCache).mo3616a(Schedulers.m776io());
        C4954I i = new C4954I(this);
        $jacocoInit[2] = true;
        C0120S<List<Displayable>> f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) i);
        $jacocoInit[3] = true;
        return f;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo16492a(GetStore getStore) {
        boolean[] $jacocoInit = $jacocoInit();
        Nodes nodes = getStore.getNodes();
        $jacocoInit[9] = true;
        GetStoreWidgets widgets = nodes.getWidgets();
        $jacocoInit[10] = true;
        C0120S parseDisplayables = parseDisplayables(widgets);
        $jacocoInit[11] = true;
        return parseDisplayables;
    }

    private C0120S<GetStore> getStoreObservable(boolean refresh, String url, boolean bypassServerCache) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.name == Name.getUser) {
            $jacocoInit[4] = true;
            GetUserRequest newGetUser = this.requestFactoryCdnPool.newGetUser(url);
            $jacocoInit[5] = true;
            C0120S<GetStore> observe = newGetUser.observe(refresh, bypassServerCache);
            $jacocoInit[6] = true;
            return observe;
        }
        GetStoreRequest newStore = this.requestFactoryCdnPool.newStore(url);
        $jacocoInit[7] = true;
        C0120S<GetStore> observe2 = newStore.observe(refresh, bypassServerCache);
        $jacocoInit[8] = true;
        return observe2;
    }
}
