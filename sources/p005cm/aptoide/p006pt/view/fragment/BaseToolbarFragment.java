package p005cm.aptoide.p006pt.view.fragment;

import android.support.p001v7.app.C0019n;
import android.support.p001v7.app.C0760a;
import android.support.p001v7.widget.Toolbar;
import android.view.View;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;

/* renamed from: cm.aptoide.pt.view.fragment.BaseToolbarFragment */
public abstract class BaseToolbarFragment extends UIComponentFragment {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private Toolbar toolbar;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(2496996287113893697L, "cm/aptoide/pt/view/fragment/BaseToolbarFragment", 19);
        $jacocoData = probes;
        return probes;
    }

    public BaseToolbarFragment() {
        $jacocoInit()[0] = true;
    }

    /* access modifiers changed from: protected */
    public Toolbar getToolbar() {
        boolean[] $jacocoInit = $jacocoInit();
        Toolbar toolbar2 = this.toolbar;
        $jacocoInit[1] = true;
        return toolbar2;
    }

    public void onDestroyView() {
        boolean[] $jacocoInit = $jacocoInit();
        super.onDestroyView();
        this.toolbar = null;
        $jacocoInit[2] = true;
    }

    public void setupViews() {
        boolean[] $jacocoInit = $jacocoInit();
        setupToolbar();
        $jacocoInit[3] = true;
    }

    public void setupToolbar() {
        boolean[] $jacocoInit = $jacocoInit();
        if (!hasToolbar()) {
            $jacocoInit[4] = true;
        } else {
            $jacocoInit[5] = true;
            ((C0019n) getActivity()).setSupportActionBar(this.toolbar);
            $jacocoInit[6] = true;
            boolean showUp = displayHomeUpAsEnabled();
            $jacocoInit[7] = true;
            C0760a actionBar = ((C0019n) getActivity()).getSupportActionBar();
            $jacocoInit[8] = true;
            actionBar.mo6153d(showUp);
            $jacocoInit[9] = true;
            actionBar.mo6147a(this.toolbar.getTitle());
            $jacocoInit[10] = true;
            setupToolbarDetails(this.toolbar);
            $jacocoInit[11] = true;
        }
        $jacocoInit[12] = true;
    }

    /* access modifiers changed from: protected */
    public boolean hasToolbar() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (this.toolbar != null) {
            $jacocoInit[13] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[14] = true;
        }
        $jacocoInit[15] = true;
        return z;
    }

    /* access modifiers changed from: protected */
    public boolean displayHomeUpAsEnabled() {
        $jacocoInit()[16] = true;
        return false;
    }

    /* access modifiers changed from: protected */
    public void setupToolbarDetails(Toolbar toolbar2) {
        $jacocoInit()[17] = true;
    }

    public void bindViews(View view) {
        boolean[] $jacocoInit = $jacocoInit();
        this.toolbar = (Toolbar) view.findViewById(C1375R.C1376id.toolbar);
        $jacocoInit[18] = true;
    }
}
