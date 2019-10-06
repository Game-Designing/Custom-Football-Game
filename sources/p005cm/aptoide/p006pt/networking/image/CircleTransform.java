package p005cm.aptoide.p006pt.networking.image;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import com.bumptech.glide.load.engine.p120a.C6250e;
import com.bumptech.glide.load.p113c.p114a.C6151e;
import java.security.MessageDigest;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.networking.image.CircleTransform */
public class CircleTransform extends C6151e {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(925284782001203791L, "cm/aptoide/pt/networking/image/CircleTransform", 17);
        $jacocoData = probes;
        return probes;
    }

    public CircleTransform() {
        $jacocoInit()[0] = true;
    }

    private static Bitmap circleCrop(C6250e pool, Bitmap source) {
        boolean[] $jacocoInit = $jacocoInit();
        if (source == null) {
            $jacocoInit[1] = true;
            return null;
        }
        int size = Math.min(source.getWidth(), source.getHeight());
        $jacocoInit[2] = true;
        int x = (source.getWidth() - size) / 2;
        $jacocoInit[3] = true;
        int y = (source.getHeight() - size) / 2;
        $jacocoInit[4] = true;
        Bitmap squared = Bitmap.createBitmap(source, x, y, size, size);
        $jacocoInit[5] = true;
        Bitmap result = pool.mo19148a(size, size, Config.ARGB_8888);
        if (result != null) {
            $jacocoInit[6] = true;
        } else {
            $jacocoInit[7] = true;
            result = Bitmap.createBitmap(size, size, Config.ARGB_8888);
            $jacocoInit[8] = true;
        }
        Canvas canvas = new Canvas(result);
        $jacocoInit[9] = true;
        Paint paint = new Paint();
        $jacocoInit[10] = true;
        TileMode tileMode = TileMode.CLAMP;
        paint.setShader(new BitmapShader(squared, tileMode, tileMode));
        $jacocoInit[11] = true;
        paint.setAntiAlias(true);
        float r = ((float) size) / 2.0f;
        $jacocoInit[12] = true;
        canvas.drawCircle(r, r, r, paint);
        $jacocoInit[13] = true;
        return result;
    }

    /* access modifiers changed from: protected */
    public Bitmap transform(C6250e pool, Bitmap toTransform, int outWidth, int outHeight) {
        boolean[] $jacocoInit = $jacocoInit();
        Bitmap circleCrop = circleCrop(pool, toTransform);
        $jacocoInit[14] = true;
        return circleCrop;
    }

    public String getId() {
        boolean[] $jacocoInit = $jacocoInit();
        String name = getClass().getName();
        $jacocoInit[15] = true;
        return name;
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        $jacocoInit()[16] = true;
    }
}
