package p024io.fabric.sdk.android;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Set;

/* renamed from: io.fabric.sdk.android.b */
/* compiled from: ActivityLifecycleManager */
public class C13914b {

    /* renamed from: a */
    private final Application f42211a;

    /* renamed from: b */
    private C13915a f42212b;

    /* renamed from: io.fabric.sdk.android.b$a */
    /* compiled from: ActivityLifecycleManager */
    private static class C13915a {

        /* renamed from: a */
        private final Set<ActivityLifecycleCallbacks> f42213a = new HashSet();

        /* renamed from: b */
        private final Application f42214b;

        C13915a(Application application) {
            this.f42214b = application;
        }

        /* access modifiers changed from: private */
        @TargetApi(14)
        /* renamed from: a */
        public void m44206a() {
            for (ActivityLifecycleCallbacks callback : this.f42213a) {
                this.f42214b.unregisterActivityLifecycleCallbacks(callback);
            }
        }

        /* access modifiers changed from: private */
        @TargetApi(14)
        /* renamed from: a */
        public boolean m44209a(C13916b callbacks) {
            if (this.f42214b == null) {
                return false;
            }
            ActivityLifecycleCallbacks callbackWrapper = new C13825a(this, callbacks);
            this.f42214b.registerActivityLifecycleCallbacks(callbackWrapper);
            this.f42213a.add(callbackWrapper);
            return true;
        }
    }

    /* renamed from: io.fabric.sdk.android.b$b */
    /* compiled from: ActivityLifecycleManager */
    public static abstract class C13916b {
        /* renamed from: a */
        public abstract void mo19405a(Activity activity, Bundle bundle);

        /* renamed from: c */
        public abstract void mo19408c(Activity activity);

        /* renamed from: d */
        public abstract void mo19409d(Activity activity);

        /* renamed from: b */
        public void mo19406b(Activity activity) {
        }

        /* renamed from: e */
        public void mo19410e(Activity activity) {
        }

        /* renamed from: b */
        public void mo19407b(Activity activity, Bundle bundle) {
        }

        /* renamed from: a */
        public void mo19404a(Activity activity) {
        }
    }

    public C13914b(Context context) {
        this.f42211a = (Application) context.getApplicationContext();
        if (VERSION.SDK_INT >= 14) {
            this.f42212b = new C13915a(this.f42211a);
        }
    }

    /* renamed from: a */
    public boolean mo43318a(C13916b callbacks) {
        C13915a aVar = this.f42212b;
        return aVar != null && aVar.m44209a(callbacks);
    }

    /* renamed from: a */
    public void mo43317a() {
        C13915a aVar = this.f42212b;
        if (aVar != null) {
            aVar.m44206a();
        }
    }
}
