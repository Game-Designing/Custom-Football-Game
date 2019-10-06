package p005cm.aptoide.p006pt.view.custom;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.utils.AptoideUtils.MathU;

/* renamed from: cm.aptoide.pt.view.custom.CircleView */
public class CircleView extends View {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final int END_COLOR = -16121;
    public static final Property<CircleView, Float> INNER_CIRCLE_RADIUS_PROGRESS = new Property<CircleView, Float>(Float.class, "innerCircleRadiusProgress") {
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(126299529053918636L, "cm/aptoide/pt/view/custom/CircleView$1", 5);
            $jacocoData = probes;
            return probes;
        }

        {
            boolean[] $jacocoInit = $jacocoInit();
            $jacocoInit[0] = true;
        }

        public /* bridge */ /* synthetic */ Object get(Object obj) {
            boolean[] $jacocoInit = $jacocoInit();
            Float f = get((CircleView) obj);
            $jacocoInit[3] = true;
            return f;
        }

        public /* bridge */ /* synthetic */ void set(Object obj, Object obj2) {
            boolean[] $jacocoInit = $jacocoInit();
            set((CircleView) obj, (Float) obj2);
            $jacocoInit[4] = true;
        }

        public void set(CircleView object, Float value) {
            boolean[] $jacocoInit = $jacocoInit();
            object.setInnerCircleRadiusProgress(value.floatValue());
            $jacocoInit[1] = true;
        }

        public Float get(CircleView object) {
            boolean[] $jacocoInit = $jacocoInit();
            Float valueOf = Float.valueOf(object.getInnerCircleRadiusProgress());
            $jacocoInit[2] = true;
            return valueOf;
        }
    };
    public static final Property<CircleView, Float> OUTER_CIRCLE_RADIUS_PROGRESS = new Property<CircleView, Float>(Float.class, "outerCircleRadiusProgress") {
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(7141941208428802874L, "cm/aptoide/pt/view/custom/CircleView$2", 5);
            $jacocoData = probes;
            return probes;
        }

        {
            boolean[] $jacocoInit = $jacocoInit();
            $jacocoInit[0] = true;
        }

        public /* bridge */ /* synthetic */ Object get(Object obj) {
            boolean[] $jacocoInit = $jacocoInit();
            Float f = get((CircleView) obj);
            $jacocoInit[3] = true;
            return f;
        }

        public /* bridge */ /* synthetic */ void set(Object obj, Object obj2) {
            boolean[] $jacocoInit = $jacocoInit();
            set((CircleView) obj, (Float) obj2);
            $jacocoInit[4] = true;
        }

        public Float get(CircleView object) {
            boolean[] $jacocoInit = $jacocoInit();
            Float valueOf = Float.valueOf(object.getOuterCircleRadiusProgress());
            $jacocoInit[1] = true;
            return valueOf;
        }

        public void set(CircleView object, Float value) {
            boolean[] $jacocoInit = $jacocoInit();
            object.setOuterCircleRadiusProgress(value.floatValue());
            $jacocoInit[2] = true;
        }
    };
    private static final int START_COLOR = -43230;
    private ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    private Paint circlePaint;
    private float innerCircleRadiusProgress;
    private Paint maskPaint;
    private int maxCircleSize;
    private float outerCircleRadiusProgress;
    private Bitmap tempBitmap;
    private Canvas tempCanvas;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8684014863396833916L, "cm/aptoide/pt/view/custom/CircleView", 38);
        $jacocoData = probes;
        return probes;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[36] = true;
        $jacocoInit[37] = true;
    }

    public CircleView(Context context) {
        boolean[] $jacocoInit = $jacocoInit();
        super(context);
        $jacocoInit[0] = true;
        $jacocoInit[1] = true;
        this.circlePaint = new Paint();
        $jacocoInit[2] = true;
        this.maskPaint = new Paint();
        this.outerCircleRadiusProgress = 0.0f;
        this.innerCircleRadiusProgress = 0.0f;
        $jacocoInit[3] = true;
        init();
        $jacocoInit[4] = true;
    }

    public CircleView(Context context, AttributeSet attrs) {
        boolean[] $jacocoInit = $jacocoInit();
        super(context, attrs);
        $jacocoInit[5] = true;
        $jacocoInit[6] = true;
        this.circlePaint = new Paint();
        $jacocoInit[7] = true;
        this.maskPaint = new Paint();
        this.outerCircleRadiusProgress = 0.0f;
        this.innerCircleRadiusProgress = 0.0f;
        $jacocoInit[8] = true;
        init();
        $jacocoInit[9] = true;
    }

    public CircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        boolean[] $jacocoInit = $jacocoInit();
        super(context, attrs, defStyleAttr);
        $jacocoInit[10] = true;
        $jacocoInit[11] = true;
        this.circlePaint = new Paint();
        $jacocoInit[12] = true;
        this.maskPaint = new Paint();
        this.outerCircleRadiusProgress = 0.0f;
        this.innerCircleRadiusProgress = 0.0f;
        $jacocoInit[13] = true;
        init();
        $jacocoInit[14] = true;
    }

    private void init() {
        boolean[] $jacocoInit = $jacocoInit();
        this.circlePaint.setStyle(Style.FILL);
        $jacocoInit[15] = true;
        this.maskPaint.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
        $jacocoInit[16] = true;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onSizeChanged(w, h, oldw, oldh);
        this.maxCircleSize = w / 2;
        $jacocoInit[17] = true;
        this.tempBitmap = Bitmap.createBitmap(getWidth(), getWidth(), Config.ARGB_8888);
        $jacocoInit[18] = true;
        this.tempCanvas = new Canvas(this.tempBitmap);
        $jacocoInit[19] = true;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onDraw(canvas);
        $jacocoInit[20] = true;
        this.tempCanvas.drawColor(16777215, Mode.CLEAR);
        $jacocoInit[21] = true;
        this.tempCanvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), this.outerCircleRadiusProgress * ((float) this.maxCircleSize), this.circlePaint);
        $jacocoInit[22] = true;
        this.tempCanvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), this.innerCircleRadiusProgress * ((float) this.maxCircleSize), this.maskPaint);
        $jacocoInit[23] = true;
        canvas.drawBitmap(this.tempBitmap, 0.0f, 0.0f, null);
        $jacocoInit[24] = true;
    }

    public float getInnerCircleRadiusProgress() {
        boolean[] $jacocoInit = $jacocoInit();
        float f = this.innerCircleRadiusProgress;
        $jacocoInit[25] = true;
        return f;
    }

    public void setInnerCircleRadiusProgress(float innerCircleRadiusProgress2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.innerCircleRadiusProgress = innerCircleRadiusProgress2;
        $jacocoInit[26] = true;
        postInvalidate();
        $jacocoInit[27] = true;
    }

    public float getOuterCircleRadiusProgress() {
        boolean[] $jacocoInit = $jacocoInit();
        float f = this.outerCircleRadiusProgress;
        $jacocoInit[28] = true;
        return f;
    }

    public void setOuterCircleRadiusProgress(float outerCircleRadiusProgress2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.outerCircleRadiusProgress = outerCircleRadiusProgress2;
        $jacocoInit[29] = true;
        updateCircleColor();
        $jacocoInit[30] = true;
        postInvalidate();
        $jacocoInit[31] = true;
    }

    private void updateCircleColor() {
        boolean[] $jacocoInit = $jacocoInit();
        double clamp = (double) ((float) MathU.clamp((double) this.outerCircleRadiusProgress, 0.5d, 1.0d));
        $jacocoInit[32] = true;
        float colorProgress = (float) MathU.mapValueFromRangeToRange(clamp, 0.5d, 1.0d, 0.0d, 1.0d);
        Paint paint = this.circlePaint;
        ArgbEvaluator argbEvaluator2 = this.argbEvaluator;
        $jacocoInit[33] = true;
        int intValue = ((Integer) argbEvaluator2.evaluate(colorProgress, Integer.valueOf(START_COLOR), Integer.valueOf(END_COLOR))).intValue();
        $jacocoInit[34] = true;
        paint.setColor(intValue);
        $jacocoInit[35] = true;
    }
}
