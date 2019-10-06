package p005cm.aptoide.p006pt.editorialList;

import p005cm.aptoide.p006pt.reactions.ReactionsHomeEvent;
import p005cm.aptoide.p006pt.reactions.network.ReactionsResponse;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.editorialList.ea */
/* compiled from: lambda */
public final /* synthetic */ class C3285ea implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ EditorialListPresenter f6662a;

    /* renamed from: b */
    private final /* synthetic */ ReactionsHomeEvent f6663b;

    public /* synthetic */ C3285ea(EditorialListPresenter editorialListPresenter, ReactionsHomeEvent reactionsHomeEvent) {
        this.f6662a = editorialListPresenter;
        this.f6663b = reactionsHomeEvent;
    }

    public final Object call(Object obj) {
        return this.f6662a.mo14106a(this.f6663b, (ReactionsResponse) obj);
    }
}
