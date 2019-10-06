package p005cm.aptoide.p006pt.networking.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import com.bumptech.glide.C5926c;
import com.bumptech.glide.load.C6352n;
import com.bumptech.glide.load.engine.C6236E;
import com.bumptech.glide.load.engine.p120a.C6250e;
import com.bumptech.glide.load.p113c.p114a.C6150d;
import java.security.MessageDigest;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.networking.image.RoundedCornersTransform */
public class RoundedCornersTransform implements C6352n<Bitmap> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private C6250e mBitmapPool;
    private CornerType mCornerType;
    private int mDiameter;
    private int mMargin;
    private int mRadius;

    /* renamed from: cm.aptoide.pt.networking.image.RoundedCornersTransform$1 */
    static /* synthetic */ class C41521 {

        /* renamed from: $SwitchMap$cm$aptoide$pt$networking$image$RoundedCornersTransform$CornerType */
        static final /* synthetic */ int[] f7699x1f5f81cf = new int[CornerType.values().length];
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(-8350066169274424386L, "cm/aptoide/pt/networking/image/RoundedCornersTransform$1", 32);
            $jacocoData = probes;
            return probes;
        }

        static {
            boolean[] $jacocoInit = $jacocoInit();
            try {
                $jacocoInit[0] = true;
                f7699x1f5f81cf[CornerType.ALL.ordinal()] = 1;
                $jacocoInit[1] = true;
            } catch (NoSuchFieldError e) {
                try {
                    $jacocoInit[2] = true;
                } catch (NoSuchFieldError e2) {
                    try {
                        $jacocoInit[4] = true;
                    } catch (NoSuchFieldError e3) {
                        try {
                            $jacocoInit[6] = true;
                        } catch (NoSuchFieldError e4) {
                            try {
                                $jacocoInit[8] = true;
                            } catch (NoSuchFieldError e5) {
                                try {
                                    $jacocoInit[10] = true;
                                } catch (NoSuchFieldError e6) {
                                    try {
                                        $jacocoInit[12] = true;
                                    } catch (NoSuchFieldError e7) {
                                        try {
                                            $jacocoInit[14] = true;
                                        } catch (NoSuchFieldError e8) {
                                            try {
                                                $jacocoInit[16] = true;
                                            } catch (NoSuchFieldError e9) {
                                                try {
                                                    $jacocoInit[18] = true;
                                                } catch (NoSuchFieldError e10) {
                                                    try {
                                                        $jacocoInit[20] = true;
                                                    } catch (NoSuchFieldError e11) {
                                                        try {
                                                            $jacocoInit[22] = true;
                                                        } catch (NoSuchFieldError e12) {
                                                            try {
                                                                $jacocoInit[24] = true;
                                                            } catch (NoSuchFieldError e13) {
                                                                try {
                                                                    $jacocoInit[26] = true;
                                                                } catch (NoSuchFieldError e14) {
                                                                    try {
                                                                        $jacocoInit[28] = true;
                                                                    } catch (NoSuchFieldError e15) {
                                                                        $jacocoInit[30] = true;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            f7699x1f5f81cf[CornerType.TOP_LEFT.ordinal()] = 2;
            $jacocoInit[3] = true;
            f7699x1f5f81cf[CornerType.TOP_RIGHT.ordinal()] = 3;
            $jacocoInit[5] = true;
            f7699x1f5f81cf[CornerType.BOTTOM_LEFT.ordinal()] = 4;
            $jacocoInit[7] = true;
            f7699x1f5f81cf[CornerType.BOTTOM_RIGHT.ordinal()] = 5;
            $jacocoInit[9] = true;
            f7699x1f5f81cf[CornerType.TOP.ordinal()] = 6;
            $jacocoInit[11] = true;
            f7699x1f5f81cf[CornerType.BOTTOM.ordinal()] = 7;
            $jacocoInit[13] = true;
            f7699x1f5f81cf[CornerType.LEFT.ordinal()] = 8;
            $jacocoInit[15] = true;
            f7699x1f5f81cf[CornerType.RIGHT.ordinal()] = 9;
            $jacocoInit[17] = true;
            f7699x1f5f81cf[CornerType.OTHER_TOP_LEFT.ordinal()] = 10;
            $jacocoInit[19] = true;
            f7699x1f5f81cf[CornerType.OTHER_TOP_RIGHT.ordinal()] = 11;
            $jacocoInit[21] = true;
            f7699x1f5f81cf[CornerType.OTHER_BOTTOM_LEFT.ordinal()] = 12;
            $jacocoInit[23] = true;
            f7699x1f5f81cf[CornerType.OTHER_BOTTOM_RIGHT.ordinal()] = 13;
            $jacocoInit[25] = true;
            f7699x1f5f81cf[CornerType.DIAGONAL_FROM_TOP_LEFT.ordinal()] = 14;
            $jacocoInit[27] = true;
            f7699x1f5f81cf[CornerType.DIAGONAL_FROM_TOP_RIGHT.ordinal()] = 15;
            $jacocoInit[29] = true;
            $jacocoInit[31] = true;
        }
    }

    /* renamed from: cm.aptoide.pt.networking.image.RoundedCornersTransform$CornerType */
    public enum CornerType {
        ALL,
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_RIGHT,
        TOP,
        BOTTOM,
        LEFT,
        RIGHT,
        OTHER_TOP_LEFT,
        OTHER_TOP_RIGHT,
        OTHER_BOTTOM_LEFT,
        OTHER_BOTTOM_RIGHT,
        DIAGONAL_FROM_TOP_LEFT,
        DIAGONAL_FROM_TOP_RIGHT;

        static {
            boolean[] $jacocoInit;
            $jacocoInit[3] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7338931448105775846L, "cm/aptoide/pt/networking/image/RoundedCornersTransform", 79);
        $jacocoData = probes;
        return probes;
    }

    public RoundedCornersTransform(Context context, int radius, int margin) {
        boolean[] $jacocoInit = $jacocoInit();
        this(context, radius, margin, CornerType.ALL);
        $jacocoInit[0] = true;
    }

    public RoundedCornersTransform(C6250e pool, int radius, int margin) {
        boolean[] $jacocoInit = $jacocoInit();
        this(pool, radius, margin, CornerType.ALL);
        $jacocoInit[1] = true;
    }

    public RoundedCornersTransform(Context context, int radius, int margin, CornerType cornerType) {
        boolean[] $jacocoInit = $jacocoInit();
        C5926c a = C5926c.m10916a(context);
        $jacocoInit[2] = true;
        C6250e c = a.mo18581c();
        $jacocoInit[3] = true;
        this(c, radius, margin, cornerType);
        $jacocoInit[4] = true;
    }

    public RoundedCornersTransform(C6250e pool, int radius, int margin, CornerType cornerType) {
        boolean[] $jacocoInit = $jacocoInit();
        this.mBitmapPool = pool;
        this.mRadius = radius;
        this.mDiameter = this.mRadius * 2;
        this.mMargin = margin;
        this.mCornerType = cornerType;
        $jacocoInit[5] = true;
    }

    public C6236E<Bitmap> transform(Context context, C6236E<Bitmap> resource, int outWidth, int outHeight) {
        boolean[] $jacocoInit = $jacocoInit();
        Bitmap source = (Bitmap) resource.get();
        $jacocoInit[6] = true;
        int width = source.getWidth();
        $jacocoInit[7] = true;
        int height = source.getHeight();
        $jacocoInit[8] = true;
        Bitmap bitmap = this.mBitmapPool.mo19148a(width, height, Config.ARGB_8888);
        if (bitmap != null) {
            $jacocoInit[9] = true;
        } else {
            $jacocoInit[10] = true;
            bitmap = Bitmap.createBitmap(width, height, Config.ARGB_8888);
            $jacocoInit[11] = true;
        }
        Canvas canvas = new Canvas(bitmap);
        $jacocoInit[12] = true;
        Paint paint = new Paint();
        $jacocoInit[13] = true;
        paint.setAntiAlias(true);
        $jacocoInit[14] = true;
        TileMode tileMode = TileMode.CLAMP;
        paint.setShader(new BitmapShader(source, tileMode, tileMode));
        $jacocoInit[15] = true;
        drawRoundRect(canvas, paint, (float) width, (float) height);
        $jacocoInit[16] = true;
        C6150d a = C6150d.m11623a(bitmap, this.mBitmapPool);
        $jacocoInit[17] = true;
        return a;
    }

    public String getId() {
        boolean[] $jacocoInit = $jacocoInit();
        StringBuilder sb = new StringBuilder();
        sb.append("RoundedTransformation(radius=");
        sb.append(this.mRadius);
        sb.append(", margin=");
        sb.append(this.mMargin);
        sb.append(", diameter=");
        sb.append(this.mDiameter);
        sb.append(", cornerType=");
        CornerType cornerType = this.mCornerType;
        $jacocoInit[18] = true;
        sb.append(cornerType.name());
        sb.append(")");
        String sb2 = sb.toString();
        $jacocoInit[19] = true;
        return sb2;
    }

    private void drawRoundRect(Canvas canvas, Paint paint, float width, float height) {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.mMargin;
        float right = width - ((float) i);
        float bottom = height - ((float) i);
        $jacocoInit[20] = true;
        switch (C41521.f7699x1f5f81cf[this.mCornerType.ordinal()]) {
            case 1:
                int i2 = this.mMargin;
                RectF rectF = new RectF((float) i2, (float) i2, right, bottom);
                int i3 = this.mRadius;
                canvas.drawRoundRect(rectF, (float) i3, (float) i3, paint);
                $jacocoInit[21] = true;
                break;
            case 2:
                drawTopLeftRoundRect(canvas, paint, right, bottom);
                $jacocoInit[22] = true;
                break;
            case 3:
                drawTopRightRoundRect(canvas, paint, right, bottom);
                $jacocoInit[23] = true;
                break;
            case 4:
                drawBottomLeftRoundRect(canvas, paint, right, bottom);
                $jacocoInit[24] = true;
                break;
            case 5:
                drawBottomRightRoundRect(canvas, paint, right, bottom);
                $jacocoInit[25] = true;
                break;
            case 6:
                drawTopRoundRect(canvas, paint, right, bottom);
                $jacocoInit[26] = true;
                break;
            case 7:
                drawBottomRoundRect(canvas, paint, right, bottom);
                $jacocoInit[27] = true;
                break;
            case 8:
                drawLeftRoundRect(canvas, paint, right, bottom);
                $jacocoInit[28] = true;
                break;
            case 9:
                drawRightRoundRect(canvas, paint, right, bottom);
                $jacocoInit[29] = true;
                break;
            case 10:
                drawOtherTopLeftRoundRect(canvas, paint, right, bottom);
                $jacocoInit[30] = true;
                break;
            case 11:
                drawOtherTopRightRoundRect(canvas, paint, right, bottom);
                $jacocoInit[31] = true;
                break;
            case 12:
                drawOtherBottomLeftRoundRect(canvas, paint, right, bottom);
                $jacocoInit[32] = true;
                break;
            case 13:
                drawOtherBottomRightRoundRect(canvas, paint, right, bottom);
                $jacocoInit[33] = true;
                break;
            case 14:
                drawDiagonalFromTopLeftRoundRect(canvas, paint, right, bottom);
                $jacocoInit[34] = true;
                break;
            case 15:
                drawDiagonalFromTopRightRoundRect(canvas, paint, right, bottom);
                $jacocoInit[35] = true;
                break;
            default:
                int i4 = this.mMargin;
                RectF rectF2 = new RectF((float) i4, (float) i4, right, bottom);
                int i5 = this.mRadius;
                canvas.drawRoundRect(rectF2, (float) i5, (float) i5, paint);
                $jacocoInit[36] = true;
                break;
        }
        $jacocoInit[37] = true;
    }

    private void drawTopLeftRoundRect(Canvas canvas, Paint paint, float right, float bottom) {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.mMargin;
        float f = (float) i;
        float f2 = (float) i;
        int i2 = this.mDiameter;
        RectF rectF = new RectF(f, f2, (float) (i + i2), (float) (i + i2));
        int i3 = this.mRadius;
        canvas.drawRoundRect(rectF, (float) i3, (float) i3, paint);
        $jacocoInit[38] = true;
        int i4 = this.mMargin;
        float f3 = (float) i4;
        int i5 = this.mRadius;
        canvas.drawRect(new RectF(f3, (float) (i4 + i5), (float) (i4 + i5), bottom), paint);
        $jacocoInit[39] = true;
        int i6 = this.mMargin;
        canvas.drawRect(new RectF((float) (this.mRadius + i6), (float) i6, right, bottom), paint);
        $jacocoInit[40] = true;
    }

    private void drawTopRightRoundRect(Canvas canvas, Paint paint, float right, float bottom) {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.mDiameter;
        float f = right - ((float) i);
        int i2 = this.mMargin;
        RectF rectF = new RectF(f, (float) i2, right, (float) (i2 + i));
        int i3 = this.mRadius;
        canvas.drawRoundRect(rectF, (float) i3, (float) i3, paint);
        $jacocoInit[41] = true;
        int i4 = this.mMargin;
        canvas.drawRect(new RectF((float) i4, (float) i4, right - ((float) this.mRadius), bottom), paint);
        $jacocoInit[42] = true;
        int i5 = this.mRadius;
        canvas.drawRect(new RectF(right - ((float) i5), (float) (this.mMargin + i5), right, bottom), paint);
        $jacocoInit[43] = true;
    }

    private void drawBottomLeftRoundRect(Canvas canvas, Paint paint, float right, float bottom) {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.mMargin;
        float f = (float) i;
        int i2 = this.mDiameter;
        RectF rectF = new RectF(f, bottom - ((float) i2), (float) (i + i2), bottom);
        int i3 = this.mRadius;
        canvas.drawRoundRect(rectF, (float) i3, (float) i3, paint);
        $jacocoInit[44] = true;
        int i4 = this.mMargin;
        canvas.drawRect(new RectF((float) i4, (float) i4, (float) (i4 + this.mDiameter), bottom - ((float) this.mRadius)), paint);
        $jacocoInit[45] = true;
        int i5 = this.mMargin;
        canvas.drawRect(new RectF((float) (this.mRadius + i5), (float) i5, right, bottom), paint);
        $jacocoInit[46] = true;
    }

    private void drawBottomRightRoundRect(Canvas canvas, Paint paint, float right, float bottom) {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.mDiameter;
        RectF rectF = new RectF(right - ((float) i), bottom - ((float) i), right, bottom);
        int i2 = this.mRadius;
        canvas.drawRoundRect(rectF, (float) i2, (float) i2, paint);
        $jacocoInit[47] = true;
        int i3 = this.mMargin;
        canvas.drawRect(new RectF((float) i3, (float) i3, right - ((float) this.mRadius), bottom), paint);
        $jacocoInit[48] = true;
        int i4 = this.mRadius;
        canvas.drawRect(new RectF(right - ((float) i4), (float) this.mMargin, right, bottom - ((float) i4)), paint);
        $jacocoInit[49] = true;
    }

    private void drawTopRoundRect(Canvas canvas, Paint paint, float right, float bottom) {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.mMargin;
        RectF rectF = new RectF((float) i, (float) i, right, (float) (i + this.mDiameter));
        int i2 = this.mRadius;
        canvas.drawRoundRect(rectF, (float) i2, (float) i2, paint);
        $jacocoInit[50] = true;
        int i3 = this.mMargin;
        canvas.drawRect(new RectF((float) i3, (float) (i3 + this.mRadius), right, bottom), paint);
        $jacocoInit[51] = true;
    }

    private void drawBottomRoundRect(Canvas canvas, Paint paint, float right, float bottom) {
        boolean[] $jacocoInit = $jacocoInit();
        RectF rectF = new RectF((float) this.mMargin, bottom - ((float) this.mDiameter), right, bottom);
        int i = this.mRadius;
        canvas.drawRoundRect(rectF, (float) i, (float) i, paint);
        $jacocoInit[52] = true;
        int i2 = this.mMargin;
        canvas.drawRect(new RectF((float) i2, (float) i2, right, bottom - ((float) this.mRadius)), paint);
        $jacocoInit[53] = true;
    }

    private void drawLeftRoundRect(Canvas canvas, Paint paint, float right, float bottom) {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.mMargin;
        RectF rectF = new RectF((float) i, (float) i, (float) (i + this.mDiameter), bottom);
        int i2 = this.mRadius;
        canvas.drawRoundRect(rectF, (float) i2, (float) i2, paint);
        $jacocoInit[54] = true;
        int i3 = this.mMargin;
        canvas.drawRect(new RectF((float) (this.mRadius + i3), (float) i3, right, bottom), paint);
        $jacocoInit[55] = true;
    }

    private void drawRightRoundRect(Canvas canvas, Paint paint, float right, float bottom) {
        boolean[] $jacocoInit = $jacocoInit();
        RectF rectF = new RectF(right - ((float) this.mDiameter), (float) this.mMargin, right, bottom);
        int i = this.mRadius;
        canvas.drawRoundRect(rectF, (float) i, (float) i, paint);
        $jacocoInit[56] = true;
        int i2 = this.mMargin;
        canvas.drawRect(new RectF((float) i2, (float) i2, right - ((float) this.mRadius), bottom), paint);
        $jacocoInit[57] = true;
    }

    private void drawOtherTopLeftRoundRect(Canvas canvas, Paint paint, float right, float bottom) {
        boolean[] $jacocoInit = $jacocoInit();
        RectF rectF = new RectF((float) this.mMargin, bottom - ((float) this.mDiameter), right, bottom);
        int i = this.mRadius;
        canvas.drawRoundRect(rectF, (float) i, (float) i, paint);
        $jacocoInit[58] = true;
        RectF rectF2 = new RectF(right - ((float) this.mDiameter), (float) this.mMargin, right, bottom);
        int i2 = this.mRadius;
        canvas.drawRoundRect(rectF2, (float) i2, (float) i2, paint);
        $jacocoInit[59] = true;
        int i3 = this.mMargin;
        float f = (float) i3;
        float f2 = (float) i3;
        int i4 = this.mRadius;
        canvas.drawRect(new RectF(f, f2, right - ((float) i4), bottom - ((float) i4)), paint);
        $jacocoInit[60] = true;
    }

    private void drawOtherTopRightRoundRect(Canvas canvas, Paint paint, float right, float bottom) {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.mMargin;
        RectF rectF = new RectF((float) i, (float) i, (float) (i + this.mDiameter), bottom);
        int i2 = this.mRadius;
        canvas.drawRoundRect(rectF, (float) i2, (float) i2, paint);
        $jacocoInit[61] = true;
        RectF rectF2 = new RectF((float) this.mMargin, bottom - ((float) this.mDiameter), right, bottom);
        int i3 = this.mRadius;
        canvas.drawRoundRect(rectF2, (float) i3, (float) i3, paint);
        $jacocoInit[62] = true;
        int i4 = this.mMargin;
        int i5 = this.mRadius;
        canvas.drawRect(new RectF((float) (i4 + i5), (float) i4, right, bottom - ((float) i5)), paint);
        $jacocoInit[63] = true;
    }

    private void drawOtherBottomLeftRoundRect(Canvas canvas, Paint paint, float right, float bottom) {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.mMargin;
        RectF rectF = new RectF((float) i, (float) i, right, (float) (i + this.mDiameter));
        int i2 = this.mRadius;
        canvas.drawRoundRect(rectF, (float) i2, (float) i2, paint);
        $jacocoInit[64] = true;
        RectF rectF2 = new RectF(right - ((float) this.mDiameter), (float) this.mMargin, right, bottom);
        int i3 = this.mRadius;
        canvas.drawRoundRect(rectF2, (float) i3, (float) i3, paint);
        $jacocoInit[65] = true;
        int i4 = this.mMargin;
        float f = (float) i4;
        int i5 = this.mRadius;
        canvas.drawRect(new RectF(f, (float) (i4 + i5), right - ((float) i5), bottom), paint);
        $jacocoInit[66] = true;
    }

    private void drawOtherBottomRightRoundRect(Canvas canvas, Paint paint, float right, float bottom) {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.mMargin;
        RectF rectF = new RectF((float) i, (float) i, right, (float) (i + this.mDiameter));
        int i2 = this.mRadius;
        canvas.drawRoundRect(rectF, (float) i2, (float) i2, paint);
        $jacocoInit[67] = true;
        int i3 = this.mMargin;
        RectF rectF2 = new RectF((float) i3, (float) i3, (float) (i3 + this.mDiameter), bottom);
        int i4 = this.mRadius;
        canvas.drawRoundRect(rectF2, (float) i4, (float) i4, paint);
        $jacocoInit[68] = true;
        int i5 = this.mMargin;
        int i6 = this.mRadius;
        canvas.drawRect(new RectF((float) (i5 + i6), (float) (i5 + i6), right, bottom), paint);
        $jacocoInit[69] = true;
    }

    private void drawDiagonalFromTopLeftRoundRect(Canvas canvas, Paint paint, float right, float bottom) {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.mMargin;
        float f = (float) i;
        float f2 = (float) i;
        int i2 = this.mDiameter;
        RectF rectF = new RectF(f, f2, (float) (i + i2), (float) (i + i2));
        int i3 = this.mRadius;
        canvas.drawRoundRect(rectF, (float) i3, (float) i3, paint);
        $jacocoInit[70] = true;
        int i4 = this.mDiameter;
        RectF rectF2 = new RectF(right - ((float) i4), bottom - ((float) i4), right, bottom);
        int i5 = this.mRadius;
        canvas.drawRoundRect(rectF2, (float) i5, (float) i5, paint);
        $jacocoInit[71] = true;
        int i6 = this.mMargin;
        canvas.drawRect(new RectF((float) i6, (float) (i6 + this.mRadius), right - ((float) this.mDiameter), bottom), paint);
        $jacocoInit[72] = true;
        int i7 = this.mMargin;
        canvas.drawRect(new RectF((float) (this.mDiameter + i7), (float) i7, right, bottom - ((float) this.mRadius)), paint);
        $jacocoInit[73] = true;
    }

    private void drawDiagonalFromTopRightRoundRect(Canvas canvas, Paint paint, float right, float bottom) {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.mDiameter;
        float f = right - ((float) i);
        int i2 = this.mMargin;
        RectF rectF = new RectF(f, (float) i2, right, (float) (i2 + i));
        int i3 = this.mRadius;
        canvas.drawRoundRect(rectF, (float) i3, (float) i3, paint);
        $jacocoInit[74] = true;
        int i4 = this.mMargin;
        float f2 = (float) i4;
        int i5 = this.mDiameter;
        RectF rectF2 = new RectF(f2, bottom - ((float) i5), (float) (i4 + i5), bottom);
        int i6 = this.mRadius;
        canvas.drawRoundRect(rectF2, (float) i6, (float) i6, paint);
        $jacocoInit[75] = true;
        int i7 = this.mMargin;
        float f3 = (float) i7;
        float f4 = (float) i7;
        int i8 = this.mRadius;
        canvas.drawRect(new RectF(f3, f4, right - ((float) i8), bottom - ((float) i8)), paint);
        $jacocoInit[76] = true;
        int i9 = this.mMargin;
        int i10 = this.mRadius;
        canvas.drawRect(new RectF((float) (i9 + i10), (float) (i9 + i10), right, bottom), paint);
        $jacocoInit[77] = true;
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        $jacocoInit()[78] = true;
    }
}
