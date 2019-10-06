package android.support.p000v4.view;

import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: android.support.v4.view.w */
/* compiled from: ViewCompat */
public class C0646w {

    /* renamed from: a */
    static final C0656j f1861a;

    /* renamed from: android.support.v4.view.w$a */
    /* compiled from: ViewCompat */
    static class C0647a extends C0656j {
        C0647a() {
        }

        /* renamed from: s */
        public boolean mo5706s(View view) {
            return view.hasOnClickListeners();
        }
    }

    /* renamed from: android.support.v4.view.w$b */
    /* compiled from: ViewCompat */
    static class C0648b extends C0647a {
        C0648b() {
        }

        /* renamed from: u */
        public boolean mo5718u(View view) {
            return view.hasTransientState();
        }

        /* renamed from: a */
        public void mo5711a(View view, boolean hasTransientState) {
            view.setHasTransientState(hasTransientState);
        }

        /* renamed from: z */
        public void mo5719z(View view) {
            view.postInvalidateOnAnimation();
        }

        /* renamed from: a */
        public void mo5709a(View view, Runnable action) {
            view.postOnAnimation(action);
        }

        /* renamed from: a */
        public void mo5710a(View view, Runnable action, long delayMillis) {
            view.postOnAnimationDelayed(action, delayMillis);
        }

        /* renamed from: h */
        public int mo5714h(View view) {
            return view.getImportantForAccessibility();
        }

        /* renamed from: d */
        public void mo5712d(View view, int mode) {
            if (mode == 4) {
                mode = 2;
            }
            view.setImportantForAccessibility(mode);
        }

        /* renamed from: k */
        public int mo5716k(View view) {
            return view.getMinimumWidth();
        }

        /* renamed from: j */
        public int mo5715j(View view) {
            return view.getMinimumHeight();
        }

        /* renamed from: A */
        public void mo5707A(View view) {
            view.requestFitSystemWindows();
        }

        /* renamed from: g */
        public boolean mo5713g(View view) {
            return view.getFitsSystemWindows();
        }

        /* renamed from: t */
        public boolean mo5717t(View view) {
            return view.hasOverlappingRendering();
        }

        /* renamed from: a */
        public void mo5708a(View view, Drawable background) {
            view.setBackground(background);
        }
    }

    /* renamed from: android.support.v4.view.w$c */
    /* compiled from: ViewCompat */
    static class C0649c extends C0648b {
        C0649c() {
        }

        /* renamed from: i */
        public int mo5722i(View view) {
            return view.getLayoutDirection();
        }

        /* renamed from: m */
        public int mo5724m(View view) {
            return view.getPaddingStart();
        }

        /* renamed from: l */
        public int mo5723l(View view) {
            return view.getPaddingEnd();
        }

        /* renamed from: a */
        public void mo5720a(View view, int start, int top, int end, int bottom) {
            view.setPaddingRelative(start, top, end, bottom);
        }

        /* renamed from: p */
        public int mo5725p(View view) {
            return view.getWindowSystemUiVisibility();
        }

        /* renamed from: y */
        public boolean mo5726y(View view) {
            return view.isPaddingRelative();
        }

        /* renamed from: e */
        public Display mo5721e(View view) {
            return view.getDisplay();
        }
    }

    /* renamed from: android.support.v4.view.w$d */
    /* compiled from: ViewCompat */
    static class C0650d extends C0649c {
        C0650d() {
        }

        /* renamed from: a */
        public void mo5727a(View view, Rect clipBounds) {
            view.setClipBounds(clipBounds);
        }

        /* renamed from: d */
        public Rect mo5728d(View view) {
            return view.getClipBounds();
        }
    }

    /* renamed from: android.support.v4.view.w$e */
    /* compiled from: ViewCompat */
    static class C0651e extends C0650d {
        C0651e() {
        }

        /* renamed from: c */
        public void mo5729c(View view, int mode) {
            view.setAccessibilityLiveRegion(mode);
        }

        /* renamed from: d */
        public void mo5712d(View view, int mode) {
            view.setImportantForAccessibility(mode);
        }

        /* renamed from: w */
        public boolean mo5731w(View view) {
            return view.isLaidOut();
        }

        /* renamed from: v */
        public boolean mo5730v(View view) {
            return view.isAttachedToWindow();
        }
    }

    /* renamed from: android.support.v4.view.w$f */
    /* compiled from: ViewCompat */
    static class C0652f extends C0651e {

        /* renamed from: j */
        private static ThreadLocal<Rect> f1862j;

        C0652f() {
        }

        /* renamed from: a */
        public void mo5739a(View view, String transitionName) {
            view.setTransitionName(transitionName);
        }

        /* renamed from: n */
        public String mo5745n(View view) {
            return view.getTransitionName();
        }

        /* renamed from: A */
        public void mo5707A(View view) {
            view.requestApplyInsets();
        }

        /* renamed from: a */
        public void mo5734a(View view, float elevation) {
            view.setElevation(elevation);
        }

        /* renamed from: f */
        public float mo5744f(View view) {
            return view.getElevation();
        }

        /* renamed from: o */
        public float mo5746o(View view) {
            return view.getTranslationZ();
        }

        /* renamed from: a */
        public void mo5738a(View view, C0641r listener) {
            if (listener == null) {
                view.setOnApplyWindowInsetsListener(null);
            } else {
                view.setOnApplyWindowInsetsListener(new C0657x(this, listener));
            }
        }

        /* renamed from: x */
        public boolean mo5748x(View view) {
            return view.isNestedScrollingEnabled();
        }

        /* renamed from: B */
        public void mo5732B(View view) {
            view.stopNestedScroll();
        }

        /* renamed from: b */
        public ColorStateList mo5740b(View view) {
            return view.getBackgroundTintList();
        }

        /* renamed from: a */
        public void mo5736a(View view, ColorStateList tintList) {
            view.setBackgroundTintList(tintList);
            if (VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                boolean hasTint = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                if (background != null && hasTint) {
                    if (background.isStateful()) {
                        background.setState(view.getDrawableState());
                    }
                    view.setBackground(background);
                }
            }
        }

        /* renamed from: a */
        public void mo5737a(View view, Mode mode) {
            view.setBackgroundTintMode(mode);
            if (VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                boolean hasTint = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                if (background != null && hasTint) {
                    if (background.isStateful()) {
                        background.setState(view.getDrawableState());
                    }
                    view.setBackground(background);
                }
            }
        }

        /* renamed from: c */
        public Mode mo5743c(View view) {
            return view.getBackgroundTintMode();
        }

        /* renamed from: b */
        public C0592M mo5741b(View v, C0592M insets) {
            WindowInsets unwrapped = (WindowInsets) C0592M.m2793a(insets);
            WindowInsets result = v.onApplyWindowInsets(unwrapped);
            if (result != unwrapped) {
                unwrapped = new WindowInsets(result);
            }
            return C0592M.m2792a((Object) unwrapped);
        }

        /* renamed from: a */
        public C0592M mo5733a(View v, C0592M insets) {
            WindowInsets unwrapped = (WindowInsets) C0592M.m2793a(insets);
            WindowInsets result = v.dispatchApplyWindowInsets(unwrapped);
            if (result != unwrapped) {
                unwrapped = new WindowInsets(result);
            }
            return C0592M.m2792a((Object) unwrapped);
        }

        /* renamed from: q */
        public float mo5747q(View view) {
            return view.getZ();
        }

        /* renamed from: a */
        public void mo5735a(View view, int offset) {
            Rect parentRect = m3020b();
            boolean needInvalidateWorkaround = false;
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View p = (View) parent;
                parentRect.set(p.getLeft(), p.getTop(), p.getRight(), p.getBottom());
                needInvalidateWorkaround = !parentRect.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            super.mo5735a(view, offset);
            if (needInvalidateWorkaround && parentRect.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(parentRect);
            }
        }

        /* renamed from: b */
        public void mo5742b(View view, int offset) {
            Rect parentRect = m3020b();
            boolean needInvalidateWorkaround = false;
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View p = (View) parent;
                parentRect.set(p.getLeft(), p.getTop(), p.getRight(), p.getBottom());
                needInvalidateWorkaround = !parentRect.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            super.mo5742b(view, offset);
            if (needInvalidateWorkaround && parentRect.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(parentRect);
            }
        }

        /* renamed from: b */
        private static Rect m3020b() {
            if (f1862j == null) {
                f1862j = new ThreadLocal<>();
            }
            Rect rect = (Rect) f1862j.get();
            if (rect == null) {
                rect = new Rect();
                f1862j.set(rect);
            }
            rect.setEmpty();
            return rect;
        }
    }

    /* renamed from: android.support.v4.view.w$g */
    /* compiled from: ViewCompat */
    static class C0653g extends C0652f {
        C0653g() {
        }

        /* renamed from: a */
        public void mo5749a(View view, int indicators, int mask) {
            view.setScrollIndicators(indicators, mask);
        }

        /* renamed from: a */
        public void mo5735a(View view, int offset) {
            view.offsetLeftAndRight(offset);
        }

        /* renamed from: b */
        public void mo5742b(View view, int offset) {
            view.offsetTopAndBottom(offset);
        }
    }

    /* renamed from: android.support.v4.view.w$h */
    /* compiled from: ViewCompat */
    static class C0654h extends C0653g {
        C0654h() {
        }

        /* renamed from: a */
        public void mo5750a(View view, C0643t pointerIconCompat) {
            view.setPointerIcon((PointerIcon) (pointerIconCompat != null ? pointerIconCompat.mo5701a() : null));
        }
    }

    /* renamed from: android.support.v4.view.w$i */
    /* compiled from: ViewCompat */
    static class C0655i extends C0654h {
        C0655i() {
        }
    }

    /* renamed from: android.support.v4.view.w$j */
    /* compiled from: ViewCompat */
    static class C0656j {

        /* renamed from: a */
        private static Field f1863a;

        /* renamed from: b */
        private static boolean f1864b;

        /* renamed from: c */
        private static Field f1865c;

        /* renamed from: d */
        private static boolean f1866d;

        /* renamed from: e */
        private static WeakHashMap<View, String> f1867e;

        /* renamed from: f */
        private static final AtomicInteger f1868f = new AtomicInteger(1);

        /* renamed from: g */
        static Field f1869g;

        /* renamed from: h */
        static boolean f1870h = false;

        /* renamed from: i */
        WeakHashMap<View, C0587I> f1871i = null;

        C0656j() {
        }

        /* renamed from: a */
        public void mo5753a(View v, C0616c delegate) {
            v.setAccessibilityDelegate(delegate == null ? null : delegate.mo5630a());
        }

        /* renamed from: r */
        public boolean mo5754r(View v) {
            boolean z = false;
            if (f1870h) {
                return false;
            }
            if (f1869g == null) {
                try {
                    f1869g = View.class.getDeclaredField("mAccessibilityDelegate");
                    f1869g.setAccessible(true);
                } catch (Throwable th) {
                    f1870h = true;
                    return false;
                }
            }
            try {
                if (f1869g.get(v) != null) {
                    z = true;
                }
                return z;
            } catch (Throwable th2) {
                f1870h = true;
                return false;
            }
        }

        /* renamed from: u */
        public boolean mo5718u(View view) {
            return false;
        }

        /* renamed from: a */
        public void mo5711a(View view, boolean hasTransientState) {
        }

        /* renamed from: z */
        public void mo5719z(View view) {
            view.postInvalidate();
        }

        /* renamed from: a */
        public void mo5709a(View view, Runnable action) {
            view.postDelayed(action, mo5751a());
        }

        /* renamed from: a */
        public void mo5710a(View view, Runnable action, long delayMillis) {
            view.postDelayed(action, mo5751a() + delayMillis);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public long mo5751a() {
            return ValueAnimator.getFrameDelay();
        }

        /* renamed from: h */
        public int mo5714h(View view) {
            return 0;
        }

        /* renamed from: d */
        public void mo5712d(View view, int mode) {
        }

        /* renamed from: i */
        public int mo5722i(View view) {
            return 0;
        }

        /* renamed from: c */
        public void mo5729c(View view, int mode) {
        }

        /* renamed from: m */
        public int mo5724m(View view) {
            return view.getPaddingLeft();
        }

        /* renamed from: l */
        public int mo5723l(View view) {
            return view.getPaddingRight();
        }

        /* renamed from: a */
        public void mo5720a(View view, int start, int top, int end, int bottom) {
            view.setPadding(start, top, end, bottom);
        }

        /* renamed from: t */
        public boolean mo5717t(View view) {
            return true;
        }

        /* renamed from: k */
        public int mo5716k(View view) {
            if (!f1864b) {
                try {
                    f1863a = View.class.getDeclaredField("mMinWidth");
                    f1863a.setAccessible(true);
                } catch (NoSuchFieldException e) {
                }
                f1864b = true;
            }
            Field field = f1863a;
            if (field != null) {
                try {
                    return ((Integer) field.get(view)).intValue();
                } catch (Exception e2) {
                }
            }
            return 0;
        }

        /* renamed from: j */
        public int mo5715j(View view) {
            if (!f1866d) {
                try {
                    f1865c = View.class.getDeclaredField("mMinHeight");
                    f1865c.setAccessible(true);
                } catch (NoSuchFieldException e) {
                }
                f1866d = true;
            }
            Field field = f1865c;
            if (field != null) {
                try {
                    return ((Integer) field.get(view)).intValue();
                } catch (Exception e2) {
                }
            }
            return 0;
        }

        /* renamed from: a */
        public C0587I mo5752a(View view) {
            if (this.f1871i == null) {
                this.f1871i = new WeakHashMap<>();
            }
            C0587I vpa = (C0587I) this.f1871i.get(view);
            if (vpa != null) {
                return vpa;
            }
            C0587I vpa2 = new C0587I(view);
            this.f1871i.put(view, vpa2);
            return vpa2;
        }

        /* renamed from: a */
        public void mo5739a(View view, String transitionName) {
            if (f1867e == null) {
                f1867e = new WeakHashMap<>();
            }
            f1867e.put(view, transitionName);
        }

        /* renamed from: n */
        public String mo5745n(View view) {
            WeakHashMap<View, String> weakHashMap = f1867e;
            if (weakHashMap == null) {
                return null;
            }
            return (String) weakHashMap.get(view);
        }

        /* renamed from: p */
        public int mo5725p(View view) {
            return 0;
        }

        /* renamed from: A */
        public void mo5707A(View view) {
        }

        /* renamed from: a */
        public void mo5734a(View view, float elevation) {
        }

        /* renamed from: f */
        public float mo5744f(View view) {
            return 0.0f;
        }

        /* renamed from: o */
        public float mo5746o(View view) {
            return 0.0f;
        }

        /* renamed from: a */
        public void mo5727a(View view, Rect clipBounds) {
        }

        /* renamed from: d */
        public Rect mo5728d(View view) {
            return null;
        }

        /* renamed from: g */
        public boolean mo5713g(View view) {
            return false;
        }

        /* renamed from: a */
        public void mo5738a(View view, C0641r listener) {
        }

        /* renamed from: b */
        public C0592M mo5741b(View v, C0592M insets) {
            return insets;
        }

        /* renamed from: a */
        public C0592M mo5733a(View v, C0592M insets) {
            return insets;
        }

        /* renamed from: y */
        public boolean mo5726y(View view) {
            return false;
        }

        /* renamed from: x */
        public boolean mo5748x(View view) {
            if (view instanceof C0636m) {
                return ((C0636m) view).isNestedScrollingEnabled();
            }
            return false;
        }

        /* renamed from: a */
        public void mo5708a(View view, Drawable background) {
            view.setBackgroundDrawable(background);
        }

        /* renamed from: b */
        public ColorStateList mo5740b(View view) {
            if (view instanceof C0645v) {
                return ((C0645v) view).getSupportBackgroundTintList();
            }
            return null;
        }

        /* renamed from: a */
        public void mo5736a(View view, ColorStateList tintList) {
            if (view instanceof C0645v) {
                ((C0645v) view).setSupportBackgroundTintList(tintList);
            }
        }

        /* renamed from: a */
        public void mo5737a(View view, Mode mode) {
            if (view instanceof C0645v) {
                ((C0645v) view).setSupportBackgroundTintMode(mode);
            }
        }

        /* renamed from: c */
        public Mode mo5743c(View view) {
            if (view instanceof C0645v) {
                return ((C0645v) view).getSupportBackgroundTintMode();
            }
            return null;
        }

        /* renamed from: B */
        public void mo5732B(View view) {
            if (view instanceof C0636m) {
                ((C0636m) view).stopNestedScroll();
            }
        }

        /* renamed from: w */
        public boolean mo5731w(View view) {
            return view.getWidth() > 0 && view.getHeight() > 0;
        }

        /* renamed from: q */
        public float mo5747q(View view) {
            return mo5746o(view) + mo5744f(view);
        }

        /* renamed from: v */
        public boolean mo5730v(View view) {
            return view.getWindowToken() != null;
        }

        /* renamed from: s */
        public boolean mo5706s(View view) {
            return false;
        }

        /* renamed from: a */
        public void mo5749a(View view, int indicators, int mask) {
        }

        /* renamed from: a */
        public void mo5735a(View view, int offset) {
            view.offsetLeftAndRight(offset);
            if (view.getVisibility() == 0) {
                m3043C(view);
                ViewParent parent = view.getParent();
                if (parent instanceof View) {
                    m3043C((View) parent);
                }
            }
        }

        /* renamed from: b */
        public void mo5742b(View view, int offset) {
            view.offsetTopAndBottom(offset);
            if (view.getVisibility() == 0) {
                m3043C(view);
                ViewParent parent = view.getParent();
                if (parent instanceof View) {
                    m3043C((View) parent);
                }
            }
        }

        /* renamed from: C */
        private static void m3043C(View view) {
            float y = view.getTranslationY();
            view.setTranslationY(1.0f + y);
            view.setTranslationY(y);
        }

        /* renamed from: a */
        public void mo5750a(View view, C0643t pointerIcon) {
        }

        /* renamed from: e */
        public Display mo5721e(View view) {
            if (mo5730v(view)) {
                return ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay();
            }
            return null;
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 26) {
            f1861a = new C0655i();
        } else if (i >= 24) {
            f1861a = new C0654h();
        } else if (i >= 23) {
            f1861a = new C0653g();
        } else if (i >= 21) {
            f1861a = new C0652f();
        } else if (i >= 19) {
            f1861a = new C0651e();
        } else if (i >= 18) {
            f1861a = new C0650d();
        } else if (i >= 17) {
            f1861a = new C0649c();
        } else if (i >= 16) {
            f1861a = new C0648b();
        } else if (i >= 15) {
            f1861a = new C0647a();
        } else {
            f1861a = new C0656j();
        }
    }

    /* renamed from: a */
    public static void m2955a(View v, C0616c delegate) {
        f1861a.mo5753a(v, delegate);
    }

    /* renamed from: p */
    public static boolean m2982p(View v) {
        return f1861a.mo5754r(v);
    }

    /* renamed from: s */
    public static boolean m2985s(View view) {
        return f1861a.mo5718u(view);
    }

    /* renamed from: b */
    public static void m2966b(View view, boolean hasTransientState) {
        f1861a.mo5711a(view, hasTransientState);
    }

    /* renamed from: x */
    public static void m2990x(View view) {
        f1861a.mo5719z(view);
    }

    /* renamed from: a */
    public static void m2958a(View view, Runnable action) {
        f1861a.mo5709a(view, action);
    }

    /* renamed from: a */
    public static void m2959a(View view, Runnable action, long delayMillis) {
        f1861a.mo5710a(view, action, delayMillis);
    }

    /* renamed from: g */
    public static int m2973g(View view) {
        return f1861a.mo5714h(view);
    }

    /* renamed from: d */
    public static void m2970d(View view, int mode) {
        f1861a.mo5712d(view, mode);
    }

    /* renamed from: h */
    public static int m2974h(View view) {
        return f1861a.mo5722i(view);
    }

    /* renamed from: c */
    public static void m2968c(View view, int mode) {
        f1861a.mo5729c(view, mode);
    }

    /* renamed from: l */
    public static int m2978l(View view) {
        return f1861a.mo5724m(view);
    }

    /* renamed from: k */
    public static int m2977k(View view) {
        return f1861a.mo5723l(view);
    }

    /* renamed from: a */
    public static void m2950a(View view, int start, int top, int end, int bottom) {
        f1861a.mo5720a(view, start, top, end, bottom);
    }

    /* renamed from: j */
    public static int m2976j(View view) {
        return f1861a.mo5716k(view);
    }

    /* renamed from: i */
    public static int m2975i(View view) {
        return f1861a.mo5715j(view);
    }

    /* renamed from: a */
    public static C0587I m2945a(View view) {
        return f1861a.mo5752a(view);
    }

    @Deprecated
    /* renamed from: a */
    public static void m2947a(View view, float value) {
        view.setAlpha(value);
    }

    /* renamed from: b */
    public static void m2964b(View view, float elevation) {
        f1861a.mo5734a(view, elevation);
    }

    /* renamed from: a */
    public static void m2960a(View view, String transitionName) {
        f1861a.mo5739a(view, transitionName);
    }

    /* renamed from: m */
    public static String m2979m(View view) {
        return f1861a.mo5745n(view);
    }

    /* renamed from: n */
    public static int m2980n(View view) {
        return f1861a.mo5725p(view);
    }

    /* renamed from: y */
    public static void m2991y(View view) {
        f1861a.mo5707A(view);
    }

    /* renamed from: f */
    public static boolean m2972f(View v) {
        return f1861a.mo5713g(v);
    }

    @Deprecated
    /* renamed from: a */
    public static void m2961a(View view, boolean fitSystemWindows) {
        view.setFitsSystemWindows(fitSystemWindows);
    }

    /* renamed from: a */
    public static void m2956a(View v, C0641r listener) {
        f1861a.mo5738a(v, listener);
    }

    /* renamed from: b */
    public static C0592M m2963b(View view, C0592M insets) {
        return f1861a.mo5741b(view, insets);
    }

    /* renamed from: a */
    public static C0592M m2946a(View view, C0592M insets) {
        return f1861a.mo5733a(view, insets);
    }

    /* renamed from: r */
    public static boolean m2984r(View view) {
        return f1861a.mo5717t(view);
    }

    /* renamed from: w */
    public static boolean m2989w(View view) {
        return f1861a.mo5726y(view);
    }

    /* renamed from: a */
    public static void m2954a(View view, Drawable background) {
        f1861a.mo5708a(view, background);
    }

    /* renamed from: b */
    public static ColorStateList m2962b(View view) {
        return f1861a.mo5740b(view);
    }

    /* renamed from: a */
    public static void m2951a(View view, ColorStateList tintList) {
        f1861a.mo5736a(view, tintList);
    }

    /* renamed from: c */
    public static Mode m2967c(View view) {
        return f1861a.mo5743c(view);
    }

    /* renamed from: a */
    public static void m2952a(View view, Mode mode) {
        f1861a.mo5737a(view, mode);
    }

    /* renamed from: v */
    public static boolean m2988v(View view) {
        return f1861a.mo5748x(view);
    }

    /* renamed from: z */
    public static void m2992z(View view) {
        f1861a.mo5732B(view);
    }

    /* renamed from: u */
    public static boolean m2987u(View view) {
        return f1861a.mo5731w(view);
    }

    /* renamed from: o */
    public static float m2981o(View view) {
        return f1861a.mo5747q(view);
    }

    /* renamed from: b */
    public static void m2965b(View view, int offset) {
        f1861a.mo5742b(view, offset);
    }

    /* renamed from: a */
    public static void m2948a(View view, int offset) {
        f1861a.mo5735a(view, offset);
    }

    /* renamed from: a */
    public static void m2953a(View view, Rect clipBounds) {
        f1861a.mo5727a(view, clipBounds);
    }

    /* renamed from: d */
    public static Rect m2969d(View view) {
        return f1861a.mo5728d(view);
    }

    /* renamed from: t */
    public static boolean m2986t(View view) {
        return f1861a.mo5730v(view);
    }

    /* renamed from: q */
    public static boolean m2983q(View view) {
        return f1861a.mo5706s(view);
    }

    /* renamed from: a */
    public static void m2949a(View view, int indicators, int mask) {
        f1861a.mo5749a(view, indicators, mask);
    }

    /* renamed from: a */
    public static void m2957a(View view, C0643t pointerIcon) {
        f1861a.mo5750a(view, pointerIcon);
    }

    /* renamed from: e */
    public static Display m2971e(View view) {
        return f1861a.mo5721e(view);
    }
}
