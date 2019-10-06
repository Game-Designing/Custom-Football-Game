package android.support.design.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.widget.C0307r.C0310c;
import android.support.p000v4.view.C0646w;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import p002b.p003c.p050d.C1170d;
import p002b.p003c.p050d.C1172f;
import p002b.p003c.p050d.C1177k;

public class SnackbarContentLayout extends LinearLayout implements C0310c {

    /* renamed from: a */
    private TextView f726a;

    /* renamed from: b */
    private Button f727b;

    /* renamed from: c */
    private int f728c;

    /* renamed from: d */
    private int f729d;

    public SnackbarContentLayout(Context context) {
        this(context, null);
    }

    public SnackbarContentLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, C1177k.SnackbarLayout);
        this.f728c = a.getDimensionPixelSize(C1177k.SnackbarLayout_android_maxWidth, -1);
        this.f729d = a.getDimensionPixelSize(C1177k.SnackbarLayout_maxActionInlineWidth, -1);
        a.recycle();
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f726a = (TextView) findViewById(C1172f.snackbar_text);
        this.f727b = (Button) findViewById(C1172f.snackbar_action);
    }

    public TextView getMessageView() {
        return this.f726a;
    }

    public Button getActionView() {
        return this.f727b;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (this.f728c > 0) {
            int measuredWidth = getMeasuredWidth();
            int i = this.f728c;
            if (measuredWidth > i) {
                widthMeasureSpec = MeasureSpec.makeMeasureSpec(i, 1073741824);
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            }
        }
        int multiLineVPadding = getResources().getDimensionPixelSize(C1170d.design_snackbar_padding_vertical_2lines);
        int singleLineVPadding = getResources().getDimensionPixelSize(C1170d.design_snackbar_padding_vertical);
        boolean isMultiLine = this.f726a.getLayout().getLineCount() > 1;
        boolean remeasure = false;
        if (!isMultiLine || this.f729d <= 0 || this.f727b.getMeasuredWidth() <= this.f729d) {
            int messagePadding = isMultiLine ? multiLineVPadding : singleLineVPadding;
            if (m1234a(0, messagePadding, messagePadding)) {
                remeasure = true;
            }
        } else if (m1234a(1, multiLineVPadding, multiLineVPadding - singleLineVPadding)) {
            remeasure = true;
        }
        if (remeasure) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    /* renamed from: a */
    private boolean m1234a(int orientation, int messagePadTop, int messagePadBottom) {
        boolean changed = false;
        if (orientation != getOrientation()) {
            setOrientation(orientation);
            changed = true;
        }
        if (this.f726a.getPaddingTop() == messagePadTop && this.f726a.getPaddingBottom() == messagePadBottom) {
            return changed;
        }
        m1233a((View) this.f726a, messagePadTop, messagePadBottom);
        return true;
    }

    /* renamed from: a */
    private static void m1233a(View view, int topPadding, int bottomPadding) {
        if (C0646w.m2989w(view)) {
            C0646w.m2950a(view, C0646w.m2978l(view), topPadding, C0646w.m2977k(view), bottomPadding);
        } else {
            view.setPadding(view.getPaddingLeft(), topPadding, view.getPaddingRight(), bottomPadding);
        }
    }

    /* renamed from: a */
    public void mo4102a(int delay, int duration) {
        this.f726a.setAlpha(0.0f);
        this.f726a.animate().alpha(1.0f).setDuration((long) duration).setStartDelay((long) delay).start();
        if (this.f727b.getVisibility() == 0) {
            this.f727b.setAlpha(0.0f);
            this.f727b.animate().alpha(1.0f).setDuration((long) duration).setStartDelay((long) delay).start();
        }
    }

    /* renamed from: b */
    public void mo4103b(int delay, int duration) {
        this.f726a.setAlpha(1.0f);
        this.f726a.animate().alpha(0.0f).setDuration((long) duration).setStartDelay((long) delay).start();
        if (this.f727b.getVisibility() == 0) {
            this.f727b.setAlpha(1.0f);
            this.f727b.animate().alpha(0.0f).setDuration((long) duration).setStartDelay((long) delay).start();
        }
    }
}
