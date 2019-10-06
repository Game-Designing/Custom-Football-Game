package android.support.transition;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Property;

/* renamed from: android.support.transition.g */
/* compiled from: ChangeBounds */
class C0366g extends Property<Drawable, PointF> {

    /* renamed from: a */
    private Rect f1243a = new Rect();

    C0366g(Class x0, String x1) {
        super(x0, x1);
    }

    /* renamed from: a */
    public void set(Drawable object, PointF value) {
        object.copyBounds(this.f1243a);
        this.f1243a.offsetTo(Math.round(value.x), Math.round(value.y));
        object.setBounds(this.f1243a);
    }

    /* renamed from: a */
    public PointF get(Drawable object) {
        object.copyBounds(this.f1243a);
        Rect rect = this.f1243a;
        return new PointF((float) rect.left, (float) rect.top);
    }
}
