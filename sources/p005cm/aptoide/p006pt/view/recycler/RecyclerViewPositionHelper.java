package p005cm.aptoide.p006pt.view.recycler;

import android.support.p001v7.widget.C0916Ba;
import android.support.p001v7.widget.RecyclerView;
import android.support.p001v7.widget.RecyclerView.C0981i;
import android.view.View;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.view.recycler.RecyclerViewPositionHelper */
public class RecyclerViewPositionHelper {
    private static transient /* synthetic */ boolean[] $jacocoData;
    final C0981i layoutManager;
    final RecyclerView recyclerView;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4598100540644257025L, "cm/aptoide/pt/view/recycler/RecyclerViewPositionHelper", 48);
        $jacocoData = probes;
        return probes;
    }

    RecyclerViewPositionHelper(RecyclerView recyclerView2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.recyclerView = recyclerView2;
        $jacocoInit[0] = true;
        this.layoutManager = recyclerView2.getLayoutManager();
        $jacocoInit[1] = true;
    }

    public static RecyclerViewPositionHelper createHelper(RecyclerView recyclerView2) {
        boolean[] $jacocoInit = $jacocoInit();
        if (recyclerView2 != null) {
            RecyclerViewPositionHelper recyclerViewPositionHelper = new RecyclerViewPositionHelper(recyclerView2);
            $jacocoInit[4] = true;
            return recyclerViewPositionHelper;
        }
        $jacocoInit[2] = true;
        NullPointerException nullPointerException = new NullPointerException("Recycler View is null");
        $jacocoInit[3] = true;
        throw nullPointerException;
    }

    public int getItemCount() {
        int i;
        boolean[] $jacocoInit = $jacocoInit();
        C0981i iVar = this.layoutManager;
        if (iVar == null) {
            i = 0;
            $jacocoInit[5] = true;
        } else {
            i = iVar.getItemCount();
            $jacocoInit[6] = true;
        }
        $jacocoInit[7] = true;
        return i;
    }

    public int getChildCount() {
        int i;
        boolean[] $jacocoInit = $jacocoInit();
        C0981i iVar = this.layoutManager;
        if (iVar == null) {
            i = 0;
            $jacocoInit[8] = true;
        } else {
            i = iVar.getChildCount();
            $jacocoInit[9] = true;
        }
        $jacocoInit[10] = true;
        return i;
    }

    public int findFirstVisibleItemPosition() {
        int i;
        boolean[] $jacocoInit = $jacocoInit();
        View child = findOneVisibleChild(0, this.layoutManager.getChildCount(), false, true);
        $jacocoInit[11] = true;
        if (child == null) {
            i = -1;
            $jacocoInit[12] = true;
        } else {
            i = this.recyclerView.mo7583f(child);
            $jacocoInit[13] = true;
        }
        $jacocoInit[14] = true;
        return i;
    }

    /* access modifiers changed from: 0000 */
    public View findOneVisibleChild(int fromIndex, int toIndex, boolean completelyVisible, boolean acceptPartiallyVisible) {
        C0916Ba helper;
        int next;
        int i = toIndex;
        boolean[] $jacocoInit = $jacocoInit();
        if (this.layoutManager.canScrollVertically()) {
            $jacocoInit[15] = true;
            helper = C0916Ba.m4404b(this.layoutManager);
            $jacocoInit[16] = true;
        } else {
            helper = C0916Ba.m4402a(this.layoutManager);
            $jacocoInit[17] = true;
        }
        int start = helper.mo6977f();
        $jacocoInit[18] = true;
        int end = helper.mo6969b();
        if (i > fromIndex) {
            $jacocoInit[19] = true;
            next = 1;
        } else {
            next = -1;
            $jacocoInit[20] = true;
        }
        View partiallyVisible = null;
        $jacocoInit[21] = true;
        int i2 = fromIndex;
        while (i2 != i) {
            $jacocoInit[22] = true;
            View child = this.layoutManager.getChildAt(i2);
            $jacocoInit[23] = true;
            int childStart = helper.mo6974d(child);
            $jacocoInit[24] = true;
            int childEnd = helper.mo6967a(child);
            if (childStart >= end) {
                $jacocoInit[25] = true;
            } else if (childEnd <= start) {
                $jacocoInit[26] = true;
            } else if (completelyVisible) {
                if (childStart < start) {
                    $jacocoInit[27] = true;
                } else if (childEnd > end) {
                    $jacocoInit[28] = true;
                } else {
                    $jacocoInit[29] = true;
                    return child;
                }
                if (!acceptPartiallyVisible) {
                    $jacocoInit[30] = true;
                } else if (partiallyVisible != null) {
                    $jacocoInit[31] = true;
                } else {
                    partiallyVisible = child;
                    $jacocoInit[32] = true;
                }
            } else {
                $jacocoInit[33] = true;
                return child;
            }
            i2 += next;
            $jacocoInit[34] = true;
        }
        $jacocoInit[35] = true;
        return partiallyVisible;
    }

    public int findFirstCompletelyVisibleItemPosition() {
        int i;
        boolean[] $jacocoInit = $jacocoInit();
        View child = findOneVisibleChild(0, this.layoutManager.getChildCount(), true, false);
        $jacocoInit[36] = true;
        if (child == null) {
            i = -1;
            $jacocoInit[37] = true;
        } else {
            i = this.recyclerView.mo7583f(child);
            $jacocoInit[38] = true;
        }
        $jacocoInit[39] = true;
        return i;
    }

    public int findLastVisibleItemPosition() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = -1;
        View child = findOneVisibleChild(this.layoutManager.getChildCount() - 1, -1, false, true);
        $jacocoInit[40] = true;
        if (child == null) {
            $jacocoInit[41] = true;
        } else {
            i = this.recyclerView.mo7583f(child);
            $jacocoInit[42] = true;
        }
        $jacocoInit[43] = true;
        return i;
    }

    public int findLastCompletelyVisibleItemPosition() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = -1;
        View child = findOneVisibleChild(this.layoutManager.getChildCount() - 1, -1, true, false);
        $jacocoInit[44] = true;
        if (child == null) {
            $jacocoInit[45] = true;
        } else {
            i = this.recyclerView.mo7583f(child);
            $jacocoInit[46] = true;
        }
        $jacocoInit[47] = true;
        return i;
    }
}
