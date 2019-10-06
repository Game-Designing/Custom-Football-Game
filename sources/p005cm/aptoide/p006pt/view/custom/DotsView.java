package p005cm.aptoide.p006pt.view.custom;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.utils.AptoideUtils.MathU;

/* renamed from: cm.aptoide.pt.view.custom.DotsView */
public class DotsView extends View {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final int COLOR_1 = -16121;
    private static final int COLOR_2 = -26624;
    private static final int COLOR_3 = -43230;
    private static final int COLOR_4 = -769226;
    private static final int DOTS_COUNT = 7;
    public static final Property<DotsView, Float> DOTS_PROGRESS = new Property<DotsView, Float>(Float.class, "dotsProgress") {
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(4385502558595313778L, "cm/aptoide/pt/view/custom/DotsView$1", 5);
            $jacocoData = probes;
            return probes;
        }

        {
            boolean[] $jacocoInit = $jacocoInit();
            $jacocoInit[0] = true;
        }

        public /* bridge */ /* synthetic */ Object get(Object obj) {
            boolean[] $jacocoInit = $jacocoInit();
            Float f = get((DotsView) obj);
            $jacocoInit[3] = true;
            return f;
        }

        public /* bridge */ /* synthetic */ void set(Object obj, Object obj2) {
            boolean[] $jacocoInit = $jacocoInit();
            set((DotsView) obj, (Float) obj2);
            $jacocoInit[4] = true;
        }

        public void set(DotsView object, Float value) {
            boolean[] $jacocoInit = $jacocoInit();
            object.setCurrentProgress(value.floatValue());
            $jacocoInit[1] = true;
        }

        public Float get(DotsView object) {
            boolean[] $jacocoInit = $jacocoInit();
            Float valueOf = Float.valueOf(object.getCurrentProgress());
            $jacocoInit[2] = true;
            return valueOf;
        }
    };
    private static final int OUTER_DOTS_POSITION_ANGLE = 51;
    private ArgbEvaluator argbEvaluator;
    private int centerX;
    private int centerY;
    private final Paint[] circlePaints = new Paint[4];
    private float currentDotSize1 = 0.0f;
    private float currentDotSize2 = 0.0f;
    private float currentProgress = 0.0f;
    private float currentRadius1 = 0.0f;
    private float currentRadius2 = 0.0f;
    private float maxDotSize;
    private float maxInnerDotsRadius;
    private float maxOuterDotsRadius;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1761168245073249276L, "cm/aptoide/pt/view/custom/DotsView", 73);
        $jacocoData = probes;
        return probes;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[72] = true;
    }

    public DotsView(Context context) {
        boolean[] $jacocoInit = $jacocoInit();
        super(context);
        $jacocoInit[0] = true;
        this.argbEvaluator = new ArgbEvaluator();
        $jacocoInit[1] = true;
        init();
        $jacocoInit[2] = true;
    }

    public DotsView(Context context, AttributeSet attrs) {
        boolean[] $jacocoInit = $jacocoInit();
        super(context, attrs);
        $jacocoInit[3] = true;
        this.argbEvaluator = new ArgbEvaluator();
        $jacocoInit[4] = true;
        init();
        $jacocoInit[5] = true;
    }

    public DotsView(Context context, AttributeSet attrs, int defStyleAttr) {
        boolean[] $jacocoInit = $jacocoInit();
        super(context, attrs, defStyleAttr);
        $jacocoInit[6] = true;
        this.argbEvaluator = new ArgbEvaluator();
        $jacocoInit[7] = true;
        init();
        $jacocoInit[8] = true;
    }

    private void init() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = 0;
        $jacocoInit[9] = true;
        while (true) {
            Paint[] paintArr = this.circlePaints;
            if (i < paintArr.length) {
                $jacocoInit[10] = true;
                paintArr[i] = new Paint();
                $jacocoInit[11] = true;
                this.circlePaints[i].setStyle(Style.FILL);
                i++;
                $jacocoInit[12] = true;
            } else {
                $jacocoInit[13] = true;
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onSizeChanged(w, h, oldw, oldh);
        this.centerX = w / 2;
        this.centerY = h / 2;
        this.maxDotSize = 4.0f;
        this.maxOuterDotsRadius = (((float) w) / 2.3f) - (this.maxDotSize * 2.0f);
        this.maxInnerDotsRadius = this.maxOuterDotsRadius * 0.8f;
        $jacocoInit[14] = true;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        boolean[] $jacocoInit = $jacocoInit();
        drawOuterDotsFrame(canvas);
        $jacocoInit[15] = true;
        drawInnerDotsFrame(canvas);
        $jacocoInit[16] = true;
    }

    private void drawOuterDotsFrame(Canvas canvas) {
        boolean[] $jacocoInit = $jacocoInit();
        int i = 0;
        $jacocoInit[17] = true;
        while (i < 7) {
            $jacocoInit[18] = true;
            double d = (double) this.centerX;
            double d2 = (double) this.currentRadius1;
            double d3 = (double) (i * 51);
            Double.isNaN(d3);
            double cos = Math.cos((d3 * 3.141592653589793d) / 180.0d);
            Double.isNaN(d2);
            double d4 = d2 * cos;
            Double.isNaN(d);
            int cX = (int) (d + d4);
            $jacocoInit[19] = true;
            double d5 = (double) this.centerY;
            double d6 = (double) this.currentRadius1;
            double d7 = (double) (i * 51);
            Double.isNaN(d7);
            double sin = Math.sin((d7 * 3.141592653589793d) / 180.0d);
            Double.isNaN(d6);
            double d8 = d6 * sin;
            Double.isNaN(d5);
            int cY = (int) (d5 + d8);
            $jacocoInit[20] = true;
            float f = (float) cX;
            float f2 = (float) cY;
            float f3 = this.currentDotSize1;
            Paint[] paintArr = this.circlePaints;
            canvas.drawCircle(f, f2, f3, paintArr[i % paintArr.length]);
            i++;
            $jacocoInit[21] = true;
        }
        Canvas canvas2 = canvas;
        $jacocoInit[22] = true;
    }

    private void drawInnerDotsFrame(Canvas canvas) {
        boolean[] $jacocoInit = $jacocoInit();
        int i = 0;
        $jacocoInit[23] = true;
        while (i < 7) {
            $jacocoInit[24] = true;
            double d = (double) this.centerX;
            double d2 = (double) this.currentRadius2;
            double d3 = (double) ((i * 51) - 10);
            Double.isNaN(d3);
            double cos = Math.cos((d3 * 3.141592653589793d) / 180.0d);
            Double.isNaN(d2);
            double d4 = d2 * cos;
            Double.isNaN(d);
            int cX = (int) (d + d4);
            $jacocoInit[25] = true;
            double d5 = (double) this.centerY;
            double d6 = (double) this.currentRadius2;
            double d7 = (double) ((i * 51) - 10);
            Double.isNaN(d7);
            double sin = Math.sin((d7 * 3.141592653589793d) / 180.0d);
            Double.isNaN(d6);
            double d8 = d6 * sin;
            Double.isNaN(d5);
            int cY = (int) (d5 + d8);
            $jacocoInit[26] = true;
            float f = (float) cX;
            float f2 = (float) cY;
            float f3 = this.currentDotSize2;
            Paint[] paintArr = this.circlePaints;
            canvas.drawCircle(f, f2, f3, paintArr[(i + 1) % paintArr.length]);
            i++;
            $jacocoInit[27] = true;
        }
        Canvas canvas2 = canvas;
        $jacocoInit[28] = true;
    }

    public float getCurrentProgress() {
        boolean[] $jacocoInit = $jacocoInit();
        float f = this.currentProgress;
        $jacocoInit[29] = true;
        return f;
    }

    public void setCurrentProgress(float currentProgress2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.currentProgress = currentProgress2;
        $jacocoInit[30] = true;
        updateInnerDotsPosition();
        $jacocoInit[31] = true;
        updateOuterDotsPosition();
        $jacocoInit[32] = true;
        updateDotsPaints();
        $jacocoInit[33] = true;
        updateDotsAlpha();
        $jacocoInit[34] = true;
        postInvalidate();
        $jacocoInit[35] = true;
    }

    private void updateInnerDotsPosition() {
        boolean[] $jacocoInit = $jacocoInit();
        float f = this.currentProgress;
        if (f < 0.3f) {
            double d = (double) f;
            double d2 = (double) this.maxInnerDotsRadius;
            $jacocoInit[36] = true;
            this.currentRadius2 = (float) MathU.mapValueFromRangeToRange(d, 0.0d, 0.30000001192092896d, 0.0d, d2);
            $jacocoInit[37] = true;
        } else {
            this.currentRadius2 = this.maxInnerDotsRadius;
            $jacocoInit[38] = true;
        }
        float f2 = this.currentProgress;
        if (((double) f2) < 0.2d) {
            this.currentDotSize2 = this.maxDotSize;
            $jacocoInit[39] = true;
        } else if (((double) f2) < 0.5d) {
            double d3 = (double) f2;
            float f3 = this.maxDotSize;
            double d4 = (double) f3;
            double d5 = (double) f3;
            Double.isNaN(d5);
            double d6 = d5 * 0.3d;
            $jacocoInit[40] = true;
            this.currentDotSize2 = (float) MathU.mapValueFromRangeToRange(d3, 0.20000000298023224d, 0.5d, d4, d6);
            $jacocoInit[41] = true;
        } else {
            double d7 = (double) f2;
            double d8 = (double) (this.maxDotSize * 0.3f);
            $jacocoInit[42] = true;
            this.currentDotSize2 = (float) MathU.mapValueFromRangeToRange(d7, 0.5d, 1.0d, d8, 0.0d);
            $jacocoInit[43] = true;
        }
        $jacocoInit[44] = true;
    }

    private void updateOuterDotsPosition() {
        boolean[] $jacocoInit = $jacocoInit();
        float f = this.currentProgress;
        if (f < 0.3f) {
            double d = (double) f;
            double d2 = (double) (this.maxOuterDotsRadius * 0.8f);
            $jacocoInit[45] = true;
            this.currentRadius1 = (float) MathU.mapValueFromRangeToRange(d, 0.0d, 0.30000001192092896d, 0.0d, d2);
            $jacocoInit[46] = true;
        } else {
            double d3 = (double) f;
            float f2 = this.maxOuterDotsRadius;
            double d4 = (double) (0.8f * f2);
            double d5 = (double) f2;
            $jacocoInit[47] = true;
            this.currentRadius1 = (float) MathU.mapValueFromRangeToRange(d3, 0.30000001192092896d, 1.0d, d4, d5);
            $jacocoInit[48] = true;
        }
        float f3 = this.currentProgress;
        if (((double) f3) < 0.7d) {
            this.currentDotSize1 = this.maxDotSize;
            $jacocoInit[49] = true;
        } else {
            double d6 = (double) f3;
            double d7 = (double) this.maxDotSize;
            $jacocoInit[50] = true;
            this.currentDotSize1 = (float) MathU.mapValueFromRangeToRange(d6, 0.699999988079071d, 1.0d, d7, 0.0d);
            $jacocoInit[51] = true;
        }
        $jacocoInit[52] = true;
    }

    private void updateDotsPaints() {
        boolean[] $jacocoInit = $jacocoInit();
        float f = this.currentProgress;
        Integer valueOf = Integer.valueOf(COLOR_1);
        Integer valueOf2 = Integer.valueOf(COLOR_4);
        Integer valueOf3 = Integer.valueOf(COLOR_3);
        Integer valueOf4 = Integer.valueOf(COLOR_2);
        if (f < 0.5f) {
            double d = (double) f;
            $jacocoInit[53] = true;
            float progress = (float) MathU.mapValueFromRangeToRange(d, 0.0d, 0.5d, 0.0d, 1.0d);
            $jacocoInit[54] = true;
            this.circlePaints[0].setColor(((Integer) this.argbEvaluator.evaluate(progress, valueOf, valueOf4)).intValue());
            $jacocoInit[55] = true;
            this.circlePaints[1].setColor(((Integer) this.argbEvaluator.evaluate(progress, valueOf4, valueOf3)).intValue());
            $jacocoInit[56] = true;
            this.circlePaints[2].setColor(((Integer) this.argbEvaluator.evaluate(progress, valueOf3, valueOf2)).intValue());
            $jacocoInit[57] = true;
            this.circlePaints[3].setColor(((Integer) this.argbEvaluator.evaluate(progress, valueOf2, valueOf)).intValue());
            $jacocoInit[58] = true;
        } else {
            double d2 = (double) f;
            $jacocoInit[59] = true;
            float progress2 = (float) MathU.mapValueFromRangeToRange(d2, 0.5d, 1.0d, 0.0d, 1.0d);
            $jacocoInit[60] = true;
            this.circlePaints[0].setColor(((Integer) this.argbEvaluator.evaluate(progress2, valueOf4, valueOf3)).intValue());
            $jacocoInit[61] = true;
            this.circlePaints[1].setColor(((Integer) this.argbEvaluator.evaluate(progress2, valueOf3, valueOf2)).intValue());
            $jacocoInit[62] = true;
            this.circlePaints[2].setColor(((Integer) this.argbEvaluator.evaluate(progress2, valueOf2, valueOf)).intValue());
            $jacocoInit[63] = true;
            this.circlePaints[3].setColor(((Integer) this.argbEvaluator.evaluate(progress2, valueOf, valueOf4)).intValue());
            $jacocoInit[64] = true;
        }
        $jacocoInit[65] = true;
    }

    private void updateDotsAlpha() {
        boolean[] $jacocoInit = $jacocoInit();
        float progress = (float) MathU.clamp((double) this.currentProgress, 0.6000000238418579d, 1.0d);
        $jacocoInit[66] = true;
        int alpha = (int) MathU.mapValueFromRangeToRange((double) progress, 0.6000000238418579d, 1.0d, 255.0d, 0.0d);
        $jacocoInit[67] = true;
        this.circlePaints[0].setAlpha(alpha);
        $jacocoInit[68] = true;
        this.circlePaints[1].setAlpha(alpha);
        $jacocoInit[69] = true;
        this.circlePaints[2].setAlpha(alpha);
        $jacocoInit[70] = true;
        this.circlePaints[3].setAlpha(alpha);
        $jacocoInit[71] = true;
    }
}
