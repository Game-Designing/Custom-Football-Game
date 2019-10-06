package p005cm.aptoide.p006pt.store.view;

import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetStoreWidgets;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.Endless;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.GetStoreWidgetsRequest;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p026rx.p027b.C0129b;
import p026rx.p398d.C14906b;

/* renamed from: cm.aptoide.pt.store.view.GetStoreWidgetsFragment */
public class GetStoreWidgetsFragment extends GetStoreEndlessFragment<GetStoreWidgets> {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5672282935713236827L, "cm/aptoide/pt/store/view/GetStoreWidgetsFragment", 10);
        $jacocoData = probes;
        return probes;
    }

    public GetStoreWidgetsFragment() {
        $jacocoInit()[0] = true;
    }

    public static Fragment newInstance() {
        boolean[] $jacocoInit = $jacocoInit();
        GetStoreWidgetsFragment getStoreWidgetsFragment = new GetStoreWidgetsFragment();
        $jacocoInit[1] = true;
        return getStoreWidgetsFragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[2] = true;
    }

    public void load(boolean create, boolean refresh, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.load(create, refresh, savedInstanceState);
        $jacocoInit[3] = true;
    }

    /* access modifiers changed from: protected */
    public C0044V7<GetStoreWidgets, ? extends Endless> buildRequest(boolean refresh, String url) {
        boolean[] $jacocoInit = $jacocoInit();
        GetStoreWidgetsRequest newStoreWidgets = this.requestFactoryCdnPool.newStoreWidgets(url);
        $jacocoInit[4] = true;
        return newStoreWidgets;
    }

    /* access modifiers changed from: protected */
    public C0129b<GetStoreWidgets> buildAction() {
        boolean[] $jacocoInit = $jacocoInit();
        C4955J j = new C4955J(this);
        $jacocoInit[5] = true;
        return j;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16493a(GetStoreWidgets getStoreWidgets) {
        boolean[] $jacocoInit = $jacocoInit();
        C14906b k = parseDisplayables(getStoreWidgets).mo3672k();
        $jacocoInit[7] = true;
        List<Displayable> first = (List) k.mo46110a();
        $jacocoInit[8] = true;
        addDisplayables(first);
        $jacocoInit[9] = true;
    }

    public void onResume() {
        boolean[] $jacocoInit = $jacocoInit();
        super.onResume();
        $jacocoInit[6] = true;
    }
}
