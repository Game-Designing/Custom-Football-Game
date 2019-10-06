package com.flurry.sdk;

import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentCallbacks2;
import android.content.Context;
import com.flurry.sdk.C7419Mb.C7420a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.flurry.sdk.Lb */
public final class C7412Lb {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f14527a = C7412Lb.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final List<String> f14528b = new ArrayList(Arrays.asList(new String[]{"FlurryFullscreenTakeoverActivity", "FlurryBrowserActivity"}));

    /* renamed from: c */
    private static C7412Lb f14529c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static boolean f14530d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static String f14531e;

    /* renamed from: f */
    private ActivityLifecycleCallbacks f14532f;

    /* renamed from: g */
    private ComponentCallbacks2 f14533g;

    /* renamed from: a */
    static /* synthetic */ void m16400a(boolean z) {
        f14530d = z;
        C7379Fb.m16302a(z);
        C7462Ub.m16528a().mo23908a((C7447Rb) new C7419Mb(f14530d ? C7420a.f14545a : C7420a.f14546b));
    }

    private C7412Lb() {
        Context context = C7379Fb.m16300a().f14432d;
        if (this.f14532f == null) {
            this.f14532f = new C7401Jb(this);
            ((Application) context).registerActivityLifecycleCallbacks(this.f14532f);
        }
        if (this.f14533g == null) {
            this.f14533g = new C7407Kb(this);
            context.registerComponentCallbacks(this.f14533g);
        }
    }

    /* renamed from: a */
    public static synchronized C7412Lb m16398a() {
        C7412Lb lb;
        synchronized (C7412Lb.class) {
            if (f14529c == null) {
                f14529c = new C7412Lb();
            }
            lb = f14529c;
        }
        return lb;
    }

    /* renamed from: b */
    public final boolean mo23853b() {
        return this.f14532f != null;
    }

    /* renamed from: c */
    public final synchronized String mo23854c() {
        return f14531e;
    }
}
