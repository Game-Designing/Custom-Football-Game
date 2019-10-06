package p005cm.aptoide.p006pt.app.view;

import p005cm.aptoide.p006pt.app.AppViewViewModel;
import p005cm.aptoide.p006pt.app.DownloadModel.Action;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.app.view.pd */
/* compiled from: lambda */
public final /* synthetic */ class C2174pd implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ AppViewPresenter f5240a;

    /* renamed from: b */
    private final /* synthetic */ AppViewViewModel f5241b;

    public /* synthetic */ C2174pd(AppViewPresenter appViewPresenter, AppViewViewModel appViewViewModel) {
        this.f5240a = appViewPresenter;
        this.f5241b = appViewViewModel;
    }

    public final Object call(Object obj) {
        return this.f5240a.mo10665e(this.f5241b, (Action) obj);
    }
}
