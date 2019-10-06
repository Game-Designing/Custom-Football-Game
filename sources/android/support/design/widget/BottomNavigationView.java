package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.design.internal.BottomNavigationPresenter;
import android.support.design.internal.C0216b;
import android.support.design.internal.C0218d;
import android.support.p000v4.content.C0510b;
import android.support.p000v4.view.AbsSavedState;
import android.support.p000v4.view.C0646w;
import android.support.p001v7.appcompat.C0793R;
import android.support.p001v7.view.menu.C0873l;
import android.support.p001v7.view.menu.C0873l.C0874a;
import android.support.p001v7.view.menu.C0890v;
import android.support.p001v7.widget.C1112sb;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import p002b.p003c.p050d.C1169c;
import p002b.p003c.p050d.C1170d;
import p002b.p003c.p050d.C1176j;
import p002b.p003c.p050d.C1177k;
import p002b.p003c.p062h.p064b.p065a.C1282b;
import p002b.p003c.p062h.p071g.C1307g;

public class BottomNavigationView extends FrameLayout {

    /* renamed from: a */
    private static final int[] f837a = {16842912};

    /* renamed from: b */
    private static final int[] f838b = {-16842910};

    /* renamed from: c */
    private final C0873l f839c;

    /* renamed from: d */
    private final C0218d f840d;

    /* renamed from: e */
    private final BottomNavigationPresenter f841e;

    /* renamed from: f */
    private MenuInflater f842f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public C0230b f843g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public C0229a f844h;

    static class SavedState extends AbsSavedState {
        public static final Creator<SavedState> CREATOR = new C0315t();

        /* renamed from: c */
        Bundle f845c;

        public SavedState(Parcelable superState) {
            super(superState);
        }

        public SavedState(Parcel source, ClassLoader loader) {
            super(source, loader);
            m1370a(source, loader);
        }

        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeBundle(this.f845c);
        }

        /* renamed from: a */
        private void m1370a(Parcel in, ClassLoader loader) {
            this.f845c = in.readBundle(loader);
        }
    }

    /* renamed from: android.support.design.widget.BottomNavigationView$a */
    public interface C0229a {
        /* renamed from: a */
        void mo4268a(MenuItem menuItem);
    }

    /* renamed from: android.support.design.widget.BottomNavigationView$b */
    public interface C0230b {
        /* renamed from: a */
        boolean mo4269a(MenuItem menuItem);
    }

    public BottomNavigationView(Context context) {
        this(context, null);
    }

    public BottomNavigationView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BottomNavigationView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f841e = new BottomNavigationPresenter();
        C0289ea.m1678a(context);
        this.f839c = new C0216b(context);
        this.f840d = new C0218d(context);
        LayoutParams params = new LayoutParams(-2, -2);
        params.gravity = 17;
        this.f840d.setLayoutParams(params);
        this.f841e.mo4077a(this.f840d);
        this.f841e.mo4074a(1);
        this.f840d.setPresenter(this.f841e);
        this.f839c.mo6708a((C0890v) this.f841e);
        this.f841e.mo4075a(getContext(), this.f839c);
        C1112sb a = C1112sb.m5456a(context, attrs, C1177k.BottomNavigationView, defStyleAttr, C1176j.Widget_Design_BottomNavigationView);
        if (a.mo8660g(C1177k.BottomNavigationView_itemIconTint)) {
            this.f840d.setIconTintList(a.mo8645a(C1177k.BottomNavigationView_itemIconTint));
        } else {
            this.f840d.setIconTintList(m1367b(16842808));
        }
        if (a.mo8660g(C1177k.BottomNavigationView_itemTextColor)) {
            this.f840d.setItemTextColor(a.mo8645a(C1177k.BottomNavigationView_itemTextColor));
        } else {
            this.f840d.setItemTextColor(m1367b(16842808));
        }
        if (a.mo8660g(C1177k.BottomNavigationView_elevation)) {
            C0646w.m2964b((View) this, (float) a.mo8651c(C1177k.BottomNavigationView_elevation, 0));
        }
        this.f840d.setItemBackgroundRes(a.mo8659g(C1177k.BottomNavigationView_itemBackground, 0));
        if (a.mo8660g(C1177k.BottomNavigationView_menu)) {
            mo4253a(a.mo8659g(C1177k.BottomNavigationView_menu, 0));
        }
        a.mo8647a();
        addView(this.f840d, params);
        if (VERSION.SDK_INT < 21) {
            m1366a(context);
        }
        this.f839c.mo6561a((C0874a) new C0314s(this));
    }

    public void setOnNavigationItemSelectedListener(C0230b listener) {
        this.f843g = listener;
    }

    public void setOnNavigationItemReselectedListener(C0229a listener) {
        this.f844h = listener;
    }

    public Menu getMenu() {
        return this.f839c;
    }

    /* renamed from: a */
    public void mo4253a(int resId) {
        this.f841e.mo4082b(true);
        getMenuInflater().inflate(resId, this.f839c);
        this.f841e.mo4082b(false);
        this.f841e.mo4079a(true);
    }

    public int getMaxItemCount() {
        return 5;
    }

    public ColorStateList getItemIconTintList() {
        return this.f840d.getIconTintList();
    }

    public void setItemIconTintList(ColorStateList tint) {
        this.f840d.setIconTintList(tint);
    }

    public ColorStateList getItemTextColor() {
        return this.f840d.getItemTextColor();
    }

    public void setItemTextColor(ColorStateList textColor) {
        this.f840d.setItemTextColor(textColor);
    }

    public int getItemBackgroundResource() {
        return this.f840d.getItemBackgroundRes();
    }

    public void setItemBackgroundResource(int resId) {
        this.f840d.setItemBackgroundRes(resId);
    }

    public int getSelectedItemId() {
        return this.f840d.getSelectedItemId();
    }

    public void setSelectedItemId(int itemId) {
        MenuItem item = this.f839c.findItem(itemId);
        if (item != null && !this.f839c.mo6714a(item, (C0890v) this.f841e, 0)) {
            item.setChecked(true);
        }
    }

    /* renamed from: a */
    private void m1366a(Context context) {
        View divider = new View(context);
        divider.setBackgroundColor(C0510b.m2564a(context, C1169c.design_bottom_navigation_shadow_color));
        divider.setLayoutParams(new LayoutParams(-1, getResources().getDimensionPixelSize(C1170d.design_bottom_navigation_shadow_height)));
        addView(divider);
    }

    private MenuInflater getMenuInflater() {
        if (this.f842f == null) {
            this.f842f = new C1307g(getContext());
        }
        return this.f842f;
    }

    /* renamed from: b */
    private ColorStateList m1367b(int baseColorThemeAttr) {
        TypedValue value = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(baseColorThemeAttr, value, true)) {
            return null;
        }
        ColorStateList baseColor = C1282b.m5997a(getContext(), value.resourceId);
        if (!getContext().getTheme().resolveAttribute(C0793R.attr.colorPrimary, value, true)) {
            return null;
        }
        int colorPrimary = value.data;
        int defaultColor = baseColor.getDefaultColor();
        return new ColorStateList(new int[][]{f838b, f837a, FrameLayout.EMPTY_STATE_SET}, new int[]{baseColor.getColorForState(f838b, defaultColor), colorPrimary, defaultColor});
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f845c = new Bundle();
        this.f839c.mo6737d(savedState.f845c);
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable state) {
        if (!(state instanceof SavedState)) {
            super.onRestoreInstanceState(state);
            return;
        }
        SavedState savedState = (SavedState) state;
        super.onRestoreInstanceState(savedState.mo5452a());
        this.f839c.mo6725b(savedState.f845c);
    }
}
