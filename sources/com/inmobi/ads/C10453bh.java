package com.inmobi.ads;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import com.inmobi.commons.p217a.C10619a;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Picasso.Builder;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

@TargetApi(14)
/* renamed from: com.inmobi.ads.bh */
/* compiled from: PicassoWrapper */
public class C10453bh {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f31796a = C10453bh.class.getSimpleName();
    /* access modifiers changed from: private */
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: b */
    public static volatile Picasso f31797b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final Object f31798c = new Object();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static List<WeakReference<Context>> f31799d = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static ActivityLifecycleCallbacks f31800e = new ActivityLifecycleCallbacks() {
        public final void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public final void onActivityStarted(Activity activity) {
        }

        public final void onActivityResumed(Activity activity) {
        }

        public final void onActivityPaused(Activity activity) {
        }

        public final void onActivityStopped(Activity activity) {
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public final void onActivityDestroyed(Activity activity) {
            synchronized (C10453bh.f31798c) {
                if (C10453bh.f31797b != null && C10453bh.m34225c(activity)) {
                    activity.getApplication().unregisterActivityLifecycleCallbacks(C10453bh.f31800e);
                    C10453bh.f31799d.remove(activity);
                    if (C10453bh.f31799d.isEmpty()) {
                        C10453bh.f31796a;
                        StringBuilder sb = new StringBuilder("Picasso instance ");
                        sb.append(C10453bh.f31797b.toString());
                        sb.append(" shutdown");
                        C10453bh.f31797b.shutdown();
                        C10453bh.f31797b = null;
                    }
                }
            }
        }
    };

    /* renamed from: a */
    public static Picasso m34220a(Context context) {
        synchronized (f31798c) {
            if (!m34225c(context)) {
                f31799d.add(new WeakReference(context));
            }
            if (f31797b == null) {
                f31797b = new Builder(context).build();
                C10619a.m34833a(context, f31800e);
            }
        }
        return f31797b;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static boolean m34225c(Context context) {
        for (int i = 0; i < f31799d.size(); i++) {
            Context context2 = (Context) ((WeakReference) f31799d.get(i)).get();
            if (context2 != null && context2.equals(context)) {
                return true;
            }
        }
        return false;
    }
}
