package com.braintreepayments.cardform.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.text.style.ReplacementSpan;

/* renamed from: com.braintreepayments.cardform.view.i */
/* compiled from: SpaceSpan */
public class C5908i extends ReplacementSpan {
    public int getSize(Paint paint, CharSequence text, int start, int end, FontMetricsInt fm) {
        return (int) (paint.measureText(" ", 0, 1) + paint.measureText(text, start, end));
    }

    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        StringBuilder sb = new StringBuilder();
        sb.append(text.subSequence(start, end));
        sb.append(" ");
        canvas.drawText(sb.toString(), x, (float) y, paint);
    }
}
