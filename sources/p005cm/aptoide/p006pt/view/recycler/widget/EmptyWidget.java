package p005cm.aptoide.p006pt.view.recycler.widget;

import android.view.View;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;

/* renamed from: cm.aptoide.pt.view.recycler.widget.EmptyWidget */
public class EmptyWidget extends Widget {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1244107070625323643L, "cm/aptoide/pt/view/recycler/widget/EmptyWidget", 3);
        $jacocoData = probes;
        return probes;
    }

    public EmptyWidget(View view) {
        boolean[] $jacocoInit = $jacocoInit();
        super(view);
        $jacocoInit[0] = true;
    }

    /* access modifiers changed from: protected */
    public void assignViews(View itemView) {
        $jacocoInit()[1] = true;
    }

    public void bindView(Displayable displayable, int position) {
        $jacocoInit()[2] = true;
    }
}
