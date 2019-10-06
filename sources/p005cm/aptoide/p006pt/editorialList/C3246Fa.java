package p005cm.aptoide.p006pt.editorialList;

import p005cm.aptoide.p006pt.home.EditorialHomeEvent;
import p005cm.aptoide.p006pt.reactions.network.ReactionsResponse;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.editorialList.Fa */
/* compiled from: lambda */
public final /* synthetic */ class C3246Fa implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ EditorialListPresenter f6621a;

    /* renamed from: b */
    private final /* synthetic */ EditorialHomeEvent f6622b;

    public /* synthetic */ C3246Fa(EditorialListPresenter editorialListPresenter, EditorialHomeEvent editorialHomeEvent) {
        this.f6621a = editorialListPresenter;
        this.f6622b = editorialHomeEvent;
    }

    public final Object call(Object obj) {
        return this.f6621a.mo14105a(this.f6622b, (ReactionsResponse) obj);
    }
}
