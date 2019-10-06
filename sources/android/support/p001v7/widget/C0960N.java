package android.support.p001v7.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

/* renamed from: android.support.v7.widget.N */
/* compiled from: CardViewBaseImpl */
class C0960N implements C0964a {

    /* renamed from: a */
    final /* synthetic */ C0962O f3050a;

    C0960N(C0962O this$0) {
        this.f3050a = this$0;
    }

    /* renamed from: a */
    public void mo7344a(Canvas canvas, RectF bounds, float cornerRadius, Paint paint) {
        Canvas canvas2 = canvas;
        RectF rectF = bounds;
        float twoRadius = cornerRadius * 2.0f;
        float innerWidth = (bounds.width() - twoRadius) - 1.0f;
        float innerHeight = (bounds.height() - twoRadius) - 1.0f;
        if (cornerRadius >= 1.0f) {
            float roundedCornerRadius = cornerRadius + 0.5f;
            this.f3050a.f3062a.set(-roundedCornerRadius, -roundedCornerRadius, roundedCornerRadius, roundedCornerRadius);
            int saved = canvas.save();
            canvas2.translate(rectF.left + roundedCornerRadius, rectF.top + roundedCornerRadius);
            canvas.drawArc(this.f3050a.f3062a, 180.0f, 90.0f, true, paint);
            canvas2.translate(innerWidth, 0.0f);
            canvas2.rotate(90.0f);
            Paint paint2 = paint;
            canvas.drawArc(this.f3050a.f3062a, 180.0f, 90.0f, true, paint2);
            canvas2.translate(innerHeight, 0.0f);
            canvas2.rotate(90.0f);
            canvas.drawArc(this.f3050a.f3062a, 180.0f, 90.0f, true, paint2);
            canvas2.translate(innerWidth, 0.0f);
            canvas2.rotate(90.0f);
            canvas.drawArc(this.f3050a.f3062a, 180.0f, 90.0f, true, paint2);
            canvas2.restoreToCount(saved);
            float f = (rectF.left + roundedCornerRadius) - 1.0f;
            float f2 = rectF.top;
            canvas.drawRect(f, f2, (rectF.right - roundedCornerRadius) + 1.0f, f2 + roundedCornerRadius, paint);
            float f3 = (rectF.left + roundedCornerRadius) - 1.0f;
            float f4 = rectF.bottom;
            canvas.drawRect(f3, f4 - roundedCornerRadius, (rectF.right - roundedCornerRadius) + 1.0f, f4, paint);
        }
        canvas.drawRect(rectF.left, rectF.top + cornerRadius, rectF.right, rectF.bottom - cornerRadius, paint);
    }
}
