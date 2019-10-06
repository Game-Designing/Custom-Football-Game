package p005cm.aptoide.p006pt.view.p080rx;

import android.support.p001v7.widget.RecyclerView;
import android.support.p001v7.widget.RecyclerView.C0988n;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.view.recycler.BaseAdapter;
import p005cm.aptoide.p006pt.view.recycler.EndlessRecyclerOnScrollListener;
import p026rx.C0120S.C0122a;
import p026rx.C14980ia;
import p026rx.p387a.C14521b;

/* renamed from: cm.aptoide.pt.view.rx.EndlessRecyclerViewLoadMoreOnSubscribe */
public class EndlessRecyclerViewLoadMoreOnSubscribe implements C0122a<Integer> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final BaseAdapter adapter;
    private final RecyclerView recyclerView;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8069970616724296224L, "cm/aptoide/pt/view/rx/EndlessRecyclerViewLoadMoreOnSubscribe", 7);
        $jacocoData = probes;
        return probes;
    }

    static /* synthetic */ RecyclerView access$000(EndlessRecyclerViewLoadMoreOnSubscribe x0) {
        boolean[] $jacocoInit = $jacocoInit();
        RecyclerView recyclerView2 = x0.recyclerView;
        $jacocoInit[6] = true;
        return recyclerView2;
    }

    public /* bridge */ /* synthetic */ void call(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        call((C14980ia) obj);
        $jacocoInit[5] = true;
    }

    public EndlessRecyclerViewLoadMoreOnSubscribe(RecyclerView recyclerView2, BaseAdapter adapter2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.recyclerView = recyclerView2;
        this.adapter = adapter2;
        $jacocoInit[0] = true;
    }

    public void call(final C14980ia<? super Integer> subscriber) {
        boolean[] $jacocoInit = $jacocoInit();
        C14521b.verifyMainThread();
        $jacocoInit[1] = true;
        final EndlessRecyclerOnScrollListener listener = new EndlessRecyclerOnScrollListener(this, this.adapter) {
            private static transient /* synthetic */ boolean[] $jacocoData;
            final /* synthetic */ EndlessRecyclerViewLoadMoreOnSubscribe this$0;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(-3723520957172007594L, "cm/aptoide/pt/view/rx/EndlessRecyclerViewLoadMoreOnSubscribe$1", 6);
                $jacocoData = probes;
                return probes;
            }

            {
                boolean[] $jacocoInit = $jacocoInit();
                this.this$0 = this$0;
                $jacocoInit[0] = true;
            }

            public void onLoadMore(boolean bypassCache, boolean bypassServerCache) {
                boolean[] $jacocoInit = $jacocoInit();
                if (subscriber.isUnsubscribed()) {
                    $jacocoInit[1] = true;
                } else {
                    $jacocoInit[2] = true;
                    subscriber.onNext(Integer.valueOf(getAdapter().getItemCount()));
                    $jacocoInit[3] = true;
                }
                $jacocoInit[4] = true;
            }

            /* access modifiers changed from: protected */
            public boolean hasMoreElements() {
                $jacocoInit()[5] = true;
                return true;
            }
        };
        $jacocoInit[2] = true;
        this.recyclerView.mo7530a((C0988n) listener);
        $jacocoInit[3] = true;
        subscriber.add(new C14521b(this) {
            private static transient /* synthetic */ boolean[] $jacocoData;
            final /* synthetic */ EndlessRecyclerViewLoadMoreOnSubscribe this$0;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(3254758774750354752L, "cm/aptoide/pt/view/rx/EndlessRecyclerViewLoadMoreOnSubscribe$2", 2);
                $jacocoData = probes;
                return probes;
            }

            {
                boolean[] $jacocoInit = $jacocoInit();
                this.this$0 = this$0;
                $jacocoInit[0] = true;
            }

            /* access modifiers changed from: protected */
            public void onUnsubscribe() {
                boolean[] $jacocoInit = $jacocoInit();
                EndlessRecyclerViewLoadMoreOnSubscribe.access$000(this.this$0).mo7549b((C0988n) listener);
                $jacocoInit[1] = true;
            }
        });
        $jacocoInit[4] = true;
    }
}
