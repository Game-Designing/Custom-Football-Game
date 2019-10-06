package p005cm.aptoide.p006pt.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.permission.PermissionServiceFragment;

/* renamed from: cm.aptoide.pt.view.fragment.UIComponentFragment */
public abstract class UIComponentFragment extends PermissionServiceFragment implements UiComponent {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1983118893566193932L, "cm/aptoide/pt/view/fragment/UIComponentFragment", 13);
        $jacocoData = probes;
        return probes;
    }

    public abstract void setupViews();

    public UIComponentFragment() {
        $jacocoInit()[0] = true;
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[1] = true;
        if (getArguments() == null) {
            $jacocoInit[2] = true;
        } else {
            $jacocoInit[3] = true;
            loadExtras(getArguments());
            $jacocoInit[4] = true;
        }
        $jacocoInit[5] = true;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onViewCreated(view, savedInstanceState);
        $jacocoInit[6] = true;
        bindViews(view);
        $jacocoInit[7] = true;
        setupViews();
        $jacocoInit[8] = true;
    }

    public void loadExtras(Bundle args) {
        $jacocoInit()[9] = true;
    }

    public void setupToolbar() {
        $jacocoInit()[10] = true;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreateView(inflater, container, savedInstanceState);
        $jacocoInit[11] = true;
        View inflate = inflater.inflate(getContentViewId(), container, false);
        $jacocoInit[12] = true;
        return inflate;
    }
}
