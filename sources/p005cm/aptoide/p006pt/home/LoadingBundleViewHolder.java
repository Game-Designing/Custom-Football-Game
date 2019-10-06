package p005cm.aptoide.p006pt.home;

import android.view.View;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.home.LoadingBundleViewHolder */
class LoadingBundleViewHolder extends AppBundleViewHolder {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3518176448294771370L, "cm/aptoide/pt/home/LoadingBundleViewHolder", 2);
        $jacocoData = probes;
        return probes;
    }

    public LoadingBundleViewHolder(View view) {
        boolean[] $jacocoInit = $jacocoInit();
        super(view);
        $jacocoInit[0] = true;
    }

    public void setBundle(HomeBundle homeBundle, int position) {
        $jacocoInit()[1] = true;
    }
}
