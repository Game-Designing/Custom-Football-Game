package com.facebook.p127a;

import com.facebook.p127a.C6638q.C6639a;
import java.util.concurrent.TimeUnit;

/* renamed from: com.facebook.a.l */
/* compiled from: AppEventQueue */
class C6632l implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C6593b f12068a;

    /* renamed from: b */
    final /* synthetic */ C6625g f12069b;

    C6632l(C6593b bVar, C6625g gVar) {
        this.f12068a = bVar;
        this.f12069b = gVar;
    }

    public void run() {
        C6635o.f12077b.mo19826a(this.f12068a, this.f12069b);
        if (C6638q.m13219b() != C6639a.EXPLICIT_ONLY && C6635o.f12077b.mo19823a() > 100) {
            C6635o.m13204b(C6644v.EVENT_THRESHOLD);
        } else if (C6635o.f12079d == null) {
            C6635o.f12079d = C6635o.f12078c.schedule(C6635o.f12080e, 15, TimeUnit.SECONDS);
        }
    }
}
