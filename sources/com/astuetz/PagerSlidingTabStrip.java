package com.astuetz;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.p000v4.view.ViewPager;
import android.support.p000v4.view.ViewPager.C0597f;
import android.support.v4.util.Pair;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.astuetz.p097a.C5893a;
import com.astuetz.p097a.C5894b;
import com.astuetz.p097a.C5895c;
import com.astuetz.p097a.C5896d;
import p002b.p003c.p053g.p061f.C1268l;

public class PagerSlidingTabStrip extends HorizontalScrollView {

    /* renamed from: a */
    private static final int[] f10234a = {16842806, 16842965, 16842966, 16842968};

    /* renamed from: A */
    private boolean f10235A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public boolean f10236B;

    /* renamed from: C */
    private boolean f10237C;

    /* renamed from: D */
    private Typeface f10238D;

    /* renamed from: E */
    private int f10239E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public int f10240F;

    /* renamed from: G */
    private int f10241G;

    /* renamed from: H */
    private int f10242H;

    /* renamed from: I */
    private OnGlobalLayoutListener f10243I;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public LinearLayout f10244b;

    /* renamed from: c */
    private LayoutParams f10245c;

    /* renamed from: d */
    private final C5891d f10246d;

    /* renamed from: e */
    private final C5890c f10247e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C5889b f10248f;

    /* renamed from: g */
    public C0597f f10249g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public ViewPager f10250h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f10251i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public int f10252j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public float f10253k;

    /* renamed from: l */
    private Paint f10254l;

    /* renamed from: m */
    private Paint f10255m;

    /* renamed from: n */
    private int f10256n;

    /* renamed from: o */
    private int f10257o;

    /* renamed from: p */
    private int f10258p;

    /* renamed from: q */
    private int f10259q;

    /* renamed from: r */
    private int f10260r;

    /* renamed from: s */
    private int f10261s;

    /* renamed from: t */
    private int f10262t;

    /* renamed from: u */
    private int f10263u;

    /* renamed from: v */
    private int f10264v;

    /* renamed from: w */
    private ColorStateList f10265w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public int f10266x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public int f10267y;

    /* renamed from: z */
    private boolean f10268z;

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C5898c();

        /* renamed from: a */
        int f10269a;

        /* synthetic */ SavedState(Parcel x0, C5892a x1) {
            this(x0);
        }

        public SavedState(Parcelable superState) {
            super(superState);
        }

        private SavedState(Parcel in) {
            super(in);
            this.f10269a = in.readInt();
        }

        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeInt(this.f10269a);
        }
    }

    /* renamed from: com.astuetz.PagerSlidingTabStrip$a */
    public interface C5888a {
        /* renamed from: a */
        View mo18416a(ViewGroup viewGroup, int i);

        /* renamed from: a */
        void mo18417a(View view);

        /* renamed from: b */
        void mo18418b(View view);
    }

    /* renamed from: com.astuetz.PagerSlidingTabStrip$b */
    public interface C5889b {
        /* renamed from: a */
        void mo18419a(int i);
    }

    /* renamed from: com.astuetz.PagerSlidingTabStrip$c */
    private class C5890c implements C0597f {
        private C5890c() {
        }

        /* synthetic */ C5890c(PagerSlidingTabStrip x0, C5892a x1) {
            this();
        }

        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            PagerSlidingTabStrip.this.f10252j = position;
            PagerSlidingTabStrip.this.f10253k = positionOffset;
            PagerSlidingTabStrip.this.m10710a(position, PagerSlidingTabStrip.this.f10251i > 0 ? (int) (((float) PagerSlidingTabStrip.this.f10244b.getChildAt(position).getWidth()) * positionOffset) : 0);
            PagerSlidingTabStrip.this.invalidate();
            C0597f fVar = PagerSlidingTabStrip.this.f10249g;
            if (fVar != null) {
                fVar.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }
        }

        public void onPageScrollStateChanged(int state) {
            if (state == 0) {
                PagerSlidingTabStrip pagerSlidingTabStrip = PagerSlidingTabStrip.this;
                pagerSlidingTabStrip.m10710a(pagerSlidingTabStrip.f10250h.getCurrentItem(), 0);
            }
            PagerSlidingTabStrip.this.m10712a(PagerSlidingTabStrip.this.f10244b.getChildAt(PagerSlidingTabStrip.this.f10250h.getCurrentItem()));
            if (PagerSlidingTabStrip.this.f10250h.getCurrentItem() - 1 >= 0) {
                PagerSlidingTabStrip.this.m10718b(PagerSlidingTabStrip.this.f10244b.getChildAt(PagerSlidingTabStrip.this.f10250h.getCurrentItem() - 1));
            }
            if (PagerSlidingTabStrip.this.f10250h.getCurrentItem() + 1 <= PagerSlidingTabStrip.this.f10250h.getAdapter().getCount() - 1) {
                PagerSlidingTabStrip.this.m10718b(PagerSlidingTabStrip.this.f10244b.getChildAt(PagerSlidingTabStrip.this.f10250h.getCurrentItem() + 1));
            }
            C0597f fVar = PagerSlidingTabStrip.this.f10249g;
            if (fVar != null) {
                fVar.onPageScrollStateChanged(state);
            }
        }

        public void onPageSelected(int position) {
            PagerSlidingTabStrip.this.m10717b(position);
            C0597f fVar = PagerSlidingTabStrip.this.f10249g;
            if (fVar != null) {
                fVar.onPageSelected(position);
            }
        }
    }

    /* renamed from: com.astuetz.PagerSlidingTabStrip$d */
    private class C5891d extends DataSetObserver {

        /* renamed from: a */
        private boolean f10271a;

        private C5891d() {
            this.f10271a = false;
        }

        /* synthetic */ C5891d(PagerSlidingTabStrip x0, C5892a x1) {
            this();
        }

        public void onChanged() {
            PagerSlidingTabStrip.this.mo18372a();
        }

        /* renamed from: a */
        public void mo18420a(boolean attached) {
            this.f10271a = attached;
        }

        /* renamed from: a */
        public boolean mo18421a() {
            return this.f10271a;
        }
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        ColorStateList colorStateList = null;
        this.f10246d = new C5891d(this, null);
        this.f10247e = new C5890c(this, null);
        this.f10248f = null;
        this.f10252j = 0;
        this.f10253k = 0.0f;
        this.f10257o = 2;
        this.f10258p = 0;
        this.f10260r = 0;
        this.f10261s = 0;
        this.f10263u = 12;
        this.f10264v = 14;
        this.f10265w = null;
        this.f10266x = 0;
        this.f10267y = 0;
        this.f10268z = false;
        this.f10236B = false;
        this.f10237C = true;
        this.f10238D = null;
        this.f10239E = 1;
        this.f10241G = 0;
        this.f10242H = C5893a.psts_background_tab;
        this.f10243I = new C5897b(this);
        setFillViewport(true);
        setWillNotDraw(false);
        this.f10244b = new LinearLayout(context);
        this.f10244b.setOrientation(0);
        addView(this.f10244b);
        this.f10254l = new Paint();
        this.f10254l.setAntiAlias(true);
        this.f10254l.setStyle(Style.FILL);
        DisplayMetrics dm = getResources().getDisplayMetrics();
        this.f10240F = (int) TypedValue.applyDimension(1, (float) this.f10240F, dm);
        this.f10257o = (int) TypedValue.applyDimension(1, (float) this.f10257o, dm);
        this.f10258p = (int) TypedValue.applyDimension(1, (float) this.f10258p, dm);
        this.f10261s = (int) TypedValue.applyDimension(1, (float) this.f10261s, dm);
        this.f10263u = (int) TypedValue.applyDimension(1, (float) this.f10263u, dm);
        this.f10260r = (int) TypedValue.applyDimension(1, (float) this.f10260r, dm);
        this.f10264v = (int) TypedValue.applyDimension(2, (float) this.f10264v, dm);
        this.f10255m = new Paint();
        this.f10255m.setAntiAlias(true);
        this.f10255m.setStrokeWidth((float) this.f10260r);
        TypedArray a = context.obtainStyledAttributes(attrs, f10234a);
        int textPrimaryColor = a.getColor(0, getResources().getColor(17170444));
        this.f10259q = textPrimaryColor;
        this.f10262t = textPrimaryColor;
        this.f10256n = textPrimaryColor;
        int padding = a.getDimensionPixelSize(1, 0);
        this.f10266x = padding > 0 ? padding : a.getDimensionPixelSize(2, 0);
        this.f10267y = padding > 0 ? padding : a.getDimensionPixelSize(3, 0);
        a.recycle();
        String tabTextTypefaceName = "sans-serif";
        if (VERSION.SDK_INT >= 21) {
            tabTextTypefaceName = "sans-serif-medium";
            this.f10239E = 0;
        }
        TypedArray a2 = context.obtainStyledAttributes(attrs, C5896d.PagerSlidingTabStrip);
        this.f10256n = a2.getColor(C5896d.PagerSlidingTabStrip_pstsIndicatorColor, this.f10256n);
        this.f10257o = a2.getDimensionPixelSize(C5896d.PagerSlidingTabStrip_pstsIndicatorHeight, this.f10257o);
        this.f10259q = a2.getColor(C5896d.PagerSlidingTabStrip_pstsUnderlineColor, this.f10259q);
        this.f10258p = a2.getDimensionPixelSize(C5896d.PagerSlidingTabStrip_pstsUnderlineHeight, this.f10258p);
        this.f10262t = a2.getColor(C5896d.PagerSlidingTabStrip_pstsDividerColor, this.f10262t);
        this.f10260r = a2.getDimensionPixelSize(C5896d.PagerSlidingTabStrip_pstsDividerWidth, this.f10260r);
        this.f10261s = a2.getDimensionPixelSize(C5896d.PagerSlidingTabStrip_pstsDividerPadding, this.f10261s);
        this.f10268z = a2.getBoolean(C5896d.PagerSlidingTabStrip_pstsShouldExpand, this.f10268z);
        this.f10240F = a2.getDimensionPixelSize(C5896d.PagerSlidingTabStrip_pstsScrollOffset, this.f10240F);
        this.f10236B = a2.getBoolean(C5896d.PagerSlidingTabStrip_pstsPaddingMiddle, this.f10236B);
        this.f10263u = a2.getDimensionPixelSize(C5896d.PagerSlidingTabStrip_pstsTabPaddingLeftRight, this.f10263u);
        this.f10242H = a2.getResourceId(C5896d.PagerSlidingTabStrip_pstsTabBackground, this.f10242H);
        this.f10264v = a2.getDimensionPixelSize(C5896d.PagerSlidingTabStrip_pstsTabTextSize, this.f10264v);
        if (a2.hasValue(C5896d.PagerSlidingTabStrip_pstsTabTextColor)) {
            colorStateList = a2.getColorStateList(C5896d.PagerSlidingTabStrip_pstsTabTextColor);
        }
        this.f10265w = colorStateList;
        this.f10239E = a2.getInt(C5896d.PagerSlidingTabStrip_pstsTabTextStyle, this.f10239E);
        this.f10237C = a2.getBoolean(C5896d.PagerSlidingTabStrip_pstsTabTextAllCaps, this.f10237C);
        int tabTextAlpha = a2.getInt(C5896d.PagerSlidingTabStrip_pstsTabTextAlpha, 150);
        String fontFamily = a2.getString(C5896d.PagerSlidingTabStrip_pstsTabTextFontFamily);
        a2.recycle();
        if (this.f10265w == null) {
            this.f10265w = m10709a(textPrimaryColor, textPrimaryColor, Color.argb(tabTextAlpha, Color.red(textPrimaryColor), Color.green(textPrimaryColor), Color.blue(textPrimaryColor)));
        }
        if (fontFamily != null) {
            tabTextTypefaceName = fontFamily;
        }
        this.f10238D = Typeface.create(tabTextTypefaceName, this.f10239E);
        m10716b();
        this.f10245c = this.f10268z ? new LayoutParams(0, -1, 1.0f) : new LayoutParams(-2, -1);
    }

    /* renamed from: b */
    private void m10716b() {
        int bottomMargin = this.f10257o;
        int i = this.f10258p;
        if (bottomMargin < i) {
            bottomMargin = i;
        }
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), bottomMargin);
    }

    public void setViewPager(ViewPager pager) {
        this.f10250h = pager;
        if (pager.getAdapter() != null) {
            this.f10235A = pager.getAdapter() instanceof C5888a;
            pager.setOnPageChangeListener(this.f10247e);
            pager.getAdapter().registerDataSetObserver(this.f10246d);
            this.f10246d.mo18420a(true);
            mo18372a();
            return;
        }
        throw new IllegalStateException("ViewPager does not have adapter instance.");
    }

    /* renamed from: a */
    public void mo18372a() {
        View tabView;
        this.f10244b.removeAllViews();
        this.f10251i = this.f10250h.getAdapter().getCount();
        for (int i = 0; i < this.f10251i; i++) {
            if (this.f10235A) {
                tabView = ((C5888a) this.f10250h.getAdapter()).mo18416a(this, i);
            } else {
                tabView = LayoutInflater.from(getContext()).inflate(C5895c.psts_tab, this, false);
            }
            m10711a(i, this.f10250h.getAdapter().getPageTitle(i), tabView);
        }
        m10723c();
    }

    /* renamed from: a */
    private void m10711a(int position, CharSequence title, View tabView) {
        TextView textView = (TextView) tabView.findViewById(C5894b.psts_tab_title);
        if (!(textView == null || title == null)) {
            textView.setText(title);
        }
        tabView.setFocusable(true);
        tabView.setOnClickListener(new C5892a(this, position));
        this.f10244b.addView(tabView, position, this.f10245c);
    }

    /* renamed from: c */
    private void m10723c() {
        for (int i = 0; i < this.f10251i; i++) {
            View v = this.f10244b.getChildAt(i);
            v.setBackgroundResource(this.f10242H);
            v.setPadding(this.f10263u, v.getPaddingTop(), this.f10263u, v.getPaddingBottom());
            TextView tab_title = (TextView) v.findViewById(C5894b.psts_tab_title);
            if (tab_title != null) {
                tab_title.setTextColor(this.f10265w);
                tab_title.setTypeface(this.f10238D, this.f10239E);
                tab_title.setTextSize(0, (float) this.f10264v);
                if (this.f10237C) {
                    if (VERSION.SDK_INT >= 14) {
                        tab_title.setAllCaps(true);
                    } else {
                        tab_title.setText(tab_title.getText().toString().toUpperCase(getResources().getConfiguration().locale));
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10710a(int position, int offset) {
        if (this.f10251i != 0) {
            int newScrollX = this.f10244b.getChildAt(position).getLeft() + offset;
            if (position > 0 || offset > 0) {
                int newScrollX2 = newScrollX - this.f10240F;
                Pair<Float, Float> lines = getIndicatorCoordinates();
                newScrollX = (int) (((float) newScrollX2) + ((((Float) lines.f4070b).floatValue() - ((Float) lines.f4069a).floatValue()) / 2.0f));
            }
            if (newScrollX != this.f10241G) {
                this.f10241G = newScrollX;
                scrollTo(newScrollX, 0);
            }
        }
    }

    private C1268l<Float, Float> getIndicatorCoordinates() {
        View currentTab = this.f10244b.getChildAt(this.f10252j);
        float lineLeft = (float) currentTab.getLeft();
        float lineRight = (float) currentTab.getRight();
        if (this.f10253k > 0.0f) {
            int i = this.f10252j;
            if (i < this.f10251i - 1) {
                View nextTab = this.f10244b.getChildAt(i + 1);
                float nextTabLeft = (float) nextTab.getLeft();
                float nextTabRight = (float) nextTab.getRight();
                float f = this.f10253k;
                lineLeft = (f * nextTabLeft) + ((1.0f - f) * lineLeft);
                lineRight = (f * nextTabRight) + ((1.0f - f) * lineRight);
            }
        }
        return new C1268l<>(Float.valueOf(lineLeft), Float.valueOf(lineRight));
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int l, int t, int r, int b) {
        int width;
        if (this.f10236B || this.f10266x > 0 || this.f10267y > 0) {
            if (this.f10236B) {
                width = getWidth();
            } else {
                width = (getWidth() - this.f10266x) - this.f10267y;
            }
            this.f10244b.setMinimumWidth(width);
            setClipToPadding(false);
        }
        if (this.f10244b.getChildCount() > 0) {
            this.f10244b.getChildAt(0).getViewTreeObserver().addOnGlobalLayoutListener(this.f10243I);
        }
        super.onLayout(changed, l, t, r, b);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.f10251i != 0) {
            int height = getHeight();
            int i = this.f10260r;
            if (i > 0) {
                this.f10255m.setStrokeWidth((float) i);
                this.f10255m.setColor(this.f10262t);
                for (int i2 = 0; i2 < this.f10251i - 1; i2++) {
                    View tab = this.f10244b.getChildAt(i2);
                    canvas.drawLine((float) tab.getRight(), (float) this.f10261s, (float) tab.getRight(), (float) (height - this.f10261s), this.f10255m);
                }
            }
            if (this.f10258p > 0) {
                this.f10254l.setColor(this.f10259q);
                canvas.drawRect((float) this.f10266x, (float) (height - this.f10258p), (float) (this.f10244b.getWidth() + this.f10267y), (float) height, this.f10254l);
            }
            if (this.f10257o > 0) {
                this.f10254l.setColor(this.f10256n);
                Pair<Float, Float> lines = getIndicatorCoordinates();
                canvas.drawRect(((Float) lines.f4069a).floatValue() + ((float) this.f10266x), (float) (height - this.f10257o), ((Float) lines.f4070b).floatValue() + ((float) this.f10266x), (float) height, this.f10254l);
            }
        }
    }

    public void setOnTabReselectedListener(C5889b tabReselectedListener) {
        this.f10248f = tabReselectedListener;
    }

    public void setOnPageChangeListener(C0597f listener) {
        this.f10249g = listener;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m10717b(int position) {
        int i = 0;
        while (i < this.f10251i) {
            View tv = this.f10244b.getChildAt(i);
            if (i == position) {
                m10712a(tv);
            } else {
                m10718b(tv);
            }
            i++;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m10718b(View tab) {
        if (tab != null) {
            TextView tab_title = (TextView) tab.findViewById(C5894b.psts_tab_title);
            if (tab_title != null) {
                tab_title.setSelected(false);
            }
            if (this.f10235A) {
                ((C5888a) this.f10250h.getAdapter()).mo18417a(tab);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10712a(View tab) {
        if (tab != null) {
            TextView tab_title = (TextView) tab.findViewById(C5894b.psts_tab_title);
            if (tab_title != null) {
                tab_title.setSelected(true);
            }
            if (this.f10235A) {
                ((C5888a) this.f10250h.getAdapter()).mo18418b(tab);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f10250h != null && !this.f10246d.mo18421a()) {
            this.f10250h.getAdapter().registerDataSetObserver(this.f10246d);
            this.f10246d.mo18420a(true);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f10250h != null && this.f10246d.mo18421a()) {
            this.f10250h.getAdapter().unregisterDataSetObserver(this.f10246d);
            this.f10246d.mo18420a(false);
        }
    }

    public void onRestoreInstanceState(Parcelable state) {
        SavedState savedState = (SavedState) state;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f10252j = savedState.f10269a;
        if (this.f10252j != 0 && this.f10244b.getChildCount() > 0) {
            m10718b(this.f10244b.getChildAt(0));
            m10712a(this.f10244b.getChildAt(this.f10252j));
        }
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f10269a = this.f10252j;
        return savedState;
    }

    public int getIndicatorColor() {
        return this.f10256n;
    }

    public int getIndicatorHeight() {
        return this.f10257o;
    }

    public int getUnderlineColor() {
        return this.f10259q;
    }

    public int getDividerColor() {
        return this.f10262t;
    }

    public int getDividerWidth() {
        return this.f10260r;
    }

    public int getUnderlineHeight() {
        return this.f10258p;
    }

    public int getDividerPadding() {
        return this.f10261s;
    }

    public int getScrollOffset() {
        return this.f10240F;
    }

    public boolean getShouldExpand() {
        return this.f10268z;
    }

    public int getTextSize() {
        return this.f10264v;
    }

    public ColorStateList getTextColor() {
        return this.f10265w;
    }

    public int getTabBackground() {
        return this.f10242H;
    }

    public int getTabPaddingLeftRight() {
        return this.f10263u;
    }

    public void setIndicatorColor(int indicatorColor) {
        this.f10256n = indicatorColor;
        invalidate();
    }

    public void setIndicatorColorResource(int resId) {
        this.f10256n = getResources().getColor(resId);
        invalidate();
    }

    public void setIndicatorHeight(int indicatorLineHeightPx) {
        this.f10257o = indicatorLineHeightPx;
        invalidate();
    }

    public void setUnderlineColor(int underlineColor) {
        this.f10259q = underlineColor;
        invalidate();
    }

    public void setUnderlineColorResource(int resId) {
        this.f10259q = getResources().getColor(resId);
        invalidate();
    }

    public void setDividerColor(int dividerColor) {
        this.f10262t = dividerColor;
        invalidate();
    }

    public void setDividerColorResource(int resId) {
        this.f10262t = getResources().getColor(resId);
        invalidate();
    }

    public void setDividerWidth(int dividerWidthPx) {
        this.f10260r = dividerWidthPx;
        invalidate();
    }

    public void setUnderlineHeight(int underlineHeightPx) {
        this.f10258p = underlineHeightPx;
        invalidate();
    }

    public void setDividerPadding(int dividerPaddingPx) {
        this.f10261s = dividerPaddingPx;
        invalidate();
    }

    public void setScrollOffset(int scrollOffsetPx) {
        this.f10240F = scrollOffsetPx;
        invalidate();
    }

    public void setShouldExpand(boolean shouldExpand) {
        this.f10268z = shouldExpand;
        if (this.f10250h != null) {
            requestLayout();
        }
    }

    public void setAllCaps(boolean textAllCaps) {
        this.f10237C = textAllCaps;
    }

    public void setTextSize(int textSizePx) {
        this.f10264v = textSizePx;
        m10723c();
    }

    public void setTextColorResource(int resId) {
        setTextColor(getResources().getColor(resId));
    }

    public void setTextColor(int textColor) {
        setTextColor(m10708a(textColor));
    }

    public void setTextColorStateListResource(int resId) {
        setTextColor(getResources().getColorStateList(resId));
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f10265w = colorStateList;
        m10723c();
    }

    /* renamed from: a */
    private ColorStateList m10708a(int color_state_default) {
        return new ColorStateList(new int[][]{new int[0]}, new int[]{color_state_default});
    }

    /* renamed from: a */
    private ColorStateList m10709a(int color_state_pressed, int color_state_selected, int color_state_default) {
        return new ColorStateList(new int[][]{new int[]{16842919}, new int[]{16842913}, new int[0]}, new int[]{color_state_pressed, color_state_selected, color_state_default});
    }

    public void setTabBackground(int resId) {
        this.f10242H = resId;
    }

    public void setTabPaddingLeftRight(int paddingPx) {
        this.f10263u = paddingPx;
        m10723c();
    }
}
