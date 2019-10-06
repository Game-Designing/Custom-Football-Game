package android.support.p001v7.app;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ActionMode;
import android.view.View;
import android.view.Window;
import android.view.Window.Callback;
import p002b.p003c.p062h.p071g.C1300b;
import p002b.p003c.p062h.p071g.C1300b.C1301a;
import p002b.p003c.p062h.p071g.C1305f.C1306a;

/* renamed from: android.support.v7.app.t */
/* compiled from: AppCompatDelegateImplV14 */
class C0783t extends C0737D {

    /* renamed from: U */
    private int f2365U = -100;

    /* renamed from: V */
    private boolean f2366V;

    /* renamed from: W */
    private boolean f2367W = true;

    /* renamed from: X */
    private C0785b f2368X;

    /* renamed from: android.support.v7.app.t$a */
    /* compiled from: AppCompatDelegateImplV14 */
    class C0784a extends C0780b {
        C0784a(Callback callback) {
            super(callback);
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (C0783t.this.mo6264w()) {
                return mo6265a(callback);
            }
            return super.onWindowStartingActionMode(callback);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public final ActionMode mo6265a(ActionMode.Callback callback) {
            C1306a callbackWrapper = new C1306a(C0783t.this.f2347f, callback);
            C1300b supportActionMode = C0783t.this.mo6079a((C1301a) callbackWrapper);
            if (supportActionMode != null) {
                return callbackWrapper.mo9256b(supportActionMode);
            }
            return null;
        }
    }

    /* renamed from: android.support.v7.app.t$b */
    /* compiled from: AppCompatDelegateImplV14 */
    final class C0785b {

        /* renamed from: a */
        private C0753L f2370a;

        /* renamed from: b */
        private boolean f2371b;

        /* renamed from: c */
        private BroadcastReceiver f2372c;

        /* renamed from: d */
        private IntentFilter f2373d;

        C0785b(C0753L twilightManager) {
            this.f2370a = twilightManager;
            this.f2371b = twilightManager.mo6169a();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public final int mo6269c() {
            this.f2371b = this.f2370a.mo6169a();
            return this.f2371b ? 2 : 1;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public final void mo6268b() {
            boolean isNight = this.f2370a.mo6169a();
            if (isNight != this.f2371b) {
                this.f2371b = isNight;
                C0783t.this.mo6243a();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: d */
        public final void mo6270d() {
            mo6267a();
            if (this.f2372c == null) {
                this.f2372c = new C0786u(this);
            }
            if (this.f2373d == null) {
                this.f2373d = new IntentFilter();
                this.f2373d.addAction("android.intent.action.TIME_SET");
                this.f2373d.addAction("android.intent.action.TIMEZONE_CHANGED");
                this.f2373d.addAction("android.intent.action.TIME_TICK");
            }
            C0783t.this.f2347f.registerReceiver(this.f2372c, this.f2373d);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public final void mo6267a() {
            BroadcastReceiver broadcastReceiver = this.f2372c;
            if (broadcastReceiver != null) {
                C0783t.this.f2347f.unregisterReceiver(broadcastReceiver);
                this.f2372c = null;
            }
        }
    }

    C0783t(Context context, Window window, C0020o callback) {
        super(context, window, callback);
    }

    /* renamed from: a */
    public void mo6082a(Bundle savedInstanceState) {
        super.mo6082a(savedInstanceState);
        if (savedInstanceState != null && this.f2365U == -100) {
            this.f2365U = savedInstanceState.getInt("appcompat:local_night_mode", -100);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public View mo6078a(View parent, String name, Context context, AttributeSet attrs) {
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Callback mo6250a(Callback callback) {
        return new C0784a(callback);
    }

    /* renamed from: w */
    public boolean mo6264w() {
        return this.f2367W;
    }

    /* renamed from: a */
    public boolean mo6243a() {
        boolean applied = false;
        int nightMode = m3684B();
        int modeToApply = mo6263g(nightMode);
        if (modeToApply != -1) {
            applied = m3686i(modeToApply);
        }
        if (nightMode == 0) {
            m3683A();
            this.f2368X.mo6270d();
        }
        this.f2366V = true;
        return applied;
    }

    /* renamed from: k */
    public void mo6248k() {
        super.mo6248k();
        mo6243a();
    }

    /* renamed from: l */
    public void mo6109l() {
        super.mo6109l();
        C0785b bVar = this.f2368X;
        if (bVar != null) {
            bVar.mo6267a();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public int mo6263g(int mode) {
        if (mode == -100) {
            return -1;
        }
        if (mode != 0) {
            return mode;
        }
        m3683A();
        return this.f2368X.mo6269c();
    }

    /* renamed from: B */
    private int m3684B() {
        int i = this.f2365U;
        return i != -100 ? i : C0776p.m3637b();
    }

    /* renamed from: c */
    public void mo6245c(Bundle outState) {
        super.mo6245c(outState);
        int i = this.f2365U;
        if (i != -100) {
            outState.putInt("appcompat:local_night_mode", i);
        }
    }

    /* renamed from: i */
    public void mo6107i() {
        super.mo6107i();
        C0785b bVar = this.f2368X;
        if (bVar != null) {
            bVar.mo6267a();
        }
    }

    /* renamed from: i */
    private boolean m3686i(int mode) {
        Resources res = this.f2347f.getResources();
        Configuration conf = res.getConfiguration();
        int currentNightMode = conf.uiMode & 48;
        int newNightMode = mode == 2 ? 32 : 16;
        if (currentNightMode == newNightMode) {
            return false;
        }
        if (m3685C()) {
            ((Activity) this.f2347f).recreate();
        } else {
            Configuration config = new Configuration(conf);
            DisplayMetrics metrics = res.getDisplayMetrics();
            config.uiMode = (config.uiMode & -49) | newNightMode;
            res.updateConfiguration(config, metrics);
            if (VERSION.SDK_INT < 26) {
                C0745G.m3489a(res);
            }
        }
        return true;
    }

    /* renamed from: A */
    private void m3683A() {
        if (this.f2368X == null) {
            this.f2368X = new C0785b(C0753L.m3524a(this.f2347f));
        }
    }

    /* renamed from: C */
    private boolean m3685C() {
        boolean z = false;
        if (this.f2366V) {
            Context context = this.f2347f;
            if (context instanceof Activity) {
                try {
                    if ((context.getPackageManager().getActivityInfo(new ComponentName(this.f2347f, this.f2347f.getClass()), 0).configChanges & 512) == 0) {
                        z = true;
                    }
                    return z;
                } catch (NameNotFoundException e) {
                    Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e);
                    return true;
                }
            }
        }
        return false;
    }
}
