package android.support.p001v7.widget;

import android.util.Property;

/* renamed from: android.support.v7.widget.mb */
/* compiled from: SwitchCompat */
class C1087mb extends Property<SwitchCompat, Float> {
    C1087mb(Class x0, String x1) {
        super(x0, x1);
    }

    /* renamed from: a */
    public Float get(SwitchCompat object) {
        return Float.valueOf(object.f3372z);
    }

    /* renamed from: a */
    public void set(SwitchCompat object, Float value) {
        object.setThumbPosition(value.floatValue());
    }
}
