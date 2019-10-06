package com.fyber.inneractive.sdk.p180ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import com.fyber.inneractive.sdk.util.C8006j;

/* renamed from: com.fyber.inneractive.sdk.ui.IAcloseButton */
public class IAcloseButton extends View {

    /* renamed from: a */
    Paint f16272a;

    /* renamed from: b */
    Path f16273b = new Path();

    public IAcloseButton(Context context, int i) {
        super(context);
        int b = C8006j.m18072b(10);
        int i2 = ((i - (b * 2)) / 4) + b;
        Point point = new Point(i2, i2);
        int i3 = i - i2;
        Point point2 = new Point(i2, i3);
        Point point3 = new Point(i3, i3);
        Point point4 = new Point(i3, i2);
        this.f16273b.setFillType(FillType.EVEN_ODD);
        this.f16273b.moveTo((float) point.x, (float) point.y);
        this.f16273b.lineTo((float) point3.x, (float) point3.y);
        this.f16273b.moveTo((float) point2.x, (float) point2.y);
        this.f16273b.lineTo((float) point4.x, (float) point4.y);
        this.f16273b.close();
        this.f16272a = new Paint(1);
        this.f16272a.setStrokeWidth((float) C8006j.m18072b(2));
        this.f16272a.setColor(-1);
        this.f16272a.setStyle(Style.FILL_AND_STROKE);
        this.f16272a.setAntiAlias(true);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(-1436657061);
        gradientDrawable.setStroke(C8006j.m18072b(2), -1);
        C8006j.m18071a((View) this, (Drawable) gradientDrawable);
        setPadding(b, b, b, b);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.f16273b, this.f16272a);
    }
}
