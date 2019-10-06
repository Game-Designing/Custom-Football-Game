package com.google.android.gms.common.api.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

@KeepForSdk
public final class BackgroundDetector implements ActivityLifecycleCallbacks, ComponentCallbacks2 {

    /* renamed from: a */
    private static final BackgroundDetector f19612a = new BackgroundDetector();

    /* renamed from: b */
    private final AtomicBoolean f19613b = new AtomicBoolean();

    /* renamed from: c */
    private final AtomicBoolean f19614c = new AtomicBoolean();

    /* renamed from: d */
    private final ArrayList<BackgroundStateChangeListener> f19615d = new ArrayList<>();

    /* renamed from: e */
    private boolean f19616e = false;

    @KeepForSdk
    public interface BackgroundStateChangeListener {
        @KeepForSdk
        /* renamed from: a */
        void mo27444a(boolean z);
    }

    @KeepForSdk
    private BackgroundDetector() {
    }

    @KeepForSdk
    /* renamed from: a */
    public static BackgroundDetector m21196a() {
        return f19612a;
    }

    @KeepForSdk
    /* renamed from: a */
    public static void m21197a(Application application) {
        synchronized (f19612a) {
            if (!f19612a.f19616e) {
                application.registerActivityLifecycleCallbacks(f19612a);
                application.registerComponentCallbacks(f19612a);
                f19612a.f19616e = true;
            }
        }
    }

    @TargetApi(16)
    @KeepForSdk
    /* renamed from: a */
    public final boolean mo27432a(boolean z) {
        if (!this.f19614c.get()) {
            if (!PlatformVersion.m22109c()) {
                return z;
            }
            RunningAppProcessInfo runningAppProcessInfo = new RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (!this.f19614c.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                this.f19613b.set(true);
            }
        }
        return mo27433b();
    }

    @KeepForSdk
    /* renamed from: b */
    public final boolean mo27433b() {
        return this.f19613b.get();
    }

    @KeepForSdk
    /* renamed from: a */
    public final void mo27431a(BackgroundStateChangeListener backgroundStateChangeListener) {
        synchronized (f19612a) {
            this.f19615d.add(backgroundStateChangeListener);
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        boolean compareAndSet = this.f19613b.compareAndSet(true, false);
        this.f19614c.set(true);
        if (compareAndSet) {
            m21198b(false);
        }
    }

    public final void onActivityResumed(Activity activity) {
        boolean compareAndSet = this.f19613b.compareAndSet(true, false);
        this.f19614c.set(true);
        if (compareAndSet) {
            m21198b(false);
        }
    }

    public final void onTrimMemory(int i) {
        if (i == 20 && this.f19613b.compareAndSet(false, true)) {
            this.f19614c.set(true);
            m21198b(true);
        }
    }

    /* renamed from: b */
    private final void m21198b(boolean z) {
        synchronized (f19612a) {
            ArrayList<BackgroundStateChangeListener> arrayList = this.f19615d;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ((BackgroundStateChangeListener) obj).mo27444a(z);
            }
        }
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityDestroyed(Activity activity) {
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public final void onLowMemory() {
    }
}
