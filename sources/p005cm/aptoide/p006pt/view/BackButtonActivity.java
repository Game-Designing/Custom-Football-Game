package p005cm.aptoide.p006pt.view;

import android.os.Bundle;
import java.util.HashSet;
import java.util.Set;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.view.BackButton.ClickHandler;

/* renamed from: cm.aptoide.pt.view.BackButtonActivity */
public abstract class BackButtonActivity extends ThemedActivityView implements BackButton {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private Set<ClickHandler> clickHandlers;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6745172701260368525L, "cm/aptoide/pt/view/BackButtonActivity", 15);
        $jacocoData = probes;
        return probes;
    }

    public BackButtonActivity() {
        $jacocoInit()[0] = true;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[1] = true;
        this.clickHandlers = new HashSet();
        $jacocoInit[2] = true;
    }

    public void registerClickHandler(ClickHandler clickHandler) {
        boolean[] $jacocoInit = $jacocoInit();
        this.clickHandlers.add(clickHandler);
        $jacocoInit[3] = true;
    }

    public void unregisterClickHandler(ClickHandler clickHandler) {
        boolean[] $jacocoInit = $jacocoInit();
        this.clickHandlers.remove(clickHandler);
        $jacocoInit[4] = true;
    }

    public void onBackPressed() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean handled = false;
        $jacocoInit[5] = true;
        $jacocoInit[6] = true;
        for (ClickHandler clickHandler : this.clickHandlers) {
            $jacocoInit[7] = true;
            if (!clickHandler.handle()) {
                $jacocoInit[8] = true;
            } else {
                handled = true;
                $jacocoInit[9] = true;
            }
            $jacocoInit[10] = true;
        }
        if (handled) {
            $jacocoInit[11] = true;
        } else {
            $jacocoInit[12] = true;
            super.onBackPressed();
            $jacocoInit[13] = true;
        }
        $jacocoInit[14] = true;
    }
}
