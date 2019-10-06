package p005cm.aptoide.p006pt.view.fragment;

import android.support.p001v7.app.C0019n;
import android.support.p001v7.app.C0760a;
import android.support.p001v7.widget.Toolbar;
import android.view.View;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;

/* renamed from: cm.aptoide.pt.view.fragment.BaseLoaderToolbarFragment */
public abstract class BaseLoaderToolbarFragment extends BaseLoaderFragment {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private Toolbar toolbar;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(5765477763565758832L, "cm/aptoide/pt/view/fragment/BaseLoaderToolbarFragment", 21);
        $jacocoData = probes;
        return probes;
    }

    public BaseLoaderToolbarFragment() {
        $jacocoInit()[0] = true;
    }

    /* access modifiers changed from: protected */
    public Toolbar getToolbar() {
        boolean[] $jacocoInit = $jacocoInit();
        Toolbar toolbar2 = this.toolbar;
        $jacocoInit[1] = true;
        return toolbar2;
    }

    public void setupViews() {
        boolean[] $jacocoInit = $jacocoInit();
        setupToolbar();
        $jacocoInit[2] = true;
    }

    public void setupToolbar() {
        boolean[] $jacocoInit = $jacocoInit();
        if (!hasToolbar()) {
            $jacocoInit[3] = true;
        } else {
            $jacocoInit[4] = true;
            ((C0019n) getActivity()).setSupportActionBar(this.toolbar);
            $jacocoInit[5] = true;
            boolean showUp = displayHomeUpAsEnabled();
            $jacocoInit[6] = true;
            C0760a actionBar = ((C0019n) getActivity()).getSupportActionBar();
            $jacocoInit[7] = true;
            actionBar.mo6153d(showUp);
            $jacocoInit[8] = true;
            actionBar.mo6147a(this.toolbar.getTitle());
            $jacocoInit[9] = true;
            setupToolbarDetails(this.toolbar);
            $jacocoInit[10] = true;
        }
        $jacocoInit[11] = true;
    }

    /* access modifiers changed from: protected */
    public boolean hasToolbar() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (this.toolbar != null) {
            $jacocoInit[12] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[13] = true;
        }
        $jacocoInit[14] = true;
        return z;
    }

    /* access modifiers changed from: protected */
    public boolean displayHomeUpAsEnabled() {
        $jacocoInit()[15] = true;
        return false;
    }

    /* access modifiers changed from: protected */
    public void setupToolbarDetails(Toolbar toolbar2) {
        $jacocoInit()[16] = true;
    }

    public void bindViews(View view) {
        boolean[] $jacocoInit = $jacocoInit();
        super.bindViews(view);
        $jacocoInit[17] = true;
        this.toolbar = (Toolbar) view.findViewById(C1375R.C1376id.toolbar);
        $jacocoInit[18] = true;
    }

    public void onDestroyView() {
        boolean[] $jacocoInit = $jacocoInit();
        this.toolbar = null;
        $jacocoInit[19] = true;
        super.onDestroyView();
        $jacocoInit[20] = true;
    }
}
