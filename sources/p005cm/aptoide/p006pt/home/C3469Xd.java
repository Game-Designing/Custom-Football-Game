package p005cm.aptoide.p006pt.home;

import p005cm.aptoide.p006pt.reactions.network.ReactionsResponse;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.home.Xd */
/* compiled from: lambda */
public final /* synthetic */ class C3469Xd implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ HomePresenter f6845a;

    /* renamed from: b */
    private final /* synthetic */ EditorialHomeEvent f6846b;

    public /* synthetic */ C3469Xd(HomePresenter homePresenter, EditorialHomeEvent editorialHomeEvent) {
        this.f6845a = homePresenter;
        this.f6846b = editorialHomeEvent;
    }

    public final Object call(Object obj) {
        return this.f6845a.mo14465a(this.f6846b, (ReactionsResponse) obj);
    }
}
