package android.support.p001v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import android.widget.TextView;
import p002b.p003c.p062h.p064b.p065a.C1282b;

/* renamed from: android.support.v7.widget.n */
/* compiled from: AppCompatCheckedTextView */
public class C1088n extends CheckedTextView {

    /* renamed from: a */
    private static final int[] f3618a = {16843016};

    /* renamed from: b */
    private final C0928F f3619b;

    public C1088n(Context context, AttributeSet attrs) {
        this(context, attrs, 16843720);
    }

    public C1088n(Context context, AttributeSet attrs, int defStyleAttr) {
        super(C1103pb.m5450a(context), attrs, defStyleAttr);
        this.f3619b = C0928F.m4444a((TextView) this);
        this.f3619b.mo7202a(attrs, defStyleAttr);
        this.f3619b.mo7196a();
        C1112sb a = C1112sb.m5456a(getContext(), attrs, f3618a, defStyleAttr, 0);
        setCheckMarkDrawable(a.mo8650b(0));
        a.mo8647a();
    }

    public void setCheckMarkDrawable(int resId) {
        setCheckMarkDrawable(C1282b.m6000b(getContext(), resId));
    }

    public void setTextAppearance(Context context, int resId) {
        super.setTextAppearance(context, resId);
        C0928F f = this.f3619b;
        if (f != null) {
            f.mo7200a(context, resId);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C0928F f = this.f3619b;
        if (f != null) {
            f.mo7196a();
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(outAttrs);
        C1107r.m5453a(onCreateInputConnection, outAttrs, this);
        return onCreateInputConnection;
    }
}
