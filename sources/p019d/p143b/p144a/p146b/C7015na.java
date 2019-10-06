package p019d.p143b.p144a.p146b;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import p019d.p143b.p150d.C7267q;

/* renamed from: d.b.a.b.na */
public class C7015na extends C7016o {

    /* renamed from: c */
    private float f13075c = 30.0f;

    /* renamed from: d */
    private float f13076d = 2.0f;

    /* renamed from: e */
    private float f13077e = 8.0f;

    /* renamed from: f */
    private float f13078f = 2.0f;

    /* renamed from: g */
    private float f13079g = 1.0f;

    public C7015na(C7267q qVar, Context context) {
        super(qVar, context);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public float mo22677a() {
        return this.f13075c * this.f13079g;
    }

    /* renamed from: a */
    public void mo22678a(float f) {
        this.f13079g = f;
    }

    /* renamed from: a */
    public void mo22636a(int i) {
        mo22678a(((float) i) / this.f13075c);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public float mo22679b() {
        return this.f13077e * this.f13079g;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public float mo22680c() {
        return this.f13078f * this.f13079g;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public float mo22681d() {
        return mo22677a() / 2.0f;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float d = mo22681d();
        Paint paint = new Paint(1);
        paint.setARGB(80, 0, 0, 0);
        canvas.drawCircle(d, d, d, paint);
        Paint paint2 = new Paint(1);
        paint2.setColor(-1);
        paint2.setStyle(Style.STROKE);
        paint2.setStrokeWidth(mo22680c());
        float b = mo22679b();
        float a = mo22677a() - b;
        Canvas canvas2 = canvas;
        float f = b;
        float f2 = a;
        Paint paint3 = paint2;
        canvas2.drawLine(f, b, f2, a, paint3);
        canvas2.drawLine(f, a, f2, b, paint3);
    }
}
