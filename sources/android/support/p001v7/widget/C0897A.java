package android.support.p001v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.database.DataSetObserver;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.p000v4.view.C0645v;
import android.support.p000v4.view.C0646w;
import android.support.p001v7.appcompat.C0793R;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import p002b.p003c.p062h.p064b.p065a.C1282b;

/* renamed from: android.support.v7.widget.A */
/* compiled from: AppCompatSpinner */
public class C0897A extends Spinner implements C0645v {

    /* renamed from: a */
    private static final int[] f2797a = {16843505};

    /* renamed from: b */
    private final C1079l f2798b;

    /* renamed from: c */
    private final Context f2799c;

    /* renamed from: d */
    private C1080la f2800d;

    /* renamed from: e */
    private SpinnerAdapter f2801e;

    /* renamed from: f */
    private final boolean f2802f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public C0899b f2803g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f2804h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final Rect f2805i;

    /* renamed from: android.support.v7.widget.A$a */
    /* compiled from: AppCompatSpinner */
    private static class C0898a implements ListAdapter, SpinnerAdapter {

        /* renamed from: a */
        private SpinnerAdapter f2806a;

        /* renamed from: b */
        private ListAdapter f2807b;

        public C0898a(SpinnerAdapter adapter, Theme dropDownTheme) {
            this.f2806a = adapter;
            if (adapter instanceof ListAdapter) {
                this.f2807b = (ListAdapter) adapter;
            }
            if (dropDownTheme == null) {
                return;
            }
            if (VERSION.SDK_INT >= 23 && (adapter instanceof ThemedSpinnerAdapter)) {
                ThemedSpinnerAdapter themedAdapter = (ThemedSpinnerAdapter) adapter;
                if (themedAdapter.getDropDownViewTheme() != dropDownTheme) {
                    themedAdapter.setDropDownViewTheme(dropDownTheme);
                }
            } else if (adapter instanceof C1095ob) {
                C1095ob themedAdapter2 = (C1095ob) adapter;
                if (themedAdapter2.getDropDownViewTheme() == null) {
                    themedAdapter2.setDropDownViewTheme(dropDownTheme);
                }
            }
        }

        public int getCount() {
            SpinnerAdapter spinnerAdapter = this.f2806a;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        public Object getItem(int position) {
            SpinnerAdapter spinnerAdapter = this.f2806a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(position);
        }

        public long getItemId(int position) {
            SpinnerAdapter spinnerAdapter = this.f2806a;
            if (spinnerAdapter == null) {
                return -1;
            }
            return spinnerAdapter.getItemId(position);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            return getDropDownView(position, convertView, parent);
        }

        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            SpinnerAdapter spinnerAdapter = this.f2806a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(position, convertView, parent);
        }

        public boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.f2806a;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        public void registerDataSetObserver(DataSetObserver observer) {
            SpinnerAdapter spinnerAdapter = this.f2806a;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(observer);
            }
        }

        public void unregisterDataSetObserver(DataSetObserver observer) {
            SpinnerAdapter spinnerAdapter = this.f2806a;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(observer);
            }
        }

        public boolean areAllItemsEnabled() {
            ListAdapter adapter = this.f2807b;
            if (adapter != null) {
                return adapter.areAllItemsEnabled();
            }
            return true;
        }

        public boolean isEnabled(int position) {
            ListAdapter adapter = this.f2807b;
            if (adapter != null) {
                return adapter.isEnabled(position);
            }
            return true;
        }

        public int getItemViewType(int position) {
            return 0;
        }

        public int getViewTypeCount() {
            return 1;
        }

        public boolean isEmpty() {
            return getCount() == 0;
        }
    }

    /* renamed from: android.support.v7.widget.A$b */
    /* compiled from: AppCompatSpinner */
    private class C0899b extends C1120va {

        /* renamed from: K */
        private CharSequence f2808K;

        /* renamed from: L */
        ListAdapter f2809L;

        /* renamed from: M */
        private final Rect f2810M = new Rect();

        public C0899b(Context context, AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
            mo8687a((View) C0897A.this);
            mo8690a(true);
            mo8699f(0);
            mo8688a((OnItemClickListener) new C0915B(this, C0897A.this));
        }

        /* renamed from: a */
        public void mo6961a(ListAdapter adapter) {
            super.mo6961a(adapter);
            this.f2809L = adapter;
        }

        /* renamed from: l */
        public CharSequence mo6965l() {
            return this.f2808K;
        }

        /* renamed from: a */
        public void mo6962a(CharSequence hintText) {
            this.f2808K = hintText;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: k */
        public void mo6964k() {
            int hOffset;
            int i;
            Drawable background = mo8696e();
            int hOffset2 = 0;
            if (background != null) {
                background.getPadding(C0897A.this.f2805i);
                if (C0946Ib.m4565a(C0897A.this)) {
                    i = C0897A.this.f2805i.right;
                } else {
                    i = -C0897A.this.f2805i.left;
                }
                hOffset2 = i;
            } else {
                Rect b = C0897A.this.f2805i;
                C0897A.this.f2805i.right = 0;
                b.left = 0;
            }
            int spinnerPaddingLeft = C0897A.this.getPaddingLeft();
            int spinnerPaddingRight = C0897A.this.getPaddingRight();
            int spinnerWidth = C0897A.this.getWidth();
            if (C0897A.this.f2804h == -2) {
                int contentWidth = C0897A.this.mo6926a((SpinnerAdapter) this.f2809L, mo8696e());
                int contentWidthLimit = (C0897A.this.getContext().getResources().getDisplayMetrics().widthPixels - C0897A.this.f2805i.left) - C0897A.this.f2805i.right;
                if (contentWidth > contentWidthLimit) {
                    contentWidth = contentWidthLimit;
                }
                mo8692b(Math.max(contentWidth, (spinnerWidth - spinnerPaddingLeft) - spinnerPaddingRight));
            } else if (C0897A.this.f2804h == -1) {
                mo8692b((spinnerWidth - spinnerPaddingLeft) - spinnerPaddingRight);
            } else {
                mo8692b(C0897A.this.f2804h);
            }
            if (C0946Ib.m4565a(C0897A.this)) {
                hOffset = hOffset2 + ((spinnerWidth - spinnerPaddingRight) - mo8702h());
            } else {
                hOffset = hOffset2 + spinnerPaddingLeft;
            }
            mo8695d(hOffset);
        }

        public void show() {
            boolean wasShowing = mo6555c();
            mo6964k();
            mo8697e(2);
            super.show();
            mo6556d().setChoiceMode(1);
            mo8701g(C0897A.this.getSelectedItemPosition());
            if (!wasShowing) {
                ViewTreeObserver vto = C0897A.this.getViewTreeObserver();
                if (vto != null) {
                    OnGlobalLayoutListener layoutListener = new C0918C(this);
                    vto.addOnGlobalLayoutListener(layoutListener);
                    mo8689a((OnDismissListener) new C0922D(this, layoutListener));
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public boolean mo6963b(View view) {
            return C0646w.m2986t(view) && view.getGlobalVisibleRect(this.f2810M);
        }
    }

    public C0897A(Context context, AttributeSet attrs) {
        this(context, attrs, C0793R.attr.spinnerStyle);
    }

    public C0897A(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, -1);
    }

    public C0897A(Context context, AttributeSet attrs, int defStyleAttr, int mode) {
        this(context, attrs, defStyleAttr, mode, null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0059, code lost:
        if (r3 != null) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005b, code lost:
        r3.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x006a, code lost:
        if (r3 == null) goto L_0x0073;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C0897A(android.content.Context r9, android.util.AttributeSet r10, int r11, int r12, android.content.res.Resources.Theme r13) {
        /*
            r8 = this;
            r8.<init>(r9, r10, r11)
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r8.f2805i = r0
            int[] r0 = android.support.p001v7.appcompat.C0793R.styleable.Spinner
            r1 = 0
            android.support.v7.widget.sb r0 = android.support.p001v7.widget.C1112sb.m5456a(r9, r10, r0, r11, r1)
            android.support.v7.widget.l r2 = new android.support.v7.widget.l
            r2.<init>(r8)
            r8.f2798b = r2
            r2 = 0
            if (r13 == 0) goto L_0x0023
            b.c.h.g.d r3 = new b.c.h.g.d
            r3.<init>(r9, r13)
            r8.f2799c = r3
            goto L_0x003e
        L_0x0023:
            int r3 = android.support.p001v7.appcompat.C0793R.styleable.Spinner_popupTheme
            int r3 = r0.mo8659g(r3, r1)
            if (r3 == 0) goto L_0x0033
            b.c.h.g.d r4 = new b.c.h.g.d
            r4.<init>(r9, r3)
            r8.f2799c = r4
            goto L_0x003e
        L_0x0033:
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 23
            if (r4 >= r5) goto L_0x003b
            r4 = r9
            goto L_0x003c
        L_0x003b:
            r4 = r2
        L_0x003c:
            r8.f2799c = r4
        L_0x003e:
            android.content.Context r3 = r8.f2799c
            r4 = 1
            if (r3 == 0) goto L_0x00ab
            r3 = -1
            if (r12 != r3) goto L_0x0073
            r3 = 0
            int[] r5 = f2797a     // Catch:{ Exception -> 0x0061 }
            android.content.res.TypedArray r5 = r9.obtainStyledAttributes(r10, r5, r11, r1)     // Catch:{ Exception -> 0x0061 }
            r3 = r5
            boolean r5 = r3.hasValue(r1)     // Catch:{ Exception -> 0x0061 }
            if (r5 == 0) goto L_0x0059
            int r5 = r3.getInt(r1, r1)     // Catch:{ Exception -> 0x0061 }
            r12 = r5
        L_0x0059:
            if (r3 == 0) goto L_0x0073
        L_0x005b:
            r3.recycle()
            goto L_0x0073
        L_0x005f:
            r1 = move-exception
            goto L_0x006d
        L_0x0061:
            r5 = move-exception
            java.lang.String r6 = "AppCompatSpinner"
            java.lang.String r7 = "Could not read android:spinnerMode"
            android.util.Log.i(r6, r7, r5)     // Catch:{ all -> 0x005f }
            if (r3 == 0) goto L_0x0073
            goto L_0x005b
        L_0x006d:
            if (r3 == 0) goto L_0x0072
            r3.recycle()
        L_0x0072:
            throw r1
        L_0x0073:
            if (r12 != r4) goto L_0x00ab
            android.support.v7.widget.A$b r3 = new android.support.v7.widget.A$b
            android.content.Context r5 = r8.f2799c
            r3.<init>(r5, r10, r11)
            android.content.Context r5 = r8.f2799c
            int[] r6 = android.support.p001v7.appcompat.C0793R.styleable.Spinner
            android.support.v7.widget.sb r1 = android.support.p001v7.widget.C1112sb.m5456a(r5, r10, r6, r11, r1)
            int r5 = android.support.p001v7.appcompat.C0793R.styleable.Spinner_android_dropDownWidth
            r6 = -2
            int r5 = r1.mo8657f(r5, r6)
            r8.f2804h = r5
            int r5 = android.support.p001v7.appcompat.C0793R.styleable.Spinner_android_popupBackground
            android.graphics.drawable.Drawable r5 = r1.mo8650b(r5)
            r3.mo8686a(r5)
            int r5 = android.support.p001v7.appcompat.C0793R.styleable.Spinner_android_prompt
            java.lang.String r5 = r0.mo8654d(r5)
            r3.mo6962a(r5)
            r1.mo8647a()
            r8.f2803g = r3
            android.support.v7.widget.z r5 = new android.support.v7.widget.z
            r5.<init>(r8, r8, r3)
            r8.f2800d = r5
        L_0x00ab:
            int r1 = android.support.p001v7.appcompat.C0793R.styleable.Spinner_android_entries
            java.lang.CharSequence[] r1 = r0.mo8658f(r1)
            if (r1 == 0) goto L_0x00c3
            android.widget.ArrayAdapter r3 = new android.widget.ArrayAdapter
            r5 = 17367048(0x1090008, float:2.5162948E-38)
            r3.<init>(r9, r5, r1)
            int r5 = android.support.p001v7.appcompat.C0793R.layout.support_simple_spinner_dropdown_item
            r3.setDropDownViewResource(r5)
            r8.setAdapter(r3)
        L_0x00c3:
            r0.mo8647a()
            r8.f2802f = r4
            android.widget.SpinnerAdapter r3 = r8.f2801e
            if (r3 == 0) goto L_0x00d1
            r8.setAdapter(r3)
            r8.f2801e = r2
        L_0x00d1:
            android.support.v7.widget.l r2 = r8.f2798b
            r2.mo8511a(r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p001v7.widget.C0897A.<init>(android.content.Context, android.util.AttributeSet, int, int, android.content.res.Resources$Theme):void");
    }

    public Context getPopupContext() {
        if (this.f2803g != null) {
            return this.f2799c;
        }
        if (VERSION.SDK_INT >= 23) {
            return super.getPopupContext();
        }
        return null;
    }

    public void setPopupBackgroundDrawable(Drawable background) {
        C0899b bVar = this.f2803g;
        if (bVar != null) {
            bVar.mo8686a(background);
        } else if (VERSION.SDK_INT >= 16) {
            super.setPopupBackgroundDrawable(background);
        }
    }

    public void setPopupBackgroundResource(int resId) {
        setPopupBackgroundDrawable(C1282b.m6000b(getPopupContext(), resId));
    }

    public Drawable getPopupBackground() {
        C0899b bVar = this.f2803g;
        if (bVar != null) {
            return bVar.mo8696e();
        }
        if (VERSION.SDK_INT >= 16) {
            return super.getPopupBackground();
        }
        return null;
    }

    public void setDropDownVerticalOffset(int pixels) {
        C0899b bVar = this.f2803g;
        if (bVar != null) {
            bVar.mo8703h(pixels);
        } else if (VERSION.SDK_INT >= 16) {
            super.setDropDownVerticalOffset(pixels);
        }
    }

    public int getDropDownVerticalOffset() {
        C0899b bVar = this.f2803g;
        if (bVar != null) {
            return bVar.mo8700g();
        }
        if (VERSION.SDK_INT >= 16) {
            return super.getDropDownVerticalOffset();
        }
        return 0;
    }

    public void setDropDownHorizontalOffset(int pixels) {
        C0899b bVar = this.f2803g;
        if (bVar != null) {
            bVar.mo8695d(pixels);
        } else if (VERSION.SDK_INT >= 16) {
            super.setDropDownHorizontalOffset(pixels);
        }
    }

    public int getDropDownHorizontalOffset() {
        C0899b bVar = this.f2803g;
        if (bVar != null) {
            return bVar.mo8698f();
        }
        if (VERSION.SDK_INT >= 16) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }

    public void setDropDownWidth(int pixels) {
        if (this.f2803g != null) {
            this.f2804h = pixels;
        } else if (VERSION.SDK_INT >= 16) {
            super.setDropDownWidth(pixels);
        }
    }

    public int getDropDownWidth() {
        if (this.f2803g != null) {
            return this.f2804h;
        }
        if (VERSION.SDK_INT >= 16) {
            return super.getDropDownWidth();
        }
        return 0;
    }

    public void setAdapter(SpinnerAdapter adapter) {
        if (!this.f2802f) {
            this.f2801e = adapter;
            return;
        }
        super.setAdapter(adapter);
        if (this.f2803g != null) {
            Context popupContext = this.f2799c;
            if (popupContext == null) {
                popupContext = getContext();
            }
            this.f2803g.mo6961a((ListAdapter) new C0898a(adapter, popupContext.getTheme()));
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C0899b bVar = this.f2803g;
        if (bVar != null && bVar.mo6555c()) {
            this.f2803g.dismiss();
        }
    }

    public boolean onTouchEvent(MotionEvent event) {
        C1080la laVar = this.f2800d;
        if (laVar == null || !laVar.onTouch(this, event)) {
            return super.onTouchEvent(event);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (this.f2803g != null && MeasureSpec.getMode(widthMeasureSpec) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), mo6926a(getAdapter(), getBackground())), MeasureSpec.getSize(widthMeasureSpec)), getMeasuredHeight());
        }
    }

    public boolean performClick() {
        C0899b bVar = this.f2803g;
        if (bVar == null) {
            return super.performClick();
        }
        if (!bVar.mo6555c()) {
            this.f2803g.show();
        }
        return true;
    }

    public void setPrompt(CharSequence prompt) {
        C0899b bVar = this.f2803g;
        if (bVar != null) {
            bVar.mo6962a(prompt);
        } else {
            super.setPrompt(prompt);
        }
    }

    public CharSequence getPrompt() {
        C0899b bVar = this.f2803g;
        return bVar != null ? bVar.mo6965l() : super.getPrompt();
    }

    public void setBackgroundResource(int resId) {
        super.setBackgroundResource(resId);
        C1079l lVar = this.f2798b;
        if (lVar != null) {
            lVar.mo8507a(resId);
        }
    }

    public void setBackgroundDrawable(Drawable background) {
        super.setBackgroundDrawable(background);
        C1079l lVar = this.f2798b;
        if (lVar != null) {
            lVar.mo8510a(background);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList tint) {
        C1079l lVar = this.f2798b;
        if (lVar != null) {
            lVar.mo8513b(tint);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C1079l lVar = this.f2798b;
        if (lVar != null) {
            return lVar.mo8512b();
        }
        return null;
    }

    public void setSupportBackgroundTintMode(Mode tintMode) {
        C1079l lVar = this.f2798b;
        if (lVar != null) {
            lVar.mo8509a(tintMode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        C1079l lVar = this.f2798b;
        if (lVar != null) {
            return lVar.mo8514c();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C1079l lVar = this.f2798b;
        if (lVar != null) {
            lVar.mo8506a();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public int mo6926a(SpinnerAdapter adapter, Drawable background) {
        if (adapter == null) {
            return 0;
        }
        int width = 0;
        View itemView = null;
        int itemType = 0;
        int widthMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int heightMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int start = Math.max(0, getSelectedItemPosition());
        int end = Math.min(adapter.getCount(), start + 15);
        for (int i = Math.max(0, start - (15 - (end - start))); i < end; i++) {
            int positionType = adapter.getItemViewType(i);
            if (positionType != itemType) {
                itemType = positionType;
                itemView = null;
            }
            itemView = adapter.getView(i, itemView, this);
            if (itemView.getLayoutParams() == null) {
                itemView.setLayoutParams(new LayoutParams(-2, -2));
            }
            itemView.measure(widthMeasureSpec, heightMeasureSpec);
            width = Math.max(width, itemView.getMeasuredWidth());
        }
        if (background != null) {
            background.getPadding(this.f2805i);
            Rect rect = this.f2805i;
            width += rect.left + rect.right;
        }
        return width;
    }
}
