package android.support.p001v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.p000v4.view.C0620e;
import android.support.p000v4.view.C0620e.C0621a;
import android.support.p001v7.appcompat.C0793R;
import android.support.p001v7.view.menu.ActionMenuItemView;
import android.support.p001v7.view.menu.ActionMenuItemView.C0855b;
import android.support.p001v7.view.menu.C0858D;
import android.support.p001v7.view.menu.C0861b;
import android.support.p001v7.view.menu.C0873l;
import android.support.p001v7.view.menu.C0879p;
import android.support.p001v7.view.menu.C0889u;
import android.support.p001v7.view.menu.C0890v.C0891a;
import android.support.p001v7.view.menu.C0892w;
import android.support.p001v7.view.menu.C0892w.C0893a;
import android.support.p001v7.view.menu.C0896z;
import android.support.p001v7.widget.ActionMenuView.C0910a;
import android.support.v7.view.menu.MenuItemImpl;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import java.util.ArrayList;
import p002b.p003c.p053g.p054a.p055a.C1200a;
import p002b.p003c.p062h.p071g.C1299a;

/* renamed from: android.support.v7.widget.ActionMenuPresenter */
class ActionMenuPresenter extends C0861b implements C0621a {

    /* renamed from: A */
    C0904a f2862A;

    /* renamed from: B */
    C0906c f2863B;

    /* renamed from: C */
    private C0905b f2864C;

    /* renamed from: D */
    final C0909f f2865D = new C0909f();

    /* renamed from: E */
    int f2866E;

    /* renamed from: k */
    C0907d f2867k;

    /* renamed from: l */
    private Drawable f2868l;

    /* renamed from: m */
    private boolean f2869m;

    /* renamed from: n */
    private boolean f2870n;

    /* renamed from: o */
    private boolean f2871o;

    /* renamed from: p */
    private int f2872p;

    /* renamed from: q */
    private int f2873q;

    /* renamed from: r */
    private int f2874r;

    /* renamed from: s */
    private boolean f2875s;

    /* renamed from: t */
    private boolean f2876t;

    /* renamed from: u */
    private boolean f2877u;

    /* renamed from: v */
    private boolean f2878v;

    /* renamed from: w */
    private int f2879w;

    /* renamed from: x */
    private final SparseBooleanArray f2880x = new SparseBooleanArray();

    /* renamed from: y */
    private View f2881y;

    /* renamed from: z */
    C0908e f2882z;

    /* renamed from: android.support.v7.widget.ActionMenuPresenter$SavedState */
    private static class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR = new C1065i();

        /* renamed from: a */
        public int f2883a;

        SavedState() {
        }

        SavedState(Parcel in) {
            this.f2883a = in.readInt();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.f2883a);
        }
    }

    /* renamed from: android.support.v7.widget.ActionMenuPresenter$a */
    private class C0904a extends C0889u {
        public C0904a(Context context, C0858D subMenu, View anchorView) {
            super(context, subMenu, anchorView, false, C0793R.attr.actionOverflowMenuStyle);
            if (!((C0879p) subMenu.getItem()).mo6794h()) {
                View view = ActionMenuPresenter.this.f2867k;
                if (view == null) {
                    view = (View) ActionMenuPresenter.this.f2649i;
                }
                mo6893a(view);
            }
            mo6892a((C0891a) ActionMenuPresenter.this.f2865D);
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public void mo6899d() {
            ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
            actionMenuPresenter.f2862A = null;
            actionMenuPresenter.f2866E = 0;
            super.mo6899d();
        }
    }

    /* renamed from: android.support.v7.widget.ActionMenuPresenter$b */
    private class C0905b extends C0855b {
        C0905b() {
        }

        /* renamed from: a */
        public C0896z mo6543a() {
            C0904a aVar = ActionMenuPresenter.this.f2862A;
            if (aVar != null) {
                return aVar.mo6897b();
            }
            return null;
        }
    }

    /* renamed from: android.support.v7.widget.ActionMenuPresenter$c */
    private class C0906c implements Runnable {

        /* renamed from: a */
        private C0908e f2886a;

        public C0906c(C0908e popup) {
            this.f2886a = popup;
        }

        public void run() {
            if (ActionMenuPresenter.this.f2643c != null) {
                ActionMenuPresenter.this.f2643c.mo6706a();
            }
            View menuView = (View) ActionMenuPresenter.this.f2649i;
            if (!(menuView == null || menuView.getWindowToken() == null || !this.f2886a.mo6901f())) {
                ActionMenuPresenter.this.f2882z = this.f2886a;
            }
            ActionMenuPresenter.this.f2863B = null;
        }
    }

    /* renamed from: android.support.v7.widget.ActionMenuPresenter$d */
    private class C0907d extends AppCompatImageView implements C0910a {

        /* renamed from: c */
        private final float[] f2888c = new float[2];

        public C0907d(Context context) {
            super(context, null, C0793R.attr.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            C0901Ab.m4307a(this, getContentDescription());
            setOnTouchListener(new C1062h(this, this, ActionMenuPresenter.this));
        }

        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            ActionMenuPresenter.this.mo7074j();
            return true;
        }

        /* renamed from: j */
        public boolean mo6526j() {
            return false;
        }

        /* renamed from: i */
        public boolean mo6525i() {
            return false;
        }

        /* access modifiers changed from: protected */
        public boolean setFrame(int l, int t, int r, int b) {
            boolean changed = super.setFrame(l, t, r, b);
            Drawable d = getDrawable();
            Drawable bg = getBackground();
            if (!(d == null || bg == null)) {
                int width = getWidth();
                int height = getHeight();
                int halfEdge = Math.max(width, height) / 2;
                int centerX = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int centerY = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                C1200a.m5725a(bg, centerX - halfEdge, centerY - halfEdge, centerX + halfEdge, centerY + halfEdge);
            }
            return changed;
        }
    }

    /* renamed from: android.support.v7.widget.ActionMenuPresenter$e */
    private class C0908e extends C0889u {
        public C0908e(Context context, C0873l menu, View anchorView, boolean overflowOnly) {
            super(context, menu, anchorView, overflowOnly, C0793R.attr.actionOverflowMenuStyle);
            mo6891a(8388613);
            mo6892a((C0891a) ActionMenuPresenter.this.f2865D);
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public void mo6899d() {
            if (ActionMenuPresenter.this.f2643c != null) {
                ActionMenuPresenter.this.f2643c.close();
            }
            ActionMenuPresenter.this.f2882z = null;
            super.mo6899d();
        }
    }

    /* renamed from: android.support.v7.widget.ActionMenuPresenter$f */
    private class C0909f implements C0891a {
        C0909f() {
        }

        /* renamed from: a */
        public boolean mo6118a(C0873l subMenu) {
            boolean z = false;
            if (subMenu == null) {
                return false;
            }
            ActionMenuPresenter.this.f2866E = ((C0858D) subMenu).getItem().getItemId();
            C0891a cb = ActionMenuPresenter.this.mo6665c();
            if (cb != null) {
                z = cb.mo6118a(subMenu);
            }
            return z;
        }

        /* renamed from: a */
        public void mo6117a(C0873l menu, boolean allMenusAreClosing) {
            if (menu instanceof C0858D) {
                menu.mo6567m().mo6712a(false);
            }
            C0891a cb = ActionMenuPresenter.this.mo6665c();
            if (cb != null) {
                cb.mo6117a(menu, allMenusAreClosing);
            }
        }
    }

    public ActionMenuPresenter(Context context) {
        super(context, C0793R.layout.abc_action_menu_layout, C0793R.layout.abc_action_menu_item_layout);
    }

    /* renamed from: a */
    public void mo4075a(Context context, C0873l menu) {
        super.mo4075a(context, menu);
        Resources res = context.getResources();
        C1299a abp = C1299a.m6042a(context);
        if (!this.f2871o) {
            this.f2870n = abp.mo9227g();
        }
        if (!this.f2877u) {
            this.f2872p = abp.mo9222b();
        }
        if (!this.f2875s) {
            this.f2874r = abp.mo9223c();
        }
        int width = this.f2872p;
        if (this.f2870n) {
            if (this.f2867k == null) {
                this.f2867k = new C0907d(this.f2641a);
                if (this.f2869m) {
                    this.f2867k.setImageDrawable(this.f2868l);
                    this.f2868l = null;
                    this.f2869m = false;
                }
                int spec = MeasureSpec.makeMeasureSpec(0, 0);
                this.f2867k.measure(spec, spec);
            }
            width -= this.f2867k.getMeasuredWidth();
        } else {
            this.f2867k = null;
        }
        this.f2873q = width;
        this.f2879w = (int) (res.getDisplayMetrics().density * 56.0f);
        this.f2881y = null;
    }

    /* renamed from: a */
    public void mo7063a(Configuration newConfig) {
        if (!this.f2875s) {
            this.f2874r = C1299a.m6042a(this.f2642b).mo9223c();
        }
        C0873l lVar = this.f2643c;
        if (lVar != null) {
            lVar.mo6727b(true);
        }
    }

    /* renamed from: c */
    public void mo7067c(boolean reserveOverflow) {
        this.f2870n = reserveOverflow;
        this.f2871o = true;
    }

    /* renamed from: b */
    public void mo7066b(boolean isExclusive) {
        this.f2878v = isExclusive;
    }

    /* renamed from: a */
    public void mo7064a(Drawable icon) {
        C0907d dVar = this.f2867k;
        if (dVar != null) {
            dVar.setImageDrawable(icon);
            return;
        }
        this.f2869m = true;
        this.f2868l = icon;
    }

    /* renamed from: e */
    public Drawable mo7069e() {
        C0907d dVar = this.f2867k;
        if (dVar != null) {
            return dVar.getDrawable();
        }
        if (this.f2869m) {
            return this.f2868l;
        }
        return null;
    }

    /* renamed from: b */
    public C0892w mo6664b(ViewGroup root) {
        C0892w oldMenuView = this.f2649i;
        C0892w result = super.mo6664b(root);
        if (oldMenuView != result) {
            ((ActionMenuView) result).setPresenter(this);
        }
        return result;
    }

    /* renamed from: a */
    public View mo6658a(C0879p item, View convertView, ViewGroup parent) {
        View actionView = item.getActionView();
        if (actionView == null || item.mo6780f()) {
            actionView = super.mo6658a(item, convertView, parent);
        }
        actionView.setVisibility(item.isActionViewExpanded() ? 8 : 0);
        ActionMenuView menuParent = (ActionMenuView) parent;
        LayoutParams lp = actionView.getLayoutParams();
        if (!menuParent.checkLayoutParams(lp)) {
            actionView.setLayoutParams(menuParent.generateLayoutParams(lp));
        }
        return actionView;
    }

    /* renamed from: a */
    public void mo6660a(C0879p item, C0893a itemView) {
        itemView.mo4088a(item, 0);
        ActionMenuItemView actionItemView = (ActionMenuItemView) itemView;
        actionItemView.setItemInvoker((ActionMenuView) this.f2649i);
        if (this.f2864C == null) {
            this.f2864C = new C0905b();
        }
        actionItemView.setPopupCallback(this.f2864C);
    }

    /* renamed from: a */
    public boolean mo6662a(int childIndex, C0879p item) {
        return item.mo6794h();
    }

    /* renamed from: a */
    public void mo4079a(boolean cleared) {
        super.mo4079a(cleared);
        ((View) this.f2649i).requestLayout();
        C0873l lVar = this.f2643c;
        if (lVar != null) {
            ArrayList<MenuItemImpl> actionItems = lVar.mo6729c();
            int count = actionItems.size();
            for (int i = 0; i < count; i++) {
                C0620e provider = ((C0879p) actionItems.get(i)).mo6601a();
                if (provider != null) {
                    provider.mo5646a((C0621a) this);
                }
            }
        }
        C0873l lVar2 = this.f2643c;
        ArrayList<MenuItemImpl> nonActionItems = lVar2 != null ? lVar2.mo6749j() : null;
        boolean hasOverflow = false;
        if (this.f2870n && nonActionItems != null) {
            int count2 = nonActionItems.size();
            boolean z = false;
            if (count2 == 1) {
                hasOverflow = !((C0879p) nonActionItems.get(0)).isActionViewExpanded();
            } else {
                if (count2 > 0) {
                    z = true;
                }
                hasOverflow = z;
            }
        }
        if (hasOverflow) {
            if (this.f2867k == null) {
                this.f2867k = new C0907d(this.f2641a);
            }
            ViewGroup parent = (ViewGroup) this.f2867k.getParent();
            if (parent != this.f2649i) {
                if (parent != null) {
                    parent.removeView(this.f2867k);
                }
                ActionMenuView menuView = (ActionMenuView) this.f2649i;
                menuView.addView(this.f2867k, menuView.mo7083b());
            }
        } else {
            C0907d dVar = this.f2867k;
            if (dVar != null) {
                ViewParent parent2 = dVar.getParent();
                C0892w wVar = this.f2649i;
                if (parent2 == wVar) {
                    ((ViewGroup) wVar).removeView(this.f2867k);
                }
            }
        }
        ((ActionMenuView) this.f2649i).setOverflowReserved(this.f2870n);
    }

    /* renamed from: a */
    public boolean mo6663a(ViewGroup parent, int childIndex) {
        if (parent.getChildAt(childIndex) == this.f2867k) {
            return false;
        }
        return super.mo6663a(parent, childIndex);
    }

    /* renamed from: a */
    public boolean mo4080a(C0858D subMenu) {
        if (!subMenu.hasVisibleItems()) {
            return false;
        }
        C0858D topSubMenu = subMenu;
        while (topSubMenu.mo6570s() != this.f2643c) {
            topSubMenu = (C0858D) topSubMenu.mo6570s();
        }
        View anchor = m4343a(topSubMenu.getItem());
        if (anchor == null) {
            return false;
        }
        this.f2866E = subMenu.getItem().getItemId();
        boolean preserveIconSpacing = false;
        int count = subMenu.size();
        int i = 0;
        while (true) {
            if (i >= count) {
                break;
            }
            MenuItem childItem = subMenu.getItem(i);
            if (childItem.isVisible() && childItem.getIcon() != null) {
                preserveIconSpacing = true;
                break;
            }
            i++;
        }
        this.f2862A = new C0904a(this.f2642b, subMenu, anchor);
        this.f2862A.mo6895a(preserveIconSpacing);
        this.f2862A.mo6900e();
        super.mo4080a(subMenu);
        return true;
    }

    /* renamed from: a */
    private View m4343a(MenuItem item) {
        ViewGroup parent = (ViewGroup) this.f2649i;
        if (parent == null) {
            return null;
        }
        int count = parent.getChildCount();
        for (int i = 0; i < count; i++) {
            View child = parent.getChildAt(i);
            if ((child instanceof C0893a) && ((C0893a) child).getItemData() == item) {
                return child;
            }
        }
        return null;
    }

    /* renamed from: j */
    public boolean mo7074j() {
        if (this.f2870n && !mo7073i()) {
            C0873l lVar = this.f2643c;
            if (lVar != null && this.f2649i != null && this.f2863B == null && !lVar.mo6749j().isEmpty()) {
                C0908e eVar = new C0908e(this.f2642b, this.f2643c, this.f2867k, true);
                this.f2863B = new C0906c(eVar);
                ((View) this.f2649i).post(this.f2863B);
                super.mo4080a((C0858D) null);
                return true;
            }
        }
        return false;
    }

    /* renamed from: f */
    public boolean mo7070f() {
        C0906c cVar = this.f2863B;
        if (cVar != null) {
            C0892w wVar = this.f2649i;
            if (wVar != null) {
                ((View) wVar).removeCallbacks(cVar);
                this.f2863B = null;
                return true;
            }
        }
        C0889u popup = this.f2882z;
        if (popup == null) {
            return false;
        }
        popup.mo6890a();
        return true;
    }

    /* renamed from: d */
    public boolean mo7068d() {
        return mo7070f() | mo7071g();
    }

    /* renamed from: g */
    public boolean mo7071g() {
        C0904a aVar = this.f2862A;
        if (aVar == null) {
            return false;
        }
        aVar.mo6890a();
        return true;
    }

    /* renamed from: i */
    public boolean mo7073i() {
        C0908e eVar = this.f2882z;
        return eVar != null && eVar.mo6898c();
    }

    /* renamed from: h */
    public boolean mo7072h() {
        return this.f2863B != null || mo7073i();
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x0175  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0144  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0171  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo4083b() {
        /*
            r24 = this;
            r0 = r24
            android.support.v7.view.menu.l r1 = r0.f2643c
            if (r1 == 0) goto L_0x000f
            java.util.ArrayList r1 = r1.mo6752n()
            int r2 = r1.size()
            goto L_0x0011
        L_0x000f:
            r1 = 0
            r2 = 0
        L_0x0011:
            int r3 = r0.f2874r
            int r4 = r0.f2873q
            r5 = 0
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r5)
            android.support.v7.view.menu.w r7 = r0.f2649i
            android.view.ViewGroup r7 = (android.view.ViewGroup) r7
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
        L_0x0023:
            if (r12 >= r2) goto L_0x004c
            java.lang.Object r13 = r1.get(r12)
            android.support.v7.view.menu.p r13 = (android.support.p001v7.view.menu.C0879p) r13
            boolean r14 = r13.mo6802k()
            if (r14 == 0) goto L_0x0034
            int r8 = r8 + 1
            goto L_0x003e
        L_0x0034:
            boolean r14 = r13.mo6801j()
            if (r14 == 0) goto L_0x003d
            int r9 = r9 + 1
            goto L_0x003e
        L_0x003d:
            r11 = 1
        L_0x003e:
            boolean r14 = r0.f2878v
            if (r14 == 0) goto L_0x0049
            boolean r14 = r13.isActionViewExpanded()
            if (r14 == 0) goto L_0x0049
            r3 = 0
        L_0x0049:
            int r12 = r12 + 1
            goto L_0x0023
        L_0x004c:
            boolean r12 = r0.f2870n
            if (r12 == 0) goto L_0x0058
            if (r11 != 0) goto L_0x0056
            int r12 = r8 + r9
            if (r12 <= r3) goto L_0x0058
        L_0x0056:
            int r3 = r3 + -1
        L_0x0058:
            int r3 = r3 - r8
            android.util.SparseBooleanArray r12 = r0.f2880x
            r12.clear()
            r13 = 0
            r14 = 0
            boolean r15 = r0.f2876t
            if (r15 == 0) goto L_0x006e
            int r15 = r0.f2879w
            int r14 = r4 / r15
            int r16 = r4 % r15
            int r17 = r16 / r14
            int r13 = r15 + r17
        L_0x006e:
            r15 = 0
        L_0x006f:
            if (r15 >= r2) goto L_0x0197
            java.lang.Object r17 = r1.get(r15)
            r5 = r17
            android.support.v7.view.menu.p r5 = (android.support.p001v7.view.menu.C0879p) r5
            boolean r17 = r5.mo6802k()
            if (r17 == 0) goto L_0x00c4
            r17 = r2
            android.view.View r2 = r0.f2881y
            android.view.View r2 = r0.mo6658a(r5, r2, r7)
            r19 = r8
            android.view.View r8 = r0.f2881y
            if (r8 != 0) goto L_0x008f
            r0.f2881y = r2
        L_0x008f:
            boolean r8 = r0.f2876t
            if (r8 == 0) goto L_0x009b
            r8 = 0
            int r20 = android.support.p001v7.widget.ActionMenuView.m4380a(r2, r13, r14, r6, r8)
            int r14 = r14 - r20
            goto L_0x009e
        L_0x009b:
            r2.measure(r6, r6)
        L_0x009e:
            int r8 = r2.getMeasuredWidth()
            int r4 = r4 - r8
            if (r10 != 0) goto L_0x00a6
            r10 = r8
        L_0x00a6:
            r20 = r2
            int r2 = r5.getGroupId()
            if (r2 == 0) goto L_0x00b5
            r21 = r4
            r4 = 1
            r12.put(r2, r4)
            goto L_0x00b8
        L_0x00b5:
            r21 = r4
            r4 = 1
        L_0x00b8:
            r5.mo6777d(r4)
            r22 = r7
            r4 = r21
            r0 = 0
            r21 = r1
            goto L_0x0188
        L_0x00c4:
            r17 = r2
            r19 = r8
            boolean r2 = r5.mo6801j()
            if (r2 == 0) goto L_0x017e
            int r2 = r5.getGroupId()
            boolean r8 = r12.get(r2)
            if (r3 > 0) goto L_0x00de
            if (r8 == 0) goto L_0x00db
            goto L_0x00de
        L_0x00db:
            r20 = r3
            goto L_0x00ec
        L_0x00de:
            if (r4 <= 0) goto L_0x00ea
            r20 = r3
            boolean r3 = r0.f2876t
            if (r3 == 0) goto L_0x00e8
            if (r14 <= 0) goto L_0x00ec
        L_0x00e8:
            r3 = 1
            goto L_0x00ed
        L_0x00ea:
            r20 = r3
        L_0x00ec:
            r3 = 0
        L_0x00ed:
            if (r3 == 0) goto L_0x0133
            r21 = r3
            android.view.View r3 = r0.f2881y
            android.view.View r3 = r0.mo6658a(r5, r3, r7)
            r22 = r7
            android.view.View r7 = r0.f2881y
            if (r7 != 0) goto L_0x00ff
            r0.f2881y = r3
        L_0x00ff:
            boolean r7 = r0.f2876t
            if (r7 == 0) goto L_0x0110
            r7 = 0
            int r23 = android.support.p001v7.widget.ActionMenuView.m4380a(r3, r13, r14, r6, r7)
            int r14 = r14 - r23
            if (r23 != 0) goto L_0x010f
            r7 = 0
            r21 = r7
        L_0x010f:
            goto L_0x0113
        L_0x0110:
            r3.measure(r6, r6)
        L_0x0113:
            int r7 = r3.getMeasuredWidth()
            int r4 = r4 - r7
            if (r10 != 0) goto L_0x011b
            r10 = r7
        L_0x011b:
            r23 = r3
            boolean r3 = r0.f2876t
            if (r3 == 0) goto L_0x0129
            if (r4 < 0) goto L_0x0125
            r3 = 1
            goto L_0x0126
        L_0x0125:
            r3 = 0
        L_0x0126:
            r3 = r21 & r3
            goto L_0x0137
        L_0x0129:
            int r3 = r4 + r10
            if (r3 <= 0) goto L_0x012f
            r3 = 1
            goto L_0x0130
        L_0x012f:
            r3 = 0
        L_0x0130:
            r3 = r21 & r3
            goto L_0x0137
        L_0x0133:
            r21 = r3
            r22 = r7
        L_0x0137:
            if (r3 == 0) goto L_0x0142
            if (r2 == 0) goto L_0x0142
            r7 = 1
            r12.put(r2, r7)
            r21 = r1
            goto L_0x0173
        L_0x0142:
            if (r8 == 0) goto L_0x0171
            r7 = 0
            r12.put(r2, r7)
            r7 = 0
        L_0x0149:
            if (r7 >= r15) goto L_0x016e
            java.lang.Object r18 = r1.get(r7)
            r0 = r18
            android.support.v7.view.menu.p r0 = (android.support.p001v7.view.menu.C0879p) r0
            r21 = r1
            int r1 = r0.getGroupId()
            if (r1 != r2) goto L_0x0167
            boolean r1 = r0.mo6794h()
            if (r1 == 0) goto L_0x0163
            int r20 = r20 + 1
        L_0x0163:
            r1 = 0
            r0.mo6777d(r1)
        L_0x0167:
            int r7 = r7 + 1
            r0 = r24
            r1 = r21
            goto L_0x0149
        L_0x016e:
            r21 = r1
            goto L_0x0173
        L_0x0171:
            r21 = r1
        L_0x0173:
            if (r3 == 0) goto L_0x0177
            int r20 = r20 + -1
        L_0x0177:
            r5.mo6777d(r3)
            r3 = r20
            r0 = 0
            goto L_0x0188
        L_0x017e:
            r21 = r1
            r20 = r3
            r22 = r7
            r0 = 0
            r5.mo6777d(r0)
        L_0x0188:
            int r15 = r15 + 1
            r5 = 0
            r0 = r24
            r2 = r17
            r8 = r19
            r1 = r21
            r7 = r22
            goto L_0x006f
        L_0x0197:
            r21 = r1
            r17 = r2
            r20 = r3
            r22 = r7
            r19 = r8
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p001v7.widget.ActionMenuPresenter.mo4083b():boolean");
    }

    /* renamed from: a */
    public void mo4078a(C0873l menu, boolean allMenusAreClosing) {
        mo7068d();
        super.mo4078a(menu, allMenusAreClosing);
    }

    /* renamed from: a */
    public Parcelable mo4073a() {
        SavedState state = new SavedState();
        state.f2883a = this.f2866E;
        return state;
    }

    /* renamed from: a */
    public void mo4076a(Parcelable state) {
        if (state instanceof SavedState) {
            int i = ((SavedState) state).f2883a;
            if (i > 0) {
                MenuItem item = this.f2643c.findItem(i);
                if (item != null) {
                    mo4080a((C0858D) item.getSubMenu());
                }
            }
        }
    }

    /* renamed from: a */
    public void mo7065a(ActionMenuView menuView) {
        this.f2649i = menuView;
        menuView.mo4100a(this.f2643c);
    }
}
