package p005cm.aptoide.p006pt.home;

import android.view.View;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.home.StoreBundleViewHolder */
class StoreBundleViewHolder extends AppBundleViewHolder {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4259865443057540623L, "cm/aptoide/pt/home/StoreBundleViewHolder", 2);
        $jacocoData = probes;
        return probes;
    }

    public StoreBundleViewHolder(View view) {
        boolean[] $jacocoInit = $jacocoInit();
        super(view);
        $jacocoInit[0] = true;
    }

    public void setBundle(HomeBundle appBundle, int position) {
        $jacocoInit()[1] = true;
    }
}
