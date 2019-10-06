package p019d.p143b.p144a.p146b;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: d.b.a.b.m */
public class C7012m extends View {

    /* renamed from: A */
    private final int f13041A;

    /* renamed from: a */
    private Paint f13042a;

    /* renamed from: b */
    private Paint f13043b;

    /* renamed from: c */
    protected Paint f13044c;

    /* renamed from: d */
    protected Paint f13045d;

    /* renamed from: e */
    private RectF f13046e;

    /* renamed from: f */
    private float f13047f;

    /* renamed from: g */
    private int f13048g;

    /* renamed from: h */
    private int f13049h;

    /* renamed from: i */
    private int f13050i;

    /* renamed from: j */
    private int f13051j;

    /* renamed from: k */
    private int f13052k;

    /* renamed from: l */
    private float f13053l;

    /* renamed from: m */
    private int f13054m;

    /* renamed from: n */
    private String f13055n;

    /* renamed from: o */
    private String f13056o;

    /* renamed from: p */
    private float f13057p;

    /* renamed from: q */
    private String f13058q;

    /* renamed from: r */
    private float f13059r;

    /* renamed from: s */
    private final float f13060s;

    /* renamed from: t */
    private final int f13061t;

    /* renamed from: u */
    private final int f13062u;

    /* renamed from: v */
    private final int f13063v;

    /* renamed from: w */
    private final int f13064w;

    /* renamed from: x */
    private final int f13065x;

    /* renamed from: y */
    private final float f13066y;

    /* renamed from: z */
    private final float f13067z;

    public C7012m(Context context) {
        this(context, null);
    }

    public C7012m(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C7012m(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13046e = new RectF();
        this.f13050i = 0;
        String str = "";
        this.f13055n = str;
        this.f13056o = str;
        this.f13058q = str;
        this.f13061t = Color.rgb(66, Opcodes.I2B, 241);
        this.f13062u = Color.rgb(66, Opcodes.I2B, 241);
        this.f13063v = Color.rgb(66, Opcodes.I2B, 241);
        this.f13064w = 0;
        this.f13065x = 100;
        this.f13066y = C7014n.m14490b(getResources(), 14.0f);
        this.f13041A = (int) C7014n.m14489a(getResources(), 100.0f);
        this.f13060s = C7014n.m14489a(getResources(), 4.0f);
        this.f13067z = C7014n.m14490b(getResources(), 18.0f);
        mo22640b();
        mo22637a();
    }

    /* renamed from: e */
    private int m14465e(int i) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        int i2 = this.f13041A;
        return mode == Integer.MIN_VALUE ? Math.min(i2, size) : i2;
    }

    /* renamed from: o */
    private float m14466o() {
        return (((float) mo22645d()) / ((float) this.f13051j)) * 360.0f;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo22637a() {
        this.f13044c = new TextPaint();
        this.f13044c.setColor(this.f13048g);
        this.f13044c.setTextSize(this.f13047f);
        this.f13044c.setAntiAlias(true);
        this.f13045d = new TextPaint();
        this.f13045d.setColor(this.f13049h);
        this.f13045d.setTextSize(this.f13057p);
        this.f13045d.setAntiAlias(true);
        this.f13042a = new Paint();
        this.f13042a.setColor(this.f13052k);
        this.f13042a.setStyle(Style.STROKE);
        this.f13042a.setAntiAlias(true);
        this.f13042a.setStrokeWidth(this.f13053l);
        this.f13043b = new Paint();
        this.f13043b.setColor(this.f13054m);
        this.f13043b.setAntiAlias(true);
    }

    /* renamed from: a */
    public void mo22638a(float f) {
        this.f13053l = f;
        invalidate();
    }

    /* renamed from: a */
    public void mo22639a(int i) {
        this.f13050i = i;
        if (this.f13050i > mo22647e()) {
            this.f13050i %= mo22647e();
        }
        invalidate();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo22640b() {
        this.f13052k = this.f13061t;
        this.f13048g = this.f13062u;
        this.f13047f = this.f13066y;
        mo22642b(100);
        mo22639a(0);
        this.f13053l = this.f13060s;
        this.f13054m = 0;
        this.f13057p = this.f13067z;
        this.f13049h = this.f13063v;
    }

    /* renamed from: b */
    public void mo22641b(float f) {
        this.f13047f = f;
        invalidate();
    }

    /* renamed from: b */
    public void mo22642b(int i) {
        if (i > 0) {
            this.f13051j = i;
            invalidate();
        }
    }

    /* renamed from: c */
    public float mo22643c() {
        return this.f13053l;
    }

    /* renamed from: c */
    public void mo22644c(int i) {
        this.f13048g = i;
        invalidate();
    }

    /* renamed from: d */
    public int mo22645d() {
        return this.f13050i;
    }

    /* renamed from: d */
    public void mo22646d(int i) {
        this.f13052k = i;
        invalidate();
    }

    /* renamed from: e */
    public int mo22647e() {
        return this.f13051j;
    }

    /* renamed from: f */
    public float mo22648f() {
        return this.f13047f;
    }

    /* renamed from: g */
    public int mo22649g() {
        return this.f13048g;
    }

    /* renamed from: h */
    public int mo22650h() {
        return this.f13052k;
    }

    /* renamed from: i */
    public String mo22651i() {
        return this.f13056o;
    }

    public void invalidate() {
        mo22637a();
        super.invalidate();
    }

    /* renamed from: j */
    public String mo22653j() {
        return this.f13055n;
    }

    /* renamed from: k */
    public int mo22654k() {
        return this.f13054m;
    }

    /* renamed from: l */
    public String mo22655l() {
        return this.f13058q;
    }

    /* renamed from: m */
    public float mo22656m() {
        return this.f13057p;
    }

    /* renamed from: n */
    public int mo22657n() {
        return this.f13049h;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = this.f13053l;
        this.f13046e.set(f, f, ((float) getWidth()) - f, ((float) getHeight()) - f);
        float width = (float) getWidth();
        float f2 = this.f13053l;
        canvas.drawCircle(((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f, ((width - f2) + f2) / 2.0f, this.f13043b);
        canvas.drawArc(this.f13046e, 270.0f, -m14466o(), false, this.f13042a);
        StringBuilder sb = new StringBuilder();
        sb.append(this.f13055n);
        sb.append(this.f13050i);
        sb.append(this.f13056o);
        String sb2 = sb.toString();
        if (!TextUtils.isEmpty(sb2)) {
            canvas.drawText(sb2, (((float) getWidth()) - this.f13044c.measureText(sb2)) / 2.0f, (((float) getWidth()) - (this.f13044c.descent() + this.f13044c.ascent())) / 2.0f, this.f13044c);
        }
        if (!TextUtils.isEmpty(mo22655l())) {
            this.f13045d.setTextSize(this.f13057p);
            canvas.drawText(mo22655l(), (((float) getWidth()) - this.f13045d.measureText(mo22655l())) / 2.0f, (((float) getHeight()) - this.f13059r) - ((this.f13044c.descent() + this.f13044c.ascent()) / 2.0f), this.f13045d);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(m14465e(i), m14465e(i2));
        this.f13059r = (float) (getHeight() - ((getHeight() * 3) / 4));
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.f13048g = bundle.getInt("text_color");
            this.f13047f = bundle.getFloat("text_size");
            this.f13057p = bundle.getFloat("inner_bottom_text_size");
            this.f13058q = bundle.getString("inner_bottom_text");
            this.f13049h = bundle.getInt("inner_bottom_text_color");
            this.f13052k = bundle.getInt("finished_stroke_color");
            this.f13053l = bundle.getFloat("finished_stroke_width");
            this.f13054m = bundle.getInt("inner_background_color");
            mo22637a();
            mo22642b(bundle.getInt("max"));
            mo22639a(bundle.getInt("progress"));
            this.f13055n = bundle.getString("prefix");
            this.f13056o = bundle.getString("suffix");
            super.onRestoreInstanceState(bundle.getParcelable("saved_instance"));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("saved_instance", super.onSaveInstanceState());
        bundle.putInt("text_color", mo22649g());
        bundle.putFloat("text_size", mo22648f());
        bundle.putFloat("inner_bottom_text_size", mo22656m());
        String str = "inner_bottom_text_color";
        bundle.putFloat(str, (float) mo22657n());
        bundle.putString("inner_bottom_text", mo22655l());
        bundle.putInt(str, mo22657n());
        bundle.putInt("finished_stroke_color", mo22650h());
        bundle.putInt("max", mo22647e());
        bundle.putInt("progress", mo22645d());
        bundle.putString("suffix", mo22651i());
        bundle.putString("prefix", mo22653j());
        bundle.putFloat("finished_stroke_width", mo22643c());
        bundle.putInt("inner_background_color", mo22654k());
        return bundle;
    }
}
