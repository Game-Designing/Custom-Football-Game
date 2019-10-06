package p005cm.aptoide.p006pt.view.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.p001v7.widget.LinearLayoutManager;
import android.support.p001v7.widget.RecyclerView;
import android.support.p001v7.widget.RecyclerView.C0980h;
import android.support.p001v7.widget.RecyclerView.C0997t;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.view.custom.HorizontalHeaderItemDecoration */
public class HorizontalHeaderItemDecoration extends C0980h {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final float PARALLAX_RATIO = 0.3f;
    private static final int VERTICAL_OFFSET = 20;
    private int headerSize;
    private View layout;
    private int margin;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(566339129044207327L, "cm/aptoide/pt/view/custom/HorizontalHeaderItemDecoration", 36);
        $jacocoData = probes;
        return probes;
    }

    public HorizontalHeaderItemDecoration(Context context, RecyclerView parent, int resId, int headerSize2, int margin2) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[0] = true;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        $jacocoInit[1] = true;
        parent.setLayoutManager(linearLayoutManager);
        $jacocoInit[2] = true;
        LayoutInflater from = LayoutInflater.from(context);
        $jacocoInit[3] = true;
        this.layout = from.inflate(resId, parent, false);
        $jacocoInit[4] = true;
        View view = this.layout;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        $jacocoInit[5] = true;
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
        $jacocoInit[6] = true;
        view.measure(makeMeasureSpec, makeMeasureSpec2);
        this.headerSize = headerSize2;
        this.margin = margin2;
        $jacocoInit[7] = true;
        View view2 = this.layout;
        view2.layout(0, 0, view2.getMeasuredWidth(), this.layout.getMeasuredHeight());
        $jacocoInit[8] = true;
    }

    public void onDraw(Canvas c, RecyclerView parent, C0997t state) {
        Canvas canvas = c;
        RecyclerView recyclerView = parent;
        boolean[] $jacocoInit = $jacocoInit();
        super.onDraw(c, parent, state);
        boolean foundFirstChild = false;
        float viewVerticalCenter = 0.0f;
        float left = 0.0f;
        $jacocoInit[9] = true;
        float limit = -(((float) this.layout.getMeasuredWidth()) / 2.0f);
        float f = ((float) this.headerSize) / 2.0f;
        View view = this.layout;
        $jacocoInit[10] = true;
        float initialPosition = ((f - (((float) view.getMeasuredWidth()) / 2.0f)) - (((float) this.margin) / 2.0f)) * PARALLAX_RATIO;
        $jacocoInit[11] = true;
        int i = 0;
        $jacocoInit[12] = true;
        while (true) {
            if (i >= parent.getChildCount()) {
                $jacocoInit[13] = true;
                break;
            }
            $jacocoInit[14] = true;
            View view2 = recyclerView.getChildAt(i);
            if (viewVerticalCenter != 0.0f) {
                $jacocoInit[15] = true;
            } else {
                $jacocoInit[16] = true;
                float viewVerticalCenter2 = (((float) view2.getTop()) + (((float) view2.getMeasuredHeight()) / 2.0f)) - (((float) this.layout.getMeasuredWidth()) / 2.0f);
                $jacocoInit[17] = true;
                viewVerticalCenter = viewVerticalCenter2;
            }
            if (recyclerView.mo7583f(view2) == 0) {
                $jacocoInit[18] = true;
                float left2 = (((((float) view2.getLeft()) - (((float) this.headerSize) / 2.0f)) - (((float) this.layout.getMeasuredWidth()) / 2.0f)) - (((float) this.margin) / 2.0f)) * PARALLAX_RATIO;
                if (left2 >= limit) {
                    $jacocoInit[19] = true;
                    left = left2;
                } else {
                    left = limit;
                    $jacocoInit[20] = true;
                }
                foundFirstChild = true;
                $jacocoInit[21] = true;
            } else {
                i++;
                $jacocoInit[22] = true;
            }
        }
        if (foundFirstChild) {
            $jacocoInit[23] = true;
        } else {
            left = limit;
            $jacocoInit[24] = true;
        }
        int movementPercentage = Math.max((int) (getPercentage(limit, initialPosition, left) * 255.0f), 1);
        $jacocoInit[25] = true;
        c.save();
        $jacocoInit[26] = true;
        canvas.saveLayerAlpha(new RectF(0.0f, 0.0f, (float) (this.headerSize - 2), (float) c.getHeight()), movementPercentage, 31);
        $jacocoInit[27] = true;
        canvas.translate(left, viewVerticalCenter - 20.0f);
        $jacocoInit[28] = true;
        this.layout.draw(canvas);
        $jacocoInit[29] = true;
        c.restore();
        $jacocoInit[30] = true;
    }

    private float getPercentage(float minimum, float maximum, float actualValue) {
        float f = (actualValue - minimum) / (maximum - minimum);
        $jacocoInit()[31] = true;
        return f;
    }

    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, C0997t state) {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.margin;
        outRect.set(i, i, 0, i);
        $jacocoInit[32] = true;
        if (parent.mo7583f(view) != 0) {
            $jacocoInit[33] = true;
        } else {
            outRect.left = this.headerSize;
            $jacocoInit[34] = true;
        }
        $jacocoInit[35] = true;
    }
}
