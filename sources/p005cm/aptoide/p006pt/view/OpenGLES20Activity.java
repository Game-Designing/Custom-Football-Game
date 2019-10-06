package p005cm.aptoide.p006pt.view;

import android.os.Bundle;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;

/* renamed from: cm.aptoide.pt.view.OpenGLES20Activity */
public class OpenGLES20Activity extends ActivityView {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-470904052009680262L, "cm/aptoide/pt/view/OpenGLES20Activity", 5);
        $jacocoData = probes;
        return probes;
    }

    public OpenGLES20Activity() {
        $jacocoInit()[0] = true;
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[1] = true;
        setContentView((int) C1375R.layout.activity_main_open_gl);
        $jacocoInit[2] = true;
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        boolean[] $jacocoInit = $jacocoInit();
        super.onPause();
        $jacocoInit[3] = true;
        overridePendingTransition(0, 0);
        $jacocoInit[4] = true;
    }
}
