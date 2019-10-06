package p005cm.aptoide.p006pt.view.p080rx;

import android.support.p001v7.widget.RecyclerView;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.view.recycler.BaseAdapter;
import p026rx.C0120S;
import p026rx.C0120S.C0122a;

/* renamed from: cm.aptoide.pt.view.rx.RxEndlessRecyclerView */
public final class RxEndlessRecyclerView {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3919253496486519865L, "cm/aptoide/pt/view/rx/RxEndlessRecyclerView", 3);
        $jacocoData = probes;
        return probes;
    }

    private RxEndlessRecyclerView() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[0] = true;
        new AssertionError("No instances!");
        $jacocoInit[1] = true;
    }

    public static C0120S<Integer> loadMore(RecyclerView recyclerView, BaseAdapter adapter) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Integer> a = C0120S.m634a((C0122a<T>) new EndlessRecyclerViewLoadMoreOnSubscribe<T>(recyclerView, adapter));
        $jacocoInit[2] = true;
        return a;
    }
}
