package p005cm.aptoide.p006pt.app.view.similar;

import android.support.p001v7.widget.RecyclerView.C1000w;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.app.AppViewSimilarApp;
import p005cm.aptoide.p006pt.app.SimilarAppsViewModel;
import p005cm.aptoide.p006pt.view.app.Application;

/* renamed from: cm.aptoide.pt.app.view.similar.SimilarBundleViewHolder */
public abstract class SimilarBundleViewHolder extends C1000w {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1047088227245019814L, "cm/aptoide/pt/app/view/similar/SimilarBundleViewHolder", 8);
        $jacocoData = probes;
        return probes;
    }

    public abstract void setBundle(SimilarAppsBundle similarAppsBundle, int i);

    public SimilarBundleViewHolder(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        super(itemView);
        $jacocoInit[0] = true;
    }

    public List<AppViewSimilarApp> mapToSimilar(SimilarAppsViewModel similarApps, boolean hasAd) {
        boolean[] $jacocoInit = $jacocoInit();
        List<AppViewSimilarApp> resultList = new ArrayList<>();
        $jacocoInit[1] = true;
        if (!hasAd) {
            $jacocoInit[2] = true;
        } else {
            resultList.add(new AppViewSimilarApp(null, similarApps.getAd()));
            $jacocoInit[3] = true;
        }
        $jacocoInit[4] = true;
        for (Application app : similarApps.getRecommendedApps()) {
            $jacocoInit[5] = true;
            resultList.add(new AppViewSimilarApp(app, null));
            $jacocoInit[6] = true;
        }
        $jacocoInit[7] = true;
        return resultList;
    }
}
