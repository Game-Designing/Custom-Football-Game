package p005cm.aptoide.p006pt.view.app;

import android.support.p001v7.widget.RecyclerView.C1000w;
import android.view.View;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.home.HomeBundle;

/* renamed from: cm.aptoide.pt.view.app.AppViewHolder */
public abstract class AppViewHolder extends C1000w {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3702044437099854020L, "cm/aptoide/pt/view/app/AppViewHolder", 1);
        $jacocoData = probes;
        return probes;
    }

    public abstract void setApp(Application application, HomeBundle homeBundle, int i, int i2);

    public AppViewHolder(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        super(itemView);
        $jacocoInit[0] = true;
    }
}
