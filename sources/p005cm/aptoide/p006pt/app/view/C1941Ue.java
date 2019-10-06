package p005cm.aptoide.p006pt.app.view;

import java.util.List;
import p005cm.aptoide.p006pt.app.AppViewViewModel;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.app.view.Ue */
/* compiled from: lambda */
public final /* synthetic */ class C1941Ue implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ List f4962a;

    /* renamed from: b */
    private final /* synthetic */ AppViewViewModel f4963b;

    public /* synthetic */ C1941Ue(List list, AppViewViewModel appViewViewModel) {
        this.f4962a = list;
        this.f4963b = appViewViewModel;
    }

    public final Object call(Object obj) {
        List list = this.f4962a;
        AppViewPresenter.m6582a(list, this.f4963b, (List) obj);
        return list;
    }
}
