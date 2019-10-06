package p005cm.aptoide.p006pt.reactions;

import p005cm.aptoide.p006pt.reactions.network.ReactionsResponse;
import p026rx.p027b.C0129b;

/* renamed from: cm.aptoide.pt.reactions.c */
/* compiled from: lambda */
public final /* synthetic */ class C4614c implements C0129b {

    /* renamed from: a */
    private final /* synthetic */ ReactionsManager f8251a;

    /* renamed from: b */
    private final /* synthetic */ String f8252b;

    /* renamed from: c */
    private final /* synthetic */ String f8253c;

    public /* synthetic */ C4614c(ReactionsManager reactionsManager, String str, String str2) {
        this.f8251a = reactionsManager;
        this.f8252b = str;
        this.f8253c = str2;
    }

    public final void call(Object obj) {
        this.f8251a.mo15849a(this.f8252b, this.f8253c, (ReactionsResponse) obj);
    }
}
