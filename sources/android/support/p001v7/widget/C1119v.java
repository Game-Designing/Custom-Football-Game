package android.support.p001v7.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.p000v4.widget.C0716r;
import android.support.p001v7.appcompat.C0793R;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;

/* renamed from: android.support.v7.widget.v */
/* compiled from: AppCompatPopupWindow */
class C1119v extends PopupWindow {

    /* renamed from: a */
    private static final boolean f3705a = (VERSION.SDK_INT < 21);

    /* renamed from: b */
    private boolean f3706b;

    public C1119v(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        m5485a(context, attrs, defStyleAttr, defStyleRes);
    }

    /* renamed from: a */
    private void m5485a(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        C1112sb a = C1112sb.m5456a(context, attrs, C0793R.styleable.PopupWindow, defStyleAttr, defStyleRes);
        if (a.mo8660g(C0793R.styleable.PopupWindow_overlapAnchor)) {
            m5486a(a.mo8648a(C0793R.styleable.PopupWindow_overlapAnchor, false));
        }
        setBackgroundDrawable(a.mo8650b(C0793R.styleable.PopupWindow_android_popupBackground));
        a.mo8647a();
    }

    public void showAsDropDown(View anchor, int xoff, int yoff) {
        if (f3705a && this.f3706b) {
            yoff -= anchor.getHeight();
        }
        super.showAsDropDown(anchor, xoff, yoff);
    }

    public void showAsDropDown(View anchor, int xoff, int yoff, int gravity) {
        if (f3705a && this.f3706b) {
            yoff -= anchor.getHeight();
        }
        super.showAsDropDown(anchor, xoff, yoff, gravity);
    }

    public void update(View anchor, int xoff, int yoff, int width, int height) {
        if (f3705a && this.f3706b) {
            yoff -= anchor.getHeight();
        }
        super.update(anchor, xoff, yoff, width, height);
    }

    /* renamed from: a */
    private void m5486a(boolean overlapAnchor) {
        if (f3705a) {
            this.f3706b = overlapAnchor;
        } else {
            C0716r.m3356a((PopupWindow) this, overlapAnchor);
        }
    }
}
