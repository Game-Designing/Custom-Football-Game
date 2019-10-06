package p005cm.aptoide.p006pt.view.custom;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.p001v7.widget.RecyclerView;
import android.support.p001v7.widget.RecyclerView.C0980h;
import android.support.p001v7.widget.RecyclerView.C0997t;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.view.custom.SimpleDividerItemDecoration */
public class SimpleDividerItemDecoration extends C0980h {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final int space;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8346852896074411370L, "cm/aptoide/pt/view/custom/SimpleDividerItemDecoration", 6);
        $jacocoData = probes;
        return probes;
    }

    public SimpleDividerItemDecoration(Context context, int spaceInDips) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[0] = true;
        this.space = getPixelsFromDips(context, spaceInDips);
        $jacocoInit[1] = true;
    }

    private int getPixelsFromDips(Context context, int dipValue) {
        boolean[] $jacocoInit = $jacocoInit();
        Resources r = context.getResources();
        float f = (float) dipValue;
        $jacocoInit[2] = true;
        DisplayMetrics displayMetrics = r.getDisplayMetrics();
        $jacocoInit[3] = true;
        int applyDimension = (int) TypedValue.applyDimension(1, f, displayMetrics);
        $jacocoInit[4] = true;
        return applyDimension;
    }

    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, C0997t state) {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.space;
        outRect.right = i;
        outRect.left = i;
        outRect.bottom = i;
        outRect.top = i;
        $jacocoInit[5] = true;
    }
}
