package com.mopub.common;

import android.app.Activity;
import com.mopub.common.privacy.PersonalInfoManager;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;

public class MoPubLifecycleManager implements LifecycleListener {

    /* renamed from: a */
    private static MoPubLifecycleManager f34347a;

    /* renamed from: b */
    private final Set<LifecycleListener> f34348b = new HashSet();

    /* renamed from: c */
    private final WeakReference<Activity> f34349c;

    private MoPubLifecycleManager(Activity mainActivity) {
        this.f34349c = new WeakReference<>(mainActivity);
    }

    public static synchronized MoPubLifecycleManager getInstance(Activity mainActivity) {
        MoPubLifecycleManager moPubLifecycleManager;
        synchronized (MoPubLifecycleManager.class) {
            if (f34347a == null) {
                f34347a = new MoPubLifecycleManager(mainActivity);
            }
            moPubLifecycleManager = f34347a;
        }
        return moPubLifecycleManager;
    }

    public void addLifecycleListener(LifecycleListener listener) {
        if (listener != null && this.f34348b.add(listener)) {
            Activity activity = (Activity) this.f34349c.get();
            if (activity != null) {
                listener.onCreate(activity);
                listener.onStart(activity);
            }
        }
    }

    public void onCreate(Activity activity) {
        for (LifecycleListener lifecycleListener : this.f34348b) {
            lifecycleListener.onCreate(activity);
        }
    }

    public void onStart(Activity activity) {
        for (LifecycleListener lifecycleListener : this.f34348b) {
            lifecycleListener.onStart(activity);
        }
    }

    public void onPause(Activity activity) {
        for (LifecycleListener lifecycleListener : this.f34348b) {
            lifecycleListener.onPause(activity);
        }
    }

    public void onResume(Activity activity) {
        PersonalInfoManager personalInfoManager = MoPub.getPersonalInformationManager();
        if (personalInfoManager != null) {
            personalInfoManager.requestSync(false);
        }
        for (LifecycleListener lifecycleListener : this.f34348b) {
            lifecycleListener.onResume(activity);
        }
    }

    public void onRestart(Activity activity) {
        for (LifecycleListener lifecycleListener : this.f34348b) {
            lifecycleListener.onRestart(activity);
        }
    }

    public void onStop(Activity activity) {
        for (LifecycleListener lifecycleListener : this.f34348b) {
            lifecycleListener.onStop(activity);
        }
    }

    public void onDestroy(Activity activity) {
        for (LifecycleListener lifecycleListener : this.f34348b) {
            lifecycleListener.onDestroy(activity);
        }
    }

    public void onBackPressed(Activity activity) {
        for (LifecycleListener lifecycleListener : this.f34348b) {
            lifecycleListener.onBackPressed(activity);
        }
    }
}
