package p005cm.aptoide.p006pt.app.view;

import p005cm.aptoide.p006pt.app.AppViewViewModel;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.app.view.Je */
/* compiled from: lambda */
public final /* synthetic */ class C1839Je implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ AppBoughClickEvent f4844a;

    public /* synthetic */ C1839Je(AppBoughClickEvent appBoughClickEvent) {
        this.f4844a = appBoughClickEvent;
    }

    public final Object call(Object obj) {
        AppBoughClickEvent appBoughClickEvent = this.f4844a;
        AppViewPresenter.m6595b(appBoughClickEvent, (AppViewViewModel) obj);
        return appBoughClickEvent;
    }
}
