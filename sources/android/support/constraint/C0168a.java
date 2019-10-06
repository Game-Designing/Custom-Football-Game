package android.support.constraint;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.constraint.p034a.p035a.C0171b;
import android.util.AttributeSet;

/* renamed from: android.support.constraint.a */
/* compiled from: Barrier */
public class C0168a extends C0205b {

    /* renamed from: g */
    private int f316g;

    /* renamed from: h */
    private int f317h;

    /* renamed from: i */
    private C0171b f318i;

    public C0168a(Context context) {
        super(context);
        super.setVisibility(8);
    }

    public int getType() {
        return this.f316g;
    }

    public void setType(int type) {
        this.f316g = type;
        this.f317h = type;
        if (VERSION.SDK_INT < 17) {
            int i = this.f316g;
            if (i == 5) {
                this.f317h = 0;
            } else if (i == 6) {
                this.f317h = 1;
            }
        } else {
            if (1 == getResources().getConfiguration().getLayoutDirection()) {
                int i2 = this.f316g;
                if (i2 == 5) {
                    this.f317h = 1;
                } else if (i2 == 6) {
                    this.f317h = 0;
                }
            } else {
                int i3 = this.f316g;
                if (i3 == 5) {
                    this.f317h = 0;
                } else if (i3 == 6) {
                    this.f317h = 1;
                }
            }
        }
        this.f318i.mo3834t(this.f317h);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3808a(AttributeSet attrs) {
        super.mo3808a(attrs);
        this.f318i = new C0171b();
        if (attrs != null) {
            TypedArray a = getContext().obtainStyledAttributes(attrs, C0214i.ConstraintLayout_Layout);
            int N = a.getIndexCount();
            for (int i = 0; i < N; i++) {
                int attr = a.getIndex(i);
                if (attr == C0214i.ConstraintLayout_Layout_barrierDirection) {
                    setType(a.getInt(attr, 0));
                } else if (attr == C0214i.ConstraintLayout_Layout_barrierAllowsGoneWidgets) {
                    this.f318i.mo3833c(a.getBoolean(attr, true));
                }
            }
        }
        this.f610d = this.f318i;
        mo4040a();
    }

    public void setAllowsGoneWidget(boolean supportGone) {
        this.f318i.mo3833c(supportGone);
    }
}
