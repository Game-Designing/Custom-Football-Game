package android.support.p001v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.p000v4.view.C0645v;
import android.support.p001v7.appcompat.C0793R;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import p002b.p003c.p062h.p064b.p065a.C1282b;

/* renamed from: android.support.v7.widget.k */
/* compiled from: AppCompatAutoCompleteTextView */
public class C1075k extends AutoCompleteTextView implements C0645v {

    /* renamed from: a */
    private static final int[] f3577a = {16843126};

    /* renamed from: b */
    private final C1079l f3578b;

    /* renamed from: c */
    private final C0928F f3579c;

    public C1075k(Context context) {
        this(context, null);
    }

    public C1075k(Context context, AttributeSet attrs) {
        this(context, attrs, C0793R.attr.autoCompleteTextViewStyle);
    }

    public C1075k(Context context, AttributeSet attrs, int defStyleAttr) {
        super(C1103pb.m5450a(context), attrs, defStyleAttr);
        C1112sb a = C1112sb.m5456a(getContext(), attrs, f3577a, defStyleAttr, 0);
        if (a.mo8660g(0)) {
            setDropDownBackgroundDrawable(a.mo8650b(0));
        }
        a.mo8647a();
        this.f3578b = new C1079l(this);
        this.f3578b.mo8511a(attrs, defStyleAttr);
        this.f3579c = C0928F.m4444a((TextView) this);
        this.f3579c.mo7202a(attrs, defStyleAttr);
        this.f3579c.mo7196a();
    }

    public void setDropDownBackgroundResource(int resId) {
        setDropDownBackgroundDrawable(C1282b.m6000b(getContext(), resId));
    }

    public void setBackgroundResource(int resId) {
        super.setBackgroundResource(resId);
        C1079l lVar = this.f3578b;
        if (lVar != null) {
            lVar.mo8507a(resId);
        }
    }

    public void setBackgroundDrawable(Drawable background) {
        super.setBackgroundDrawable(background);
        C1079l lVar = this.f3578b;
        if (lVar != null) {
            lVar.mo8510a(background);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList tint) {
        C1079l lVar = this.f3578b;
        if (lVar != null) {
            lVar.mo8513b(tint);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C1079l lVar = this.f3578b;
        if (lVar != null) {
            return lVar.mo8512b();
        }
        return null;
    }

    public void setSupportBackgroundTintMode(Mode tintMode) {
        C1079l lVar = this.f3578b;
        if (lVar != null) {
            lVar.mo8509a(tintMode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        C1079l lVar = this.f3578b;
        if (lVar != null) {
            return lVar.mo8514c();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C1079l lVar = this.f3578b;
        if (lVar != null) {
            lVar.mo8506a();
        }
        C0928F f = this.f3579c;
        if (f != null) {
            f.mo7196a();
        }
    }

    public void setTextAppearance(Context context, int resId) {
        super.setTextAppearance(context, resId);
        C0928F f = this.f3579c;
        if (f != null) {
            f.mo7200a(context, resId);
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(outAttrs);
        C1107r.m5453a(onCreateInputConnection, outAttrs, this);
        return onCreateInputConnection;
    }
}
