package android.support.p000v4.view;

import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* renamed from: android.support.v4.view.I */
/* compiled from: ViewPropertyAnimatorCompat */
public final class C0587I {

    /* renamed from: a */
    private WeakReference<View> f1803a;

    /* renamed from: b */
    Runnable f1804b = null;

    /* renamed from: c */
    Runnable f1805c = null;

    /* renamed from: d */
    int f1806d = -1;

    /* renamed from: android.support.v4.view.I$a */
    /* compiled from: ViewPropertyAnimatorCompat */
    static class C0588a implements C0589J {

        /* renamed from: a */
        C0587I f1807a;

        /* renamed from: b */
        boolean f1808b;

        C0588a(C0587I vpa) {
            this.f1807a = vpa;
        }

        public void onAnimationStart(View view) {
            this.f1808b = false;
            if (this.f1807a.f1806d > -1) {
                view.setLayerType(2, null);
            }
            C0587I i = this.f1807a;
            if (i.f1804b != null) {
                Runnable startAction = i.f1804b;
                i.f1804b = null;
                startAction.run();
            }
            Object listenerTag = view.getTag(2113929216);
            C0589J listener = null;
            if (listenerTag instanceof C0589J) {
                listener = (C0589J) listenerTag;
            }
            if (listener != null) {
                listener.onAnimationStart(view);
            }
        }

        public void onAnimationEnd(View view) {
            int i = this.f1807a.f1806d;
            if (i > -1) {
                view.setLayerType(i, null);
                this.f1807a.f1806d = -1;
            }
            if (VERSION.SDK_INT >= 16 || !this.f1808b) {
                C0587I i2 = this.f1807a;
                if (i2.f1805c != null) {
                    Runnable endAction = i2.f1805c;
                    i2.f1805c = null;
                    endAction.run();
                }
                Object listenerTag = view.getTag(2113929216);
                C0589J listener = null;
                if (listenerTag instanceof C0589J) {
                    listener = (C0589J) listenerTag;
                }
                if (listener != null) {
                    listener.onAnimationEnd(view);
                }
                this.f1808b = true;
            }
        }

        public void onAnimationCancel(View view) {
            Object listenerTag = view.getTag(2113929216);
            C0589J listener = null;
            if (listenerTag instanceof C0589J) {
                listener = (C0589J) listenerTag;
            }
            if (listener != null) {
                listener.onAnimationCancel(view);
            }
        }
    }

    C0587I(View view) {
        this.f1803a = new WeakReference<>(view);
    }

    /* renamed from: a */
    public C0587I mo5471a(long value) {
        View view = (View) this.f1803a.get();
        View view2 = view;
        if (view != null) {
            view2.animate().setDuration(value);
        }
        return this;
    }

    /* renamed from: a */
    public C0587I mo5470a(float value) {
        View view = (View) this.f1803a.get();
        View view2 = view;
        if (view != null) {
            view2.animate().alpha(value);
        }
        return this;
    }

    /* renamed from: b */
    public C0587I mo5477b(float value) {
        View view = (View) this.f1803a.get();
        View view2 = view;
        if (view != null) {
            view2.animate().translationY(value);
        }
        return this;
    }

    /* renamed from: b */
    public long mo5476b() {
        View view = (View) this.f1803a.get();
        View view2 = view;
        if (view != null) {
            return view2.animate().getDuration();
        }
        return 0;
    }

    /* renamed from: a */
    public C0587I mo5474a(Interpolator value) {
        View view = (View) this.f1803a.get();
        View view2 = view;
        if (view != null) {
            view2.animate().setInterpolator(value);
        }
        return this;
    }

    /* renamed from: b */
    public C0587I mo5478b(long value) {
        View view = (View) this.f1803a.get();
        View view2 = view;
        if (view != null) {
            view2.animate().setStartDelay(value);
        }
        return this;
    }

    /* renamed from: a */
    public void mo5475a() {
        View view = (View) this.f1803a.get();
        View view2 = view;
        if (view != null) {
            view2.animate().cancel();
        }
    }

    /* renamed from: c */
    public void mo5479c() {
        View view = (View) this.f1803a.get();
        View view2 = view;
        if (view != null) {
            view2.animate().start();
        }
    }

    /* renamed from: a */
    public C0587I mo5472a(C0589J listener) {
        View view = (View) this.f1803a.get();
        View view2 = view;
        if (view != null) {
            if (VERSION.SDK_INT >= 16) {
                m2780a(view2, listener);
            } else {
                view2.setTag(2113929216, listener);
                m2780a(view2, new C0588a(this));
            }
        }
        return this;
    }

    /* renamed from: a */
    private void m2780a(View view, C0589J listener) {
        if (listener != null) {
            view.animate().setListener(new C0585G(this, listener, view));
        } else {
            view.animate().setListener(null);
        }
    }

    /* renamed from: a */
    public C0587I mo5473a(C0591L listener) {
        View view = (View) this.f1803a.get();
        View view2 = view;
        if (view != null && VERSION.SDK_INT >= 19) {
            AnimatorUpdateListener wrapped = null;
            if (listener != null) {
                wrapped = new C0586H(this, listener, view2);
            }
            view2.animate().setUpdateListener(wrapped);
        }
        return this;
    }
}
