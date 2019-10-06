package android.support.p001v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.p000v4.content.p036a.C0507d;
import android.support.p000v4.content.p036a.C0507d.C0508a;
import android.util.AttributeSet;
import android.util.TypedValue;
import p002b.p003c.p062h.p064b.p065a.C1282b;

/* renamed from: android.support.v7.widget.sb */
/* compiled from: TintTypedArray */
public class C1112sb {

    /* renamed from: a */
    private final Context f3691a;

    /* renamed from: b */
    private final TypedArray f3692b;

    /* renamed from: c */
    private TypedValue f3693c;

    /* renamed from: a */
    public static C1112sb m5455a(Context context, AttributeSet set, int[] attrs) {
        return new C1112sb(context, context.obtainStyledAttributes(set, attrs));
    }

    /* renamed from: a */
    public static C1112sb m5456a(Context context, AttributeSet set, int[] attrs, int defStyleAttr, int defStyleRes) {
        return new C1112sb(context, context.obtainStyledAttributes(set, attrs, defStyleAttr, defStyleRes));
    }

    /* renamed from: a */
    public static C1112sb m5454a(Context context, int resid, int[] attrs) {
        return new C1112sb(context, context.obtainStyledAttributes(resid, attrs));
    }

    private C1112sb(Context context, TypedArray array) {
        this.f3691a = context;
        this.f3692b = array;
    }

    /* renamed from: b */
    public Drawable mo8650b(int index) {
        if (this.f3692b.hasValue(index)) {
            int resourceId = this.f3692b.getResourceId(index, 0);
            if (resourceId != 0) {
                return C1282b.m6000b(this.f3691a, resourceId);
            }
        }
        return this.f3692b.getDrawable(index);
    }

    /* renamed from: c */
    public Drawable mo8652c(int index) {
        if (this.f3692b.hasValue(index)) {
            int resourceId = this.f3692b.getResourceId(index, 0);
            if (resourceId != 0) {
                return C1096p.m5420a().mo8566a(this.f3691a, resourceId, true);
            }
        }
        return null;
    }

    /* renamed from: a */
    public Typeface mo8646a(int index, int style, C0508a fontCallback) {
        int resourceId = this.f3692b.getResourceId(index, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f3693c == null) {
            this.f3693c = new TypedValue();
        }
        return C0507d.m2539a(this.f3691a, resourceId, this.f3693c, style, fontCallback);
    }

    /* renamed from: e */
    public CharSequence mo8656e(int index) {
        return this.f3692b.getText(index);
    }

    /* renamed from: d */
    public String mo8654d(int index) {
        return this.f3692b.getString(index);
    }

    /* renamed from: a */
    public boolean mo8648a(int index, boolean defValue) {
        return this.f3692b.getBoolean(index, defValue);
    }

    /* renamed from: d */
    public int mo8653d(int index, int defValue) {
        return this.f3692b.getInt(index, defValue);
    }

    /* renamed from: a */
    public float mo8643a(int index, float defValue) {
        return this.f3692b.getFloat(index, defValue);
    }

    /* renamed from: a */
    public int mo8644a(int index, int defValue) {
        return this.f3692b.getColor(index, defValue);
    }

    /* renamed from: a */
    public ColorStateList mo8645a(int index) {
        if (this.f3692b.hasValue(index)) {
            int resourceId = this.f3692b.getResourceId(index, 0);
            if (resourceId != 0) {
                ColorStateList value = C1282b.m5997a(this.f3691a, resourceId);
                if (value != null) {
                    return value;
                }
            }
        }
        return this.f3692b.getColorStateList(index);
    }

    /* renamed from: e */
    public int mo8655e(int index, int defValue) {
        return this.f3692b.getInteger(index, defValue);
    }

    /* renamed from: b */
    public int mo8649b(int index, int defValue) {
        return this.f3692b.getDimensionPixelOffset(index, defValue);
    }

    /* renamed from: c */
    public int mo8651c(int index, int defValue) {
        return this.f3692b.getDimensionPixelSize(index, defValue);
    }

    /* renamed from: f */
    public int mo8657f(int index, int defValue) {
        return this.f3692b.getLayoutDimension(index, defValue);
    }

    /* renamed from: g */
    public int mo8659g(int index, int defValue) {
        return this.f3692b.getResourceId(index, defValue);
    }

    /* renamed from: f */
    public CharSequence[] mo8658f(int index) {
        return this.f3692b.getTextArray(index);
    }

    /* renamed from: g */
    public boolean mo8660g(int index) {
        return this.f3692b.hasValue(index);
    }

    /* renamed from: a */
    public void mo8647a() {
        this.f3692b.recycle();
    }
}
