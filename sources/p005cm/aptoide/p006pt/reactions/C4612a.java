package p005cm.aptoide.p006pt.reactions;

import p005cm.aptoide.p006pt.reactions.network.LoadReactionModel;
import p026rx.p027b.C0129b;

/* renamed from: cm.aptoide.pt.reactions.a */
/* compiled from: lambda */
public final /* synthetic */ class C4612a implements C0129b {

    /* renamed from: a */
    private final /* synthetic */ ReactionsManager f8244a;

    /* renamed from: b */
    private final /* synthetic */ String f8245b;

    /* renamed from: c */
    private final /* synthetic */ String f8246c;

    public /* synthetic */ C4612a(ReactionsManager reactionsManager, String str, String str2) {
        this.f8244a = reactionsManager;
        this.f8245b = str;
        this.f8246c = str2;
    }

    public final void call(Object obj) {
        this.f8244a.mo15848a(this.f8245b, this.f8246c, (LoadReactionModel) obj);
    }
}
