package p005cm.aptoide.p006pt.app.view;

import p005cm.aptoide.p006pt.app.AppViewViewModel;
import p005cm.aptoide.p006pt.promotions.Promotion;
import p026rx.p027b.C0129b;

/* renamed from: cm.aptoide.pt.app.view.Xa */
/* compiled from: lambda */
public final /* synthetic */ class C1964Xa implements C0129b {

    /* renamed from: a */
    private final /* synthetic */ AppViewPresenter f4992a;

    /* renamed from: b */
    private final /* synthetic */ Promotion f4993b;

    public /* synthetic */ C1964Xa(AppViewPresenter appViewPresenter, Promotion promotion) {
        this.f4992a = appViewPresenter;
        this.f4993b = promotion;
    }

    public final void call(Object obj) {
        this.f4992a.mo10612a(this.f4993b, (AppViewViewModel) obj);
    }
}
