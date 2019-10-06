package p005cm.aptoide.p006pt.app;

import p005cm.aptoide.p006pt.app.DownloadModel.Action;
import p005cm.aptoide.p006pt.database.realm.Download;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.app.g */
/* compiled from: lambda */
public final /* synthetic */ class C1732g implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ AppViewManager f4702a;

    /* renamed from: b */
    private final /* synthetic */ Action f4703b;

    /* renamed from: c */
    private final /* synthetic */ long f4704c;

    public /* synthetic */ C1732g(AppViewManager appViewManager, Action action, long j) {
        this.f4702a = appViewManager;
        this.f4703b = action;
        this.f4704c = j;
    }

    public final Object call(Object obj) {
        return this.f4702a.mo10163a(this.f4703b, this.f4704c, (Download) obj);
    }
}
