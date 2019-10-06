package p005cm.aptoide.p006pt.editorial;

import p005cm.aptoide.p006pt.reactions.ReactionEvent;
import p005cm.aptoide.p006pt.reactions.network.ReactionsResponse;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.editorial.ib */
/* compiled from: lambda */
public final /* synthetic */ class C3173ib implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ EditorialPresenter f6538a;

    /* renamed from: b */
    private final /* synthetic */ ReactionEvent f6539b;

    public /* synthetic */ C3173ib(EditorialPresenter editorialPresenter, ReactionEvent reactionEvent) {
        this.f6538a = editorialPresenter;
        this.f6539b = reactionEvent;
    }

    public final Object call(Object obj) {
        return this.f6538a.mo13906a(this.f6539b, (ReactionsResponse) obj);
    }
}
