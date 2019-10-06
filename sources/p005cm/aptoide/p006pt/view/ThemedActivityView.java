package p005cm.aptoide.p006pt.view;

import android.os.Bundle;
import javax.inject.Inject;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.view.ThemedActivityView */
public abstract class ThemedActivityView extends ActivityView {
    private static transient /* synthetic */ boolean[] $jacocoData;
    @Inject
    String theme;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3537802090456655123L, "cm/aptoide/pt/view/ThemedActivityView", 4);
        $jacocoData = probes;
        return probes;
    }

    public ThemedActivityView() {
        $jacocoInit()[0] = true;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[1] = true;
        ThemeUtils.setStatusBarThemeColor(this, this.theme);
        $jacocoInit[2] = true;
        ThemeUtils.setAptoideTheme(this, this.theme);
        $jacocoInit[3] = true;
    }
}
