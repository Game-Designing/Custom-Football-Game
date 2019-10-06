package android.support.p000v4.app;

import android.app.ActivityOptions;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;

/* renamed from: android.support.v4.app.d */
/* compiled from: ActivityOptionsCompat */
public class C0460d {

    /* renamed from: android.support.v4.app.d$a */
    /* compiled from: ActivityOptionsCompat */
    private static class C0461a extends C0460d {

        /* renamed from: a */
        protected final ActivityOptions f1571a;

        C0461a(ActivityOptions activityOptions) {
            this.f1571a = activityOptions;
        }

        /* renamed from: a */
        public Bundle mo5140a() {
            return this.f1571a.toBundle();
        }
    }

    /* renamed from: android.support.v4.app.d$b */
    /* compiled from: ActivityOptionsCompat */
    private static class C0462b extends C0461a {
        C0462b(ActivityOptions activityOptions) {
            super(activityOptions);
        }
    }

    /* renamed from: android.support.v4.app.d$c */
    /* compiled from: ActivityOptionsCompat */
    private static class C0463c extends C0462b {
        C0463c(ActivityOptions activityOptions) {
            super(activityOptions);
        }
    }

    /* renamed from: a */
    public static C0460d m2360a(Context context, int enterResId, int exitResId) {
        if (VERSION.SDK_INT >= 16) {
            return m2359a(ActivityOptions.makeCustomAnimation(context, enterResId, exitResId));
        }
        return new C0460d();
    }

    /* renamed from: a */
    private static C0460d m2359a(ActivityOptions options) {
        int i = VERSION.SDK_INT;
        if (i >= 24) {
            return new C0463c(options);
        }
        if (i >= 23) {
            return new C0462b(options);
        }
        return new C0461a(options);
    }

    protected C0460d() {
    }

    /* renamed from: a */
    public Bundle mo5140a() {
        return null;
    }
}
