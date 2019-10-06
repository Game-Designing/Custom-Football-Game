package p005cm.aptoide.p006pt.home;

import android.support.p001v7.widget.C0916Ba;
import android.support.p001v7.widget.C1111sa;
import android.support.p001v7.widget.LinearLayoutManager;
import android.support.p001v7.widget.RecyclerView;
import android.support.p001v7.widget.RecyclerView.C0981i;
import android.view.View;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.home.SnapToStartHelper */
public class SnapToStartHelper extends C1111sa {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private C0916Ba horizontalHelper;
    private C0916Ba verticalHelper;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3941477077738694363L, "cm/aptoide/pt/home/SnapToStartHelper", 41);
        $jacocoData = probes;
        return probes;
    }

    public SnapToStartHelper() {
        $jacocoInit()[0] = true;
    }

    public void attachToRecyclerView(RecyclerView recyclerView) throws IllegalStateException {
        boolean[] $jacocoInit = $jacocoInit();
        super.attachToRecyclerView(recyclerView);
        $jacocoInit[1] = true;
    }

    public int[] calculateDistanceToFinalSnap(C0981i layoutManager, View targetView) {
        boolean[] $jacocoInit = $jacocoInit();
        int[] out = new int[2];
        $jacocoInit[2] = true;
        if (layoutManager.canScrollHorizontally()) {
            $jacocoInit[3] = true;
            out[0] = distanceToStart(targetView, getHorizontalHelper(layoutManager));
            $jacocoInit[4] = true;
        } else {
            out[0] = 0;
            $jacocoInit[5] = true;
        }
        if (layoutManager.canScrollVertically()) {
            $jacocoInit[6] = true;
            out[1] = distanceToStart(targetView, getVerticalHelper(layoutManager));
            $jacocoInit[7] = true;
        } else {
            out[1] = 0;
            $jacocoInit[8] = true;
        }
        $jacocoInit[9] = true;
        return out;
    }

    public View findSnapView(C0981i layoutManager) {
        boolean[] $jacocoInit = $jacocoInit();
        if (layoutManager instanceof LinearLayoutManager) {
            $jacocoInit[10] = true;
            if (layoutManager.canScrollHorizontally()) {
                $jacocoInit[11] = true;
                View startView = getStartView(layoutManager, getHorizontalHelper(layoutManager));
                $jacocoInit[12] = true;
                return startView;
            }
            View startView2 = getStartView(layoutManager, getVerticalHelper(layoutManager));
            $jacocoInit[13] = true;
            return startView2;
        }
        View findSnapView = super.findSnapView(layoutManager);
        $jacocoInit[14] = true;
        return findSnapView;
    }

    private int distanceToStart(View targetView, C0916Ba helper) {
        int d = helper.mo6974d(targetView) - helper.mo6977f();
        $jacocoInit()[15] = true;
        return d;
    }

    private View getStartView(C0981i layoutManager, C0916Ba helper) {
        boolean isLastItem;
        boolean[] $jacocoInit = $jacocoInit();
        if (layoutManager instanceof LinearLayoutManager) {
            $jacocoInit[16] = true;
            int firstChild = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            $jacocoInit[17] = true;
            int findLastCompletelyVisibleItemPosition = linearLayoutManager.findLastCompletelyVisibleItemPosition();
            $jacocoInit[18] = true;
            if (findLastCompletelyVisibleItemPosition == layoutManager.getItemCount() - 1) {
                $jacocoInit[19] = true;
                isLastItem = true;
            } else {
                isLastItem = false;
                $jacocoInit[20] = true;
            }
            if (firstChild == -1) {
                $jacocoInit[21] = true;
            } else if (isLastItem) {
                $jacocoInit[22] = true;
            } else {
                View child = layoutManager.findViewByPosition(firstChild);
                $jacocoInit[24] = true;
                if (helper.mo6967a(child) < helper.mo6970b(child) / 2) {
                    $jacocoInit[25] = true;
                } else {
                    $jacocoInit[26] = true;
                    if (helper.mo6967a(child) <= 0) {
                        $jacocoInit[27] = true;
                    } else {
                        $jacocoInit[28] = true;
                        return child;
                    }
                }
                int findLastCompletelyVisibleItemPosition2 = ((LinearLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition();
                $jacocoInit[29] = true;
                if (findLastCompletelyVisibleItemPosition2 == layoutManager.getItemCount() - 1) {
                    $jacocoInit[30] = true;
                    return null;
                }
                View findViewByPosition = layoutManager.findViewByPosition(firstChild + 1);
                $jacocoInit[31] = true;
                return findViewByPosition;
            }
            $jacocoInit[23] = true;
            return null;
        }
        View findSnapView = super.findSnapView(layoutManager);
        $jacocoInit[32] = true;
        return findSnapView;
    }

    private C0916Ba getVerticalHelper(C0981i layoutManager) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.verticalHelper != null) {
            $jacocoInit[33] = true;
        } else {
            $jacocoInit[34] = true;
            this.verticalHelper = C0916Ba.m4404b(layoutManager);
            $jacocoInit[35] = true;
        }
        C0916Ba ba = this.verticalHelper;
        $jacocoInit[36] = true;
        return ba;
    }

    private C0916Ba getHorizontalHelper(C0981i layoutManager) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.horizontalHelper != null) {
            $jacocoInit[37] = true;
        } else {
            $jacocoInit[38] = true;
            this.horizontalHelper = C0916Ba.m4402a(layoutManager);
            $jacocoInit[39] = true;
        }
        C0916Ba ba = this.horizontalHelper;
        $jacocoInit[40] = true;
        return ba;
    }
}
