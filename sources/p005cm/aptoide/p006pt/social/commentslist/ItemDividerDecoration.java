package p005cm.aptoide.p006pt.social.commentslist;

import android.graphics.Rect;
import android.support.p001v7.widget.RecyclerView;
import android.support.p001v7.widget.RecyclerView.C0980h;
import android.support.p001v7.widget.RecyclerView.C0997t;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.social.commentslist.ItemDividerDecoration */
class ItemDividerDecoration extends C0980h {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final DisplayMetrics displayMetrics;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4546975539219776662L, "cm/aptoide/pt/social/commentslist/ItemDividerDecoration", 5);
        $jacocoData = probes;
        return probes;
    }

    public ItemDividerDecoration(DisplayMetrics displayMetrics2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.displayMetrics = displayMetrics2;
        $jacocoInit[0] = true;
    }

    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, C0997t state) {
        boolean[] $jacocoInit = $jacocoInit();
        int top = 0;
        int bottom = 0;
        int left = 0;
        int right = 0;
        DisplayMetrics displayMetrics2 = this.displayMetrics;
        if (displayMetrics2 == null) {
            $jacocoInit[1] = true;
        } else {
            $jacocoInit[2] = true;
            int offset = (int) TypedValue.applyDimension(1, 0.5f, displayMetrics2);
            top = offset;
            bottom = offset;
            left = offset;
            right = offset;
            $jacocoInit[3] = true;
        }
        outRect.set(left, top, right, bottom);
        $jacocoInit[4] = true;
    }
}
