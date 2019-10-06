package android.support.p001v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.p000v4.view.C0587I;
import android.support.p000v4.view.C0646w;
import android.support.p001v7.appcompat.C0793R;
import android.support.p001v7.view.menu.C0873l;
import android.support.p001v7.view.menu.C0890v;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import p002b.p003c.p062h.p071g.C1300b;

/* renamed from: android.support.v7.widget.ActionBarContextView */
public class ActionBarContextView extends C1035a {

    /* renamed from: i */
    private CharSequence f2822i;

    /* renamed from: j */
    private CharSequence f2823j;

    /* renamed from: k */
    private View f2824k;

    /* renamed from: l */
    private View f2825l;

    /* renamed from: m */
    private LinearLayout f2826m;

    /* renamed from: n */
    private TextView f2827n;

    /* renamed from: o */
    private TextView f2828o;

    /* renamed from: p */
    private int f2829p;

    /* renamed from: q */
    private int f2830q;

    /* renamed from: r */
    private boolean f2831r;

    /* renamed from: s */
    private int f2832s;

    /* renamed from: a */
    public /* bridge */ /* synthetic */ C0587I mo6998a(int i, long j) {
        return super.mo6998a(i, j);
    }

    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    public ActionBarContextView(Context context, AttributeSet attrs) {
        this(context, attrs, C0793R.attr.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        C1112sb a = C1112sb.m5456a(context, attrs, C0793R.styleable.ActionMode, defStyle, 0);
        C0646w.m2954a((View) this, a.mo8650b(C0793R.styleable.ActionMode_background));
        this.f2829p = a.mo8659g(C0793R.styleable.ActionMode_titleTextStyle, 0);
        this.f2830q = a.mo8659g(C0793R.styleable.ActionMode_subtitleTextStyle, 0);
        this.f3451e = a.mo8657f(C0793R.styleable.ActionMode_height, 0);
        this.f2832s = a.mo8659g(C0793R.styleable.ActionMode_closeItemLayout, C0793R.layout.abc_action_mode_close_item_material);
        a.mo8647a();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActionMenuPresenter actionMenuPresenter = this.f3450d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.mo7070f();
            this.f3450d.mo7071g();
        }
    }

    public void setContentHeight(int height) {
        this.f3451e = height;
    }

    public void setCustomView(View view) {
        View view2 = this.f2825l;
        if (view2 != null) {
            removeView(view2);
        }
        this.f2825l = view;
        if (view != null) {
            LinearLayout linearLayout = this.f2826m;
            if (linearLayout != null) {
                removeView(linearLayout);
                this.f2826m = null;
            }
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setTitle(CharSequence title) {
        this.f2822i = title;
        m4310e();
    }

    public void setSubtitle(CharSequence subtitle) {
        this.f2823j = subtitle;
        m4310e();
    }

    public CharSequence getTitle() {
        return this.f2822i;
    }

    public CharSequence getSubtitle() {
        return this.f2823j;
    }

    /* renamed from: e */
    private void m4310e() {
        if (this.f2826m == null) {
            LayoutInflater.from(getContext()).inflate(C0793R.layout.abc_action_bar_title_item, this);
            this.f2826m = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f2827n = (TextView) this.f2826m.findViewById(C0793R.C0794id.action_bar_title);
            this.f2828o = (TextView) this.f2826m.findViewById(C0793R.C0794id.action_bar_subtitle);
            if (this.f2829p != 0) {
                this.f2827n.setTextAppearance(getContext(), this.f2829p);
            }
            if (this.f2830q != 0) {
                this.f2828o.setTextAppearance(getContext(), this.f2830q);
            }
        }
        this.f2827n.setText(this.f2822i);
        this.f2828o.setText(this.f2823j);
        boolean hasTitle = !TextUtils.isEmpty(this.f2822i);
        boolean hasSubtitle = !TextUtils.isEmpty(this.f2823j);
        int i = 0;
        this.f2828o.setVisibility(hasSubtitle ? 0 : 8);
        LinearLayout linearLayout = this.f2826m;
        if (!hasTitle && !hasSubtitle) {
            i = 8;
        }
        linearLayout.setVisibility(i);
        if (this.f2826m.getParent() == null) {
            addView(this.f2826m);
        }
    }

    /* renamed from: a */
    public void mo7000a(C1300b mode) {
        View view = this.f2824k;
        if (view == null) {
            this.f2824k = LayoutInflater.from(getContext()).inflate(this.f2832s, this, false);
            addView(this.f2824k);
        } else if (view.getParent() == null) {
            addView(this.f2824k);
        }
        this.f2824k.findViewById(C0793R.C0794id.action_mode_close_button).setOnClickListener(new C1046d(this, mode));
        C0873l menu = (C0873l) mode.mo6193c();
        ActionMenuPresenter actionMenuPresenter = this.f3450d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.mo7068d();
        }
        this.f3450d = new ActionMenuPresenter(getContext());
        this.f3450d.mo7067c(true);
        LayoutParams layoutParams = new LayoutParams(-2, -1);
        menu.mo6709a((C0890v) this.f3450d, this.f3448b);
        this.f3449c = (ActionMenuView) this.f3450d.mo6664b((ViewGroup) this);
        C0646w.m2954a((View) this.f3449c, (Drawable) null);
        addView(this.f3449c, layoutParams);
    }

    /* renamed from: a */
    public void mo6999a() {
        if (this.f2824k == null) {
            mo7002c();
        }
    }

    /* renamed from: c */
    public void mo7002c() {
        removeAllViews();
        this.f2825l = null;
        this.f3449c = null;
    }

    /* renamed from: d */
    public boolean mo7003d() {
        ActionMenuPresenter actionMenuPresenter = this.f3450d;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.mo7074j();
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(-1, -2);
    }

    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        String str = " can only be used ";
        int customHeightMode = 1073741824;
        if (widthMode != 1073741824) {
            StringBuilder sb = new StringBuilder();
            sb.append(getClass().getSimpleName());
            sb.append(str);
            sb.append("with android:layout_width=\"match_parent\" (or fill_parent)");
            throw new IllegalStateException(sb.toString());
        } else if (MeasureSpec.getMode(heightMeasureSpec) != 0) {
            int contentWidth = MeasureSpec.getSize(widthMeasureSpec);
            int maxHeight = this.f3451e;
            if (maxHeight <= 0) {
                maxHeight = MeasureSpec.getSize(heightMeasureSpec);
            }
            int verticalPadding = getPaddingTop() + getPaddingBottom();
            int availableWidth = (contentWidth - getPaddingLeft()) - getPaddingRight();
            int height = maxHeight - verticalPadding;
            int childSpecHeight = MeasureSpec.makeMeasureSpec(height, LinearLayoutManager.INVALID_OFFSET);
            View view = this.f2824k;
            int i = 0;
            if (view != null) {
                int availableWidth2 = mo8376a(view, availableWidth, childSpecHeight, 0);
                MarginLayoutParams lp = (MarginLayoutParams) this.f2824k.getLayoutParams();
                availableWidth = availableWidth2 - (lp.leftMargin + lp.rightMargin);
            }
            ActionMenuView actionMenuView = this.f3449c;
            if (actionMenuView != null && actionMenuView.getParent() == this) {
                availableWidth = mo8376a(this.f3449c, availableWidth, childSpecHeight, 0);
            }
            LinearLayout linearLayout = this.f2826m;
            if (linearLayout != null && this.f2825l == null) {
                if (this.f2831r) {
                    this.f2826m.measure(MeasureSpec.makeMeasureSpec(0, 0), childSpecHeight);
                    int titleWidth = this.f2826m.getMeasuredWidth();
                    boolean titleFits = titleWidth <= availableWidth;
                    if (titleFits) {
                        availableWidth -= titleWidth;
                    }
                    LinearLayout linearLayout2 = this.f2826m;
                    if (!titleFits) {
                        i = 8;
                    }
                    linearLayout2.setVisibility(i);
                } else {
                    availableWidth = mo8376a(linearLayout, availableWidth, childSpecHeight, 0);
                }
            }
            View view2 = this.f2825l;
            if (view2 != null) {
                LayoutParams lp2 = view2.getLayoutParams();
                int customWidthMode = lp2.width != -2 ? 1073741824 : LinearLayoutManager.INVALID_OFFSET;
                int i2 = lp2.width;
                int customWidth = i2 >= 0 ? Math.min(i2, availableWidth) : availableWidth;
                if (lp2.height == -2) {
                    customHeightMode = LinearLayoutManager.INVALID_OFFSET;
                }
                int i3 = lp2.height;
                int i4 = widthMode;
                this.f2825l.measure(MeasureSpec.makeMeasureSpec(customWidth, customWidthMode), MeasureSpec.makeMeasureSpec(i3 >= 0 ? Math.min(i3, height) : height, customHeightMode));
            }
            if (this.f3451e <= 0) {
                int measuredHeight = 0;
                int count = getChildCount();
                for (int i5 = 0; i5 < count; i5++) {
                    int paddedViewHeight = getChildAt(i5).getMeasuredHeight() + verticalPadding;
                    if (paddedViewHeight > measuredHeight) {
                        measuredHeight = paddedViewHeight;
                    }
                }
                setMeasuredDimension(contentWidth, measuredHeight);
                return;
            }
            setMeasuredDimension(contentWidth, maxHeight);
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(getClass().getSimpleName());
            sb2.append(str);
            sb2.append("with android:layout_height=\"wrap_content\"");
            throw new IllegalStateException(sb2.toString());
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int l, int t, int r, int b) {
        int x;
        boolean isLayoutRtl = C0946Ib.m4565a(this);
        int x2 = isLayoutRtl ? (r - l) - getPaddingRight() : getPaddingLeft();
        int y = getPaddingTop();
        int contentHeight = ((b - t) - getPaddingTop()) - getPaddingBottom();
        View view = this.f2824k;
        if (view == null || view.getVisibility() == 8) {
            x = x2;
        } else {
            MarginLayoutParams lp = (MarginLayoutParams) this.f2824k.getLayoutParams();
            int endMargin = isLayoutRtl ? lp.leftMargin : lp.rightMargin;
            int x3 = C1035a.m5201a(x2, isLayoutRtl ? lp.rightMargin : lp.leftMargin, isLayoutRtl);
            x = C1035a.m5201a(x3 + mo8377a(this.f2824k, x3, y, contentHeight, isLayoutRtl), endMargin, isLayoutRtl);
        }
        LinearLayout linearLayout = this.f2826m;
        if (!(linearLayout == null || this.f2825l != null || linearLayout.getVisibility() == 8)) {
            x += mo8377a(this.f2826m, x, y, contentHeight, isLayoutRtl);
        }
        View view2 = this.f2825l;
        if (view2 != null) {
            int x4 = x + mo8377a(view2, x, y, contentHeight, isLayoutRtl);
        }
        int x5 = isLayoutRtl ? getPaddingLeft() : (r - l) - getPaddingRight();
        ActionMenuView actionMenuView = this.f3449c;
        if (actionMenuView != null) {
            int x6 = x5 + mo8377a(actionMenuView, x5, y, contentHeight, !isLayoutRtl);
        }
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        if (event.getEventType() == 32) {
            event.setSource(this);
            event.setClassName(getClass().getName());
            event.setPackageName(getContext().getPackageName());
            event.setContentDescription(this.f2822i);
            return;
        }
        super.onInitializeAccessibilityEvent(event);
    }

    public void setTitleOptional(boolean titleOptional) {
        if (titleOptional != this.f2831r) {
            requestLayout();
        }
        this.f2831r = titleOptional;
    }

    /* renamed from: b */
    public boolean mo7001b() {
        return this.f2831r;
    }
}
