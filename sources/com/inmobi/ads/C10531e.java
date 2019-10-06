package com.inmobi.ads;

import android.os.SystemClock;
import com.inmobi.commons.core.network.C10672a;
import com.inmobi.commons.core.network.C10672a.C10674a;
import com.inmobi.commons.core.network.C10677d;
import com.inmobi.p207a.C10299n;

/* renamed from: com.inmobi.ads.e */
/* compiled from: AdNetworkClient */
final class C10531e implements C10674a {

    /* renamed from: a */
    private static final String f32109a = C10531e.class.getSimpleName();

    /* renamed from: b */
    private C10537f f32110b;

    /* renamed from: c */
    private C10532a f32111c;

    /* renamed from: d */
    private long f32112d = 0;

    /* renamed from: com.inmobi.ads.e$a */
    /* compiled from: AdNetworkClient */
    public interface C10532a {
        /* renamed from: a */
        void mo34172a(C10538g gVar);

        /* renamed from: b */
        void mo34173b(C10538g gVar);
    }

    public C10531e(C10537f fVar, C10532a aVar) {
        this.f32110b = fVar;
        this.f32111c = aVar;
    }

    /* renamed from: a */
    public final void mo34260a() {
        this.f32112d = SystemClock.elapsedRealtime();
        new C10672a(this.f32110b, this).mo34498a();
    }

    /* renamed from: a */
    public final void mo34261a(C10677d dVar) {
        C10538g gVar = new C10538g(this.f32110b, dVar);
        try {
            C10299n.m33566a().mo33663a(this.f32110b.mo34509g());
            C10299n.m33566a().mo33664b(dVar.mo34513c());
            C10299n.m33566a().mo33665c(SystemClock.elapsedRealtime() - this.f32112d);
            this.f32111c.mo34172a(gVar);
        } catch (Exception e) {
            new StringBuilder("Handling ad fetch success encountered an unexpected error: ").append(e.getMessage());
        }
    }

    /* renamed from: b */
    public final void mo34262b(C10677d dVar) {
        C10538g gVar = new C10538g(this.f32110b, dVar);
        new StringBuilder("Ad fetch failed:").append(gVar.f32129a.f32591b.f32553b);
        try {
            C10299n.m33566a().mo33663a(this.f32110b.mo34509g());
            C10299n.m33566a().mo33664b(dVar.mo34513c());
            this.f32111c.mo34173b(gVar);
        } catch (Exception e) {
            new StringBuilder("Handling ad fetch failed encountered an unexpected error: ").append(e.getMessage());
        }
    }
}
