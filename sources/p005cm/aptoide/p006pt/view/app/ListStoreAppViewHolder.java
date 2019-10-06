package p005cm.aptoide.p006pt.view.app;

import android.support.p001v7.widget.RecyclerView.C1000w;
import android.view.View;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.view.app.ListStoreAppViewHolder */
public abstract class ListStoreAppViewHolder extends C1000w {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3575953317837681292L, "cm/aptoide/pt/view/app/ListStoreAppViewHolder", 1);
        $jacocoData = probes;
        return probes;
    }

    public abstract void setApp(Application application);

    public ListStoreAppViewHolder(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        super(itemView);
        $jacocoInit[0] = true;
    }
}
