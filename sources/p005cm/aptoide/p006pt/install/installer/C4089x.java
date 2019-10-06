package p005cm.aptoide.p006pt.install.installer;

import android.content.Context;
import java.util.concurrent.Callable;

/* renamed from: cm.aptoide.pt.install.installer.x */
/* compiled from: lambda */
public final /* synthetic */ class C4089x implements Callable {

    /* renamed from: a */
    private final /* synthetic */ DefaultInstaller f7623a;

    /* renamed from: b */
    private final /* synthetic */ boolean f7624b;

    /* renamed from: c */
    private final /* synthetic */ Installation f7625c;

    /* renamed from: d */
    private final /* synthetic */ Context f7626d;

    public /* synthetic */ C4089x(DefaultInstaller defaultInstaller, boolean z, Installation installation, Context context) {
        this.f7623a = defaultInstaller;
        this.f7624b = z;
        this.f7625c = installation;
        this.f7626d = context;
    }

    public final Object call() {
        return this.f7623a.mo15095a(this.f7624b, this.f7625c, this.f7626d);
    }
}
