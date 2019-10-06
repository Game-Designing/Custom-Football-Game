package p005cm.aptoide.p006pt.app;

import p005cm.aptoide.p006pt.database.realm.Download;
import p005cm.aptoide.p006pt.promotions.WalletApp;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.app.z */
/* compiled from: lambda */
public final /* synthetic */ class C2278z implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ AppViewManager f5353a;

    /* renamed from: b */
    private final /* synthetic */ WalletApp f5354b;

    public /* synthetic */ C2278z(AppViewManager appViewManager, WalletApp walletApp) {
        this.f5353a = appViewManager;
        this.f5354b = walletApp;
    }

    public final Object call(Object obj) {
        return this.f5353a.mo10165a(this.f5354b, (Download) obj);
    }
}
