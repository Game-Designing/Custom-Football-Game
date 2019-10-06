package p005cm.aptoide.p006pt.analytics;

import android.content.SharedPreferences;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.analytics.a */
/* compiled from: lambda */
public final /* synthetic */ class C1678a implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ SharedPreferences f4631a;

    public /* synthetic */ C1678a(SharedPreferences sharedPreferences) {
        this.f4631a = sharedPreferences;
    }

    public final Object call(Object obj) {
        return FirstLaunchAnalytics.m144a(this.f4631a, obj);
    }
}
