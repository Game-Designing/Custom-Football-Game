package p005cm.aptoide.p006pt.app.view;

import p005cm.aptoide.accountmanager.Account;
import p005cm.aptoide.p006pt.app.AppViewViewModel;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.app.view.Tb */
/* compiled from: lambda */
public final /* synthetic */ class C1929Tb implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ AppViewPresenter f4946a;

    /* renamed from: b */
    private final /* synthetic */ AppViewViewModel f4947b;

    public /* synthetic */ C1929Tb(AppViewPresenter appViewPresenter, AppViewViewModel appViewViewModel) {
        this.f4946a = appViewPresenter;
        this.f4947b = appViewViewModel;
    }

    public final Object call(Object obj) {
        return this.f4946a.mo10645c(this.f4947b, (Account) obj);
    }
}
