package p005cm.aptoide.p006pt.app.view;

import p005cm.aptoide.accountmanager.Account;
import p005cm.aptoide.p006pt.app.AppViewViewModel;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.app.view.Pd */
/* compiled from: lambda */
public final /* synthetic */ class C1896Pd implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ AppViewPresenter f4908a;

    /* renamed from: b */
    private final /* synthetic */ AppViewViewModel f4909b;

    public /* synthetic */ C1896Pd(AppViewPresenter appViewPresenter, AppViewViewModel appViewViewModel) {
        this.f4908a = appViewPresenter;
        this.f4909b = appViewViewModel;
    }

    public final Object call(Object obj) {
        return this.f4908a.mo10586a(this.f4909b, (Account) obj);
    }
}
