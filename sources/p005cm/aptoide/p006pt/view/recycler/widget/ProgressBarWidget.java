package p005cm.aptoide.p006pt.view.recycler.widget;

import android.view.View;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p005cm.aptoide.p006pt.view.recycler.displayable.ProgressBarDisplayable;

/* renamed from: cm.aptoide.pt.view.recycler.widget.ProgressBarWidget */
public class ProgressBarWidget extends Widget<ProgressBarDisplayable> {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6973239844361219157L, "cm/aptoide/pt/view/recycler/widget/ProgressBarWidget", 4);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void bindView(Displayable displayable, int i) {
        boolean[] $jacocoInit = $jacocoInit();
        bindView((ProgressBarDisplayable) displayable, i);
        $jacocoInit[3] = true;
    }

    public ProgressBarWidget(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        super(itemView);
        $jacocoInit[0] = true;
    }

    /* access modifiers changed from: protected */
    public void assignViews(View itemView) {
        $jacocoInit()[1] = true;
    }

    public void bindView(ProgressBarDisplayable displayable, int position) {
        $jacocoInit()[2] = true;
    }
}
