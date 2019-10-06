package p005cm.aptoide.p006pt.app.view;

import p005cm.aptoide.p006pt.app.AppViewViewModel;
import p005cm.aptoide.p006pt.app.DownloadModel.Action;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.app.view.Uf */
/* compiled from: lambda */
public final /* synthetic */ class C1942Uf implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ AppViewViewModel f4964a;

    public /* synthetic */ C1942Uf(AppViewViewModel appViewViewModel) {
        this.f4964a = appViewViewModel;
    }

    public final Object call(Object obj) {
        AppViewViewModel appViewViewModel = this.f4964a;
        AppViewPresenter.m6607c(appViewViewModel, (Action) obj);
        return appViewViewModel;
    }
}
