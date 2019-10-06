package com.mopub.mobileads.resource;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public abstract class BaseWidgetDrawable extends Drawable {
    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo37527a(Canvas canvas, Paint textPaint, Rect textRect, String text) {
        textPaint.getTextBounds(text, 0, text.length(), textRect);
        canvas.drawText(text, (float) getBounds().centerX(), ((float) getBounds().centerY()) + (((textPaint.descent() - textPaint.ascent()) / 2.0f) - textPaint.descent()), textPaint);
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return 0;
    }
}
