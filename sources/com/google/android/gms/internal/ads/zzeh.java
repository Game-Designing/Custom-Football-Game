package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.Window;
import java.lang.ref.WeakReference;

public final class zzeh implements ActivityLifecycleCallbacks, OnAttachStateChangeListener, OnGlobalLayoutListener, OnScrollChangedListener {

    /* renamed from: a */
    private static final Handler f28359a = new Handler(Looper.getMainLooper());

    /* renamed from: b */
    private final Context f28360b;

    /* renamed from: c */
    private Application f28361c;

    /* renamed from: d */
    private final PowerManager f28362d;

    /* renamed from: e */
    private final KeyguardManager f28363e;

    /* renamed from: f */
    private final zzdy f28364f;

    /* renamed from: g */
    private BroadcastReceiver f28365g;

    /* renamed from: h */
    private WeakReference<ViewTreeObserver> f28366h;

    /* renamed from: i */
    private WeakReference<View> f28367i;

    /* renamed from: j */
    private C9433fo f28368j;

    /* renamed from: k */
    private byte f28369k = -1;

    /* renamed from: l */
    private int f28370l = -1;

    /* renamed from: m */
    private long f28371m = -3;

    public zzeh(zzdy zzdy, View view) {
        this.f28364f = zzdy;
        this.f28360b = zzdy.f28324b;
        this.f28362d = (PowerManager) this.f28360b.getSystemService("power");
        this.f28363e = (KeyguardManager) this.f28360b.getSystemService("keyguard");
        Context context = this.f28360b;
        if (context instanceof Application) {
            this.f28361c = (Application) context;
            this.f28368j = new C9433fo((Application) context, this);
        }
        mo31731a(view);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo31731a(View view) {
        WeakReference<View> weakReference = this.f28367i;
        View view2 = weakReference != null ? (View) weakReference.get() : null;
        if (view2 != null) {
            view2.removeOnAttachStateChangeListener(this);
            m30178c(view2);
        }
        this.f28367i = new WeakReference<>(view);
        if (view != null) {
            if ((view.getWindowToken() == null && view.getWindowVisibility() == 8) ? false : true) {
                m30176b(view);
            }
            view.addOnAttachStateChangeListener(this);
            this.f28371m = -2;
            return;
        }
        this.f28371m = -3;
    }

    /* renamed from: b */
    private final void m30175b() {
        f28359a.post(new C8798Cq(this));
    }

    public final void onViewAttachedToWindow(View view) {
        this.f28370l = -1;
        m30176b(view);
        m30177c();
    }

    public final void onViewDetachedFromWindow(View view) {
        this.f28370l = -1;
        m30177c();
        m30175b();
        m30178c(view);
    }

    /* renamed from: a */
    private final void m30173a(Activity activity, int i) {
        if (this.f28367i != null) {
            Window window = activity.getWindow();
            if (window != null) {
                View peekDecorView = window.peekDecorView();
                View view = (View) this.f28367i.get();
                if (!(view == null || peekDecorView == null || view.getRootView() != peekDecorView.getRootView())) {
                    this.f28370l = i;
                }
            }
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        m30173a(activity, 0);
        m30177c();
    }

    public final void onActivityStarted(Activity activity) {
        m30173a(activity, 0);
        m30177c();
    }

    public final void onActivityResumed(Activity activity) {
        m30173a(activity, 0);
        m30177c();
        m30175b();
    }

    public final void onActivityPaused(Activity activity) {
        m30173a(activity, 4);
        m30177c();
    }

    public final void onActivityStopped(Activity activity) {
        m30177c();
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        m30177c();
    }

    public final void onActivityDestroyed(Activity activity) {
        m30177c();
    }

    public final void onGlobalLayout() {
        m30177c();
    }

    public final void onScrollChanged() {
        m30177c();
    }

    /* renamed from: a */
    public final long mo31730a() {
        if (this.f28371m <= -2 && this.f28367i.get() == null) {
            this.f28371m = -3;
        }
        return this.f28371m;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x006a, code lost:
        if (r7 == false) goto L_0x006d;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m30177c() {
        /*
            r9 = this;
            java.lang.ref.WeakReference<android.view.View> r0 = r9.f28367i
            if (r0 != 0) goto L_0x0006
            return
        L_0x0006:
            java.lang.Object r0 = r0.get()
            android.view.View r0 = (android.view.View) r0
            r1 = -1
            r2 = -3
            if (r0 != 0) goto L_0x0016
            r9.f28371m = r2
            r9.f28369k = r1
            return
        L_0x0016:
            int r4 = r0.getVisibility()
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0020
            r4 = 1
            goto L_0x0021
        L_0x0020:
            r4 = 0
        L_0x0021:
            boolean r7 = r0.isShown()
            if (r7 != 0) goto L_0x002a
            r4 = r4 | 2
            byte r4 = (byte) r4
        L_0x002a:
            android.os.PowerManager r7 = r9.f28362d
            if (r7 == 0) goto L_0x0037
            boolean r7 = r7.isScreenOn()
            if (r7 != 0) goto L_0x0037
            r4 = r4 | 4
            byte r4 = (byte) r4
        L_0x0037:
            com.google.android.gms.internal.ads.zzdy r7 = r9.f28364f
            boolean r7 = r7.mo31723k()
            if (r7 != 0) goto L_0x006f
            android.app.KeyguardManager r7 = r9.f28363e
            if (r7 == 0) goto L_0x006d
            boolean r7 = r7.inKeyguardRestrictedInputMode()
            if (r7 == 0) goto L_0x006d
            android.app.Activity r7 = com.google.android.gms.internal.ads.zzef.m30165a(r0)
            if (r7 == 0) goto L_0x0069
            android.view.Window r7 = r7.getWindow()
            if (r7 != 0) goto L_0x0059
            r7 = 0
            goto L_0x005d
        L_0x0059:
            android.view.WindowManager$LayoutParams r7 = r7.getAttributes()
        L_0x005d:
            if (r7 == 0) goto L_0x0069
            int r7 = r7.flags
            r8 = 524288(0x80000, float:7.34684E-40)
            r7 = r7 & r8
            if (r7 == 0) goto L_0x0069
            r7 = 1
            goto L_0x006a
        L_0x0069:
            r7 = 0
        L_0x006a:
            if (r7 == 0) goto L_0x006d
            goto L_0x006f
        L_0x006d:
            r5 = 0
            goto L_0x0070
        L_0x006f:
        L_0x0070:
            if (r5 != 0) goto L_0x0075
            r4 = r4 | 8
            byte r4 = (byte) r4
        L_0x0075:
            android.graphics.Rect r5 = new android.graphics.Rect
            r5.<init>()
            boolean r5 = r0.getGlobalVisibleRect(r5)
            if (r5 != 0) goto L_0x0083
            r4 = r4 | 16
            byte r4 = (byte) r4
        L_0x0083:
            android.graphics.Rect r5 = new android.graphics.Rect
            r5.<init>()
            boolean r5 = r0.getLocalVisibleRect(r5)
            if (r5 != 0) goto L_0x0091
            r4 = r4 | 32
            byte r4 = (byte) r4
        L_0x0091:
            int r0 = r0.getWindowVisibility()
            int r5 = r9.f28370l
            if (r5 == r1) goto L_0x009b
            r0 = r5
            goto L_0x009c
        L_0x009b:
        L_0x009c:
            if (r0 == 0) goto L_0x00a1
            r0 = r4 | 64
            byte r4 = (byte) r0
        L_0x00a1:
            byte r0 = r9.f28369k
            if (r0 == r4) goto L_0x00b5
            r9.f28369k = r4
            byte r0 = r9.f28369k
            if (r0 != 0) goto L_0x00b0
            long r0 = android.os.SystemClock.elapsedRealtime()
            goto L_0x00b3
        L_0x00b0:
            long r0 = (long) r0
            long r0 = r2 - r0
        L_0x00b3:
            r9.f28371m = r0
        L_0x00b5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeh.m30177c():void");
    }

    /* renamed from: b */
    private final void m30176b(View view) {
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            this.f28366h = new WeakReference<>(viewTreeObserver);
            viewTreeObserver.addOnScrollChangedListener(this);
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        if (this.f28365g == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            this.f28365g = new C8819Dq(this);
            this.f28360b.registerReceiver(this.f28365g, intentFilter);
        }
        Application application = this.f28361c;
        if (application != null) {
            try {
                application.registerActivityLifecycleCallbacks(this.f28368j);
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: c */
    private final void m30178c(View view) {
        try {
            if (this.f28366h != null) {
                ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.f28366h.get();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnScrollChangedListener(this);
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                this.f28366h = null;
            }
        } catch (Exception e) {
        }
        try {
            ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
            if (viewTreeObserver2.isAlive()) {
                viewTreeObserver2.removeOnScrollChangedListener(this);
                viewTreeObserver2.removeGlobalOnLayoutListener(this);
            }
        } catch (Exception e2) {
        }
        BroadcastReceiver broadcastReceiver = this.f28365g;
        if (broadcastReceiver != null) {
            try {
                this.f28360b.unregisterReceiver(broadcastReceiver);
            } catch (Exception e3) {
            }
            this.f28365g = null;
        }
        Application application = this.f28361c;
        if (application != null) {
            try {
                application.unregisterActivityLifecycleCallbacks(this.f28368j);
            } catch (Exception e4) {
            }
        }
    }
}
