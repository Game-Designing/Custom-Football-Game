package p005cm.aptoide.analytics.implementation.network;

import p005cm.aptoide.analytics.implementation.data.Event;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.analytics.implementation.network.b */
/* compiled from: lambda */
public final /* synthetic */ class C1357b implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ RetrofitAptoideBiService f4253a;

    /* renamed from: b */
    private final /* synthetic */ Event f4254b;

    public /* synthetic */ C1357b(RetrofitAptoideBiService retrofitAptoideBiService, Event event) {
        this.f4253a = retrofitAptoideBiService;
        this.f4254b = event;
    }

    public final Object call(Object obj) {
        return this.f4253a.mo9416a(this.f4254b, obj);
    }
}
