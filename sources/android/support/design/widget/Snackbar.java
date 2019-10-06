package android.support.design.widget;

import android.content.Context;
import android.support.design.internal.SnackbarContentLayout;
import android.support.design.widget.C0307r.C0308a;
import android.support.design.widget.C0307r.C0310c;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import p002b.p003c.p050d.C1174h;

public final class Snackbar extends C0307r<Snackbar> {

    /* renamed from: k */
    private C0308a<Snackbar> f1037k;

    public static final class SnackbarLayout extends C0313f {
        public SnackbarLayout(Context context) {
            super(context);
        }

        public SnackbarLayout(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        /* access modifiers changed from: protected */
        public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            int childCount = getChildCount();
            int availableWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            for (int i = 0; i < childCount; i++) {
                View child = getChildAt(i);
                if (child.getLayoutParams().width == -1) {
                    child.measure(MeasureSpec.makeMeasureSpec(availableWidth, 1073741824), MeasureSpec.makeMeasureSpec(child.getMeasuredHeight(), 1073741824));
                }
            }
        }
    }

    /* renamed from: android.support.design.widget.Snackbar$a */
    public static class C0266a extends C0308a<Snackbar> {
        public static final int DISMISS_EVENT_ACTION = 1;
        public static final int DISMISS_EVENT_CONSECUTIVE = 4;
        public static final int DISMISS_EVENT_MANUAL = 3;
        public static final int DISMISS_EVENT_SWIPE = 0;
        public static final int DISMISS_EVENT_TIMEOUT = 2;

        public void onShown(Snackbar sb) {
        }

        public void onDismissed(Snackbar transientBottomBar, int event) {
        }
    }

    private Snackbar(ViewGroup parent, View content, C0310c contentViewCallback) {
        super(parent, content, contentViewCallback);
    }

    /* renamed from: a */
    public static Snackbar m1624a(View view, CharSequence text, int duration) {
        ViewGroup parent = m1625a(view);
        if (parent != null) {
            SnackbarContentLayout content = (SnackbarContentLayout) LayoutInflater.from(parent.getContext()).inflate(C1174h.design_layout_snackbar_include, parent, false);
            Snackbar snackbar = new Snackbar(parent, content, content);
            snackbar.mo4554a(text);
            snackbar.mo4686d(duration);
            return snackbar;
        }
        throw new IllegalArgumentException("No suitable parent found from the given view. Please provide a valid view.");
    }

    /* renamed from: a */
    public static Snackbar m1623a(View view, int resId, int duration) {
        return m1624a(view, view.getResources().getText(resId), duration);
    }

    /* renamed from: a */
    private static ViewGroup m1625a(View view) {
        ViewGroup fallback = null;
        while (!(view instanceof CoordinatorLayout)) {
            if (view instanceof FrameLayout) {
                if (view.getId() == 16908290) {
                    return (ViewGroup) view;
                }
                fallback = (ViewGroup) view;
            }
            if (view != null) {
                ViewParent parent = view.getParent();
                view = parent instanceof View ? (View) parent : null;
                continue;
            }
            if (view == null) {
                return fallback;
            }
        }
        return (ViewGroup) view;
    }

    /* renamed from: a */
    public Snackbar mo4554a(CharSequence message) {
        ((SnackbarContentLayout) this.f1119e.getChildAt(0)).getMessageView().setText(message);
        return this;
    }

    /* renamed from: a */
    public Snackbar mo4552a(int resId, OnClickListener listener) {
        mo4555a(mo4685d().getText(resId), listener);
        return this;
    }

    /* renamed from: a */
    public Snackbar mo4555a(CharSequence text, OnClickListener listener) {
        TextView tv = ((SnackbarContentLayout) this.f1119e.getChildAt(0)).getActionView();
        if (TextUtils.isEmpty(text) || listener == null) {
            tv.setVisibility(8);
            tv.setOnClickListener(null);
        } else {
            tv.setVisibility(0);
            tv.setText(text);
            tv.setOnClickListener(new C0264Q(this, listener));
        }
        return this;
    }

    @Deprecated
    /* renamed from: a */
    public Snackbar mo4553a(C0266a callback) {
        C0308a<Snackbar> aVar = this.f1037k;
        if (aVar != null) {
            mo4680b(aVar);
        }
        if (callback != null) {
            mo4678a((C0308a<B>) callback);
        }
        this.f1037k = callback;
        return this;
    }
}
