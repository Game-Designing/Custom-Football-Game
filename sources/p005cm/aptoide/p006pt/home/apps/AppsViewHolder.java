package p005cm.aptoide.p006pt.home.apps;

import android.support.p001v7.widget.RecyclerView.C1000w;
import android.view.View;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.home.apps.AppsViewHolder */
public abstract class AppsViewHolder extends C1000w {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4056177477042115960L, "cm/aptoide/pt/home/apps/AppsViewHolder", 1);
        $jacocoData = probes;
        return probes;
    }

    public abstract void setApp(App app);

    public AppsViewHolder(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        super(itemView);
        $jacocoInit[0] = true;
    }
}
