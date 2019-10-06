package p005cm.aptoide.p006pt.view.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.support.p000v4.content.C0510b;
import android.support.p001v7.widget.RecyclerView;
import android.support.p001v7.widget.RecyclerView.C0997t;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;

/* renamed from: cm.aptoide.pt.view.custom.HorizontalDividerItemDecoration */
public class HorizontalDividerItemDecoration extends DrawableItemDecoration {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6597862843424982335L, "cm/aptoide/pt/view/custom/HorizontalDividerItemDecoration", 3);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void onDrawOver(Canvas canvas, RecyclerView recyclerView, C0997t tVar) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onDrawOver(canvas, recyclerView, tVar);
        $jacocoInit[2] = true;
    }

    public HorizontalDividerItemDecoration(Context context) {
        boolean[] $jacocoInit = $jacocoInit();
        this(context, 0);
        $jacocoInit[0] = true;
    }

    public HorizontalDividerItemDecoration(Context context, int customHorizontalPadding) {
        boolean[] $jacocoInit = $jacocoInit();
        super(C0510b.m2572c(context, C1375R.drawable.gray_item_decorator), customHorizontalPadding);
        $jacocoInit[1] = true;
    }
}
