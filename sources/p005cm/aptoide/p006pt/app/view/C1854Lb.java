package p005cm.aptoide.p006pt.app.view;

import p005cm.aptoide.accountmanager.Account;
import p005cm.aptoide.p006pt.app.AppViewViewModel;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.app.view.Lb */
/* compiled from: lambda */
public final /* synthetic */ class C1854Lb implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ AppViewPresenter f4861a;

    /* renamed from: b */
    private final /* synthetic */ AppViewViewModel f4862b;

    public /* synthetic */ C1854Lb(AppViewPresenter appViewPresenter, AppViewViewModel appViewViewModel) {
        this.f4861a = appViewPresenter;
        this.f4862b = appViewViewModel;
    }

    public final Object call(Object obj) {
        return this.f4861a.mo10658d(this.f4862b, (Account) obj);
    }
}
