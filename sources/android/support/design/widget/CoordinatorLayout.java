package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.p000v4.content.C0510b;
import android.support.p000v4.view.AbsSavedState;
import android.support.p000v4.view.C0592M;
import android.support.p000v4.view.C0623f;
import android.support.p000v4.view.C0638o;
import android.support.p000v4.view.C0640q;
import android.support.p000v4.view.C0641r;
import android.support.p000v4.view.C0646w;
import android.support.p000v4.widget.C0679I;
import android.support.p000v4.widget.C0705l;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.view.ViewParent;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p002b.p003c.p048b.C1159a;
import p002b.p003c.p048b.C1160b;
import p002b.p003c.p048b.C1161c;
import p002b.p003c.p053g.p054a.p055a.C1200a;
import p002b.p003c.p053g.p058c.C1226a;
import p002b.p003c.p053g.p061f.C1267k;
import p002b.p003c.p053g.p061f.C1269m;
import p002b.p003c.p053g.p061f.C1271o;

public class CoordinatorLayout extends ViewGroup implements C0638o {

    /* renamed from: a */
    static final String f901a;

    /* renamed from: b */
    static final Class<?>[] f902b = {Context.class, AttributeSet.class};

    /* renamed from: c */
    static final ThreadLocal<Map<String, Constructor<C0237b>>> f903c = new ThreadLocal<>();

    /* renamed from: d */
    static final Comparator<View> f904d;

    /* renamed from: e */
    private static final C1269m<Rect> f905e = new C1271o(12);

    /* renamed from: f */
    private final List<View> f906f;

    /* renamed from: g */
    private final C0705l<View> f907g;

    /* renamed from: h */
    private final List<View> f908h;

    /* renamed from: i */
    private final List<View> f909i;

    /* renamed from: j */
    private final int[] f910j;

    /* renamed from: k */
    private Paint f911k;

    /* renamed from: l */
    private boolean f912l;

    /* renamed from: m */
    private boolean f913m;

    /* renamed from: n */
    private int[] f914n;

    /* renamed from: o */
    private View f915o;

    /* renamed from: p */
    private View f916p;

    /* renamed from: q */
    private C0240f f917q;

    /* renamed from: r */
    private boolean f918r;

    /* renamed from: s */
    private C0592M f919s;

    /* renamed from: t */
    private boolean f920t;

    /* renamed from: u */
    private Drawable f921u;

    /* renamed from: v */
    OnHierarchyChangeListener f922v;

    /* renamed from: w */
    private C0641r f923w;

    /* renamed from: x */
    private final C0640q f924x;

    @Deprecated
    @Retention(RetentionPolicy.RUNTIME)
    /* renamed from: android.support.design.widget.CoordinatorLayout$c */
    public @interface C0004c {
        Class<? extends C0237b> value();
    }

    protected static class SavedState extends AbsSavedState {
        public static final Creator<SavedState> CREATOR = new C0243E();

        /* renamed from: c */
        SparseArray<Parcelable> f925c;

        public SavedState(Parcel source, ClassLoader loader) {
            super(source, loader);
            int size = source.readInt();
            int[] ids = new int[size];
            source.readIntArray(ids);
            Parcelable[] states = source.readParcelableArray(loader);
            this.f925c = new SparseArray<>(size);
            for (int i = 0; i < size; i++) {
                this.f925c.append(ids[i], states[i]);
            }
        }

        public SavedState(Parcelable superState) {
            super(superState);
        }

        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            SparseArray<Parcelable> sparseArray = this.f925c;
            int size = sparseArray != null ? sparseArray.size() : 0;
            dest.writeInt(size);
            int[] ids = new int[size];
            Parcelable[] states = new Parcelable[size];
            for (int i = 0; i < size; i++) {
                ids[i] = this.f925c.keyAt(i);
                states[i] = (Parcelable) this.f925c.valueAt(i);
            }
            dest.writeIntArray(ids);
            dest.writeParcelableArray(states, flags);
        }
    }

    /* renamed from: android.support.design.widget.CoordinatorLayout$a */
    public interface C0236a {
        /* renamed from: a */
        C0237b mo4415a();
    }

    /* renamed from: android.support.design.widget.CoordinatorLayout$b */
    public static abstract class C0237b<V extends View> {
        public C0237b() {
        }

        public C0237b(Context context, AttributeSet attrs) {
        }

        /* renamed from: a */
        public void mo4418a(C0239e params) {
        }

        /* renamed from: a */
        public void mo4417a() {
        }

        /* renamed from: a */
        public boolean mo4276a(CoordinatorLayout parent, V v, MotionEvent ev) {
            return false;
        }

        /* renamed from: b */
        public boolean mo4282b(CoordinatorLayout parent, V v, MotionEvent ev) {
            return false;
        }

        /* renamed from: b */
        public int mo4425b(CoordinatorLayout parent, V v) {
            return CtaButton.BACKGROUND_COLOR;
        }

        /* renamed from: c */
        public float mo4426c(CoordinatorLayout parent, V v) {
            return 0.0f;
        }

        /* renamed from: a */
        public boolean mo4422a(CoordinatorLayout parent, V child) {
            return mo4426c(parent, child) > 0.0f;
        }

        /* renamed from: a */
        public boolean mo4244a(CoordinatorLayout parent, V v, View dependency) {
            return false;
        }

        /* renamed from: b */
        public boolean mo4246b(CoordinatorLayout parent, V v, View dependency) {
            return false;
        }

        /* renamed from: c */
        public void mo4427c(CoordinatorLayout parent, V v, View dependency) {
        }

        /* renamed from: a */
        public boolean mo4227a(CoordinatorLayout parent, V v, int parentWidthMeasureSpec, int widthUsed, int parentHeightMeasureSpec, int heightUsed) {
            return false;
        }

        /* renamed from: a */
        public boolean mo4226a(CoordinatorLayout parent, V v, int layoutDirection) {
            return false;
        }

        @Deprecated
        /* renamed from: b */
        public boolean mo4283b(CoordinatorLayout coordinatorLayout, V v, View directTargetChild, View target, int axes) {
            return false;
        }

        /* renamed from: b */
        public boolean mo4234b(CoordinatorLayout coordinatorLayout, V child, View directTargetChild, View target, int axes, int type) {
            if (type == 0) {
                return mo4283b(coordinatorLayout, child, directTargetChild, target, axes);
            }
            return false;
        }

        @Deprecated
        /* renamed from: a */
        public void mo4420a(CoordinatorLayout coordinatorLayout, V v, View directTargetChild, View target, int axes) {
        }

        /* renamed from: a */
        public void mo4421a(CoordinatorLayout coordinatorLayout, V child, View directTargetChild, View target, int axes, int type) {
            if (type == 0) {
                mo4420a(coordinatorLayout, child, directTargetChild, target, axes);
            }
        }

        @Deprecated
        /* renamed from: d */
        public void mo4287d(CoordinatorLayout coordinatorLayout, V v, View target) {
        }

        /* renamed from: a */
        public void mo4218a(CoordinatorLayout coordinatorLayout, V child, View target, int type) {
            if (type == 0) {
                mo4287d(coordinatorLayout, child, target);
            }
        }

        @Deprecated
        /* renamed from: a */
        public void mo4419a(CoordinatorLayout coordinatorLayout, V v, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        }

        /* renamed from: a */
        public void mo4219a(CoordinatorLayout coordinatorLayout, V child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
            if (type == 0) {
                mo4419a(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
            }
        }

        @Deprecated
        /* renamed from: a */
        public void mo4273a(CoordinatorLayout coordinatorLayout, V v, View target, int dx, int dy, int[] consumed) {
        }

        /* renamed from: a */
        public void mo4220a(CoordinatorLayout coordinatorLayout, V child, View target, int dx, int dy, int[] consumed, int type) {
            if (type == 0) {
                mo4273a(coordinatorLayout, child, target, dx, dy, consumed);
            }
        }

        /* renamed from: a */
        public boolean mo4424a(CoordinatorLayout coordinatorLayout, V v, View target, float velocityX, float velocityY, boolean consumed) {
            return false;
        }

        /* renamed from: a */
        public boolean mo4277a(CoordinatorLayout coordinatorLayout, V v, View target, float velocityX, float velocityY) {
            return false;
        }

        /* renamed from: a */
        public C0592M mo4416a(CoordinatorLayout coordinatorLayout, V v, C0592M insets) {
            return insets;
        }

        /* renamed from: a */
        public boolean mo4243a(CoordinatorLayout coordinatorLayout, V v, Rect rectangle, boolean immediate) {
            return false;
        }

        /* renamed from: a */
        public void mo4217a(CoordinatorLayout parent, V v, Parcelable state) {
        }

        /* renamed from: d */
        public Parcelable mo4238d(CoordinatorLayout parent, V v) {
            return BaseSavedState.EMPTY_STATE;
        }

        /* renamed from: a */
        public boolean mo4423a(CoordinatorLayout parent, V v, Rect rect) {
            return false;
        }
    }

    /* renamed from: android.support.design.widget.CoordinatorLayout$d */
    private class C0238d implements OnHierarchyChangeListener {
        C0238d() {
        }

        public void onChildViewAdded(View parent, View child) {
            OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.f922v;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(parent, child);
            }
        }

        public void onChildViewRemoved(View parent, View child) {
            CoordinatorLayout.this.mo4357a(2);
            OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.f922v;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(parent, child);
            }
        }
    }

    /* renamed from: android.support.design.widget.CoordinatorLayout$e */
    public static class C0239e extends MarginLayoutParams {

        /* renamed from: a */
        C0237b f927a;

        /* renamed from: b */
        boolean f928b = false;

        /* renamed from: c */
        public int f929c = 0;

        /* renamed from: d */
        public int f930d = 0;

        /* renamed from: e */
        public int f931e = -1;

        /* renamed from: f */
        int f932f = -1;

        /* renamed from: g */
        public int f933g = 0;

        /* renamed from: h */
        public int f934h = 0;

        /* renamed from: i */
        int f935i;

        /* renamed from: j */
        int f936j;

        /* renamed from: k */
        View f937k;

        /* renamed from: l */
        View f938l;

        /* renamed from: m */
        private boolean f939m;

        /* renamed from: n */
        private boolean f940n;

        /* renamed from: o */
        private boolean f941o;

        /* renamed from: p */
        private boolean f942p;

        /* renamed from: q */
        final Rect f943q = new Rect();

        /* renamed from: r */
        Object f944r;

        public C0239e(int width, int height) {
            super(width, height);
        }

        C0239e(Context context, AttributeSet attrs) {
            super(context, attrs);
            TypedArray a = context.obtainStyledAttributes(attrs, C1161c.CoordinatorLayout_Layout);
            this.f929c = a.getInteger(C1161c.CoordinatorLayout_Layout_android_layout_gravity, 0);
            this.f932f = a.getResourceId(C1161c.CoordinatorLayout_Layout_layout_anchor, -1);
            this.f930d = a.getInteger(C1161c.CoordinatorLayout_Layout_layout_anchorGravity, 0);
            this.f931e = a.getInteger(C1161c.CoordinatorLayout_Layout_layout_keyline, -1);
            this.f933g = a.getInt(C1161c.CoordinatorLayout_Layout_layout_insetEdge, 0);
            this.f934h = a.getInt(C1161c.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
            this.f928b = a.hasValue(C1161c.CoordinatorLayout_Layout_layout_behavior);
            if (this.f928b) {
                this.f927a = CoordinatorLayout.m1409a(context, attrs, a.getString(C1161c.CoordinatorLayout_Layout_layout_behavior));
            }
            a.recycle();
            C0237b bVar = this.f927a;
            if (bVar != null) {
                bVar.mo4418a(this);
            }
        }

        public C0239e(C0239e p) {
            super(p);
        }

        public C0239e(MarginLayoutParams p) {
            super(p);
        }

        public C0239e(LayoutParams p) {
            super(p);
        }

        /* renamed from: c */
        public int mo4441c() {
            return this.f932f;
        }

        /* renamed from: d */
        public C0237b mo4442d() {
            return this.f927a;
        }

        /* renamed from: a */
        public void mo4433a(C0237b behavior) {
            C0237b bVar = this.f927a;
            if (bVar != behavior) {
                if (bVar != null) {
                    bVar.mo4417a();
                }
                this.f927a = behavior;
                this.f944r = null;
                this.f928b = true;
                if (behavior != null) {
                    behavior.mo4418a(this);
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo4432a(Rect r) {
            this.f943q.set(r);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: f */
        public Rect mo4444f() {
            return this.f943q;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo4435a() {
            return this.f937k == null && this.f932f != -1;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public boolean mo4439b() {
            if (this.f927a == null) {
                this.f939m = false;
            }
            return this.f939m;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public boolean mo4440b(CoordinatorLayout parent, View child) {
            boolean z = this.f939m;
            if (z) {
                return true;
            }
            C0237b bVar = this.f927a;
            boolean a = z | (bVar != null ? bVar.mo4422a(parent, child) : false);
            this.f939m = a;
            return a;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: h */
        public void mo4446h() {
            this.f939m = false;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo4438b(int type) {
            mo4431a(type, false);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo4431a(int type, boolean accept) {
            if (type == 0) {
                this.f940n = accept;
            } else if (type == 1) {
                this.f941o = accept;
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo4436a(int type) {
            if (type == 0) {
                return this.f940n;
            }
            if (type != 1) {
                return false;
            }
            return this.f941o;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: e */
        public boolean mo4443e() {
            return this.f942p;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo4434a(boolean changed) {
            this.f942p = changed;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: g */
        public void mo4445g() {
            this.f942p = false;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo4437a(CoordinatorLayout parent, View child, View dependency) {
            if (dependency != this.f938l && !m1485a(dependency, C0646w.m2974h(parent))) {
                C0237b bVar = this.f927a;
                if (bVar == null || !bVar.mo4244a(parent, child, dependency)) {
                    return false;
                }
            }
            return true;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public View mo4430a(CoordinatorLayout parent, View forChild) {
            if (this.f932f == -1) {
                this.f938l = null;
                this.f937k = null;
                return null;
            }
            if (this.f937k == null || !m1486b(forChild, parent)) {
                m1484a(forChild, parent);
            }
            return this.f937k;
        }

        /* renamed from: a */
        private void m1484a(View forChild, CoordinatorLayout parent) {
            this.f937k = parent.findViewById(this.f932f);
            View view = this.f937k;
            if (view != null) {
                if (view != parent) {
                    View directChild = this.f937k;
                    ViewParent p = view.getParent();
                    while (p != parent && p != null) {
                        if (p != forChild) {
                            if (p instanceof View) {
                                directChild = (View) p;
                            }
                            p = p.getParent();
                        } else if (parent.isInEditMode()) {
                            this.f938l = null;
                            this.f937k = null;
                            return;
                        } else {
                            throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                        }
                    }
                    this.f938l = directChild;
                } else if (parent.isInEditMode()) {
                    this.f938l = null;
                    this.f937k = null;
                } else {
                    throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                }
            } else if (parent.isInEditMode()) {
                this.f938l = null;
                this.f937k = null;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Could not find CoordinatorLayout descendant view with id ");
                sb.append(parent.getResources().getResourceName(this.f932f));
                sb.append(" to anchor view ");
                sb.append(forChild);
                throw new IllegalStateException(sb.toString());
            }
        }

        /* renamed from: b */
        private boolean m1486b(View forChild, CoordinatorLayout parent) {
            if (this.f937k.getId() != this.f932f) {
                return false;
            }
            View directChild = this.f937k;
            for (ViewParent p = this.f937k.getParent(); p != parent; p = p.getParent()) {
                if (p == null || p == forChild) {
                    this.f938l = null;
                    this.f937k = null;
                    return false;
                }
                if (p instanceof View) {
                    directChild = (View) p;
                }
            }
            this.f938l = directChild;
            return true;
        }

        /* renamed from: a */
        private boolean m1485a(View other, int layoutDirection) {
            int absInset = C0623f.m2881a(((C0239e) other.getLayoutParams()).f933g, layoutDirection);
            return absInset != 0 && (C0623f.m2881a(this.f934h, layoutDirection) & absInset) == absInset;
        }
    }

    /* renamed from: android.support.design.widget.CoordinatorLayout$f */
    class C0240f implements OnPreDrawListener {
        C0240f() {
        }

        public boolean onPreDraw() {
            CoordinatorLayout.this.mo4357a(0);
            return true;
        }
    }

    /* renamed from: android.support.design.widget.CoordinatorLayout$g */
    static class C0241g implements Comparator<View> {
        C0241g() {
        }

        /* renamed from: a */
        public int compare(View lhs, View rhs) {
            float lz = C0646w.m2981o(lhs);
            float rz = C0646w.m2981o(rhs);
            if (lz > rz) {
                return -1;
            }
            if (lz < rz) {
                return 1;
            }
            return 0;
        }
    }

    static {
        Package pkg = CoordinatorLayout.class.getPackage();
        f901a = pkg != null ? pkg.getName() : null;
        if (VERSION.SDK_INT >= 21) {
            f904d = new C0241g();
        } else {
            f904d = null;
        }
    }

    /* renamed from: d */
    private static Rect m1423d() {
        Rect rect = (Rect) f905e.mo9148a();
        if (rect == null) {
            return new Rect();
        }
        return rect;
    }

    /* renamed from: a */
    private static void m1410a(Rect rect) {
        rect.setEmpty();
        f905e.mo9149a(rect);
    }

    public CoordinatorLayout(Context context) {
        this(context, null);
    }

    public CoordinatorLayout(Context context, AttributeSet attrs) {
        this(context, attrs, C1159a.coordinatorLayoutStyle);
    }

    public CoordinatorLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray a;
        super(context, attrs, defStyleAttr);
        this.f906f = new ArrayList();
        this.f907g = new C0705l<>();
        this.f908h = new ArrayList();
        this.f909i = new ArrayList();
        this.f910j = new int[2];
        this.f924x = new C0640q(this);
        if (defStyleAttr == 0) {
            a = context.obtainStyledAttributes(attrs, C1161c.CoordinatorLayout, 0, C1160b.Widget_Support_CoordinatorLayout);
        } else {
            a = context.obtainStyledAttributes(attrs, C1161c.CoordinatorLayout, defStyleAttr, 0);
        }
        int keylineArrayRes = a.getResourceId(C1161c.CoordinatorLayout_keylines, 0);
        if (keylineArrayRes != 0) {
            Resources res = context.getResources();
            this.f914n = res.getIntArray(keylineArrayRes);
            float density = res.getDisplayMetrics().density;
            int count = this.f914n.length;
            for (int i = 0; i < count; i++) {
                int[] iArr = this.f914n;
                iArr[i] = (int) (((float) iArr[i]) * density);
            }
        }
        this.f921u = a.getDrawable(C1161c.CoordinatorLayout_statusBarBackground);
        a.recycle();
        m1429f();
        super.setOnHierarchyChangeListener(new C0238d());
    }

    public void setOnHierarchyChangeListener(OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f922v = onHierarchyChangeListener;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m1416a(false);
        if (this.f918r) {
            if (this.f917q == null) {
                this.f917q = new C0240f();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f917q);
        }
        if (this.f919s == null && C0646w.m2972f(this)) {
            C0646w.m2991y(this);
        }
        this.f913m = true;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m1416a(false);
        if (this.f918r && this.f917q != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f917q);
        }
        View view = this.f916p;
        if (view != null) {
            onStopNestedScroll(view);
        }
        this.f913m = false;
    }

    public void setStatusBarBackground(Drawable bg) {
        Drawable drawable = this.f921u;
        if (drawable != bg) {
            Drawable drawable2 = null;
            if (drawable != null) {
                drawable.setCallback(null);
            }
            if (bg != null) {
                drawable2 = bg.mutate();
            }
            this.f921u = drawable2;
            Drawable drawable3 = this.f921u;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.f921u.setState(getDrawableState());
                }
                C1200a.m5732a(this.f921u, C0646w.m2974h(this));
                this.f921u.setVisible(getVisibility() == 0, false);
                this.f921u.setCallback(this);
            }
            C0646w.m2990x(this);
        }
    }

    public Drawable getStatusBarBackground() {
        return this.f921u;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] state = getDrawableState();
        boolean changed = false;
        Drawable d = this.f921u;
        if (d != null && d.isStateful()) {
            changed = false | d.setState(state);
        }
        if (changed) {
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable who) {
        return super.verifyDrawable(who) || who == this.f921u;
    }

    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        boolean visible = visibility == 0;
        Drawable drawable = this.f921u;
        if (drawable != null && drawable.isVisible() != visible) {
            this.f921u.setVisible(visible, false);
        }
    }

    public void setStatusBarBackgroundResource(int resId) {
        setStatusBarBackground(resId != 0 ? C0510b.m2572c(getContext(), resId) : null);
    }

    public void setStatusBarBackgroundColor(int color) {
        setStatusBarBackground(new ColorDrawable(color));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final C0592M mo4355a(C0592M insets) {
        if (C1267k.m5950a(this.f919s, insets)) {
            return insets;
        }
        this.f919s = insets;
        boolean z = true;
        this.f920t = insets != null && insets.mo5489e() > 0;
        if (this.f920t || getBackground() != null) {
            z = false;
        }
        setWillNotDraw(z);
        C0592M insets2 = m1419b(insets);
        requestLayout();
        return insets2;
    }

    public final C0592M getLastWindowInsets() {
        return this.f919s;
    }

    /* renamed from: a */
    private void m1416a(boolean notifyOnInterceptTouchEvent) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            C0237b b = ((C0239e) child.getLayoutParams()).mo4442d();
            if (b != null) {
                long now = SystemClock.uptimeMillis();
                MotionEvent cancelEvent = MotionEvent.obtain(now, now, 3, 0.0f, 0.0f, 0);
                if (notifyOnInterceptTouchEvent) {
                    b.mo4276a(this, child, cancelEvent);
                } else {
                    b.mo4282b(this, child, cancelEvent);
                }
                cancelEvent.recycle();
            }
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            ((C0239e) getChildAt(i2).getLayoutParams()).mo4446h();
        }
        this.f915o = null;
        this.f912l = false;
    }

    /* renamed from: a */
    private void m1415a(List<View> out) {
        out.clear();
        boolean useCustomOrder = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        int i = childCount - 1;
        while (i >= 0) {
            out.add(getChildAt(useCustomOrder ? getChildDrawingOrder(childCount, i) : i));
            i--;
        }
        Comparator<View> comparator = f904d;
        if (comparator != null) {
            Collections.sort(out, comparator);
        }
    }

    /* renamed from: a */
    private boolean m1417a(MotionEvent ev, int type) {
        MotionEvent motionEvent = ev;
        int i = type;
        boolean intercepted = false;
        boolean newBlock = false;
        MotionEvent cancelEvent = null;
        int action = ev.getActionMasked();
        List<View> topmostChildList = this.f908h;
        m1415a(topmostChildList);
        int childCount = topmostChildList.size();
        for (int i2 = 0; i2 < childCount; i2++) {
            View child = (View) topmostChildList.get(i2);
            C0239e lp = (C0239e) child.getLayoutParams();
            C0237b b = lp.mo4442d();
            boolean z = true;
            if ((!intercepted && !newBlock) || action == 0) {
                if (!intercepted && b != null) {
                    if (i == 0) {
                        intercepted = b.mo4276a(this, child, motionEvent);
                    } else if (i == 1) {
                        intercepted = b.mo4282b(this, child, motionEvent);
                    }
                    if (intercepted) {
                        this.f915o = child;
                    }
                }
                boolean wasBlocking = lp.mo4439b();
                boolean isBlocking = lp.mo4440b(this, child);
                if (!isBlocking || wasBlocking) {
                    z = false;
                }
                newBlock = z;
                if (isBlocking && !newBlock) {
                    break;
                }
            } else if (b != null) {
                if (cancelEvent == null) {
                    long now = SystemClock.uptimeMillis();
                    cancelEvent = MotionEvent.obtain(now, now, 3, 0.0f, 0.0f, 0);
                }
                if (i == 0) {
                    b.mo4276a(this, child, cancelEvent);
                } else if (i == 1) {
                    b.mo4282b(this, child, cancelEvent);
                }
            }
        }
        topmostChildList.clear();
        return intercepted;
    }

    public boolean onInterceptTouchEvent(MotionEvent ev) {
        MotionEvent cancelEvent = null;
        int action = ev.getActionMasked();
        if (action == 0) {
            m1416a(true);
        }
        boolean intercepted = m1417a(ev, 0);
        if (cancelEvent != null) {
            cancelEvent.recycle();
        }
        if (action == 1 || action == 3) {
            m1416a(true);
        }
        return intercepted;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0015, code lost:
        if (r6 != false) goto L_0x0017;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = 0
            r3 = 0
            r4 = 0
            int r5 = r19.getActionMasked()
            android.view.View r6 = r0.f915o
            r7 = 1
            if (r6 != 0) goto L_0x0017
            boolean r6 = r0.m1417a(r1, r7)
            r3 = r6
            if (r6 == 0) goto L_0x002b
        L_0x0017:
            android.view.View r6 = r0.f915o
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            android.support.design.widget.CoordinatorLayout$e r6 = (android.support.design.widget.CoordinatorLayout.C0239e) r6
            android.support.design.widget.CoordinatorLayout$b r8 = r6.mo4442d()
            if (r8 == 0) goto L_0x002b
            android.view.View r9 = r0.f915o
            boolean r2 = r8.mo4282b(r0, r9, r1)
        L_0x002b:
            android.view.View r6 = r0.f915o
            if (r6 != 0) goto L_0x0035
            boolean r6 = super.onTouchEvent(r19)
            r2 = r2 | r6
            goto L_0x004c
        L_0x0035:
            if (r3 == 0) goto L_0x004c
            if (r4 != 0) goto L_0x0049
            long r16 = android.os.SystemClock.uptimeMillis()
            r12 = 3
            r13 = 0
            r14 = 0
            r15 = 0
            r8 = r16
            r10 = r16
            android.view.MotionEvent r4 = android.view.MotionEvent.obtain(r8, r10, r12, r13, r14, r15)
        L_0x0049:
            super.onTouchEvent(r4)
        L_0x004c:
            if (r4 == 0) goto L_0x0052
            r4.recycle()
        L_0x0052:
            if (r5 == r7) goto L_0x0057
            r6 = 3
            if (r5 != r6) goto L_0x005b
        L_0x0057:
            r6 = 0
            r0.m1416a(r6)
        L_0x005b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        super.requestDisallowInterceptTouchEvent(disallowIntercept);
        if (disallowIntercept && !this.f912l) {
            m1416a(false);
            this.f912l = true;
        }
    }

    /* renamed from: b */
    private int m1418b(int index) {
        int[] iArr = this.f914n;
        String str = "CoordinatorLayout";
        if (iArr == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("No keylines defined for ");
            sb.append(this);
            sb.append(" - attempted index lookup ");
            sb.append(index);
            Log.e(str, sb.toString());
            return 0;
        } else if (index >= 0 && index < iArr.length) {
            return iArr[index];
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Keyline index ");
            sb2.append(index);
            sb2.append(" out of range for ");
            sb2.append(this);
            Log.e(str, sb2.toString());
            return 0;
        }
    }

    /* renamed from: a */
    static C0237b m1409a(Context context, AttributeSet attrs, String name) {
        String fullName;
        if (TextUtils.isEmpty(name)) {
            return null;
        }
        if (name.startsWith(".")) {
            StringBuilder sb = new StringBuilder();
            sb.append(context.getPackageName());
            sb.append(name);
            fullName = sb.toString();
        } else if (name.indexOf(46) >= 0) {
            fullName = name;
        } else if (!TextUtils.isEmpty(f901a)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(f901a);
            sb2.append('.');
            sb2.append(name);
            fullName = sb2.toString();
        } else {
            fullName = name;
        }
        try {
            Map map = (Map) f903c.get();
            if (map == null) {
                map = new HashMap();
                f903c.set(map);
            }
            Constructor constructor = (Constructor) map.get(fullName);
            if (constructor == null) {
                constructor = context.getClassLoader().loadClass(fullName).getConstructor(f902b);
                constructor.setAccessible(true);
                map.put(fullName, constructor);
            }
            return (C0237b) constructor.newInstance(new Object[]{context, attrs});
        } catch (Exception e) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Could not inflate Behavior subclass ");
            sb3.append(fullName);
            throw new RuntimeException(sb3.toString(), e);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public C0239e mo4378d(View child) {
        C0239e result = (C0239e) child.getLayoutParams();
        if (!result.f928b) {
            String str = "CoordinatorLayout";
            if (child instanceof C0236a) {
                C0237b attachedBehavior = ((C0236a) child).mo4415a();
                if (attachedBehavior == null) {
                    Log.e(str, "Attached behavior class is null");
                }
                result.mo4433a(attachedBehavior);
                result.f928b = true;
            } else {
                C0004c defaultBehavior = null;
                for (Class<?> childClass = child.getClass(); childClass != null; childClass = childClass.getSuperclass()) {
                    C0004c cVar = (C0004c) childClass.getAnnotation(C0004c.class);
                    defaultBehavior = cVar;
                    if (cVar != null) {
                        break;
                    }
                }
                if (defaultBehavior != null) {
                    try {
                        result.mo4433a((C0237b) defaultBehavior.value().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                    } catch (Exception e) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Default behavior class ");
                        sb.append(defaultBehavior.value().getName());
                        sb.append(" could not be instantiated. Did you forget");
                        sb.append(" a default constructor?");
                        Log.e(str, sb.toString(), e);
                    }
                }
                result.f928b = true;
            }
        }
        return result;
    }

    /* renamed from: e */
    private void m1426e() {
        this.f906f.clear();
        this.f907g.mo6009a();
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View view = getChildAt(i);
            C0239e lp = mo4378d(view);
            lp.mo4430a(this, view);
            this.f907g.mo6010a(view);
            for (int j = 0; j < count; j++) {
                if (j != i) {
                    View other = getChildAt(j);
                    if (lp.mo4437a(this, view, other)) {
                        if (!this.f907g.mo6013b(other)) {
                            this.f907g.mo6010a(other);
                        }
                        this.f907g.mo6011a(other, view);
                    }
                }
            }
        }
        this.f906f.addAll(this.f907g.mo6012b());
        Collections.reverse(this.f906f);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4364a(View descendant, Rect out) {
        C0679I.m3163a((ViewGroup) this, descendant, out);
    }

    /* access modifiers changed from: protected */
    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    /* access modifiers changed from: protected */
    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    /* renamed from: a */
    public void mo4360a(View child, int parentWidthMeasureSpec, int widthUsed, int parentHeightMeasureSpec, int heightUsed) {
        measureChildWithMargins(child, parentWidthMeasureSpec, widthUsed, parentHeightMeasureSpec, heightUsed);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x013a, code lost:
        if (r29.mo4227a(r35, r21, r26, r23, r28, 0) == false) goto L_0x014b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r36, int r37) {
        /*
            r35 = this;
            r7 = r35
            r35.m1426e()
            r35.mo4369b()
            int r8 = r35.getPaddingLeft()
            int r9 = r35.getPaddingTop()
            int r10 = r35.getPaddingRight()
            int r11 = r35.getPaddingBottom()
            int r12 = android.support.p000v4.view.C0646w.m2974h(r35)
            r0 = 1
            if (r12 != r0) goto L_0x0021
            r1 = 1
            goto L_0x0022
        L_0x0021:
            r1 = 0
        L_0x0022:
            r14 = r1
            int r15 = android.view.View.MeasureSpec.getMode(r36)
            int r16 = android.view.View.MeasureSpec.getSize(r36)
            int r6 = android.view.View.MeasureSpec.getMode(r37)
            int r17 = android.view.View.MeasureSpec.getSize(r37)
            int r18 = r8 + r10
            int r19 = r9 + r11
            int r1 = r35.getSuggestedMinimumWidth()
            int r2 = r35.getSuggestedMinimumHeight()
            r3 = 0
            android.support.v4.view.M r4 = r7.f919s
            if (r4 == 0) goto L_0x004b
            boolean r4 = android.support.p000v4.view.C0646w.m2972f(r35)
            if (r4 == 0) goto L_0x004b
            goto L_0x004c
        L_0x004b:
            r0 = 0
        L_0x004c:
            r20 = r0
            java.util.List<android.view.View> r0 = r7.f906f
            int r5 = r0.size()
            r0 = 0
            r4 = r0
            r34 = r3
            r3 = r1
            r1 = r2
            r2 = r34
        L_0x005c:
            if (r4 >= r5) goto L_0x0190
            java.util.List<android.view.View> r0 = r7.f906f
            java.lang.Object r0 = r0.get(r4)
            r21 = r0
            android.view.View r21 = (android.view.View) r21
            int r0 = r21.getVisibility()
            r13 = 8
            if (r0 != r13) goto L_0x007a
            r24 = r4
            r25 = r5
            r27 = r6
            r22 = 0
            goto L_0x0188
        L_0x007a:
            android.view.ViewGroup$LayoutParams r0 = r21.getLayoutParams()
            r13 = r0
            android.support.design.widget.CoordinatorLayout$e r13 = (android.support.design.widget.CoordinatorLayout.C0239e) r13
            r0 = 0
            r23 = r0
            int r0 = r13.f931e
            if (r0 < 0) goto L_0x00cc
            if (r15 == 0) goto L_0x00cc
            int r0 = r7.m1418b(r0)
            r24 = r1
            int r1 = r13.f929c
            int r1 = m1425e(r1)
            int r1 = android.support.p000v4.view.C0623f.m2881a(r1, r12)
            r1 = r1 & 7
            r25 = r2
            r2 = 3
            if (r1 != r2) goto L_0x00a3
            if (r14 == 0) goto L_0x00a8
        L_0x00a3:
            r2 = 5
            if (r1 != r2) goto L_0x00b5
            if (r14 == 0) goto L_0x00b5
        L_0x00a8:
            int r2 = r16 - r10
            int r2 = r2 - r0
            r27 = r3
            r3 = 0
            int r2 = java.lang.Math.max(r3, r2)
            r23 = r2
            goto L_0x00d3
        L_0x00b5:
            r27 = r3
            if (r1 != r2) goto L_0x00bb
            if (r14 == 0) goto L_0x00c0
        L_0x00bb:
            r2 = 3
            if (r1 != r2) goto L_0x00ca
            if (r14 == 0) goto L_0x00ca
        L_0x00c0:
            int r2 = r0 - r8
            r3 = 0
            int r2 = java.lang.Math.max(r3, r2)
            r23 = r2
            goto L_0x00d3
        L_0x00ca:
            r3 = 0
            goto L_0x00d3
        L_0x00cc:
            r24 = r1
            r25 = r2
            r27 = r3
            r3 = 0
        L_0x00d3:
            r0 = r36
            r1 = r37
            if (r20 == 0) goto L_0x010c
            boolean r2 = android.support.p000v4.view.C0646w.m2972f(r21)
            if (r2 != 0) goto L_0x010c
            android.support.v4.view.M r2 = r7.f919s
            int r2 = r2.mo5487c()
            android.support.v4.view.M r3 = r7.f919s
            int r3 = r3.mo5488d()
            int r2 = r2 + r3
            android.support.v4.view.M r3 = r7.f919s
            int r3 = r3.mo5489e()
            r26 = r0
            android.support.v4.view.M r0 = r7.f919s
            int r0 = r0.mo5486b()
            int r3 = r3 + r0
            int r0 = r16 - r2
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r15)
            r26 = r0
            int r0 = r17 - r3
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r6)
            r28 = r0
            goto L_0x0110
        L_0x010c:
            r26 = r0
            r28 = r1
        L_0x0110:
            android.support.design.widget.CoordinatorLayout$b r29 = r13.mo4442d()
            if (r29 == 0) goto L_0x013d
            r30 = 0
            r0 = r29
            r3 = r24
            r1 = r35
            r31 = r25
            r2 = r21
            r33 = r3
            r32 = r27
            r22 = 0
            r3 = r26
            r24 = r4
            r4 = r23
            r25 = r5
            r5 = r28
            r27 = r6
            r6 = r30
            boolean r0 = r0.mo4227a(r1, r2, r3, r4, r5, r6)
            if (r0 != 0) goto L_0x0159
            goto L_0x014b
        L_0x013d:
            r33 = r24
            r31 = r25
            r32 = r27
            r22 = 0
            r24 = r4
            r25 = r5
            r27 = r6
        L_0x014b:
            r5 = 0
            r0 = r35
            r1 = r21
            r2 = r26
            r3 = r23
            r4 = r28
            r0.mo4360a(r1, r2, r3, r4, r5)
        L_0x0159:
            int r0 = r21.getMeasuredWidth()
            int r0 = r18 + r0
            int r1 = r13.leftMargin
            int r0 = r0 + r1
            int r1 = r13.rightMargin
            int r0 = r0 + r1
            r1 = r32
            int r0 = java.lang.Math.max(r1, r0)
            int r1 = r21.getMeasuredHeight()
            int r1 = r19 + r1
            int r2 = r13.topMargin
            int r1 = r1 + r2
            int r2 = r13.bottomMargin
            int r1 = r1 + r2
            r2 = r33
            int r1 = java.lang.Math.max(r2, r1)
            int r2 = r21.getMeasuredState()
            r3 = r31
            int r2 = android.view.View.combineMeasuredStates(r3, r2)
            r3 = r0
        L_0x0188:
            int r4 = r24 + 1
            r5 = r25
            r6 = r27
            goto L_0x005c
        L_0x0190:
            r24 = r4
            r25 = r5
            r27 = r6
            r34 = r2
            r2 = r1
            r1 = r3
            r3 = r34
            r0 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r0 = r0 & r3
            r4 = r36
            int r0 = android.view.View.resolveSizeAndState(r1, r4, r0)
            int r5 = r3 << 16
            r6 = r37
            int r5 = android.view.View.resolveSizeAndState(r2, r6, r5)
            r7.setMeasuredDimension(r0, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    /* renamed from: b */
    private C0592M m1419b(C0592M insets) {
        if (insets.mo5491f()) {
            return insets;
        }
        int z = getChildCount();
        for (int i = 0; i < z; i++) {
            View child = getChildAt(i);
            if (C0646w.m2972f(child)) {
                C0237b b = ((C0239e) child.getLayoutParams()).mo4442d();
                if (b != null) {
                    insets = b.mo4416a(this, child, insets);
                    if (insets.mo5491f()) {
                        break;
                    }
                } else {
                    continue;
                }
            }
        }
        return insets;
    }

    /* renamed from: c */
    public void mo4375c(View child, int layoutDirection) {
        C0239e lp = (C0239e) child.getLayoutParams();
        if (!lp.mo4435a()) {
            View view = lp.f937k;
            if (view != null) {
                m1414a(child, view, layoutDirection);
                return;
            }
            int i = lp.f931e;
            if (i >= 0) {
                m1420b(child, i, layoutDirection);
            } else {
                m1424d(child, layoutDirection);
            }
        } else {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int l, int t, int r, int b) {
        int layoutDirection = C0646w.m2974h(this);
        int childCount = this.f906f.size();
        for (int i = 0; i < childCount; i++) {
            View child = (View) this.f906f.get(i);
            if (child.getVisibility() != 8) {
                C0237b behavior = ((C0239e) child.getLayoutParams()).mo4442d();
                if (behavior == null || !behavior.mo4226a(this, child, layoutDirection)) {
                    mo4375c(child, layoutDirection);
                }
            }
        }
    }

    public void onDraw(Canvas c) {
        super.onDraw(c);
        if (this.f920t && this.f921u != null) {
            C0592M m = this.f919s;
            int inset = m != null ? m.mo5489e() : 0;
            if (inset > 0) {
                this.f921u.setBounds(0, 0, getWidth(), inset);
                this.f921u.draw(c);
            }
        }
    }

    public void setFitsSystemWindows(boolean fitSystemWindows) {
        super.setFitsSystemWindows(fitSystemWindows);
        m1429f();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo4376c(View child, Rect r) {
        ((C0239e) child.getLayoutParams()).mo4432a(r);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo4371b(View child, Rect out) {
        out.set(((C0239e) child.getLayoutParams()).mo4444f());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4366a(View child, boolean transform, Rect out) {
        if (child.isLayoutRequested() || child.getVisibility() == 8) {
            out.setEmpty();
            return;
        }
        if (transform) {
            mo4364a(child, out);
        } else {
            out.set(child.getLeft(), child.getTop(), child.getRight(), child.getBottom());
        }
    }

    /* renamed from: a */
    private void m1412a(View child, int layoutDirection, Rect anchorRect, Rect out, C0239e lp, int childWidth, int childHeight) {
        int left;
        int top;
        int i = layoutDirection;
        Rect rect = anchorRect;
        C0239e eVar = lp;
        int absGravity = C0623f.m2881a(m1421c(eVar.f929c), i);
        int absAnchorGravity = C0623f.m2881a(m1422d(eVar.f930d), i);
        int hgrav = absGravity & 7;
        int vgrav = absGravity & 112;
        int anchorHgrav = absAnchorGravity & 7;
        int anchorVgrav = absAnchorGravity & 112;
        if (anchorHgrav == 1) {
            left = rect.left + (anchorRect.width() / 2);
        } else if (anchorHgrav != 5) {
            left = rect.left;
        } else {
            left = rect.right;
        }
        if (anchorVgrav == 16) {
            top = rect.top + (anchorRect.height() / 2);
        } else if (anchorVgrav != 80) {
            top = rect.top;
        } else {
            top = rect.bottom;
        }
        if (hgrav == 1) {
            left -= childWidth / 2;
        } else if (hgrav != 5) {
            left -= childWidth;
        }
        if (vgrav == 16) {
            top -= childHeight / 2;
        } else if (vgrav != 80) {
            top -= childHeight;
        }
        out.set(left, top, left + childWidth, top + childHeight);
    }

    /* renamed from: a */
    private void m1411a(C0239e lp, Rect out, int childWidth, int childHeight) {
        int width = getWidth();
        int height = getHeight();
        int left = Math.max(getPaddingLeft() + lp.leftMargin, Math.min(out.left, ((width - getPaddingRight()) - childWidth) - lp.rightMargin));
        int top = Math.max(getPaddingTop() + lp.topMargin, Math.min(out.top, ((height - getPaddingBottom()) - childHeight) - lp.bottomMargin));
        out.set(left, top, left + childWidth, top + childHeight);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4363a(View child, int layoutDirection, Rect anchorRect, Rect out) {
        C0239e lp = (C0239e) child.getLayoutParams();
        int childWidth = child.getMeasuredWidth();
        int childHeight = child.getMeasuredHeight();
        m1412a(child, layoutDirection, anchorRect, out, lp, childWidth, childHeight);
        m1411a(lp, out, childWidth, childHeight);
    }

    /* renamed from: a */
    private void m1414a(View child, View anchor, int layoutDirection) {
        LayoutParams layoutParams = child.getLayoutParams();
        Rect anchorRect = m1423d();
        Rect childRect = m1423d();
        try {
            mo4364a(anchor, anchorRect);
            mo4363a(child, layoutDirection, anchorRect, childRect);
            child.layout(childRect.left, childRect.top, childRect.right, childRect.bottom);
        } finally {
            m1410a(anchorRect);
            m1410a(childRect);
        }
    }

    /* renamed from: b */
    private void m1420b(View child, int keyline, int layoutDirection) {
        int keyline2;
        int i = layoutDirection;
        C0239e lp = (C0239e) child.getLayoutParams();
        int absGravity = C0623f.m2881a(m1425e(lp.f929c), i);
        int hgrav = absGravity & 7;
        int vgrav = absGravity & 112;
        int width = getWidth();
        int height = getHeight();
        int childWidth = child.getMeasuredWidth();
        int childHeight = child.getMeasuredHeight();
        if (i == 1) {
            keyline2 = width - keyline;
        } else {
            keyline2 = keyline;
        }
        int left = m1418b(keyline2) - childWidth;
        int top = 0;
        if (hgrav == 1) {
            left += childWidth / 2;
        } else if (hgrav == 5) {
            left += childWidth;
        }
        if (vgrav == 16) {
            top = 0 + (childHeight / 2);
        } else if (vgrav == 80) {
            top = 0 + childHeight;
        }
        int left2 = Math.max(getPaddingLeft() + lp.leftMargin, Math.min(left, ((width - getPaddingRight()) - childWidth) - lp.rightMargin));
        int top2 = Math.max(getPaddingTop() + lp.topMargin, Math.min(top, ((height - getPaddingBottom()) - childHeight) - lp.bottomMargin));
        child.layout(left2, top2, left2 + childWidth, top2 + childHeight);
    }

    /* renamed from: d */
    private void m1424d(View child, int layoutDirection) {
        C0239e lp = (C0239e) child.getLayoutParams();
        Rect parent = m1423d();
        parent.set(getPaddingLeft() + lp.leftMargin, getPaddingTop() + lp.topMargin, (getWidth() - getPaddingRight()) - lp.rightMargin, (getHeight() - getPaddingBottom()) - lp.bottomMargin);
        if (this.f919s != null && C0646w.m2972f(this) && !C0646w.m2972f(child)) {
            parent.left += this.f919s.mo5487c();
            parent.top += this.f919s.mo5489e();
            parent.right -= this.f919s.mo5488d();
            parent.bottom -= this.f919s.mo5486b();
        }
        Rect out = m1423d();
        C0623f.m2882a(m1422d(lp.f929c), child.getMeasuredWidth(), child.getMeasuredHeight(), parent, out, layoutDirection);
        child.layout(out.left, out.top, out.right, out.bottom);
        m1410a(parent);
        m1410a(out);
    }

    /* renamed from: d */
    private static int m1422d(int gravity) {
        if ((gravity & 7) == 0) {
            gravity |= 8388611;
        }
        if ((gravity & 112) == 0) {
            return gravity | 48;
        }
        return gravity;
    }

    /* renamed from: e */
    private static int m1425e(int gravity) {
        if (gravity == 0) {
            return 8388661;
        }
        return gravity;
    }

    /* renamed from: c */
    private static int m1421c(int gravity) {
        if (gravity == 0) {
            return 17;
        }
        return gravity;
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View child, long drawingTime) {
        C0239e lp = (C0239e) child.getLayoutParams();
        C0237b bVar = lp.f927a;
        if (bVar != null) {
            float scrimAlpha = bVar.mo4426c(this, child);
            if (scrimAlpha > 0.0f) {
                if (this.f911k == null) {
                    this.f911k = new Paint();
                }
                this.f911k.setColor(lp.f927a.mo4425b(this, child));
                this.f911k.setAlpha(C1226a.m5823a(Math.round(255.0f * scrimAlpha), 0, 255));
                int saved = canvas.save();
                if (child.isOpaque()) {
                    canvas.clipRect((float) child.getLeft(), (float) child.getTop(), (float) child.getRight(), (float) child.getBottom(), Op.DIFFERENCE);
                }
                canvas.drawRect((float) getPaddingLeft(), (float) getPaddingTop(), (float) (getWidth() - getPaddingRight()), (float) (getHeight() - getPaddingBottom()), this.f911k);
                canvas.restoreToCount(saved);
            }
        }
        return super.drawChild(canvas, child, drawingTime);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo4357a(int type) {
        boolean handled;
        int i = type;
        int layoutDirection = C0646w.m2974h(this);
        int childCount = this.f906f.size();
        Rect inset = m1423d();
        Rect drawRect = m1423d();
        Rect lastDrawRect = m1423d();
        for (int i2 = 0; i2 < childCount; i2++) {
            View child = (View) this.f906f.get(i2);
            C0239e lp = (C0239e) child.getLayoutParams();
            if (i != 0 || child.getVisibility() != 8) {
                for (int j = 0; j < i2; j++) {
                    if (lp.f938l == ((View) this.f906f.get(j))) {
                        mo4370b(child, layoutDirection);
                    }
                }
                mo4366a(child, true, drawRect);
                if (lp.f933g != 0 && !drawRect.isEmpty()) {
                    int absInsetEdge = C0623f.m2881a(lp.f933g, layoutDirection);
                    int i3 = absInsetEdge & 112;
                    if (i3 == 48) {
                        inset.top = Math.max(inset.top, drawRect.bottom);
                    } else if (i3 == 80) {
                        inset.bottom = Math.max(inset.bottom, getHeight() - drawRect.top);
                    }
                    int i4 = absInsetEdge & 7;
                    if (i4 == 3) {
                        inset.left = Math.max(inset.left, drawRect.right);
                    } else if (i4 == 5) {
                        inset.right = Math.max(inset.right, getWidth() - drawRect.left);
                    }
                }
                if (lp.f934h != 0 && child.getVisibility() == 0) {
                    m1413a(child, inset, layoutDirection);
                }
                int i5 = 2;
                if (i != 2) {
                    mo4371b(child, lastDrawRect);
                    if (!lastDrawRect.equals(drawRect)) {
                        mo4376c(child, drawRect);
                    }
                }
                int j2 = i2 + 1;
                while (j2 < childCount) {
                    View checkChild = (View) this.f906f.get(j2);
                    C0239e checkLp = (C0239e) checkChild.getLayoutParams();
                    C0237b b = checkLp.mo4442d();
                    if (b != null && b.mo4244a(this, checkChild, child)) {
                        if (i != 0 || !checkLp.mo4443e()) {
                            if (i != i5) {
                                handled = b.mo4246b(this, checkChild, child);
                            } else {
                                b.mo4427c(this, checkChild, child);
                                handled = true;
                            }
                            if (i == 1) {
                                checkLp.mo4434a(handled);
                            }
                        } else {
                            checkLp.mo4445g();
                        }
                    }
                    j2++;
                    i5 = 2;
                }
            }
        }
        m1410a(inset);
        m1410a(drawRect);
        m1410a(lastDrawRect);
    }

    /* renamed from: a */
    private void m1413a(View child, Rect inset, int layoutDirection) {
        if (C0646w.m2987u(child) && child.getWidth() > 0 && child.getHeight() > 0) {
            C0239e lp = (C0239e) child.getLayoutParams();
            C0237b behavior = lp.mo4442d();
            Rect dodgeRect = m1423d();
            Rect bounds = m1423d();
            bounds.set(child.getLeft(), child.getTop(), child.getRight(), child.getBottom());
            if (behavior == null || !behavior.mo4423a(this, child, dodgeRect)) {
                dodgeRect.set(bounds);
            } else if (!bounds.contains(dodgeRect)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Rect should be within the child's bounds. Rect:");
                sb.append(dodgeRect.toShortString());
                sb.append(" | Bounds:");
                sb.append(bounds.toShortString());
                throw new IllegalArgumentException(sb.toString());
            }
            m1410a(bounds);
            if (dodgeRect.isEmpty()) {
                m1410a(dodgeRect);
                return;
            }
            int absDodgeInsetEdges = C0623f.m2881a(lp.f934h, layoutDirection);
            boolean offsetY = false;
            if ((absDodgeInsetEdges & 48) == 48) {
                int distance = (dodgeRect.top - lp.topMargin) - lp.f936j;
                int i = inset.top;
                if (distance < i) {
                    m1430f(child, i - distance);
                    offsetY = true;
                }
            }
            if ((absDodgeInsetEdges & 80) == 80) {
                int distance2 = ((getHeight() - dodgeRect.bottom) - lp.bottomMargin) + lp.f936j;
                int i2 = inset.bottom;
                if (distance2 < i2) {
                    m1430f(child, distance2 - i2);
                    offsetY = true;
                }
            }
            if (!offsetY) {
                m1430f(child, 0);
            }
            boolean offsetX = false;
            if ((absDodgeInsetEdges & 3) == 3) {
                int distance3 = (dodgeRect.left - lp.leftMargin) - lp.f935i;
                int i3 = inset.left;
                if (distance3 < i3) {
                    m1427e(child, i3 - distance3);
                    offsetX = true;
                }
            }
            if ((absDodgeInsetEdges & 5) == 5) {
                int distance4 = ((getWidth() - dodgeRect.right) - lp.rightMargin) + lp.f935i;
                int i4 = inset.right;
                if (distance4 < i4) {
                    m1427e(child, distance4 - i4);
                    offsetX = true;
                }
            }
            if (!offsetX) {
                m1427e(child, 0);
            }
            m1410a(dodgeRect);
        }
    }

    /* renamed from: e */
    private void m1427e(View child, int offsetX) {
        C0239e lp = (C0239e) child.getLayoutParams();
        int i = lp.f935i;
        if (i != offsetX) {
            C0646w.m2948a(child, offsetX - i);
            lp.f935i = offsetX;
        }
    }

    /* renamed from: f */
    private void m1430f(View child, int offsetY) {
        C0239e lp = (C0239e) child.getLayoutParams();
        int i = lp.f936j;
        if (i != offsetY) {
            C0646w.m2965b(child, offsetY - i);
            lp.f936j = offsetY;
        }
    }

    /* renamed from: a */
    public void mo4358a(View view) {
        List<View> dependents = this.f907g.mo6014c(view);
        if (dependents != null && !dependents.isEmpty()) {
            for (int i = 0; i < dependents.size(); i++) {
                View child = (View) dependents.get(i);
                C0237b b = ((C0239e) child.getLayoutParams()).mo4442d();
                if (b != null) {
                    b.mo4246b(this, child, view);
                }
            }
        }
    }

    /* renamed from: b */
    public List<View> mo4368b(View child) {
        List<View> dependencies = this.f907g.mo6015d(child);
        this.f909i.clear();
        if (dependencies != null) {
            this.f909i.addAll(dependencies);
        }
        return this.f909i;
    }

    /* renamed from: c */
    public List<View> mo4373c(View child) {
        List<View> edges = this.f907g.mo6014c(child);
        this.f909i.clear();
        if (edges != null) {
            this.f909i.addAll(edges);
        }
        return this.f909i;
    }

    /* access modifiers changed from: 0000 */
    public final List<View> getDependencySortedChildren() {
        m1426e();
        return Collections.unmodifiableList(this.f906f);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo4369b() {
        boolean hasDependencies = false;
        int childCount = getChildCount();
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            } else if (m1428e(getChildAt(i))) {
                hasDependencies = true;
                break;
            } else {
                i++;
            }
        }
        if (hasDependencies == this.f918r) {
            return;
        }
        if (hasDependencies) {
            mo4356a();
        } else {
            mo4374c();
        }
    }

    /* renamed from: e */
    private boolean m1428e(View child) {
        return this.f907g.mo6016e(child);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4356a() {
        if (this.f913m) {
            if (this.f917q == null) {
                this.f917q = new C0240f();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f917q);
        }
        this.f918r = true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo4374c() {
        if (this.f913m && this.f917q != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f917q);
        }
        this.f918r = false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo4370b(View child, int layoutDirection) {
        View view = child;
        C0239e lp = (C0239e) child.getLayoutParams();
        if (lp.f937k != null) {
            Rect anchorRect = m1423d();
            Rect childRect = m1423d();
            Rect desiredChildRect = m1423d();
            mo4364a(lp.f937k, anchorRect);
            boolean z = false;
            mo4366a(view, false, childRect);
            int childWidth = child.getMeasuredWidth();
            int childHeight = child.getMeasuredHeight();
            int childHeight2 = childHeight;
            m1412a(child, layoutDirection, anchorRect, desiredChildRect, lp, childWidth, childHeight);
            if (!(desiredChildRect.left == childRect.left && desiredChildRect.top == childRect.top)) {
                z = true;
            }
            boolean changed = z;
            m1411a(lp, desiredChildRect, childWidth, childHeight2);
            int dx = desiredChildRect.left - childRect.left;
            int dy = desiredChildRect.top - childRect.top;
            if (dx != 0) {
                C0646w.m2948a(view, dx);
            }
            if (dy != 0) {
                C0646w.m2965b(view, dy);
            }
            if (changed) {
                C0237b b = lp.mo4442d();
                if (b != null) {
                    b.mo4246b(this, view, lp.f937k);
                }
            }
            m1410a(anchorRect);
            m1410a(childRect);
            m1410a(desiredChildRect);
        }
    }

    /* renamed from: a */
    public boolean mo4367a(View child, int x, int y) {
        Rect r = m1423d();
        mo4364a(child, r);
        try {
            return r.contains(x, y);
        } finally {
            m1410a(r);
        }
    }

    public C0239e generateLayoutParams(AttributeSet attrs) {
        return new C0239e(getContext(), attrs);
    }

    /* access modifiers changed from: protected */
    public C0239e generateLayoutParams(LayoutParams p) {
        if (p instanceof C0239e) {
            return new C0239e((C0239e) p);
        }
        if (p instanceof MarginLayoutParams) {
            return new C0239e((MarginLayoutParams) p);
        }
        return new C0239e(p);
    }

    /* access modifiers changed from: protected */
    public C0239e generateDefaultLayoutParams() {
        return new C0239e(-2, -2);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(LayoutParams p) {
        return (p instanceof C0239e) && super.checkLayoutParams(p);
    }

    public boolean onStartNestedScroll(View child, View target, int nestedScrollAxes) {
        return mo4372b(child, target, nestedScrollAxes, 0);
    }

    /* renamed from: b */
    public boolean mo4372b(View child, View target, int axes, int type) {
        int i = type;
        int childCount = getChildCount();
        boolean handled = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            View view = getChildAt(i2);
            if (view.getVisibility() != 8) {
                C0239e lp = (C0239e) view.getLayoutParams();
                C0237b viewBehavior = lp.mo4442d();
                if (viewBehavior != null) {
                    boolean accepted = viewBehavior.mo4234b(this, view, child, target, axes, type);
                    boolean handled2 = handled | accepted;
                    lp.mo4431a(i, accepted);
                    handled = handled2;
                } else {
                    lp.mo4431a(i, false);
                }
            }
        }
        return handled;
    }

    public void onNestedScrollAccepted(View child, View target, int nestedScrollAxes) {
        mo4365a(child, target, nestedScrollAxes, 0);
    }

    /* renamed from: a */
    public void mo4365a(View child, View target, int nestedScrollAxes, int type) {
        View view = target;
        int i = type;
        this.f924x.mo5687a(child, view, nestedScrollAxes, i);
        this.f916p = view;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View view2 = getChildAt(i2);
            C0239e lp = (C0239e) view2.getLayoutParams();
            if (lp.mo4436a(i)) {
                C0237b viewBehavior = lp.mo4442d();
                if (viewBehavior != null) {
                    viewBehavior.mo4421a(this, view2, child, target, nestedScrollAxes, type);
                }
            }
        }
    }

    public void onStopNestedScroll(View target) {
        mo4359a(target, 0);
    }

    /* renamed from: a */
    public void mo4359a(View target, int type) {
        this.f924x.mo5685a(target, type);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View view = getChildAt(i);
            C0239e lp = (C0239e) view.getLayoutParams();
            if (lp.mo4436a(type)) {
                C0237b viewBehavior = lp.mo4442d();
                if (viewBehavior != null) {
                    viewBehavior.mo4218a(this, view, target, type);
                }
                lp.mo4438b(type);
                lp.mo4445g();
            }
        }
        this.f916p = null;
    }

    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        mo4361a(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, 0);
    }

    /* renamed from: a */
    public void mo4361a(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        int childCount = getChildCount();
        boolean accepted = false;
        for (int i = 0; i < childCount; i++) {
            View view = getChildAt(i);
            if (view.getVisibility() == 8) {
                int i2 = type;
            } else {
                C0239e lp = (C0239e) view.getLayoutParams();
                if (lp.mo4436a(type)) {
                    C0237b viewBehavior = lp.mo4442d();
                    if (viewBehavior != null) {
                        viewBehavior.mo4219a(this, view, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type);
                        accepted = true;
                    }
                }
            }
        }
        int i3 = type;
        if (accepted) {
            mo4357a(1);
        }
    }

    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {
        mo4362a(target, dx, dy, consumed, 0);
    }

    /* renamed from: a */
    public void mo4362a(View target, int dx, int dy, int[] consumed, int type) {
        int xConsumed;
        int yConsumed;
        int childCount = getChildCount();
        int xConsumed2 = 0;
        int yConsumed2 = 0;
        boolean accepted = false;
        for (int i = 0; i < childCount; i++) {
            View view = getChildAt(i);
            if (view.getVisibility() != 8) {
                C0239e lp = (C0239e) view.getLayoutParams();
                if (lp.mo4436a(type)) {
                    C0237b viewBehavior = lp.mo4442d();
                    if (viewBehavior != null) {
                        int[] iArr = this.f910j;
                        iArr[1] = 0;
                        iArr[0] = 0;
                        int[] iArr2 = iArr;
                        C0239e eVar = lp;
                        viewBehavior.mo4220a(this, view, target, dx, dy, iArr2, type);
                        if (dx > 0) {
                            xConsumed = Math.max(xConsumed2, this.f910j[0]);
                        } else {
                            xConsumed = Math.min(xConsumed2, this.f910j[0]);
                        }
                        if (dy > 0) {
                            yConsumed = Math.max(yConsumed2, this.f910j[1]);
                        } else {
                            yConsumed = Math.min(yConsumed2, this.f910j[1]);
                        }
                        xConsumed2 = xConsumed;
                        yConsumed2 = yConsumed;
                        accepted = true;
                    }
                }
            }
        }
        consumed[0] = xConsumed2;
        consumed[1] = yConsumed2;
        if (accepted) {
            mo4357a(1);
        }
    }

    public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed) {
        int childCount = getChildCount();
        boolean handled = false;
        for (int i = 0; i < childCount; i++) {
            View view = getChildAt(i);
            if (view.getVisibility() != 8) {
                C0239e lp = (C0239e) view.getLayoutParams();
                if (lp.mo4436a(0)) {
                    C0237b viewBehavior = lp.mo4442d();
                    if (viewBehavior != null) {
                        handled = viewBehavior.mo4424a(this, view, target, velocityX, velocityY, consumed) | handled;
                    }
                }
            }
        }
        if (handled) {
            mo4357a(1);
        }
        return handled;
    }

    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        boolean handled = false;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View view = getChildAt(i);
            if (view.getVisibility() != 8) {
                C0239e lp = (C0239e) view.getLayoutParams();
                if (lp.mo4436a(0)) {
                    C0237b viewBehavior = lp.mo4442d();
                    if (viewBehavior != null) {
                        handled |= viewBehavior.mo4277a(this, view, target, velocityX, velocityY);
                    }
                }
            }
        }
        return handled;
    }

    public int getNestedScrollAxes() {
        return this.f924x.mo5683a();
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable state) {
        if (!(state instanceof SavedState)) {
            super.onRestoreInstanceState(state);
            return;
        }
        SavedState ss = (SavedState) state;
        super.onRestoreInstanceState(ss.mo5452a());
        SparseArray<Parcelable> behaviorStates = ss.f925c;
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            int childId = child.getId();
            C0237b b = mo4378d(child).mo4442d();
            if (!(childId == -1 || b == null)) {
                Parcelable savedState = (Parcelable) behaviorStates.get(childId);
                if (savedState != null) {
                    b.mo4217a(this, child, savedState);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState ss = new SavedState(super.onSaveInstanceState());
        SparseArray<Parcelable> behaviorStates = new SparseArray<>();
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            int childId = child.getId();
            C0237b b = ((C0239e) child.getLayoutParams()).mo4442d();
            if (!(childId == -1 || b == null)) {
                Parcelable state = b.mo4238d(this, child);
                if (state != null) {
                    behaviorStates.append(childId, state);
                }
            }
        }
        ss.f925c = behaviorStates;
        return ss;
    }

    public boolean requestChildRectangleOnScreen(View child, Rect rectangle, boolean immediate) {
        C0237b behavior = ((C0239e) child.getLayoutParams()).mo4442d();
        if (behavior == null || !behavior.mo4243a(this, child, rectangle, immediate)) {
            return super.requestChildRectangleOnScreen(child, rectangle, immediate);
        }
        return true;
    }

    /* renamed from: f */
    private void m1429f() {
        if (VERSION.SDK_INT >= 21) {
            if (C0646w.m2972f(this)) {
                if (this.f923w == null) {
                    this.f923w = new C0242D(this);
                }
                C0646w.m2956a((View) this, this.f923w);
                setSystemUiVisibility(1280);
            } else {
                C0646w.m2956a((View) this, (C0641r) null);
            }
        }
    }
}
