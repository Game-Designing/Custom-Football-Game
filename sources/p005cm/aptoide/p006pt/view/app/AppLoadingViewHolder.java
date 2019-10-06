package p005cm.aptoide.p006pt.view.app;

import android.view.View;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.view.app.AppLoadingViewHolder */
public class AppLoadingViewHolder extends ListStoreAppViewHolder {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6387013564495027602L, "cm/aptoide/pt/view/app/AppLoadingViewHolder", 2);
        $jacocoData = probes;
        return probes;
    }

    public AppLoadingViewHolder(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        super(itemView);
        $jacocoInit[0] = true;
    }

    public void setApp(Application app) {
        $jacocoInit()[1] = true;
    }
}
