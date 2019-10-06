package android.support.p001v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.p000v4.view.C0646w;
import android.support.p000v4.widget.C0716r;
import android.support.p001v7.appcompat.C0793R;
import android.support.p001v7.view.menu.C0896z;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.lang.reflect.Method;

/* renamed from: android.support.v7.widget.va */
/* compiled from: ListPopupWindow */
public class C1120va implements C0896z {

    /* renamed from: a */
    private static Method f3707a;

    /* renamed from: b */
    private static Method f3708b;

    /* renamed from: c */
    private static Method f3709c;

    /* renamed from: A */
    final C1125e f3710A;

    /* renamed from: B */
    private final C1124d f3711B;

    /* renamed from: C */
    private final C1123c f3712C;

    /* renamed from: D */
    private final C1121a f3713D;

    /* renamed from: E */
    private Runnable f3714E;

    /* renamed from: F */
    final Handler f3715F;

    /* renamed from: G */
    private final Rect f3716G;

    /* renamed from: H */
    private Rect f3717H;

    /* renamed from: I */
    private boolean f3718I;

    /* renamed from: J */
    PopupWindow f3719J;

    /* renamed from: d */
    private Context f3720d;

    /* renamed from: e */
    private ListAdapter f3721e;

    /* renamed from: f */
    C1058ga f3722f;

    /* renamed from: g */
    private int f3723g;

    /* renamed from: h */
    private int f3724h;

    /* renamed from: i */
    private int f3725i;

    /* renamed from: j */
    private int f3726j;

    /* renamed from: k */
    private int f3727k;

    /* renamed from: l */
    private boolean f3728l;

    /* renamed from: m */
    private boolean f3729m;

    /* renamed from: n */
    private boolean f3730n;

    /* renamed from: o */
    private boolean f3731o;

    /* renamed from: p */
    private int f3732p;

    /* renamed from: q */
    private boolean f3733q;

    /* renamed from: r */
    private boolean f3734r;

    /* renamed from: s */
    int f3735s;

    /* renamed from: t */
    private View f3736t;

    /* renamed from: u */
    private int f3737u;

    /* renamed from: v */
    private DataSetObserver f3738v;

    /* renamed from: w */
    private View f3739w;

    /* renamed from: x */
    private Drawable f3740x;

    /* renamed from: y */
    private OnItemClickListener f3741y;

    /* renamed from: z */
    private OnItemSelectedListener f3742z;

    /* renamed from: android.support.v7.widget.va$a */
    /* compiled from: ListPopupWindow */
    private class C1121a implements Runnable {
        C1121a() {
        }

        public void run() {
            C1120va.this.mo8683a();
        }
    }

    /* renamed from: android.support.v7.widget.va$b */
    /* compiled from: ListPopupWindow */
    private class C1122b extends DataSetObserver {
        C1122b() {
        }

        public void onChanged() {
            if (C1120va.this.mo6555c()) {
                C1120va.this.show();
            }
        }

        public void onInvalidated() {
            C1120va.this.dismiss();
        }
    }

    /* renamed from: android.support.v7.widget.va$c */
    /* compiled from: ListPopupWindow */
    private class C1123c implements OnScrollListener {
        C1123c() {
        }

        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        }

        public void onScrollStateChanged(AbsListView view, int scrollState) {
            if (scrollState == 1 && !C1120va.this.mo8705i() && C1120va.this.f3719J.getContentView() != null) {
                C1120va vaVar = C1120va.this;
                vaVar.f3715F.removeCallbacks(vaVar.f3710A);
                C1120va.this.f3710A.run();
            }
        }
    }

    /* renamed from: android.support.v7.widget.va$d */
    /* compiled from: ListPopupWindow */
    private class C1124d implements OnTouchListener {
        C1124d() {
        }

        public boolean onTouch(View v, MotionEvent event) {
            int action = event.getAction();
            int x = (int) event.getX();
            int y = (int) event.getY();
            if (action == 0) {
                PopupWindow popupWindow = C1120va.this.f3719J;
                if (popupWindow != null && popupWindow.isShowing() && x >= 0 && x < C1120va.this.f3719J.getWidth() && y >= 0 && y < C1120va.this.f3719J.getHeight()) {
                    C1120va vaVar = C1120va.this;
                    vaVar.f3715F.postDelayed(vaVar.f3710A, 250);
                    return false;
                }
            }
            if (action == 1) {
                C1120va vaVar2 = C1120va.this;
                vaVar2.f3715F.removeCallbacks(vaVar2.f3710A);
            }
            return false;
        }
    }

    /* renamed from: android.support.v7.widget.va$e */
    /* compiled from: ListPopupWindow */
    private class C1125e implements Runnable {
        C1125e() {
        }

        public void run() {
            C1058ga gaVar = C1120va.this.f3722f;
            if (gaVar != null && C0646w.m2986t(gaVar) && C1120va.this.f3722f.getCount() > C1120va.this.f3722f.getChildCount()) {
                int childCount = C1120va.this.f3722f.getChildCount();
                C1120va vaVar = C1120va.this;
                if (childCount <= vaVar.f3735s) {
                    vaVar.f3719J.setInputMethodMode(2);
                    C1120va.this.show();
                }
            }
        }
    }

    static {
        String str = "ListPopupWindow";
        try {
            f3707a = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", new Class[]{Boolean.TYPE});
        } catch (NoSuchMethodException e) {
            Log.i(str, "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
        }
        try {
            f3708b = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", new Class[]{View.class, Integer.TYPE, Boolean.TYPE});
        } catch (NoSuchMethodException e2) {
            Log.i(str, "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
        }
        try {
            f3709c = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", new Class[]{Rect.class});
        } catch (NoSuchMethodException e3) {
            Log.i(str, "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
        }
    }

    public C1120va(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public C1120va(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        this.f3723g = -2;
        this.f3724h = -2;
        this.f3727k = 1002;
        this.f3729m = true;
        this.f3732p = 0;
        this.f3733q = false;
        this.f3734r = false;
        this.f3735s = MoPubClientPositioning.NO_REPEAT;
        this.f3737u = 0;
        this.f3710A = new C1125e();
        this.f3711B = new C1124d();
        this.f3712C = new C1123c();
        this.f3713D = new C1121a();
        this.f3716G = new Rect();
        this.f3720d = context;
        this.f3715F = new Handler(context.getMainLooper());
        TypedArray a = context.obtainStyledAttributes(attrs, C0793R.styleable.ListPopupWindow, defStyleAttr, defStyleRes);
        this.f3725i = a.getDimensionPixelOffset(C0793R.styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.f3726j = a.getDimensionPixelOffset(C0793R.styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.f3726j != 0) {
            this.f3728l = true;
        }
        a.recycle();
        this.f3719J = new C1119v(context, attrs, defStyleAttr, defStyleRes);
        this.f3719J.setInputMethodMode(1);
    }

    /* renamed from: a */
    public void mo6961a(ListAdapter adapter) {
        DataSetObserver dataSetObserver = this.f3738v;
        if (dataSetObserver == null) {
            this.f3738v = new C1122b();
        } else {
            ListAdapter listAdapter = this.f3721e;
            if (listAdapter != null) {
                listAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f3721e = adapter;
        if (adapter != null) {
            adapter.registerDataSetObserver(this.f3738v);
        }
        C1058ga gaVar = this.f3722f;
        if (gaVar != null) {
            gaVar.setAdapter(this.f3721e);
        }
    }

    /* renamed from: f */
    public void mo8699f(int position) {
        this.f3737u = position;
    }

    /* renamed from: a */
    public void mo8690a(boolean modal) {
        this.f3718I = modal;
        this.f3719J.setFocusable(modal);
    }

    /* renamed from: j */
    public boolean mo8706j() {
        return this.f3718I;
    }

    /* renamed from: e */
    public Drawable mo8696e() {
        return this.f3719J.getBackground();
    }

    /* renamed from: a */
    public void mo8686a(Drawable d) {
        this.f3719J.setBackgroundDrawable(d);
    }

    /* renamed from: a */
    public void mo8684a(int animationStyle) {
        this.f3719J.setAnimationStyle(animationStyle);
    }

    /* renamed from: b */
    public View mo8691b() {
        return this.f3739w;
    }

    /* renamed from: a */
    public void mo8687a(View anchor) {
        this.f3739w = anchor;
    }

    /* renamed from: f */
    public int mo8698f() {
        return this.f3725i;
    }

    /* renamed from: d */
    public void mo8695d(int offset) {
        this.f3725i = offset;
    }

    /* renamed from: g */
    public int mo8700g() {
        if (!this.f3728l) {
            return 0;
        }
        return this.f3726j;
    }

    /* renamed from: h */
    public void mo8703h(int offset) {
        this.f3726j = offset;
        this.f3728l = true;
    }

    /* renamed from: a */
    public void mo8685a(Rect bounds) {
        this.f3717H = bounds;
    }

    /* renamed from: c */
    public void mo8694c(int gravity) {
        this.f3732p = gravity;
    }

    /* renamed from: h */
    public int mo8702h() {
        return this.f3724h;
    }

    /* renamed from: i */
    public void mo8704i(int width) {
        this.f3724h = width;
    }

    /* renamed from: b */
    public void mo8692b(int width) {
        Drawable popupBackground = this.f3719J.getBackground();
        if (popupBackground != null) {
            popupBackground.getPadding(this.f3716G);
            Rect rect = this.f3716G;
            this.f3724h = rect.left + rect.right + width;
            return;
        }
        mo8704i(width);
    }

    /* renamed from: a */
    public void mo8688a(OnItemClickListener clickListener) {
        this.f3741y = clickListener;
    }

    public void show() {
        int widthSpec;
        int heightSpec;
        int widthSpec2;
        int heightSpec2;
        int height = mo6964k();
        boolean noInputMethod = mo8705i();
        C0716r.m3354a(this.f3719J, this.f3727k);
        boolean z = true;
        if (!this.f3719J.isShowing()) {
            int widthSpec3 = this.f3724h;
            if (widthSpec3 == -1) {
                widthSpec = -1;
            } else if (widthSpec3 == -2) {
                widthSpec = mo8691b().getWidth();
            } else {
                widthSpec = this.f3724h;
            }
            int i = this.f3723g;
            if (i == -1) {
                heightSpec = -1;
            } else if (i == -2) {
                heightSpec = height;
            } else {
                heightSpec = this.f3723g;
            }
            this.f3719J.setWidth(widthSpec);
            this.f3719J.setHeight(heightSpec);
            mo8726c(true);
            this.f3719J.setOutsideTouchable(!this.f3734r && !this.f3733q);
            this.f3719J.setTouchInterceptor(this.f3711B);
            if (this.f3731o) {
                C0716r.m3356a(this.f3719J, this.f3730n);
            }
            Method method = f3709c;
            if (method != null) {
                try {
                    method.invoke(this.f3719J, new Object[]{this.f3717H});
                } catch (Exception e) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e);
                }
            }
            C0716r.m3355a(this.f3719J, mo8691b(), this.f3725i, this.f3726j, this.f3732p);
            this.f3722f.setSelection(-1);
            if (!this.f3718I || this.f3722f.isInTouchMode()) {
                mo8683a();
            }
            if (!this.f3718I) {
                this.f3715F.post(this.f3713D);
            }
        } else if (C0646w.m2986t(mo8691b())) {
            int widthSpec4 = this.f3724h;
            if (widthSpec4 == -1) {
                widthSpec2 = -1;
            } else if (widthSpec4 == -2) {
                widthSpec2 = mo8691b().getWidth();
            } else {
                widthSpec2 = this.f3724h;
            }
            int i2 = this.f3723g;
            if (i2 == -1) {
                heightSpec2 = noInputMethod ? height : -1;
                if (noInputMethod) {
                    this.f3719J.setWidth(this.f3724h == -1 ? -1 : 0);
                    this.f3719J.setHeight(0);
                } else {
                    this.f3719J.setWidth(this.f3724h == -1 ? -1 : 0);
                    this.f3719J.setHeight(-1);
                }
            } else {
                heightSpec2 = i2 == -2 ? height : this.f3723g;
            }
            PopupWindow popupWindow = this.f3719J;
            if (this.f3734r || this.f3733q) {
                z = false;
            }
            popupWindow.setOutsideTouchable(z);
            this.f3719J.update(mo8691b(), this.f3725i, this.f3726j, widthSpec2 < 0 ? -1 : widthSpec2, heightSpec2 < 0 ? -1 : heightSpec2);
        }
    }

    public void dismiss() {
        this.f3719J.dismiss();
        mo6965l();
        this.f3719J.setContentView(null);
        this.f3722f = null;
        this.f3715F.removeCallbacks(this.f3710A);
    }

    /* renamed from: a */
    public void mo8689a(OnDismissListener listener) {
        this.f3719J.setOnDismissListener(listener);
    }

    /* renamed from: l */
    private void mo6965l() {
        View view = this.f3736t;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f3736t);
            }
        }
    }

    /* renamed from: e */
    public void mo8697e(int mode) {
        this.f3719J.setInputMethodMode(mode);
    }

    /* renamed from: g */
    public void mo8701g(int position) {
        C1058ga list = this.f3722f;
        if (mo6555c() && list != null) {
            list.setListSelectionHidden(false);
            list.setSelection(position);
            if (list.getChoiceMode() != 0) {
                list.setItemChecked(position, true);
            }
        }
    }

    /* renamed from: a */
    public void mo8683a() {
        C1058ga list = this.f3722f;
        if (list != null) {
            list.setListSelectionHidden(true);
            list.requestLayout();
        }
    }

    /* renamed from: c */
    public boolean mo6555c() {
        return this.f3719J.isShowing();
    }

    /* renamed from: i */
    public boolean mo8705i() {
        return this.f3719J.getInputMethodMode() == 2;
    }

    /* renamed from: d */
    public ListView mo6556d() {
        return this.f3722f;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C1058ga mo8682a(Context context, boolean hijackFocus) {
        return new C1058ga(context, hijackFocus);
    }

    /* renamed from: k */
    private int mo6964k() {
        int padding;
        int childWidthSpec;
        int widthSize;
        int widthMode;
        int otherHeights = 0;
        boolean ignoreBottomDecorations = false;
        if (this.f3722f == null) {
            Context context = this.f3720d;
            this.f3714E = new C1114ta(this);
            this.f3722f = mo8682a(context, !this.f3718I);
            Drawable drawable = this.f3740x;
            if (drawable != null) {
                this.f3722f.setSelector(drawable);
            }
            this.f3722f.setAdapter(this.f3721e);
            this.f3722f.setOnItemClickListener(this.f3741y);
            this.f3722f.setFocusable(true);
            this.f3722f.setFocusableInTouchMode(true);
            this.f3722f.setOnItemSelectedListener(new C1117ua(this));
            this.f3722f.setOnScrollListener(this.f3712C);
            OnItemSelectedListener onItemSelectedListener = this.f3742z;
            if (onItemSelectedListener != null) {
                this.f3722f.setOnItemSelectedListener(onItemSelectedListener);
            }
            View view = this.f3722f;
            View hintView = this.f3736t;
            if (hintView != null) {
                LinearLayout hintContainer = new LinearLayout(context);
                hintContainer.setOrientation(1);
                LayoutParams hintParams = new LayoutParams(-1, 0, 1.0f);
                int i = this.f3737u;
                if (i == 0) {
                    hintContainer.addView(hintView);
                    hintContainer.addView(view, hintParams);
                } else if (i != 1) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Invalid hint position ");
                    sb.append(this.f3737u);
                    Log.e("ListPopupWindow", sb.toString());
                } else {
                    hintContainer.addView(view, hintParams);
                    hintContainer.addView(hintView);
                }
                if (this.f3724h >= 0) {
                    widthMode = LinearLayoutManager.INVALID_OFFSET;
                    widthSize = this.f3724h;
                } else {
                    widthMode = 0;
                    widthSize = 0;
                }
                hintView.measure(MeasureSpec.makeMeasureSpec(widthSize, widthMode), 0);
                LayoutParams hintParams2 = (LayoutParams) hintView.getLayoutParams();
                view = hintContainer;
                otherHeights = hintView.getMeasuredHeight() + hintParams2.topMargin + hintParams2.bottomMargin;
            }
            this.f3719J.setContentView(view);
        } else {
            ViewGroup viewGroup = (ViewGroup) this.f3719J.getContentView();
            View view2 = this.f3736t;
            if (view2 != null) {
                LayoutParams hintParams3 = (LayoutParams) view2.getLayoutParams();
                otherHeights = view2.getMeasuredHeight() + hintParams3.topMargin + hintParams3.bottomMargin;
            }
        }
        Drawable background = this.f3719J.getBackground();
        if (background != null) {
            background.getPadding(this.f3716G);
            Rect rect = this.f3716G;
            int i2 = rect.top;
            padding = rect.bottom + i2;
            if (!this.f3728l) {
                this.f3726j = -i2;
            }
        } else {
            this.f3716G.setEmpty();
            padding = 0;
        }
        if (this.f3719J.getInputMethodMode() == 2) {
            ignoreBottomDecorations = true;
        }
        int maxHeight = m5487a(mo8691b(), this.f3726j, ignoreBottomDecorations);
        if (this.f3733q || this.f3723g == -1) {
            return maxHeight + padding;
        }
        int i3 = this.f3724h;
        if (i3 == -2) {
            int i4 = this.f3720d.getResources().getDisplayMetrics().widthPixels;
            Rect rect2 = this.f3716G;
            childWidthSpec = MeasureSpec.makeMeasureSpec(i4 - (rect2.left + rect2.right), LinearLayoutManager.INVALID_OFFSET);
        } else if (i3 != -1) {
            childWidthSpec = MeasureSpec.makeMeasureSpec(i3, 1073741824);
        } else {
            int i5 = this.f3720d.getResources().getDisplayMetrics().widthPixels;
            Rect rect3 = this.f3716G;
            childWidthSpec = MeasureSpec.makeMeasureSpec(i5 - (rect3.left + rect3.right), 1073741824);
        }
        int listContent = this.f3722f.mo8431a(childWidthSpec, 0, -1, maxHeight - otherHeights, -1);
        if (listContent > 0) {
            otherHeights += padding + this.f3722f.getPaddingTop() + this.f3722f.getPaddingBottom();
        }
        return listContent + otherHeights;
    }

    /* renamed from: b */
    public void mo8693b(boolean overlapAnchor) {
        this.f3731o = true;
        this.f3730n = overlapAnchor;
    }

    /* renamed from: c */
    private void mo8726c(boolean clip) {
        Method method = f3707a;
        if (method != null) {
            try {
                method.invoke(this.f3719J, new Object[]{Boolean.valueOf(clip)});
            } catch (Exception e) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    /* renamed from: a */
    private int m5487a(View anchor, int yOffset, boolean ignoreBottomDecorations) {
        Method method = f3708b;
        if (method != null) {
            try {
                return ((Integer) method.invoke(this.f3719J, new Object[]{anchor, Integer.valueOf(yOffset), Boolean.valueOf(ignoreBottomDecorations)})).intValue();
            } catch (Exception e) {
                Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.f3719J.getMaxAvailableHeight(anchor, yOffset);
    }
}
