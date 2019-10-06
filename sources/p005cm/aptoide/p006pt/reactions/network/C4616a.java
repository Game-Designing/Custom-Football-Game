package p005cm.aptoide.p006pt.reactions.network;

import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.reactions.network.a */
/* compiled from: lambda */
public final /* synthetic */ class C4616a implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ ReactionsRemoteService f8255a;

    public /* synthetic */ C4616a(ReactionsRemoteService reactionsRemoteService) {
        this.f8255a = reactionsRemoteService;
    }

    public final Object call(Object obj) {
        return this.f8255a.mapToTopReactionsList((TopReactionsResponse) obj);
    }
}
