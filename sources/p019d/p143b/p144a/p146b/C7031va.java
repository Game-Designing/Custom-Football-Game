package p019d.p143b.p144a.p146b;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;
import p019d.p143b.p150d.C7267q;

/* renamed from: d.b.a.b.va */
public class C7031va extends C7016o {

    /* renamed from: c */
    private float f13120c = 30.0f;

    /* renamed from: d */
    private float f13121d = 2.0f;

    /* renamed from: e */
    private float f13122e = 10.0f;

    /* renamed from: f */
    private float f13123f = 3.0f;

    /* renamed from: g */
    private float f13124g = 1.0f;

    public C7031va(C7267q qVar, Context context) {
        super(qVar, context);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public float mo22718a() {
        return this.f13120c * this.f13124g;
    }

    /* renamed from: a */
    public void mo22719a(float f) {
        this.f13124g = f;
    }

    /* renamed from: a */
    public void mo22636a(int i) {
        mo22719a(((float) i) / this.f13120c);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public float mo22720b() {
        return this.f13122e * this.f13124g;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public float mo22721c() {
        return this.f13123f * this.f13124g;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public float mo22722d() {
        return mo22718a() / 2.0f;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public float mo22723e() {
        return this.f13121d * this.f13124g;
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public float mo22724f() {
        return mo22722d() - mo22723e();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float d = mo22722d();
        Paint paint = new Paint(1);
        paint.setColor(-1);
        canvas.drawCircle(d, d, d, paint);
        Paint paint2 = new Paint(1);
        paint2.setColor(CtaButton.BACKGROUND_COLOR);
        canvas.drawCircle(d, d, mo22724f(), paint2);
        Paint paint3 = new Paint(paint);
        paint3.setStyle(Style.STROKE);
        paint3.setStrokeWidth(mo22721c());
        float b = mo22720b();
        float a = mo22718a() - b;
        Canvas canvas2 = canvas;
        float f = b;
        float f2 = a;
        Paint paint4 = paint3;
        canvas2.drawLine(f, b, f2, a, paint4);
        canvas2.drawLine(f, a, f2, b, paint4);
    }
}
