package android.support.p001v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.p001v7.app.C0760a.C0763c;
import android.support.p001v7.appcompat.C0793R;
import android.support.p001v7.widget.C1101pa.C1102a;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Spinner;
import android.widget.TextView;
import p002b.p003c.p062h.p071g.C1299a;

/* renamed from: android.support.v7.widget.Sa */
/* compiled from: ScrollingTabContainerView */
public class C1004Sa extends HorizontalScrollView implements OnItemSelectedListener {

    /* renamed from: a */
    private static final Interpolator f3246a = new DecelerateInterpolator();

    /* renamed from: b */
    Runnable f3247b;

    /* renamed from: c */
    private C1006b f3248c;

    /* renamed from: d */
    C1101pa f3249d;

    /* renamed from: e */
    private Spinner f3250e;

    /* renamed from: f */
    private boolean f3251f;

    /* renamed from: g */
    int f3252g;

    /* renamed from: h */
    int f3253h;

    /* renamed from: i */
    private int f3254i;

    /* renamed from: j */
    private int f3255j;

    /* renamed from: android.support.v7.widget.Sa$a */
    /* compiled from: ScrollingTabContainerView */
    private class C1005a extends BaseAdapter {
        C1005a() {
        }

        public int getCount() {
            return C1004Sa.this.f3249d.getChildCount();
        }

        public Object getItem(int position) {
            return ((C1007c) C1004Sa.this.f3249d.getChildAt(position)).mo8040a();
        }

        public long getItemId(int position) {
            return (long) position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                return C1004Sa.this.mo8024a((C0763c) getItem(position), true);
            }
            ((C1007c) convertView).mo8041a((C0763c) getItem(position));
            return convertView;
        }
    }

    /* renamed from: android.support.v7.widget.Sa$b */
    /* compiled from: ScrollingTabContainerView */
    private class C1006b implements OnClickListener {
        C1006b() {
        }

        public void onClick(View view) {
            ((C1007c) view).mo8040a().mo6205e();
            int tabCount = C1004Sa.this.f3249d.getChildCount();
            for (int i = 0; i < tabCount; i++) {
                View child = C1004Sa.this.f3249d.getChildAt(i);
                child.setSelected(child == view);
            }
        }
    }

    /* renamed from: android.support.v7.widget.Sa$c */
    /* compiled from: ScrollingTabContainerView */
    private class C1007c extends LinearLayout {

        /* renamed from: a */
        private final int[] f3258a = {16842964};

        /* renamed from: b */
        private C0763c f3259b;

        /* renamed from: c */
        private TextView f3260c;

        /* renamed from: d */
        private ImageView f3261d;

        /* renamed from: e */
        private View f3262e;

        public C1007c(Context context, C0763c tab, boolean forList) {
            super(context, null, C0793R.attr.actionBarTabStyle);
            this.f3259b = tab;
            C1112sb a = C1112sb.m5456a(context, null, this.f3258a, C0793R.attr.actionBarTabStyle, 0);
            if (a.mo8660g(0)) {
                setBackgroundDrawable(a.mo8650b(0));
            }
            a.mo8647a();
            if (forList) {
                setGravity(8388627);
            }
            mo8042b();
        }

        /* renamed from: a */
        public void mo8041a(C0763c tab) {
            this.f3259b = tab;
            mo8042b();
        }

        public void setSelected(boolean selected) {
            boolean changed = isSelected() != selected;
            super.setSelected(selected);
            if (changed && selected) {
                sendAccessibilityEvent(4);
            }
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
            super.onInitializeAccessibilityEvent(event);
            event.setClassName(C0763c.class.getName());
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
            super.onInitializeAccessibilityNodeInfo(info);
            info.setClassName(C0763c.class.getName());
        }

        public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            if (C1004Sa.this.f3252g > 0) {
                int measuredWidth = getMeasuredWidth();
                int i = C1004Sa.this.f3252g;
                if (measuredWidth > i) {
                    super.onMeasure(MeasureSpec.makeMeasureSpec(i, 1073741824), heightMeasureSpec);
                }
            }
        }

        /* renamed from: b */
        public void mo8042b() {
            C0763c tab = this.f3259b;
            View custom = tab.mo6202b();
            CharSequence charSequence = null;
            if (custom != null) {
                ViewParent customParent = custom.getParent();
                if (customParent != this) {
                    if (customParent != null) {
                        ((ViewGroup) customParent).removeView(custom);
                    }
                    addView(custom);
                }
                this.f3262e = custom;
                TextView textView = this.f3260c;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f3261d;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f3261d.setImageDrawable(null);
                    return;
                }
                return;
            }
            View view = this.f3262e;
            if (view != null) {
                removeView(view);
                this.f3262e = null;
            }
            Drawable icon = tab.mo6203c();
            CharSequence text = tab.mo6204d();
            if (icon != null) {
                if (this.f3261d == null) {
                    ImageView iconView = new AppCompatImageView(getContext());
                    LayoutParams lp = new LayoutParams(-2, -2);
                    lp.gravity = 16;
                    iconView.setLayoutParams(lp);
                    addView(iconView, 0);
                    this.f3261d = iconView;
                }
                this.f3261d.setImageDrawable(icon);
                this.f3261d.setVisibility(0);
            } else {
                ImageView imageView2 = this.f3261d;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.f3261d.setImageDrawable(null);
                }
            }
            boolean hasText = !TextUtils.isEmpty(text);
            if (hasText) {
                if (this.f3260c == null) {
                    TextView textView2 = new C0939H(getContext(), null, C0793R.attr.actionBarTabTextStyle);
                    textView2.setEllipsize(TruncateAt.END);
                    LayoutParams lp2 = new LayoutParams(-2, -2);
                    lp2.gravity = 16;
                    textView2.setLayoutParams(lp2);
                    addView(textView2);
                    this.f3260c = textView2;
                }
                this.f3260c.setText(text);
                this.f3260c.setVisibility(0);
            } else {
                TextView textView3 = this.f3260c;
                if (textView3 != null) {
                    textView3.setVisibility(8);
                    this.f3260c.setText(null);
                }
            }
            ImageView imageView3 = this.f3261d;
            if (imageView3 != null) {
                imageView3.setContentDescription(tab.mo6201a());
            }
            if (!hasText) {
                charSequence = tab.mo6201a();
            }
            C0901Ab.m4307a(this, charSequence);
        }

        /* renamed from: a */
        public C0763c mo8040a() {
            return this.f3259b;
        }
    }

    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        boolean canCollapse = true;
        boolean lockedExpanded = widthMode == 1073741824;
        setFillViewport(lockedExpanded);
        int childCount = this.f3249d.getChildCount();
        if (childCount <= 1 || !(widthMode == 1073741824 || widthMode == Integer.MIN_VALUE)) {
            this.f3252g = -1;
        } else {
            if (childCount > 2) {
                this.f3252g = (int) (((float) MeasureSpec.getSize(widthMeasureSpec)) * 0.4f);
            } else {
                this.f3252g = MeasureSpec.getSize(widthMeasureSpec) / 2;
            }
            this.f3252g = Math.min(this.f3252g, this.f3253h);
        }
        int heightMeasureSpec2 = MeasureSpec.makeMeasureSpec(this.f3254i, 1073741824);
        if (lockedExpanded || !this.f3251f) {
            canCollapse = false;
        }
        if (canCollapse) {
            this.f3249d.measure(0, heightMeasureSpec2);
            if (this.f3249d.getMeasuredWidth() > MeasureSpec.getSize(widthMeasureSpec)) {
                m4997c();
            } else {
                m4998d();
            }
        } else {
            m4998d();
        }
        int oldWidth = getMeasuredWidth();
        super.onMeasure(widthMeasureSpec, heightMeasureSpec2);
        int newWidth = getMeasuredWidth();
        if (lockedExpanded && oldWidth != newWidth) {
            setTabSelected(this.f3255j);
        }
    }

    /* renamed from: b */
    private boolean m4996b() {
        Spinner spinner = this.f3250e;
        return spinner != null && spinner.getParent() == this;
    }

    public void setAllowCollapse(boolean allowCollapse) {
        this.f3251f = allowCollapse;
    }

    /* renamed from: c */
    private void m4997c() {
        if (!m4996b()) {
            if (this.f3250e == null) {
                this.f3250e = m4995a();
            }
            removeView(this.f3249d);
            addView(this.f3250e, new ViewGroup.LayoutParams(-2, -1));
            if (this.f3250e.getAdapter() == null) {
                this.f3250e.setAdapter(new C1005a());
            }
            Runnable runnable = this.f3247b;
            if (runnable != null) {
                removeCallbacks(runnable);
                this.f3247b = null;
            }
            this.f3250e.setSelection(this.f3255j);
        }
    }

    /* renamed from: d */
    private boolean m4998d() {
        if (!m4996b()) {
            return false;
        }
        removeView(this.f3250e);
        addView(this.f3249d, new ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.f3250e.getSelectedItemPosition());
        return false;
    }

    public void setTabSelected(int position) {
        this.f3255j = position;
        int tabCount = this.f3249d.getChildCount();
        int i = 0;
        while (i < tabCount) {
            View child = this.f3249d.getChildAt(i);
            boolean isSelected = i == position;
            child.setSelected(isSelected);
            if (isSelected) {
                mo8025a(position);
            }
            i++;
        }
        Spinner spinner = this.f3250e;
        if (spinner != null && position >= 0) {
            spinner.setSelection(position);
        }
    }

    public void setContentHeight(int contentHeight) {
        this.f3254i = contentHeight;
        requestLayout();
    }

    /* renamed from: a */
    private Spinner m4995a() {
        Spinner spinner = new C0897A(getContext(), null, C0793R.attr.actionDropDownStyle);
        spinner.setLayoutParams(new C1102a(-2, -1));
        spinner.setOnItemSelectedListener(this);
        return spinner;
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        C1299a abp = C1299a.m6042a(getContext());
        setContentHeight(abp.mo9225e());
        this.f3253h = abp.mo9224d();
    }

    /* renamed from: a */
    public void mo8025a(int position) {
        View tabView = this.f3249d.getChildAt(position);
        Runnable runnable = this.f3247b;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        this.f3247b = new C0969Ra(this, tabView);
        post(this.f3247b);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.f3247b;
        if (runnable != null) {
            post(runnable);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f3247b;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C1007c mo8024a(C0763c tab, boolean forAdapter) {
        C1007c tabView = new C1007c(getContext(), tab, forAdapter);
        if (forAdapter) {
            tabView.setBackgroundDrawable(null);
            tabView.setLayoutParams(new AbsListView.LayoutParams(-1, this.f3254i));
        } else {
            tabView.setFocusable(true);
            if (this.f3248c == null) {
                this.f3248c = new C1006b();
            }
            tabView.setOnClickListener(this.f3248c);
        }
        return tabView;
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        ((C1007c) view).mo8040a().mo6205e();
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
