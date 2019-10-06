package com.crashlytics.android.p124a;

import android.content.Context;
import p024io.fabric.sdk.android.C13920f;
import p024io.fabric.sdk.android.C13929o;

/* renamed from: com.crashlytics.android.a.y */
/* compiled from: FirebaseAnalyticsApiAdapter */
class C6402y {

    /* renamed from: a */
    private final Context f11458a;

    /* renamed from: b */
    private final C6359A f11459b;

    /* renamed from: c */
    private C6401x f11460c;

    public C6402y(Context context) {
        this(context, new C6359A());
    }

    public C6402y(Context context, C6359A eventMapper) {
        this.f11458a = context;
        this.f11459b = eventMapper;
    }

    /* renamed from: a */
    public C6401x mo19426a() {
        if (this.f11460c == null) {
            this.f11460c = C6393q.m12381a(this.f11458a);
        }
        return this.f11460c;
    }

    /* renamed from: a */
    public void mo19427a(C6371M sessionEvent) {
        C6401x eventLogger = mo19426a();
        String str = "Answers";
        if (eventLogger == null) {
            C13920f.m44245e().mo43326c(str, "Firebase analytics logging was enabled, but not available...");
            return;
        }
        C6403z mappedEvent = this.f11459b.mo19340a(sessionEvent);
        if (mappedEvent == null) {
            C13929o e = C13920f.m44245e();
            StringBuilder sb = new StringBuilder();
            sb.append("Fabric event was not mappable to Firebase event: ");
            sb.append(sessionEvent);
            e.mo43326c(str, sb.toString());
            return;
        }
        eventLogger.mo19413a(mappedEvent.mo19428a(), mappedEvent.mo19429b());
        if ("levelEnd".equals(sessionEvent.f11364g)) {
            eventLogger.mo19413a("post_score", mappedEvent.mo19429b());
        }
    }
}
