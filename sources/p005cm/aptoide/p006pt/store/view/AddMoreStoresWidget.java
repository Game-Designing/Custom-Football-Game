package p005cm.aptoide.p006pt.store.view;

import android.support.p000v4.app.C0014p;
import android.support.p000v4.app.C0486t;
import android.view.View;
import android.widget.Button;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p005cm.aptoide.p006pt.view.recycler.widget.Widget;

/* renamed from: cm.aptoide.pt.store.view.AddMoreStoresWidget */
public class AddMoreStoresWidget extends Widget<AddMoreStoresDisplayable> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private Button addMoreStores;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7521216776246365598L, "cm/aptoide/pt/store/view/AddMoreStoresWidget", 10);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void bindView(Displayable displayable, int i) {
        boolean[] $jacocoInit = $jacocoInit();
        bindView((AddMoreStoresDisplayable) displayable, i);
        $jacocoInit[3] = true;
    }

    public AddMoreStoresWidget(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        super(itemView);
        $jacocoInit[0] = true;
    }

    /* access modifiers changed from: protected */
    public void assignViews(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        this.addMoreStores = (Button) itemView.findViewById(C1375R.C1376id.add_more_stores);
        $jacocoInit[1] = true;
    }

    public void bindView(AddMoreStoresDisplayable displayable, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        this.addMoreStores.setOnClickListener(new C4979a(this));
        $jacocoInit[2] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16464a(View v) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!(this.itemView.getContext() instanceof C0014p)) {
            $jacocoInit[4] = true;
        } else {
            $jacocoInit[5] = true;
            AddStoreDialog addStoreDialog = new AddStoreDialog();
            View view = this.itemView;
            $jacocoInit[6] = true;
            C0486t supportFragmentManager = ((C0014p) view.getContext()).getSupportFragmentManager();
            $jacocoInit[7] = true;
            addStoreDialog.show(supportFragmentManager, "addStoreDialog");
            $jacocoInit[8] = true;
        }
        $jacocoInit[9] = true;
    }
}
