package android.support.p001v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.p000v4.view.C0587I;
import android.support.p000v4.widget.C0713o;
import android.support.p001v7.appcompat.C0793R;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.reflect.Field;
import p002b.p003c.p053g.p054a.p055a.C1200a;
import p002b.p003c.p062h.p066c.p067a.C1285a;

/* renamed from: android.support.v7.widget.ga */
/* compiled from: DropDownListView */
class C1058ga extends ListView {

    /* renamed from: a */
    private final Rect f3509a = new Rect();

    /* renamed from: b */
    private int f3510b = 0;

    /* renamed from: c */
    private int f3511c = 0;

    /* renamed from: d */
    private int f3512d = 0;

    /* renamed from: e */
    private int f3513e = 0;

    /* renamed from: f */
    private int f3514f;

    /* renamed from: g */
    private Field f3515g;

    /* renamed from: h */
    private C1059a f3516h;

    /* renamed from: i */
    private boolean f3517i;

    /* renamed from: j */
    private boolean f3518j;

    /* renamed from: k */
    private boolean f3519k;

    /* renamed from: l */
    private C0587I f3520l;

    /* renamed from: m */
    private C0713o f3521m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public C1060b f3522n;

    /* renamed from: android.support.v7.widget.ga$a */
    /* compiled from: DropDownListView */
    private static class C1059a extends C1285a {

        /* renamed from: b */
        private boolean f3523b = true;

        C1059a(Drawable drawable) {
            super(drawable);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo8444a(boolean enabled) {
            this.f3523b = enabled;
        }

        public boolean setState(int[] stateSet) {
            if (this.f3523b) {
                return super.setState(stateSet);
            }
            return false;
        }

        public void draw(Canvas canvas) {
            if (this.f3523b) {
                super.draw(canvas);
            }
        }

        public void setHotspot(float x, float y) {
            if (this.f3523b) {
                super.setHotspot(x, y);
            }
        }

        public void setHotspotBounds(int left, int top, int right, int bottom) {
            if (this.f3523b) {
                super.setHotspotBounds(left, top, right, bottom);
            }
        }

        public boolean setVisible(boolean visible, boolean restart) {
            if (this.f3523b) {
                return super.setVisible(visible, restart);
            }
            return false;
        }
    }

    /* renamed from: android.support.v7.widget.ga$b */
    /* compiled from: DropDownListView */
    private class C1060b implements Runnable {
        private C1060b() {
        }

        public void run() {
            C1058ga.this.f3522n = null;
            C1058ga.this.drawableStateChanged();
        }

        /* renamed from: a */
        public void mo8449a() {
            C1058ga.this.f3522n = null;
            C1058ga.this.removeCallbacks(this);
        }

        /* renamed from: b */
        public void mo8450b() {
            C1058ga.this.post(this);
        }
    }

    C1058ga(Context context, boolean hijackFocus) {
        super(context, null, C0793R.attr.dropDownListViewStyle);
        this.f3518j = hijackFocus;
        setCacheColorHint(0);
        try {
            this.f3515g = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.f3515g.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public boolean isInTouchMode() {
        return (this.f3518j && this.f3517i) || super.isInTouchMode();
    }

    public boolean hasWindowFocus() {
        return this.f3518j || super.hasWindowFocus();
    }

    public boolean isFocused() {
        return this.f3518j || super.isFocused();
    }

    public boolean hasFocus() {
        return this.f3518j || super.hasFocus();
    }

    public void setSelector(Drawable sel) {
        this.f3516h = sel != null ? new C1059a(sel) : null;
        super.setSelector(this.f3516h);
        Rect padding = new Rect();
        if (sel != null) {
            sel.getPadding(padding);
        }
        this.f3510b = padding.left;
        this.f3511c = padding.top;
        this.f3512d = padding.right;
        this.f3513e = padding.bottom;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        if (this.f3522n == null) {
            super.drawableStateChanged();
            setSelectorEnabled(true);
            m5267c();
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        m5262a(canvas);
        super.dispatchDraw(canvas);
    }

    public boolean onTouchEvent(MotionEvent ev) {
        if (ev.getAction() == 0) {
            this.f3514f = pointToPosition((int) ev.getX(), (int) ev.getY());
        }
        C1060b bVar = this.f3522n;
        if (bVar != null) {
            bVar.mo8449a();
        }
        return super.onTouchEvent(ev);
    }

    /* renamed from: a */
    public int mo8431a(int widthMeasureSpec, int startPosition, int endPosition, int maxHeight, int disallowPartialChildPosition) {
        LayoutParams childLp;
        int heightMeasureSpec;
        int i = maxHeight;
        int i2 = disallowPartialChildPosition;
        int paddingTop = getListPaddingTop();
        int paddingBottom = getListPaddingBottom();
        int listPaddingLeft = getListPaddingLeft();
        int listPaddingRight = getListPaddingRight();
        int reportedDividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return paddingTop + paddingBottom;
        }
        int returnedHeight = paddingTop + paddingBottom;
        int dividerHeight = (reportedDividerHeight <= 0 || divider == null) ? 0 : reportedDividerHeight;
        View child = null;
        int count = adapter.getCount();
        int viewType = 0;
        int prevHeightWithoutPartialChild = 0;
        int returnedHeight2 = returnedHeight;
        int i3 = 0;
        while (i3 < count) {
            int paddingTop2 = paddingTop;
            int paddingTop3 = adapter.getItemViewType(i3);
            if (paddingTop3 != viewType) {
                child = null;
                viewType = paddingTop3;
            }
            int i4 = paddingTop3;
            child = adapter.getView(i3, child, this);
            LayoutParams childLp2 = child.getLayoutParams();
            if (childLp2 == null) {
                childLp = generateDefaultLayoutParams();
                child.setLayoutParams(childLp);
            } else {
                childLp = childLp2;
            }
            int paddingBottom2 = paddingBottom;
            int paddingBottom3 = childLp.height;
            if (paddingBottom3 > 0) {
                LayoutParams layoutParams = childLp;
                heightMeasureSpec = MeasureSpec.makeMeasureSpec(paddingBottom3, 1073741824);
            } else {
                heightMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
            }
            child.measure(widthMeasureSpec, heightMeasureSpec);
            child.forceLayout();
            if (i3 > 0) {
                returnedHeight2 += dividerHeight;
            }
            returnedHeight2 += child.getMeasuredHeight();
            if (returnedHeight2 >= i) {
                return (i2 < 0 || i3 <= i2 || prevHeightWithoutPartialChild <= 0 || returnedHeight2 == i) ? i : prevHeightWithoutPartialChild;
            }
            if (i2 >= 0 && i3 >= i2) {
                prevHeightWithoutPartialChild = returnedHeight2;
            }
            i3++;
            paddingTop = paddingTop2;
            paddingBottom = paddingBottom2;
        }
        int i5 = paddingBottom;
        int paddingTop4 = widthMeasureSpec;
        return returnedHeight2;
    }

    private void setSelectorEnabled(boolean enabled) {
        C1059a aVar = this.f3516h;
        if (aVar != null) {
            aVar.mo8444a(enabled);
        }
    }

    public boolean onHoverEvent(MotionEvent ev) {
        if (VERSION.SDK_INT < 26) {
            return super.onHoverEvent(ev);
        }
        int action = ev.getActionMasked();
        if (action == 10 && this.f3522n == null) {
            this.f3522n = new C1060b();
            this.f3522n.mo8450b();
        }
        boolean handled = super.onHoverEvent(ev);
        if (action == 9 || action == 7) {
            int position = pointToPosition((int) ev.getX(), (int) ev.getY());
            if (!(position == -1 || position == getSelectedItemPosition())) {
                View hoveredItem = getChildAt(position - getFirstVisiblePosition());
                if (hoveredItem.isEnabled()) {
                    setSelectionFromTop(position, hoveredItem.getTop() - getTop());
                }
                m5267c();
            }
        } else {
            setSelection(-1);
        }
        return handled;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        this.f3522n = null;
        super.onDetachedFromWindow();
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0062  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo8432a(android.view.MotionEvent r12, int r13) {
        /*
            r11 = this;
            r0 = 1
            r1 = 0
            int r2 = r12.getActionMasked()
            r3 = 1
            if (r2 == r3) goto L_0x0012
            r4 = 2
            if (r2 == r4) goto L_0x0013
            r4 = 3
            if (r2 == r4) goto L_0x0010
            goto L_0x0043
        L_0x0010:
            r0 = 0
            goto L_0x0043
        L_0x0012:
            r0 = 0
        L_0x0013:
            int r4 = r12.findPointerIndex(r13)
            if (r4 >= 0) goto L_0x001b
            r0 = 0
            goto L_0x0043
        L_0x001b:
            float r5 = r12.getX(r4)
            int r5 = (int) r5
            float r6 = r12.getY(r4)
            int r6 = (int) r6
            int r7 = r11.pointToPosition(r5, r6)
            r8 = -1
            if (r7 != r8) goto L_0x002e
            r1 = 1
            goto L_0x0043
        L_0x002e:
            int r8 = r11.getFirstVisiblePosition()
            int r8 = r7 - r8
            android.view.View r8 = r11.getChildAt(r8)
            float r9 = (float) r5
            float r10 = (float) r6
            r11.m5264a(r8, r7, r9, r10)
            r0 = 1
            if (r2 != r3) goto L_0x0043
            r11.m5263a(r8, r7)
        L_0x0043:
            if (r0 == 0) goto L_0x0047
            if (r1 == 0) goto L_0x004a
        L_0x0047:
            r11.m5259a()
        L_0x004a:
            if (r0 == 0) goto L_0x0062
            android.support.v4.widget.o r4 = r11.f3521m
            if (r4 != 0) goto L_0x0057
            android.support.v4.widget.o r4 = new android.support.v4.widget.o
            r4.<init>(r11)
            r11.f3521m = r4
        L_0x0057:
            android.support.v4.widget.o r4 = r11.f3521m
            r4.mo5896a(r3)
            android.support.v4.widget.o r3 = r11.f3521m
            r3.onTouch(r11, r12)
            goto L_0x006a
        L_0x0062:
            android.support.v4.widget.o r3 = r11.f3521m
            if (r3 == 0) goto L_0x006a
            r4 = 0
            r3.mo5896a(r4)
        L_0x006a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p001v7.widget.C1058ga.mo8432a(android.view.MotionEvent, int):boolean");
    }

    /* renamed from: a */
    private void m5263a(View child, int position) {
        performItemClick(child, position, getItemIdAtPosition(position));
    }

    /* access modifiers changed from: 0000 */
    public void setListSelectionHidden(boolean hideListSelection) {
        this.f3517i = hideListSelection;
    }

    /* renamed from: c */
    private void m5267c() {
        Drawable selector = getSelector();
        if (selector != null && m5266b() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    /* renamed from: a */
    private void m5262a(Canvas canvas) {
        if (!this.f3509a.isEmpty()) {
            Drawable selector = getSelector();
            if (selector != null) {
                selector.setBounds(this.f3509a);
                selector.draw(canvas);
            }
        }
    }

    /* renamed from: a */
    private void m5261a(int position, View sel, float x, float y) {
        m5265b(position, sel);
        Drawable selector = getSelector();
        if (selector != null && position != -1) {
            C1200a.m5724a(selector, x, y);
        }
    }

    /* renamed from: b */
    private void m5265b(int position, View sel) {
        Drawable selector = getSelector();
        boolean z = true;
        boolean manageState = (selector == null || position == -1) ? false : true;
        if (manageState) {
            selector.setVisible(false, false);
        }
        m5260a(position, sel);
        if (manageState) {
            Rect bounds = this.f3509a;
            float x = bounds.exactCenterX();
            float y = bounds.exactCenterY();
            if (getVisibility() != 0) {
                z = false;
            }
            selector.setVisible(z, false);
            C1200a.m5724a(selector, x, y);
        }
    }

    /* renamed from: a */
    private void m5260a(int position, View sel) {
        Rect selectorRect = this.f3509a;
        selectorRect.set(sel.getLeft(), sel.getTop(), sel.getRight(), sel.getBottom());
        selectorRect.left -= this.f3510b;
        selectorRect.top -= this.f3511c;
        selectorRect.right += this.f3512d;
        selectorRect.bottom += this.f3513e;
        try {
            boolean isChildViewEnabled = this.f3515g.getBoolean(this);
            if (sel.isEnabled() != isChildViewEnabled) {
                this.f3515g.set(this, Boolean.valueOf(!isChildViewEnabled));
                if (position != -1) {
                    refreshDrawableState();
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m5259a() {
        this.f3519k = false;
        setPressed(false);
        drawableStateChanged();
        View motionView = getChildAt(this.f3514f - getFirstVisiblePosition());
        if (motionView != null) {
            motionView.setPressed(false);
        }
        C0587I i = this.f3520l;
        if (i != null) {
            i.mo5475a();
            this.f3520l = null;
        }
    }

    /* renamed from: a */
    private void m5264a(View child, int position, float x, float y) {
        this.f3519k = true;
        if (VERSION.SDK_INT >= 21) {
            drawableHotspotChanged(x, y);
        }
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        int i = this.f3514f;
        if (i != -1) {
            View motionView = getChildAt(i - getFirstVisiblePosition());
            if (!(motionView == null || motionView == child || !motionView.isPressed())) {
                motionView.setPressed(false);
            }
        }
        this.f3514f = position;
        float childX = x - ((float) child.getLeft());
        float childY = y - ((float) child.getTop());
        if (VERSION.SDK_INT >= 21) {
            child.drawableHotspotChanged(childX, childY);
        }
        if (!child.isPressed()) {
            child.setPressed(true);
        }
        m5261a(position, child, x, y);
        setSelectorEnabled(false);
        refreshDrawableState();
    }

    /* renamed from: b */
    private boolean m5266b() {
        return this.f3519k;
    }
}
