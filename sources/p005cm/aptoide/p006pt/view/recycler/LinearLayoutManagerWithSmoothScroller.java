package p005cm.aptoide.p006pt.view.recycler;

import android.content.Context;
import android.graphics.PointF;
import android.support.p001v7.widget.C1108ra;
import android.support.p001v7.widget.LinearLayoutManager;
import android.support.p001v7.widget.RecyclerView;
import android.support.p001v7.widget.RecyclerView.C0994s;
import android.support.p001v7.widget.RecyclerView.C0997t;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.view.recycler.LinearLayoutManagerWithSmoothScroller */
public class LinearLayoutManagerWithSmoothScroller extends LinearLayoutManager {
    private static transient /* synthetic */ boolean[] $jacocoData;

    /* renamed from: cm.aptoide.pt.view.recycler.LinearLayoutManagerWithSmoothScroller$TopSnappedSmoothScroller */
    private class TopSnappedSmoothScroller extends C1108ra {
        private static transient /* synthetic */ boolean[] $jacocoData;
        final /* synthetic */ LinearLayoutManagerWithSmoothScroller this$0;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(8800120985587228632L, "cm/aptoide/pt/view/recycler/LinearLayoutManagerWithSmoothScroller$TopSnappedSmoothScroller", 4);
            $jacocoData = probes;
            return probes;
        }

        TopSnappedSmoothScroller(LinearLayoutManagerWithSmoothScroller linearLayoutManagerWithSmoothScroller, Context context) {
            boolean[] $jacocoInit = $jacocoInit();
            this.this$0 = linearLayoutManagerWithSmoothScroller;
            $jacocoInit[0] = true;
            super(context);
            $jacocoInit[1] = true;
        }

        /* access modifiers changed from: protected */
        public int getVerticalSnapPreference() {
            $jacocoInit()[2] = true;
            return -1;
        }

        public PointF computeScrollVectorForPosition(int targetPosition) {
            boolean[] $jacocoInit = $jacocoInit();
            PointF computeScrollVectorForPosition = this.this$0.computeScrollVectorForPosition(targetPosition);
            $jacocoInit[3] = true;
            return computeScrollVectorForPosition;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-558202406936904729L, "cm/aptoide/pt/view/recycler/LinearLayoutManagerWithSmoothScroller", 6);
        $jacocoData = probes;
        return probes;
    }

    public LinearLayoutManagerWithSmoothScroller(Context context) {
        boolean[] $jacocoInit = $jacocoInit();
        super(context, 1, false);
        $jacocoInit[0] = true;
    }

    public LinearLayoutManagerWithSmoothScroller(Context context, int orientation, boolean reverseLayout) {
        boolean[] $jacocoInit = $jacocoInit();
        super(context, orientation, reverseLayout);
        $jacocoInit[1] = true;
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, C0997t state, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[2] = true;
        C0994s smoothScroller = new TopSnappedSmoothScroller(this, recyclerView.getContext());
        $jacocoInit[3] = true;
        smoothScroller.setTargetPosition(position);
        $jacocoInit[4] = true;
        startSmoothScroll(smoothScroller);
        $jacocoInit[5] = true;
    }
}
