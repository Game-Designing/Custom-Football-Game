package p005cm.aptoide.p006pt.app.view;

import p005cm.aptoide.p006pt.app.AppViewViewModel;
import p005cm.aptoide.p006pt.app.DownloadModel.Action;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.app.view.kf */
/* compiled from: lambda */
public final /* synthetic */ class C2127kf implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ AppViewViewModel f5190a;

    public /* synthetic */ C2127kf(AppViewViewModel appViewViewModel) {
        this.f5190a = appViewViewModel;
    }

    public final Object call(Object obj) {
        AppViewViewModel appViewViewModel = this.f5190a;
        AppViewPresenter.m6628f(appViewViewModel, (Action) obj);
        return appViewViewModel;
    }
}
