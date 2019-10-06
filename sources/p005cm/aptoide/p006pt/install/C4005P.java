package p005cm.aptoide.p006pt.install;

import p005cm.aptoide.p006pt.database.realm.Download;
import p005cm.aptoide.p006pt.install.Install.InstallationType;
import p005cm.aptoide.p006pt.install.installer.InstallationState;
import p026rx.p027b.C14542r;

/* renamed from: cm.aptoide.pt.install.P */
/* compiled from: lambda */
public final /* synthetic */ class C4005P implements C14542r {

    /* renamed from: a */
    private final /* synthetic */ InstallManager f7495a;

    /* renamed from: b */
    private final /* synthetic */ String f7496b;

    /* renamed from: c */
    private final /* synthetic */ String f7497c;

    /* renamed from: d */
    private final /* synthetic */ int f7498d;

    public /* synthetic */ C4005P(InstallManager installManager, String str, String str2, int i) {
        this.f7495a = installManager;
        this.f7496b = str;
        this.f7497c = str2;
        this.f7498d = i;
    }

    public final Object call(Object obj, Object obj2, Object obj3) {
        return this.f7495a.mo2067a(this.f7496b, this.f7497c, this.f7498d, (Download) obj, (InstallationState) obj2, (InstallationType) obj3);
    }
}
