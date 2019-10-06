package android.support.p000v4.view;

import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;

/* renamed from: android.support.v4.view.F */
/* compiled from: ViewParentCompat */
public final class C0581F {

    /* renamed from: a */
    static final C0584c f1796a;

    /* renamed from: android.support.v4.view.F$a */
    /* compiled from: ViewParentCompat */
    static class C0582a extends C0584c {
        C0582a() {
        }
    }

    /* renamed from: android.support.v4.view.F$b */
    /* compiled from: ViewParentCompat */
    static class C0583b extends C0582a {
        C0583b() {
        }

        /* renamed from: b */
        public boolean mo5465b(ViewParent parent, View child, View target, int nestedScrollAxes) {
            try {
                return parent.onStartNestedScroll(child, target, nestedScrollAxes);
            } catch (AbstractMethodError e) {
                StringBuilder sb = new StringBuilder();
                sb.append("ViewParent ");
                sb.append(parent);
                sb.append(" does not implement interface ");
                sb.append("method onStartNestedScroll");
                Log.e("ViewParentCompat", sb.toString(), e);
                return false;
            }
        }

        /* renamed from: a */
        public void mo5462a(ViewParent parent, View child, View target, int nestedScrollAxes) {
            try {
                parent.onNestedScrollAccepted(child, target, nestedScrollAxes);
            } catch (AbstractMethodError e) {
                StringBuilder sb = new StringBuilder();
                sb.append("ViewParent ");
                sb.append(parent);
                sb.append(" does not implement interface ");
                sb.append("method onNestedScrollAccepted");
                Log.e("ViewParentCompat", sb.toString(), e);
            }
        }

        /* renamed from: a */
        public void mo5459a(ViewParent parent, View target) {
            try {
                parent.onStopNestedScroll(target);
            } catch (AbstractMethodError e) {
                StringBuilder sb = new StringBuilder();
                sb.append("ViewParent ");
                sb.append(parent);
                sb.append(" does not implement interface ");
                sb.append("method onStopNestedScroll");
                Log.e("ViewParentCompat", sb.toString(), e);
            }
        }

        /* renamed from: a */
        public void mo5460a(ViewParent parent, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
            try {
                parent.onNestedScroll(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
            } catch (AbstractMethodError e) {
                StringBuilder sb = new StringBuilder();
                sb.append("ViewParent ");
                sb.append(parent);
                sb.append(" does not implement interface ");
                sb.append("method onNestedScroll");
                Log.e("ViewParentCompat", sb.toString(), e);
            }
        }

        /* renamed from: a */
        public void mo5461a(ViewParent parent, View target, int dx, int dy, int[] consumed) {
            try {
                parent.onNestedPreScroll(target, dx, dy, consumed);
            } catch (AbstractMethodError e) {
                StringBuilder sb = new StringBuilder();
                sb.append("ViewParent ");
                sb.append(parent);
                sb.append(" does not implement interface ");
                sb.append("method onNestedPreScroll");
                Log.e("ViewParentCompat", sb.toString(), e);
            }
        }

        /* renamed from: a */
        public boolean mo5464a(ViewParent parent, View target, float velocityX, float velocityY, boolean consumed) {
            try {
                return parent.onNestedFling(target, velocityX, velocityY, consumed);
            } catch (AbstractMethodError e) {
                StringBuilder sb = new StringBuilder();
                sb.append("ViewParent ");
                sb.append(parent);
                sb.append(" does not implement interface ");
                sb.append("method onNestedFling");
                Log.e("ViewParentCompat", sb.toString(), e);
                return false;
            }
        }

        /* renamed from: a */
        public boolean mo5463a(ViewParent parent, View target, float velocityX, float velocityY) {
            try {
                return parent.onNestedPreFling(target, velocityX, velocityY);
            } catch (AbstractMethodError e) {
                StringBuilder sb = new StringBuilder();
                sb.append("ViewParent ");
                sb.append(parent);
                sb.append(" does not implement interface ");
                sb.append("method onNestedPreFling");
                Log.e("ViewParentCompat", sb.toString(), e);
                return false;
            }
        }
    }

    /* renamed from: android.support.v4.view.F$c */
    /* compiled from: ViewParentCompat */
    static class C0584c {
        C0584c() {
        }

        /* renamed from: b */
        public boolean mo5465b(ViewParent parent, View child, View target, int nestedScrollAxes) {
            if (parent instanceof C0639p) {
                return ((C0639p) parent).onStartNestedScroll(child, target, nestedScrollAxes);
            }
            return false;
        }

        /* renamed from: a */
        public void mo5462a(ViewParent parent, View child, View target, int nestedScrollAxes) {
            if (parent instanceof C0639p) {
                ((C0639p) parent).onNestedScrollAccepted(child, target, nestedScrollAxes);
            }
        }

        /* renamed from: a */
        public void mo5459a(ViewParent parent, View target) {
            if (parent instanceof C0639p) {
                ((C0639p) parent).onStopNestedScroll(target);
            }
        }

        /* renamed from: a */
        public void mo5460a(ViewParent parent, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
            if (parent instanceof C0639p) {
                ((C0639p) parent).onNestedScroll(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
            }
        }

        /* renamed from: a */
        public void mo5461a(ViewParent parent, View target, int dx, int dy, int[] consumed) {
            if (parent instanceof C0639p) {
                ((C0639p) parent).onNestedPreScroll(target, dx, dy, consumed);
            }
        }

        /* renamed from: a */
        public boolean mo5464a(ViewParent parent, View target, float velocityX, float velocityY, boolean consumed) {
            if (parent instanceof C0639p) {
                return ((C0639p) parent).onNestedFling(target, velocityX, velocityY, consumed);
            }
            return false;
        }

        /* renamed from: a */
        public boolean mo5463a(ViewParent parent, View target, float velocityX, float velocityY) {
            if (parent instanceof C0639p) {
                return ((C0639p) parent).onNestedPreFling(target, velocityX, velocityY);
            }
            return false;
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            f1796a = new C0583b();
        } else if (i >= 19) {
            f1796a = new C0582a();
        } else {
            f1796a = new C0584c();
        }
    }

    /* renamed from: b */
    public static boolean m2765b(ViewParent parent, View child, View target, int nestedScrollAxes, int type) {
        if (parent instanceof C0638o) {
            return ((C0638o) parent).mo4372b(child, target, nestedScrollAxes, type);
        }
        if (type == 0) {
            return f1796a.mo5465b(parent, child, target, nestedScrollAxes);
        }
        return false;
    }

    /* renamed from: a */
    public static void m2762a(ViewParent parent, View child, View target, int nestedScrollAxes, int type) {
        if (parent instanceof C0638o) {
            ((C0638o) parent).mo4365a(child, target, nestedScrollAxes, type);
        } else if (type == 0) {
            f1796a.mo5462a(parent, child, target, nestedScrollAxes);
        }
    }

    /* renamed from: a */
    public static void m2759a(ViewParent parent, View target, int type) {
        if (parent instanceof C0638o) {
            ((C0638o) parent).mo4359a(target, type);
        } else if (type == 0) {
            f1796a.mo5459a(parent, target);
        }
    }

    /* renamed from: a */
    public static void m2760a(ViewParent parent, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        if (parent instanceof C0638o) {
            ((C0638o) parent).mo4361a(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type);
        } else if (type == 0) {
            f1796a.mo5460a(parent, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
        }
    }

    /* renamed from: a */
    public static void m2761a(ViewParent parent, View target, int dx, int dy, int[] consumed, int type) {
        if (parent instanceof C0638o) {
            ((C0638o) parent).mo4362a(target, dx, dy, consumed, type);
        } else if (type == 0) {
            f1796a.mo5461a(parent, target, dx, dy, consumed);
        }
    }

    /* renamed from: a */
    public static boolean m2764a(ViewParent parent, View target, float velocityX, float velocityY, boolean consumed) {
        return f1796a.mo5464a(parent, target, velocityX, velocityY, consumed);
    }

    /* renamed from: a */
    public static boolean m2763a(ViewParent parent, View target, float velocityX, float velocityY) {
        return f1796a.mo5463a(parent, target, velocityX, velocityY);
    }
}
