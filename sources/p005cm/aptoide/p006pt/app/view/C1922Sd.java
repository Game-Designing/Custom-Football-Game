package p005cm.aptoide.p006pt.app.view;

import p005cm.aptoide.p006pt.app.AppViewViewModel;
import p005cm.aptoide.p006pt.app.DownloadModel.Action;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.app.view.Sd */
/* compiled from: lambda */
public final /* synthetic */ class C1922Sd implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ AppViewPresenter f4936a;

    /* renamed from: b */
    private final /* synthetic */ Action f4937b;

    /* renamed from: c */
    private final /* synthetic */ AppViewViewModel f4938c;

    public /* synthetic */ C1922Sd(AppViewPresenter appViewPresenter, Action action, AppViewViewModel appViewViewModel) {
        this.f4936a = appViewPresenter;
        this.f4937b = action;
        this.f4938c = appViewViewModel;
    }

    public final Object call(Object obj) {
        return this.f4936a.mo10596a(this.f4937b, this.f4938c, (Action) obj);
    }
}
