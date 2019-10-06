package p005cm.aptoide.p006pt.app.view;

import p005cm.aptoide.p006pt.app.AppViewViewModel;
import p005cm.aptoide.p006pt.app.DownloadModel.Action;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.app.view.Ic */
/* compiled from: lambda */
public final /* synthetic */ class C1828Ic implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ AppViewPresenter f4827a;

    /* renamed from: b */
    private final /* synthetic */ Action f4828b;

    /* renamed from: c */
    private final /* synthetic */ AppViewViewModel f4829c;

    public /* synthetic */ C1828Ic(AppViewPresenter appViewPresenter, Action action, AppViewViewModel appViewViewModel) {
        this.f4827a = appViewPresenter;
        this.f4828b = action;
        this.f4829c = appViewViewModel;
    }

    public final Object call(Object obj) {
        return this.f4827a.mo10589a(this.f4828b, this.f4829c, (Void) obj);
    }
}
