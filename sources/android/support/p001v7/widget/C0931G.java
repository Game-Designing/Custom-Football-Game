package android.support.p001v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.p001v7.appcompat.C0793R;
import android.util.AttributeSet;
import android.widget.TextView;

/* renamed from: android.support.v7.widget.G */
/* compiled from: AppCompatTextHelperV17 */
class C0931G extends C0928F {

    /* renamed from: j */
    private C1106qb f2983j;

    /* renamed from: k */
    private C1106qb f2984k;

    C0931G(TextView view) {
        super(view);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7202a(AttributeSet attrs, int defStyleAttr) {
        super.mo7202a(attrs, defStyleAttr);
        Context context = this.f2970a.getContext();
        C1096p drawableManager = C1096p.m5420a();
        TypedArray a = context.obtainStyledAttributes(attrs, C0793R.styleable.AppCompatTextHelper, defStyleAttr, 0);
        if (a.hasValue(C0793R.styleable.AppCompatTextHelper_android_drawableStart)) {
            this.f2983j = C0928F.m4445a(context, drawableManager, a.getResourceId(C0793R.styleable.AppCompatTextHelper_android_drawableStart, 0));
        }
        if (a.hasValue(C0793R.styleable.AppCompatTextHelper_android_drawableEnd)) {
            this.f2984k = C0928F.m4445a(context, drawableManager, a.getResourceId(C0793R.styleable.AppCompatTextHelper_android_drawableEnd, 0));
        }
        a.recycle();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7196a() {
        super.mo7196a();
        if (this.f2983j != null || this.f2984k != null) {
            Drawable[] compoundDrawables = this.f2970a.getCompoundDrawablesRelative();
            mo7201a(compoundDrawables[0], this.f2983j);
            mo7201a(compoundDrawables[2], this.f2984k);
        }
    }
}
