package p005cm.aptoide.p006pt.install;

import p005cm.aptoide.p006pt.database.realm.Download;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.install.U */
/* compiled from: lambda */
public final /* synthetic */ class C4014U implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ InstallManager f7508a;

    /* renamed from: b */
    private final /* synthetic */ boolean f7509b;

    /* renamed from: c */
    private final /* synthetic */ Download f7510c;

    /* renamed from: d */
    private final /* synthetic */ boolean f7511d;

    public /* synthetic */ C4014U(InstallManager installManager, boolean z, Download download, boolean z2) {
        this.f7508a = installManager;
        this.f7509b = z;
        this.f7510c = download;
        this.f7511d = z2;
    }

    public final Object call(Object obj) {
        return this.f7508a.mo2073a(this.f7509b, this.f7510c, this.f7511d, (Install) obj);
    }
}
