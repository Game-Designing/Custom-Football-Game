package p005cm.aptoide.p006pt.reactions.network;

import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.reactions.network.c */
/* compiled from: lambda */
public final /* synthetic */ class C4618c implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ ReactionsRemoteService f8257a;

    public /* synthetic */ C4618c(ReactionsRemoteService reactionsRemoteService) {
        this.f8257a = reactionsRemoteService;
    }

    public final Object call(Object obj) {
        return this.f8257a.mapErrorResponse((Throwable) obj);
    }
}
