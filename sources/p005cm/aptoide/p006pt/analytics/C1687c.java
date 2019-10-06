package p005cm.aptoide.p006pt.analytics;

import android.app.Application;
import java.util.concurrent.Callable;

/* renamed from: cm.aptoide.pt.analytics.c */
/* compiled from: lambda */
public final /* synthetic */ class C1687c implements Callable {

    /* renamed from: a */
    private final /* synthetic */ Application f4641a;

    public /* synthetic */ C1687c(Application application) {
        this.f4641a = application;
    }

    public final Object call() {
        return FirstLaunchAnalytics.m145a(this.f4641a);
    }
}
