package p005cm.aptoide.p006pt.home;

import p005cm.aptoide.p006pt.reactions.ReactionsHomeEvent;
import p005cm.aptoide.p006pt.reactions.network.ReactionsResponse;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.home.Zc */
/* compiled from: lambda */
public final /* synthetic */ class C3478Zc implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ HomePresenter f6856a;

    /* renamed from: b */
    private final /* synthetic */ ReactionsHomeEvent f6857b;

    public /* synthetic */ C3478Zc(HomePresenter homePresenter, ReactionsHomeEvent reactionsHomeEvent) {
        this.f6856a = homePresenter;
        this.f6857b = reactionsHomeEvent;
    }

    public final Object call(Object obj) {
        return this.f6856a.mo14466a(this.f6857b, (ReactionsResponse) obj);
    }
}
