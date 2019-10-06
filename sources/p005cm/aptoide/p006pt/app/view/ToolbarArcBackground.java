package p005cm.aptoide.p006pt.app.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;

/* renamed from: cm.aptoide.pt.app.view.ToolbarArcBackground */
public class ToolbarArcBackground extends View {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private float extenderOverBoundary = 250.0f;
    private Paint paint;
    private RectF rectF;
    private float scale = 0.0f;
    private float strokeWidth = 200.0f;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(812704520359747797L, "cm/aptoide/pt/app/view/ToolbarArcBackground", 28);
        $jacocoData = probes;
        return probes;
    }

    public ToolbarArcBackground(Context context) {
        boolean[] $jacocoInit = $jacocoInit();
        super(context);
        $jacocoInit[0] = true;
        this.paint = new Paint(1);
        $jacocoInit[1] = true;
        this.rectF = new RectF();
        $jacocoInit[2] = true;
        Paint paint2 = this.paint;
        Resources resources = context.getResources();
        $jacocoInit[3] = true;
        int color = resources.getColor(C1375R.color.white);
        $jacocoInit[4] = true;
        paint2.setColor(color);
        $jacocoInit[5] = true;
    }

    public ToolbarArcBackground(Context context, AttributeSet attrs) {
        boolean[] $jacocoInit = $jacocoInit();
        super(context, attrs);
        $jacocoInit[6] = true;
        this.paint = new Paint(1);
        $jacocoInit[7] = true;
        this.rectF = new RectF();
        $jacocoInit[8] = true;
        Paint paint2 = this.paint;
        Resources resources = context.getResources();
        $jacocoInit[9] = true;
        int color = resources.getColor(C1375R.color.white);
        $jacocoInit[10] = true;
        paint2.setColor(color);
        $jacocoInit[11] = true;
    }

    public ToolbarArcBackground(Context context, AttributeSet attrs, int defStyleAttr) {
        boolean[] $jacocoInit = $jacocoInit();
        super(context, attrs, defStyleAttr);
        $jacocoInit[12] = true;
        this.paint = new Paint(1);
        $jacocoInit[13] = true;
        this.rectF = new RectF();
        $jacocoInit[14] = true;
        Paint paint2 = this.paint;
        Resources resources = context.getResources();
        $jacocoInit[15] = true;
        int color = resources.getColor(C1375R.color.white);
        $jacocoInit[16] = true;
        paint2.setColor(color);
        $jacocoInit[17] = true;
    }

    public void setScale(float scale2) {
        boolean[] $jacocoInit = $jacocoInit();
        float f = 0.0f;
        if (scale2 < 0.0f) {
            $jacocoInit[18] = true;
        } else {
            $jacocoInit[19] = true;
            f = scale2;
        }
        this.scale = f;
        $jacocoInit[20] = true;
        invalidate();
        $jacocoInit[21] = true;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onDraw(canvas);
        $jacocoInit[22] = true;
        this.paint.setStyle(Style.STROKE);
        $jacocoInit[23] = true;
        this.paint.setStrokeWidth(this.strokeWidth);
        $jacocoInit[24] = true;
        float f = -this.extenderOverBoundary;
        float height = (((float) getHeight()) + (this.strokeWidth / 2.0f)) * this.scale;
        $jacocoInit[25] = true;
        this.rectF = new RectF(f, height, ((float) getWidth()) + this.extenderOverBoundary, ((float) getHeight()) + (this.strokeWidth / 2.0f));
        $jacocoInit[26] = true;
        canvas.drawArc(this.rectF, 0.0f, 180.0f, false, this.paint);
        $jacocoInit[27] = true;
    }
}
