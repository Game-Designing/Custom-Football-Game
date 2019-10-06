package p005cm.aptoide.p006pt.app;

import p005cm.aptoide.p006pt.app.DownloadModel.Action;
import p005cm.aptoide.p006pt.database.realm.Download;
import p026rx.p027b.C0129b;

/* renamed from: cm.aptoide.pt.app.S */
/* compiled from: lambda */
public final /* synthetic */ class C1712S implements C0129b {

    /* renamed from: a */
    private final /* synthetic */ AppViewManager f4674a;

    /* renamed from: b */
    private final /* synthetic */ Action f4675b;

    public /* synthetic */ C1712S(AppViewManager appViewManager, Action action) {
        this.f4674a = appViewManager;
        this.f4675b = action;
    }

    public final void call(Object obj) {
        this.f4674a.mo10168a(this.f4675b, (Download) obj);
    }
}
