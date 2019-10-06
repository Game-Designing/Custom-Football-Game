package android.support.transition;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

/* renamed from: android.support.transition.B */
/* compiled from: PathProperty */
class C0323B<T> extends Property<T, Float> {

    /* renamed from: a */
    private final Property<T, PointF> f1146a;

    /* renamed from: b */
    private final PathMeasure f1147b;

    /* renamed from: c */
    private final float f1148c;

    /* renamed from: d */
    private final float[] f1149d = new float[2];

    /* renamed from: e */
    private final PointF f1150e = new PointF();

    /* renamed from: f */
    private float f1151f;

    C0323B(Property<T, PointF> property, Path path) {
        super(Float.class, property.getName());
        this.f1146a = property;
        this.f1147b = new PathMeasure(path, false);
        this.f1148c = this.f1147b.getLength();
    }

    public Float get(T t) {
        return Float.valueOf(this.f1151f);
    }

    /* renamed from: a */
    public void set(T target, Float fraction) {
        this.f1151f = fraction.floatValue();
        this.f1147b.getPosTan(this.f1148c * fraction.floatValue(), this.f1149d, null);
        PointF pointF = this.f1150e;
        float[] fArr = this.f1149d;
        pointF.x = fArr[0];
        pointF.y = fArr[1];
        this.f1146a.set(target, pointF);
    }
}
