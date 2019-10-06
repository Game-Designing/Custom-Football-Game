package p005cm.aptoide.p006pt.view;

import android.content.Context;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.view.BackButton.ClickHandler;
import p005cm.aptoide.p006pt.view.fragment.NavigationTrackFragment;

/* renamed from: cm.aptoide.pt.view.BackButtonFragment */
public abstract class BackButtonFragment extends NavigationTrackFragment implements BackButton {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private BackButton backButton;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6114653829346746836L, "cm/aptoide/pt/view/BackButtonFragment", 5);
        $jacocoData = probes;
        return probes;
    }

    public BackButtonFragment() {
        $jacocoInit()[0] = true;
    }

    public void onAttach(Context context) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onAttach(context);
        if (context instanceof BackButton) {
            this.backButton = (BackButton) context;
            $jacocoInit[2] = true;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Context must implement ");
        sb.append(BackButton.class.getSimpleName());
        IllegalStateException illegalStateException = new IllegalStateException(sb.toString());
        $jacocoInit[1] = true;
        throw illegalStateException;
    }

    public void registerClickHandler(ClickHandler clickHandler) {
        boolean[] $jacocoInit = $jacocoInit();
        this.backButton.registerClickHandler(clickHandler);
        $jacocoInit[3] = true;
    }

    public void unregisterClickHandler(ClickHandler clickHandler) {
        boolean[] $jacocoInit = $jacocoInit();
        this.backButton.unregisterClickHandler(clickHandler);
        $jacocoInit[4] = true;
    }
}
