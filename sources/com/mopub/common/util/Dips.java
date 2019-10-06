package com.mopub.common.util;

import android.content.Context;
import android.util.TypedValue;
import com.mopub.common.Preconditions;

public class Dips {
    public static float pixelsToFloatDips(float pixels, Context context) {
        return pixels / m37188a(context);
    }

    public static int pixelsToIntDips(float pixels, Context context) {
        return (int) (pixelsToFloatDips(pixels, context) + 0.5f);
    }

    public static float dipsToFloatPixels(float dips, Context context) {
        return m37188a(context) * dips;
    }

    public static int dipsToIntPixels(float dips, Context context) {
        return (int) (dipsToFloatPixels(dips, context) + 0.5f);
    }

    /* renamed from: a */
    private static float m37188a(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    public static float asFloatPixels(float dips, Context context) {
        return TypedValue.applyDimension(1, dips, context.getResources().getDisplayMetrics());
    }

    public static int asIntPixels(float dips, Context context) {
        return (int) (asFloatPixels(dips, context) + 0.5f);
    }

    public static int screenWidthAsIntDips(Context context) {
        Preconditions.checkNotNull(context);
        return pixelsToIntDips((float) context.getResources().getDisplayMetrics().widthPixels, context);
    }

    public static int screenHeightAsIntDips(Context context) {
        Preconditions.checkNotNull(context);
        return pixelsToIntDips((float) context.getResources().getDisplayMetrics().heightPixels, context);
    }
}
