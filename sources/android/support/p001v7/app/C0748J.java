package android.support.p001v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.p000v4.view.C0646w;
import android.support.p001v7.app.C0760a.C0762b;
import android.support.p001v7.view.menu.C0873l;
import android.support.p001v7.view.menu.C0873l.C0874a;
import android.support.p001v7.view.menu.C0890v.C0891a;
import android.support.p001v7.widget.C1021U;
import android.support.p001v7.widget.C1140zb;
import android.support.p001v7.widget.Toolbar;
import android.support.p001v7.widget.Toolbar.C1020c;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window.Callback;
import java.util.ArrayList;
import p002b.p003c.p062h.p071g.C1312j;

/* renamed from: android.support.v7.app.J */
/* compiled from: ToolbarActionBar */
class C0748J extends C0760a {

    /* renamed from: a */
    C1021U f2245a;

    /* renamed from: b */
    boolean f2246b;

    /* renamed from: c */
    Callback f2247c;

    /* renamed from: d */
    private boolean f2248d;

    /* renamed from: e */
    private boolean f2249e;

    /* renamed from: f */
    private ArrayList<C0762b> f2250f = new ArrayList<>();

    /* renamed from: g */
    private final Runnable f2251g = new C0746H(this);

    /* renamed from: h */
    private final C1020c f2252h = new C0747I(this);

    /* renamed from: android.support.v7.app.J$a */
    /* compiled from: ToolbarActionBar */
    private final class C0749a implements C0891a {

        /* renamed from: a */
        private boolean f2253a;

        C0749a() {
        }

        /* renamed from: a */
        public boolean mo6118a(C0873l subMenu) {
            Callback callback = C0748J.this.f2247c;
            if (callback == null) {
                return false;
            }
            callback.onMenuOpened(108, subMenu);
            return true;
        }

        /* renamed from: a */
        public void mo6117a(C0873l menu, boolean allMenusAreClosing) {
            if (!this.f2253a) {
                this.f2253a = true;
                C0748J.this.f2245a.mo8340l();
                Callback callback = C0748J.this.f2247c;
                if (callback != null) {
                    callback.onPanelClosed(108, menu);
                }
                this.f2253a = false;
            }
        }
    }

    /* renamed from: android.support.v7.app.J$b */
    /* compiled from: ToolbarActionBar */
    private final class C0750b implements C0874a {
        C0750b() {
        }

        /* renamed from: a */
        public boolean mo4699a(C0873l menu, MenuItem item) {
            return false;
        }

        /* renamed from: a */
        public void mo4698a(C0873l menu) {
            C0748J j = C0748J.this;
            if (j.f2247c == null) {
                return;
            }
            if (j.f2245a.mo8330d()) {
                C0748J.this.f2247c.onPanelClosed(108, menu);
            } else if (C0748J.this.f2247c.onPreparePanel(0, null, menu)) {
                C0748J.this.f2247c.onMenuOpened(108, menu);
            }
        }
    }

    /* renamed from: android.support.v7.app.J$c */
    /* compiled from: ToolbarActionBar */
    private class C0751c extends C1312j {
        public C0751c(Callback wrapped) {
            super(wrapped);
        }

        public boolean onPreparePanel(int featureId, View view, Menu menu) {
            boolean result = super.onPreparePanel(featureId, view, menu);
            if (result) {
                C0748J j = C0748J.this;
                if (!j.f2246b) {
                    j.f2245a.mo8331e();
                    C0748J.this.f2246b = true;
                }
            }
            return result;
        }

        public View onCreatePanelView(int featureId) {
            if (featureId == 0) {
                return new View(C0748J.this.f2245a.getContext());
            }
            return super.onCreatePanelView(featureId);
        }
    }

    C0748J(Toolbar toolbar, CharSequence title, Callback windowCallback) {
        this.f2245a = new C1140zb(toolbar, false);
        this.f2247c = new C0751c(windowCallback);
        this.f2245a.setWindowCallback(this.f2247c);
        toolbar.setOnMenuItemClickListener(this.f2252h);
        this.f2245a.setWindowTitle(title);
    }

    /* renamed from: l */
    public Callback mo6164l() {
        return this.f2247c;
    }

    /* renamed from: f */
    public void mo6156f(boolean enabled) {
    }

    /* renamed from: h */
    public Context mo6160h() {
        return this.f2245a.getContext();
    }

    /* renamed from: c */
    public void mo6152c(boolean enabled) {
    }

    /* renamed from: g */
    public void mo6159g(boolean enabled) {
    }

    /* renamed from: a */
    public void mo6145a(Configuration config) {
        super.mo6145a(config);
    }

    /* renamed from: a */
    public void mo6147a(CharSequence title) {
        this.f2245a.setTitle(title);
    }

    /* renamed from: b */
    public void mo6150b(CharSequence title) {
        this.f2245a.setWindowTitle(title);
    }

    /* renamed from: a */
    public void mo6144a(int options, int mask) {
        this.f2245a.mo8317a((options & mask) | ((mask ^ -1) & this.f2245a.mo8341m()));
    }

    /* renamed from: e */
    public void mo6154e(boolean showHome) {
        mo6144a(showHome ? 2 : 0, 2);
    }

    /* renamed from: d */
    public void mo6153d(boolean showHomeAsUp) {
        mo6144a(showHomeAsUp ? 4 : 0, 4);
    }

    /* renamed from: a */
    public void mo6146a(Drawable d) {
        this.f2245a.mo8318a(d);
    }

    /* renamed from: g */
    public int mo6158g() {
        return this.f2245a.mo8341m();
    }

    /* renamed from: k */
    public boolean mo6163k() {
        return this.f2245a.mo8328c();
    }

    /* renamed from: e */
    public boolean mo6155e() {
        return this.f2245a.mo8326b();
    }

    /* renamed from: i */
    public boolean mo6161i() {
        this.f2245a.mo8338j().removeCallbacks(this.f2251g);
        C0646w.m2958a((View) this.f2245a.mo8338j(), this.f2251g);
        return true;
    }

    /* renamed from: f */
    public boolean mo6157f() {
        if (!this.f2245a.mo8333g()) {
            return false;
        }
        this.f2245a.collapseActionView();
        return true;
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: 0000 */
    /* renamed from: m */
    public void mo6165m() {
        Menu menu = m3494n();
        C0873l mb = menu instanceof C0873l ? (C0873l) menu : null;
        if (mb != null) {
            mb.mo6756r();
        }
        try {
            menu.clear();
            if (!this.f2247c.onCreatePanelMenu(0, menu) || !this.f2247c.onPreparePanel(0, null, menu)) {
                menu.clear();
            }
            if (mb != null) {
                mb.mo6755q();
            }
        } catch (Throwable th) {
            if (mb != null) {
                mb.mo6755q();
            }
            throw th;
        }
    }

    /* renamed from: a */
    public boolean mo6149a(KeyEvent event) {
        if (event.getAction() == 1) {
            mo6163k();
        }
        return true;
    }

    /* renamed from: a */
    public boolean mo6148a(int keyCode, KeyEvent ev) {
        Menu menu = m3494n();
        if (menu == null) {
            return false;
        }
        boolean z = true;
        if (KeyCharacterMap.load(ev != null ? ev.getDeviceId() : -1).getKeyboardType() == 1) {
            z = false;
        }
        menu.setQwertyMode(z);
        return menu.performShortcut(keyCode, ev, 0);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public void mo6162j() {
        this.f2245a.mo8338j().removeCallbacks(this.f2251g);
    }

    /* renamed from: b */
    public void mo6151b(boolean isVisible) {
        if (isVisible != this.f2249e) {
            this.f2249e = isVisible;
            int count = this.f2250f.size();
            for (int i = 0; i < count; i++) {
                ((C0762b) this.f2250f.get(i)).onMenuVisibilityChanged(isVisible);
            }
        }
    }

    /* renamed from: n */
    private Menu m3494n() {
        if (!this.f2248d) {
            this.f2245a.mo8319a((C0891a) new C0749a(), (C0874a) new C0750b());
            this.f2248d = true;
        }
        return this.f2245a.mo8336h();
    }
}
