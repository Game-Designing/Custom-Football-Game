package android.support.design.internal;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.support.p000v4.view.C0646w;
import android.support.p000v4.view.p039b.C0611b;
import android.support.p001v7.view.menu.C0873l;
import android.support.p001v7.view.menu.C0879p;
import android.support.p001v7.view.menu.C0892w;
import android.support.transition.C0334M;
import android.support.transition.C0340P;
import android.support.transition.C0344T;
import android.support.transition.C0361e;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import p002b.p003c.p050d.C1170d;
import p002b.p003c.p053g.p061f.C1269m;
import p002b.p003c.p053g.p061f.C1271o;

/* renamed from: android.support.design.internal.d */
/* compiled from: BottomNavigationMenuView */
public class C0218d extends ViewGroup implements C0892w {

    /* renamed from: a */
    private final C0344T f743a;

    /* renamed from: b */
    private final int f744b;

    /* renamed from: c */
    private final int f745c;

    /* renamed from: d */
    private final int f746d;

    /* renamed from: e */
    private final int f747e;

    /* renamed from: f */
    private final OnClickListener f748f;

    /* renamed from: g */
    private final C1269m<C0215a> f749g;

    /* renamed from: h */
    private C0215a[] f750h;

    /* renamed from: i */
    private int f751i;

    /* renamed from: j */
    private int f752j;

    /* renamed from: k */
    private ColorStateList f753k;

    /* renamed from: l */
    private ColorStateList f754l;

    /* renamed from: m */
    private int f755m;
    private boolean mShiftingMode;

    /* renamed from: n */
    private int[] f756n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public BottomNavigationPresenter f757o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public C0873l f758p;

    public C0218d(Context context) {
        this(context, null);
    }

    public C0218d(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f749g = new C1271o(5);
        this.mShiftingMode = true;
        this.f751i = 0;
        this.f752j = 0;
        Resources res = getResources();
        this.f744b = res.getDimensionPixelSize(C1170d.design_bottom_navigation_item_max_width);
        this.f745c = res.getDimensionPixelSize(C1170d.design_bottom_navigation_item_min_width);
        this.f746d = res.getDimensionPixelSize(C1170d.design_bottom_navigation_active_item_max_width);
        this.f747e = res.getDimensionPixelSize(C1170d.design_bottom_navigation_height);
        this.f743a = new C0361e();
        this.f743a.mo4795b(0);
        this.f743a.mo4748a(115);
        this.f743a.mo4749a((TimeInterpolator) new C0611b());
        this.f743a.mo4796b((C0334M) new C0223i());
        this.f748f = new C0217c(this);
        this.f756n = new int[5];
    }

    /* renamed from: a */
    public void mo4100a(C0873l menu) {
        this.f758p = menu;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int count = getChildCount();
        int heightSpec = MeasureSpec.makeMeasureSpec(this.f747e, 1073741824);
        if (this.mShiftingMode) {
            int inactiveCount = count - 1;
            int activeWidth = Math.min(width - (this.f745c * inactiveCount), this.f746d);
            int inactiveWidth = Math.min((width - activeWidth) / inactiveCount, this.f744b);
            int extra = (width - activeWidth) - (inactiveWidth * inactiveCount);
            int i = 0;
            while (i < count) {
                this.f756n[i] = i == this.f752j ? activeWidth : inactiveWidth;
                if (extra > 0) {
                    int[] iArr = this.f756n;
                    iArr[i] = iArr[i] + 1;
                    extra--;
                }
                i++;
            }
        } else {
            int childWidth = Math.min(width / (count == 0 ? 1 : count), this.f746d);
            int extra2 = width - (childWidth * count);
            for (int i2 = 0; i2 < count; i2++) {
                int[] iArr2 = this.f756n;
                iArr2[i2] = childWidth;
                if (extra2 > 0) {
                    iArr2[i2] = iArr2[i2] + 1;
                    extra2--;
                }
            }
        }
        int totalWidth = 0;
        for (int i3 = 0; i3 < count; i3++) {
            View child = getChildAt(i3);
            if (child.getVisibility() != 8) {
                child.measure(MeasureSpec.makeMeasureSpec(this.f756n[i3], 1073741824), heightSpec);
                child.getLayoutParams().width = child.getMeasuredWidth();
                totalWidth += child.getMeasuredWidth();
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(totalWidth, MeasureSpec.makeMeasureSpec(totalWidth, 1073741824), 0), View.resolveSizeAndState(this.f747e, heightSpec, 0));
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int count = getChildCount();
        int width = right - left;
        int height = bottom - top;
        int used = 0;
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() != 8) {
                if (C0646w.m2974h(this) == 1) {
                    child.layout((width - used) - child.getMeasuredWidth(), 0, width - used, height);
                } else {
                    child.layout(used, 0, child.getMeasuredWidth() + used, height);
                }
                used += child.getMeasuredWidth();
            }
        }
    }

    public int getWindowAnimations() {
        return 0;
    }

    public void setIconTintList(ColorStateList tint) {
        this.f753k = tint;
        C0215a[] aVarArr = this.f750h;
        if (aVarArr != null) {
            for (C0215a item : aVarArr) {
                item.setIconTintList(tint);
            }
        }
    }

    public ColorStateList getIconTintList() {
        return this.f753k;
    }

    public void setItemTextColor(ColorStateList color) {
        this.f754l = color;
        C0215a[] aVarArr = this.f750h;
        if (aVarArr != null) {
            for (C0215a item : aVarArr) {
                item.setTextColor(color);
            }
        }
    }

    public ColorStateList getItemTextColor() {
        return this.f754l;
    }

    public void setItemBackgroundRes(int background) {
        this.f755m = background;
        C0215a[] aVarArr = this.f750h;
        if (aVarArr != null) {
            for (C0215a item : aVarArr) {
                item.setItemBackground(background);
            }
        }
    }

    public int getItemBackgroundRes() {
        return this.f755m;
    }

    public void setPresenter(BottomNavigationPresenter presenter) {
        this.f757o = presenter;
    }

    /* renamed from: a */
    public void mo4123a() {
        removeAllViews();
        C0215a[] aVarArr = this.f750h;
        if (aVarArr != null) {
            for (C0215a item : aVarArr) {
                this.f749g.mo9149a(item);
            }
        }
        if (this.f758p.size() == 0) {
            this.f751i = 0;
            this.f752j = 0;
            this.f750h = null;
            return;
        }
        this.f750h = new C0215a[this.f758p.size()];
        this.mShiftingMode = this.f758p.size() > 3;
        for (int i = 0; i < this.f758p.size(); i++) {
            this.f757o.mo4082b(true);
            this.f758p.getItem(i).setCheckable(true);
            this.f757o.mo4082b(false);
            C0215a child = getNewItem();
            this.f750h[i] = child;
            child.setIconTintList(this.f753k);
            child.setTextColor(this.f754l);
            child.setItemBackground(this.f755m);
            child.setShiftingMode(this.mShiftingMode);
            child.mo4088a((C0879p) this.f758p.getItem(i), 0);
            child.setItemPosition(i);
            child.setOnClickListener(this.f748f);
            addView(child);
        }
        this.f752j = Math.min(this.f758p.size() - 1, this.f752j);
        this.f758p.getItem(this.f752j).setChecked(true);
    }

    /* renamed from: b */
    public void mo4125b() {
        int menuSize = this.f758p.size();
        if (menuSize != this.f750h.length) {
            mo4123a();
            return;
        }
        int previousSelectedId = this.f751i;
        for (int i = 0; i < menuSize; i++) {
            MenuItem item = this.f758p.getItem(i);
            if (item.isChecked()) {
                this.f751i = item.getItemId();
                this.f752j = i;
            }
        }
        if (previousSelectedId != this.f751i) {
            C0340P.m1824a(this, this.f743a);
        }
        for (int i2 = 0; i2 < menuSize; i2++) {
            this.f757o.mo4082b(true);
            this.f750h[i2].mo4088a((C0879p) this.f758p.getItem(i2), 0);
            this.f757o.mo4082b(false);
        }
    }

    private C0215a getNewItem() {
        C0215a item = (C0215a) this.f749g.mo9148a();
        if (item == null) {
            return new C0215a(getContext());
        }
        return item;
    }

    public int getSelectedItemId() {
        return this.f751i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4124a(int itemId) {
        int size = this.f758p.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = this.f758p.getItem(i);
            if (itemId == item.getItemId()) {
                this.f751i = itemId;
                this.f752j = i;
                item.setChecked(true);
                return;
            }
        }
    }
}
