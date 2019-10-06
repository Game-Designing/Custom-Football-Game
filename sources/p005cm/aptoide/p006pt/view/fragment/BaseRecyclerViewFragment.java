package p005cm.aptoide.p006pt.view.fragment;

import android.os.Bundle;
import android.support.p001v7.widget.RecyclerView;
import android.support.p001v7.widget.RecyclerView.C0981i;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.view.LifecycleSchim;
import p005cm.aptoide.p006pt.view.recycler.BaseAdapter;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;

/* renamed from: cm.aptoide.pt.view.fragment.BaseRecyclerViewFragment */
public abstract class BaseRecyclerViewFragment<T extends BaseAdapter> extends BaseLoaderToolbarFragment implements LifecycleSchim, DisplayableManager {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private T adapter;
    private ArrayList<Displayable> displayables = new ArrayList<>();
    private C0981i layoutManager;
    private RecyclerView recyclerView;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3548114431495322076L, "cm/aptoide/pt/view/fragment/BaseRecyclerViewFragment", Opcodes.ISHR);
        $jacocoData = probes;
        return probes;
    }

    /* access modifiers changed from: protected */
    public abstract T createAdapter();

    /* access modifiers changed from: protected */
    public abstract C0981i createLayoutManager();

    public BaseRecyclerViewFragment() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[0] = true;
        $jacocoInit[1] = true;
    }

    public void loadExtras(Bundle args) {
        boolean[] $jacocoInit = $jacocoInit();
        super.loadExtras(args);
        $jacocoInit[2] = true;
    }

    public int getContentViewId() {
        $jacocoInit()[3] = true;
        return C1375R.layout.recycler_fragment;
    }

    public void setupViews() {
        boolean[] $jacocoInit = $jacocoInit();
        super.setupViews();
        $jacocoInit[4] = true;
        this.recyclerView.setAdapter(this.adapter);
        $jacocoInit[5] = true;
        this.layoutManager = createLayoutManager();
        $jacocoInit[6] = true;
        this.recyclerView.setLayoutManager(this.layoutManager);
        $jacocoInit[7] = true;
        this.recyclerView.setSaveEnabled(true);
        $jacocoInit[8] = true;
    }

    public void bindViews(View view) {
        boolean[] $jacocoInit = $jacocoInit();
        super.bindViews(view);
        $jacocoInit[9] = true;
        this.recyclerView = (RecyclerView) view.findViewById(C1375R.C1376id.recycler_view);
        $jacocoInit[10] = true;
    }

    public void onDestroyView() {
        boolean[] $jacocoInit = $jacocoInit();
        super.onDestroyView();
        T t = this.adapter;
        if (t == null) {
            $jacocoInit[11] = true;
        } else {
            $jacocoInit[12] = true;
            t.onDestroyView();
            $jacocoInit[13] = true;
        }
        this.layoutManager = null;
        $jacocoInit[14] = true;
        this.recyclerView.mo7557c();
        $jacocoInit[15] = true;
        this.recyclerView.setAdapter(null);
        this.recyclerView = null;
        this.adapter = null;
        $jacocoInit[16] = true;
    }

    @Deprecated
    public void addDisplayable(Displayable displayable) {
        boolean[] $jacocoInit = $jacocoInit();
        addDisplayable(displayable, true);
        $jacocoInit[17] = true;
    }

    @Deprecated
    public void addDisplayables(List<? extends Displayable> displayables2) {
        boolean[] $jacocoInit = $jacocoInit();
        addDisplayables(displayables2, true);
        $jacocoInit[18] = true;
    }

    public BaseRecyclerViewFragment addDisplayable(int position, Displayable displayable, boolean finishedLoading) {
        boolean[] $jacocoInit = $jacocoInit();
        this.adapter.addDisplayable(position, displayable);
        $jacocoInit[19] = true;
        this.displayables.add(position, displayable);
        if (!finishedLoading) {
            $jacocoInit[20] = true;
        } else {
            $jacocoInit[21] = true;
            finishLoading();
            $jacocoInit[22] = true;
        }
        $jacocoInit[23] = true;
        return this;
    }

    public BaseRecyclerViewFragment replaceDisplayable(int position, Displayable displayable, boolean finishedLoading) {
        boolean[] $jacocoInit = $jacocoInit();
        this.adapter.removeDisplayable(position);
        $jacocoInit[24] = true;
        this.adapter.addDisplayable(position, displayable);
        $jacocoInit[25] = true;
        this.adapter.notifyItemChanged(position);
        $jacocoInit[26] = true;
        this.displayables.remove(position);
        $jacocoInit[27] = true;
        this.displayables.add(position, displayable);
        if (!finishedLoading) {
            $jacocoInit[28] = true;
        } else {
            $jacocoInit[29] = true;
            finishLoading();
            $jacocoInit[30] = true;
        }
        $jacocoInit[31] = true;
        return this;
    }

    public BaseRecyclerViewFragment addDisplayable(Displayable displayable, boolean finishedLoading) {
        boolean[] $jacocoInit = $jacocoInit();
        this.adapter.addDisplayable(displayable);
        $jacocoInit[32] = true;
        this.displayables.add(displayable);
        if (!finishedLoading) {
            $jacocoInit[33] = true;
        } else {
            $jacocoInit[34] = true;
            finishLoading();
            $jacocoInit[35] = true;
        }
        $jacocoInit[36] = true;
        return this;
    }

    public BaseRecyclerViewFragment addDisplayables(List<? extends Displayable> displayables2, boolean finishedLoading) {
        boolean[] $jacocoInit = $jacocoInit();
        this.adapter.addDisplayables(displayables2);
        $jacocoInit[37] = true;
        this.displayables.addAll(displayables2);
        if (!finishedLoading) {
            $jacocoInit[38] = true;
        } else {
            $jacocoInit[39] = true;
            finishLoading();
            $jacocoInit[40] = true;
        }
        $jacocoInit[41] = true;
        return this;
    }

    public Displayable getDisplayableAt(int index) {
        boolean[] $jacocoInit = $jacocoInit();
        ArrayList<Displayable> arrayList = this.displayables;
        if (arrayList == null) {
            $jacocoInit[42] = true;
        } else if (arrayList.size() <= index) {
            $jacocoInit[43] = true;
        } else {
            $jacocoInit[44] = true;
            Displayable displayable = (Displayable) this.displayables.get(0);
            $jacocoInit[45] = true;
            return displayable;
        }
        $jacocoInit[46] = true;
        return null;
    }

    public BaseRecyclerViewFragment addDisplayables(int position, List<? extends Displayable> displayables2, boolean finishedLoading) {
        boolean[] $jacocoInit = $jacocoInit();
        this.adapter.addDisplayables(position, displayables2);
        $jacocoInit[47] = true;
        this.displayables.addAll(position, displayables2);
        if (!finishedLoading) {
            $jacocoInit[48] = true;
        } else {
            $jacocoInit[49] = true;
            finishLoading();
            $jacocoInit[50] = true;
        }
        $jacocoInit[51] = true;
        return this;
    }

    public BaseRecyclerViewFragment clearDisplayables() {
        boolean[] $jacocoInit = $jacocoInit();
        this.adapter.clearDisplayables();
        $jacocoInit[52] = true;
        this.displayables.clear();
        $jacocoInit[53] = true;
        return this;
    }

    public boolean hasDisplayables() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        ArrayList<Displayable> arrayList = this.displayables;
        if (arrayList == null) {
            $jacocoInit[54] = true;
        } else if (arrayList.size() <= 0) {
            $jacocoInit[55] = true;
        } else {
            $jacocoInit[56] = true;
            z = true;
            $jacocoInit[58] = true;
            return z;
        }
        z = false;
        $jacocoInit[57] = true;
        $jacocoInit[58] = true;
        return z;
    }

    public int getDisplayablesSize() {
        boolean[] $jacocoInit = $jacocoInit();
        int size = this.displayables.size();
        $jacocoInit[59] = true;
        return size;
    }

    public void removeDisplayables(int fromIndex, int toIndex) {
        boolean[] $jacocoInit = $jacocoInit();
        Iterator<Displayable> iterator = this.displayables.iterator();
        $jacocoInit[60] = true;
        while (true) {
            int fromIndex2 = fromIndex - 1;
            if (fromIndex <= 0) {
                $jacocoInit[61] = true;
                break;
            } else if (!iterator.hasNext()) {
                $jacocoInit[62] = true;
                break;
            } else {
                toIndex--;
                $jacocoInit[63] = true;
                iterator.next();
                $jacocoInit[64] = true;
                fromIndex = fromIndex2;
            }
        }
        while (true) {
            int toIndex2 = toIndex - 1;
            if (toIndex < 0) {
                $jacocoInit[65] = true;
                break;
            } else if (!iterator.hasNext()) {
                $jacocoInit[66] = true;
                break;
            } else {
                $jacocoInit[67] = true;
                iterator.next();
                $jacocoInit[68] = true;
                iterator.remove();
                $jacocoInit[69] = true;
                toIndex = toIndex2;
            }
        }
        this.adapter.clearDisplayables();
        $jacocoInit[70] = true;
        this.adapter.addDisplayables(this.displayables);
        $jacocoInit[71] = true;
    }

    public boolean contains(Displayable displayable) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        ArrayList<Displayable> arrayList = this.displayables;
        if (arrayList == null) {
            $jacocoInit[72] = true;
        } else if (!arrayList.contains(displayable)) {
            $jacocoInit[73] = true;
        } else {
            $jacocoInit[74] = true;
            z = true;
            $jacocoInit[76] = true;
            return z;
        }
        z = false;
        $jacocoInit[75] = true;
        $jacocoInit[76] = true;
        return z;
    }

    public BaseRecyclerViewFragment addDisplayableWithAnimation(int position, Displayable displayable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.adapter.addDisplayableWithAnimation(position, displayable);
        $jacocoInit[77] = true;
        this.displayables.add(position, displayable);
        $jacocoInit[78] = true;
        return this;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.adapter != null) {
            $jacocoInit[79] = true;
        } else {
            $jacocoInit[80] = true;
            this.adapter = createAdapter();
            $jacocoInit[81] = true;
        }
        super.onViewCreated(view, savedInstanceState);
        $jacocoInit[82] = true;
        onViewCreated();
        $jacocoInit[83] = true;
    }

    public void load(boolean create, boolean refresh, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        if (create) {
            $jacocoInit[84] = true;
        } else if (refresh) {
            $jacocoInit[85] = true;
        } else {
            List<Displayable> displayablesCopy = new LinkedList<>(this.displayables);
            $jacocoInit[87] = true;
            this.displayables.clear();
            $jacocoInit[88] = true;
            this.adapter.clearDisplayables();
            $jacocoInit[89] = true;
            this.displayables.addAll(displayablesCopy);
            $jacocoInit[90] = true;
            this.adapter.addDisplayables(displayablesCopy);
            $jacocoInit[91] = true;
            finishLoading();
            $jacocoInit[92] = true;
            $jacocoInit[93] = true;
        }
        clearDisplayables();
        $jacocoInit[86] = true;
        $jacocoInit[93] = true;
    }

    public void onResume() {
        boolean[] $jacocoInit = $jacocoInit();
        super.onResume();
        T t = this.adapter;
        if (t == null) {
            $jacocoInit[94] = true;
        } else {
            $jacocoInit[95] = true;
            t.onResume();
            $jacocoInit[96] = true;
        }
        $jacocoInit[97] = true;
    }

    public void onPause() {
        boolean[] $jacocoInit = $jacocoInit();
        super.onPause();
        T t = this.adapter;
        if (t == null) {
            $jacocoInit[98] = true;
        } else {
            $jacocoInit[99] = true;
            t.onPause();
            $jacocoInit[100] = true;
        }
        $jacocoInit[101] = true;
    }

    public void onViewCreated() {
        boolean[] $jacocoInit = $jacocoInit();
        T t = this.adapter;
        if (t == null) {
            $jacocoInit[102] = true;
        } else {
            $jacocoInit[103] = true;
            t.onViewCreated();
            $jacocoInit[104] = true;
        }
        $jacocoInit[105] = true;
    }

    public void onViewStateRestored(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onViewStateRestored(savedInstanceState);
        T t = this.adapter;
        if (t == null) {
            $jacocoInit[106] = true;
        } else {
            $jacocoInit[107] = true;
            t.onViewStateRestored(savedInstanceState);
            $jacocoInit[108] = true;
        }
        $jacocoInit[109] = true;
    }

    public void onSaveInstanceState(Bundle outState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onSaveInstanceState(outState);
        T t = this.adapter;
        if (t == null) {
            $jacocoInit[110] = true;
        } else {
            $jacocoInit[111] = true;
            t.onSaveInstanceState(outState);
            $jacocoInit[112] = true;
        }
        $jacocoInit[113] = true;
    }

    public T getAdapter() {
        boolean[] $jacocoInit = $jacocoInit();
        T t = this.adapter;
        $jacocoInit[114] = true;
        return t;
    }

    public C0981i getLayoutManager() {
        boolean[] $jacocoInit = $jacocoInit();
        C0981i iVar = this.layoutManager;
        $jacocoInit[115] = true;
        return iVar;
    }

    public RecyclerView getRecyclerView() {
        boolean[] $jacocoInit = $jacocoInit();
        RecyclerView recyclerView2 = this.recyclerView;
        $jacocoInit[116] = true;
        return recyclerView2;
    }
}
