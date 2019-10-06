package p019d.p143b.p144a.p147c;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

/* renamed from: d.b.a.c.ob */
class C7192ob implements ActivityLifecycleCallbacks {

    /* renamed from: a */
    final /* synthetic */ C7188nb f13656a;

    C7192ob(C7188nb nbVar) {
        this.f13656a = nbVar;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        this.f13656a.m15352j();
    }

    public void onActivityDestroyed(Activity activity) {
        this.f13656a.m15352j();
    }

    public void onActivityPaused(Activity activity) {
        this.f13656a.m15345e();
    }

    public void onActivityResumed(Activity activity) {
        this.f13656a.m15351i();
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.f13656a.m15347f();
    }

    public void onActivityStarted(Activity activity) {
        this.f13656a.m15350h();
    }

    public void onActivityStopped(Activity activity) {
        this.f13656a.m15349g();
    }
}
