package p005cm.aptoide.p006pt.app;

import p005cm.aptoide.p006pt.app.DownloadModel.Action;
import p005cm.aptoide.p006pt.database.realm.Download;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.app.W */
/* compiled from: lambda */
public final /* synthetic */ class C1716W implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ AppViewManager f4680a;

    /* renamed from: b */
    private final /* synthetic */ Action f4681b;

    /* renamed from: c */
    private final /* synthetic */ long f4682c;

    /* renamed from: d */
    private final /* synthetic */ String f4683d;

    /* renamed from: e */
    private final /* synthetic */ String f4684e;

    public /* synthetic */ C1716W(AppViewManager appViewManager, Action action, long j, String str, String str2) {
        this.f4680a = appViewManager;
        this.f4681b = action;
        this.f4682c = j;
        this.f4683d = str;
        this.f4684e = str2;
    }

    public final Object call(Object obj) {
        return this.f4680a.mo10164a(this.f4681b, this.f4682c, this.f4683d, this.f4684e, (Download) obj);
    }
}
