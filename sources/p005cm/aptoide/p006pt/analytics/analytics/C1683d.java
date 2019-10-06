package p005cm.aptoide.p006pt.analytics.analytics;

import p005cm.aptoide.analytics.implementation.data.Event;
import p026rx.C14502N;
import p026rx.p027b.C0129b;

/* renamed from: cm.aptoide.pt.analytics.analytics.d */
/* compiled from: lambda */
public final /* synthetic */ class C1683d implements C0129b {

    /* renamed from: a */
    private final /* synthetic */ RealmEventPersistence f4636a;

    /* renamed from: b */
    private final /* synthetic */ Event f4637b;

    public /* synthetic */ C1683d(RealmEventPersistence realmEventPersistence, Event event) {
        this.f4636a = realmEventPersistence;
        this.f4637b = event;
    }

    public final void call(Object obj) {
        this.f4636a.mo10068a(this.f4637b, (C14502N) obj);
    }
}
