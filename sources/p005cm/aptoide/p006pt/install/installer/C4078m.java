package p005cm.aptoide.p006pt.install.installer;

import android.content.Context;
import android.net.Uri;
import java.util.concurrent.Callable;

/* renamed from: cm.aptoide.pt.install.installer.m */
/* compiled from: lambda */
public final /* synthetic */ class C4078m implements Callable {

    /* renamed from: a */
    private final /* synthetic */ DefaultInstaller f7600a;

    /* renamed from: b */
    private final /* synthetic */ Context f7601b;

    /* renamed from: c */
    private final /* synthetic */ String f7602c;

    /* renamed from: d */
    private final /* synthetic */ Uri f7603d;

    public /* synthetic */ C4078m(DefaultInstaller defaultInstaller, Context context, String str, Uri uri) {
        this.f7600a = defaultInstaller;
        this.f7601b = context;
        this.f7602c = str;
        this.f7603d = uri;
    }

    public final Object call() {
        return this.f7600a.mo15093a(this.f7601b, this.f7602c, this.f7603d);
    }
}
