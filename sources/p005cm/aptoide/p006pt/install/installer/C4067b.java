package p005cm.aptoide.p006pt.install.installer;

import android.content.Context;
import p005cm.aptoide.p006pt.packageinstaller.InstallStatus;
import p026rx.p027b.C0129b;

/* renamed from: cm.aptoide.pt.install.installer.b */
/* compiled from: lambda */
public final /* synthetic */ class C4067b implements C0129b {

    /* renamed from: a */
    private final /* synthetic */ DefaultInstaller f7574a;

    /* renamed from: b */
    private final /* synthetic */ Installation f7575b;

    /* renamed from: c */
    private final /* synthetic */ boolean f7576c;

    /* renamed from: d */
    private final /* synthetic */ Context f7577d;

    public /* synthetic */ C4067b(DefaultInstaller defaultInstaller, Installation installation, boolean z, Context context) {
        this.f7574a = defaultInstaller;
        this.f7575b = installation;
        this.f7576c = z;
        this.f7577d = context;
    }

    public final void call(Object obj) {
        this.f7574a.mo15106a(this.f7575b, this.f7576c, this.f7577d, (InstallStatus) obj);
    }
}
