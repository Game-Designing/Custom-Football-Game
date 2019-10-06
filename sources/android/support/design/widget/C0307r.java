package android.support.design.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.design.widget.BaseTransientBottomBar.Behavior;
import android.support.design.widget.C0307r;
import android.support.design.widget.CoordinatorLayout.C0237b;
import android.support.design.widget.CoordinatorLayout.C0239e;
import android.support.design.widget.SwipeDismissBehavior.C0267a;
import android.support.p000v4.view.C0641r;
import android.support.p000v4.view.C0646w;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.List;
import p002b.p003c.p050d.C1167a;
import p002b.p003c.p050d.C1174h;
import p002b.p003c.p050d.C1177k;

/* renamed from: android.support.design.widget.r */
/* compiled from: BaseTransientBottomBar */
public abstract class C0307r<B extends C0307r<B>> {

    /* renamed from: a */
    static final Handler f1115a = new Handler(Looper.getMainLooper(), new C0294h());
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final boolean f1116b;

    /* renamed from: c */
    private final ViewGroup f1117c;

    /* renamed from: d */
    private final Context f1118d;

    /* renamed from: e */
    final C0313f f1119e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final C0310c f1120f;

    /* renamed from: g */
    private int f1121g;

    /* renamed from: h */
    private List<C0308a<B>> f1122h;

    /* renamed from: i */
    private final AccessibilityManager f1123i;

    /* renamed from: j */
    final C0270a f1124j = new C0298j(this);

    /* renamed from: android.support.design.widget.r$a */
    /* compiled from: BaseTransientBottomBar */
    public static abstract class C0308a<B> {
        public static final int DISMISS_EVENT_ACTION = 1;
        public static final int DISMISS_EVENT_CONSECUTIVE = 4;
        public static final int DISMISS_EVENT_MANUAL = 3;
        public static final int DISMISS_EVENT_SWIPE = 0;
        public static final int DISMISS_EVENT_TIMEOUT = 2;

        public void onDismissed(B b, int event) {
        }

        public void onShown(B b) {
        }
    }

    /* renamed from: android.support.design.widget.r$b */
    /* compiled from: BaseTransientBottomBar */
    final class C0309b extends SwipeDismissBehavior<C0313f> {
        C0309b() {
        }

        /* renamed from: a */
        public boolean mo4564a(View child) {
            return child instanceof C0313f;
        }

        /* renamed from: a */
        public boolean mo4276a(CoordinatorLayout parent, C0313f child, MotionEvent event) {
            int actionMasked = event.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked == 1 || actionMasked == 3) {
                    C0269T.m1643a().mo4576e(C0307r.this.f1124j);
                }
            } else if (parent.mo4367a((View) child, (int) event.getX(), (int) event.getY())) {
                C0269T.m1643a().mo4575d(C0307r.this.f1124j);
            }
            return super.mo4276a(parent, child, event);
        }
    }

    /* renamed from: android.support.design.widget.r$c */
    /* compiled from: BaseTransientBottomBar */
    public interface C0310c {
        /* renamed from: a */
        void mo4102a(int i, int i2);

        /* renamed from: b */
        void mo4103b(int i, int i2);
    }

    /* renamed from: android.support.design.widget.r$d */
    /* compiled from: BaseTransientBottomBar */
    interface C0311d {
        void onViewAttachedToWindow(View view);

        void onViewDetachedFromWindow(View view);
    }

    /* renamed from: android.support.design.widget.r$e */
    /* compiled from: BaseTransientBottomBar */
    interface C0312e {
        /* renamed from: a */
        void mo4671a(View view, int i, int i2, int i3, int i4);
    }

    /* renamed from: android.support.design.widget.r$f */
    /* compiled from: BaseTransientBottomBar */
    static class C0313f extends FrameLayout {

        /* renamed from: a */
        private C0312e f1126a;

        /* renamed from: b */
        private C0311d f1127b;

        C0313f(Context context) {
            this(context, null);
        }

        C0313f(Context context, AttributeSet attrs) {
            super(context, attrs);
            TypedArray a = context.obtainStyledAttributes(attrs, C1177k.SnackbarLayout);
            if (a.hasValue(C1177k.SnackbarLayout_elevation)) {
                C0646w.m2964b((View) this, (float) a.getDimensionPixelSize(C1177k.SnackbarLayout_elevation, 0));
            }
            a.recycle();
            setClickable(true);
        }

        /* access modifiers changed from: protected */
        public void onLayout(boolean changed, int l, int t, int r, int b) {
            super.onLayout(changed, l, t, r, b);
            C0312e eVar = this.f1126a;
            if (eVar != null) {
                eVar.mo4671a(this, l, t, r, b);
            }
        }

        /* access modifiers changed from: protected */
        public void onAttachedToWindow() {
            super.onAttachedToWindow();
            C0311d dVar = this.f1127b;
            if (dVar != null) {
                dVar.onViewAttachedToWindow(this);
            }
            C0646w.m2991y(this);
        }

        /* access modifiers changed from: protected */
        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            C0311d dVar = this.f1127b;
            if (dVar != null) {
                dVar.onViewDetachedFromWindow(this);
            }
        }

        /* access modifiers changed from: 0000 */
        public void setOnLayoutChangeListener(C0312e onLayoutChangeListener) {
            this.f1126a = onLayoutChangeListener;
        }

        /* access modifiers changed from: 0000 */
        public void setOnAttachStateChangeListener(C0311d listener) {
            this.f1127b = listener;
        }
    }

    static {
        int i = VERSION.SDK_INT;
        f1116b = i >= 16 && i <= 19;
    }

    protected C0307r(ViewGroup parent, View content, C0310c contentViewCallback) {
        if (parent == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
        } else if (content == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null content");
        } else if (contentViewCallback != null) {
            this.f1117c = parent;
            this.f1120f = contentViewCallback;
            this.f1118d = parent.getContext();
            C0289ea.m1678a(this.f1118d);
            this.f1119e = (C0313f) LayoutInflater.from(this.f1118d).inflate(C1174h.design_layout_snackbar, this.f1117c, false);
            this.f1119e.addView(content);
            C0646w.m2968c(this.f1119e, 1);
            C0646w.m2970d(this.f1119e, 1);
            C0646w.m2961a((View) this.f1119e, true);
            C0646w.m2956a((View) this.f1119e, (C0641r) new C0296i(this));
            this.f1123i = (AccessibilityManager) this.f1118d.getSystemService("accessibility");
        } else {
            throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
        }
    }

    /* renamed from: d */
    public B mo4686d(int duration) {
        this.f1121g = duration;
        return this;
    }

    /* renamed from: d */
    public Context mo4685d() {
        return this.f1118d;
    }

    /* renamed from: h */
    public void mo4690h() {
        C0269T.m1643a().mo4569a(this.f1121g, this.f1124j);
    }

    /* renamed from: c */
    public void mo4683c() {
        mo4679a(3);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4679a(int event) {
        C0269T.m1643a().mo4570a(this.f1124j, event);
    }

    /* renamed from: a */
    public B mo4678a(C0308a<B> callback) {
        if (callback == null) {
            return this;
        }
        if (this.f1122h == null) {
            this.f1122h = new ArrayList();
        }
        this.f1122h.add(callback);
        return this;
    }

    /* renamed from: b */
    public B mo4680b(C0308a<B> callback) {
        if (callback == null) {
            return this;
        }
        List<C0308a<B>> list = this.f1122h;
        if (list == null) {
            return this;
        }
        list.remove(callback);
        return this;
    }

    /* renamed from: e */
    public boolean mo4687e() {
        return C0269T.m1643a().mo4572a(this.f1124j);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public final void mo4691i() {
        if (this.f1119e.getParent() == null) {
            LayoutParams lp = this.f1119e.getLayoutParams();
            if (lp instanceof C0239e) {
                C0239e clp = (C0239e) lp;
                Behavior behavior = new C0309b<>();
                behavior.mo4565b(0.1f);
                behavior.mo4561a(0.6f);
                behavior.mo4562a(0);
                behavior.mo4563a((C0267a) new C0300k(this));
                clp.mo4433a((C0237b) behavior);
                clp.f933g = 80;
            }
            this.f1117c.addView(this.f1119e);
        }
        this.f1119e.setOnAttachStateChangeListener(new C0302m(this));
        if (!C0646w.m2987u(this.f1119e)) {
            this.f1119e.setOnLayoutChangeListener(new C0303n(this));
        } else if (mo4689g()) {
            mo4681b();
        } else {
            mo4688f();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo4681b() {
        if (VERSION.SDK_INT >= 12) {
            int viewHeight = this.f1119e.getHeight();
            if (f1116b) {
                C0646w.m2965b((View) this.f1119e, viewHeight);
            } else {
                this.f1119e.setTranslationY((float) viewHeight);
            }
            ValueAnimator animator = new ValueAnimator();
            animator.setIntValues(new int[]{viewHeight, 0});
            animator.setInterpolator(C0280a.f1075b);
            animator.setDuration(250);
            animator.addListener(new C0304o(this));
            animator.addUpdateListener(new C0305p(this, viewHeight));
            animator.start();
            return;
        }
        Animation anim = AnimationUtils.loadAnimation(this.f1119e.getContext(), C1167a.design_snackbar_in);
        anim.setInterpolator(C0280a.f1075b);
        anim.setDuration(250);
        anim.setAnimationListener(new C0306q(this));
        this.f1119e.startAnimation(anim);
    }

    /* renamed from: e */
    private void m1701e(int event) {
        if (VERSION.SDK_INT >= 12) {
            ValueAnimator animator = new ValueAnimator();
            animator.setIntValues(new int[]{0, this.f1119e.getHeight()});
            animator.setInterpolator(C0280a.f1075b);
            animator.setDuration(250);
            animator.addListener(new C0288e(this, event));
            animator.addUpdateListener(new C0290f(this));
            animator.start();
            return;
        }
        Animation anim = AnimationUtils.loadAnimation(this.f1119e.getContext(), C1167a.design_snackbar_out);
        anim.setInterpolator(C0280a.f1075b);
        anim.setDuration(250);
        anim.setAnimationListener(new C0292g(this, event));
        this.f1119e.startAnimation(anim);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final void mo4682b(int event) {
        if (!mo4689g() || this.f1119e.getVisibility() != 0) {
            mo4684c(event);
        } else {
            m1701e(event);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public void mo4688f() {
        C0269T.m1643a().mo4574c(this.f1124j);
        List<C0308a<B>> list = this.f1122h;
        if (list != null) {
            for (int i = list.size() - 1; i >= 0; i--) {
                ((C0308a) this.f1122h.get(i)).onShown(this);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo4684c(int event) {
        C0269T.m1643a().mo4573b(this.f1124j);
        List<C0308a<B>> list = this.f1122h;
        if (list != null) {
            for (int i = list.size() - 1; i >= 0; i--) {
                ((C0308a) this.f1122h.get(i)).onDismissed(this, event);
            }
        }
        if (VERSION.SDK_INT < 11) {
            this.f1119e.setVisibility(8);
        }
        ViewParent parent = this.f1119e.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f1119e);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public boolean mo4689g() {
        return !this.f1123i.isEnabled();
    }
}
