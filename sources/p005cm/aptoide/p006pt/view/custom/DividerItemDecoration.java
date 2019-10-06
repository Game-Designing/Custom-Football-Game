package p005cm.aptoide.p006pt.view.custom;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.p001v7.widget.GridLayoutManager;
import android.support.p001v7.widget.LinearLayoutManager;
import android.support.p001v7.widget.RecyclerView;
import android.support.p001v7.widget.RecyclerView.C0980h;
import android.support.p001v7.widget.RecyclerView.C0981i;
import android.support.p001v7.widget.RecyclerView.C0997t;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.view.custom.DividerItemDecoration */
public class DividerItemDecoration extends C0980h {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final int ALL = 7;
    public static final int BOTTOM = 4;
    public static final int LEFT = 1;
    public static final int RIGHT = 2;
    private final int space;
    private final int spacingFlag;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8244288017793812067L, "cm/aptoide/pt/view/custom/DividerItemDecoration", 28);
        $jacocoData = probes;
        return probes;
    }

    public DividerItemDecoration(Context context, float space2) {
        boolean[] $jacocoInit = $jacocoInit();
        this(context, space2, 7);
        $jacocoInit[0] = true;
    }

    public DividerItemDecoration(Context context, float spaceInDips, int spacingFlag2) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[1] = true;
        this.space = getPixelsFromDips(context, spaceInDips);
        this.spacingFlag = spacingFlag2;
        $jacocoInit[2] = true;
    }

    private int getPixelsFromDips(Context context, float dipValue) {
        boolean[] $jacocoInit = $jacocoInit();
        Resources r = context.getResources();
        $jacocoInit[3] = true;
        DisplayMetrics displayMetrics = r.getDisplayMetrics();
        $jacocoInit[4] = true;
        int applyDimension = (int) TypedValue.applyDimension(1, dipValue, displayMetrics);
        $jacocoInit[5] = true;
        return applyDimension;
    }

    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, C0997t state) {
        boolean[] $jacocoInit = $jacocoInit();
        if ((this.spacingFlag & 1) != 1) {
            $jacocoInit[6] = true;
        } else {
            outRect.left = this.space;
            $jacocoInit[7] = true;
        }
        if ((this.spacingFlag & 2) != 2) {
            $jacocoInit[8] = true;
        } else {
            outRect.right = this.space;
            $jacocoInit[9] = true;
        }
        if ((this.spacingFlag & 4) != 4) {
            $jacocoInit[10] = true;
        } else {
            outRect.bottom = this.space;
            $jacocoInit[11] = true;
        }
        C0981i parentLayoutManager = parent.getLayoutManager();
        if (parentLayoutManager instanceof LinearLayoutManager) {
            LinearLayoutManager manager = (LinearLayoutManager) parentLayoutManager;
            $jacocoInit[12] = true;
            if (manager.getOrientation() != 1) {
                $jacocoInit[13] = true;
            } else {
                $jacocoInit[14] = true;
                if (manager.getPosition(view) != 0) {
                    $jacocoInit[15] = true;
                } else {
                    outRect.top = this.space;
                    $jacocoInit[16] = true;
                }
            }
            $jacocoInit[17] = true;
        } else if (GridLayoutManager.class.isAssignableFrom(parentLayoutManager.getClass())) {
            GridLayoutManager manager2 = (GridLayoutManager) parentLayoutManager;
            $jacocoInit[18] = true;
            if (manager2.getOrientation() != 1) {
                $jacocoInit[19] = true;
            } else {
                $jacocoInit[20] = true;
                int colcount = manager2.getSpanCount();
                $jacocoInit[21] = true;
                if (parent.mo7611h(view) >= colcount) {
                    $jacocoInit[22] = true;
                } else {
                    outRect.top = this.space;
                    $jacocoInit[23] = true;
                }
            }
            $jacocoInit[24] = true;
        } else if (parent.mo7611h(view) != 0) {
            $jacocoInit[25] = true;
        } else {
            outRect.top = this.space;
            $jacocoInit[26] = true;
        }
        $jacocoInit[27] = true;
    }
}
