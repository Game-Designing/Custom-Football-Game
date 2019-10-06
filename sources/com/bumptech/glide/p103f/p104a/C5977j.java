package com.bumptech.glide.p103f.p104a;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.WindowManager;
import com.bumptech.glide.p103f.C5986c;
import com.bumptech.glide.p107h.C6024i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.bumptech.glide.f.a.j */
/* compiled from: ViewTarget */
public abstract class C5977j<T extends View, Z> extends C5968a<Z> {

    /* renamed from: a */
    private static boolean f10536a;

    /* renamed from: b */
    private static Integer f10537b;

    /* renamed from: c */
    protected final T f10538c;

    /* renamed from: d */
    private final C5978a f10539d;

    /* renamed from: e */
    private OnAttachStateChangeListener f10540e;

    /* renamed from: f */
    private boolean f10541f;

    /* renamed from: g */
    private boolean f10542g;

    /* renamed from: com.bumptech.glide.f.a.j$a */
    /* compiled from: ViewTarget */
    static final class C5978a {

        /* renamed from: a */
        static Integer f10543a;

        /* renamed from: b */
        private final View f10544b;

        /* renamed from: c */
        private final List<C5975h> f10545c = new ArrayList();

        /* renamed from: d */
        boolean f10546d;

        /* renamed from: e */
        private C5979a f10547e;

        /* renamed from: com.bumptech.glide.f.a.j$a$a */
        /* compiled from: ViewTarget */
        private static final class C5979a implements OnPreDrawListener {

            /* renamed from: a */
            private final WeakReference<C5978a> f10548a;

            C5979a(C5978a sizeDeterminer) {
                this.f10548a = new WeakReference<>(sizeDeterminer);
            }

            public boolean onPreDraw() {
                String str = "ViewTarget";
                if (Log.isLoggable(str, 2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("OnGlobalLayoutListener called attachStateListener=");
                    sb.append(this);
                    Log.v(str, sb.toString());
                }
                C5978a sizeDeterminer = (C5978a) this.f10548a.get();
                if (sizeDeterminer != null) {
                    sizeDeterminer.mo18705a();
                }
                return true;
            }
        }

        C5978a(View view) {
            this.f10544b = view;
        }

        /* renamed from: a */
        private static int m11068a(Context context) {
            if (f10543a == null) {
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                C6024i.m11264a(windowManager);
                Display display = windowManager.getDefaultDisplay();
                Point displayDimensions = new Point();
                display.getSize(displayDimensions);
                f10543a = Integer.valueOf(Math.max(displayDimensions.x, displayDimensions.y));
            }
            return f10543a.intValue();
        }

        /* renamed from: b */
        private void m11071b(int width, int height) {
            Iterator it = new ArrayList(this.f10545c).iterator();
            while (it.hasNext()) {
                ((C5975h) it.next()).mo18703a(width, height);
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo18705a() {
            if (!this.f10545c.isEmpty()) {
                int currentWidth = m11073d();
                int currentHeight = m11072c();
                if (m11070a(currentWidth, currentHeight)) {
                    m11071b(currentWidth, currentHeight);
                    mo18707b();
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo18706a(C5975h cb) {
            int currentWidth = m11073d();
            int currentHeight = m11072c();
            if (m11070a(currentWidth, currentHeight)) {
                cb.mo18703a(currentWidth, currentHeight);
                return;
            }
            if (!this.f10545c.contains(cb)) {
                this.f10545c.add(cb);
            }
            if (this.f10547e == null) {
                ViewTreeObserver observer = this.f10544b.getViewTreeObserver();
                this.f10547e = new C5979a(this);
                observer.addOnPreDrawListener(this.f10547e);
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo18708b(C5975h cb) {
            this.f10545c.remove(cb);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo18707b() {
            ViewTreeObserver observer = this.f10544b.getViewTreeObserver();
            if (observer.isAlive()) {
                observer.removeOnPreDrawListener(this.f10547e);
            }
            this.f10547e = null;
            this.f10545c.clear();
        }

        /* renamed from: a */
        private boolean m11070a(int width, int height) {
            return m11069a(width) && m11069a(height);
        }

        /* renamed from: c */
        private int m11072c() {
            int verticalPadding = this.f10544b.getPaddingTop() + this.f10544b.getPaddingBottom();
            LayoutParams layoutParams = this.f10544b.getLayoutParams();
            return m11067a(this.f10544b.getHeight(), layoutParams != null ? layoutParams.height : 0, verticalPadding);
        }

        /* renamed from: d */
        private int m11073d() {
            int horizontalPadding = this.f10544b.getPaddingLeft() + this.f10544b.getPaddingRight();
            LayoutParams layoutParams = this.f10544b.getLayoutParams();
            return m11067a(this.f10544b.getWidth(), layoutParams != null ? layoutParams.width : 0, horizontalPadding);
        }

        /* renamed from: a */
        private int m11067a(int viewSize, int paramSize, int paddingSize) {
            int adjustedParamSize = paramSize - paddingSize;
            if (adjustedParamSize > 0) {
                return adjustedParamSize;
            }
            if (this.f10546d && this.f10544b.isLayoutRequested()) {
                return 0;
            }
            int adjustedViewSize = viewSize - paddingSize;
            if (adjustedViewSize > 0) {
                return adjustedViewSize;
            }
            if (this.f10544b.isLayoutRequested() || paramSize != -2) {
                return 0;
            }
            String str = "ViewTarget";
            if (Log.isLoggable(str, 4)) {
                Log.i(str, "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use .override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            return m11068a(this.f10544b.getContext());
        }

        /* renamed from: a */
        private boolean m11069a(int size) {
            return size > 0 || size == Integer.MIN_VALUE;
        }
    }

    public C5977j(T view) {
        C6024i.m11264a(view);
        this.f10538c = (View) view;
        this.f10539d = new C5978a(view);
    }

    public void onLoadStarted(Drawable placeholder) {
        super.onLoadStarted(placeholder);
        m11065b();
    }

    /* renamed from: b */
    private void m11065b() {
        OnAttachStateChangeListener onAttachStateChangeListener = this.f10540e;
        if (onAttachStateChangeListener != null && !this.f10542g) {
            this.f10538c.addOnAttachStateChangeListener(onAttachStateChangeListener);
            this.f10542g = true;
        }
    }

    /* renamed from: c */
    private void m11066c() {
        OnAttachStateChangeListener onAttachStateChangeListener = this.f10540e;
        if (onAttachStateChangeListener != null && this.f10542g) {
            this.f10538c.removeOnAttachStateChangeListener(onAttachStateChangeListener);
            this.f10542g = false;
        }
    }

    public void getSize(C5975h cb) {
        this.f10539d.mo18706a(cb);
    }

    public void removeCallback(C5975h cb) {
        this.f10539d.mo18708b(cb);
    }

    public void onLoadCleared(Drawable placeholder) {
        super.onLoadCleared(placeholder);
        this.f10539d.mo18707b();
        if (!this.f10541f) {
            m11066c();
        }
    }

    public void setRequest(C5986c request) {
        mo18696a(request);
    }

    public C5986c getRequest() {
        Object tag = m11063a();
        if (tag == null) {
            return null;
        }
        if (tag instanceof C5986c) {
            return (C5986c) tag;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Target for: ");
        sb.append(this.f10538c);
        return sb.toString();
    }

    /* renamed from: a */
    private void mo18696a(Object tag) {
        Integer num = f10537b;
        if (num == null) {
            f10536a = true;
            this.f10538c.setTag(tag);
            return;
        }
        this.f10538c.setTag(num.intValue(), tag);
    }

    /* renamed from: a */
    private Object m11063a() {
        Integer num = f10537b;
        if (num == null) {
            return this.f10538c.getTag();
        }
        return this.f10538c.getTag(num.intValue());
    }
}
