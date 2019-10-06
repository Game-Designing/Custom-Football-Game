package android.support.p001v7.widget;

import android.support.p000v4.view.C0646w;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnHoverListener;
import android.view.View.OnLongClickListener;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;

/* renamed from: android.support.v7.widget.Db */
/* compiled from: TooltipCompatHandler */
class C0924Db implements OnLongClickListener, OnHoverListener, OnAttachStateChangeListener {

    /* renamed from: a */
    private static C0924Db f2951a;

    /* renamed from: b */
    private static C0924Db f2952b;

    /* renamed from: c */
    private final View f2953c;

    /* renamed from: d */
    private final CharSequence f2954d;

    /* renamed from: e */
    private final Runnable f2955e = new C0917Bb(this);

    /* renamed from: f */
    private final Runnable f2956f = new C0920Cb(this);

    /* renamed from: g */
    private int f2957g;

    /* renamed from: h */
    private int f2958h;

    /* renamed from: i */
    private C0927Eb f2959i;

    /* renamed from: j */
    private boolean f2960j;

    /* renamed from: a */
    public static void m4432a(View view, CharSequence tooltipText) {
        C0924Db db = f2951a;
        if (db != null && db.f2953c == view) {
            m4435b(null);
        }
        if (TextUtils.isEmpty(tooltipText)) {
            C0924Db db2 = f2952b;
            if (db2 != null && db2.f2953c == view) {
                db2.m4434b();
            }
            view.setOnLongClickListener(null);
            view.setLongClickable(false);
            view.setOnHoverListener(null);
            return;
        }
        new C0924Db(view, tooltipText);
    }

    private C0924Db(View anchor, CharSequence tooltipText) {
        this.f2953c = anchor;
        this.f2954d = tooltipText;
        this.f2953c.setOnLongClickListener(this);
        this.f2953c.setOnHoverListener(this);
    }

    public boolean onLongClick(View v) {
        this.f2957g = v.getWidth() / 2;
        this.f2958h = v.getHeight() / 2;
        m4433a(true);
        return true;
    }

    public boolean onHover(View v, MotionEvent event) {
        if (this.f2959i != null && this.f2960j) {
            return false;
        }
        AccessibilityManager manager = (AccessibilityManager) this.f2953c.getContext().getSystemService("accessibility");
        if (manager.isEnabled() && manager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = event.getAction();
        if (action != 7) {
            if (action == 10) {
                m4434b();
            }
        } else if (this.f2953c.isEnabled() && this.f2959i == null) {
            this.f2957g = (int) event.getX();
            this.f2958h = (int) event.getY();
            m4435b(this);
        }
        return false;
    }

    public void onViewAttachedToWindow(View v) {
    }

    public void onViewDetachedFromWindow(View v) {
        m4434b();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m4433a(boolean fromTouch) {
        long timeout;
        if (C0646w.m2986t(this.f2953c)) {
            m4435b(null);
            C0924Db db = f2952b;
            if (db != null) {
                db.m4434b();
            }
            f2952b = this;
            this.f2960j = fromTouch;
            this.f2959i = new C0927Eb(this.f2953c.getContext());
            this.f2959i.mo7194a(this.f2953c, this.f2957g, this.f2958h, this.f2960j, this.f2954d);
            this.f2953c.addOnAttachStateChangeListener(this);
            if (this.f2960j) {
                timeout = 2500;
            } else if ((C0646w.m2980n(this.f2953c) & 1) == 1) {
                timeout = 3000 - ((long) ViewConfiguration.getLongPressTimeout());
            } else {
                timeout = 15000 - ((long) ViewConfiguration.getLongPressTimeout());
            }
            this.f2953c.removeCallbacks(this.f2956f);
            this.f2953c.postDelayed(this.f2956f, timeout);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m4434b() {
        if (f2952b == this) {
            f2952b = null;
            C0927Eb eb = this.f2959i;
            if (eb != null) {
                eb.mo7193a();
                this.f2959i = null;
                this.f2953c.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f2951a == this) {
            m4435b(null);
        }
        this.f2953c.removeCallbacks(this.f2956f);
    }

    /* renamed from: b */
    private static void m4435b(C0924Db handler) {
        C0924Db db = f2951a;
        if (db != null) {
            db.m4429a();
        }
        f2951a = handler;
        C0924Db db2 = f2951a;
        if (db2 != null) {
            db2.m4436c();
        }
    }

    /* renamed from: c */
    private void m4436c() {
        this.f2953c.postDelayed(this.f2955e, (long) ViewConfiguration.getLongPressTimeout());
    }

    /* renamed from: a */
    private void m4429a() {
        this.f2953c.removeCallbacks(this.f2955e);
    }
}
