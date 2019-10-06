package p005cm.aptoide.p006pt.view.recycler.widget;

import android.view.View;
import android.widget.TextView;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p005cm.aptoide.p006pt.view.recycler.displayable.FooterRowDisplayable;

/* renamed from: cm.aptoide.pt.view.recycler.widget.FooterRowWidget */
public class FooterRowWidget extends Widget<FooterRowDisplayable> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private TextView title;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7815079765383144228L, "cm/aptoide/pt/view/recycler/widget/FooterRowWidget", 6);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void bindView(Displayable displayable, int i) {
        boolean[] $jacocoInit = $jacocoInit();
        bindView((FooterRowDisplayable) displayable, i);
        $jacocoInit[5] = true;
    }

    public FooterRowWidget(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        super(itemView);
        $jacocoInit[0] = true;
    }

    /* access modifiers changed from: protected */
    public void assignViews(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        this.title = (TextView) itemView.findViewById(C1375R.C1376id.title);
        $jacocoInit[1] = true;
    }

    public void bindView(FooterRowDisplayable displayable, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        String pojo = (String) displayable.getPojo();
        $jacocoInit[2] = true;
        this.title.setText(pojo);
        $jacocoInit[3] = true;
        this.title.setVisibility(0);
        $jacocoInit[4] = true;
    }
}
