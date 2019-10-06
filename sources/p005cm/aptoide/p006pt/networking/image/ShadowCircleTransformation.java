package p005cm.aptoide.p006pt.networking.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Shader.TileMode;
import android.view.View;
import com.bumptech.glide.load.engine.p120a.C6250e;
import com.bumptech.glide.load.p113c.p114a.C6151e;
import java.security.MessageDigest;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.networking.image.ShadowCircleTransformation */
public class ShadowCircleTransformation extends C6151e {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final int shadowColor;
    private final float spaceBetween;
    private final float strokeSize;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(2923248680091504939L, "cm/aptoide/pt/networking/image/ShadowCircleTransformation", 33);
        $jacocoData = probes;
        return probes;
    }

    public ShadowCircleTransformation(Context context, View view) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[0] = true;
        view.setLayerType(1, null);
        this.shadowColor = -1;
        this.strokeSize = 0.08f;
        this.spaceBetween = 0.0f;
        $jacocoInit[1] = true;
    }

    public ShadowCircleTransformation(Context context) {
        boolean[] $jacocoInit = $jacocoInit();
        this.shadowColor = -1;
        this.strokeSize = 0.08f;
        this.spaceBetween = 0.0f;
        $jacocoInit[2] = true;
    }

    public ShadowCircleTransformation(Context context, View view, int shadowColor2, float spaceBetween2, float strokeSize2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.strokeSize = strokeSize2;
        $jacocoInit[3] = true;
        view.setLayerType(1, null);
        this.shadowColor = shadowColor2;
        this.spaceBetween = spaceBetween2;
        $jacocoInit[4] = true;
    }

    public ShadowCircleTransformation(Context context, View view, int shadowColor2) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[5] = true;
        view.setLayerType(1, null);
        this.shadowColor = shadowColor2;
        this.strokeSize = 0.08f;
        this.spaceBetween = 0.95f;
        $jacocoInit[6] = true;
    }

    public ShadowCircleTransformation(Context context, View view, float strokeSize2) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[7] = true;
        view.setLayerType(1, null);
        this.strokeSize = strokeSize2;
        this.shadowColor = -1;
        this.spaceBetween = 0.95f;
        $jacocoInit[8] = true;
    }

    /* access modifiers changed from: protected */
    public Bitmap transform(C6250e pool, Bitmap toTransform, int outWidth, int outHeight) {
        boolean[] $jacocoInit = $jacocoInit();
        Bitmap circleCrop = circleCrop(pool, toTransform);
        $jacocoInit[9] = true;
        return circleCrop;
    }

    private Bitmap circleCrop(C6250e pool, Bitmap source) {
        Bitmap bitmap = source;
        boolean[] $jacocoInit = $jacocoInit();
        if (bitmap == null) {
            $jacocoInit[10] = true;
            return null;
        }
        int size = Math.min(source.getWidth(), source.getHeight());
        $jacocoInit[11] = true;
        int x = (source.getWidth() - size) / 2;
        $jacocoInit[12] = true;
        int y = (source.getHeight() - size) / 2;
        $jacocoInit[13] = true;
        Bitmap squared = Bitmap.createBitmap(bitmap, x, y, size, size);
        $jacocoInit[14] = true;
        Bitmap result = pool.mo19148a(size, size, Config.ARGB_8888);
        if (result != null) {
            $jacocoInit[15] = true;
        } else {
            $jacocoInit[16] = true;
            result = Bitmap.createBitmap(size, size, Config.ARGB_8888);
            $jacocoInit[17] = true;
        }
        Canvas canvas = new Canvas(result);
        float r = ((float) size) / 2.0f;
        $jacocoInit[18] = true;
        Paint strokePaint = new Paint();
        $jacocoInit[19] = true;
        strokePaint.setColor(this.shadowColor);
        $jacocoInit[20] = true;
        strokePaint.setStyle(Style.FILL);
        float shadowRadius = ((float) size) * 0.02f;
        $jacocoInit[21] = true;
        strokePaint.setShadowLayer(shadowRadius, 0.0f, 0.0f, -7829368);
        $jacocoInit[22] = true;
        strokePaint.setAntiAlias(true);
        $jacocoInit[23] = true;
        canvas.drawCircle(r, r, r - shadowRadius, strokePaint);
        $jacocoInit[24] = true;
        strokePaint.setColor(-1);
        $jacocoInit[25] = true;
        canvas.drawCircle(r, r, (r - shadowRadius) * this.spaceBetween, strokePaint);
        $jacocoInit[26] = true;
        Paint paint = new Paint();
        $jacocoInit[27] = true;
        TileMode tileMode = TileMode.CLAMP;
        paint.setShader(new BitmapShader(squared, tileMode, tileMode));
        $jacocoInit[28] = true;
        paint.setAntiAlias(true);
        $jacocoInit[29] = true;
        canvas.drawCircle(r, r, r - (((float) size) * this.strokeSize), paint);
        $jacocoInit[30] = true;
        return result;
    }

    public String getId() {
        boolean[] $jacocoInit = $jacocoInit();
        String name = getClass().getName();
        $jacocoInit[31] = true;
        return name;
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        $jacocoInit()[32] = true;
    }
}
