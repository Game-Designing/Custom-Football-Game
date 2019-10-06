package p005cm.aptoide.p006pt.view.custom;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.p001v7.widget.RecyclerView;
import android.support.p001v7.widget.RecyclerView.C0980h;
import android.support.p001v7.widget.RecyclerView.C0984j;
import android.support.p001v7.widget.RecyclerView.C0997t;
import android.view.View;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.view.custom.DrawableItemDecoration */
class DrawableItemDecoration extends C0980h {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final int customHorizontalPadding;
    private final Drawable dividerDrawable;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7915028899897473241L, "cm/aptoide/pt/view/custom/DrawableItemDecoration", 12);
        $jacocoData = probes;
        return probes;
    }

    DrawableItemDecoration(Drawable divider, int customHorizontalPadding2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.dividerDrawable = divider;
        this.customHorizontalPadding = customHorizontalPadding2;
        $jacocoInit[0] = true;
    }

    public void onDrawOver(Canvas canvas, RecyclerView parent, C0997t state) {
        boolean[] $jacocoInit = $jacocoInit();
        int left = this.customHorizontalPadding;
        $jacocoInit[1] = true;
        int right = parent.getWidth() - this.customHorizontalPadding;
        $jacocoInit[2] = true;
        int childCount = parent.getChildCount();
        int i = 0;
        $jacocoInit[3] = true;
        while (i < childCount - 1) {
            $jacocoInit[4] = true;
            View child = parent.getChildAt(i);
            $jacocoInit[5] = true;
            C0984j params = (C0984j) child.getLayoutParams();
            $jacocoInit[6] = true;
            int top = child.getBottom() + params.bottomMargin;
            $jacocoInit[7] = true;
            int bottom = this.dividerDrawable.getIntrinsicHeight() + top;
            $jacocoInit[8] = true;
            this.dividerDrawable.setBounds(left, top, right, bottom);
            $jacocoInit[9] = true;
            this.dividerDrawable.draw(canvas);
            i++;
            $jacocoInit[10] = true;
        }
        $jacocoInit[11] = true;
    }
}
