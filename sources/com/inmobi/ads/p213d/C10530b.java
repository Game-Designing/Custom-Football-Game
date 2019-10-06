package com.inmobi.ads.p213d;

import com.inmobi.commons.core.p223f.C10671b;
import com.inmobi.commons.core.utilities.p225b.C10694e;
import com.inmobi.p216b.C10614a;

/* renamed from: com.inmobi.ads.d.b */
/* compiled from: TRCCollectorImpl */
public final class C10530b implements C10529a {

    /* renamed from: a */
    private final C10614a f32108a;

    public C10530b(C10614a aVar) {
        this.f32108a = aVar;
    }

    /* renamed from: a */
    public final void mo34259a(C10671b bVar) {
        C10614a aVar = this.f32108a;
        if (aVar.f32335c.mo34204b(bVar.f32550j).f31915h) {
            aVar.f32334a.execute(new Runnable(bVar) {

                /* renamed from: a */
                final /* synthetic */ C10671b f32339a;

                {
                    this.f32339a = r2;
                }

                public final void run() {
                    C10694e.m35113c();
                    if (C10694e.m35114d() == 0) {
                        C10614a.f32331f;
                        return;
                    }
                    C10614a.m34823a(C10614a.this, this.f32339a);
                    C10614a.m34824a(C10614a.this, this.f32339a.f32550j);
                }
            });
        }
    }
}
