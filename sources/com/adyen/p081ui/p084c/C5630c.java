package com.adyen.p081ui.p084c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.support.p000v4.content.C0510b;
import com.adyen.p081ui.C5572a;

/* renamed from: com.adyen.ui.c.c */
/* compiled from: IconUtil */
public final class C5630c {
    /* renamed from: a */
    public static String m9930a(Context context, String url) {
        String str = ".png";
        if (!url.contains(str)) {
            return url;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(url.substring(0, url.indexOf(str)));
        sb.append(m9932b(context));
        sb.append(str);
        return sb.toString();
    }

    /* renamed from: b */
    private static String m9932b(Context context) {
        int density = context.getResources().getDisplayMetrics().densityDpi;
        String result = "";
        if (density <= 160) {
            return result;
        }
        if (density > 160 && density <= 320) {
            return "@2x";
        }
        if (density > 320) {
            return "@3x";
        }
        return result;
    }

    /* renamed from: a */
    public static Drawable m9927a(Context context, Bitmap bitmap, int targetHeight) {
        return m9929a(context, (Drawable) new BitmapDrawable(context.getResources(), m9931b(m9926a(bitmap, targetHeight), m9925a(3))));
    }

    /* renamed from: b */
    private static Bitmap m9931b(Bitmap bitmap, int radiusPx) {
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        float roundPx = (float) radiusPx;
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return output;
    }

    /* renamed from: a */
    private static Bitmap m9926a(Bitmap bitmap, int targetHeight) {
        double width = (double) bitmap.getWidth();
        double height = (double) bitmap.getHeight();
        Double.isNaN(width);
        Double.isNaN(height);
        double ratio = width / height;
        double d = (double) targetHeight;
        Double.isNaN(d);
        return Bitmap.createScaledBitmap(bitmap, (int) (d * ratio), targetHeight, true);
    }

    /* renamed from: a */
    private static LayerDrawable m9929a(Context context, Drawable drawable) {
        return new LayerDrawable(new Drawable[]{drawable, m9928a(context)});
    }

    /* renamed from: a */
    private static GradientDrawable m9928a(Context context) {
        GradientDrawable gd = new GradientDrawable();
        gd.setCornerRadius((float) m9925a(3));
        gd.setStroke(1, C0510b.m2564a(context, C5572a.black_20_percent_opacity));
        return gd;
    }

    /* renamed from: a */
    private static int m9925a(int dp) {
        return (int) (((float) dp) * Resources.getSystem().getDisplayMetrics().density);
    }
}
