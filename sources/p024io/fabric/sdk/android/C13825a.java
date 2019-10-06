package p024io.fabric.sdk.android;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import p024io.fabric.sdk.android.C13914b.C13916b;

/* renamed from: io.fabric.sdk.android.a */
/* compiled from: ActivityLifecycleManager */
class C13825a implements ActivityLifecycleCallbacks {

    /* renamed from: a */
    final /* synthetic */ C13916b f41983a;

    /* renamed from: b */
    final /* synthetic */ C13915a f41984b;

    C13825a(C13915a this$0, C13916b bVar) {
        this.f41984b = this$0;
        this.f41983a = bVar;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        this.f41983a.mo19405a(activity, bundle);
    }

    public void onActivityStarted(Activity activity) {
        this.f41983a.mo19409d(activity);
    }

    public void onActivityResumed(Activity activity) {
        this.f41983a.mo19408c(activity);
    }

    public void onActivityPaused(Activity activity) {
        this.f41983a.mo19406b(activity);
    }

    public void onActivityStopped(Activity activity) {
        this.f41983a.mo19410e(activity);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.f41983a.mo19407b(activity, bundle);
    }

    public void onActivityDestroyed(Activity activity) {
        this.f41983a.mo19404a(activity);
    }
}
