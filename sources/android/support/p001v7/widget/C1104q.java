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
import android.widget.EditText;
import android.widget.TextView;

/* renamed from: android.support.v7.widget.q */
/* compiled from: AppCompatEditText */
public class C1104q extends EditText implements C0645v {

    /* renamed from: a */
    private final C1079l f3682a;

    /* renamed from: b */
    private final C0928F f3683b;

    public C1104q(Context context) {
        this(context, null);
    }

    public C1104q(Context context, AttributeSet attrs) {
        this(context, attrs, C0793R.attr.editTextStyle);
    }

    public C1104q(Context context, AttributeSet attrs, int defStyleAttr) {
        super(C1103pb.m5450a(context), attrs, defStyleAttr);
        this.f3682a = new C1079l(this);
        this.f3682a.mo8511a(attrs, defStyleAttr);
        this.f3683b = C0928F.m4444a((TextView) this);
        this.f3683b.mo7202a(attrs, defStyleAttr);
        this.f3683b.mo7196a();
    }

    public void setBackgroundResource(int resId) {
        super.setBackgroundResource(resId);
        C1079l lVar = this.f3682a;
        if (lVar != null) {
            lVar.mo8507a(resId);
        }
    }

    public void setBackgroundDrawable(Drawable background) {
        super.setBackgroundDrawable(background);
        C1079l lVar = this.f3682a;
        if (lVar != null) {
            lVar.mo8510a(background);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList tint) {
        C1079l lVar = this.f3682a;
        if (lVar != null) {
            lVar.mo8513b(tint);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C1079l lVar = this.f3682a;
        if (lVar != null) {
            return lVar.mo8512b();
        }
        return null;
    }

    public void setSupportBackgroundTintMode(Mode tintMode) {
        C1079l lVar = this.f3682a;
        if (lVar != null) {
            lVar.mo8509a(tintMode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        C1079l lVar = this.f3682a;
        if (lVar != null) {
            return lVar.mo8514c();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C1079l lVar = this.f3682a;
        if (lVar != null) {
            lVar.mo8506a();
        }
        C0928F f = this.f3683b;
        if (f != null) {
            f.mo7196a();
        }
    }

    public void setTextAppearance(Context context, int resId) {
        super.setTextAppearance(context, resId);
        C0928F f = this.f3683b;
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
