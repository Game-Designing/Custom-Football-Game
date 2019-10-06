package android.support.p001v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.p001v7.view.menu.ActionMenuItemView;
import android.support.p001v7.view.menu.C0873l;
import android.support.p001v7.view.menu.C0873l.C0874a;
import android.support.p001v7.view.menu.C0873l.C0875b;
import android.support.p001v7.view.menu.C0879p;
import android.support.p001v7.view.menu.C0890v;
import android.support.p001v7.view.menu.C0890v.C0891a;
import android.support.p001v7.view.menu.C0892w;
import android.support.p001v7.widget.C1101pa.C1102a;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;

/* renamed from: android.support.v7.widget.ActionMenuView */
public class ActionMenuView extends C1101pa implements C0875b, C0892w {

    /* renamed from: a */
    private C0873l f2892a;

    /* renamed from: b */
    private Context f2893b;

    /* renamed from: c */
    private int f2894c;

    /* renamed from: d */
    private boolean f2895d;

    /* renamed from: e */
    private ActionMenuPresenter f2896e;

    /* renamed from: f */
    private C0891a f2897f;

    /* renamed from: g */
    C0874a f2898g;

    /* renamed from: h */
    private boolean f2899h;

    /* renamed from: i */
    private int f2900i;

    /* renamed from: j */
    private int f2901j;

    /* renamed from: k */
    private int f2902k;

    /* renamed from: l */
    C0914e f2903l;

    /* renamed from: android.support.v7.widget.ActionMenuView$a */
    public interface C0910a {
        /* renamed from: i */
        boolean mo6525i();

        /* renamed from: j */
        boolean mo6526j();
    }

    /* renamed from: android.support.v7.widget.ActionMenuView$b */
    private static class C0911b implements C0891a {
        C0911b() {
        }

        /* renamed from: a */
        public void mo6117a(C0873l menu, boolean allMenusAreClosing) {
        }

        /* renamed from: a */
        public boolean mo6118a(C0873l subMenu) {
            return false;
        }
    }

    /* renamed from: android.support.v7.widget.ActionMenuView$c */
    public static class C0912c extends C1102a {
        @ExportedProperty

        /* renamed from: c */
        public boolean f2904c;
        @ExportedProperty

        /* renamed from: d */
        public int f2905d;
        @ExportedProperty

        /* renamed from: e */
        public int f2906e;
        @ExportedProperty

        /* renamed from: f */
        public boolean f2907f;
        @ExportedProperty

        /* renamed from: g */
        public boolean f2908g;

        /* renamed from: h */
        boolean f2909h;

        public C0912c(Context c, AttributeSet attrs) {
            super(c, attrs);
        }

        public C0912c(LayoutParams other) {
            super(other);
        }

        public C0912c(C0912c other) {
            super(other);
            this.f2904c = other.f2904c;
        }

        public C0912c(int width, int height) {
            super(width, height);
            this.f2904c = false;
        }
    }

    /* renamed from: android.support.v7.widget.ActionMenuView$d */
    private class C0913d implements C0874a {
        C0913d() {
        }

        /* renamed from: a */
        public boolean mo4699a(C0873l menu, MenuItem item) {
            C0914e eVar = ActionMenuView.this.f2903l;
            return eVar != null && eVar.onMenuItemClick(item);
        }

        /* renamed from: a */
        public void mo4698a(C0873l menu) {
            C0874a aVar = ActionMenuView.this.f2898g;
            if (aVar != null) {
                aVar.mo4698a(menu);
            }
        }
    }

    /* renamed from: android.support.v7.widget.ActionMenuView$e */
    public interface C0914e {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    public ActionMenuView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setBaselineAligned(false);
        float density = context.getResources().getDisplayMetrics().density;
        this.f2901j = (int) (56.0f * density);
        this.f2902k = (int) (4.0f * density);
        this.f2893b = context;
        this.f2894c = 0;
    }

    public void setPopupTheme(int resId) {
        if (this.f2894c != resId) {
            this.f2894c = resId;
            if (resId == 0) {
                this.f2893b = getContext();
            } else {
                this.f2893b = new ContextThemeWrapper(getContext(), resId);
            }
        }
    }

    public int getPopupTheme() {
        return this.f2894c;
    }

    public void setPresenter(ActionMenuPresenter presenter) {
        this.f2896e = presenter;
        this.f2896e.mo7065a(this);
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        ActionMenuPresenter actionMenuPresenter = this.f2896e;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.mo4079a(false);
            if (this.f2896e.mo7073i()) {
                this.f2896e.mo7070f();
                this.f2896e.mo7074j();
            }
        }
    }

    public void setOnMenuItemClickListener(C0914e listener) {
        this.f2903l = listener;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        boolean wasFormatted = this.f2899h;
        this.f2899h = MeasureSpec.getMode(widthMeasureSpec) == 1073741824;
        if (wasFormatted != this.f2899h) {
            this.f2900i = 0;
        }
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        if (this.f2899h) {
            C0873l lVar = this.f2892a;
            if (!(lVar == null || widthSize == this.f2900i)) {
                this.f2900i = widthSize;
                lVar.mo6727b(true);
            }
        }
        int childCount = getChildCount();
        if (!this.f2899h || childCount <= 0) {
            for (int i = 0; i < childCount; i++) {
                C0912c lp = (C0912c) getChildAt(i).getLayoutParams();
                lp.rightMargin = 0;
                lp.leftMargin = 0;
            }
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        m4381a(widthMeasureSpec, heightMeasureSpec);
    }

    /* renamed from: a */
    private void m4381a(int widthMeasureSpec, int heightMeasureSpec) {
        int maxChildHeight;
        int widthSize;
        boolean needsExpansion;
        int heightSize;
        int heightPadding;
        int cellSizeRemaining;
        boolean z;
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize2 = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize2 = MeasureSpec.getSize(heightMeasureSpec);
        int widthPadding = getPaddingLeft() + getPaddingRight();
        int heightPadding2 = getPaddingTop() + getPaddingBottom();
        int itemHeightSpec = ViewGroup.getChildMeasureSpec(heightMeasureSpec, heightPadding2, -2);
        int widthSize3 = widthSize2 - widthPadding;
        int i = this.f2901j;
        int cellCount = widthSize3 / i;
        int cellSizeRemaining2 = widthSize3 % i;
        if (cellCount == 0) {
            setMeasuredDimension(widthSize3, 0);
            return;
        }
        int cellSize = i + (cellSizeRemaining2 / cellCount);
        int cellsRemaining = cellCount;
        boolean hasOverflow = false;
        int childCount = getChildCount();
        int heightSize3 = heightSize2;
        int maxChildHeight2 = 0;
        int visibleItemCount = 0;
        int expandableItemCount = 0;
        int maxCellsUsed = 0;
        int cellsRemaining2 = cellsRemaining;
        int i2 = 0;
        long smallestItemsAt = 0;
        while (true) {
            int widthPadding2 = widthPadding;
            if (i2 >= childCount) {
                break;
            }
            View child = getChildAt(i2);
            int cellCount2 = cellCount;
            if (child.getVisibility() == 8) {
                heightPadding = heightPadding2;
                cellSizeRemaining = cellSizeRemaining2;
            } else {
                boolean isGeneratedItem = child instanceof ActionMenuItemView;
                visibleItemCount++;
                if (isGeneratedItem) {
                    int i3 = this.f2902k;
                    cellSizeRemaining = cellSizeRemaining2;
                    z = false;
                    child.setPadding(i3, 0, i3, 0);
                } else {
                    cellSizeRemaining = cellSizeRemaining2;
                    z = false;
                }
                C0912c lp = (C0912c) child.getLayoutParams();
                lp.f2909h = z;
                lp.f2906e = z ? 1 : 0;
                lp.f2905d = z;
                lp.f2907f = z;
                lp.leftMargin = z;
                lp.rightMargin = z;
                lp.f2908g = isGeneratedItem && ((ActionMenuItemView) child).mo6527k();
                boolean z2 = isGeneratedItem;
                int cellsUsed = m4380a(child, cellSize, lp.f2904c ? 1 : cellsRemaining2, itemHeightSpec, heightPadding2);
                maxCellsUsed = Math.max(maxCellsUsed, cellsUsed);
                heightPadding = heightPadding2;
                if (lp.f2907f != 0) {
                    expandableItemCount++;
                }
                if (lp.f2904c) {
                    hasOverflow = true;
                }
                cellsRemaining2 -= cellsUsed;
                maxChildHeight2 = Math.max(maxChildHeight2, child.getMeasuredHeight());
                if (cellsUsed == 1) {
                    View view = child;
                    smallestItemsAt |= (long) (1 << i2);
                    maxChildHeight2 = maxChildHeight2;
                } else {
                    View view2 = child;
                }
            }
            i2++;
            int i4 = heightMeasureSpec;
            widthPadding = widthPadding2;
            cellCount = cellCount2;
            cellSizeRemaining2 = cellSizeRemaining;
            heightPadding2 = heightPadding;
        }
        int i5 = cellCount;
        int i6 = cellSizeRemaining2;
        boolean centerSingleExpandedItem = hasOverflow && visibleItemCount == 2;
        boolean needsExpansion2 = false;
        while (true) {
            if (expandableItemCount <= 0 || cellsRemaining2 <= 0) {
                widthSize = widthSize3;
                maxChildHeight = maxChildHeight2;
                needsExpansion = needsExpansion2;
            } else {
                long minCellsAt = 0;
                int minCells = Integer.MAX_VALUE;
                int minCellsItemCount = 0;
                int i7 = 0;
                while (i7 < childCount) {
                    View child2 = getChildAt(i7);
                    boolean needsExpansion3 = needsExpansion2;
                    C0912c lp2 = (C0912c) child2.getLayoutParams();
                    View view3 = child2;
                    if (lp2.f2907f) {
                        int i8 = lp2.f2905d;
                        if (i8 < minCells) {
                            minCells = lp2.f2905d;
                            minCellsAt = 1 << i7;
                            minCellsItemCount = 1;
                        } else if (i8 == minCells) {
                            minCellsAt |= 1 << i7;
                            minCellsItemCount++;
                        }
                    }
                    i7++;
                    needsExpansion2 = needsExpansion3;
                }
                needsExpansion = needsExpansion2;
                smallestItemsAt |= minCellsAt;
                if (minCellsItemCount > cellsRemaining2) {
                    widthSize = widthSize3;
                    maxChildHeight = maxChildHeight2;
                    break;
                }
                int minCells2 = minCells + 1;
                int i9 = 0;
                while (i9 < childCount) {
                    View child3 = getChildAt(i9);
                    C0912c lp3 = (C0912c) child3.getLayoutParams();
                    int minCellsItemCount2 = minCellsItemCount;
                    int widthSize4 = widthSize3;
                    int maxChildHeight3 = maxChildHeight2;
                    if ((minCellsAt & ((long) (1 << i9))) != 0) {
                        if (centerSingleExpandedItem && lp3.f2908g && cellsRemaining2 == 1) {
                            int i10 = this.f2902k;
                            child3.setPadding(i10 + cellSize, 0, i10, 0);
                        }
                        lp3.f2905d++;
                        lp3.f2909h = true;
                        cellsRemaining2--;
                    } else if (lp3.f2905d == minCells2) {
                        smallestItemsAt |= (long) (1 << i9);
                    }
                    i9++;
                    minCellsItemCount = minCellsItemCount2;
                    widthSize3 = widthSize4;
                    maxChildHeight2 = maxChildHeight3;
                }
                int i11 = maxChildHeight2;
                int i12 = minCellsItemCount;
                needsExpansion2 = true;
            }
        }
        widthSize = widthSize3;
        maxChildHeight = maxChildHeight2;
        needsExpansion = needsExpansion2;
        boolean singleItem = !hasOverflow && visibleItemCount == 1;
        if (cellsRemaining2 <= 0 || smallestItemsAt == 0) {
            boolean z3 = centerSingleExpandedItem;
        } else if (cellsRemaining2 < visibleItemCount - 1 || singleItem || maxCellsUsed > 1) {
            float expandCount = (float) Long.bitCount(smallestItemsAt);
            if (!singleItem) {
                if ((smallestItemsAt & 1) != 0) {
                    if (!((C0912c) getChildAt(0).getLayoutParams()).f2908g) {
                        expandCount -= 0.5f;
                    }
                }
                boolean z4 = centerSingleExpandedItem;
                if ((smallestItemsAt & ((long) (1 << (childCount - 1)))) != 0 && !((C0912c) getChildAt(childCount - 1).getLayoutParams()).f2908g) {
                    expandCount -= 0.5f;
                }
            }
            int extraPixels = expandCount > 0.0f ? (int) (((float) (cellsRemaining2 * cellSize)) / expandCount) : 0;
            int i13 = 0;
            boolean needsExpansion4 = needsExpansion;
            while (i13 < childCount) {
                boolean singleItem2 = singleItem;
                float expandCount2 = expandCount;
                if ((smallestItemsAt & ((long) (1 << i13))) != 0) {
                    View child4 = getChildAt(i13);
                    C0912c lp4 = (C0912c) child4.getLayoutParams();
                    if (child4 instanceof ActionMenuItemView) {
                        lp4.f2906e = extraPixels;
                        lp4.f2909h = true;
                        if (i13 == 0 && !lp4.f2908g) {
                            lp4.leftMargin = (-extraPixels) / 2;
                        }
                        needsExpansion4 = true;
                    } else if (lp4.f2904c) {
                        lp4.f2906e = extraPixels;
                        lp4.f2909h = true;
                        lp4.rightMargin = (-extraPixels) / 2;
                        needsExpansion4 = true;
                    } else {
                        if (i13 != 0) {
                            lp4.leftMargin = extraPixels / 2;
                        }
                        if (i13 != childCount - 1) {
                            lp4.rightMargin = extraPixels / 2;
                        }
                    }
                }
                i13++;
                singleItem = singleItem2;
                expandCount = expandCount2;
            }
            float f = expandCount;
            needsExpansion = needsExpansion4;
        } else {
            boolean z5 = singleItem;
            boolean z6 = centerSingleExpandedItem;
        }
        if (needsExpansion) {
            for (int i14 = 0; i14 < childCount; i14++) {
                View child5 = getChildAt(i14);
                C0912c lp5 = (C0912c) child5.getLayoutParams();
                if (lp5.f2909h) {
                    child5.measure(MeasureSpec.makeMeasureSpec((lp5.f2905d * cellSize) + lp5.f2906e, 1073741824), itemHeightSpec);
                }
            }
        }
        if (heightMode != 1073741824) {
            heightSize = maxChildHeight;
        } else {
            heightSize = heightSize3;
        }
        setMeasuredDimension(widthSize, heightSize);
    }

    /* renamed from: a */
    static int m4380a(View child, int cellSize, int cellsRemaining, int parentHeightMeasureSpec, int parentHeightPadding) {
        View view = child;
        int i = cellsRemaining;
        C0912c lp = (C0912c) child.getLayoutParams();
        int childHeightSpec = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(parentHeightMeasureSpec) - parentHeightPadding, MeasureSpec.getMode(parentHeightMeasureSpec));
        ActionMenuItemView itemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean expandable = false;
        boolean hasText = itemView != null && itemView.mo6527k();
        int cellsUsed = 0;
        if (i > 0 && (!hasText || i >= 2)) {
            child.measure(MeasureSpec.makeMeasureSpec(cellSize * i, LinearLayoutManager.INVALID_OFFSET), childHeightSpec);
            int measuredWidth = child.getMeasuredWidth();
            cellsUsed = measuredWidth / cellSize;
            if (measuredWidth % cellSize != 0) {
                cellsUsed++;
            }
            if (hasText && cellsUsed < 2) {
                cellsUsed = 2;
            }
        }
        if (!lp.f2904c && hasText) {
            expandable = true;
        }
        lp.f2907f = expandable;
        lp.f2905d = cellsUsed;
        child.measure(MeasureSpec.makeMeasureSpec(cellsUsed * cellSize, 1073741824), childHeightSpec);
        return cellsUsed;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int i;
        int overflowWidth;
        int dividerWidth;
        boolean isLayoutRtl;
        int midVertical;
        int r;
        int l;
        ActionMenuView actionMenuView = this;
        if (!actionMenuView.f2899h) {
            super.onLayout(changed, left, top, right, bottom);
            return;
        }
        int childCount = getChildCount();
        int midVertical2 = (bottom - top) / 2;
        int dividerWidth2 = getDividerWidth();
        int overflowWidth2 = 0;
        int nonOverflowWidth = 0;
        int nonOverflowCount = 0;
        int widthRemaining = ((right - left) - getPaddingRight()) - getPaddingLeft();
        boolean hasOverflow = false;
        boolean isLayoutRtl2 = C0946Ib.m4565a(this);
        int i2 = 0;
        while (true) {
            i = 8;
            if (i2 >= childCount) {
                break;
            }
            View v = actionMenuView.getChildAt(i2);
            if (v.getVisibility() == 8) {
                midVertical = midVertical2;
                isLayoutRtl = isLayoutRtl2;
            } else {
                C0912c p = (C0912c) v.getLayoutParams();
                if (p.f2904c) {
                    overflowWidth2 = v.getMeasuredWidth();
                    if (actionMenuView.mo7082a(i2)) {
                        overflowWidth2 += dividerWidth2;
                    }
                    int height = v.getMeasuredHeight();
                    if (isLayoutRtl2) {
                        l = getPaddingLeft() + p.leftMargin;
                        r = l + overflowWidth2;
                    } else {
                        r = (getWidth() - getPaddingRight()) - p.rightMargin;
                        l = r - overflowWidth2;
                    }
                    isLayoutRtl = isLayoutRtl2;
                    int t = midVertical2 - (height / 2);
                    midVertical = midVertical2;
                    v.layout(l, t, r, t + height);
                    widthRemaining -= overflowWidth2;
                    hasOverflow = true;
                } else {
                    midVertical = midVertical2;
                    isLayoutRtl = isLayoutRtl2;
                    int size = v.getMeasuredWidth() + p.leftMargin + p.rightMargin;
                    nonOverflowWidth += size;
                    widthRemaining -= size;
                    if (actionMenuView.mo7082a(i2)) {
                        nonOverflowWidth += dividerWidth2;
                    }
                    nonOverflowCount++;
                }
            }
            i2++;
            midVertical2 = midVertical;
            isLayoutRtl2 = isLayoutRtl;
        }
        int midVertical3 = midVertical2;
        boolean isLayoutRtl3 = isLayoutRtl2;
        int i3 = 1;
        if (childCount != 1 || hasOverflow) {
            if (hasOverflow) {
                i3 = 0;
            }
            int spacerCount = nonOverflowCount - i3;
            int spacerSize = Math.max(0, spacerCount > 0 ? widthRemaining / spacerCount : 0);
            if (isLayoutRtl3) {
                int startRight = getWidth() - getPaddingRight();
                int i4 = 0;
                while (i4 < childCount) {
                    View v2 = actionMenuView.getChildAt(i4);
                    C0912c lp = (C0912c) v2.getLayoutParams();
                    if (v2.getVisibility() == i) {
                        dividerWidth = dividerWidth2;
                        overflowWidth = overflowWidth2;
                    } else if (lp.f2904c) {
                        dividerWidth = dividerWidth2;
                        overflowWidth = overflowWidth2;
                    } else {
                        int startRight2 = startRight - lp.rightMargin;
                        int width = v2.getMeasuredWidth();
                        int height2 = v2.getMeasuredHeight();
                        int t2 = midVertical3 - (height2 / 2);
                        dividerWidth = dividerWidth2;
                        overflowWidth = overflowWidth2;
                        v2.layout(startRight2 - width, t2, startRight2, t2 + height2);
                        startRight = startRight2 - ((lp.leftMargin + width) + spacerSize);
                    }
                    i4++;
                    dividerWidth2 = dividerWidth;
                    overflowWidth2 = overflowWidth;
                    i = 8;
                }
                int i5 = overflowWidth2;
            } else {
                int i6 = overflowWidth2;
                int startLeft = getPaddingLeft();
                int i7 = 0;
                while (i7 < childCount) {
                    View v3 = actionMenuView.getChildAt(i7);
                    C0912c lp2 = (C0912c) v3.getLayoutParams();
                    if (v3.getVisibility() != 8 && !lp2.f2904c) {
                        int startLeft2 = startLeft + lp2.leftMargin;
                        int width2 = v3.getMeasuredWidth();
                        int height3 = v3.getMeasuredHeight();
                        int t3 = midVertical3 - (height3 / 2);
                        v3.layout(startLeft2, t3, startLeft2 + width2, t3 + height3);
                        startLeft = startLeft2 + lp2.rightMargin + width2 + spacerSize;
                    }
                    i7++;
                    actionMenuView = this;
                }
            }
            return;
        }
        View v4 = actionMenuView.getChildAt(0);
        int width3 = v4.getMeasuredWidth();
        int height4 = v4.getMeasuredHeight();
        int l2 = ((right - left) / 2) - (width3 / 2);
        int t4 = midVertical3 - (height4 / 2);
        v4.layout(l2, t4, l2 + width3, t4 + height4);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mo7080a();
    }

    public void setOverflowIcon(Drawable icon) {
        getMenu();
        this.f2896e.mo7064a(icon);
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.f2896e.mo7069e();
    }

    /* renamed from: f */
    public boolean mo7089f() {
        return this.f2895d;
    }

    public void setOverflowReserved(boolean reserveOverflow) {
        this.f2895d = reserveOverflow;
    }

    /* access modifiers changed from: protected */
    public C0912c generateDefaultLayoutParams() {
        C0912c params = new C0912c(-2, -2);
        params.f3677b = 16;
        return params;
    }

    public C0912c generateLayoutParams(AttributeSet attrs) {
        return new C0912c(getContext(), attrs);
    }

    /* access modifiers changed from: protected */
    public C0912c generateLayoutParams(LayoutParams p) {
        if (p == null) {
            return generateDefaultLayoutParams();
        }
        C0912c result = p instanceof C0912c ? new C0912c((C0912c) p) : new C0912c(p);
        if (result.f3677b <= 0) {
            result.f3677b = 16;
        }
        return result;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(LayoutParams p) {
        return p != null && (p instanceof C0912c);
    }

    /* renamed from: b */
    public C0912c mo7083b() {
        C0912c result = generateDefaultLayoutParams();
        result.f2904c = true;
        return result;
    }

    /* renamed from: a */
    public boolean mo6589a(C0879p item) {
        return this.f2892a.mo6713a((MenuItem) item, 0);
    }

    public int getWindowAnimations() {
        return 0;
    }

    /* renamed from: a */
    public void mo4100a(C0873l menu) {
        this.f2892a = menu;
    }

    public Menu getMenu() {
        if (this.f2892a == null) {
            Context context = getContext();
            this.f2892a = new C0873l(context);
            this.f2892a.mo6561a((C0874a) new C0913d());
            this.f2896e = new ActionMenuPresenter(context);
            this.f2896e.mo7067c(true);
            ActionMenuPresenter actionMenuPresenter = this.f2896e;
            C0891a aVar = this.f2897f;
            if (aVar == null) {
                aVar = new C0911b();
            }
            actionMenuPresenter.mo6548a(aVar);
            this.f2892a.mo6709a((C0890v) this.f2896e, this.f2893b);
            this.f2896e.mo7065a(this);
        }
        return this.f2892a;
    }

    /* renamed from: a */
    public void mo7081a(C0891a pcb, C0874a mcb) {
        this.f2897f = pcb;
        this.f2898g = mcb;
    }

    /* renamed from: g */
    public C0873l mo7090g() {
        return this.f2892a;
    }

    /* renamed from: i */
    public boolean mo7098i() {
        ActionMenuPresenter actionMenuPresenter = this.f2896e;
        return actionMenuPresenter != null && actionMenuPresenter.mo7074j();
    }

    /* renamed from: c */
    public boolean mo7084c() {
        ActionMenuPresenter actionMenuPresenter = this.f2896e;
        return actionMenuPresenter != null && actionMenuPresenter.mo7070f();
    }

    /* renamed from: e */
    public boolean mo7088e() {
        ActionMenuPresenter actionMenuPresenter = this.f2896e;
        return actionMenuPresenter != null && actionMenuPresenter.mo7073i();
    }

    /* renamed from: d */
    public boolean mo7086d() {
        ActionMenuPresenter actionMenuPresenter = this.f2896e;
        return actionMenuPresenter != null && actionMenuPresenter.mo7072h();
    }

    /* renamed from: a */
    public void mo7080a() {
        ActionMenuPresenter actionMenuPresenter = this.f2896e;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.mo7068d();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo7082a(int childIndex) {
        if (childIndex == 0) {
            return false;
        }
        View childBefore = getChildAt(childIndex - 1);
        View child = getChildAt(childIndex);
        boolean result = false;
        if (childIndex < getChildCount() && (childBefore instanceof C0910a)) {
            result = false | ((C0910a) childBefore).mo6525i();
        }
        if (childIndex > 0 && (child instanceof C0910a)) {
            result |= ((C0910a) child).mo6526j();
        }
        return result;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        return false;
    }

    public void setExpandedActionViewsExclusive(boolean exclusive) {
        this.f2896e.mo7066b(exclusive);
    }
}
