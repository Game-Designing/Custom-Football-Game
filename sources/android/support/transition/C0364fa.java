package android.support.transition;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.p000v4.view.C0646w;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* renamed from: android.support.transition.fa */
/* compiled from: ViewOverlayApi14 */
class C0364fa implements C0369ha {

    /* renamed from: a */
    protected C0365a f1237a;

    /* renamed from: android.support.transition.fa$a */
    /* compiled from: ViewOverlayApi14 */
    static class C0365a extends ViewGroup {

        /* renamed from: a */
        static Method f1238a;

        /* renamed from: b */
        ViewGroup f1239b;

        /* renamed from: c */
        View f1240c;

        /* renamed from: d */
        ArrayList<Drawable> f1241d = null;

        /* renamed from: e */
        C0364fa f1242e;

        static {
            try {
                f1238a = ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", new Class[]{Integer.TYPE, Integer.TYPE, Rect.class});
            } catch (NoSuchMethodException e) {
            }
        }

        C0365a(Context context, ViewGroup hostView, View requestingView, C0364fa viewOverlay) {
            super(context);
            this.f1239b = hostView;
            this.f1240c = requestingView;
            setRight(hostView.getWidth());
            setBottom(hostView.getHeight());
            hostView.addView(this);
            this.f1242e = viewOverlay;
        }

        public boolean dispatchTouchEvent(MotionEvent ev) {
            return false;
        }

        /* renamed from: a */
        public void mo4814a(Drawable drawable) {
            if (this.f1241d == null) {
                this.f1241d = new ArrayList<>();
            }
            if (!this.f1241d.contains(drawable)) {
                this.f1241d.add(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback(this);
            }
        }

        /* renamed from: b */
        public void mo4817b(Drawable drawable) {
            ArrayList<Drawable> arrayList = this.f1241d;
            if (arrayList != null) {
                arrayList.remove(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback(null);
            }
        }

        /* access modifiers changed from: protected */
        public boolean verifyDrawable(Drawable who) {
            if (!super.verifyDrawable(who)) {
                ArrayList<Drawable> arrayList = this.f1241d;
                if (arrayList == null || !arrayList.contains(who)) {
                    return false;
                }
            }
            return true;
        }

        /* renamed from: a */
        public void mo4815a(View child) {
            if (child.getParent() instanceof ViewGroup) {
                ViewGroup parent = (ViewGroup) child.getParent();
                if (!(parent == this.f1239b || parent.getParent() == null || !C0646w.m2986t(parent))) {
                    int[] parentLocation = new int[2];
                    int[] hostViewLocation = new int[2];
                    parent.getLocationOnScreen(parentLocation);
                    this.f1239b.getLocationOnScreen(hostViewLocation);
                    C0646w.m2948a(child, parentLocation[0] - hostViewLocation[0]);
                    C0646w.m2965b(child, parentLocation[1] - hostViewLocation[1]);
                }
                parent.removeView(child);
                if (child.getParent() != null) {
                    parent.removeView(child);
                }
            }
            super.addView(child, getChildCount() - 1);
        }

        /* renamed from: b */
        public void mo4818b(View view) {
            super.removeView(view);
            if (mo4816a()) {
                this.f1239b.removeView(this);
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo4816a() {
            if (getChildCount() == 0) {
                ArrayList<Drawable> arrayList = this.f1241d;
                if (arrayList == null || arrayList.size() == 0) {
                    return true;
                }
            }
            return false;
        }

        public void invalidateDrawable(Drawable drawable) {
            invalidate(drawable.getBounds());
        }

        /* access modifiers changed from: protected */
        public void dispatchDraw(Canvas canvas) {
            int[] contentViewLocation = new int[2];
            int[] hostViewLocation = new int[2];
            this.f1239b.getLocationOnScreen(contentViewLocation);
            this.f1240c.getLocationOnScreen(hostViewLocation);
            int numDrawables = 0;
            canvas.translate((float) (hostViewLocation[0] - contentViewLocation[0]), (float) (hostViewLocation[1] - contentViewLocation[1]));
            canvas.clipRect(new Rect(0, 0, this.f1240c.getWidth(), this.f1240c.getHeight()));
            super.dispatchDraw(canvas);
            ArrayList<Drawable> arrayList = this.f1241d;
            if (arrayList != null) {
                numDrawables = arrayList.size();
            }
            for (int i = 0; i < numDrawables; i++) {
                ((Drawable) this.f1241d.get(i)).draw(canvas);
            }
        }

        /* access modifiers changed from: protected */
        public void onLayout(boolean changed, int l, int t, int r, int b) {
        }

        /* renamed from: a */
        private void m1905a(int[] offset) {
            int[] contentViewLocation = new int[2];
            int[] hostViewLocation = new int[2];
            this.f1239b.getLocationOnScreen(contentViewLocation);
            this.f1240c.getLocationOnScreen(hostViewLocation);
            offset[0] = hostViewLocation[0] - contentViewLocation[0];
            offset[1] = hostViewLocation[1] - contentViewLocation[1];
        }

        public ViewParent invalidateChildInParent(int[] location, Rect dirty) {
            if (this.f1239b != null) {
                dirty.offset(location[0], location[1]);
                if (this.f1239b instanceof ViewGroup) {
                    location[0] = 0;
                    location[1] = 0;
                    int[] offset = new int[2];
                    m1905a(offset);
                    dirty.offset(offset[0], offset[1]);
                    return super.invalidateChildInParent(location, dirty);
                }
                invalidate(dirty);
            }
            return null;
        }
    }

    C0364fa(Context context, ViewGroup hostView, View requestingView) {
        this.f1237a = new C0365a(context, hostView, requestingView, this);
    }

    /* renamed from: d */
    static ViewGroup m1902d(View view) {
        View parent = view;
        while (parent != null) {
            if (parent.getId() == 16908290 && (parent instanceof ViewGroup)) {
                return (ViewGroup) parent;
            }
            if (parent.getParent() instanceof ViewGroup) {
                parent = (ViewGroup) parent.getParent();
            }
        }
        return null;
    }

    /* renamed from: c */
    static C0364fa m1901c(View view) {
        ViewGroup contentView = m1902d(view);
        if (contentView == null) {
            return null;
        }
        int numChildren = contentView.getChildCount();
        for (int i = 0; i < numChildren; i++) {
            View child = contentView.getChildAt(i);
            if (child instanceof C0365a) {
                return ((C0365a) child).f1242e;
            }
        }
        return new C0349X(contentView.getContext(), contentView, view);
    }

    /* renamed from: a */
    public void mo4803a(Drawable drawable) {
        this.f1237a.mo4814a(drawable);
    }

    /* renamed from: b */
    public void mo4804b(Drawable drawable) {
        this.f1237a.mo4817b(drawable);
    }
}
