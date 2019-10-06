package com.bumptech.glide.load.p113c.p114a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.load.engine.C6236E;
import com.bumptech.glide.load.engine.p120a.C6250e;
import java.util.concurrent.locks.Lock;

/* renamed from: com.bumptech.glide.load.c.a.n */
/* compiled from: DrawableToBitmapConverter */
final class C6172n {

    /* renamed from: a */
    private static final C6250e f10890a = new C6171m();

    /* renamed from: a */
    static C6236E<Bitmap> m11700a(C6250e bitmapPool, Drawable drawable, int width, int height) {
        Drawable drawable2 = drawable.getCurrent();
        Bitmap result = null;
        boolean isRecycleable = false;
        if (drawable2 instanceof BitmapDrawable) {
            result = ((BitmapDrawable) drawable2).getBitmap();
        } else if (!(drawable2 instanceof Animatable)) {
            result = m11701b(bitmapPool, drawable2, width, height);
            isRecycleable = true;
        }
        return C6150d.m11623a(result, isRecycleable ? bitmapPool : f10890a);
    }

    /* renamed from: b */
    private static Bitmap m11701b(C6250e bitmapPool, Drawable drawable, int width, int height) {
        String str = "Unable to draw ";
        String str2 = "DrawableToBitmap";
        if (width == Integer.MIN_VALUE && drawable.getIntrinsicWidth() <= 0) {
            if (Log.isLoggable(str2, 5)) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(drawable);
                sb.append(" to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width");
                Log.w(str2, sb.toString());
            }
            return null;
        } else if (height != Integer.MIN_VALUE || drawable.getIntrinsicHeight() > 0) {
            int targetWidth = drawable.getIntrinsicWidth() > 0 ? drawable.getIntrinsicWidth() : width;
            int targetHeight = drawable.getIntrinsicHeight() > 0 ? drawable.getIntrinsicHeight() : height;
            Lock lock = C6182v.m11729a();
            lock.lock();
            Bitmap result = bitmapPool.mo19148a(targetWidth, targetHeight, Config.ARGB_8888);
            try {
                Canvas canvas = new Canvas(result);
                drawable.setBounds(0, 0, targetWidth, targetHeight);
                drawable.draw(canvas);
                canvas.setBitmap(null);
                return result;
            } finally {
                lock.unlock();
            }
        } else {
            if (Log.isLoggable(str2, 5)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(drawable);
                sb2.append(" to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height");
                Log.w(str2, sb2.toString());
            }
            return null;
        }
    }
}
