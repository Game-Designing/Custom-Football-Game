package p005cm.aptoide.p006pt.app.view;

import p005cm.aptoide.accountmanager.Account;
import p005cm.aptoide.p006pt.app.AppViewViewModel;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.app.view.pc */
/* compiled from: lambda */
public final /* synthetic */ class C2173pc implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ AppViewViewModel f5239a;

    public /* synthetic */ C2173pc(AppViewViewModel appViewViewModel) {
        this.f5239a = appViewViewModel;
    }

    public final Object call(Object obj) {
        AppViewViewModel appViewViewModel = this.f5239a;
        AppViewPresenter.m6593b(appViewViewModel, (Account) obj);
        return appViewViewModel;
    }
}
