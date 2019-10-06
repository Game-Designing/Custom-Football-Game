package p005cm.aptoide.p006pt.app.view;

import p005cm.aptoide.p006pt.app.AppViewViewModel;
import p005cm.aptoide.p006pt.app.DownloadModel.Action;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.app.view.zc */
/* compiled from: lambda */
public final /* synthetic */ class C2269zc implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ AppViewPresenter f5343a;

    /* renamed from: b */
    private final /* synthetic */ Action f5344b;

    public /* synthetic */ C2269zc(AppViewPresenter appViewPresenter, Action action) {
        this.f5343a = appViewPresenter;
        this.f5344b = action;
    }

    public final Object call(Object obj) {
        return this.f5343a.mo10655d(this.f5344b, (AppViewViewModel) obj);
    }
}
