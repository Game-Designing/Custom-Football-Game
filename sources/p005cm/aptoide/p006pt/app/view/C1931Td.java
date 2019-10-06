package p005cm.aptoide.p006pt.app.view;

import p005cm.aptoide.p006pt.app.AppViewViewModel;
import p005cm.aptoide.p006pt.app.DownloadModel.Action;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.app.view.Td */
/* compiled from: lambda */
public final /* synthetic */ class C1931Td implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ AppViewPresenter f4949a;

    /* renamed from: b */
    private final /* synthetic */ Action f4950b;

    public /* synthetic */ C1931Td(AppViewPresenter appViewPresenter, Action action) {
        this.f4949a = appViewPresenter;
        this.f4950b = action;
    }

    public final Object call(Object obj) {
        return this.f4949a.mo10621b(this.f4950b, (AppViewViewModel) obj);
    }
}
