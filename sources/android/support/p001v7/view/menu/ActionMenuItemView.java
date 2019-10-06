package android.support.p001v7.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.p001v7.appcompat.C0793R;
import android.support.p001v7.view.menu.C0873l.C0875b;
import android.support.p001v7.view.menu.C0892w.C0893a;
import android.support.p001v7.widget.ActionMenuView.C0910a;
import android.support.p001v7.widget.C0901Ab;
import android.support.p001v7.widget.C0939H;
import android.support.p001v7.widget.C1080la;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;

/* renamed from: android.support.v7.view.menu.ActionMenuItemView */
public class ActionMenuItemView extends C0939H implements C0893a, OnClickListener, C0910a {

    /* renamed from: c */
    C0879p f2566c;

    /* renamed from: d */
    private CharSequence f2567d;

    /* renamed from: e */
    private Drawable f2568e;

    /* renamed from: f */
    C0875b f2569f;

    /* renamed from: g */
    private C1080la f2570g;

    /* renamed from: h */
    C0855b f2571h;

    /* renamed from: i */
    private boolean f2572i;

    /* renamed from: j */
    private boolean f2573j;

    /* renamed from: k */
    private int f2574k;

    /* renamed from: l */
    private int f2575l;

    /* renamed from: m */
    private int f2576m;

    /* renamed from: android.support.v7.view.menu.ActionMenuItemView$a */
    private class C0854a extends C1080la {
        public C0854a() {
            super(ActionMenuItemView.this);
        }

        /* renamed from: h */
        public C0896z mo6541h() {
            C0855b bVar = ActionMenuItemView.this.f2571h;
            if (bVar != null) {
                return bVar.mo6543a();
            }
            return null;
        }

        /* access modifiers changed from: protected */
        /* renamed from: i */
        public boolean mo6542i() {
            ActionMenuItemView actionMenuItemView = ActionMenuItemView.this;
            C0875b bVar = actionMenuItemView.f2569f;
            boolean z = false;
            if (bVar == null || !bVar.mo6589a(actionMenuItemView.f2566c)) {
                return false;
            }
            C0896z popup = mo6541h();
            if (popup != null && popup.mo6555c()) {
                z = true;
            }
            return z;
        }
    }

    /* renamed from: android.support.v7.view.menu.ActionMenuItemView$b */
    public static abstract class C0855b {
        /* renamed from: a */
        public abstract C0896z mo6543a();
    }

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    public ActionMenuItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        Resources res = context.getResources();
        this.f2572i = m4008l();
        TypedArray a = context.obtainStyledAttributes(attrs, C0793R.styleable.ActionMenuItemView, defStyle, 0);
        this.f2574k = a.getDimensionPixelSize(C0793R.styleable.ActionMenuItemView_android_minWidth, 0);
        a.recycle();
        this.f2576m = (int) ((32.0f * res.getDisplayMetrics().density) + 0.5f);
        setOnClickListener(this);
        this.f2575l = -1;
        setSaveEnabled(false);
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        this.f2572i = m4008l();
        m4009m();
    }

    /* renamed from: l */
    private boolean m4008l() {
        Configuration config = getContext().getResources().getConfiguration();
        int widthDp = config.screenWidthDp;
        return widthDp >= 480 || (widthDp >= 640 && config.screenHeightDp >= 480) || config.orientation == 2;
    }

    public void setPadding(int l, int t, int r, int b) {
        this.f2575l = l;
        super.setPadding(l, t, r, b);
    }

    public C0879p getItemData() {
        return this.f2566c;
    }

    /* renamed from: a */
    public void mo4088a(C0879p itemData, int menuType) {
        this.f2566c = itemData;
        setIcon(itemData.getIcon());
        setTitle(itemData.mo6768a((C0893a) this));
        setId(itemData.getItemId());
        setVisibility(itemData.isVisible() ? 0 : 8);
        setEnabled(itemData.isEnabled());
        if (itemData.hasSubMenu() && this.f2570g == null) {
            this.f2570g = new C0854a();
        }
    }

    public boolean onTouchEvent(MotionEvent e) {
        if (this.f2566c.hasSubMenu()) {
            C1080la laVar = this.f2570g;
            if (laVar != null && laVar.onTouch(this, e)) {
                return true;
            }
        }
        return super.onTouchEvent(e);
    }

    public void onClick(View v) {
        C0875b bVar = this.f2569f;
        if (bVar != null) {
            bVar.mo6589a(this.f2566c);
        }
    }

    public void setItemInvoker(C0875b invoker) {
        this.f2569f = invoker;
    }

    public void setPopupCallback(C0855b popupCallback) {
        this.f2571h = popupCallback;
    }

    /* renamed from: h */
    public boolean mo4090h() {
        return true;
    }

    public void setCheckable(boolean checkable) {
    }

    public void setChecked(boolean checked) {
    }

    public void setExpandedFormat(boolean expandedFormat) {
        if (this.f2573j != expandedFormat) {
            this.f2573j = expandedFormat;
            C0879p pVar = this.f2566c;
            if (pVar != null) {
                pVar.mo6772b();
            }
        }
    }

    /* renamed from: m */
    private void m4009m() {
        boolean z = true;
        boolean visible = !TextUtils.isEmpty(this.f2567d);
        if (this.f2568e != null && (!this.f2566c.mo6805n() || (!this.f2572i && !this.f2573j))) {
            z = false;
        }
        boolean visible2 = visible & z;
        CharSequence charSequence = null;
        setText(visible2 ? this.f2567d : null);
        CharSequence contentDescription = this.f2566c.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            setContentDescription(visible2 ? null : this.f2566c.getTitle());
        } else {
            setContentDescription(contentDescription);
        }
        CharSequence tooltipText = this.f2566c.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            if (!visible2) {
                charSequence = this.f2566c.getTitle();
            }
            C0901Ab.m4307a(this, charSequence);
            return;
        }
        C0901Ab.m4307a(this, tooltipText);
    }

    public void setIcon(Drawable icon) {
        this.f2568e = icon;
        if (icon != null) {
            int width = icon.getIntrinsicWidth();
            int height = icon.getIntrinsicHeight();
            int i = this.f2576m;
            if (width > i) {
                float scale = ((float) i) / ((float) width);
                width = this.f2576m;
                height = (int) (((float) height) * scale);
            }
            int i2 = this.f2576m;
            if (height > i2) {
                float scale2 = ((float) i2) / ((float) height);
                height = this.f2576m;
                width = (int) (((float) width) * scale2);
            }
            icon.setBounds(0, 0, width, height);
        }
        setCompoundDrawables(icon, null, null, null);
        m4009m();
    }

    /* renamed from: k */
    public boolean mo6527k() {
        return !TextUtils.isEmpty(getText());
    }

    public void setTitle(CharSequence title) {
        this.f2567d = title;
        m4009m();
    }

    /* renamed from: j */
    public boolean mo6526j() {
        return mo6527k() && this.f2566c.getIcon() == null;
    }

    /* renamed from: i */
    public boolean mo6525i() {
        return mo6527k();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        boolean textVisible = mo6527k();
        if (textVisible) {
            int i = this.f2575l;
            if (i >= 0) {
                super.setPadding(i, getPaddingTop(), getPaddingRight(), getPaddingBottom());
            }
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int oldMeasuredWidth = getMeasuredWidth();
        int targetWidth = widthMode == Integer.MIN_VALUE ? Math.min(widthSize, this.f2574k) : this.f2574k;
        if (widthMode != 1073741824 && this.f2574k > 0 && oldMeasuredWidth < targetWidth) {
            super.onMeasure(MeasureSpec.makeMeasureSpec(targetWidth, 1073741824), heightMeasureSpec);
        }
        if (!textVisible && this.f2568e != null) {
            super.setPadding((getMeasuredWidth() - this.f2568e.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    public void onRestoreInstanceState(Parcelable state) {
        super.onRestoreInstanceState(null);
    }
}
