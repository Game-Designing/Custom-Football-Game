package android.support.p001v7.app;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p001v7.view.menu.C0873l;
import android.support.p001v7.widget.C1112sb;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import android.view.Window.Callback;
import p002b.p003c.p062h.p071g.C1307g;
import p002b.p003c.p062h.p071g.C1312j;

/* renamed from: android.support.v7.app.r */
/* compiled from: AppCompatDelegateImplBase */
abstract class C0778r extends C0776p {

    /* renamed from: c */
    private static boolean f2344c = true;

    /* renamed from: d */
    private static final boolean f2345d = (VERSION.SDK_INT < 21);

    /* renamed from: e */
    private static final int[] f2346e = {16842836};

    /* renamed from: f */
    final Context f2347f;

    /* renamed from: g */
    final Window f2348g;

    /* renamed from: h */
    final Callback f2349h = this.f2348g.getCallback();

    /* renamed from: i */
    final Callback f2350i;

    /* renamed from: j */
    final C0020o f2351j;

    /* renamed from: k */
    C0760a f2352k;

    /* renamed from: l */
    MenuInflater f2353l;

    /* renamed from: m */
    boolean f2354m;

    /* renamed from: n */
    boolean f2355n;

    /* renamed from: o */
    boolean f2356o;

    /* renamed from: p */
    boolean f2357p;

    /* renamed from: q */
    boolean f2358q;

    /* renamed from: r */
    private CharSequence f2359r;

    /* renamed from: s */
    private boolean f2360s;

    /* renamed from: t */
    private boolean f2361t;

    /* renamed from: android.support.v7.app.r$a */
    /* compiled from: AppCompatDelegateImplBase */
    private class C0779a implements C0764b {
        C0779a() {
        }
    }

    /* renamed from: android.support.v7.app.r$b */
    /* compiled from: AppCompatDelegateImplBase */
    class C0780b extends C1312j {
        C0780b(Callback callback) {
            super(callback);
        }

        public boolean dispatchKeyEvent(KeyEvent event) {
            return C0778r.this.mo6090a(event) || super.dispatchKeyEvent(event);
        }

        public boolean dispatchKeyShortcutEvent(KeyEvent event) {
            return super.dispatchKeyShortcutEvent(event) || C0778r.this.mo6088a(event.getKeyCode(), event);
        }

        public boolean onCreatePanelMenu(int featureId, Menu menu) {
            if (featureId != 0 || (menu instanceof C0873l)) {
                return super.onCreatePanelMenu(featureId, menu);
            }
            return false;
        }

        public void onContentChanged() {
        }

        public boolean onPreparePanel(int featureId, View view, Menu menu) {
            C0873l mb = menu instanceof C0873l ? (C0873l) menu : null;
            if (featureId == 0 && mb == null) {
                return false;
            }
            if (mb != null) {
                mb.mo6732c(true);
            }
            boolean handled = super.onPreparePanel(featureId, view, menu);
            if (mb != null) {
                mb.mo6732c(false);
            }
            return handled;
        }

        public boolean onMenuOpened(int featureId, Menu menu) {
            super.onMenuOpened(featureId, menu);
            C0778r.this.mo6089a(featureId, menu);
            return true;
        }

        public void onPanelClosed(int featureId, Menu menu) {
            super.onPanelClosed(featureId, menu);
            C0778r.this.mo6093b(featureId, menu);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public abstract Callback mo6250a(Callback callback);

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public abstract boolean mo6088a(int i, KeyEvent keyEvent);

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public abstract boolean mo6089a(int i, Menu menu);

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public abstract boolean mo6090a(KeyEvent keyEvent);

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public abstract void mo6093b(int i, Menu menu);

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public abstract void mo6097b(CharSequence charSequence);

    /* access modifiers changed from: 0000 */
    /* renamed from: p */
    public abstract void mo6112p();

    static {
        if (f2345d && !f2344c) {
            Thread.setDefaultUncaughtExceptionHandler(new C0777q(Thread.getDefaultUncaughtExceptionHandler()));
        }
    }

    C0778r(Context context, Window window, C0020o callback) {
        this.f2347f = context;
        this.f2348g = window;
        this.f2351j = callback;
        Callback callback2 = this.f2349h;
        if (!(callback2 instanceof C0780b)) {
            this.f2350i = mo6250a(callback2);
            this.f2348g.setCallback(this.f2350i);
            C1112sb a = C1112sb.m5455a(context, (AttributeSet) null, f2346e);
            Drawable winBg = a.mo8652c(0);
            if (winBg != null) {
                this.f2348g.setBackgroundDrawable(winBg);
            }
            a.mo8647a();
            return;
        }
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    /* renamed from: e */
    public C0760a mo6247e() {
        mo6112p();
        return this.f2352k;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: r */
    public final C0760a mo6255r() {
        return this.f2352k;
    }

    /* renamed from: d */
    public MenuInflater mo6246d() {
        if (this.f2353l == null) {
            mo6112p();
            C0760a aVar = this.f2352k;
            this.f2353l = new C1307g(aVar != null ? aVar.mo6160h() : this.f2347f);
        }
        return this.f2353l;
    }

    /* renamed from: c */
    public final C0764b mo6244c() {
        return new C0779a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: m */
    public final Context mo6251m() {
        Context context = null;
        C0760a ab = mo6247e();
        if (ab != null) {
            context = ab.mo6160h();
        }
        if (context == null) {
            return this.f2347f;
        }
        return context;
    }

    /* renamed from: k */
    public void mo6248k() {
        this.f2360s = true;
    }

    /* renamed from: i */
    public void mo6107i() {
        this.f2361t = true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: q */
    public final boolean mo6254q() {
        return this.f2361t;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: o */
    public final Callback mo6253o() {
        return this.f2348g.getCallback();
    }

    /* renamed from: a */
    public final void mo6242a(CharSequence title) {
        this.f2359r = title;
        mo6097b(title);
    }

    /* renamed from: c */
    public void mo6245c(Bundle outState) {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: n */
    public final CharSequence mo6252n() {
        Callback callback = this.f2349h;
        if (callback instanceof Activity) {
            return ((Activity) callback).getTitle();
        }
        return this.f2359r;
    }
}
