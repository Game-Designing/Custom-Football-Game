package p005cm.aptoide.p006pt.reactions.network;

import p026rx.p027b.C0132p;
import retrofit2.Response;

/* renamed from: cm.aptoide.pt.reactions.network.b */
/* compiled from: lambda */
public final /* synthetic */ class C4617b implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ ReactionsRemoteService f8256a;

    public /* synthetic */ C4617b(ReactionsRemoteService reactionsRemoteService) {
        this.f8256a = reactionsRemoteService;
    }

    public final Object call(Object obj) {
        return this.f8256a.mapResponse((Response) obj);
    }
}
