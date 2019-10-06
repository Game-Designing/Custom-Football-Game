package p005cm.aptoide.p006pt.view.fragment;

import android.content.res.Resources;
import android.support.p000v4.app.C0014p;
import android.support.p001v7.widget.RecyclerView.C0981i;
import android.view.WindowManager;
import java.lang.reflect.Constructor;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.view.recycler.BaseAdapter;
import p005cm.aptoide.p006pt.view.recycler.BaseGridLayoutManager;

/* renamed from: cm.aptoide.pt.view.fragment.GridRecyclerFragment */
public abstract class GridRecyclerFragment<T extends BaseAdapter> extends BaseRecyclerViewFragment<T> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Class<? extends BaseAdapter> adapterClass;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6149291306091313498L, "cm/aptoide/pt/view/fragment/GridRecyclerFragment", 12);
        $jacocoData = probes;
        return probes;
    }

    public GridRecyclerFragment() {
        boolean[] $jacocoInit = $jacocoInit();
        this.adapterClass = BaseAdapter.class;
        $jacocoInit[0] = true;
    }

    public GridRecyclerFragment(Class<T> adapterClass2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.adapterClass = adapterClass2;
        $jacocoInit[1] = true;
    }

    /* access modifiers changed from: protected */
    public int[] getViewsToShowAfterLoadingId() {
        int[] iArr = new int[0];
        $jacocoInit()[2] = true;
        return iArr;
    }

    /* access modifiers changed from: protected */
    public int getViewToShowAfterLoadingId() {
        $jacocoInit()[3] = true;
        return C1375R.C1376id.recycler_view;
    }

    /* access modifiers changed from: protected */
    public C0981i createLayoutManager() {
        boolean[] $jacocoInit = $jacocoInit();
        C0014p activity = getActivity();
        BaseAdapter adapter = getAdapter();
        Resources resources = getContext().getResources();
        $jacocoInit[4] = true;
        BaseGridLayoutManager baseGridLayoutManager = new BaseGridLayoutManager(activity, adapter, resources, (WindowManager) getContext().getSystemService("window"));
        $jacocoInit[5] = true;
        return baseGridLayoutManager;
    }

    /* access modifiers changed from: protected */
    public T createAdapter() {
        boolean[] $jacocoInit = $jacocoInit();
        try {
            Constructor constructor = this.adapterClass.getConstructor(new Class[0]);
            Object[] objArr = new Object[0];
            $jacocoInit[6] = true;
            T t = (BaseAdapter) constructor.newInstance(objArr);
            $jacocoInit[7] = true;
            return t;
        } catch (Exception e) {
            $jacocoInit[8] = true;
            e.printStackTrace();
            $jacocoInit[9] = true;
            CrashReport instance = CrashReport.getInstance();
            $jacocoInit[10] = true;
            instance.log(e);
            $jacocoInit[11] = true;
            return null;
        }
    }
}
