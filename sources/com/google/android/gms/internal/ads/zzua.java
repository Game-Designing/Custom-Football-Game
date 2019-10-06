package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.ScrollView;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

@TargetApi(14)
@zzard
public final class zzua implements ActivityLifecycleCallbacks, OnAttachStateChangeListener, OnGlobalLayoutListener, OnScrollChangedListener {

    /* renamed from: a */
    private static final long f29437a = ((Long) zzyt.m31536e().mo29599a(zzacu.f23982Ob)).longValue();

    /* renamed from: b */
    private final Context f29438b;

    /* renamed from: c */
    private Application f29439c;

    /* renamed from: d */
    private final WindowManager f29440d;

    /* renamed from: e */
    private final PowerManager f29441e;

    /* renamed from: f */
    private final KeyguardManager f29442f;
    @VisibleForTesting

    /* renamed from: g */
    private BroadcastReceiver f29443g;

    /* renamed from: h */
    private WeakReference<ViewTreeObserver> f29444h;

    /* renamed from: i */
    private WeakReference<View> f29445i;

    /* renamed from: j */
    private C9592mt f29446j;

    /* renamed from: k */
    private zzazj f29447k = new zzazj(f29437a);

    /* renamed from: l */
    private boolean f29448l = false;

    /* renamed from: m */
    private int f29449m = -1;

    /* renamed from: n */
    private final HashSet<zzue> f29450n = new HashSet<>();

    /* renamed from: o */
    private final DisplayMetrics f29451o;

    /* renamed from: p */
    private final Rect f29452p;

    public zzua(Context context, View view) {
        this.f29438b = context.getApplicationContext();
        this.f29440d = (WindowManager) context.getSystemService("window");
        this.f29441e = (PowerManager) this.f29438b.getSystemService("power");
        this.f29442f = (KeyguardManager) context.getSystemService("keyguard");
        Context context2 = this.f29438b;
        if (context2 instanceof Application) {
            this.f29439c = (Application) context2;
            this.f29446j = new C9592mt((Application) context2, this);
        }
        this.f29451o = context.getResources().getDisplayMetrics();
        this.f29452p = new Rect();
        this.f29452p.right = this.f29440d.getDefaultDisplay().getWidth();
        this.f29452p.bottom = this.f29440d.getDefaultDisplay().getHeight();
        WeakReference<View> weakReference = this.f29445i;
        View view2 = weakReference != null ? (View) weakReference.get() : null;
        if (view2 != null) {
            view2.removeOnAttachStateChangeListener(this);
            m31230b(view2);
        }
        this.f29445i = new WeakReference<>(view);
        if (view != null) {
            if (zzk.zzli().mo30255a(view)) {
                m31226a(view);
            }
            view.addOnAttachStateChangeListener(this);
        }
    }

    /* renamed from: a */
    public final void mo32250a(zzue zzue) {
        this.f29450n.add(zzue);
        m31224a(3);
    }

    /* renamed from: b */
    public final void mo32251b(zzue zzue) {
        this.f29450n.remove(zzue);
    }

    /* renamed from: b */
    private final void m31229b() {
        zzk.zzlg();
        zzaxi.f24961a.post(new C9548kt(this));
    }

    public final void onViewAttachedToWindow(View view) {
        this.f29449m = -1;
        m31226a(view);
        m31224a(3);
    }

    public final void onViewDetachedFromWindow(View view) {
        this.f29449m = -1;
        m31224a(3);
        m31229b();
        m31230b(view);
    }

    /* renamed from: a */
    private final void m31225a(Activity activity, int i) {
        if (this.f29445i != null) {
            Window window = activity.getWindow();
            if (window != null) {
                View peekDecorView = window.peekDecorView();
                View view = (View) this.f29445i.get();
                if (!(view == null || peekDecorView == null || view.getRootView() != peekDecorView.getRootView())) {
                    this.f29449m = i;
                }
            }
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        m31225a(activity, 0);
        m31224a(3);
        m31229b();
    }

    public final void onActivityStarted(Activity activity) {
        m31225a(activity, 0);
        m31224a(3);
        m31229b();
    }

    public final void onActivityResumed(Activity activity) {
        m31225a(activity, 0);
        m31224a(3);
        m31229b();
    }

    public final void onActivityPaused(Activity activity) {
        m31225a(activity, 4);
        m31224a(3);
        m31229b();
    }

    public final void onActivityStopped(Activity activity) {
        m31224a(3);
        m31229b();
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        m31224a(3);
        m31229b();
    }

    public final void onActivityDestroyed(Activity activity) {
        m31224a(3);
        m31229b();
    }

    public final void onGlobalLayout() {
        m31224a(2);
        m31229b();
    }

    public final void onScrollChanged() {
        m31224a(1);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m31224a(int i) {
        boolean z;
        boolean z2;
        List list;
        int i2 = i;
        if (this.f29450n.size() != 0) {
            WeakReference<View> weakReference = this.f29445i;
            if (weakReference != null) {
                View view = (View) weakReference.get();
                boolean z3 = i2 == 1;
                boolean z4 = view == null;
                Rect rect = new Rect();
                Rect rect2 = new Rect();
                Rect rect3 = new Rect();
                Rect rect4 = new Rect();
                int[] iArr = new int[2];
                int[] iArr2 = new int[2];
                if (view != null) {
                    boolean globalVisibleRect = view.getGlobalVisibleRect(rect2);
                    boolean localVisibleRect = view.getLocalVisibleRect(rect3);
                    view.getHitRect(rect4);
                    try {
                        view.getLocationOnScreen(iArr);
                        view.getLocationInWindow(iArr2);
                    } catch (Exception e) {
                        zzbad.m26356b("Failure getting view location.", e);
                    }
                    rect.left = iArr[0];
                    rect.top = iArr[1];
                    rect.right = rect.left + view.getWidth();
                    rect.bottom = rect.top + view.getHeight();
                    z2 = globalVisibleRect;
                    z = localVisibleRect;
                } else {
                    z2 = false;
                    z = false;
                }
                if (!((Boolean) zzyt.m31536e().mo29599a(zzacu.f24000Rb)).booleanValue() || view == null) {
                    list = Collections.emptyList();
                } else {
                    list = m31231c(view);
                }
                int windowVisibility = view != null ? view.getWindowVisibility() : 8;
                int i3 = this.f29449m;
                if (i3 != -1) {
                    windowVisibility = i3;
                }
                boolean z5 = !z4 && zzk.zzlg().mo30236a(view, this.f29441e, this.f29442f) && z2 && z && windowVisibility == 0;
                if (z3 && !this.f29447k.mo30301a() && z5 == this.f29448l) {
                    return;
                }
                if (z5 || this.f29448l || i2 != 1) {
                    zzud zzud = new zzud(zzk.zzln().mo27934a(), this.f29441e.isScreenOn(), view != null && zzk.zzli().mo30255a(view), view != null ? view.getWindowVisibility() : 8, m31223a(this.f29452p), m31223a(rect), m31223a(rect2), z2, m31223a(rect3), z, m31223a(rect4), this.f29451o.density, z5, list);
                    Iterator it = this.f29450n.iterator();
                    while (it.hasNext()) {
                        ((zzue) it.next()).mo28694a(zzud);
                    }
                    this.f29448l = z5;
                }
            }
        }
    }

    /* renamed from: a */
    private final Rect m31223a(Rect rect) {
        return new Rect(m31228b(rect.left), m31228b(rect.top), m31228b(rect.right), m31228b(rect.bottom));
    }

    /* renamed from: b */
    private final int m31228b(int i) {
        return (int) (((float) i) / this.f29451o.density);
    }

    /* renamed from: c */
    private final List<Rect> m31231c(View view) {
        boolean z;
        try {
            ArrayList arrayList = new ArrayList();
            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                View view2 = (View) parent;
                Rect rect = new Rect();
                if (VERSION.SDK_INT >= 16) {
                    z = view2.isScrollContainer();
                } else {
                    if (!(view2 instanceof ScrollView)) {
                        if (!(view2 instanceof ListView)) {
                            z = false;
                        }
                    }
                    z = true;
                }
                if (z && view2.getGlobalVisibleRect(rect)) {
                    arrayList.add(m31223a(rect));
                }
            }
            return arrayList;
        } catch (Exception e) {
            zzk.zzlk().mo30168a((Throwable) e, "PositionWatcher.getParentScrollViewRects");
            return Collections.emptyList();
        }
    }

    /* renamed from: a */
    private final void m31226a(View view) {
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            this.f29444h = new WeakReference<>(viewTreeObserver);
            viewTreeObserver.addOnScrollChangedListener(this);
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        if (this.f29443g == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            this.f29443g = new C9570lt(this);
            zzk.zzmb().mo30306a(this.f29438b, this.f29443g, intentFilter);
        }
        Application application = this.f29439c;
        if (application != null) {
            try {
                application.registerActivityLifecycleCallbacks(this.f29446j);
            } catch (Exception e) {
                zzbad.m26356b("Error registering activity lifecycle callbacks.", e);
            }
        }
    }

    /* renamed from: b */
    private final void m31230b(View view) {
        try {
            if (this.f29444h != null) {
                ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.f29444h.get();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnScrollChangedListener(this);
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                this.f29444h = null;
            }
        } catch (Exception e) {
            zzbad.m26356b("Error while unregistering listeners from the last ViewTreeObserver.", e);
        }
        try {
            ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
            if (viewTreeObserver2.isAlive()) {
                viewTreeObserver2.removeOnScrollChangedListener(this);
                viewTreeObserver2.removeGlobalOnLayoutListener(this);
            }
        } catch (Exception e2) {
            zzbad.m26356b("Error while unregistering listeners from the ViewTreeObserver.", e2);
        }
        if (this.f29443g != null) {
            try {
                zzk.zzmb().mo30305a(this.f29438b, this.f29443g);
            } catch (IllegalStateException e3) {
                zzbad.m26356b("Failed trying to unregister the receiver", e3);
            } catch (Exception e4) {
                zzk.zzlk().mo30168a((Throwable) e4, "ActiveViewUnit.stopScreenStatusMonitoring");
            }
            this.f29443g = null;
        }
        Application application = this.f29439c;
        if (application != null) {
            try {
                application.unregisterActivityLifecycleCallbacks(this.f29446j);
            } catch (Exception e5) {
                zzbad.m26356b("Error registering activity lifecycle callbacks.", e5);
            }
        }
    }

    /* renamed from: a */
    public final void mo32249a(long j) {
        this.f29447k.mo30300a(j);
    }

    /* renamed from: a */
    public final void mo32248a() {
        this.f29447k.mo30300a(f29437a);
    }
}
