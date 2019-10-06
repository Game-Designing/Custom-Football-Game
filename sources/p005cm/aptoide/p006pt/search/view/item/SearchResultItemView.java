package p005cm.aptoide.p006pt.search.view.item;

import android.support.p001v7.widget.RecyclerView.C1000w;
import android.view.View;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.search.view.item.SearchResultItemView */
public abstract class SearchResultItemView<T> extends C1000w {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7164815289371566646L, "cm/aptoide/pt/search/view/item/SearchResultItemView", 3);
        $jacocoData = probes;
        return probes;
    }

    SearchResultItemView(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        super(itemView);
        $jacocoInit[0] = true;
    }

    public void setup(T t) {
        $jacocoInit()[1] = true;
    }

    public void prepareToRecycle() {
        $jacocoInit()[2] = true;
    }
}
