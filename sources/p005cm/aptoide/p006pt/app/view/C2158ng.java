package p005cm.aptoide.p006pt.app.view;

import p005cm.aptoide.p006pt.app.AppViewViewModel;
import p005cm.aptoide.p006pt.search.model.SearchAdResult;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.app.view.ng */
/* compiled from: lambda */
public final /* synthetic */ class C2158ng implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ AppViewViewModel f5223a;

    public /* synthetic */ C2158ng(AppViewViewModel appViewViewModel) {
        this.f5223a = appViewViewModel;
    }

    public final Object call(Object obj) {
        AppViewViewModel appViewViewModel = this.f5223a;
        AppViewPresenter.m6569a(appViewViewModel, (SearchAdResult) obj);
        return appViewViewModel;
    }
}
