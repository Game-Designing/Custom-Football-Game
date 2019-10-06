package p005cm.aptoide.p006pt.presenter;

import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.presenter.CompositePresenter */
public final class CompositePresenter implements Presenter {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final List<Presenter> presenters;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8236455825100605629L, "cm/aptoide/pt/presenter/CompositePresenter", 5);
        $jacocoData = probes;
        return probes;
    }

    public CompositePresenter(List<Presenter> presenters2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.presenters = presenters2;
        $jacocoInit[0] = true;
    }

    public void present() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[1] = true;
        for (Presenter presenter : this.presenters) {
            $jacocoInit[2] = true;
            presenter.present();
            $jacocoInit[3] = true;
        }
        $jacocoInit[4] = true;
    }
}
