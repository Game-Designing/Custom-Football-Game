package com.inmobi.rendering;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.RectF;
import android.view.View;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;

public class CustomView extends View {

    /* renamed from: a */
    private float f32676a;

    /* renamed from: b */
    private float f32677b;

    /* renamed from: c */
    private float f32678c;

    /* renamed from: d */
    private float f32679d;

    /* renamed from: e */
    private float f32680e;

    /* renamed from: f */
    private int f32681f;

    /* renamed from: g */
    private int f32682g;

    /* renamed from: h */
    private Paint f32683h;

    /* renamed from: i */
    private Path f32684i;

    /* renamed from: j */
    private RectF f32685j;

    private CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, float f, int i) {
        this(context);
        this.f32681f = i;
        this.f32676a = f;
        this.f32682g = 15;
        this.f32683h = new Paint(1);
        this.f32685j = new RectF();
        this.f32684i = new Path();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Canvas canvas2 = canvas;
        super.onDraw(canvas);
        this.f32683h.reset();
        switch (this.f32681f) {
            case 0:
                float f = this.f32676a;
                float f2 = (50.0f * f) / 2.0f;
                float f3 = (f * 30.0f) / 2.0f;
                float f4 = f3 / 3.0f;
                float f5 = f2 - f4;
                float f6 = f2 + f4;
                this.f32683h.setAntiAlias(true);
                this.f32683h.setColor(CtaButton.BACKGROUND_COLOR);
                this.f32683h.setStrokeWidth(3.0f);
                this.f32683h.setStyle(Style.FILL_AND_STROKE);
                canvas2.drawCircle(f2, f2, f3, this.f32683h);
                this.f32683h.setColor(-1);
                this.f32683h.setStyle(Style.STROKE);
                Canvas canvas3 = canvas;
                float f7 = f5;
                float f8 = f6;
                canvas3.drawLine(f7, f5, f8, f6, this.f32683h);
                canvas3.drawLine(f7, f6, f8, f5, this.f32683h);
                canvas2.drawCircle(f2, f2, f3, this.f32683h);
                return;
            case 1:
                float f9 = (this.f32676a * 50.0f) / 2.0f;
                this.f32683h.setAntiAlias(true);
                this.f32683h.setColor(0);
                this.f32683h.setStrokeWidth(3.0f);
                this.f32683h.setStyle(Style.FILL_AND_STROKE);
                canvas2.drawCircle(f9, f9, f9, this.f32683h);
                return;
            case 2:
                this.f32683h.setAntiAlias(true);
                this.f32683h.setColor(-1);
                this.f32683h.setStrokeWidth(5.0f);
                this.f32683h.setStyle(Style.STROKE);
                Canvas canvas4 = canvas;
                canvas4.drawLine(((float) (getWidth() / 2)) - ((((float) this.f32682g) * this.f32676a) / 2.0f), ((float) (getHeight() / 2)) - ((((float) this.f32682g) * this.f32676a) / 2.0f), ((((float) this.f32682g) * this.f32676a) / 2.0f) + ((float) (getWidth() / 2)), ((((float) this.f32682g) * this.f32676a) / 2.0f) + ((float) (getHeight() / 2)), this.f32683h);
                Canvas canvas5 = canvas;
                canvas5.drawLine(((float) (getWidth() / 2)) - ((((float) this.f32682g) * this.f32676a) / 2.0f), ((((float) this.f32682g) * this.f32676a) / 2.0f) + ((float) (getHeight() / 2)), ((((float) this.f32682g) * this.f32676a) / 2.0f) + ((float) (getWidth() / 2)), ((float) (getHeight() / 2)) - ((((float) this.f32682g) * this.f32676a) / 2.0f), this.f32683h);
                break;
            case 3:
                float f10 = this.f32676a;
                float f11 = (50.0f * f10) / 2.0f;
                float f12 = (f10 * 30.0f) / 2.0f;
                this.f32684i.reset();
                this.f32683h.setAntiAlias(true);
                this.f32683h.setColor(CtaButton.BACKGROUND_COLOR);
                this.f32683h.setStrokeWidth(3.0f);
                this.f32683h.setStyle(Style.FILL_AND_STROKE);
                canvas2.drawCircle(f11, f11, f12, this.f32683h);
                this.f32683h.setColor(-1);
                this.f32683h.setStyle(Style.STROKE);
                canvas2.drawCircle(f11, f11, f12, this.f32683h);
                this.f32685j.set(((float) (getWidth() / 2)) - ((((float) this.f32682g) * this.f32676a) / 2.0f), ((float) (getHeight() / 2)) - ((((float) this.f32682g) * this.f32676a) / 2.0f), ((float) (getWidth() / 2)) + ((((float) this.f32682g) * this.f32676a) / 2.0f), ((float) (getHeight() / 2)) + ((((float) this.f32682g) * this.f32676a) / 2.0f));
                canvas.drawArc(this.f32685j, 0.0f, 270.0f, false, this.f32683h);
                this.f32684i.setFillType(FillType.EVEN_ODD);
                this.f32684i.moveTo(((float) (getWidth() / 2)) + ((((float) this.f32682g) * this.f32676a) / 2.0f), ((float) (getHeight() / 2)) - (this.f32676a * 2.0f));
                Path path = this.f32684i;
                float width = (float) (getWidth() / 2);
                float f13 = (float) this.f32682g;
                float f14 = this.f32676a;
                path.lineTo((width + ((f13 * f14) / 2.0f)) - (f14 * 2.0f), (float) (getHeight() / 2));
                Path path2 = this.f32684i;
                float width2 = (float) (getWidth() / 2);
                float f15 = (float) this.f32682g;
                float f16 = this.f32676a;
                path2.lineTo(width2 + ((f15 * f16) / 2.0f) + (f16 * 2.0f), (float) (getHeight() / 2));
                this.f32684i.lineTo(((float) (getWidth() / 2)) + ((((float) this.f32682g) * this.f32676a) / 2.0f), ((float) (getHeight() / 2)) - (this.f32676a * 2.0f));
                this.f32684i.close();
                this.f32683h.setStyle(Style.FILL_AND_STROKE);
                canvas2.drawPath(this.f32684i, this.f32683h);
                return;
            case 4:
                this.f32684i.reset();
                this.f32684i.setFillType(FillType.EVEN_ODD);
                this.f32684i.moveTo(((float) (getWidth() / 2)) - ((((float) this.f32682g) * this.f32676a) / 2.0f), (float) (getHeight() / 2));
                this.f32684i.lineTo(((float) (getWidth() / 2)) + ((((float) this.f32682g) * this.f32676a) / 2.0f), ((float) (getHeight() / 2)) - ((((float) this.f32682g) * this.f32676a) / 2.0f));
                this.f32684i.lineTo(((float) (getWidth() / 2)) + ((((float) this.f32682g) * this.f32676a) / 2.0f), ((float) (getHeight() / 2)) + ((((float) this.f32682g) * this.f32676a) / 2.0f));
                this.f32684i.lineTo(((float) (getWidth() / 2)) - ((((float) this.f32682g) * this.f32676a) / 2.0f), (float) (getHeight() / 2));
                this.f32684i.close();
                this.f32683h.setAntiAlias(true);
                this.f32683h.setColor(CtaButton.BACKGROUND_COLOR);
                this.f32683h.setStrokeWidth(3.0f);
                this.f32683h.setStyle(Style.FILL_AND_STROKE);
                canvas2.drawPath(this.f32684i, this.f32683h);
                return;
            case 5:
                this.f32684i.reset();
                this.f32684i.setFillType(FillType.EVEN_ODD);
                this.f32684i.moveTo(((float) (getWidth() / 2)) - ((((float) this.f32682g) * this.f32676a) / 2.0f), ((float) (getHeight() / 2)) - ((((float) this.f32682g) * this.f32676a) / 2.0f));
                this.f32684i.lineTo(((float) (getWidth() / 2)) + ((((float) this.f32682g) * this.f32676a) / 2.0f), (float) (getHeight() / 2));
                this.f32684i.lineTo(((float) (getWidth() / 2)) - ((((float) this.f32682g) * this.f32676a) / 2.0f), ((float) (getHeight() / 2)) + ((((float) this.f32682g) * this.f32676a) / 2.0f));
                this.f32684i.lineTo(((float) (getWidth() / 2)) - ((((float) this.f32682g) * this.f32676a) / 2.0f), ((float) (getHeight() / 2)) - ((((float) this.f32682g) * this.f32676a) / 2.0f));
                this.f32684i.close();
                this.f32683h.setAntiAlias(true);
                this.f32683h.setColor(CtaButton.BACKGROUND_COLOR);
                this.f32683h.setStrokeWidth(3.0f);
                this.f32683h.setStyle(Style.FILL_AND_STROKE);
                canvas2.drawPath(this.f32684i, this.f32683h);
                return;
            case 6:
                this.f32684i.reset();
                this.f32684i.setFillType(FillType.EVEN_ODD);
                this.f32684i.moveTo(((float) (getWidth() / 2)) - ((((float) this.f32682g) * this.f32676a) / 2.0f), ((float) (getHeight() / 2)) - ((((float) this.f32682g) * this.f32676a) / 2.0f));
                this.f32684i.lineTo(((float) (getWidth() / 2)) + ((((float) this.f32682g) * this.f32676a) / 2.0f), (float) (getHeight() / 2));
                this.f32684i.lineTo(((float) (getWidth() / 2)) - ((((float) this.f32682g) * this.f32676a) / 2.0f), ((float) (getHeight() / 2)) + ((((float) this.f32682g) * this.f32676a) / 2.0f));
                this.f32684i.lineTo(((float) (getWidth() / 2)) - ((((float) this.f32682g) * this.f32676a) / 2.0f), ((float) (getHeight() / 2)) - ((((float) this.f32682g) * this.f32676a) / 2.0f));
                this.f32684i.close();
                this.f32683h.setAntiAlias(true);
                this.f32683h.setColor(-12303292);
                this.f32683h.setStrokeWidth(3.0f);
                this.f32683h.setStyle(Style.FILL_AND_STROKE);
                canvas2.drawPath(this.f32684i, this.f32683h);
                return;
            case 7:
                m35175b(canvas);
                float f17 = this.f32680e;
                this.f32677b = f17 / 3.0f;
                this.f32678c = f17 / 3.0f;
                this.f32683h.setStyle(Style.FILL);
                Path path3 = this.f32684i;
                float f18 = this.f32679d;
                path3.moveTo(this.f32677b + f18, f18);
                Path path4 = this.f32684i;
                float f19 = this.f32679d;
                path4.lineTo(f19 - this.f32677b, f19 - this.f32678c);
                Path path5 = this.f32684i;
                float f20 = this.f32679d;
                path5.lineTo(f20 - this.f32677b, f20 + this.f32678c);
                Path path6 = this.f32684i;
                float f21 = this.f32679d;
                path6.lineTo(this.f32677b + f21, f21);
                canvas2.drawPath(this.f32684i, this.f32683h);
                return;
            case 8:
                m35175b(canvas);
                float f22 = this.f32680e;
                this.f32677b = f22 / 4.0f;
                this.f32678c = f22 / 3.0f;
                float f23 = this.f32679d;
                float f24 = this.f32677b;
                float f25 = f23 - f24;
                float f26 = this.f32678c;
                canvas.drawLine(f25, f23 - f26, f23 - f24, f23 + f26, this.f32683h);
                float f27 = this.f32679d;
                float f28 = this.f32677b;
                float f29 = f27 + f28;
                float f30 = this.f32678c;
                canvas.drawLine(f29, f27 - f30, f27 + f28, f27 + f30, this.f32683h);
                return;
            case 9:
                m35174a(canvas);
                float f31 = this.f32679d;
                float f32 = this.f32676a;
                float f33 = f31 - (f32 * 10.0f);
                float f34 = this.f32678c;
                RectF rectF = new RectF(f33, (f31 - f34) - (f32 * 2.0f), (14.0f * f32) + f31, f31 + f34 + (f32 * 2.0f));
                float f35 = this.f32679d;
                float f36 = this.f32676a;
                float f37 = f35 - (10.0f * f36);
                float f38 = this.f32678c;
                RectF rectF2 = new RectF(f37, (f35 - f38) - (f36 * 4.0f), (18.0f * f36) + f35, f35 + f38 + (f36 * 4.0f));
                this.f32683h.setColor(-1);
                this.f32683h.setStrokeWidth(4.0f);
                this.f32683h.setStyle(Style.STROKE);
                Canvas canvas6 = canvas;
                canvas6.drawArc(rectF, -45.0f, 90.0f, false, this.f32683h);
                canvas6.drawArc(rectF2, -45.0f, 90.0f, false, this.f32683h);
                canvas2.drawPath(this.f32684i, this.f32683h);
                canvas2.drawPath(this.f32684i, this.f32683h);
                return;
            case 11:
                m35174a(canvas);
                this.f32683h.setColor(-1);
                this.f32683h.setStrokeWidth(4.0f);
                this.f32683h.setStyle(Style.STROKE);
                Path path7 = this.f32684i;
                float f39 = this.f32679d;
                path7.moveTo((this.f32676a * 10.0f) + f39, f39 - this.f32678c);
                Path path8 = this.f32684i;
                float f40 = this.f32679d;
                path8.lineTo((this.f32676a * 18.0f) + f40, f40 + this.f32678c);
                Path path9 = this.f32684i;
                float f41 = this.f32679d;
                path9.moveTo((this.f32676a * 18.0f) + f41, f41 - this.f32678c);
                Path path10 = this.f32684i;
                float f42 = this.f32679d;
                path10.lineTo((this.f32676a * 10.0f) + f42, f42 + this.f32678c);
                canvas2.drawPath(this.f32684i, this.f32683h);
                return;
            case 12:
                float f43 = this.f32676a;
                this.f32679d = (50.0f * f43) / 2.0f;
                this.f32677b = f43 * 3.0f;
                this.f32678c = f43 * 3.0f;
                this.f32683h.setStyle(Style.STROKE);
                this.f32683h.setStrokeWidth(4.0f);
                this.f32683h.setColor(-1);
                Path path11 = this.f32684i;
                float f44 = this.f32679d;
                path11.moveTo(f44 - this.f32677b, (f44 - this.f32678c) - (this.f32676a * 5.0f));
                Path path12 = this.f32684i;
                float f45 = this.f32679d;
                path12.lineTo(f45 - this.f32677b, f45 - this.f32678c);
                Path path13 = this.f32684i;
                float f46 = this.f32679d;
                path13.lineTo((f46 - this.f32677b) - (this.f32676a * 5.0f), f46 - this.f32678c);
                Path path14 = this.f32684i;
                float f47 = this.f32679d;
                path14.moveTo(this.f32677b + f47, (f47 - this.f32678c) - (this.f32676a * 5.0f));
                Path path15 = this.f32684i;
                float f48 = this.f32679d;
                path15.lineTo(this.f32677b + f48, f48 - this.f32678c);
                Path path16 = this.f32684i;
                float f49 = this.f32679d;
                path16.lineTo(this.f32677b + f49 + (this.f32676a * 5.0f), f49 - this.f32678c);
                Path path17 = this.f32684i;
                float f50 = this.f32679d;
                path17.moveTo(f50 - this.f32677b, f50 + this.f32678c + (this.f32676a * 5.0f));
                Path path18 = this.f32684i;
                float f51 = this.f32679d;
                path18.lineTo(f51 - this.f32677b, f51 + this.f32678c);
                Path path19 = this.f32684i;
                float f52 = this.f32679d;
                path19.lineTo((f52 - this.f32677b) - (this.f32676a * 5.0f), f52 + this.f32678c);
                Path path20 = this.f32684i;
                float f53 = this.f32679d;
                path20.moveTo(this.f32677b + f53, f53 + this.f32678c + (this.f32676a * 5.0f));
                Path path21 = this.f32684i;
                float f54 = this.f32679d;
                path21.lineTo(this.f32677b + f54, f54 + this.f32678c);
                Path path22 = this.f32684i;
                float f55 = this.f32679d;
                path22.lineTo(this.f32677b + f55 + (this.f32676a * 5.0f), f55 + this.f32678c);
                canvas2.drawPath(this.f32684i, this.f32683h);
                return;
        }
    }

    /* renamed from: a */
    private void m35174a(Canvas canvas) {
        float f = this.f32676a;
        this.f32679d = ((30.0f * f) / 2.0f) - (f * 5.0f);
        this.f32677b = f * 5.0f;
        this.f32678c = f * 5.0f;
        this.f32683h.setStyle(Style.FILL);
        this.f32683h.setColor(-1);
        this.f32683h.setStrokeWidth(4.0f);
        this.f32683h.setAntiAlias(true);
        Path path = this.f32684i;
        float f2 = this.f32679d;
        path.moveTo(f2 - this.f32677b, f2 - this.f32678c);
        Path path2 = this.f32684i;
        float f3 = this.f32679d;
        path2.lineTo(f3, f3 - this.f32678c);
        Path path3 = this.f32684i;
        float f4 = this.f32679d;
        float f5 = this.f32676a;
        path3.lineTo((f5 * 6.0f) + f4, (f4 - this.f32678c) - (f5 * 4.0f));
        Path path4 = this.f32684i;
        float f6 = this.f32679d;
        float f7 = this.f32676a;
        path4.lineTo((6.0f * f7) + f6, f6 + this.f32678c + (f7 * 4.0f));
        Path path5 = this.f32684i;
        float f8 = this.f32679d;
        path5.lineTo(f8, this.f32678c + f8);
        Path path6 = this.f32684i;
        float f9 = this.f32679d;
        path6.lineTo(f9 - this.f32677b, f9 + this.f32678c);
        Path path7 = this.f32684i;
        float f10 = this.f32679d;
        path7.lineTo(f10 - this.f32677b, f10 - this.f32678c);
        canvas.drawPath(this.f32684i, this.f32683h);
    }

    /* renamed from: b */
    private void m35175b(Canvas canvas) {
        float f = this.f32676a;
        this.f32680e = 25.0f * f;
        this.f32679d = f * 30.0f;
        this.f32683h.setAntiAlias(true);
        this.f32683h.setColor(-1);
        this.f32683h.setStrokeWidth(7.0f);
        this.f32683h.setStyle(Style.STROKE);
        float f2 = this.f32679d;
        canvas.drawCircle(f2, f2, this.f32680e, this.f32683h);
    }

    public void setSwitchInt(int i) {
        this.f32681f = i;
    }
}
